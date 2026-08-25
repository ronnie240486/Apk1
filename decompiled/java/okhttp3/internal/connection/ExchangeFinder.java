package okhttp3.internal.connection;

import com.lzy.okgo.model.Progress;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import p103j9.AbstractC2796i;

public final class ExchangeFinder {
    private final Address address;
    private final RealCall call;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address, RealCall realCall, EventListener eventListener) {
        AbstractC2796i.m5785f(realConnectionPool, "connectionPool");
        AbstractC2796i.m5785f(address, "address");
        AbstractC2796i.m5785f(realCall, "call");
        AbstractC2796i.m5785f(eventListener, "eventListener");
        this.connectionPool = realConnectionPool;
        this.address = address;
        this.call = realCall;
        this.eventListener = eventListener;
    }

    private final RealConnection findConnection(int i6, int i10, int i11, int i12, boolean z7) throws IOException {
        List<Route> routes;
        RealConnection realConnection;
        Socket socketReleaseConnectionNoEvents$okhttp;
        if (this.call.isCanceled()) {
            throw new IOException("Canceled");
        }
        RealConnection connection = this.call.getConnection();
        if (connection != null) {
            synchronized (connection) {
                try {
                    socketReleaseConnectionNoEvents$okhttp = (connection.getNoNewExchanges() || !sameHostAndPort(connection.route().address().url())) ? this.call.releaseConnectionNoEvents$okhttp() : null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.call.getConnection() != null) {
                if (socketReleaseConnectionNoEvents$okhttp == null) {
                    return connection;
                }
                throw new IllegalStateException("Check failed.");
            }
            if (socketReleaseConnectionNoEvents$okhttp != null) {
                Util.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
            }
            this.eventListener.connectionReleased(this.call, connection);
        }
        this.refusedStreamCount = 0;
        this.connectionShutdownCount = 0;
        this.otherFailureCount = 0;
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
            RealConnection connection2 = this.call.getConnection();
            AbstractC2796i.m5782c(connection2);
            this.eventListener.connectionAcquired(this.call, connection2);
            return connection2;
        }
        Route next = this.nextRouteToTry;
        try {
            if (next == null) {
                RouteSelector.Selection selection = this.routeSelection;
                if (selection != null) {
                    AbstractC2796i.m5782c(selection);
                    if (selection.hasNext()) {
                        RouteSelector.Selection selection2 = this.routeSelection;
                        AbstractC2796i.m5782c(selection2);
                        next = selection2.next();
                    }
                    realConnection = new RealConnection(this.connectionPool, next);
                    this.call.setConnectionToCancel(realConnection);
                    realConnection.connect(i6, i10, i11, i12, z7, this.call, this.eventListener);
                    this.call.setConnectionToCancel(null);
                    this.call.getClient().getRouteDatabase().connected(realConnection.route());
                    if (!this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, true)) {
                        synchronized (realConnection) {
                            this.connectionPool.put(realConnection);
                            this.call.acquireConnectionNoEvents(realConnection);
                        }
                        this.eventListener.connectionAcquired(this.call, realConnection);
                        return realConnection;
                    }
                    RealConnection connection3 = this.call.getConnection();
                    AbstractC2796i.m5782c(connection3);
                    this.nextRouteToTry = next;
                    Util.closeQuietly(realConnection.socket());
                    this.eventListener.connectionAcquired(this.call, connection3);
                    return connection3;
                }
                RouteSelector routeSelector = this.routeSelector;
                if (routeSelector == null) {
                    routeSelector = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
                    this.routeSelector = routeSelector;
                }
                RouteSelector.Selection next2 = routeSelector.next();
                this.routeSelection = next2;
                routes = next2.getRoutes();
                if (this.call.isCanceled()) {
                    throw new IOException("Canceled");
                }
                if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, false)) {
                    RealConnection connection4 = this.call.getConnection();
                    AbstractC2796i.m5782c(connection4);
                    this.eventListener.connectionAcquired(this.call, connection4);
                    return connection4;
                }
                next = next2.next();
                realConnection = new RealConnection(this.connectionPool, next);
                this.call.setConnectionToCancel(realConnection);
                realConnection.connect(i6, i10, i11, i12, z7, this.call, this.eventListener);
                this.call.setConnectionToCancel(null);
                this.call.getClient().getRouteDatabase().connected(realConnection.route());
                if (!this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, true)) {
                    synchronized (realConnection) {
                        this.connectionPool.put(realConnection);
                        this.call.acquireConnectionNoEvents(realConnection);
                        this.eventListener.connectionAcquired(this.call, realConnection);
                        return realConnection;
                    }
                }
                RealConnection connection5 = this.call.getConnection();
                AbstractC2796i.m5782c(connection5);
                this.nextRouteToTry = next;
                Util.closeQuietly(realConnection.socket());
                this.eventListener.connectionAcquired(this.call, connection5);
                return connection5;
            }
            AbstractC2796i.m5782c(next);
            this.nextRouteToTry = null;
            realConnection.connect(i6, i10, i11, i12, z7, this.call, this.eventListener);
            this.call.setConnectionToCancel(null);
            this.call.getClient().getRouteDatabase().connected(realConnection.route());
            if (!this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, true)) {
                synchronized (realConnection) {
                    this.connectionPool.put(realConnection);
                    this.call.acquireConnectionNoEvents(realConnection);
                    this.eventListener.connectionAcquired(this.call, realConnection);
                    return realConnection;
                }
            }
            RealConnection connection6 = this.call.getConnection();
            AbstractC2796i.m5782c(connection6);
            this.nextRouteToTry = next;
            Util.closeQuietly(realConnection.socket());
            this.eventListener.connectionAcquired(this.call, connection6);
            return connection6;
        } catch (Throwable th2) {
            this.call.setConnectionToCancel(null);
            throw th2;
        }
        routes = null;
        realConnection = new RealConnection(this.connectionPool, next);
        this.call.setConnectionToCancel(realConnection);
    }

    private final RealConnection findHealthyConnection(int i6, int i10, int i11, int i12, boolean z7, boolean z10) throws IOException {
        while (true) {
            RealConnection realConnectionFindConnection = findConnection(i6, i10, i11, i12, z7);
            if (realConnectionFindConnection.isHealthy(z10)) {
                return realConnectionFindConnection;
            }
            realConnectionFindConnection.noNewExchanges$okhttp();
            if (this.nextRouteToTry == null) {
                RouteSelector.Selection selection = this.routeSelection;
                if (selection != null ? selection.hasNext() : true) {
                    continue;
                } else {
                    RouteSelector routeSelector = this.routeSelector;
                    if (!(routeSelector != null ? routeSelector.hasNext() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    private final Route retryRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount$okhttp() != 0) {
                return null;
            }
            if (Util.canReuseConnectionFor(connection.route().address().url(), this.address.url())) {
                return connection.route();
            }
            return null;
        }
    }

    public final ExchangeCodec find(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) {
        AbstractC2796i.m5785f(okHttpClient, "client");
        AbstractC2796i.m5785f(realInterceptorChain, "chain");
        try {
            return findHealthyConnection(realInterceptorChain.getConnectTimeoutMillis$okhttp(), realInterceptorChain.getReadTimeoutMillis$okhttp(), realInterceptorChain.getWriteTimeoutMillis$okhttp(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), !AbstractC2796i.m5780a(realInterceptorChain.getRequest$okhttp().method(), "GET")).newCodec$okhttp(okHttpClient, realInterceptorChain);
        } catch (IOException e5) {
            trackFailure(e5);
            throw new RouteException(e5);
        } catch (RouteException e10) {
            trackFailure(e10.getLastConnectException());
            throw e10;
        }
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        RouteSelector routeSelector;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        Route routeRetryRoute = retryRoute();
        if (routeRetryRoute != null) {
            this.nextRouteToTry = routeRetryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if ((selection == null || !selection.hasNext()) && (routeSelector = this.routeSelector) != null) {
            return routeSelector.hasNext();
        }
        return true;
    }

    public final boolean sameHostAndPort(HttpUrl httpUrl) {
        AbstractC2796i.m5785f(httpUrl, Progress.URL);
        HttpUrl httpUrlUrl = this.address.url();
        return httpUrl.port() == httpUrlUrl.port() && AbstractC2796i.m5780a(httpUrl.host(), httpUrlUrl.host());
    }

    public final void trackFailure(IOException iOException) {
        AbstractC2796i.m5785f(iOException, "e");
        this.nextRouteToTry = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }
}

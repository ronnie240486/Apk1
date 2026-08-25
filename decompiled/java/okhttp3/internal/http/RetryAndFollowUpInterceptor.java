package okhttp3.internal.http;

import androidx.media3.exoplayer.rtsp.RtspHeaders;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p253x8.AbstractC4147j;
import p253x8.C4155r;

public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        private Companion() {
        }
    }

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        AbstractC2796i.m5785f(okHttpClient, "client");
        this.client = okHttpClient;
    }

    private final Request buildRedirectRequest(Response response, String str) {
        String strHeader$default;
        HttpUrl httpUrlResolve;
        if (!this.client.followRedirects() || (strHeader$default = Response.header$default(response, "Location", null, 2, null)) == null || (httpUrlResolve = response.request().url().resolve(strHeader$default)) == null) {
            return null;
        }
        if (!AbstractC2796i.m5780a(httpUrlResolve.scheme(), response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder builderNewBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(str)) {
            int iCode = response.code();
            HttpMethod httpMethod = HttpMethod.INSTANCE;
            boolean z7 = httpMethod.redirectsWithBody(str) || iCode == 308 || iCode == 307;
            if (!httpMethod.redirectsToGet(str) || iCode == 308 || iCode == 307) {
                builderNewBuilder.method(str, z7 ? response.request().body() : null);
            } else {
                builderNewBuilder.method("GET", null);
            }
            if (!z7) {
                builderNewBuilder.removeHeader("Transfer-Encoding");
                builderNewBuilder.removeHeader("Content-Length");
                builderNewBuilder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(response.request().url(), httpUrlResolve)) {
            builderNewBuilder.removeHeader(RtspHeaders.AUTHORIZATION);
        }
        return builderNewBuilder.url(httpUrlResolve).build();
    }

    private final Request followUpRequest(Response response, Exchange exchange) throws IOException {
        RealConnection connection$okhttp;
        Route route = (exchange == null || (connection$okhttp = exchange.getConnection$okhttp()) == null) ? null : connection$okhttp.route();
        int iCode = response.code();
        String strMethod = response.request().method();
        if (iCode != 307 && iCode != 308) {
            if (iCode == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (iCode == 421) {
                RequestBody requestBodyBody = response.request().body();
                if ((requestBodyBody != null && requestBodyBody.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                return response.request();
            }
            if (iCode == 503) {
                Response responsePriorResponse = response.priorResponse();
                if ((responsePriorResponse == null || responsePriorResponse.code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            }
            if (iCode == 407) {
                AbstractC2796i.m5782c(route);
                if (route.proxy().type() == Proxy.Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iCode == 408) {
                if (!this.client.retryOnConnectionFailure()) {
                    return null;
                }
                RequestBody requestBodyBody2 = response.request().body();
                if (requestBodyBody2 != null && requestBodyBody2.isOneShot()) {
                    return null;
                }
                Response responsePriorResponse2 = response.priorResponse();
                if ((responsePriorResponse2 == null || responsePriorResponse2.code() != 408) && retryAfter(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
            switch (iCode) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return buildRedirectRequest(response, strMethod);
    }

    private final boolean isRecoverable(IOException iOException, boolean z7) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z7;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request, boolean z7) {
        if (this.client.retryOnConnectionFailure()) {
            return !(z7 && requestIsOneShot(iOException, request)) && isRecoverable(iOException, z7) && realCall.retryAfterFailure();
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody requestBodyBody = request.body();
        return (requestBodyBody != null && requestBodyBody.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final int retryAfter(Response response, int i6) {
        String strHeader$default = Response.header$default(response, "Retry-After", null, 2, null);
        if (strHeader$default == null) {
            return i6;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        AbstractC2796i.m5784e(patternCompile, "compile(...)");
        if (!patternCompile.matcher(strHeader$default).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strHeader$default);
        AbstractC2796i.m5784e(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        AbstractC2796i.m5785f(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RealCall call$okhttp = realInterceptorChain.getCall$okhttp();
        List listM8187a0 = C4155r.f14074a;
        Response response = null;
        boolean z7 = true;
        int i6 = 0;
        while (true) {
            call$okhttp.enterNetworkInterceptorExchange(request$okhttp, z7);
            try {
                if (call$okhttp.isCanceled()) {
                    throw new IOException("Canceled");
                }
                try {
                    try {
                        Response responseProceed = realInterceptorChain.proceed(request$okhttp);
                        if (response != null) {
                            responseProceed = responseProceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                        }
                        response = responseProceed;
                        Exchange interceptorScopedExchange$okhttp = call$okhttp.getInterceptorScopedExchange$okhttp();
                        Request requestFollowUpRequest = followUpRequest(response, interceptorScopedExchange$okhttp);
                        if (requestFollowUpRequest == null) {
                            if (interceptorScopedExchange$okhttp != null && interceptorScopedExchange$okhttp.isDuplex$okhttp()) {
                                call$okhttp.timeoutEarlyExit();
                            }
                            call$okhttp.exitNetworkInterceptorExchange$okhttp(false);
                            return response;
                        }
                        RequestBody requestBodyBody = requestFollowUpRequest.body();
                        if (requestBodyBody != null && requestBodyBody.isOneShot()) {
                            call$okhttp.exitNetworkInterceptorExchange$okhttp(false);
                            return response;
                        }
                        ResponseBody responseBodyBody = response.body();
                        if (responseBodyBody != null) {
                            Util.closeQuietly(responseBodyBody);
                        }
                        i6++;
                        if (i6 > 20) {
                            throw new ProtocolException("Too many follow-up requests: " + i6);
                        }
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                        request$okhttp = requestFollowUpRequest;
                        z7 = true;
                    } catch (RouteException e5) {
                        if (!recover(e5.getLastConnectException(), call$okhttp, request$okhttp, false)) {
                            throw Util.withSuppressed(e5.getFirstConnectException(), listM8187a0);
                        }
                        listM8187a0 = AbstractC4147j.m8187a0(listM8187a0, e5.getFirstConnectException());
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                        z7 = false;
                    }
                } catch (IOException e10) {
                    if (!recover(e10, call$okhttp, request$okhttp, !(e10 instanceof ConnectionShutdownException))) {
                        throw Util.withSuppressed(e10, listM8187a0);
                    }
                    listM8187a0 = AbstractC4147j.m8187a0(listM8187a0, e10);
                    call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                    z7 = false;
                }
            } catch (Throwable th) {
                call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                throw th;
            }
        }
    }
}

package okhttp3.internal.connection;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import p000a.AbstractC0004e;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public final class RealConnectionPool {
    public static final Companion Companion = new Companion(null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            AbstractC2796i.m5785f(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }

        private Companion() {
        }
    }

    public RealConnectionPool(TaskRunner taskRunner, int i6, long j10, TimeUnit timeUnit) {
        AbstractC2796i.m5785f(taskRunner, "taskRunner");
        AbstractC2796i.m5785f(timeUnit, "timeUnit");
        this.maxIdleConnections = i6;
        this.keepAliveDurationNs = timeUnit.toNanos(j10);
        this.cleanupQueue = taskRunner.newQueue();
        final String strM26t = AbstractC0004e.m26t(new StringBuilder(), Util.okHttpName, " ConnectionPool");
        this.cleanupTask = new Task(strM26t) {
            @Override
            public long runOnce() {
                return this.this$0.cleanup(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (j10 <= 0) {
            throw new IllegalArgumentException(AbstractC0004e.m21o(j10, "keepAliveDuration <= 0: ").toString());
        }
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j10) {
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        int i6 = 0;
        while (i6 < calls.size()) {
            Reference<RealCall> reference = calls.get(i6);
            if (reference.get() != null) {
                i6++;
            } else {
                Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i6);
                realConnection.setNoNewExchanges(true);
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs$okhttp(j10 - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return calls.size();
    }

    public final boolean callAcquirePooledConnection(Address address, RealCall realCall, List<Route> list, boolean z7) {
        AbstractC2796i.m5785f(address, "address");
        AbstractC2796i.m5785f(realCall, "call");
        for (RealConnection realConnection : this.connections) {
            AbstractC2796i.m5784e(realConnection, "connection");
            synchronized (realConnection) {
                if (z7) {
                    try {
                        if (!realConnection.isMultiplexed$okhttp()) {
                            continue;
                        } else if (realConnection.isEligible$okhttp(address, list)) {
                            realCall.acquireConnectionNoEvents(realConnection);
                            return true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else if (realConnection.isEligible$okhttp(address, list)) {
                    realCall.acquireConnectionNoEvents(realConnection);
                    return true;
                }
            }
        }
        return false;
    }

    public final long cleanup(long j10) {
        int i6 = 0;
        long j11 = Long.MIN_VALUE;
        RealConnection realConnection = null;
        int i10 = 0;
        for (RealConnection realConnection2 : this.connections) {
            AbstractC2796i.m5784e(realConnection2, "connection");
            synchronized (realConnection2) {
                if (pruneAndGetAllocationCount(realConnection2, j10) > 0) {
                    i10++;
                } else {
                    i6++;
                    long idleAtNs$okhttp = j10 - realConnection2.getIdleAtNs$okhttp();
                    if (idleAtNs$okhttp > j11) {
                        realConnection = realConnection2;
                        j11 = idleAtNs$okhttp;
                    }
                }
            }
        }
        long j12 = this.keepAliveDurationNs;
        if (j11 < j12 && i6 <= this.maxIdleConnections) {
            if (i6 > 0) {
                return j12 - j11;
            }
            if (i10 > 0) {
                return j12;
            }
            return -1L;
        }
        AbstractC2796i.m5782c(realConnection);
        synchronized (realConnection) {
            if (!realConnection.getCalls().isEmpty()) {
                return 0L;
            }
            if (realConnection.getIdleAtNs$okhttp() + j11 != j10) {
                return 0L;
            }
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return 0L;
        }
    }

    public final boolean connectionBecameIdle(RealConnection realConnection) {
        AbstractC2796i.m5785f(realConnection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        if (!realConnection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return false;
        }
        realConnection.setNoNewExchanges(true);
        this.connections.remove(realConnection);
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
        return true;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it = this.connections.iterator();
        AbstractC2796i.m5784e(it, "connections.iterator()");
        while (it.hasNext()) {
            RealConnection next = it.next();
            AbstractC2796i.m5784e(next, "connection");
            synchronized (next) {
                if (next.getCalls().isEmpty()) {
                    it.remove();
                    next.setNoNewExchanges(true);
                    socket = next.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                Util.closeQuietly(socket);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final int idleConnectionCount() {
        boolean zIsEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i6 = 0;
        if (!(concurrentLinkedQueue instanceof Collection) || !concurrentLinkedQueue.isEmpty()) {
            for (RealConnection realConnection : concurrentLinkedQueue) {
                AbstractC2796i.m5784e(realConnection, "it");
                synchronized (realConnection) {
                    zIsEmpty = realConnection.getCalls().isEmpty();
                }
                if (zIsEmpty && (i6 = i6 + 1) < 0) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        return i6;
    }

    public final void put(RealConnection realConnection) {
        AbstractC2796i.m5785f(realConnection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            this.connections.add(realConnection);
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        } else {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
    }
}

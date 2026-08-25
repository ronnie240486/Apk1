package p213t9;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public final class RunnableC3867v extends AbstractC3831f0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    public static final RunnableC3867v f12965i;

    public static final long f12966j;

    static {
        Long l9;
        RunnableC3867v runnableC3867v = new RunnableC3867v();
        f12965i = runnableC3867v;
        runnableC3867v.m7673j(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l9 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l9 = 1000L;
        }
        f12966j = timeUnit.toNanos(l9.longValue());
    }

    @Override
    public final Thread mo7646i() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    @Override
    public final void mo7666l(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.mo7666l(runnable);
    }

    public final synchronized void m7703p() {
        int i6 = debugStatus;
        if (i6 == 2 || i6 == 3) {
            debugStatus = 3;
            AbstractC3831f0.f12911f.set(this, null);
            AbstractC3831f0.f12912g.set(this, null);
            notifyAll();
        }
    }

    @Override
    public final void run() {
        AbstractC3832f1.f12914a.set(this);
        try {
            synchronized (this) {
                int i6 = debugStatus;
                if (i6 == 2 || i6 == 3) {
                    _thread = null;
                    m7703p();
                    if (m7668n()) {
                        return;
                    }
                    mo7646i();
                    return;
                }
                debugStatus = 1;
                notifyAll();
                long j10 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jM7669o = m7669o();
                    if (jM7669o == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j10 == Long.MAX_VALUE) {
                            j10 = f12966j + jNanoTime;
                        }
                        long j11 = j10 - jNanoTime;
                        if (j11 <= 0) {
                            _thread = null;
                            m7703p();
                            if (m7668n()) {
                                return;
                            }
                            mo7646i();
                            return;
                        }
                        if (jM7669o > j11) {
                            jM7669o = j11;
                        }
                    } else {
                        j10 = Long.MAX_VALUE;
                    }
                    if (jM7669o > 0) {
                        int i10 = debugStatus;
                        if (i10 == 2 || i10 == 3) {
                            _thread = null;
                            m7703p();
                            if (m7668n()) {
                                return;
                            }
                            mo7646i();
                            return;
                        }
                        LockSupport.parkNanos(this, jM7669o);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            m7703p();
            if (!m7668n()) {
                mo7646i();
            }
            throw th;
        }
    }

    @Override
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}

package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;

public final class RunnableC1710v6 extends AtomicReference implements Runnable {

    public static final RunnableC1656p6 f5702c = new RunnableC1656p6();

    public static final RunnableC1656p6 f5703d = new RunnableC1656p6();

    public final Callable f5704a;

    public final RunnableFutureC1719w6 f5705b;

    public RunnableC1710v6(RunnableFutureC1719w6 runnableFutureC1719w6, Callable callable) {
        this.f5705b = runnableFutureC1719w6;
        callable.getClass();
        this.f5704a = callable;
    }

    public final void m4036a(Thread thread) {
        Runnable runnable = (Runnable) get();
        RunnableC1647o6 runnableC1647o6 = null;
        boolean z7 = false;
        int i6 = 0;
        while (true) {
            boolean z10 = runnable instanceof RunnableC1647o6;
            RunnableC1656p6 runnableC1656p6 = f5703d;
            if (!z10) {
                if (runnable != runnableC1656p6) {
                    break;
                }
            } else {
                runnableC1647o6 = (RunnableC1647o6) runnable;
            }
            i6++;
            if (i6 <= 1000) {
                Thread.yield();
            } else if (runnable == runnableC1656p6 || compareAndSet(runnable, runnableC1656p6)) {
                z7 = Thread.interrupted() || z7;
                LockSupport.park(runnableC1647o6);
            }
            runnable = (Runnable) get();
        }
        if (z7) {
            thread.interrupt();
        }
    }

    @Override
    public final void run() {
        Object objCall;
        Thread threadCurrentThread = Thread.currentThread();
        if (compareAndSet(null, threadCurrentThread)) {
            RunnableFutureC1719w6 runnableFutureC1719w6 = this.f5705b;
            boolean zIsDone = runnableFutureC1719w6.isDone();
            RunnableC1656p6 runnableC1656p6 = f5702c;
            if (zIsDone) {
                objCall = null;
            } else {
                try {
                    objCall = this.f5704a.call();
                } catch (Throwable th) {
                    try {
                        if (th instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(threadCurrentThread, runnableC1656p6)) {
                            m4036a(threadCurrentThread);
                        }
                        boolean zMo3708r = AbstractC1608k6.f5390j.mo3708r(runnableFutureC1719w6, null, new C1538d6(th));
                        if (zMo3708r) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (!compareAndSet(threadCurrentThread, runnableC1656p6)) {
                            m4036a(threadCurrentThread);
                        }
                        runnableFutureC1719w6.getClass();
                        if (AbstractC1608k6.f5390j.mo3708r(runnableFutureC1719w6, null, AbstractC1608k6.f5387g)) {
                            AbstractC1558f6.m3820z(runnableFutureC1719w6);
                        }
                    }
                }
            }
            if (!compareAndSet(threadCurrentThread, runnableC1656p6)) {
                m4036a(threadCurrentThread);
            }
            if (zIsDone) {
                return;
            }
            runnableFutureC1719w6.getClass();
            if (objCall == null) {
                objCall = AbstractC1608k6.f5387g;
            }
            if (AbstractC1608k6.f5390j.mo3708r(runnableFutureC1719w6, null, objCall)) {
                AbstractC1558f6.m3820z(runnableFutureC1719w6);
            }
        }
    }

    @Override
    public final String toString() {
        String strM24r;
        Runnable runnable = (Runnable) get();
        if (runnable == f5702c) {
            strM24r = "running=[DONE]";
        } else if (runnable instanceof RunnableC1647o6) {
            strM24r = "running=[INTERRUPTED]";
        } else {
            strM24r = runnable instanceof Thread ? AbstractC0004e.m24r("running=[RUNNING ON ", ((Thread) runnable).getName(), "]") : "running=[NOT STARTED YET]";
        }
        return AbstractC2460q.m5495i(strM24r, ", ", this.f5704a.toString());
    }
}

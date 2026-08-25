package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import p000a.AbstractC0004e;

public final class RunnableFutureC1719w6 extends AbstractC1558f6 implements RunnableFuture {

    public volatile RunnableC1710v6 f5717k;

    public RunnableFutureC1719w6(Callable callable) {
        super(12);
        this.f5717k = new RunnableC1710v6(this, callable);
    }

    @Override
    public final void run() {
        RunnableC1710v6 runnableC1710v6 = this.f5717k;
        if (runnableC1710v6 != null) {
            runnableC1710v6.run();
        }
        this.f5717k = null;
    }

    @Override
    public final String mo3821v() {
        RunnableC1710v6 runnableC1710v6 = this.f5717k;
        if (runnableC1710v6 != null) {
            return AbstractC0004e.m24r("task=[", runnableC1710v6.toString(), "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override
    public final void mo3822w() {
        RunnableC1710v6 runnableC1710v6;
        Object obj = this.f5391d;
        if ((obj instanceof C1518b6) && ((C1518b6) obj).f5221a && (runnableC1710v6 = this.f5717k) != null) {
            RunnableC1656p6 runnableC1656p6 = RunnableC1710v6.f5703d;
            RunnableC1656p6 runnableC1656p7 = RunnableC1710v6.f5702c;
            Runnable runnable = (Runnable) runnableC1710v6.get();
            if (runnable instanceof Thread) {
                RunnableC1647o6 runnableC1647o6 = new RunnableC1647o6(runnableC1710v6);
                runnableC1647o6.setExclusiveOwnerThread(Thread.currentThread());
                if (runnableC1710v6.compareAndSet(runnable, runnableC1647o6)) {
                    try {
                        Thread thread = (Thread) runnable;
                        thread.interrupt();
                        if (((Runnable) runnableC1710v6.getAndSet(runnableC1656p7)) == runnableC1656p6) {
                            LockSupport.unpark(thread);
                        }
                    } catch (Throwable th) {
                        if (((Runnable) runnableC1710v6.getAndSet(runnableC1656p7)) == runnableC1656p6) {
                            LockSupport.unpark((Thread) runnable);
                        }
                        throw th;
                    }
                }
            }
        }
        this.f5717k = null;
    }
}

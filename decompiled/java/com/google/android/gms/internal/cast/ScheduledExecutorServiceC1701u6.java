package com.google.android.gms.internal.cast;

import android.os.Build;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class ScheduledExecutorServiceC1701u6 extends C1674r6 implements ScheduledExecutorService {

    public final ScheduledExecutorService f5689b;

    public ScheduledExecutorServiceC1701u6(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.f5689b = scheduledExecutorService;
    }

    @Override
    public final void close() {
        if (Build.VERSION.SDK_INT <= 23 || this != ForkJoinPool.commonPool()) {
            ExecutorService executorService = this.f5587a;
            if (executorService.isTerminated()) {
                return;
            }
            shutdown();
            boolean zAwaitTermination = false;
            boolean z7 = false;
            while (!zAwaitTermination) {
                try {
                    zAwaitTermination = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z7) {
                        shutdownNow();
                    }
                    z7 = true;
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public final ScheduledFuture schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        RunnableFutureC1719w6 runnableFutureC1719w6 = new RunnableFutureC1719w6(Executors.callable(runnable, null));
        return new ScheduledFutureC1683s6(runnableFutureC1719w6, this.f5689b.schedule(runnableFutureC1719w6, j10, timeUnit));
    }

    @Override
    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        RunnableC1692t6 runnableC1692t6 = new RunnableC1692t6(runnable);
        return new ScheduledFutureC1683s6(runnableC1692t6, this.f5689b.scheduleAtFixedRate(runnableC1692t6, j10, j11, timeUnit));
    }

    @Override
    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        RunnableC1692t6 runnableC1692t6 = new RunnableC1692t6(runnable);
        return new ScheduledFutureC1683s6(runnableC1692t6, this.f5689b.scheduleWithFixedDelay(runnableC1692t6, j10, j11, timeUnit));
    }

    @Override
    public final ScheduledFuture schedule(Callable callable, long j10, TimeUnit timeUnit) {
        RunnableFutureC1719w6 runnableFutureC1719w6 = new RunnableFutureC1719w6(callable);
        return new ScheduledFutureC1683s6(runnableFutureC1719w6, this.f5689b.schedule(runnableFutureC1719w6, j10, timeUnit));
    }
}

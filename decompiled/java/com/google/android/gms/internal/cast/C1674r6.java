package com.google.android.gms.internal.cast;

import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

public class C1674r6 extends AbstractExecutorService implements AutoCloseable, InterfaceExecutorServiceC1665q6 {

    public final ExecutorService f5587a;

    public C1674r6(ExecutorService executorService) {
        executorService.getClass();
        this.f5587a = executorService;
    }

    @Override
    public final boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return this.f5587a.awaitTermination(j10, timeUnit);
    }

    @Override
    public void close() {
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
    public final void execute(Runnable runnable) {
        this.f5587a.execute(runnable);
    }

    @Override
    public final boolean isShutdown() {
        return this.f5587a.isShutdown();
    }

    @Override
    public final boolean isTerminated() {
        return this.f5587a.isTerminated();
    }

    @Override
    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return new RunnableFutureC1719w6(Executors.callable(runnable, obj));
    }

    @Override
    public final void shutdown() {
        this.f5587a.shutdown();
    }

    @Override
    public final List shutdownNow() {
        return this.f5587a.shutdownNow();
    }

    @Override
    public final Future submit(Runnable runnable) {
        return (ListenableFuture) super.submit(runnable);
    }

    public final String toString() {
        return super.toString() + "[" + String.valueOf(this.f5587a) + "]";
    }

    @Override
    public final RunnableFuture newTaskFor(Callable callable) {
        return new RunnableFutureC1719w6(callable);
    }

    @Override
    public final Future submit(Runnable runnable, Object obj) {
        return (ListenableFuture) super.submit(runnable, obj);
    }

    @Override
    public final Future submit(Callable callable) {
        return (ListenableFuture) super.submit(callable);
    }
}

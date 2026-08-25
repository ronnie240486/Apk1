package com.google.android.gms.internal.cast;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class ScheduledFutureC1683s6 extends AbstractC1503a1 implements ScheduledFuture, ListenableFuture, Future {

    public final AbstractC1558f6 f5673d;

    public final ScheduledFuture f5674e;

    public ScheduledFutureC1683s6(AbstractC1558f6 abstractC1558f6, ScheduledFuture scheduledFuture) {
        super(7);
        this.f5673d = abstractC1558f6;
        this.f5674e = scheduledFuture;
    }

    @Override
    public final void addListener(Runnable runnable, Executor executor) {
        this.f5673d.addListener(runnable, executor);
    }

    @Override
    public final boolean cancel(boolean z7) {
        boolean zCancel = this.f5673d.cancel(z7);
        if (zCancel) {
            this.f5674e.cancel(z7);
        }
        return zCancel;
    }

    @Override
    public final int compareTo(Delayed delayed) {
        return this.f5674e.compareTo(delayed);
    }

    @Override
    public final Object get() {
        return this.f5673d.get();
    }

    @Override
    public final long getDelay(TimeUnit timeUnit) {
        return this.f5674e.getDelay(timeUnit);
    }

    @Override
    public final boolean isCancelled() {
        return this.f5673d.f5391d instanceof C1518b6;
    }

    @Override
    public final boolean isDone() {
        return this.f5673d.isDone();
    }

    @Override
    public final Object get(long j10, TimeUnit timeUnit) {
        return this.f5673d.get(j10, timeUnit);
    }
}

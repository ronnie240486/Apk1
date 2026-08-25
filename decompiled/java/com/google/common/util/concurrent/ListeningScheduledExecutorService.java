package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
public interface ListeningScheduledExecutorService extends ScheduledExecutorService, ListeningExecutorService {
    @Override
    ListenableScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit);

    @Override
    <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit);

    @Override
    ScheduledFuture schedule(Runnable runnable, long j10, TimeUnit timeUnit);

    @Override
    ScheduledFuture schedule(Callable callable, long j10, TimeUnit timeUnit);

    @Override
    ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit);

    @Override
    ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit);

    @Override
    ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit);

    @Override
    ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit);
}

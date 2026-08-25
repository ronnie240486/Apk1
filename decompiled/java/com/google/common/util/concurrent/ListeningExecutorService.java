package com.google.common.util.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
public interface ListeningExecutorService extends ExecutorService {
    @Override
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException;

    @Override
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException;

    ListenableFuture<?> submit(Runnable runnable);

    <T> ListenableFuture<T> submit(Runnable runnable, @ParametricNullness T t5);

    <T> ListenableFuture<T> submit(Callable<T> callable);

    Future submit(Runnable runnable);

    Future submit(Runnable runnable, @ParametricNullness Object obj);

    Future submit(Callable callable);
}

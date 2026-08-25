package com.google.common.util.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p041d7.AbstractC2239l1;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingExecutorService extends AbstractC2239l1 implements ExecutorService {
    @Override
    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        return delegate().awaitTermination(j10, timeUnit);
    }

    @Override
    public abstract ExecutorService delegate();

    @Override
    public void execute(Runnable runnable) {
        delegate().execute(runnable);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return delegate().invokeAll(collection);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) delegate().invokeAny(collection);
    }

    @Override
    public boolean isShutdown() {
        return delegate().isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return delegate().isTerminated();
    }

    @Override
    public void shutdown() {
        delegate().shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return delegate().shutdownNow();
    }

    @Override
    public <T> Future<T> submit(Callable<T> callable) {
        return delegate().submit(callable);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException {
        return delegate().invokeAll(collection, j10, timeUnit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) delegate().invokeAny(collection, j10, timeUnit);
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        return delegate().submit(runnable);
    }

    @Override
    public <T> Future<T> submit(Runnable runnable, @ParametricNullness T t5) {
        return delegate().submit(runnable, t5);
    }
}

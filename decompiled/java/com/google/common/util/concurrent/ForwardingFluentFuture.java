package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ElementTypesAreNonnullByDefault
final class ForwardingFluentFuture<V> extends FluentFuture<V> {
    private final ListenableFuture<V> delegate;

    public ForwardingFluentFuture(ListenableFuture<V> listenableFuture) {
        listenableFuture.getClass();
        this.delegate = listenableFuture;
    }

    @Override
    public void addListener(Runnable runnable, Executor executor) {
        this.delegate.addListener(runnable, executor);
    }

    @Override
    public boolean cancel(boolean z7) {
        return this.delegate.cancel(z7);
    }

    @Override
    @ParametricNullness
    public V get() throws ExecutionException, InterruptedException {
        return this.delegate.get();
    }

    @Override
    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    @Override
    public boolean isDone() {
        return this.delegate.isDone();
    }

    @Override
    public String toString() {
        return this.delegate.toString();
    }

    @Override
    @ParametricNullness
    public V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.delegate.get(j10, timeUnit);
    }
}

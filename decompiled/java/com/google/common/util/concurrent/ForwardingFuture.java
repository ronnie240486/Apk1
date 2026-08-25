package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p041d7.AbstractC2239l1;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingFuture<V> extends AbstractC2239l1 implements Future<V> {

    public static abstract class SimpleForwardingFuture<V> extends ForwardingFuture<V> {
        private final Future<V> delegate;

        public SimpleForwardingFuture(Future<V> future) {
            future.getClass();
            this.delegate = future;
        }

        @Override
        public final Future<V> delegate() {
            return this.delegate;
        }
    }

    @Override
    public boolean cancel(boolean z7) {
        return delegate().cancel(z7);
    }

    @Override
    public abstract Future<? extends V> delegate();

    @Override
    @ParametricNullness
    public V get() throws ExecutionException, InterruptedException {
        return delegate().get();
    }

    @Override
    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    @Override
    public boolean isDone() {
        return delegate().isDone();
    }

    @Override
    @ParametricNullness
    public V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return delegate().get(j10, timeUnit);
    }
}

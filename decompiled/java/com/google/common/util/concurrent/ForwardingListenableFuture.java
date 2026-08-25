package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
    @Override
    public void addListener(Runnable runnable, Executor executor) {
        delegate().addListener(runnable, executor);
    }

    @Override
    public abstract ListenableFuture<? extends V> delegate();

    public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
        private final ListenableFuture<V> delegate;

        public SimpleForwardingListenableFuture(ListenableFuture<V> listenableFuture) {
            listenableFuture.getClass();
            this.delegate = listenableFuture;
        }

        @Override
        public final ListenableFuture<V> delegate() {
            return this.delegate;
        }
    }
}

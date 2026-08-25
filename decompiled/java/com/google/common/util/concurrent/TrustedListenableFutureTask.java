package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import p020b7.AbstractC1332b;

@ElementTypesAreNonnullByDefault
class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {
    private volatile InterruptibleTask<?> task;

    public final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;

        public TrustedFutureInterruptibleAsyncTask(AsyncCallable<V> asyncCallable) {
            asyncCallable.getClass();
            this.callable = asyncCallable;
        }

        @Override
        public void afterRanInterruptiblyFailure(Throwable th) {
            TrustedListenableFutureTask.this.setException(th);
        }

        @Override
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override
        public void afterRanInterruptiblySuccess(ListenableFuture<V> listenableFuture) {
            TrustedListenableFutureTask.this.setFuture(listenableFuture);
        }

        @Override
        public ListenableFuture<V> runInterruptibly() throws Exception {
            ListenableFuture<V> listenableFutureCall = this.callable.call();
            AbstractC1332b.m3218i(listenableFutureCall, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
            return listenableFutureCall;
        }
    }

    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        public TrustedFutureInterruptibleTask(Callable<V> callable) {
            callable.getClass();
            this.callable = callable;
        }

        @Override
        public void afterRanInterruptiblyFailure(Throwable th) {
            TrustedListenableFutureTask.this.setException(th);
        }

        @Override
        public void afterRanInterruptiblySuccess(@ParametricNullness V v10) {
            TrustedListenableFutureTask.this.set(v10);
        }

        @Override
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override
        @ParametricNullness
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public TrustedListenableFutureTask(Callable<V> callable) {
        this.task = new TrustedFutureInterruptibleTask(callable);
    }

    public static <V> TrustedListenableFutureTask<V> create(AsyncCallable<V> asyncCallable) {
        return new TrustedListenableFutureTask<>(asyncCallable);
    }

    @Override
    public void afterDone() {
        InterruptibleTask<?> interruptibleTask;
        super.afterDone();
        if (wasInterrupted() && (interruptibleTask = this.task) != null) {
            interruptibleTask.interruptTask();
        }
        this.task = null;
    }

    @Override
    public String pendingToString() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask == null) {
            return super.pendingToString();
        }
        return "task=[" + interruptibleTask + "]";
    }

    @Override
    public void run() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.task = null;
    }

    public static <V> TrustedListenableFutureTask<V> create(Callable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    public TrustedListenableFutureTask(AsyncCallable<V> asyncCallable) {
        this.task = new TrustedFutureInterruptibleAsyncTask(asyncCallable);
    }

    public static <V> TrustedListenableFutureTask<V> create(Runnable runnable, @ParametricNullness V v10) {
        return new TrustedListenableFutureTask<>(Executors.callable(runnable, v10));
    }
}

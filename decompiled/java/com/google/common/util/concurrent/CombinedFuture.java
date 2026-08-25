package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import p020b7.AbstractC1332b;
import p041d7.AbstractC2274q1;

@ElementTypesAreNonnullByDefault
final class CombinedFuture<V> extends AggregateFuture<Object, V> {
    private CombinedFuture<V>.CombinedFutureInterruptibleTask<?> task;

    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;

        public AsyncCallableInterruptibleTask(AsyncCallable<V> asyncCallable, Executor executor) {
            super(executor);
            asyncCallable.getClass();
            this.callable = asyncCallable;
        }

        @Override
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override
        public ListenableFuture<V> runInterruptibly() throws Exception {
            ListenableFuture<V> listenableFutureCall = this.callable.call();
            AbstractC1332b.m3218i(listenableFutureCall, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
            return listenableFutureCall;
        }

        @Override
        public void setValue(ListenableFuture<V> listenableFuture) {
            CombinedFuture.this.setFuture(listenableFuture);
        }
    }

    public final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> callable;

        public CallableInterruptibleTask(Callable<V> callable, Executor executor) {
            super(executor);
            callable.getClass();
            this.callable = callable;
        }

        @Override
        @ParametricNullness
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override
        public void setValue(@ParametricNullness V v10) {
            CombinedFuture.this.set(v10);
        }

        @Override
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;

        public CombinedFutureInterruptibleTask(Executor executor) {
            executor.getClass();
            this.listenerExecutor = executor;
        }

        @Override
        public final void afterRanInterruptiblyFailure(Throwable th) {
            CombinedFuture.this.task = null;
            if (th instanceof ExecutionException) {
                CombinedFuture.this.setException(((ExecutionException) th).getCause());
            } else if (th instanceof CancellationException) {
                CombinedFuture.this.cancel(false);
            } else {
                CombinedFuture.this.setException(th);
            }
        }

        @Override
        public final void afterRanInterruptiblySuccess(@ParametricNullness T t5) {
            CombinedFuture.this.task = null;
            setValue(t5);
        }

        public final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException e5) {
                CombinedFuture.this.setException(e5);
            }
        }

        @Override
        public final boolean isDone() {
            return CombinedFuture.this.isDone();
        }

        public abstract void setValue(@ParametricNullness T t5);
    }

    public CombinedFuture(AbstractC2274q1 abstractC2274q1, boolean z7, Executor executor, AsyncCallable<V> asyncCallable) {
        super(abstractC2274q1, z7, false);
        this.task = new AsyncCallableInterruptibleTask(asyncCallable, executor);
        init();
    }

    @Override
    public void handleAllCompleted() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.task;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.execute();
        }
    }

    @Override
    public void interruptTask() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.task;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.interruptTask();
        }
    }

    @Override
    public void releaseResources(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.releaseResources(releaseResourcesReason);
        if (releaseResourcesReason == AggregateFuture.ReleaseResourcesReason.OUTPUT_FUTURE_DONE) {
            this.task = null;
        }
    }

    public CombinedFuture(AbstractC2274q1 abstractC2274q1, boolean z7, Executor executor, Callable<V> callable) {
        super(abstractC2274q1, z7, false);
        this.task = new CallableInterruptibleTask(callable, executor);
        init();
    }

    @Override
    public void collectOneValue(int i6, Object obj) {
    }
}

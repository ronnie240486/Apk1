package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

@ElementTypesAreNonnullByDefault
public final class JdkFutureAdapters {

    public static class ListenableFutureAdapter<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
        private static final Executor defaultAdapterExecutor;
        private static final ThreadFactory threadFactory;
        private final Executor adapterExecutor;
        private final Future<V> delegate;
        private final ExecutionList executionList;
        private final AtomicBoolean hasListeners;

        static {
            ThreadFactory threadFactoryBuild = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
            threadFactory = threadFactoryBuild;
            defaultAdapterExecutor = Executors.newCachedThreadPool(threadFactoryBuild);
        }

        public ListenableFutureAdapter(Future<V> future) {
            this(future, defaultAdapterExecutor);
        }

        public void lambda$addListener$0() {
            try {
                Uninterruptibles.getUninterruptibly(this.delegate);
            } catch (Throwable unused) {
            }
            this.executionList.execute();
        }

        @Override
        public void addListener(Runnable runnable, Executor executor) {
            this.executionList.add(runnable, executor);
            if (this.hasListeners.compareAndSet(false, true)) {
                if (this.delegate.isDone()) {
                    this.executionList.execute();
                } else {
                    this.adapterExecutor.execute(new RunnableC1959c(1, this));
                }
            }
        }

        public ListenableFutureAdapter(Future<V> future, Executor executor) {
            this.executionList = new ExecutionList();
            this.hasListeners = new AtomicBoolean(false);
            future.getClass();
            this.delegate = future;
            executor.getClass();
            this.adapterExecutor = executor;
        }

        @Override
        public Future<V> delegate() {
            return this.delegate;
        }
    }

    private JdkFutureAdapters() {
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> future) {
        return future instanceof ListenableFuture ? (ListenableFuture) future : new ListenableFutureAdapter(future);
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> future, Executor executor) {
        executor.getClass();
        if (future instanceof ListenableFuture) {
            return (ListenableFuture) future;
        }
        return new ListenableFutureAdapter(future, executor);
    }
}

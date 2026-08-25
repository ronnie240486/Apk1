package com.google.common.util.concurrent;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import p020b7.AbstractC1332b;

@ElementTypesAreNonnullByDefault
public final class ExecutionSequencer {
    private final AtomicReference<ListenableFuture<Void>> ref = new AtomicReference<>(Futures.immediateVoidFuture());
    private ThreadConfinedTaskQueue latestTaskQueue = new ThreadConfinedTaskQueue();

    public enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    public static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {
        Executor delegate;
        ExecutionSequencer sequencer;
        Thread submitting;
        Runnable task;

        public boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }

        public boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        @Override
        public void execute(Runnable runnable) {
            if (get() == RunningState.CANCELLED) {
                this.delegate = null;
                this.sequencer = null;
                return;
            }
            this.submitting = Thread.currentThread();
            try {
                ExecutionSequencer executionSequencer = this.sequencer;
                Objects.requireNonNull(executionSequencer);
                ThreadConfinedTaskQueue threadConfinedTaskQueue = executionSequencer.latestTaskQueue;
                if (threadConfinedTaskQueue.thread == this.submitting) {
                    this.sequencer = null;
                    AbstractC1332b.m3224o(threadConfinedTaskQueue.nextTask == null);
                    threadConfinedTaskQueue.nextTask = runnable;
                    Executor executor = this.delegate;
                    Objects.requireNonNull(executor);
                    threadConfinedTaskQueue.nextExecutor = executor;
                    this.delegate = null;
                } else {
                    Executor executor2 = this.delegate;
                    Objects.requireNonNull(executor2);
                    this.delegate = null;
                    this.task = runnable;
                    executor2.execute(this);
                }
            } finally {
                this.submitting = null;
            }
        }

        @Override
        public void run() {
            Executor executor;
            Thread threadCurrentThread = Thread.currentThread();
            if (threadCurrentThread != this.submitting) {
                Runnable runnable = this.task;
                Objects.requireNonNull(runnable);
                this.task = null;
                runnable.run();
                return;
            }
            ThreadConfinedTaskQueue threadConfinedTaskQueue = new ThreadConfinedTaskQueue();
            threadConfinedTaskQueue.thread = threadCurrentThread;
            ExecutionSequencer executionSequencer = this.sequencer;
            Objects.requireNonNull(executionSequencer);
            executionSequencer.latestTaskQueue = threadConfinedTaskQueue;
            this.sequencer = null;
            try {
                Runnable runnable2 = this.task;
                Objects.requireNonNull(runnable2);
                this.task = null;
                runnable2.run();
                while (true) {
                    Runnable runnable3 = threadConfinedTaskQueue.nextTask;
                    if (runnable3 == null || (executor = threadConfinedTaskQueue.nextExecutor) == null) {
                        break;
                    }
                    threadConfinedTaskQueue.nextTask = null;
                    threadConfinedTaskQueue.nextExecutor = null;
                    executor.execute(runnable3);
                }
                threadConfinedTaskQueue.thread = null;
            } catch (Throwable th) {
                threadConfinedTaskQueue.thread = null;
                throw th;
            }
        }

        private TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer) {
            super(RunningState.NOT_RUN);
            this.delegate = executor;
            this.sequencer = executionSequencer;
        }
    }

    public static final class ThreadConfinedTaskQueue {
        Executor nextExecutor;
        Runnable nextTask;
        Thread thread;

        private ThreadConfinedTaskQueue() {
        }
    }

    private ExecutionSequencer() {
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    public static void lambda$submitAsync$0(TrustedListenableFutureTask trustedListenableFutureTask, SettableFuture settableFuture, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, TaskNonReentrantExecutor taskNonReentrantExecutor) {
        if (trustedListenableFutureTask.isDone()) {
            settableFuture.setFuture(listenableFuture);
        } else if (listenableFuture2.isCancelled() && taskNonReentrantExecutor.trySetCancelled()) {
            trustedListenableFutureTask.cancel(false);
        }
    }

    public <T> ListenableFuture<T> submit(final Callable<T> callable, Executor executor) {
        callable.getClass();
        executor.getClass();
        return submitAsync(new AsyncCallable<T>(this) {
            final ExecutionSequencer this$0;

            {
                this.this$0 = this;
            }

            @Override
            public ListenableFuture<T> call() throws Exception {
                return Futures.immediateFuture(callable.call());
            }

            public String toString() {
                return callable.toString();
            }
        }, executor);
    }

    public <T> ListenableFuture<T> submitAsync(final AsyncCallable<T> asyncCallable, Executor executor) {
        asyncCallable.getClass();
        executor.getClass();
        final TaskNonReentrantExecutor taskNonReentrantExecutor = new TaskNonReentrantExecutor(executor, this);
        AsyncCallable<T> asyncCallable2 = new AsyncCallable<T>(this) {
            final ExecutionSequencer this$0;

            {
                this.this$0 = this;
            }

            @Override
            public ListenableFuture<T> call() throws Exception {
                return !taskNonReentrantExecutor.trySetStarted() ? Futures.immediateCancelledFuture() : asyncCallable.call();
            }

            public String toString() {
                return asyncCallable.toString();
            }
        };
        final SettableFuture settableFutureCreate = SettableFuture.create();
        final ListenableFuture<Void> andSet = this.ref.getAndSet(settableFutureCreate);
        final TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(asyncCallable2);
        andSet.addListener(trustedListenableFutureTaskCreate, taskNonReentrantExecutor);
        final ListenableFuture<T> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(trustedListenableFutureTaskCreate);
        Runnable runnable = new Runnable() {
            @Override
            public final void run() {
                ExecutionSequencer.TaskNonReentrantExecutor taskNonReentrantExecutor2 = taskNonReentrantExecutor;
                ExecutionSequencer.lambda$submitAsync$0(trustedListenableFutureTaskCreate, settableFutureCreate, andSet, listenableFutureNonCancellationPropagating, taskNonReentrantExecutor2);
            }
        };
        listenableFutureNonCancellationPropagating.addListener(runnable, MoreExecutors.directExecutor());
        trustedListenableFutureTaskCreate.addListener(runnable, MoreExecutors.directExecutor());
        return listenableFutureNonCancellationPropagating;
    }
}

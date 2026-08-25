package com.google.common.util.concurrent;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p020b7.AbstractC1332b;
import p020b7.AbstractC1347i0;
import p020b7.InterfaceC1339e0;
import p041d7.AbstractC2182d0;

@ElementTypesAreNonnullByDefault
public final class MoreExecutors {

    public static class ListeningDecorator extends AbstractListeningExecutorService {
        private final ExecutorService delegate;

        public ListeningDecorator(ExecutorService executorService) {
            executorService.getClass();
            this.delegate = executorService;
        }

        @Override
        public final boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
            return this.delegate.awaitTermination(j10, timeUnit);
        }

        @Override
        public final void execute(Runnable runnable) {
            this.delegate.execute(runnable);
        }

        @Override
        public final boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        @Override
        public final boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        @Override
        public final void shutdown() {
            this.delegate.shutdown();
        }

        @Override
        public final List<Runnable> shutdownNow() {
            return this.delegate.shutdownNow();
        }

        public final String toString() {
            return super.toString() + "[" + this.delegate + "]";
        }
    }

    public static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
        final ScheduledExecutorService delegate;

        public static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
            private final ScheduledFuture<?> scheduledDelegate;

            public ListenableScheduledTask(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
                super(listenableFuture);
                this.scheduledDelegate = scheduledFuture;
            }

            @Override
            public boolean cancel(boolean z7) {
                boolean zCancel = super.cancel(z7);
                if (zCancel) {
                    this.scheduledDelegate.cancel(z7);
                }
                return zCancel;
            }

            @Override
            public long getDelay(TimeUnit timeUnit) {
                return this.scheduledDelegate.getDelay(timeUnit);
            }

            @Override
            public int compareTo(Delayed delayed) {
                return this.scheduledDelegate.compareTo(delayed);
            }
        }

        public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {
            private final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                runnable.getClass();
                this.delegate = runnable;
            }

            @Override
            public String pendingToString() {
                return "task=[" + this.delegate + "]";
            }

            @Override
            public void run() {
                try {
                    this.delegate.run();
                } catch (Throwable th) {
                    setException(th);
                    throw th;
                }
            }
        }

        public ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            scheduledExecutorService.getClass();
            this.delegate = scheduledExecutorService;
        }

        @Override
        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j10, j11, timeUnit));
        }

        @Override
        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j10, j11, timeUnit));
        }

        @Override
        public ListenableScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(runnable, null);
            return new ListenableScheduledTask(trustedListenableFutureTaskCreate, this.delegate.schedule(trustedListenableFutureTaskCreate, j10, timeUnit));
        }

        @Override
        public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
            TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(callable);
            return new ListenableScheduledTask(trustedListenableFutureTaskCreate, this.delegate.schedule(trustedListenableFutureTaskCreate, j10, timeUnit));
        }
    }

    private MoreExecutors() {
    }

    public static void addDelayedShutdownHook(ExecutorService executorService, long j10, TimeUnit timeUnit) {
        new Application().addDelayedShutdownHook(executorService, j10, timeUnit);
    }

    public static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }

    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long j10, TimeUnit timeUnit) {
        return new Application().getExitingExecutorService(threadPoolExecutor, j10, timeUnit);
    }

    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j10, TimeUnit timeUnit) {
        return new Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor, j10, timeUnit);
    }

    @ParametricNullness
    public static <T> T invokeAnyImpl(ListeningExecutorService listeningExecutorService, Collection<? extends Callable<T>> collection, boolean z7, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long jNanoTime;
        long jNanoTime2;
        listeningExecutorService.getClass();
        timeUnit.getClass();
        int size = collection.size();
        AbstractC1332b.m3215f(size > 0);
        ArrayList arrayListM5157t = AbstractC2182d0.m5157t(size);
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        long nanos = timeUnit.toNanos(j10);
        if (z7) {
            try {
                jNanoTime = System.nanoTime();
            } catch (Throwable th) {
                Iterator it = arrayListM5157t.iterator();
                while (it.hasNext()) {
                    ((Future) it.next()).cancel(true);
                }
                throw th;
            }
        } else {
            jNanoTime = 0;
        }
        Iterator<? extends Callable<T>> it2 = collection.iterator();
        arrayListM5157t.add(submitAndAddQueueListener(listeningExecutorService, it2.next(), linkedBlockingQueue));
        int i6 = size - 1;
        ExecutionException executionException = null;
        int i10 = 1;
        while (true) {
            Future future = (Future) linkedBlockingQueue.poll();
            if (future != null) {
                jNanoTime2 = jNanoTime;
            } else {
                if (i6 > 0) {
                    i6--;
                    arrayListM5157t.add(submitAndAddQueueListener(listeningExecutorService, it2.next(), linkedBlockingQueue));
                    i10++;
                } else {
                    if (i10 == 0) {
                        if (executionException == null) {
                            throw new ExecutionException((Throwable) null);
                        }
                        throw executionException;
                    }
                    if (z7) {
                        future = (Future) linkedBlockingQueue.poll(nanos, TimeUnit.NANOSECONDS);
                        if (future == null) {
                            throw new TimeoutException();
                        }
                        jNanoTime2 = System.nanoTime();
                        nanos -= jNanoTime2 - jNanoTime;
                    } else {
                        future = (Future) linkedBlockingQueue.take();
                    }
                }
                jNanoTime2 = jNanoTime;
            }
            long j11 = nanos;
            int i11 = i6;
            if (future != null) {
                i10--;
                try {
                    try {
                        T t5 = (T) future.get();
                        Iterator it3 = arrayListM5157t.iterator();
                        while (it3.hasNext()) {
                            ((Future) it3.next()).cancel(true);
                        }
                        return t5;
                    } catch (InterruptedException e5) {
                        throw e5;
                    }
                } catch (ExecutionException e10) {
                    executionException = e10;
                    i6 = i11;
                    nanos = j11;
                    jNanoTime = jNanoTime2;
                } catch (Exception e11) {
                    executionException = new ExecutionException(e11);
                    i6 = i11;
                    nanos = j11;
                    jNanoTime = jNanoTime2;
                }
            }
            i6 = i11;
            nanos = j11;
            jNanoTime = jNanoTime2;
        }
    }

    private static boolean isAppEngineWithApiClasses() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            Class.forName("com.google.appengine.api.utils.SystemProperty");
            return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", null).invoke(null, null) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static ListeningExecutorService listeningDecorator(ExecutorService executorService) {
        if (executorService instanceof ListeningExecutorService) {
            return (ListeningExecutorService) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new ListeningDecorator(executorService);
    }

    public static ListeningExecutorService newDirectExecutorService() {
        return new DirectExecutorService();
    }

    public static Executor newSequentialExecutor(Executor executor) {
        return new SequentialExecutor(executor);
    }

    public static Thread newThread(String str, Runnable runnable) {
        str.getClass();
        runnable.getClass();
        Thread threadNewThread = platformThreadFactory().newThread(runnable);
        Objects.requireNonNull(threadNewThread);
        try {
            threadNewThread.setName(str);
        } catch (SecurityException unused) {
        }
        return threadNewThread;
    }

    public static ThreadFactory platformThreadFactory() {
        if (!isAppEngineWithApiClasses()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", null).invoke(null, null);
        } catch (ClassNotFoundException e5) {
            e = e5;
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (IllegalAccessException e10) {
            e = e10;
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (NoSuchMethodException e11) {
            e = e11;
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            Object obj = AbstractC1347i0.f4166a;
            cause.getClass();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static Executor rejectionPropagatingExecutor(final Executor executor, final AbstractFuture<?> abstractFuture) {
        executor.getClass();
        abstractFuture.getClass();
        return executor == directExecutor() ? executor : new Executor() {
            @Override
            public void execute(Runnable runnable) {
                try {
                    executor.execute(runnable);
                } catch (RejectedExecutionException e5) {
                    abstractFuture.setException(e5);
                }
            }
        };
    }

    public static Executor renamingDecorator(final Executor executor, final InterfaceC1339e0 interfaceC1339e0) {
        executor.getClass();
        interfaceC1339e0.getClass();
        return new Executor() {
            @Override
            public void execute(Runnable runnable) {
                executor.execute(Callables.threadRenaming(runnable, interfaceC1339e0));
            }
        };
    }

    public static boolean shutdownAndAwaitTermination(ExecutorService executorService, long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10) / 2;
        executorService.shutdown();
        try {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (!executorService.awaitTermination(nanos, timeUnit2)) {
                executorService.shutdownNow();
                executorService.awaitTermination(nanos, timeUnit2);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }

    private static <T> ListenableFuture<T> submitAndAddQueueListener(ListeningExecutorService listeningExecutorService, Callable<T> callable, final BlockingQueue<Future<T>> blockingQueue) {
        final ListenableFuture<T> listenableFutureSubmit = listeningExecutorService.submit((Callable) callable);
        listenableFutureSubmit.addListener(new Runnable() {
            @Override
            public void run() {
                blockingQueue.add(listenableFutureSubmit);
            }
        }, directExecutor());
        return listenableFutureSubmit;
    }

    public static void useDaemonThreadFactory(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
    }

    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
        return new Application().getExitingExecutorService(threadPoolExecutor);
    }

    public static class Application {
        public final void addDelayedShutdownHook(final ExecutorService executorService, final long j10, final TimeUnit timeUnit) {
            executorService.getClass();
            timeUnit.getClass();
            addShutdownHook(MoreExecutors.newThread("DelayedShutdownHook-for-" + executorService, new Runnable(this) {
                final Application this$0;

                {
                    this.this$0 = this;
                }

                @Override
                public void run() {
                    try {
                        executorService.shutdown();
                        executorService.awaitTermination(j10, timeUnit);
                    } catch (InterruptedException unused) {
                    }
                }
            }));
        }

        public void addShutdownHook(Thread thread) {
            Runtime.getRuntime().addShutdownHook(thread);
        }

        public final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long j10, TimeUnit timeUnit) {
            MoreExecutors.useDaemonThreadFactory(threadPoolExecutor);
            ExecutorService executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
            addDelayedShutdownHook(threadPoolExecutor, j10, timeUnit);
            return executorServiceUnconfigurableExecutorService;
        }

        public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j10, TimeUnit timeUnit) {
            MoreExecutors.useDaemonThreadFactory(scheduledThreadPoolExecutor);
            ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
            addDelayedShutdownHook(scheduledThreadPoolExecutor, j10, timeUnit);
            return scheduledExecutorServiceUnconfigurableScheduledExecutorService;
        }

        public final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
            return getExitingExecutorService(threadPoolExecutor, 120L, TimeUnit.SECONDS);
        }

        public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            return getExitingScheduledExecutorService(scheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS);
        }
    }

    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor);
    }

    public static ExecutorService renamingDecorator(ExecutorService executorService, final InterfaceC1339e0 interfaceC1339e0) {
        executorService.getClass();
        interfaceC1339e0.getClass();
        return new WrappingExecutorService(executorService) {
            @Override
            public <T> Callable<T> wrapTask(Callable<T> callable) {
                return Callables.threadRenaming(callable, interfaceC1339e0);
            }

            @Override
            public Runnable wrapTask(Runnable runnable) {
                return Callables.threadRenaming(runnable, interfaceC1339e0);
            }
        };
    }

    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService instanceof ListeningScheduledExecutorService) {
            return (ListeningScheduledExecutorService) scheduledExecutorService;
        }
        return new ScheduledListeningDecorator(scheduledExecutorService);
    }

    public static ScheduledExecutorService renamingDecorator(ScheduledExecutorService scheduledExecutorService, final InterfaceC1339e0 interfaceC1339e0) {
        scheduledExecutorService.getClass();
        interfaceC1339e0.getClass();
        return new WrappingScheduledExecutorService(scheduledExecutorService) {
            @Override
            public <T> Callable<T> wrapTask(Callable<T> callable) {
                return Callables.threadRenaming(callable, interfaceC1339e0);
            }

            @Override
            public Runnable wrapTask(Runnable runnable) {
                return Callables.threadRenaming(runnable, interfaceC1339e0);
            }
        };
    }
}

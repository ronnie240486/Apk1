package com.google.common.util.concurrent;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p020b7.AbstractC1347i0;
import p041d7.AbstractC2301u1;
import p041d7.C2288s1;

@ElementTypesAreNonnullByDefault
abstract class WrappingExecutorService implements ExecutorService {
    private final ExecutorService delegate;

    public WrappingExecutorService(ExecutorService executorService) {
        executorService.getClass();
        this.delegate = executorService;
    }

    public static void lambda$wrapTask$0(Callable callable) {
        try {
            callable.call();
        } catch (Exception e5) {
            Platform.restoreInterruptIfIsInterruptedException(e5);
            Object obj = AbstractC1347i0.f4166a;
            if (!(e5 instanceof RuntimeException)) {
                throw new RuntimeException(e5);
            }
            throw ((RuntimeException) e5);
        }
    }

    private <T> AbstractC2301u1 wrapTasks(Collection<? extends Callable<T>> collection) {
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        Iterator<? extends Callable<T>> it = collection.iterator();
        while (it.hasNext()) {
            c2288s1M5269k.m5255a(wrapTask(it.next()));
        }
        return c2288s1M5269k.m5262g();
    }

    @Override
    public final boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j10, timeUnit);
    }

    @Override
    public final void execute(Runnable runnable) {
        this.delegate.execute(wrapTask(runnable));
    }

    @Override
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(wrapTasks(collection));
    }

    @Override
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.delegate.invokeAny(wrapTasks(collection));
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

    @Override
    public final <T> Future<T> submit(Callable<T> callable) {
        ExecutorService executorService = this.delegate;
        callable.getClass();
        return executorService.submit(wrapTask(callable));
    }

    public Runnable wrapTask(Runnable runnable) {
        return new RunnableC1959c(2, wrapTask(Executors.callable(runnable, null)));
    }

    public abstract <T> Callable<T> wrapTask(Callable<T> callable);

    @Override
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(wrapTasks(collection), j10, timeUnit);
    }

    @Override
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.delegate.invokeAny(wrapTasks(collection), j10, timeUnit);
    }

    @Override
    public final Future<?> submit(Runnable runnable) {
        return this.delegate.submit(wrapTask(runnable));
    }

    @Override
    public final <T> Future<T> submit(Runnable runnable, @ParametricNullness T t5) {
        return this.delegate.submit(wrapTask(runnable), t5);
    }
}

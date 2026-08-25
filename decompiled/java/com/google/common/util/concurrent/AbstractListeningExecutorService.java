package com.google.common.util.concurrent;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

@ElementTypesAreNonnullByDefault
public abstract class AbstractListeningExecutorService extends AbstractExecutorService implements ListeningExecutorService {
    @Override
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, @ParametricNullness T t5) {
        return TrustedListenableFutureTask.create(runnable, t5);
    }

    @Override
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return TrustedListenableFutureTask.create(callable);
    }

    @Override
    public ListenableFuture<?> submit(Runnable runnable) {
        return (ListenableFuture) super.submit(runnable);
    }

    @Override
    public <T> ListenableFuture<T> submit(Runnable runnable, @ParametricNullness T t5) {
        return (ListenableFuture) super.submit(runnable, (Object) t5);
    }

    @Override
    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        return (ListenableFuture) super.submit((Callable) callable);
    }
}

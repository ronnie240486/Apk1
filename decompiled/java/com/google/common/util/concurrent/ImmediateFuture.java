package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import p020b7.AbstractC1332b;

@ElementTypesAreNonnullByDefault
class ImmediateFuture<V> implements ListenableFuture<V> {
    static final ListenableFuture<?> NULL = new ImmediateFuture(null);
    private static final LazyLogger log = new LazyLogger(ImmediateFuture.class);

    @ParametricNullness
    private final V value;

    public static final class ImmediateCancelledFuture<V> extends AbstractFuture.TrustedFuture<V> {
        static final ImmediateCancelledFuture<Object> INSTANCE;

        static {
            INSTANCE = AbstractFuture.GENERATE_CANCELLATION_CAUSES ? null : new ImmediateCancelledFuture<>();
        }

        public ImmediateCancelledFuture() {
            cancel(false);
        }
    }

    public static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
        public ImmediateFailedFuture(Throwable th) {
            setException(th);
        }
    }

    public ImmediateFuture(@ParametricNullness V v10) {
        this.value = v10;
    }

    @Override
    public void addListener(Runnable runnable, Executor executor) {
        AbstractC1332b.m3219j(runnable, "Runnable was null.");
        AbstractC1332b.m3219j(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (Exception e5) {
            log.get().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e5);
        }
    }

    @Override
    public boolean cancel(boolean z7) {
        return false;
    }

    @Override
    @ParametricNullness
    public V get() {
        return this.value;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return true;
    }

    public String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + this.value + "]]";
    }

    @Override
    @ParametricNullness
    public V get(long j10, TimeUnit timeUnit) throws ExecutionException {
        timeUnit.getClass();
        return get();
    }
}

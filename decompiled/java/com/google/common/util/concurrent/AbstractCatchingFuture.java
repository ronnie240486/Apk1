package com.google.common.util.concurrent;

import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1346i;
import p055ea.AbstractC2460q;

@ElementTypesAreNonnullByDefault
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {
    Class<X> exceptionType;
    F fallback;
    ListenableFuture<? extends V> inputFuture;

    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        public AsyncCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        @Override
        public ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> asyncFunction, X x10) throws Exception {
            ListenableFuture<? extends V> listenableFutureApply = asyncFunction.apply(x10);
            AbstractC1332b.m3218i(listenableFutureApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return listenableFutureApply;
        }

        @Override
        public void setResult(ListenableFuture<? extends V> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, InterfaceC1346i, V> {
        public CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, InterfaceC1346i interfaceC1346i) {
            super(listenableFuture, cls, interfaceC1346i);
        }

        @Override
        public void setResult(@ParametricNullness V v10) {
            set(v10);
        }

        @Override
        @ParametricNullness
        public V doFallback(InterfaceC1346i interfaceC1346i, X x10) throws Exception {
            return (V) interfaceC1346i.apply(x10);
        }
    }

    public AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f) {
        listenableFuture.getClass();
        this.inputFuture = listenableFuture;
        cls.getClass();
        this.exceptionType = cls;
        f.getClass();
        this.fallback = f;
    }

    public static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, InterfaceC1346i interfaceC1346i, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, interfaceC1346i);
        listenableFuture.addListener(catchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, catchingFuture));
        return catchingFuture;
    }

    public static <X extends Throwable, V> ListenableFuture<V> createAsync(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(asyncCatchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }

    @Override
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    @ParametricNullness
    public abstract T doFallback(F f, X x10) throws Exception;

    @Override
    public String pendingToString() {
        String str;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f = this.fallback;
        String strPendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls == null || f == null) {
            if (strPendingToString != null) {
                return AbstractC2460q.m5494h(str, strPendingToString);
            }
            return null;
        }
        return str + "exceptionType=[" + cls + "], fallback=[" + f + "]";
    }

    @Override
    public final void run() {
        Object done;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f = this.fallback;
        if (((f == null) || ((listenableFuture == null) | (cls == null))) || isCancelled()) {
            return;
        }
        ?? r10 = (Class<X>) null;
        this.inputFuture = null;
        try {
            th = listenableFuture instanceof InternalFutureFailureAccess ? InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture) : null;
            done = th == null ? Futures.getDone(listenableFuture) : null;
        } catch (ExecutionException e5) {
            Throwable cause = e5.getCause();
            if (cause == null) {
                cause = new NullPointerException("Future type " + listenableFuture.getClass() + " threw " + e5.getClass() + " without a cause");
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        if (th == null) {
            set(NullnessCasts.uncheckedCastNullableTToT(done));
            return;
        }
        if (!Platform.isInstanceOfThrowableClass(th, cls)) {
            setFuture(listenableFuture);
            return;
        }
        try {
            Object objDoFallback = doFallback(f, th);
            this.exceptionType = null;
            this.fallback = null;
            setResult(objDoFallback);
        } catch (Throwable th2) {
            try {
                Platform.restoreInterruptIfIsInterruptedException(th2);
                setException(th2);
            } finally {
                this.exceptionType = null;
                this.fallback = null;
            }
        }
    }

    public abstract void setResult(@ParametricNullness T t5);
}

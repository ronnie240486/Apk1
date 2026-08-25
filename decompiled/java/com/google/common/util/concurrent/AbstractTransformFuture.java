package com.google.common.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1346i;
import p055ea.AbstractC2460q;

@ElementTypesAreNonnullByDefault
abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {
    F function;
    ListenableFuture<? extends I> inputFuture;

    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        public AsyncTransformFuture(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        @Override
        public ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> asyncFunction, @ParametricNullness I i6) throws Exception {
            ListenableFuture<? extends O> listenableFutureApply = asyncFunction.apply(i6);
            AbstractC1332b.m3218i(listenableFutureApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return listenableFutureApply;
        }

        @Override
        public void setResult(ListenableFuture<? extends O> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, InterfaceC1346i, O> {
        public TransformFuture(ListenableFuture<? extends I> listenableFuture, InterfaceC1346i interfaceC1346i) {
            super(listenableFuture, interfaceC1346i);
        }

        @Override
        public void setResult(@ParametricNullness O o6) {
            set(o6);
        }

        @Override
        @ParametricNullness
        public O doTransform(InterfaceC1346i interfaceC1346i, @ParametricNullness I i6) {
            return (O) interfaceC1346i.apply(i6);
        }
    }

    public AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f) {
        listenableFuture.getClass();
        this.inputFuture = listenableFuture;
        f.getClass();
        this.function = f;
    }

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, InterfaceC1346i interfaceC1346i, Executor executor) {
        interfaceC1346i.getClass();
        TransformFuture transformFuture = new TransformFuture(listenableFuture, interfaceC1346i);
        listenableFuture.addListener(transformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, transformFuture));
        return transformFuture;
    }

    public static <I, O> ListenableFuture<O> createAsync(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        executor.getClass();
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(asyncTransformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    @Override
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    @ParametricNullness
    public abstract T doTransform(F f, @ParametricNullness I i6) throws Exception;

    @Override
    public String pendingToString() {
        String str;
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f = this.function;
        String strPendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (f == null) {
            if (strPendingToString != null) {
                return AbstractC2460q.m5494h(str, strPendingToString);
            }
            return null;
        }
        return str + "function=[" + f + "]";
    }

    @Override
    public final void run() {
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f = this.function;
        if ((isCancelled() | (listenableFuture == null)) || (f == null)) {
            return;
        }
        this.inputFuture = null;
        if (listenableFuture.isCancelled()) {
            setFuture(listenableFuture);
            return;
        }
        try {
            try {
                Object objDoTransform = doTransform(f, Futures.getDone(listenableFuture));
                this.function = null;
                setResult(objDoTransform);
            } catch (Throwable th) {
                try {
                    Platform.restoreInterruptIfIsInterruptedException(th);
                    setException(th);
                } finally {
                    this.function = null;
                }
            }
        } catch (Error e5) {
            setException(e5);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e10) {
            setException(e10.getCause());
        } catch (Exception e11) {
            setException(e11);
        }
    }

    public abstract void setResult(@ParametricNullness T t5);
}

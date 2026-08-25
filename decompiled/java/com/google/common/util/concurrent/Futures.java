package com.google.common.util.concurrent;

import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import p002a1.C0026b;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1346i;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2288s1;

@ElementTypesAreNonnullByDefault
public final class Futures extends GwtFuturesCatchingSpecialization {

    public static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> callback;
        final Future<V> future;

        public CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.future = future;
            this.callback = futureCallback;
        }

        @Override
        public void run() {
            Throwable thTryInternalFastPathGetFailure;
            Future<V> future = this.future;
            if ((future instanceof InternalFutureFailureAccess) && (thTryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) future)) != null) {
                this.callback.onFailure(thTryInternalFastPathGetFailure);
                return;
            }
            try {
                this.callback.onSuccess(Futures.getDone(this.future));
            } catch (ExecutionException e5) {
                this.callback.onFailure(e5.getCause());
            } catch (Throwable th) {
                this.callback.onFailure(th);
            }
        }

        public String toString() {
            C0026b c0026bM3232w = AbstractC1332b.m3232w(this);
            FutureCallback<? super V> futureCallback = this.callback;
            C0026b c0026b = new C0026b(13, false);
            ((C0026b) c0026bM3232w.f56d).f56d = c0026b;
            c0026bM3232w.f56d = c0026b;
            c0026b.f55c = futureCallback;
            return c0026bM3232w.toString();
        }
    }

    public static final class FutureCombiner<V> {
        private final boolean allMustSucceed;
        private final AbstractC2301u1 futures;

        public <C> ListenableFuture<C> call(Callable<C> callable, Executor executor) {
            return new CombinedFuture(this.futures, this.allMustSucceed, executor, callable);
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> asyncCallable, Executor executor) {
            return new CombinedFuture(this.futures, this.allMustSucceed, executor, asyncCallable);
        }

        public ListenableFuture<?> run(final Runnable runnable, Executor executor) {
            return call(new Callable<Void>(this) {
                final FutureCombiner this$0;

                {
                    this.this$0 = this;
                }

                @Override
                public Void call() throws Exception {
                    runnable.run();
                    return null;
                }
            }, executor);
        }

        private FutureCombiner(boolean z7, AbstractC2301u1 abstractC2301u1) {
            this.allMustSucceed = z7;
            this.futures = abstractC2301u1;
        }
    }

    public static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {
        private InCompletionOrderState<T> state;

        @Override
        public void afterDone() {
            this.state = null;
        }

        @Override
        public boolean cancel(boolean z7) {
            InCompletionOrderState<T> inCompletionOrderState = this.state;
            if (!super.cancel(z7)) {
                return false;
            }
            Objects.requireNonNull(inCompletionOrderState);
            inCompletionOrderState.recordOutputCancellation(z7);
            return true;
        }

        @Override
        public String pendingToString() {
            InCompletionOrderState<T> inCompletionOrderState = this.state;
            if (inCompletionOrderState == null) {
                return null;
            }
            return "inputCount=[" + ((InCompletionOrderState) inCompletionOrderState).inputFutures.length + "], remaining=[" + ((InCompletionOrderState) inCompletionOrderState).incompleteOutputCount.get() + "]";
        }

        private InCompletionOrderFuture(InCompletionOrderState<T> inCompletionOrderState) {
            this.state = inCompletionOrderState;
        }
    }

    public static final class InCompletionOrderState<T> {
        private volatile int delegateIndex;
        private final AtomicInteger incompleteOutputCount;
        private final ListenableFuture<? extends T>[] inputFutures;
        private boolean shouldInterrupt;
        private boolean wasCancelled;

        public static void access$600(InCompletionOrderState inCompletionOrderState, AbstractC2301u1 abstractC2301u1, int i6) {
            inCompletionOrderState.recordInputCompletion(abstractC2301u1, i6);
        }

        private void recordCompletion() {
            if (this.incompleteOutputCount.decrementAndGet() == 0 && this.wasCancelled) {
                for (ListenableFuture<? extends T> listenableFuture : this.inputFutures) {
                    if (listenableFuture != null) {
                        listenableFuture.cancel(this.shouldInterrupt);
                    }
                }
            }
        }

        public void recordInputCompletion(AbstractC2301u1 abstractC2301u1, int i6) {
            ListenableFuture<? extends T> listenableFuture = this.inputFutures[i6];
            Objects.requireNonNull(listenableFuture);
            ListenableFuture<? extends T> listenableFuture2 = listenableFuture;
            this.inputFutures[i6] = null;
            for (int i10 = this.delegateIndex; i10 < abstractC2301u1.size(); i10++) {
                if (((AbstractFuture) abstractC2301u1.get(i10)).setFuture(listenableFuture2)) {
                    recordCompletion();
                    this.delegateIndex = i10 + 1;
                    return;
                }
            }
            this.delegateIndex = abstractC2301u1.size();
        }

        public void recordOutputCancellation(boolean z7) {
            this.wasCancelled = true;
            if (!z7) {
                this.shouldInterrupt = false;
            }
            recordCompletion();
        }

        private InCompletionOrderState(ListenableFuture<? extends T>[] listenableFutureArr) {
            this.wasCancelled = false;
            this.shouldInterrupt = true;
            this.delegateIndex = 0;
            this.inputFutures = listenableFutureArr;
            this.incompleteOutputCount = new AtomicInteger(listenableFutureArr.length);
        }
    }

    public static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {
        private ListenableFuture<V> delegate;

        public NonCancellationPropagatingFuture(ListenableFuture<V> listenableFuture) {
            this.delegate = listenableFuture;
        }

        @Override
        public void afterDone() {
            this.delegate = null;
        }

        @Override
        public String pendingToString() {
            ListenableFuture<V> listenableFuture = this.delegate;
            if (listenableFuture == null) {
                return null;
            }
            return "delegate=[" + listenableFuture + "]";
        }

        @Override
        public void run() {
            ListenableFuture<V> listenableFuture = this.delegate;
            if (listenableFuture != null) {
                setFuture(listenableFuture);
            }
        }
    }

    private Futures() {
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        futureCallback.getClass();
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.ListFuture(AbstractC2301u1.m5273o(listenableFutureArr), true);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> listenableFuture, Class<X> cls, InterfaceC1346i interfaceC1346i, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, cls, interfaceC1346i, executor);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return AbstractCatchingFuture.createAsync(listenableFuture, cls, asyncFunction, executor);
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) throws Exception {
        return (V) FuturesGetChecked.getChecked(future, cls);
    }

    @ParametricNullness
    public static <V> V getDone(Future<V> future) throws ExecutionException {
        AbstractC1332b.m3222m(future, "Future was expected to be done: %s", future.isDone());
        return (V) Uninterruptibles.getUninterruptibly(future);
    }

    @ParametricNullness
    public static <V> V getUnchecked(Future<V> future) {
        future.getClass();
        try {
            return (V) Uninterruptibles.getUninterruptibly(future);
        } catch (ExecutionException e5) {
            wrapAndThrowUnchecked(e5.getCause());
            throw new AssertionError();
        }
    }

    private static <T> ListenableFuture<? extends T>[] gwtCompatibleToArray(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        return (ListenableFuture[]) (iterable instanceof Collection ? (Collection) iterable : AbstractC2301u1.m5271m(iterable)).toArray(new ListenableFuture[0]);
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        ImmediateFuture.ImmediateCancelledFuture<Object> immediateCancelledFuture = ImmediateFuture.ImmediateCancelledFuture.INSTANCE;
        return immediateCancelledFuture != null ? immediateCancelledFuture : new ImmediateFuture.ImmediateCancelledFuture();
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable th) {
        th.getClass();
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    public static <V> ListenableFuture<V> immediateFuture(@ParametricNullness V v10) {
        return v10 == null ? (ListenableFuture<V>) ImmediateFuture.NULL : new ImmediateFuture(v10);
    }

    public static ListenableFuture<Void> immediateVoidFuture() {
        return ImmediateFuture.NULL;
    }

    public static <T> AbstractC2301u1 inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        ListenableFuture[] listenableFutureArrGwtCompatibleToArray = gwtCompatibleToArray(iterable);
        InCompletionOrderState inCompletionOrderState = new InCompletionOrderState(listenableFutureArrGwtCompatibleToArray);
        C2288s1 c2288s1M5270l = AbstractC2301u1.m5270l(listenableFutureArrGwtCompatibleToArray.length);
        for (int i6 = 0; i6 < listenableFutureArrGwtCompatibleToArray.length; i6++) {
            c2288s1M5270l.m5255a(new InCompletionOrderFuture(inCompletionOrderState));
        }
        C2180c5 c2180c5M5262g = c2288s1M5270l.m5262g();
        for (int i10 = 0; i10 < listenableFutureArrGwtCompatibleToArray.length; i10++) {
            listenableFutureArrGwtCompatibleToArray[i10].addListener(new RunnableC1963g(inCompletionOrderState, c2180c5M5262g, i10), MoreExecutors.directExecutor());
        }
        return c2180c5M5262g;
    }

    public static <I, O> Future<O> lazyTransform(final Future<I> future, final InterfaceC1346i interfaceC1346i) {
        future.getClass();
        interfaceC1346i.getClass();
        return new Future<O>() {
            private O applyTransformation(I i6) throws ExecutionException {
                try {
                    return (O) interfaceC1346i.apply(i6);
                } catch (Throwable th) {
                    throw new ExecutionException(th);
                }
            }

            @Override
            public boolean cancel(boolean z7) {
                return future.cancel(z7);
            }

            @Override
            public O get() throws ExecutionException, InterruptedException {
                return applyTransformation(future.get());
            }

            @Override
            public boolean isCancelled() {
                return future.isCancelled();
            }

            @Override
            public boolean isDone() {
                return future.isDone();
            }

            @Override
            public O get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
                return applyTransformation(future.get(j10, timeUnit));
            }
        };
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> listenableFuture) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        NonCancellationPropagatingFuture nonCancellationPropagatingFuture = new NonCancellationPropagatingFuture(listenableFuture);
        listenableFuture.addListener(nonCancellationPropagatingFuture, MoreExecutors.directExecutor());
        return nonCancellationPropagatingFuture;
    }

    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> asyncCallable, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(asyncCallable);
        trustedListenableFutureTaskCreate.addListener(new RunnableC1959c(4, scheduledExecutorService.schedule(trustedListenableFutureTaskCreate, j10, timeUnit)), MoreExecutors.directExecutor());
        return trustedListenableFutureTaskCreate;
    }

    public static <O> ListenableFuture<O> submit(Callable<O> callable, Executor executor) {
        TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(callable);
        executor.execute(trustedListenableFutureTaskCreate);
        return trustedListenableFutureTaskCreate;
    }

    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> asyncCallable, Executor executor) {
        TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(asyncCallable);
        executor.execute(trustedListenableFutureTaskCreate);
        return trustedListenableFutureTaskCreate;
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.ListFuture(AbstractC2301u1.m5273o(listenableFutureArr), false);
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, InterfaceC1346i interfaceC1346i, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, interfaceC1346i, executor);
    }

    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        return AbstractTransformFuture.createAsync(listenableFuture, asyncFunction, executor);
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(false, AbstractC2301u1.m5273o(listenableFutureArr));
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(true, AbstractC2301u1.m5273o(listenableFutureArr));
    }

    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> listenableFuture, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : TimeoutFuture.create(listenableFuture, j10, timeUnit, scheduledExecutorService);
    }

    private static void wrapAndThrowUnchecked(Throwable th) {
        if (!(th instanceof Error)) {
            throw new UncheckedExecutionException(th);
        }
        throw new ExecutionError((Error) th);
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j10, TimeUnit timeUnit) throws Exception {
        return (V) FuturesGetChecked.getChecked(future, cls, j10, timeUnit);
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.ListFuture(AbstractC2301u1.m5271m(iterable), false);
    }

    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(false, AbstractC2301u1.m5271m(iterable));
    }

    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(true, AbstractC2301u1.m5271m(iterable));
    }

    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.ListFuture(AbstractC2301u1.m5271m(iterable), true);
    }

    public static ListenableFuture<Void> submit(Runnable runnable, Executor executor) {
        TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(runnable, null);
        executor.execute(trustedListenableFutureTaskCreate);
        return trustedListenableFutureTaskCreate;
    }
}

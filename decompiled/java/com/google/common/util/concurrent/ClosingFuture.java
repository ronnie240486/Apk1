package com.google.common.util.concurrent;

import java.io.Closeable;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import p002a1.C0026b;
import p020b7.AbstractC1332b;
import p020b7.C1348j;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2301u1;
import p041d7.C2197f1;
import p041d7.C2204g1;
import p041d7.C2268p2;
import p041d7.C2320x2;

@ElementTypesAreNonnullByDefault
public final class ClosingFuture<V> {
    private static final LazyLogger logger = new LazyLogger(ClosingFuture.class);
    private final CloseableList closeables;
    private final FluentFuture<V> future;
    private final AtomicReference<State> state;

    public interface AsyncClosingCallable<V> {
        ClosingFuture<V> call(DeferredCloser deferredCloser) throws Exception;
    }

    public interface AsyncClosingFunction<T, U> {
        ClosingFuture<U> apply(DeferredCloser deferredCloser, @ParametricNullness T t5) throws Exception;
    }

    public static final class CloseableList extends IdentityHashMap<AutoCloseable, Executor> implements Closeable {
        private volatile boolean closed;
        private final DeferredCloser closer;
        private volatile CountDownLatch whenClosed;

        private CloseableList() {
            this.closer = new DeferredCloser(this);
        }

        public void add(AutoCloseable autoCloseable, Executor executor) {
            executor.getClass();
            if (autoCloseable == null) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.closed) {
                        ClosingFuture.closeQuietly(autoCloseable, executor);
                    } else {
                        put(autoCloseable, executor);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public <V, U> FluentFuture<U> applyAsyncClosingFunction(AsyncClosingFunction<V, U> asyncClosingFunction, @ParametricNullness V v10) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                ClosingFuture<U> closingFutureApply = asyncClosingFunction.apply(closeableList.closer, v10);
                closingFutureApply.becomeSubsumedInto(closeableList);
                return ((ClosingFuture) closingFutureApply).future;
            } finally {
                add(closeableList, MoreExecutors.directExecutor());
            }
        }

        public <V, U> ListenableFuture<U> applyClosingFunction(ClosingFunction<? super V, U> closingFunction, @ParametricNullness V v10) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                return Futures.immediateFuture(closingFunction.apply(closeableList.closer, v10));
            } finally {
                add(closeableList, MoreExecutors.directExecutor());
            }
        }

        @Override
        public void close() {
            if (this.closed) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    for (Map.Entry<AutoCloseable, Executor> entry : entrySet()) {
                        ClosingFuture.closeQuietly(entry.getKey(), entry.getValue());
                    }
                    clear();
                    if (this.whenClosed != null) {
                        this.whenClosed.countDown();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public CountDownLatch whenClosedCountDown() {
            if (this.closed) {
                return new CountDownLatch(0);
            }
            synchronized (this) {
                try {
                    if (this.closed) {
                        return new CountDownLatch(0);
                    }
                    AbstractC1332b.m3224o(this.whenClosed == null);
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.whenClosed = countDownLatch;
                    return countDownLatch;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public interface ClosingCallable<V> {
        @ParametricNullness
        V call(DeferredCloser deferredCloser) throws Exception;
    }

    public interface ClosingFunction<T, U> {
        @ParametricNullness
        U apply(DeferredCloser deferredCloser, @ParametricNullness T t5) throws Exception;
    }

    public static class Combiner {
        private final boolean allMustSucceed;
        private final CloseableList closeables;
        protected final AbstractC2301u1 inputs;

        public interface AsyncCombiningCallable<V> {
            ClosingFuture<V> call(DeferredCloser deferredCloser, Peeker peeker) throws Exception;
        }

        public interface CombiningCallable<V> {
            @ParametricNullness
            V call(DeferredCloser deferredCloser, Peeker peeker) throws Exception;
        }

        private Futures.FutureCombiner<Object> futureCombiner() {
            return this.allMustSucceed ? Futures.whenAllSucceed(inputFutures()) : Futures.whenAllComplete(inputFutures());
        }

        private AbstractC2301u1 inputFutures() {
            AbstractC2301u1 abstractC2301u1 = this.inputs;
            C2197f1 c2197f1 = new C2197f1(abstractC2301u1, abstractC2301u1);
            C1969m c1969m = new C1969m(3);
            Iterable iterable = (Iterable) c2197f1.f7916a.mo3209a(c2197f1);
            iterable.getClass();
            return AbstractC2301u1.m5271m(new C2268p2(iterable, c1969m));
        }

        public <V> ClosingFuture<V> call(final CombiningCallable<V> combiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(futureCombiner().call(new Callable<V>(this) {
                final Combiner this$0;

                {
                    this.this$0 = this;
                }

                @Override
                @ParametricNullness
                public V call() throws Exception {
                    return (V) new Peeker(this.this$0.inputs).call(combiningCallable, this.this$0.closeables);
                }

                public String toString() {
                    return combiningCallable.toString();
                }
            }, executor));
            ((ClosingFuture) closingFuture).closeables.add(this.closeables, MoreExecutors.directExecutor());
            return closingFuture;
        }

        public <V> ClosingFuture<V> callAsync(final AsyncCombiningCallable<V> asyncCombiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(futureCombiner().callAsync(new AsyncCallable<V>(this) {
                final Combiner this$0;

                {
                    this.this$0 = this;
                }

                @Override
                public ListenableFuture<V> call() throws Exception {
                    return new Peeker(this.this$0.inputs).callAsync(asyncCombiningCallable, this.this$0.closeables);
                }

                public String toString() {
                    return asyncCombiningCallable.toString();
                }
            }, executor));
            ((ClosingFuture) closingFuture).closeables.add(this.closeables, MoreExecutors.directExecutor());
            return closingFuture;
        }

        private Combiner(boolean z7, Iterable<? extends ClosingFuture<?>> iterable) {
            this.closeables = new CloseableList();
            this.allMustSucceed = z7;
            this.inputs = AbstractC2301u1.m5271m(iterable);
            Iterator<? extends ClosingFuture<?>> it = iterable.iterator();
            while (it.hasNext()) {
                it.next().becomeSubsumedInto(this.closeables);
            }
        }
    }

    public static final class Combiner2<V1, V2> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;

        public interface AsyncClosingFunction2<V1, V2, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, @ParametricNullness V1 v10, @ParametricNullness V2 v11) throws Exception;
        }

        public interface ClosingFunction2<V1, V2, U> {
            @ParametricNullness
            U apply(DeferredCloser deferredCloser, @ParametricNullness V1 v10, @ParametricNullness V2 v11) throws Exception;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction2<V1, V2, U> closingFunction2, Executor executor) {
            return call(new Combiner.CombiningCallable<U>(this) {
                final Combiner2 this$0;

                {
                    this.this$0 = this;
                }

                @Override
                @ParametricNullness
                public U call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return (U) closingFunction2.apply(deferredCloser, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2));
                }

                public String toString() {
                    return closingFunction2.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction2<V1, V2, U> asyncClosingFunction2, Executor executor) {
            return callAsync(new Combiner.AsyncCombiningCallable<U>(this) {
                final Combiner2 this$0;

                {
                    this.this$0 = this;
                }

                @Override
                public ClosingFuture<U> call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return asyncClosingFunction2.apply(deferredCloser, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2));
                }

                public String toString() {
                    return asyncClosingFunction2.toString();
                }
            }, executor);
        }

        private Combiner2(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
            super(true, AbstractC2301u1.m5276s(closingFuture, closingFuture2));
            this.future1 = closingFuture;
            this.future2 = closingFuture2;
        }
    }

    public static final class Combiner3<V1, V2, V3> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;

        public interface AsyncClosingFunction3<V1, V2, V3, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, @ParametricNullness V1 v10, @ParametricNullness V2 v11, @ParametricNullness V3 v12) throws Exception;
        }

        public interface ClosingFunction3<V1, V2, V3, U> {
            @ParametricNullness
            U apply(DeferredCloser deferredCloser, @ParametricNullness V1 v10, @ParametricNullness V2 v11, @ParametricNullness V3 v12) throws Exception;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction3<V1, V2, V3, U> closingFunction3, Executor executor) {
            return call(new Combiner.CombiningCallable<U>(this) {
                final Combiner3 this$0;

                {
                    this.this$0 = this;
                }

                @Override
                @ParametricNullness
                public U call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return (U) closingFunction3.apply(deferredCloser, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2), peeker.getDone(this.this$0.future3));
                }

                public String toString() {
                    return closingFunction3.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction3<V1, V2, V3, U> asyncClosingFunction3, Executor executor) {
            return callAsync(new Combiner.AsyncCombiningCallable<U>(this) {
                final Combiner3 this$0;

                {
                    this.this$0 = this;
                }

                @Override
                public ClosingFuture<U> call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return asyncClosingFunction3.apply(deferredCloser, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2), peeker.getDone(this.this$0.future3));
                }

                public String toString() {
                    return asyncClosingFunction3.toString();
                }
            }, executor);
        }

        private Combiner3(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
            super(true, AbstractC2301u1.m5277t(closingFuture, closingFuture2, closingFuture3));
            this.future1 = closingFuture;
            this.future2 = closingFuture2;
            this.future3 = closingFuture3;
        }
    }

    public static final class Combiner4<V1, V2, V3, V4> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;
        private final ClosingFuture<V4> future4;

        public interface AsyncClosingFunction4<V1, V2, V3, V4, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, @ParametricNullness V1 v10, @ParametricNullness V2 v11, @ParametricNullness V3 v12, @ParametricNullness V4 v13) throws Exception;
        }

        public interface ClosingFunction4<V1, V2, V3, V4, U> {
            @ParametricNullness
            U apply(DeferredCloser deferredCloser, @ParametricNullness V1 v10, @ParametricNullness V2 v11, @ParametricNullness V3 v12, @ParametricNullness V4 v13) throws Exception;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction4<V1, V2, V3, V4, U> closingFunction4, Executor executor) {
            return call(new Combiner.CombiningCallable<U>(this) {
                final Combiner4 this$0;

                {
                    this.this$0 = this;
                }

                @Override
                @ParametricNullness
                public U call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return (U) closingFunction4.apply(deferredCloser, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2), peeker.getDone(this.this$0.future3), peeker.getDone(this.this$0.future4));
                }

                public String toString() {
                    return closingFunction4.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction4<V1, V2, V3, V4, U> asyncClosingFunction4, Executor executor) {
            return callAsync(new Combiner.AsyncCombiningCallable<U>(this) {
                final Combiner4 this$0;

                {
                    this.this$0 = this;
                }

                @Override
                public ClosingFuture<U> call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return asyncClosingFunction4.apply(deferredCloser, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2), peeker.getDone(this.this$0.future3), peeker.getDone(this.this$0.future4));
                }

                public String toString() {
                    return asyncClosingFunction4.toString();
                }
            }, executor);
        }

        private Combiner4(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            Object[] objArr = {closingFuture, closingFuture2, closingFuture3, closingFuture4};
            AbstractC2182d0.m5139b(objArr, 4);
            super(true, AbstractC2301u1.m5268j(objArr, 4));
            this.future1 = closingFuture;
            this.future2 = closingFuture2;
            this.future3 = closingFuture3;
            this.future4 = closingFuture4;
        }
    }

    public static final class Combiner5<V1, V2, V3, V4, V5> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;
        private final ClosingFuture<V4> future4;
        private final ClosingFuture<V5> future5;

        public interface AsyncClosingFunction5<V1, V2, V3, V4, V5, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, @ParametricNullness V1 v10, @ParametricNullness V2 v11, @ParametricNullness V3 v12, @ParametricNullness V4 v13, @ParametricNullness V5 v14) throws Exception;
        }

        public interface ClosingFunction5<V1, V2, V3, V4, V5, U> {
            @ParametricNullness
            U apply(DeferredCloser deferredCloser, @ParametricNullness V1 v10, @ParametricNullness V2 v11, @ParametricNullness V3 v12, @ParametricNullness V4 v13, @ParametricNullness V5 v14) throws Exception;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction5<V1, V2, V3, V4, V5, U> closingFunction5, Executor executor) {
            return call(new Combiner.CombiningCallable<U>(this) {
                final Combiner5 this$0;

                {
                    this.this$0 = this;
                }

                @Override
                @ParametricNullness
                public U call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return (U) closingFunction5.apply(deferredCloser, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2), peeker.getDone(this.this$0.future3), peeker.getDone(this.this$0.future4), peeker.getDone(this.this$0.future5));
                }

                public String toString() {
                    return closingFunction5.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction5<V1, V2, V3, V4, V5, U> asyncClosingFunction5, Executor executor) {
            return callAsync(new Combiner.AsyncCombiningCallable<U>(this) {
                final Combiner5 this$0;

                {
                    this.this$0 = this;
                }

                @Override
                public ClosingFuture<U> call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return asyncClosingFunction5.apply(deferredCloser, peeker.getDone(this.this$0.future1), peeker.getDone(this.this$0.future2), peeker.getDone(this.this$0.future3), peeker.getDone(this.this$0.future4), peeker.getDone(this.this$0.future5));
                }

                public String toString() {
                    return asyncClosingFunction5.toString();
                }
            }, executor);
        }

        private Combiner5(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
            super(true, AbstractC2301u1.m5278u(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5));
            this.future1 = closingFuture;
            this.future2 = closingFuture2;
            this.future3 = closingFuture3;
            this.future4 = closingFuture4;
            this.future5 = closingFuture5;
        }
    }

    public static final class DeferredCloser {
        private final CloseableList list;

        public DeferredCloser(CloseableList closeableList) {
            this.list = closeableList;
        }

        @ParametricNullness
        public <C extends AutoCloseable> C eventuallyClose(@ParametricNullness C c5, Executor executor) {
            executor.getClass();
            if (c5 != null) {
                this.list.add(c5, executor);
            }
            return c5;
        }
    }

    public static final class Peeker {
        private volatile boolean beingCalled;
        private final AbstractC2301u1 futures;

        @ParametricNullness
        public <V> V call(Combiner.CombiningCallable<V> combiningCallable, CloseableList closeableList) throws Exception {
            this.beingCalled = true;
            CloseableList closeableList2 = new CloseableList();
            try {
                return combiningCallable.call(closeableList2.closer, this);
            } finally {
                closeableList.add(closeableList2, MoreExecutors.directExecutor());
                this.beingCalled = false;
            }
        }

        public <V> FluentFuture<V> callAsync(Combiner.AsyncCombiningCallable<V> asyncCombiningCallable, CloseableList closeableList) throws Exception {
            this.beingCalled = true;
            CloseableList closeableList2 = new CloseableList();
            try {
                ClosingFuture<V> closingFutureCall = asyncCombiningCallable.call(closeableList2.closer, this);
                closingFutureCall.becomeSubsumedInto(closeableList);
                return ((ClosingFuture) closingFutureCall).future;
            } finally {
                closeableList.add(closeableList2, MoreExecutors.directExecutor());
                this.beingCalled = false;
            }
        }

        @ParametricNullness
        public final <D> D getDone(ClosingFuture<D> closingFuture) throws ExecutionException {
            AbstractC1332b.m3224o(this.beingCalled);
            AbstractC1332b.m3215f(this.futures.contains(closingFuture));
            return (D) Futures.getDone(((ClosingFuture) closingFuture).future);
        }

        private Peeker(AbstractC2301u1 abstractC2301u1) {
            abstractC2301u1.getClass();
            this.futures = abstractC2301u1;
        }
    }

    public enum State {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    public static final class ValueAndCloser<V> {
        private final ClosingFuture<? extends V> closingFuture;

        public ValueAndCloser(ClosingFuture<? extends V> closingFuture) {
            closingFuture.getClass();
            this.closingFuture = closingFuture;
        }

        public void closeAsync() {
            this.closingFuture.close();
        }

        @ParametricNullness
        public V get() throws ExecutionException {
            return (V) Futures.getDone(((ClosingFuture) this.closingFuture).future);
        }
    }

    public interface ValueAndCloserConsumer<V> {
        void accept(ValueAndCloser<V> valueAndCloser);
    }

    public static FluentFuture access$000(ClosingFuture closingFuture) {
        return closingFuture.future;
    }

    public void becomeSubsumedInto(CloseableList closeableList) {
        checkAndUpdateState(State.OPEN, State.SUBSUMED);
        closeableList.add(this.closeables, MoreExecutors.directExecutor());
    }

    private <X extends Throwable, W extends V> ClosingFuture<V> catchingAsyncMoreGeneric(Class<X> cls, final AsyncClosingFunction<? super X, W> asyncClosingFunction, Executor executor) {
        asyncClosingFunction.getClass();
        return (ClosingFuture<V>) derive(this.future.catchingAsync(cls, new AsyncFunction<X, W>(this) {
            final ClosingFuture this$0;

            {
                this.this$0 = this;
            }

            public String toString() {
                return asyncClosingFunction.toString();
            }

            @Override
            public ListenableFuture apply(Throwable th) throws Exception {
                return this.this$0.closeables.applyAsyncClosingFunction(asyncClosingFunction, th);
            }
        }, executor));
    }

    private <X extends Throwable, W extends V> ClosingFuture<V> catchingMoreGeneric(Class<X> cls, final ClosingFunction<? super X, W> closingFunction, Executor executor) {
        closingFunction.getClass();
        return (ClosingFuture<V>) derive(this.future.catchingAsync(cls, new AsyncFunction<X, W>(this) {
            final ClosingFuture this$0;

            {
                this.this$0 = this;
            }

            public String toString() {
                return closingFunction.toString();
            }

            @Override
            public ListenableFuture apply(Throwable th) throws Exception {
                return this.this$0.closeables.applyClosingFunction(closingFunction, th);
            }
        }, executor));
    }

    public void checkAndUpdateState(State state, State state2) {
        if (!compareAndUpdateState(state, state2)) {
            throw new IllegalStateException(AbstractC1332b.m3228s("Expected state to be %s, but it was %s", state, state2));
        }
    }

    public void close() {
        logger.get().log(Level.FINER, "closing {0}", this);
        this.closeables.close();
    }

    public static void closeQuietly(AutoCloseable autoCloseable, Executor executor) {
        if (autoCloseable == null) {
            return;
        }
        try {
            executor.execute(new RunnableC1959c(3, autoCloseable));
        } catch (RejectedExecutionException e5) {
            LazyLogger lazyLogger = logger;
            Logger logger2 = lazyLogger.get();
            Level level = Level.WARNING;
            if (logger2.isLoggable(level)) {
                lazyLogger.get().log(level, String.format("while submitting close to %s; will close inline", executor), (Throwable) e5);
            }
            closeQuietly(autoCloseable, MoreExecutors.directExecutor());
        }
    }

    private boolean compareAndUpdateState(State state, State state2) {
        AtomicReference<State> atomicReference = this.state;
        while (!atomicReference.compareAndSet(state, state2)) {
            if (atomicReference.get() != state) {
                return false;
            }
        }
        return true;
    }

    private <U> ClosingFuture<U> derive(FluentFuture<U> fluentFuture) {
        ClosingFuture<U> closingFuture = new ClosingFuture<>(fluentFuture);
        becomeSubsumedInto(closingFuture.closeables);
        return closingFuture;
    }

    @Deprecated
    public static <C extends AutoCloseable> ClosingFuture<C> eventuallyClosing(ListenableFuture<C> listenableFuture, final Executor executor) {
        executor.getClass();
        ClosingFuture<C> closingFuture = new ClosingFuture<>(Futures.nonCancellationPropagating(listenableFuture));
        Futures.addCallback(listenableFuture, new FutureCallback<AutoCloseable>() {
            @Override
            public void onSuccess(AutoCloseable autoCloseable) {
                ClosingFuture.this.closeables.closer.eventuallyClose(autoCloseable, executor);
            }

            @Override
            public void onFailure(Throwable th) {
            }
        }, MoreExecutors.directExecutor());
        return closingFuture;
    }

    public static <V> ClosingFuture<V> from(ListenableFuture<V> listenableFuture) {
        return new ClosingFuture<>(listenableFuture);
    }

    public static void lambda$closeQuietly$0(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Exception e5) {
            Platform.restoreInterruptIfIsInterruptedException(e5);
            logger.get().log(Level.WARNING, "thrown by close()", (Throwable) e5);
        }
    }

    public static <C, V extends C> void provideValueAndCloser(ValueAndCloserConsumer<C> valueAndCloserConsumer, ClosingFuture<V> closingFuture) {
        valueAndCloserConsumer.accept(new ValueAndCloser<>(closingFuture));
    }

    public static <V> ClosingFuture<V> submit(final ClosingCallable<V> closingCallable, Executor executor) {
        closingCallable.getClass();
        final CloseableList closeableList = new CloseableList();
        TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(new Callable<V>() {
            @Override
            @ParametricNullness
            public V call() throws Exception {
                return (V) closingCallable.call(closeableList.closer);
            }

            public String toString() {
                return closingCallable.toString();
            }
        });
        executor.execute(trustedListenableFutureTaskCreate);
        return new ClosingFuture<>(trustedListenableFutureTaskCreate, closeableList);
    }

    public static <V> ClosingFuture<V> submitAsync(final AsyncClosingCallable<V> asyncClosingCallable, Executor executor) {
        asyncClosingCallable.getClass();
        final CloseableList closeableList = new CloseableList();
        TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(new AsyncCallable<V>() {
            @Override
            public ListenableFuture<V> call() throws Exception {
                CloseableList closeableList2 = new CloseableList();
                try {
                    ClosingFuture<V> closingFutureCall = asyncClosingCallable.call(closeableList2.closer);
                    closingFutureCall.becomeSubsumedInto(closeableList);
                    return ((ClosingFuture) closingFutureCall).future;
                } finally {
                    closeableList.add(closeableList2, MoreExecutors.directExecutor());
                }
            }

            public String toString() {
                return asyncClosingCallable.toString();
            }
        });
        executor.execute(trustedListenableFutureTaskCreate);
        return new ClosingFuture<>(trustedListenableFutureTaskCreate, closeableList);
    }

    public static Combiner whenAllComplete(ClosingFuture<?> closingFuture, ClosingFuture<?>... closingFutureArr) {
        return whenAllComplete(new C2320x2(closingFuture, closingFutureArr));
    }

    public static Combiner whenAllSucceed(Iterable<? extends ClosingFuture<?>> iterable) {
        return new Combiner(true, iterable);
    }

    public static <V, U> AsyncClosingFunction<V, U> withoutCloser(final AsyncFunction<V, U> asyncFunction) {
        asyncFunction.getClass();
        return new AsyncClosingFunction<V, U>() {
            @Override
            public ClosingFuture<U> apply(DeferredCloser deferredCloser, V v10) throws Exception {
                return ClosingFuture.from(asyncFunction.apply(v10));
            }
        };
    }

    public boolean cancel(boolean z7) {
        logger.get().log(Level.FINER, "cancelling {0}", this);
        boolean zCancel = this.future.cancel(z7);
        if (zCancel) {
            close();
        }
        return zCancel;
    }

    public <X extends Throwable> ClosingFuture<V> catching(Class<X> cls, ClosingFunction<? super X, ? extends V> closingFunction, Executor executor) {
        return catchingMoreGeneric(cls, closingFunction, executor);
    }

    public <X extends Throwable> ClosingFuture<V> catchingAsync(Class<X> cls, AsyncClosingFunction<? super X, ? extends V> asyncClosingFunction, Executor executor) {
        return catchingAsyncMoreGeneric(cls, asyncClosingFunction, executor);
    }

    public void finalize() {
        if (this.state.get().equals(State.OPEN)) {
            logger.get().log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            finishToFuture();
        }
    }

    public FluentFuture<V> finishToFuture() {
        if (compareAndUpdateState(State.OPEN, State.WILL_CLOSE)) {
            logger.get().log(Level.FINER, "will close {0}", this);
            this.future.addListener(new Runnable() {
                @Override
                public void run() {
                    ClosingFuture closingFuture = ClosingFuture.this;
                    State state = State.WILL_CLOSE;
                    State state2 = State.CLOSING;
                    closingFuture.checkAndUpdateState(state, state2);
                    ClosingFuture.this.close();
                    ClosingFuture.this.checkAndUpdateState(state2, State.CLOSED);
                }
            }, MoreExecutors.directExecutor());
        } else {
            int iOrdinal = this.state.get().ordinal();
            if (iOrdinal == 0) {
                throw new AssertionError();
            }
            if (iOrdinal == 1) {
                throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
            }
            if (iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4) {
                throw new IllegalStateException("Cannot call finishToFuture() twice");
            }
            if (iOrdinal == 5) {
                throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
            }
        }
        return this.future;
    }

    public void finishToValueAndCloser(final ValueAndCloserConsumer<? super V> valueAndCloserConsumer, Executor executor) {
        valueAndCloserConsumer.getClass();
        if (compareAndUpdateState(State.OPEN, State.WILL_CREATE_VALUE_AND_CLOSER)) {
            this.future.addListener(new Runnable(this) {
                final ClosingFuture this$0;

                {
                    this.this$0 = this;
                }

                @Override
                public void run() {
                    ClosingFuture.provideValueAndCloser(valueAndCloserConsumer, this.this$0);
                }
            }, executor);
            return;
        }
        int iOrdinal = this.state.get().ordinal();
        if (iOrdinal == 1) {
            throw new IllegalStateException("Cannot call finishToValueAndCloser() after deriving another step");
        }
        if (iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4) {
            throw new IllegalStateException("Cannot call finishToValueAndCloser() after calling finishToFuture()");
        }
        if (iOrdinal == 5) {
            throw new IllegalStateException("Cannot call finishToValueAndCloser() twice");
        }
        throw new AssertionError(this.state);
    }

    public ListenableFuture<?> statusFuture() {
        return Futures.nonCancellationPropagating(this.future.transform(new C1348j(), MoreExecutors.directExecutor()));
    }

    public String toString() {
        C0026b c0026bM3232w = AbstractC1332b.m3232w(this);
        c0026bM3232w.m127d(this.state.get(), "state");
        FluentFuture<V> fluentFuture = this.future;
        C0026b c0026b = new C0026b(13, false);
        ((C0026b) c0026bM3232w.f56d).f56d = c0026b;
        c0026bM3232w.f56d = c0026b;
        c0026b.f55c = fluentFuture;
        return c0026bM3232w.toString();
    }

    public <U> ClosingFuture<U> transform(final ClosingFunction<? super V, U> closingFunction, Executor executor) {
        closingFunction.getClass();
        return derive(this.future.transformAsync(new AsyncFunction<V, U>(this) {
            final ClosingFuture this$0;

            {
                this.this$0 = this;
            }

            @Override
            public ListenableFuture<U> apply(V v10) throws Exception {
                return this.this$0.closeables.applyClosingFunction(closingFunction, v10);
            }

            public String toString() {
                return closingFunction.toString();
            }
        }, executor));
    }

    public <U> ClosingFuture<U> transformAsync(final AsyncClosingFunction<? super V, U> asyncClosingFunction, Executor executor) {
        asyncClosingFunction.getClass();
        return derive(this.future.transformAsync(new AsyncFunction<V, U>(this) {
            final ClosingFuture this$0;

            {
                this.this$0 = this;
            }

            @Override
            public ListenableFuture<U> apply(V v10) throws Exception {
                return this.this$0.closeables.applyAsyncClosingFunction(asyncClosingFunction, v10);
            }

            public String toString() {
                return asyncClosingFunction.toString();
            }
        }, executor));
    }

    public CountDownLatch whenClosedCountDown() {
        return this.closeables.whenClosedCountDown();
    }

    private ClosingFuture(ListenableFuture<V> listenableFuture) {
        this(listenableFuture, new CloseableList());
    }

    public static <V1, V2> Combiner2<V1, V2> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
        return new Combiner2<>(closingFuture2);
    }

    private ClosingFuture(ListenableFuture<V> listenableFuture, CloseableList closeableList) {
        this.state = new AtomicReference<>(State.OPEN);
        this.future = FluentFuture.from(listenableFuture);
        this.closeables = closeableList;
    }

    public static Combiner whenAllComplete(Iterable<? extends ClosingFuture<?>> iterable) {
        return new Combiner(false, iterable);
    }

    public static <V1, V2, V3> Combiner3<V1, V2, V3> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
        return new Combiner3<>(closingFuture2, closingFuture3);
    }

    public static <V1, V2, V3, V4> Combiner4<V1, V2, V3, V4> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
        return new Combiner4<>(closingFuture2, closingFuture3, closingFuture4);
    }

    public static <V1, V2, V3, V4, V5> Combiner5<V1, V2, V3, V4, V5> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
        return new Combiner5<>(closingFuture2, closingFuture3, closingFuture4, closingFuture5);
    }

    public static Combiner whenAllSucceed(ClosingFuture<?> closingFuture, ClosingFuture<?> closingFuture2, ClosingFuture<?> closingFuture3, ClosingFuture<?> closingFuture4, ClosingFuture<?> closingFuture5, ClosingFuture<?> closingFuture6, ClosingFuture<?>... closingFutureArr) {
        C2320x2 c2320x2 = new C2320x2(closingFuture, new ClosingFuture[]{closingFuture2, closingFuture3, closingFuture4, closingFuture5, closingFuture6});
        C2197f1 c2197f1 = new C2197f1(c2320x2, c2320x2);
        Iterable[] iterableArr = {(Iterable) c2197f1.f7916a.mo3209a(c2197f1), Arrays.asList(closingFutureArr)};
        for (int i6 = 0; i6 < 2; i6++) {
            iterableArr[i6].getClass();
        }
        return whenAllSucceed(new C2197f1(iterableArr));
    }
}

package com.google.common.util.concurrent;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import p020b7.AbstractC1332b;
import p041d7.AbstractC2274q1;
import p041d7.AbstractC2292s5;

@ElementTypesAreNonnullByDefault
abstract class AggregateFuture<InputT, OutputT> extends AggregateFutureState<OutputT> {
    private static final LazyLogger logger = new LazyLogger(AggregateFuture.class);
    private final boolean allMustSucceed;
    private final boolean collectsValues;
    private AbstractC2274q1 futures;

    public enum ReleaseResourcesReason {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    public AggregateFuture(AbstractC2274q1 abstractC2274q1, boolean z7, boolean z10) {
        super(abstractC2274q1.size());
        this.futures = abstractC2274q1;
        this.allMustSucceed = z7;
        this.collectsValues = z10;
    }

    private static boolean addCausalChain(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    private void collectValueFromNonCancelledFuture(int i6, Future<? extends InputT> future) {
        try {
            collectOneValue(i6, Uninterruptibles.getUninterruptibly(future));
        } catch (ExecutionException e5) {
            handleException(e5.getCause());
        } catch (Throwable th) {
            handleException(th);
        }
    }

    public void lambda$init$1(AbstractC2274q1 abstractC2274q1) {
        int iDecrementRemainingAndGet = decrementRemainingAndGet();
        AbstractC1332b.m3223n("Less than 0 remaining futures", iDecrementRemainingAndGet >= 0);
        if (iDecrementRemainingAndGet == 0) {
            processCompleted(abstractC2274q1);
        }
    }

    private void handleException(Throwable th) {
        th.getClass();
        if (this.allMustSucceed && !setException(th) && addCausalChain(getOrInitSeenExceptions(), th)) {
            log(th);
        } else if (th instanceof Error) {
            log(th);
        }
    }

    private static void log(Throwable th) {
        logger.get().log(Level.SEVERE, th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    public void lambda$init$0(int i6, ListenableFuture<? extends InputT> listenableFuture) {
        try {
            if (listenableFuture.isCancelled()) {
                this.futures = null;
                cancel(false);
            } else {
                collectValueFromNonCancelledFuture(i6, listenableFuture);
            }
        } finally {
            lambda$init$1(null);
        }
    }

    private void processCompleted(AbstractC2274q1 abstractC2274q1) {
        if (abstractC2274q1 != null) {
            AbstractC2292s5 abstractC2292s5Mo5164i = abstractC2274q1.iterator();
            int i6 = 0;
            while (abstractC2292s5Mo5164i.hasNext()) {
                Future<? extends InputT> future = (Future) abstractC2292s5Mo5164i.next();
                if (!future.isCancelled()) {
                    collectValueFromNonCancelledFuture(i6, future);
                }
                i6++;
            }
        }
        clearSeenExceptions();
        handleAllCompleted();
        releaseResources(ReleaseResourcesReason.ALL_INPUT_FUTURES_PROCESSED);
    }

    @Override
    public final void addInitialException(Set<Throwable> set) {
        set.getClass();
        if (isCancelled()) {
            return;
        }
        Throwable thTryInternalFastPathGetFailure = tryInternalFastPathGetFailure();
        Objects.requireNonNull(thTryInternalFastPathGetFailure);
        addCausalChain(set, thTryInternalFastPathGetFailure);
    }

    @Override
    public final void afterDone() {
        super.afterDone();
        AbstractC2274q1 abstractC2274q1 = this.futures;
        releaseResources(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (abstractC2274q1 != null)) {
            boolean zWasInterrupted = wasInterrupted();
            AbstractC2292s5 abstractC2292s5Mo5164i = abstractC2274q1.iterator();
            while (abstractC2292s5Mo5164i.hasNext()) {
                ((Future) abstractC2292s5Mo5164i.next()).cancel(zWasInterrupted);
            }
        }
    }

    public abstract void collectOneValue(int i6, @ParametricNullness InputT inputt);

    public abstract void handleAllCompleted();

    public final void init() {
        Objects.requireNonNull(this.futures);
        if (this.futures.isEmpty()) {
            handleAllCompleted();
            return;
        }
        if (!this.allMustSucceed) {
            AbstractC2274q1 abstractC2274q1 = this.collectsValues ? this.futures : null;
            RunnableC1964h runnableC1964h = new RunnableC1964h(this, 0, abstractC2274q1);
            AbstractC2292s5 abstractC2292s5Mo5164i = this.futures.iterator();
            while (abstractC2292s5Mo5164i.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture) abstractC2292s5Mo5164i.next();
                if (listenableFuture.isDone()) {
                    lambda$init$1(abstractC2274q1);
                } else {
                    listenableFuture.addListener(runnableC1964h, MoreExecutors.directExecutor());
                }
            }
            return;
        }
        AbstractC2292s5 abstractC2292s5Mo5164i2 = this.futures.iterator();
        int i6 = 0;
        while (abstractC2292s5Mo5164i2.hasNext()) {
            ListenableFuture<? extends InputT> listenableFuture2 = (ListenableFuture) abstractC2292s5Mo5164i2.next();
            int i10 = i6 + 1;
            if (listenableFuture2.isDone()) {
                lambda$init$0(i6, listenableFuture2);
            } else {
                listenableFuture2.addListener(new RunnableC1963g(this, i6, listenableFuture2), MoreExecutors.directExecutor());
            }
            i6 = i10;
        }
    }

    @Override
    public final String pendingToString() {
        AbstractC2274q1 abstractC2274q1 = this.futures;
        if (abstractC2274q1 == null) {
            return super.pendingToString();
        }
        return "futures=" + abstractC2274q1;
    }

    public void releaseResources(ReleaseResourcesReason releaseResourcesReason) {
        releaseResourcesReason.getClass();
        this.futures = null;
    }
}

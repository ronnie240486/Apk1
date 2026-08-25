package com.google.common.util.concurrent;

import p041d7.C2180c5;

public final class RunnableC1963g implements Runnable {

    public final int f6972a = 0;

    public final int f6973b;

    public final Object f6974c;

    public final Object f6975d;

    public RunnableC1963g(AggregateFuture aggregateFuture, int i6, ListenableFuture listenableFuture) {
        this.f6974c = aggregateFuture;
        this.f6973b = i6;
        this.f6975d = listenableFuture;
    }

    @Override
    public final void run() {
        switch (this.f6972a) {
            case 0:
                ((AggregateFuture) this.f6974c).lambda$init$0(this.f6973b, (ListenableFuture) this.f6975d);
                break;
            default:
                Futures.InCompletionOrderState.access$600((Futures.InCompletionOrderState) this.f6974c, (C2180c5) this.f6975d, this.f6973b);
                break;
        }
    }

    public RunnableC1963g(Futures.InCompletionOrderState inCompletionOrderState, C2180c5 c2180c5, int i6) {
        this.f6974c = inCompletionOrderState;
        this.f6975d = c2180c5;
        this.f6973b = i6;
    }
}

package com.google.common.util.concurrent;

import p020b7.InterfaceC1339e0;
import p041d7.AbstractC2274q1;

public final class RunnableC1964h implements Runnable {

    public final int f6976a;

    public final Object f6977b;

    public final Object f6978c;

    public RunnableC1964h(Object obj, int i6, Object obj2) {
        this.f6976a = i6;
        this.f6977b = obj;
        this.f6978c = obj2;
    }

    @Override
    public final void run() {
        switch (this.f6976a) {
            case 0:
                ((AggregateFuture) this.f6977b).lambda$init$1((AbstractC2274q1) this.f6978c);
                break;
            default:
                Callables.lambda$threadRenaming$3((InterfaceC1339e0) this.f6977b, (Runnable) this.f6978c);
                break;
        }
    }
}

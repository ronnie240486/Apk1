package com.google.android.gms.internal.cast;

import android.content.Context;
import p173q1.C3451u0;

public final class RunnableC1658q implements Runnable {

    public final int f5543a;

    public final C1685t f5544b;

    public RunnableC1658q(C1685t c1685t, int i6) {
        this.f5543a = i6;
        this.f5544b = c1685t;
    }

    @Override
    public final void run() {
        switch (this.f5543a) {
            case 0:
                C1685t c1685t = this.f5544b;
                C1712w c1712w = c1685t.f5681e;
                if (((C3451u0) c1712w.f5715b) == null) {
                    c1712w.f5715b = C3451u0.m7069d((Context) c1712w.f5714a);
                }
                C3451u0 c3451u0 = (C3451u0) c1712w.f5715b;
                if (c3451u0 != null) {
                    c3451u0.m7075h(c1685t);
                }
                break;
            default:
                this.f5544b.m4022p();
                break;
        }
    }
}

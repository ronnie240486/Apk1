package com.google.android.gms.internal.cast;

import android.view.ViewGroup;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.C3320b;
import p002a1.C0026b;
import p101j7.C2782c;
import p173q1.C3424l0;

public final class RunnableC1631n implements Runnable {

    public final int f5416a;

    public final Object f5417b;

    public final Object f5418c;

    public RunnableC1631n(Object obj, int i6, Object obj2) {
        this.f5416a = i6;
        this.f5417b = obj;
        this.f5418c = obj2;
    }

    @Override
    public final void run() {
        switch (this.f5416a) {
            case 0:
                C1640o c1640o = (C1640o) ((C0026b) this.f5417b).f56d;
                if (c1640o.f5479f) {
                    ((ViewGroup) ((Spark) this.f5418c).getWindow().getDecorView()).removeView(c1640o);
                    C2782c c2782c = c1640o.f5476c;
                    if (c2782c != null) {
                        ((C3320b) c2782c.f9501b).f11207e = null;
                    }
                    c1640o.m3954a();
                }
                break;
            case 1:
                C1640o c1640o2 = (C1640o) ((C0026b) this.f5417b).f56d;
                if (c1640o2.f5479f) {
                    ((ViewGroup) ((Spark) this.f5418c).getWindow().getDecorView()).removeView(c1640o2);
                    C2782c c2782c2 = c1640o2.f5476c;
                    if (c2782c2 != null) {
                        ((C3320b) c2782c2.f9501b).f11207e = null;
                    }
                    c1640o2.m3954a();
                }
                break;
            default:
                ((BinderC1703v) this.f5417b).m4028A((C3424l0) this.f5418c);
                break;
        }
    }
}

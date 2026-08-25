package com.google.android.gms.internal.cast;

import android.util.Log;
import java.util.HashSet;
import p018b5.AbstractC1312l;
import p025c2.C1381b;
import p176q4.C3482h;
import p230v4.C3988b;

public final class RunnableC1721x implements Runnable {

    public final int f5720a;

    public final C1730y f5721b;

    public RunnableC1721x(C1730y c1730y, int i6) {
        this.f5720a = i6;
        this.f5721b = c1730y;
    }

    @Override
    public final void run() {
        C1730y c1730y = this.f5721b;
        int i6 = 2;
        switch (this.f5720a) {
            case 0:
                c1730y.getClass();
                C3988b c3988b = C1730y.f5727g;
                Log.i(c3988b.f13521a, c3988b.m7977d("transfer with type = %d has timed out", 0));
                c3988b.m7975b("notify failed transfer with type = %d, reason = %d", 0, 101);
                for (C1594j2 c1594j2 : new HashSet(c1730y.f5729b)) {
                    switch (c1594j2.f5363a) {
                        case 0:
                            C1624m2.f5407i.m7975b("onTransferFailed with type = %d and reason = %d", 0, 101);
                            C1624m2 c1624m2 = (C1624m2) c1594j2.f5364b;
                            c1624m2.m3934c();
                            C1575h3 c1575h3M3971b = c1624m2.f5410c.m3971b(c1624m2.f5414g);
                            C1515b3 c1515b3M3745m = C1525c3.m3745m(c1575h3M3971b.m3837d());
                            c1515b3M3745m.m3841c();
                            C1525c3.m3756x((C1525c3) c1515b3M3745m.f5338b);
                            c1515b3M3745m.m3841c();
                            C1525c3.m3755w((C1525c3) c1515b3M3745m.f5338b);
                            c1575h3M3971b.m3838e((C1525c3) c1515b3M3745m.m3839a());
                            c1624m2.f5408a.m4015a((C1585i3) c1575h3M3971b.m3839a(), 232);
                            break;
                        default:
                            C1552f0 c1552f0 = new C1552f0(11);
                            c1552f0.f5292b = 101;
                            C1381b c1381b = (C1381b) c1594j2.f5364b;
                            c1552f0.f5293c = Boolean.valueOf(((BinderC1571h) c1381b.f4199c).f5332f == 2);
                            C1381b.m3250k(c1381b, new C1562g0(c1552f0));
                            break;
                    }
                }
                c1730y.m4055a();
                break;
            default:
                C1675r7 c1675r7 = new C1675r7(i6, c1730y);
                C3482h c3482h = c1730y.f5733f;
                AbstractC1312l.m3198e(c3482h);
                c3482h.m7140a(c1675r7);
                break;
        }
    }
}

package com.google.android.gms.internal.cast;

import android.os.Parcel;
import p018b5.AbstractC1312l;
import p176q4.C3473b;
import p230v4.C3988b;
import p242w5.C4056d;
import p271z4.InterfaceC4340k;

public final class C1661q2 implements InterfaceC1693t7, InterfaceC1659q0, InterfaceC4340k, InterfaceC1651p1 {

    public static final C1661q2 f5550b = new C1661q2(0);

    public static final C1661q2 f5551c = new C1661q2(1);

    public static final C1661q2 f5552d = new C1661q2(2);

    public static final C1661q2 f5553e = new C1661q2(3);

    public static final C1661q2 f5554f = new C1661q2(4);

    public static final C1661q2 f5555g = new C1661q2(5);

    public static final C1661q2 f5556h = new C1661q2(6);

    public static final C1661q2 f5557i = new C1661q2(7);

    public static final C1661q2 f5558j = new C1661q2(8);

    public static final C1661q2 f5559k = new C1661q2(9);

    public static final C1661q2 f5560l = new C1661q2(10);

    public static final C1661q2 f5561m = new C1661q2(11);

    public static final C1661q2 f5562n = new C1661q2(12);

    public static final C1661q2 f5563o = new C1661q2(13);

    public static final C1661q2 f5564p = new C1661q2(14);

    public static final C1661q2 f5565q = new C1661q2(16);

    public static final C1661q2 f5566r = new C1661q2(17);

    public final int f5567a;

    public C1661q2(int i6) {
        this.f5567a = i6;
    }

    public static void m3974b(Object obj) {
        C1550e8 c1550e8 = ((AbstractC1589i7) obj).zzc;
        if (c1550e8.f5290d) {
            c1550e8.f5290d = false;
        }
    }

    @Override
    public void mo3972a() {
    }

    @Override
    public C1510a8 mo3975c(Class cls) {
        switch (this.f5567a) {
            case 14:
                if (!AbstractC1589i7.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (C1510a8) AbstractC1589i7.m3865k(cls.asSubclass(AbstractC1589i7.class)).mo3714h(3, null);
                } catch (Exception e5) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e5);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override
    public boolean mo3976e(Class cls) {
        switch (this.f5567a) {
            case 14:
                return AbstractC1589i7.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }

    @Override
    public void mo99p(Object obj, Object obj2) {
        BinderC1513b1 binderC1513b1 = new BinderC1513b1((C4056d) obj2);
        C1573h1 c1573h1 = (C1573h1) ((C1593j1) obj).m3663p();
        Parcel parcelM3687l = c1573h1.m3687l();
        AbstractC1542e0.m3810d(parcelM3687l, binderC1513b1);
        c1573h1.m3689x(parcelM3687l, 2);
    }

    public C1661q2(C1523c1 c1523c1) {
        this.f5567a = 20;
    }

    @Override
    public Object mo3969a() {
        switch (this.f5567a) {
            case 21:
                throw new IllegalStateException();
            default:
                C3988b c3988b = C1540d8.f5253v;
                C3988b c3988b2 = C3473b.f11740k;
                AbstractC1312l.m3195b("Must be called from the main thread.");
                C3473b c3473b = C3473b.f11742m;
                AbstractC1312l.m3198e(c3473b);
                AbstractC1312l.m3195b("Must be called from the main thread.");
                return c3473b.f11747e.f4763a;
        }
    }
}

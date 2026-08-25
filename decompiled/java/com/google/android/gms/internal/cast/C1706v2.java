package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.RandomAccess;

public final class C1706v2 extends AbstractC1589i7 {
    private static final C1706v2 zzb;
    private int zzd;
    private C1742z2 zze;
    private C1654p4 zzf;
    private InterfaceC1629m7 zzg = C1747z7.f5747e;
    private InterfaceC1609k7 zzh = C1599j7.f5369e;

    static {
        C1706v2 c1706v2 = new C1706v2();
        zzb = c1706v2;
        AbstractC1589i7.m3864e(C1706v2.class, c1706v2);
    }

    public static C1697u2 m4033l() {
        return (C1697u2) zzb.m3871j();
    }

    public static void m4034m(C1706v2 c1706v2, ArrayList arrayList) {
        RandomAccess randomAccess = c1706v2.zzh;
        if (!((AbstractC1737y6) randomAccess).f5737a) {
            C1599j7 c1599j7 = (C1599j7) randomAccess;
            int i6 = c1599j7.f5371c;
            c1706v2.zzh = c1599j7.mo3876a(i6 + i6);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            EnumC1679s2 enumC1679s2 = (EnumC1679s2) it.next();
            ((C1599j7) c1706v2.zzh).m3879g(enumC1679s2.f5672a);
        }
    }

    public static void m4035n(C1706v2 c1706v2, C1742z2 c1742z2) {
        c1706v2.zze = c1742z2;
        c1706v2.zzd |= 1;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004ࠞ", new Object[]{"zzd", "zze", "zzf", "zzg", C1606k4.class, "zzh", C1661q2.f5557i});
        }
        if (i10 == 3) {
            return new C1706v2();
        }
        if (i10 == 4) {
            return new C1697u2(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

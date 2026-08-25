package com.google.android.gms.internal.cast;

public final class C1625m3 extends AbstractC1589i7 {
    private static final C1625m3 zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        C1625m3 c1625m3 = new C1625m3();
        zzb = c1625m3;
        AbstractC1589i7.m3864e(C1625m3.class, c1625m3);
    }

    public static C1615l3 m3940l() {
        return (C1615l3) zzb.m3871j();
    }

    public static void m3941m(C1625m3 c1625m3, int i6) {
        c1625m3.zzd |= 2;
        c1625m3.zzf = i6;
    }

    public static void m3942n(C1625m3 c1625m3, int i6) {
        c1625m3.zze = i6 - 1;
        c1625m3.zzd |= 1;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001", new Object[]{"zzd", "zze", C1643o2.f5486A, "zzf"});
        }
        if (i10 == 3) {
            return new C1625m3();
        }
        if (i10 == 4) {
            return new C1615l3(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

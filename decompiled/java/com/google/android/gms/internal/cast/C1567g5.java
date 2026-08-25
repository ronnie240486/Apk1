package com.google.android.gms.internal.cast;

public final class C1567g5 extends AbstractC1589i7 {
    private static final C1567g5 zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        C1567g5 c1567g5 = new C1567g5();
        zzb = c1567g5;
        AbstractC1589i7.m3864e(C1567g5.class, c1567g5);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            C1643o2 c1643o2 = C1643o2.f5506q;
            return new C1510a8(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", c1643o2, "zzf", c1643o2});
        }
        if (i10 == 3) {
            return new C1567g5();
        }
        if (i10 == 4) {
            return new C1626m4(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

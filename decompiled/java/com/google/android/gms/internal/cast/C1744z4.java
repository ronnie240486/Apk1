package com.google.android.gms.internal.cast;

public final class C1744z4 extends AbstractC1589i7 {
    private static final C1744z4 zzb;
    private int zzd;
    private int zze;

    static {
        C1744z4 c1744z4 = new C1744z4();
        zzb = c1744z4;
        AbstractC1589i7.m3864e(C1744z4.class, c1744z4);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", C1661q2.f5561m});
        }
        if (i10 == 3) {
            return new C1744z4();
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

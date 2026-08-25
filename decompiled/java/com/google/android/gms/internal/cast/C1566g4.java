package com.google.android.gms.internal.cast;

public final class C1566g4 extends AbstractC1589i7 {
    private static final C1566g4 zzb;
    private int zzd;
    private int zze;

    static {
        C1566g4 c1566g4 = new C1566g4();
        zzb = c1566g4;
        AbstractC1589i7.m3864e(C1566g4.class, c1566g4);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", C1643o2.f5490a});
        }
        if (i10 == 3) {
            return new C1566g4();
        }
        if (i10 == 4) {
            return new C1521c(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

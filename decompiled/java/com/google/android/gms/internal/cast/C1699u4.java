package com.google.android.gms.internal.cast;

public final class C1699u4 extends AbstractC1589i7 {
    private static final C1699u4 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        C1699u4 c1699u4 = new C1699u4();
        zzb = c1699u4;
        AbstractC1589i7.m3864e(C1699u4.class, c1699u4);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i10 == 3) {
            return new C1699u4();
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

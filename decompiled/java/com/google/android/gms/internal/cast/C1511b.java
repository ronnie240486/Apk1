package com.google.android.gms.internal.cast;

public final class C1511b extends AbstractC1589i7 {
    private static final C1511b zzb;
    private int zzd;
    private double zze;
    private int zzf;
    private int zzg;

    static {
        C1511b c1511b = new C1511b();
        zzb = c1511b;
        AbstractC1589i7.m3864e(C1511b.class, c1511b);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001က\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", C1636n4.f5448c, "zzg", C1636n4.f5447b});
        }
        if (i10 == 3) {
            return new C1511b();
        }
        if (i10 == 4) {
            return new C1709v5(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

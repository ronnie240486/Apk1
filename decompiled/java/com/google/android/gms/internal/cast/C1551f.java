package com.google.android.gms.internal.cast;

public final class C1551f extends AbstractC1589i7 {
    private static final C1551f zzb;
    private int zzd;
    private long zze;
    private long zzf;
    private int zzg;

    static {
        C1551f c1551f = new C1551f();
        zzb = c1551f;
        AbstractC1589i7.m3864e(C1551f.class, c1551f);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i10 == 3) {
            return new C1551f();
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

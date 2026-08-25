package com.google.android.gms.internal.cast;

public final class C1745z5 extends AbstractC1589i7 {
    private static final C1745z5 zzb;
    private int zzd;
    private String zze = "";
    private long zzf;
    private long zzg;
    private C1508a6 zzh;

    static {
        C1745z5 c1745z5 = new C1745z5();
        zzb = c1745z5;
        AbstractC1589i7.m3864e(C1745z5.class, c1745z5);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i10 == 3) {
            return new C1745z5();
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

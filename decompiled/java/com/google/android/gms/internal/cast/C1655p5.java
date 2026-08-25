package com.google.android.gms.internal.cast;

public final class C1655p5 extends AbstractC1589i7 {
    private static final C1655p5 zzb;
    private int zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;

    static {
        C1655p5 c1655p5 = new C1655p5();
        zzb = c1655p5;
        AbstractC1589i7.m3864e(C1655p5.class, c1655p5);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i10 == 3) {
            return new C1655p5();
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

package com.google.android.gms.internal.cast;

public final class C1505a3 extends AbstractC1589i7 {
    private static final C1505a3 zzb;
    private int zzd;
    private String zze = "";
    private long zzf;

    static {
        C1505a3 c1505a3 = new C1505a3();
        zzb = c1505a3;
        AbstractC1589i7.m3864e(C1505a3.class, c1505a3);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i10 == 3) {
            return new C1505a3();
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

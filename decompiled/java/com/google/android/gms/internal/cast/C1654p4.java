package com.google.android.gms.internal.cast;

public final class C1654p4 extends AbstractC1589i7 {
    private static final C1654p4 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        C1654p4 c1654p4 = new C1654p4();
        zzb = c1654p4;
        AbstractC1589i7.m3864e(C1654p4.class, c1654p4);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i10 == 3) {
            return new C1654p4();
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

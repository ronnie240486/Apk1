package com.google.android.gms.internal.cast;

public final class C1698u3 extends AbstractC1589i7 {
    private static final C1698u3 zzb;
    private int zzd;
    private String zze = "";
    private long zzf;

    static {
        C1698u3 c1698u3 = new C1698u3();
        zzb = c1698u3;
        AbstractC1589i7.m3864e(C1698u3.class, c1698u3);
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
            return new C1698u3();
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

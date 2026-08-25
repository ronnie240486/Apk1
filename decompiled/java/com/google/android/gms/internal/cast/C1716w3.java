package com.google.android.gms.internal.cast;

public final class C1716w3 extends AbstractC1589i7 {
    private static final C1716w3 zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        C1716w3 c1716w3 = new C1716w3();
        zzb = c1716w3;
        AbstractC1589i7.m3864e(C1716w3.class, c1716w3);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", C1636n4.f5468w, "zzf", C1636n4.f5467v});
        }
        if (i10 == 3) {
            return new C1716w3();
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

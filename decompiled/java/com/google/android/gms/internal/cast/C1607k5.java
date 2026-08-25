package com.google.android.gms.internal.cast;

public final class C1607k5 extends AbstractC1589i7 {
    private static final C1607k5 zzb;
    private int zzd;
    private C1715w2 zze;

    static {
        C1607k5 c1607k5 = new C1607k5();
        zzb = c1607k5;
        AbstractC1589i7.m3864e(C1607k5.class, c1607k5);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i10 == 3) {
            return new C1607k5();
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

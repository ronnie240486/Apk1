package com.google.android.gms.internal.cast;

public final class C1630m8 extends AbstractC1589i7 {
    private static final C1630m8 zzb;
    private int zzd;
    private C1541e zze;
    private int zzf;
    private int zzg;

    static {
        C1630m8 c1630m8 = new C1630m8();
        zzb = c1630m8;
        AbstractC1589i7.m3864e(C1630m8.class, c1630m8);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", C1661q2.f5566r, "zzg", C1661q2.f5565q});
        }
        if (i10 == 3) {
            return new C1630m8();
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

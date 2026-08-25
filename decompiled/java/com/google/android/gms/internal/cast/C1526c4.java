package com.google.android.gms.internal.cast;

public final class C1526c4 extends AbstractC1589i7 {
    private static final C1526c4 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private InterfaceC1629m7 zzh = C1747z7.f5747e;

    static {
        C1526c4 c1526c4 = new C1526c4();
        zzb = c1526c4;
        AbstractC1589i7.m3864e(C1526c4.class, c1526c4);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", C1516b4.class});
        }
        if (i10 == 3) {
            return new C1526c4();
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

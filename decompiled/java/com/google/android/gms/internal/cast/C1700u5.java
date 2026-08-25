package com.google.android.gms.internal.cast;

public final class C1700u5 extends AbstractC1589i7 {
    private static final C1700u5 zzb;
    private int zzd;
    private int zze;
    private InterfaceC1629m7 zzf;
    private InterfaceC1629m7 zzg;
    private int zzh;

    static {
        C1700u5 c1700u5 = new C1700u5();
        zzb = c1700u5;
        AbstractC1589i7.m3864e(C1700u5.class, c1700u5);
    }

    public C1700u5() {
        C1747z7 c1747z7 = C1747z7.f5747e;
        this.zzf = c1747z7;
        this.zzg = c1747z7;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001᠌\u0000\u0002\u001b\u0003\u001b\u0004င\u0001", new Object[]{"zzd", "zze", C1661q2.f5552d, "zzf", C1708v4.class, "zzg", C1708v4.class, "zzh"});
        }
        if (i10 == 3) {
            return new C1700u5();
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

package com.google.android.gms.internal.cast;

public final class C1673r5 extends AbstractC1589i7 {
    private static final C1673r5 zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private InterfaceC1629m7 zzg;
    private InterfaceC1629m7 zzh;

    static {
        C1673r5 c1673r5 = new C1673r5();
        zzb = c1673r5;
        AbstractC1589i7.m3864e(C1673r5.class, c1673r5);
    }

    public C1673r5() {
        C1747z7 c1747z7 = C1747z7.f5747e;
        this.zzg = c1747z7;
        this.zzh = c1747z7;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003\u001b\u0004\u001b", new Object[]{"zzd", "zze", C1643o2.f5513x, "zzf", "zzg", C1655p5.class, "zzh", C1664q5.class});
        }
        if (i10 == 3) {
            return new C1673r5();
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

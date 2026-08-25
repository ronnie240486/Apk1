package com.google.android.gms.internal.cast;

public final class C1664q5 extends AbstractC1589i7 {
    private static final C1664q5 zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private InterfaceC1629m7 zzg;
    private InterfaceC1629m7 zzh;
    private InterfaceC1629m7 zzi;

    static {
        C1664q5 c1664q5 = new C1664q5();
        zzb = c1664q5;
        AbstractC1589i7.m3864e(C1664q5.class, c1664q5);
    }

    public C1664q5() {
        C1747z7 c1747z7 = C1747z7.f5747e;
        this.zzg = c1747z7;
        this.zzh = c1747z7;
        this.zzi = c1747z7;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003\u001b\u0004\u001b\u0005\u001b", new Object[]{"zzd", "zze", C1643o2.f5512w, "zzf", "zzg", C1627m5.class, "zzh", C1605k3.class, "zzi", C1655p5.class});
        }
        if (i10 == 3) {
            return new C1664q5();
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

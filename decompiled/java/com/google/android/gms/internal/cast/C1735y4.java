package com.google.android.gms.internal.cast;

public final class C1735y4 extends AbstractC1589i7 {
    private static final C1735y4 zzb;
    private int zzd;
    private InterfaceC1629m7 zze;
    private InterfaceC1629m7 zzf;
    private C1607k5 zzg;

    static {
        C1735y4 c1735y4 = new C1735y4();
        zzb = c1735y4;
        AbstractC1589i7.m3864e(C1735y4.class, c1735y4);
    }

    public C1735y4() {
        C1747z7 c1747z7 = C1747z7.f5747e;
        this.zze = c1747z7;
        this.zzf = c1747z7;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003ဉ\u0000", new Object[]{"zzd", "zze", C1691t5.class, "zzf", C1734y3.class, "zzg"});
        }
        if (i10 == 3) {
            return new C1735y4();
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

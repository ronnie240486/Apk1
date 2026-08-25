package com.google.android.gms.internal.cast;

public final class C1557f5 extends AbstractC1589i7 {
    private static final C1557f5 zzb;
    private int zzd;
    private C1531d zze;
    private InterfaceC1629m7 zzf;
    private InterfaceC1629m7 zzg;
    private InterfaceC1629m7 zzh;
    private String zzi;
    private long zzj;
    private int zzk;

    static {
        C1557f5 c1557f5 = new C1557f5();
        zzb = c1557f5;
        AbstractC1589i7.m3864e(C1557f5.class, c1557f5);
    }

    public C1557f5() {
        C1747z7 c1747z7 = C1747z7.f5747e;
        this.zzf = c1747z7;
        this.zzg = c1747z7;
        this.zzh = c1747z7;
        this.zzi = "";
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0003\u0000\u0001ဉ\u0000\u0002\u001a\u0003\u001b\u0004\u001b\u0005ဈ\u0001\u0006ဂ\u0002\u0007᠌\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", C1505a3.class, "zzh", C1517b5.class, "zzi", "zzj", "zzk", C1661q2.f5560l});
        }
        if (i10 == 3) {
            return new C1557f5();
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

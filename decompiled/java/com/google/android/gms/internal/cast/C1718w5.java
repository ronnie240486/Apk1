package com.google.android.gms.internal.cast;

public final class C1718w5 extends AbstractC1589i7 {
    private static final C1718w5 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private InterfaceC1629m7 zzg;
    private InterfaceC1629m7 zzh;
    private int zzi;
    private InterfaceC1609k7 zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        C1718w5 c1718w5 = new C1718w5();
        zzb = c1718w5;
        AbstractC1589i7.m3864e(C1718w5.class, c1718w5);
    }

    public C1718w5() {
        C1747z7 c1747z7 = C1747z7.f5747e;
        this.zzg = c1747z7;
        this.zzh = c1747z7;
        this.zzj = C1599j7.f5369e;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            C1661q2 c1661q2 = C1661q2.f5553e;
            return new C1510a8(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003\u001b\u0004\u001b\u0005᠌\u0002\u0006ࠬ\u0007ဇ\u0003\bဇ\u0004", new Object[]{"zzd", "zze", c1661q2, "zzf", C1661q2.f5554f, "zzg", C1506a4.class, "zzh", C1506a4.class, "zzi", C1636n4.f5442A, "zzj", c1661q2, "zzk", "zzl"});
        }
        if (i10 == 3) {
            return new C1718w5();
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

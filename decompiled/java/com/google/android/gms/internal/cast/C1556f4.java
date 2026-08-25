package com.google.android.gms.internal.cast;

public final class C1556f4 extends AbstractC1589i7 {
    private static final C1556f4 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private InterfaceC1609k7 zzg;
    private InterfaceC1609k7 zzh;
    private InterfaceC1629m7 zzi;
    private InterfaceC1629m7 zzj;
    private int zzk;

    static {
        C1556f4 c1556f4 = new C1556f4();
        zzb = c1556f4;
        AbstractC1589i7.m3864e(C1556f4.class, c1556f4);
    }

    public C1556f4() {
        C1599j7 c1599j7 = C1599j7.f5369e;
        this.zzg = c1599j7;
        this.zzh = c1599j7;
        C1747z7 c1747z7 = C1747z7.f5747e;
        this.zzi = c1747z7;
        this.zzj = c1747z7;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001င\u0000\u0002᠌\u0001\u0003\u0016\u0004\u0016\u0005\u001a\u0006\u001a\u0007᠌\u0002", new Object[]{"zzd", "zze", "zzf", C1643o2.f5490a, "zzg", "zzh", "zzi", "zzj", "zzk", C1636n4.f5442A});
        }
        if (i10 == 3) {
            return new C1556f4();
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

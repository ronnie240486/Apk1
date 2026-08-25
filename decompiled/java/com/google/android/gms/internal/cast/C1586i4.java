package com.google.android.gms.internal.cast;

public final class C1586i4 extends AbstractC1589i7 {
    private static final C1586i4 zzb;
    private int zzd;
    private InterfaceC1629m7 zze = C1747z7.f5747e;
    private boolean zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;

    static {
        C1586i4 c1586i4 = new C1586i4();
        zzb = c1586i4;
        AbstractC1589i7.m3864e(C1586i4.class, c1586i4);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002ဇ\u0000\u0003ဇ\u0001\u0004ဂ\u0002\u0005ဂ\u0003\u0006ဂ\u0004\u0007ဇ\u0005", new Object[]{"zzd", "zze", C1546e4.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i10 == 3) {
            return new C1586i4();
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

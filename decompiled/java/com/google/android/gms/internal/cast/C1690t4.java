package com.google.android.gms.internal.cast;

public final class C1690t4 extends AbstractC1589i7 {
    private static final C1690t4 zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    static {
        C1690t4 c1690t4 = new C1690t4();
        zzb = c1690t4;
        AbstractC1589i7.m3864e(C1690t4.class, c1690t4);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            C1643o2 c1643o2 = C1643o2.f5501l;
            return new C1510a8(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", c1643o2, "zzj", c1643o2, "zzk"});
        }
        if (i10 == 3) {
            return new C1690t4();
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

package com.google.android.gms.internal.cast;

public final class C1645o4 extends AbstractC1589i7 {
    private static final C1645o4 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private boolean zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    static {
        C1645o4 c1645o4 = new C1645o4();
        zzb = c1645o4;
        AbstractC1589i7.m3864e(C1645o4.class, c1645o4);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", C1643o2.f5495f, "zzi", C1643o2.f5497h, "zzj", C1643o2.f5496g, "zzk", C1643o2.f5498i});
        }
        if (i10 == 3) {
            return new C1645o4();
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

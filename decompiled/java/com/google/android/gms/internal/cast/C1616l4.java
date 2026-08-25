package com.google.android.gms.internal.cast;

public final class C1616l4 extends AbstractC1589i7 {
    private static final C1616l4 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private byte zzh = 2;

    static {
        C1616l4 c1616l4 = new C1616l4();
        zzb = c1616l4;
        AbstractC1589i7.m3864e(C1616l4.class, c1616l4);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ᴌ\u0000\u0002င\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", C1643o2.f5494e, "zzf", "zzg", C1661q2.f5559k});
        }
        if (i10 == 3) {
            return new C1616l4();
        }
        if (i10 == 4) {
            return new C1521c(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzh = abstractC1589i7 == null ? (byte) 0 : (byte) 1;
        return null;
    }
}

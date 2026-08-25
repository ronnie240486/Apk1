package com.google.android.gms.internal.cast;

public final class C1680s3 extends AbstractC1589i7 {
    private static final C1680s3 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        C1680s3 c1680s3 = new C1680s3();
        zzb = c1680s3;
        AbstractC1589i7.m3864e(C1680s3.class, c1680s3);
    }

    public static C1671r3 m4016l() {
        return (C1671r3) zzb.m3871j();
    }

    public static void m4017m(C1680s3 c1680s3, int i6) {
        c1680s3.zzd |= 2;
        c1680s3.zzf = i6;
    }

    public static void m4018n(C1680s3 c1680s3, int i6) {
        c1680s3.zzd |= 4;
        c1680s3.zzg = i6;
    }

    public static void m4019o(C1680s3 c1680s3, int i6) {
        c1680s3.zzd |= 8;
        c1680s3.zzh = i6;
    }

    public static void m4020p(C1680s3 c1680s3, int i6) {
        c1680s3.zze = i6 - 1;
        c1680s3.zzd |= 1;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzd", "zze", C1643o2.f5488C, "zzf", "zzg", "zzh"});
        }
        if (i10 == 3) {
            return new C1680s3();
        }
        if (i10 == 4) {
            return new C1671r3(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

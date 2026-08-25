package com.google.android.gms.internal.cast;

public final class C1605k3 extends AbstractC1589i7 {
    private static final C1605k3 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        C1605k3 c1605k3 = new C1605k3();
        zzb = c1605k3;
        AbstractC1589i7.m3864e(C1605k3.class, c1605k3);
    }

    public static C1595j3 m3917l() {
        return (C1595j3) zzb.m3871j();
    }

    public static void m3918m(C1605k3 c1605k3, int i6) {
        c1605k3.zzd |= 16;
        c1605k3.zzi = i6;
    }

    public static void m3919n(C1605k3 c1605k3, int i6) {
        c1605k3.zzd |= 2;
        c1605k3.zzf = i6;
    }

    public static void m3920o(C1605k3 c1605k3, int i6) {
        c1605k3.zzd |= 8;
        c1605k3.zzh = i6;
    }

    public static void m3921p(C1605k3 c1605k3, int i6) {
        c1605k3.zzd |= 4;
        c1605k3.zzg = i6;
    }

    public static void m3922q(C1605k3 c1605k3, int i6) {
        c1605k3.zze = i6 - 1;
        c1605k3.zzd |= 1;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzd", "zze", C1643o2.f5515z, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i10 == 3) {
            return new C1605k3();
        }
        if (i10 == 4) {
            return new C1595j3(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

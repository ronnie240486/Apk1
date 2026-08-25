package com.google.android.gms.internal.cast;

public final class C1644o3 extends AbstractC1589i7 {
    private static final C1644o3 zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;

    static {
        C1644o3 c1644o3 = new C1644o3();
        zzb = c1644o3;
        AbstractC1589i7.m3864e(C1644o3.class, c1644o3);
    }

    public static C1635n3 m3956l() {
        return (C1635n3) zzb.m3871j();
    }

    public static void m3957m(C1644o3 c1644o3, boolean z7) {
        c1644o3.zzd |= 8;
        c1644o3.zzh = z7;
    }

    public static void m3958n(C1644o3 c1644o3, int i6) {
        c1644o3.zzd |= 4;
        c1644o3.zzg = i6;
    }

    public static void m3959o(C1644o3 c1644o3, long j10) {
        c1644o3.zzd |= 16;
        c1644o3.zzi = j10;
    }

    public static void m3960p(C1644o3 c1644o3, int i6) {
        c1644o3.zzd |= 2;
        c1644o3.zzf = i6;
    }

    public static void m3961q(C1644o3 c1644o3, int i6) {
        c1644o3.zze = i6 - 1;
        c1644o3.zzd |= 1;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004ဇ\u0003\u0006ဂ\u0004", new Object[]{"zzd", "zze", C1643o2.f5487B, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i10 == 3) {
            return new C1644o3();
        }
        if (i10 == 4) {
            return new C1635n3(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

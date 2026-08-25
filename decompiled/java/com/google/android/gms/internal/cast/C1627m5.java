package com.google.android.gms.internal.cast;

public final class C1627m5 extends AbstractC1589i7 {
    private static final C1627m5 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private boolean zzk;
    private int zzl;

    static {
        C1627m5 c1627m5 = new C1627m5();
        zzb = c1627m5;
        AbstractC1589i7.m3864e(C1627m5.class, c1627m5);
    }

    public static C1617l5 m3943l() {
        return (C1617l5) zzb.m3871j();
    }

    public static void m3944m(C1627m5 c1627m5, String str) {
        str.getClass();
        c1627m5.zzd |= 8;
        c1627m5.zzh = str;
    }

    public static void m3945n(C1627m5 c1627m5, String str) {
        str.getClass();
        c1627m5.zzd |= 16;
        c1627m5.zzi = str;
    }

    public static void m3946o(C1627m5 c1627m5, String str) {
        str.getClass();
        c1627m5.zzd |= 1;
        c1627m5.zze = str;
    }

    public static void m3947p(C1627m5 c1627m5, String str) {
        str.getClass();
        c1627m5.zzd |= 2;
        c1627m5.zzf = str;
    }

    public static void m3948q(C1627m5 c1627m5, String str) {
        str.getClass();
        c1627m5.zzd |= 4;
        c1627m5.zzg = str;
    }

    public static void m3949r(C1627m5 c1627m5, String str) {
        str.getClass();
        c1627m5.zzd |= 32;
        c1627m5.zzj = str;
    }

    public static void m3950s(C1627m5 c1627m5, int i6) {
        c1627m5.zzl = i6 - 1;
        c1627m5.zzd |= 128;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဇ\u0006\b᠌\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", C1636n4.f5462q});
        }
        if (i10 == 3) {
            return new C1627m5();
        }
        if (i10 == 4) {
            return new C1617l5(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

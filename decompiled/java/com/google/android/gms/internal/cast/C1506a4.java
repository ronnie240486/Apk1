package com.google.android.gms.internal.cast;

public final class C1506a4 extends AbstractC1589i7 {
    private static final C1506a4 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        C1506a4 c1506a4 = new C1506a4();
        zzb = c1506a4;
        AbstractC1589i7.m3864e(C1506a4.class, c1506a4);
    }

    public static C1743z3 m3715l() {
        return (C1743z3) zzb.m3871j();
    }

    public static void m3716m(C1506a4 c1506a4, String str) {
        str.getClass();
        c1506a4.zzd |= 1;
        c1506a4.zze = str;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i10 == 3) {
            return new C1506a4();
        }
        if (i10 == 4) {
            return new C1743z3(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

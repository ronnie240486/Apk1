package com.google.android.gms.internal.cast;

public final class C1742z2 extends AbstractC1589i7 {
    private static final C1742z2 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        C1742z2 c1742z2 = new C1742z2();
        zzb = c1742z2;
        AbstractC1589i7.m3864e(C1742z2.class, c1742z2);
    }

    public static C1733y2 m4061l() {
        return (C1733y2) zzb.m3871j();
    }

    public static void m4062m(C1742z2 c1742z2, String str) {
        str.getClass();
        c1742z2.zzd |= 1;
        c1742z2.zze = str;
    }

    public static void m4063n(C1742z2 c1742z2, String str) {
        str.getClass();
        c1742z2.zzd |= 2;
        c1742z2.zzf = str;
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
            return new C1742z2();
        }
        if (i10 == 4) {
            return new C1733y2(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

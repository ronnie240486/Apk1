package com.google.android.gms.internal.cast;

public final class C1681s4 extends AbstractC1589i7 {
    private static final C1681s4 zzb;
    private int zzd;
    private long zze;
    private InterfaceC1619l7 zzf;
    private InterfaceC1619l7 zzg;

    static {
        C1681s4 c1681s4 = new C1681s4();
        zzb = c1681s4;
        AbstractC1589i7.m3864e(C1681s4.class, c1681s4);
    }

    public C1681s4() {
        C1666q7 c1666q7 = C1666q7.f5569e;
        this.zzf = c1666q7;
        this.zzg = c1666q7;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001စ\u0000\u0002\u0017\u0003\u0017", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i10 == 3) {
            return new C1681s4();
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

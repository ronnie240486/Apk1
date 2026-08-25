package com.google.android.gms.internal.cast;

public final class C1531d extends AbstractC1589i7 {
    private static final C1531d zzb;
    private InterfaceC1629m7 zzd;
    private InterfaceC1629m7 zze;
    private InterfaceC1629m7 zzf;
    private InterfaceC1629m7 zzg;

    static {
        C1531d c1531d = new C1531d();
        zzb = c1531d;
        AbstractC1589i7.m3864e(C1531d.class, c1531d);
    }

    public C1531d() {
        C1747z7 c1747z7 = C1747z7.f5747e;
        this.zzd = c1747z7;
        this.zze = c1747z7;
        this.zzf = c1747z7;
        this.zzg = c1747z7;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b", new Object[]{"zzd", C1511b.class, "zze", C1630m8.class, "zzf", C1511b.class, "zzg", C1630m8.class});
        }
        if (i10 == 3) {
            return new C1531d();
        }
        if (i10 == 4) {
            return new C1521c(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

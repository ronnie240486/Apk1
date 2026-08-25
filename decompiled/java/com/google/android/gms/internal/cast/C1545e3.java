package com.google.android.gms.internal.cast;

public final class C1545e3 extends AbstractC1589i7 {
    private static final C1545e3 zzb;
    private InterfaceC1629m7 zzd = C1747z7.f5747e;

    static {
        C1545e3 c1545e3 = new C1545e3();
        zzb = c1545e3;
        AbstractC1589i7.m3864e(C1545e3.class, c1545e3);
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzd"});
        }
        if (i10 == 3) {
            return new C1545e3();
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

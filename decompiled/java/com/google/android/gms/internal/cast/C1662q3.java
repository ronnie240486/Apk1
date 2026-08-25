package com.google.android.gms.internal.cast;

import java.util.ArrayList;

public final class C1662q3 extends AbstractC1589i7 {
    private static final C1662q3 zzb;
    private int zzd;
    private C1506a4 zze;
    private long zzf;
    private int zzg;
    private InterfaceC1629m7 zzh;
    private InterfaceC1629m7 zzi;
    private InterfaceC1629m7 zzj;
    private InterfaceC1629m7 zzk;
    private InterfaceC1629m7 zzl;
    private int zzm;

    static {
        C1662q3 c1662q3 = new C1662q3();
        zzb = c1662q3;
        AbstractC1589i7.m3864e(C1662q3.class, c1662q3);
    }

    public C1662q3() {
        C1747z7 c1747z7 = C1747z7.f5747e;
        this.zzh = c1747z7;
        this.zzi = c1747z7;
        this.zzj = c1747z7;
        this.zzk = c1747z7;
        this.zzl = c1747z7;
    }

    public static C1653p3 m3977l() {
        return (C1653p3) zzb.m3871j();
    }

    public static void m3978m(C1662q3 c1662q3, ArrayList arrayList) {
        InterfaceC1629m7 interfaceC1629m7 = c1662q3.zzh;
        if (!((AbstractC1737y6) interfaceC1629m7).f5737a) {
            int size = interfaceC1629m7.size();
            c1662q3.zzh = interfaceC1629m7.mo3876a(size + size);
        }
        AbstractC1728x6.m4054b(arrayList, c1662q3.zzh);
    }

    public static void m3979n(C1662q3 c1662q3, ArrayList arrayList) {
        InterfaceC1629m7 interfaceC1629m7 = c1662q3.zzi;
        if (!((AbstractC1737y6) interfaceC1629m7).f5737a) {
            int size = interfaceC1629m7.size();
            c1662q3.zzi = interfaceC1629m7.mo3876a(size + size);
        }
        AbstractC1728x6.m4054b(arrayList, c1662q3.zzi);
    }

    public static void m3980o(C1662q3 c1662q3, ArrayList arrayList) {
        InterfaceC1629m7 interfaceC1629m7 = c1662q3.zzl;
        if (!((AbstractC1737y6) interfaceC1629m7).f5737a) {
            int size = interfaceC1629m7.size();
            c1662q3.zzl = interfaceC1629m7.mo3876a(size + size);
        }
        AbstractC1728x6.m4054b(arrayList, c1662q3.zzl);
    }

    public static void m3981p(C1662q3 c1662q3, ArrayList arrayList) {
        InterfaceC1629m7 interfaceC1629m7 = c1662q3.zzj;
        if (!((AbstractC1737y6) interfaceC1629m7).f5737a) {
            int size = interfaceC1629m7.size();
            c1662q3.zzj = interfaceC1629m7.mo3876a(size + size);
        }
        AbstractC1728x6.m4054b(arrayList, c1662q3.zzj);
    }

    public static void m3982q(C1662q3 c1662q3, ArrayList arrayList) {
        InterfaceC1629m7 interfaceC1629m7 = c1662q3.zzk;
        if (!((AbstractC1737y6) interfaceC1629m7).f5737a) {
            int size = interfaceC1629m7.size();
            c1662q3.zzk = interfaceC1629m7.mo3876a(size + size);
        }
        AbstractC1728x6.m4054b(arrayList, c1662q3.zzk);
    }

    public static void m3983r(C1662q3 c1662q3, C1506a4 c1506a4) {
        c1662q3.zze = c1506a4;
        c1662q3.zzd |= 1;
    }

    public static void m3984s(C1662q3 c1662q3, int i6) {
        c1662q3.zzd |= 8;
        c1662q3.zzm = i6;
    }

    public static void m3985t(C1662q3 c1662q3, long j10) {
        c1662q3.zzd |= 2;
        c1662q3.zzf = j10;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0005\u0000\u0001ဉ\u0000\u0002စ\u0001\u0003᠌\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007\u001b\b\u001b\tင\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", C1661q2.f5550b, "zzh", C1644o3.class, "zzi", C1605k3.class, "zzj", C1689t3.class, "zzk", C1680s3.class, "zzl", C1625m3.class, "zzm"});
        }
        if (i10 == 3) {
            return new C1662q3();
        }
        if (i10 == 4) {
            return new C1653p3(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

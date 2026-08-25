package com.google.android.gms.internal.cast;

public final class C1525c3 extends AbstractC1589i7 {
    private static final C1525c3 zzb;
    private int zzd;
    private C1506a4 zze;
    private boolean zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private C1567g5 zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private boolean zzs;

    static {
        C1525c3 c1525c3 = new C1525c3();
        zzb = c1525c3;
        AbstractC1589i7.m3864e(C1525c3.class, c1525c3);
    }

    public static C1515b3 m3744l() {
        return (C1515b3) zzb.m3871j();
    }

    public static C1515b3 m3745m(C1525c3 c1525c3) {
        AbstractC1579h7 abstractC1579h7M3871j = zzb.m3871j();
        AbstractC1589i7 abstractC1589i7 = abstractC1579h7M3871j.f5337a;
        if (!abstractC1589i7.equals(c1525c3)) {
            if (!abstractC1579h7M3871j.f5338b.m3869g()) {
                AbstractC1589i7 abstractC1589i8 = (AbstractC1589i7) abstractC1589i7.mo3714h(4, null);
                C1738y7.f5738c.m4060a(abstractC1589i8.getClass()).mo3741g(abstractC1589i8, abstractC1579h7M3871j.f5338b);
                abstractC1579h7M3871j.f5338b = abstractC1589i8;
            }
            AbstractC1589i7 abstractC1589i9 = abstractC1579h7M3871j.f5338b;
            C1738y7.f5738c.m4060a(abstractC1589i9.getClass()).mo3741g(abstractC1589i9, c1525c3);
        }
        return (C1515b3) abstractC1579h7M3871j;
    }

    public static C1525c3 m3746n() {
        return zzb;
    }

    public static void m3747o(C1525c3 c1525c3, C1506a4 c1506a4) {
        c1525c3.zze = c1506a4;
        c1525c3.zzd |= 1;
    }

    public static void m3748p(C1525c3 c1525c3, int i6) {
        c1525c3.zzd |= 1024;
        c1525c3.zzo = i6;
    }

    public static void m3749q(C1525c3 c1525c3, int i6) {
        c1525c3.zzd |= 128;
        c1525c3.zzl = i6;
    }

    public static void m3750r(C1525c3 c1525c3, boolean z7) {
        c1525c3.zzd |= 2048;
        c1525c3.zzp = z7;
    }

    public static void m3751s(C1525c3 c1525c3, boolean z7) {
        c1525c3.zzd |= 16384;
        c1525c3.zzs = z7;
    }

    public static void m3752t(C1525c3 c1525c3, boolean z7) {
        c1525c3.zzd |= 2;
        c1525c3.zzf = z7;
    }

    public static void m3753u(C1525c3 c1525c3, int i6) {
        c1525c3.zzd |= 64;
        c1525c3.zzk = i6;
    }

    public static void m3754v(C1525c3 c1525c3, long j10) {
        c1525c3.zzd |= 4;
        c1525c3.zzg = j10;
    }

    public static void m3755w(C1525c3 c1525c3) {
        c1525c3.zzd |= 8192;
        c1525c3.zzr = 101;
    }

    public static void m3756x(C1525c3 c1525c3) {
        c1525c3.zzd |= 4096;
        c1525c3.zzq = 0;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001\u0003စ\u0002\u0004ဆ\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007င\u0006\bင\u0007\tဉ\b\n᠌\t\u000bင\n\fဇ\u000b\rင\f\u000eင\r\u000fဇ\u000e", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", C1636n4.f5459n, "zzj", C1636n4.f5458m, "zzk", "zzl", "zzm", "zzn", C1636n4.f5443B, "zzo", "zzp", "zzq", "zzr", "zzs"});
        }
        if (i10 == 3) {
            return new C1525c3();
        }
        if (i10 == 4) {
            return new C1515b3(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        throw null;
    }
}

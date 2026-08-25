package com.google.android.gms.internal.cast;

import androidx.media3.common.C0565C;

public final class C1585i3 extends AbstractC1589i7 {
    private static final C1585i3 zzb;
    private InterfaceC1629m7 zzA;
    private InterfaceC1629m7 zzB;
    private InterfaceC1629m7 zzC;
    private C1587i5 zzD;
    private int zzE;
    private int zzF;
    private C1506a4 zzG;
    private int zzH;
    private C1565g3 zzI;
    private InterfaceC1629m7 zzJ;
    private C1506a4 zzK;
    private int zzL;
    private int zzM;
    private int zzN;
    private int zzO;
    private int zzP;
    private int zzQ;
    private C1718w5 zzR;
    private C1525c3 zzS;
    private C1662q3 zzT;
    private C1688t2 zzU;
    private C1616l4 zzV;
    private C1577h5 zzW;
    private C1663q4 zzX;
    private InterfaceC1629m7 zzY;
    private C1654p4 zzZ;
    private int zzaa;
    private C1699u4 zzab;
    private InterfaceC1629m7 zzac;
    private boolean zzad;
    private boolean zzae;
    private int zzaf;
    private C1706v2 zzag;
    private C1735y4 zzah;
    private C1586i4 zzai;
    private C1707v3 zzaj;
    private C1690t4 zzak;
    private C1637n5 zzal;
    private C1716w3 zzam;
    private int zzan;
    private int zzao;
    private int zzap;
    private InterfaceC1629m7 zzaq;
    private C1745z5 zzar;
    private C1646o5 zzas;
    private C1627m5 zzat;
    private C1545e3 zzau;
    private C1673r5 zzav;
    private C1557f5 zzaw;
    private C1645o4 zzax;
    private int zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private C1566g4 zzi;
    private C1726x4 zzj;
    private C1556f4 zzk;
    private C1536d4 zzl;
    private C1555f3 zzm;
    private C1717w4 zzn;
    private C1724x2 zzo;
    private C1700u5 zzp;
    private C1526c4 zzr;
    private C1614l2 zzs;
    private int zzv;
    private C1681s4 zzw;
    private InterfaceC1629m7 zzz;
    private byte zzay = 2;
    private String zzq = "";
    private String zzt = "";
    private String zzu = "";
    private String zzx = "";
    private InterfaceC1609k7 zzy = C1599j7.f5369e;

    static {
        C1585i3 c1585i3 = new C1585i3();
        zzb = c1585i3;
        AbstractC1589i7.m3864e(C1585i3.class, c1585i3);
    }

    public C1585i3() {
        C1747z7 c1747z7 = C1747z7.f5747e;
        this.zzz = c1747z7;
        this.zzA = c1747z7;
        this.zzB = c1747z7;
        this.zzC = c1747z7;
        this.zzJ = c1747z7;
        this.zzY = c1747z7;
        this.zzac = c1747z7;
        this.zzaq = c1747z7;
    }

    public static C1575h3 m3848m() {
        return (C1575h3) zzb.m3871j();
    }

    public static C1575h3 m3849n(C1585i3 c1585i3) {
        AbstractC1579h7 abstractC1579h7M3871j = zzb.m3871j();
        AbstractC1589i7 abstractC1589i7 = abstractC1579h7M3871j.f5337a;
        if (!abstractC1589i7.equals(c1585i3)) {
            if (!abstractC1579h7M3871j.f5338b.m3869g()) {
                AbstractC1589i7 abstractC1589i8 = (AbstractC1589i7) abstractC1589i7.mo3714h(4, null);
                C1738y7.f5738c.m4060a(abstractC1589i8.getClass()).mo3741g(abstractC1589i8, abstractC1579h7M3871j.f5338b);
                abstractC1579h7M3871j.f5338b = abstractC1589i8;
            }
            AbstractC1589i7 abstractC1589i9 = abstractC1579h7M3871j.f5338b;
            C1738y7.f5738c.m4060a(abstractC1589i9.getClass()).mo3741g(abstractC1589i9, c1585i3);
        }
        return (C1575h3) abstractC1579h7M3871j;
    }

    public static void m3850o(C1585i3 c1585i3, C1742z2 c1742z2) {
        InterfaceC1629m7 interfaceC1629m7 = c1585i3.zzY;
        if (!((AbstractC1737y6) interfaceC1629m7).f5737a) {
            int size = interfaceC1629m7.size();
            c1585i3.zzY = interfaceC1629m7.mo3876a(size + size);
        }
        c1585i3.zzY.add(c1742z2);
    }

    public static void m3851p(C1585i3 c1585i3, C1706v2 c1706v2) {
        c1585i3.zzag = c1706v2;
        c1585i3.zze |= 8192;
    }

    public static void m3852q(C1585i3 c1585i3, C1525c3 c1525c3) {
        c1585i3.zzS = c1525c3;
        c1585i3.zze |= 2;
    }

    public static void m3853r(C1585i3 c1585i3, String str) {
        str.getClass();
        c1585i3.zzd |= 32768;
        c1585i3.zzu = str;
    }

    public static void m3854s(C1585i3 c1585i3, String str) {
        str.getClass();
        c1585i3.zzd |= 2048;
        c1585i3.zzq = str;
    }

    public static void m3855t(C1585i3 c1585i3, int i6) {
        c1585i3.zzd |= Integer.MIN_VALUE;
        c1585i3.zzQ = i6;
    }

    public static void m3856u(C1585i3 c1585i3, int i6) {
        c1585i3.zzd |= C0565C.DEFAULT_BUFFER_SEGMENT_SIZE;
        c1585i3.zzv = i6;
    }

    public static void m3857v(C1585i3 c1585i3, C1627m5 c1627m5) {
        c1585i3.zzat = c1627m5;
        c1585i3.zze |= 33554432;
    }

    public static void m3858w(C1585i3 c1585i3, String str) {
        c1585i3.zzd |= 262144;
        c1585i3.zzx = str;
    }

    public static void m3859x(C1585i3 c1585i3, String str) {
        str.getClass();
        c1585i3.zzd |= 16384;
        c1585i3.zzt = str;
    }

    public static void m3860y(C1585i3 c1585i3, C1662q3 c1662q3) {
        c1585i3.zzT = c1662q3;
        c1585i3.zze |= 4;
    }

    public static void m3861z(C1585i3 c1585i3, long j10) {
        c1585i3.zzd |= 2;
        c1585i3.zzg = j10;
    }

    @Override
    public final Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7) {
        int i10 = i6 - 1;
        if (i10 == 0) {
            return Byte.valueOf(this.zzay);
        }
        if (i10 == 2) {
            return new C1510a8(zzb, "\u0001G\u0000\u0002\u0001GG\u0000\t\u0001\u0001ဂ\u0000\u0002ဂ\u0001\u0003᠌\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဈ\u000e\nဉ\b\u000bဉ\t\fဉ\n\rဈ\u000b\u000eဉ\f\u000fဉ\r\u0010ဉ\u0011\u0011ဈ\u0012\u0012\u0016\u0013\u001b\u0014\u001b\u0015\u001b\u0016\u001b\u0017᠌\u0014\u0018ဉ\u0018\u0019\u001b\u001aဉ\u0019\u001b᠌\u001b\u001cင\u001c\u001dင\u001d\u001eင\u001e\u001fဆ\u001f ဉ !ဉ!\"ဉ##᠌\u0015$ဉ\u0016%ᐉ$&ဉ%'ဉ&(\u001b)᠌(*ဉ)+\u001b,᠌\u001a-ဇ*.ဇ+/᠌,0ဉ-1င\u00172ဉ.3ဉ/4ဉ15ဉ26ဉ37᠌48᠌59᠌6:\u001b;ဈ\u000f<ဉ7=ဉ0>ဉ\u0013?ဉ\"@င\u0010Aဉ8Bဉ'Cဉ9Dဉ:Eဉ;Fဉ<Gဉ=", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", C1643o2.f5489D, "zzi", "zzj", "zzk", "zzl", "zzm", "zzt", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzw", "zzx", "zzy", "zzz", C1576h4.class, "zzA", C1596j4.class, "zzB", C1725x3.class, "zzC", C1597j5.class, "zzE", C1643o2.f5511v, "zzI", "zzJ", C1506a4.class, "zzK", "zzM", C1643o2.f5492c, "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzU", "zzF", C1643o2.f5509t, "zzG", "zzV", "zzW", "zzX", "zzY", C1742z2.class, "zzaa", C1643o2.f5510u, "zzab", "zzac", C1535d3.class, "zzL", C1643o2.f5491b, "zzad", "zzae", "zzaf", C1636n4.f5445D, "zzag", "zzH", "zzah", "zzai", "zzak", "zzal", "zzam", "zzan", C1636n4.f5465t, "zzao", C1643o2.f5502m, "zzap", C1636n4.f5464s, "zzaq", C1682s5.class, "zzu", "zzar", "zzaj", "zzD", "zzT", "zzv", "zzas", "zzZ", "zzat", "zzau", "zzav", "zzaw", "zzax"});
        }
        if (i10 == 3) {
            return new C1585i3();
        }
        if (i10 == 4) {
            return new C1575h3(zzb);
        }
        if (i10 == 5) {
            return zzb;
        }
        this.zzay = abstractC1589i7 == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final C1525c3 m3862l() {
        C1525c3 c1525c3 = this.zzS;
        return c1525c3 == null ? C1525c3.m3746n() : c1525c3;
    }
}

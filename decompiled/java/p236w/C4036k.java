package p236w;

import java.util.ArrayList;
import p215u.AbstractC3885h;
import p225v.C3956c;
import p225v.C3958e;
import p225v.C3963j;
import p225v.EnumC3957d;

public final class C4036k extends AbstractC4039n {

    public static final int[] f13676k = new int[2];

    public static void m8033m(int[] iArr, int i6, int i10, int i11, int i12, float f, int i13) {
        int i14 = i10 - i6;
        int i15 = i12 - i11;
        if (i13 != -1) {
            if (i13 == 0) {
                iArr[0] = (int) ((i15 * f) + 0.5f);
                iArr[1] = i15;
                return;
            } else {
                if (i13 != 1) {
                    return;
                }
                iArr[0] = i14;
                iArr[1] = (int) ((i14 * f) + 0.5f);
                return;
            }
        }
        int i16 = (int) ((i15 * f) + 0.5f);
        int i17 = (int) ((i14 / f) + 0.5f);
        if (i16 <= i14) {
            iArr[0] = i16;
            iArr[1] = i15;
        } else if (i17 <= i15) {
            iArr[0] = i14;
            iArr[1] = i17;
        }
    }

    @Override
    public final void mo8013a(InterfaceC4030e interfaceC4030e) {
        int iM8042g;
        int i6;
        int iM8042g2;
        float f;
        float f3;
        float f4;
        int i10;
        if (AbstractC3885h.m7785a(this.f13690j) == 3) {
            C3958e c3958e = this.f13682b;
            m8043l(c3958e.f13380y, c3958e.f13324A, 0);
            return;
        }
        C4033h c4033h = this.f13685e;
        boolean z7 = c4033h.f13672j;
        EnumC3957d enumC3957d = EnumC3957d.f13321c;
        C4032g c4032g = this.f13688h;
        C4032g c4032g2 = this.f13689i;
        if (!z7 && this.f13684d == enumC3957d) {
            C3958e c3958e2 = this.f13682b;
            int i11 = c3958e2.f13365j;
            if (i11 == 2) {
                C3958e c3958e3 = c3958e2.f13334K;
                if (c3958e3 != null) {
                    C4033h c4033h2 = c3958e3.f13356d.f13685e;
                    if (c4033h2.f13672j) {
                        c4033h.mo8030d((int) ((c4033h2.f13669g * c3958e2.f13370o) + 0.5f));
                    }
                }
            } else if (i11 == 3) {
                int i12 = c3958e2.f13366k;
                if (i12 == 0 || i12 == 3) {
                    C4038m c4038m = c3958e2.f13358e;
                    C4032g c4032g3 = c4038m.f13688h;
                    C4032g c4032g4 = c4038m.f13689i;
                    boolean z10 = c3958e2.f13380y.f13315d != null;
                    boolean z11 = c3958e2.f13381z.f13315d != null;
                    boolean z12 = c3958e2.f13324A.f13315d != null;
                    boolean z13 = c3958e2.f13325B.f13315d != null;
                    int i13 = c3958e2.f13338O;
                    if (z10 && z11 && z12 && z13) {
                        float f5 = c3958e2.f13337N;
                        boolean z14 = c4032g3.f13672j;
                        int[] iArr = f13676k;
                        if (z14 && c4032g4.f13672j) {
                            if (c4032g.f13665c && c4032g2.f13665c) {
                                m8033m(iArr, ((C4032g) c4032g.f13674l.get(0)).f13669g + c4032g.f13668f, ((C4032g) c4032g2.f13674l.get(0)).f13669g - c4032g2.f13668f, c4032g3.f13669g + c4032g3.f13668f, c4032g4.f13669g - c4032g4.f13668f, f5, i13);
                                c4033h.mo8030d(iArr[0]);
                                this.f13682b.f13358e.f13685e.mo8030d(iArr[1]);
                                return;
                            }
                            return;
                        }
                        boolean z15 = c4032g.f13672j;
                        ArrayList arrayList = c4032g3.f13674l;
                        if (z15 && c4032g2.f13672j) {
                            if (!c4032g3.f13665c || !c4032g4.f13665c) {
                                return;
                            }
                            m8033m(iArr, c4032g.f13669g + c4032g.f13668f, c4032g2.f13669g - c4032g2.f13668f, ((C4032g) arrayList.get(0)).f13669g + c4032g3.f13668f, ((C4032g) c4032g4.f13674l.get(0)).f13669g - c4032g4.f13668f, f5, i13);
                            c4033h.mo8030d(iArr[0]);
                            this.f13682b.f13358e.f13685e.mo8030d(iArr[1]);
                        }
                        if (!c4032g.f13665c || !c4032g2.f13665c || !c4032g3.f13665c || !c4032g4.f13665c) {
                            return;
                        }
                        m8033m(iArr, ((C4032g) c4032g.f13674l.get(0)).f13669g + c4032g.f13668f, ((C4032g) c4032g2.f13674l.get(0)).f13669g - c4032g2.f13668f, ((C4032g) arrayList.get(0)).f13669g + c4032g3.f13668f, ((C4032g) c4032g4.f13674l.get(0)).f13669g - c4032g4.f13668f, f5, i13);
                        c4033h.mo8030d(iArr[0]);
                        this.f13682b.f13358e.f13685e.mo8030d(iArr[1]);
                    } else if (z10 && z12) {
                        if (!c4032g.f13665c || !c4032g2.f13665c) {
                            return;
                        }
                        float f10 = c3958e2.f13337N;
                        int i14 = ((C4032g) c4032g.f13674l.get(0)).f13669g + c4032g.f13668f;
                        int i15 = ((C4032g) c4032g2.f13674l.get(0)).f13669g - c4032g2.f13668f;
                        if (i13 == -1 || i13 == 0) {
                            int iM8042g3 = m8042g(i15 - i14, 0);
                            int i16 = (int) ((iM8042g3 * f10) + 0.5f);
                            int iM8042g4 = m8042g(i16, 1);
                            if (i16 != iM8042g4) {
                                iM8042g3 = (int) ((iM8042g4 / f10) + 0.5f);
                            }
                            c4033h.mo8030d(iM8042g3);
                            this.f13682b.f13358e.f13685e.mo8030d(iM8042g4);
                        } else if (i13 == 1) {
                            int iM8042g5 = m8042g(i15 - i14, 0);
                            int i17 = (int) ((iM8042g5 / f10) + 0.5f);
                            int iM8042g6 = m8042g(i17, 1);
                            if (i17 != iM8042g6) {
                                iM8042g5 = (int) ((iM8042g6 * f10) + 0.5f);
                            }
                            c4033h.mo8030d(iM8042g5);
                            this.f13682b.f13358e.f13685e.mo8030d(iM8042g6);
                        }
                    } else if (z11 && z13) {
                        if (!c4032g3.f13665c || !c4032g4.f13665c) {
                            return;
                        }
                        float f11 = c3958e2.f13337N;
                        int i18 = ((C4032g) c4032g3.f13674l.get(0)).f13669g + c4032g3.f13668f;
                        int i19 = ((C4032g) c4032g4.f13674l.get(0)).f13669g - c4032g4.f13668f;
                        if (i13 == -1) {
                            iM8042g = m8042g(i19 - i18, 1);
                            i6 = (int) ((iM8042g / f11) + 0.5f);
                            iM8042g2 = m8042g(i6, 0);
                            if (i6 != iM8042g2) {
                                iM8042g = (int) ((iM8042g2 * f11) + 0.5f);
                            }
                            c4033h.mo8030d(iM8042g2);
                            this.f13682b.f13358e.f13685e.mo8030d(iM8042g);
                        } else if (i13 == 0) {
                            int iM8042g7 = m8042g(i19 - i18, 1);
                            int i20 = (int) ((iM8042g7 * f11) + 0.5f);
                            int iM8042g8 = m8042g(i20, 0);
                            if (i20 != iM8042g8) {
                                iM8042g7 = (int) ((iM8042g8 / f11) + 0.5f);
                            }
                            c4033h.mo8030d(iM8042g8);
                            this.f13682b.f13358e.f13685e.mo8030d(iM8042g7);
                        } else if (i13 == 1) {
                            iM8042g = m8042g(i19 - i18, 1);
                            i6 = (int) ((iM8042g / f11) + 0.5f);
                            iM8042g2 = m8042g(i6, 0);
                            if (i6 != iM8042g2) {
                                iM8042g = (int) ((iM8042g2 * f11) + 0.5f);
                            }
                            c4033h.mo8030d(iM8042g2);
                            this.f13682b.f13358e.f13685e.mo8030d(iM8042g);
                        }
                    }
                } else {
                    int i21 = c3958e2.f13338O;
                    if (i21 != -1) {
                        if (i21 == 0) {
                            f4 = c3958e2.f13358e.f13685e.f13669g / c3958e2.f13337N;
                            i10 = (int) (f4 + 0.5f);
                        } else if (i21 != 1) {
                            i10 = 0;
                        } else {
                            f = c3958e2.f13358e.f13685e.f13669g;
                            f3 = c3958e2.f13337N;
                        }
                        c4033h.mo8030d(i10);
                    } else {
                        f = c3958e2.f13358e.f13685e.f13669g;
                        f3 = c3958e2.f13337N;
                    }
                    f4 = f * f3;
                    i10 = (int) (f4 + 0.5f);
                    c4033h.mo8030d(i10);
                }
            }
        }
        if (c4032g.f13665c && c4032g2.f13665c) {
            if (c4032g.f13672j && c4032g2.f13672j && c4033h.f13672j) {
                return;
            }
            if (!c4033h.f13672j && this.f13684d == enumC3957d) {
                C3958e c3958e4 = this.f13682b;
                if (c3958e4.f13365j == 0 && !c3958e4.m7910r()) {
                    C4032g c4032g5 = (C4032g) c4032g.f13674l.get(0);
                    C4032g c4032g6 = (C4032g) c4032g2.f13674l.get(0);
                    int i22 = c4032g5.f13669g + c4032g.f13668f;
                    int i23 = c4032g6.f13669g + c4032g2.f13668f;
                    c4032g.mo8030d(i22);
                    c4032g2.mo8030d(i23);
                    c4033h.mo8030d(i23 - i22);
                    return;
                }
            }
            if (!c4033h.f13672j && this.f13684d == enumC3957d && this.f13681a == 1 && c4032g.f13674l.size() > 0 && c4032g2.f13674l.size() > 0) {
                int iMin = Math.min((((C4032g) c4032g2.f13674l.get(0)).f13669g + c4032g2.f13668f) - (((C4032g) c4032g.f13674l.get(0)).f13669g + c4032g.f13668f), c4033h.f13675m);
                C3958e c3958e5 = this.f13682b;
                int i24 = c3958e5.f13369n;
                int iMax = Math.max(c3958e5.f13368m, iMin);
                if (i24 > 0) {
                    iMax = Math.min(i24, iMax);
                }
                c4033h.mo8030d(iMax);
            }
            if (c4033h.f13672j) {
                C4032g c4032g7 = (C4032g) c4032g.f13674l.get(0);
                C4032g c4032g8 = (C4032g) c4032g2.f13674l.get(0);
                int i25 = c4032g7.f13669g;
                int i26 = c4032g.f13668f + i25;
                int i27 = c4032g8.f13669g;
                int i28 = c4032g2.f13668f + i27;
                float f12 = this.f13682b.f13344U;
                if (c4032g7 == c4032g8) {
                    f12 = 0.5f;
                } else {
                    i25 = i26;
                    i27 = i28;
                }
                c4032g.mo8030d((int) ((((i27 - i25) - c4033h.f13669g) * f12) + i25 + 0.5f));
                c4032g2.mo8030d(c4032g.f13669g + c4033h.f13669g);
            }
        }
    }

    @Override
    public final void mo8014d() {
        C3958e c3958e;
        C3958e c3958e2;
        C3958e c3958e3;
        C3958e c3958e4;
        C3958e c3958e5 = this.f13682b;
        boolean z7 = c3958e5.f13350a;
        C4033h c4033h = this.f13685e;
        if (z7) {
            c4033h.mo8030d(c3958e5.m7905m());
        }
        boolean z10 = c4033h.f13672j;
        EnumC3957d enumC3957d = EnumC3957d.f13322d;
        EnumC3957d enumC3957d2 = EnumC3957d.f13321c;
        EnumC3957d enumC3957d3 = EnumC3957d.f13319a;
        C4032g c4032g = this.f13689i;
        C4032g c4032g2 = this.f13688h;
        if (!z10) {
            C3958e c3958e6 = this.f13682b;
            EnumC3957d enumC3957d4 = c3958e6.f13333J[0];
            this.f13684d = enumC3957d4;
            if (enumC3957d4 != enumC3957d2) {
                if (enumC3957d4 == enumC3957d && (((c3958e4 = c3958e6.f13334K) != null && c3958e4.f13333J[0] == enumC3957d3) || c3958e4.f13333J[0] == enumC3957d)) {
                    int iM7905m = (c3958e4.m7905m() - this.f13682b.f13380y.m7887c()) - this.f13682b.f13324A.m7887c();
                    C4036k c4036k = c3958e4.f13356d;
                    AbstractC4039n.m8038b(c4032g2, c4036k.f13688h, this.f13682b.f13380y.m7887c());
                    AbstractC4039n.m8038b(c4032g, c4036k.f13689i, -this.f13682b.f13324A.m7887c());
                    c4033h.mo8030d(iM7905m);
                    return;
                }
                if (enumC3957d4 == enumC3957d3) {
                    c4033h.mo8030d(c3958e6.m7905m());
                }
            }
        } else if (this.f13684d == enumC3957d && (((c3958e2 = (c3958e = this.f13682b).f13334K) != null && c3958e2.f13333J[0] == enumC3957d3) || c3958e2.f13333J[0] == enumC3957d)) {
            AbstractC4039n.m8038b(c4032g2, c3958e2.f13356d.f13688h, c3958e.f13380y.m7887c());
            AbstractC4039n.m8038b(c4032g, c3958e2.f13356d.f13689i, -this.f13682b.f13324A.m7887c());
            return;
        }
        if (c4033h.f13672j) {
            C3958e c3958e7 = this.f13682b;
            if (c3958e7.f13350a) {
                C3956c[] c3956cArr = c3958e7.f13330G;
                C3956c c3956c = c3956cArr[0];
                C3956c c3956c2 = c3956c.f13315d;
                if (c3956c2 != null && c3956cArr[1].f13315d != null) {
                    if (c3958e7.m7910r()) {
                        c4032g2.f13668f = this.f13682b.f13330G[0].m7887c();
                        c4032g.f13668f = -this.f13682b.f13330G[1].m7887c();
                        return;
                    }
                    C4032g c4032gM8039h = AbstractC4039n.m8039h(this.f13682b.f13330G[0]);
                    if (c4032gM8039h != null) {
                        AbstractC4039n.m8038b(c4032g2, c4032gM8039h, this.f13682b.f13330G[0].m7887c());
                    }
                    C4032g c4032gM8039h2 = AbstractC4039n.m8039h(this.f13682b.f13330G[1]);
                    if (c4032gM8039h2 != null) {
                        AbstractC4039n.m8038b(c4032g, c4032gM8039h2, -this.f13682b.f13330G[1].m7887c());
                    }
                    c4032g2.f13664b = true;
                    c4032g.f13664b = true;
                    return;
                }
                if (c3956c2 != null) {
                    C4032g c4032gM8039h3 = AbstractC4039n.m8039h(c3956c);
                    if (c4032gM8039h3 != null) {
                        AbstractC4039n.m8038b(c4032g2, c4032gM8039h3, this.f13682b.f13330G[0].m7887c());
                        AbstractC4039n.m8038b(c4032g, c4032g2, c4033h.f13669g);
                        return;
                    }
                    return;
                }
                C3956c c3956c3 = c3956cArr[1];
                if (c3956c3.f13315d != null) {
                    C4032g c4032gM8039h4 = AbstractC4039n.m8039h(c3956c3);
                    if (c4032gM8039h4 != null) {
                        AbstractC4039n.m8038b(c4032g, c4032gM8039h4, -this.f13682b.f13330G[1].m7887c());
                        AbstractC4039n.m8038b(c4032g2, c4032g, -c4033h.f13669g);
                        return;
                    }
                    return;
                }
                if ((c3958e7 instanceof C3963j) || c3958e7.f13334K == null || c3958e7.mo7900h(7).f13315d != null) {
                    return;
                }
                C3958e c3958e8 = this.f13682b;
                AbstractC4039n.m8038b(c4032g2, c3958e8.f13334K.f13356d.f13688h, c3958e8.m7906n());
                AbstractC4039n.m8038b(c4032g, c4032g2, c4033h.f13669g);
                return;
            }
        }
        if (this.f13684d == enumC3957d2) {
            C3958e c3958e9 = this.f13682b;
            int i6 = c3958e9.f13365j;
            if (i6 == 2) {
                C3958e c3958e10 = c3958e9.f13334K;
                if (c3958e10 != null) {
                    C4033h c4033h2 = c3958e10.f13358e.f13685e;
                    c4033h.f13674l.add(c4033h2);
                    c4033h2.f13673k.add(c4033h);
                    c4033h.f13664b = true;
                    c4033h.f13673k.add(c4032g2);
                    c4033h.f13673k.add(c4032g);
                }
            } else if (i6 == 3) {
                if (c3958e9.f13366k == 3) {
                    c4032g2.f13663a = this;
                    c4032g.f13663a = this;
                    C4038m c4038m = c3958e9.f13358e;
                    c4038m.f13688h.f13663a = this;
                    c4038m.f13689i.f13663a = this;
                    c4033h.f13663a = this;
                    if (c3958e9.m7911s()) {
                        c4033h.f13674l.add(this.f13682b.f13358e.f13685e);
                        this.f13682b.f13358e.f13685e.f13673k.add(c4033h);
                        C4038m c4038m2 = this.f13682b.f13358e;
                        c4038m2.f13685e.f13663a = this;
                        c4033h.f13674l.add(c4038m2.f13688h);
                        c4033h.f13674l.add(this.f13682b.f13358e.f13689i);
                        this.f13682b.f13358e.f13688h.f13673k.add(c4033h);
                        this.f13682b.f13358e.f13689i.f13673k.add(c4033h);
                    } else if (this.f13682b.m7910r()) {
                        this.f13682b.f13358e.f13685e.f13674l.add(c4033h);
                        c4033h.f13673k.add(this.f13682b.f13358e.f13685e);
                    } else {
                        this.f13682b.f13358e.f13685e.f13674l.add(c4033h);
                    }
                } else {
                    C4033h c4033h3 = c3958e9.f13358e.f13685e;
                    c4033h.f13674l.add(c4033h3);
                    c4033h3.f13673k.add(c4033h);
                    this.f13682b.f13358e.f13688h.f13673k.add(c4033h);
                    this.f13682b.f13358e.f13689i.f13673k.add(c4033h);
                    c4033h.f13664b = true;
                    c4033h.f13673k.add(c4032g2);
                    c4033h.f13673k.add(c4032g);
                    c4032g2.f13674l.add(c4033h);
                    c4032g.f13674l.add(c4033h);
                }
            }
        }
        C3958e c3958e11 = this.f13682b;
        C3956c[] c3956cArr2 = c3958e11.f13330G;
        C3956c c3956c4 = c3956cArr2[0];
        C3956c c3956c5 = c3956c4.f13315d;
        if (c3956c5 != null && c3956cArr2[1].f13315d != null) {
            if (c3958e11.m7910r()) {
                c4032g2.f13668f = this.f13682b.f13330G[0].m7887c();
                c4032g.f13668f = -this.f13682b.f13330G[1].m7887c();
                return;
            }
            C4032g c4032gM8039h5 = AbstractC4039n.m8039h(this.f13682b.f13330G[0]);
            C4032g c4032gM8039h6 = AbstractC4039n.m8039h(this.f13682b.f13330G[1]);
            c4032gM8039h5.m8028b(this);
            c4032gM8039h6.m8028b(this);
            this.f13690j = 4;
            return;
        }
        if (c3956c5 != null) {
            C4032g c4032gM8039h7 = AbstractC4039n.m8039h(c3956c4);
            if (c4032gM8039h7 != null) {
                AbstractC4039n.m8038b(c4032g2, c4032gM8039h7, this.f13682b.f13330G[0].m7887c());
                m8041c(c4032g, c4032g2, 1, c4033h);
                return;
            }
            return;
        }
        C3956c c3956c6 = c3956cArr2[1];
        if (c3956c6.f13315d != null) {
            C4032g c4032gM8039h8 = AbstractC4039n.m8039h(c3956c6);
            if (c4032gM8039h8 != null) {
                AbstractC4039n.m8038b(c4032g, c4032gM8039h8, -this.f13682b.f13330G[1].m7887c());
                m8041c(c4032g2, c4032g, -1, c4033h);
                return;
            }
            return;
        }
        if ((c3958e11 instanceof C3963j) || (c3958e3 = c3958e11.f13334K) == null) {
            return;
        }
        AbstractC4039n.m8038b(c4032g2, c3958e3.f13356d.f13688h, c3958e11.m7906n());
        m8041c(c4032g, c4032g2, 1, c4033h);
    }

    @Override
    public final void mo8015e() {
        C4032g c4032g = this.f13688h;
        if (c4032g.f13672j) {
            this.f13682b.f13339P = c4032g.f13669g;
        }
    }

    @Override
    public final void mo8016f() {
        this.f13683c = null;
        this.f13688h.m8029c();
        this.f13689i.m8029c();
        this.f13685e.m8029c();
        this.f13687g = false;
    }

    @Override
    public final boolean mo8018k() {
        return this.f13684d != EnumC3957d.f13321c || this.f13682b.f13365j == 0;
    }

    public final void m8034n() {
        this.f13687g = false;
        C4032g c4032g = this.f13688h;
        c4032g.m8029c();
        c4032g.f13672j = false;
        C4032g c4032g2 = this.f13689i;
        c4032g2.m8029c();
        c4032g2.f13672j = false;
        this.f13685e.f13672j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f13682b.f13348Y;
    }
}

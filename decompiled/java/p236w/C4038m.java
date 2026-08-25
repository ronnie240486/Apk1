package p236w;

import p215u.AbstractC3885h;
import p225v.C3956c;
import p225v.C3958e;
import p225v.C3963j;
import p225v.EnumC3957d;

public final class C4038m extends AbstractC4039n {

    public C4032g f13679k;

    public C4026a f13680l;

    @Override
    public final void mo8013a(InterfaceC4030e interfaceC4030e) {
        float f;
        float f3;
        float f4;
        int i6;
        if (AbstractC3885h.m7785a(this.f13690j) == 3) {
            C3958e c3958e = this.f13682b;
            m8043l(c3958e.f13381z, c3958e.f13325B, 1);
            return;
        }
        C4033h c4033h = this.f13685e;
        boolean z7 = c4033h.f13665c;
        EnumC3957d enumC3957d = EnumC3957d.f13321c;
        if (z7 && !c4033h.f13672j && this.f13684d == enumC3957d) {
            C3958e c3958e2 = this.f13682b;
            int i10 = c3958e2.f13366k;
            if (i10 == 2) {
                C3958e c3958e3 = c3958e2.f13334K;
                if (c3958e3 != null) {
                    C4033h c4033h2 = c3958e3.f13358e.f13685e;
                    if (c4033h2.f13672j) {
                        c4033h.mo8030d((int) ((c4033h2.f13669g * c3958e2.f13373r) + 0.5f));
                    }
                }
            } else if (i10 == 3) {
                C4033h c4033h3 = c3958e2.f13356d.f13685e;
                if (c4033h3.f13672j) {
                    int i11 = c3958e2.f13338O;
                    if (i11 != -1) {
                        if (i11 == 0) {
                            f4 = c4033h3.f13669g * c3958e2.f13337N;
                            i6 = (int) (f4 + 0.5f);
                        } else if (i11 != 1) {
                            i6 = 0;
                        } else {
                            f = c4033h3.f13669g;
                            f3 = c3958e2.f13337N;
                        }
                        c4033h.mo8030d(i6);
                    } else {
                        f = c4033h3.f13669g;
                        f3 = c3958e2.f13337N;
                    }
                    f4 = f / f3;
                    i6 = (int) (f4 + 0.5f);
                    c4033h.mo8030d(i6);
                }
            }
        }
        C4032g c4032g = this.f13688h;
        if (c4032g.f13665c) {
            C4032g c4032g2 = this.f13689i;
            if (c4032g2.f13665c) {
                if (c4032g.f13672j && c4032g2.f13672j && c4033h.f13672j) {
                    return;
                }
                if (!c4033h.f13672j && this.f13684d == enumC3957d) {
                    C3958e c3958e4 = this.f13682b;
                    if (c3958e4.f13365j == 0 && !c3958e4.m7911s()) {
                        C4032g c4032g3 = (C4032g) c4032g.f13674l.get(0);
                        C4032g c4032g4 = (C4032g) c4032g2.f13674l.get(0);
                        int i12 = c4032g3.f13669g + c4032g.f13668f;
                        int i13 = c4032g4.f13669g + c4032g2.f13668f;
                        c4032g.mo8030d(i12);
                        c4032g2.mo8030d(i13);
                        c4033h.mo8030d(i13 - i12);
                        return;
                    }
                }
                if (!c4033h.f13672j && this.f13684d == enumC3957d && this.f13681a == 1 && c4032g.f13674l.size() > 0 && c4032g2.f13674l.size() > 0) {
                    C4032g c4032g5 = (C4032g) c4032g.f13674l.get(0);
                    int i14 = (((C4032g) c4032g2.f13674l.get(0)).f13669g + c4032g2.f13668f) - (c4032g5.f13669g + c4032g.f13668f);
                    int i15 = c4033h.f13675m;
                    if (i14 < i15) {
                        c4033h.mo8030d(i14);
                    } else {
                        c4033h.mo8030d(i15);
                    }
                }
                if (c4033h.f13672j && c4032g.f13674l.size() > 0 && c4032g2.f13674l.size() > 0) {
                    C4032g c4032g6 = (C4032g) c4032g.f13674l.get(0);
                    C4032g c4032g7 = (C4032g) c4032g2.f13674l.get(0);
                    int i16 = c4032g6.f13669g;
                    int i17 = c4032g.f13668f + i16;
                    int i18 = c4032g7.f13669g;
                    int i19 = c4032g2.f13668f + i18;
                    float f5 = this.f13682b.f13345V;
                    if (c4032g6 == c4032g7) {
                        f5 = 0.5f;
                    } else {
                        i16 = i17;
                        i18 = i19;
                    }
                    c4032g.mo8030d((int) ((((i18 - i16) - c4033h.f13669g) * f5) + i16 + 0.5f));
                    c4032g2.mo8030d(c4032g.f13669g + c4033h.f13669g);
                }
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
            c4033h.mo8030d(c3958e5.m7902j());
        }
        boolean z10 = c4033h.f13672j;
        EnumC3957d enumC3957d = EnumC3957d.f13322d;
        EnumC3957d enumC3957d2 = EnumC3957d.f13319a;
        EnumC3957d enumC3957d3 = EnumC3957d.f13321c;
        C4032g c4032g = this.f13689i;
        C4032g c4032g2 = this.f13688h;
        if (!z10) {
            C3958e c3958e6 = this.f13682b;
            this.f13684d = c3958e6.f13333J[1];
            if (c3958e6.f13378w) {
                this.f13680l = new C4026a(this);
            }
            EnumC3957d enumC3957d4 = this.f13684d;
            if (enumC3957d4 != enumC3957d3) {
                if (enumC3957d4 == enumC3957d && (c3958e4 = this.f13682b.f13334K) != null && c3958e4.f13333J[1] == enumC3957d2) {
                    int iM7902j = (c3958e4.m7902j() - this.f13682b.f13381z.m7887c()) - this.f13682b.f13325B.m7887c();
                    C4038m c4038m = c3958e4.f13358e;
                    AbstractC4039n.m8038b(c4032g2, c4038m.f13688h, this.f13682b.f13381z.m7887c());
                    AbstractC4039n.m8038b(c4032g, c4038m.f13689i, -this.f13682b.f13325B.m7887c());
                    c4033h.mo8030d(iM7902j);
                    return;
                }
                if (enumC3957d4 == enumC3957d2) {
                    c4033h.mo8030d(this.f13682b.m7902j());
                }
            }
        } else if (this.f13684d == enumC3957d && (c3958e2 = (c3958e = this.f13682b).f13334K) != null && c3958e2.f13333J[1] == enumC3957d2) {
            C4038m c4038m2 = c3958e2.f13358e;
            AbstractC4039n.m8038b(c4032g2, c4038m2.f13688h, c3958e.f13381z.m7887c());
            AbstractC4039n.m8038b(c4032g, c4038m2.f13689i, -this.f13682b.f13325B.m7887c());
            return;
        }
        boolean z11 = c4033h.f13672j;
        C4032g c4032g3 = this.f13679k;
        if (z11) {
            C3958e c3958e7 = this.f13682b;
            if (c3958e7.f13350a) {
                C3956c[] c3956cArr = c3958e7.f13330G;
                C3956c c3956c = c3956cArr[2];
                C3956c c3956c2 = c3956c.f13315d;
                if (c3956c2 != null && c3956cArr[3].f13315d != null) {
                    if (c3958e7.m7911s()) {
                        c4032g2.f13668f = this.f13682b.f13330G[2].m7887c();
                        c4032g.f13668f = -this.f13682b.f13330G[3].m7887c();
                    } else {
                        C4032g c4032gM8039h = AbstractC4039n.m8039h(this.f13682b.f13330G[2]);
                        if (c4032gM8039h != null) {
                            AbstractC4039n.m8038b(c4032g2, c4032gM8039h, this.f13682b.f13330G[2].m7887c());
                        }
                        C4032g c4032gM8039h2 = AbstractC4039n.m8039h(this.f13682b.f13330G[3]);
                        if (c4032gM8039h2 != null) {
                            AbstractC4039n.m8038b(c4032g, c4032gM8039h2, -this.f13682b.f13330G[3].m7887c());
                        }
                        c4032g2.f13664b = true;
                        c4032g.f13664b = true;
                    }
                    C3958e c3958e8 = this.f13682b;
                    if (c3958e8.f13378w) {
                        AbstractC4039n.m8038b(c4032g3, c4032g2, c3958e8.f13341R);
                        return;
                    }
                    return;
                }
                if (c3956c2 != null) {
                    C4032g c4032gM8039h3 = AbstractC4039n.m8039h(c3956c);
                    if (c4032gM8039h3 != null) {
                        AbstractC4039n.m8038b(c4032g2, c4032gM8039h3, this.f13682b.f13330G[2].m7887c());
                        AbstractC4039n.m8038b(c4032g, c4032g2, c4033h.f13669g);
                        C3958e c3958e9 = this.f13682b;
                        if (c3958e9.f13378w) {
                            AbstractC4039n.m8038b(c4032g3, c4032g2, c3958e9.f13341R);
                            return;
                        }
                        return;
                    }
                    return;
                }
                C3956c c3956c3 = c3956cArr[3];
                if (c3956c3.f13315d != null) {
                    C4032g c4032gM8039h4 = AbstractC4039n.m8039h(c3956c3);
                    if (c4032gM8039h4 != null) {
                        AbstractC4039n.m8038b(c4032g, c4032gM8039h4, -this.f13682b.f13330G[3].m7887c());
                        AbstractC4039n.m8038b(c4032g2, c4032g, -c4033h.f13669g);
                    }
                    C3958e c3958e10 = this.f13682b;
                    if (c3958e10.f13378w) {
                        AbstractC4039n.m8038b(c4032g3, c4032g2, c3958e10.f13341R);
                        return;
                    }
                    return;
                }
                C3956c c3956c4 = c3956cArr[4];
                if (c3956c4.f13315d != null) {
                    C4032g c4032gM8039h5 = AbstractC4039n.m8039h(c3956c4);
                    if (c4032gM8039h5 != null) {
                        AbstractC4039n.m8038b(c4032g3, c4032gM8039h5, 0);
                        AbstractC4039n.m8038b(c4032g2, c4032g3, -this.f13682b.f13341R);
                        AbstractC4039n.m8038b(c4032g, c4032g2, c4033h.f13669g);
                        return;
                    }
                    return;
                }
                if ((c3958e7 instanceof C3963j) || c3958e7.f13334K == null || c3958e7.mo7900h(7).f13315d != null) {
                    return;
                }
                C3958e c3958e11 = this.f13682b;
                AbstractC4039n.m8038b(c4032g2, c3958e11.f13334K.f13358e.f13688h, c3958e11.m7907o());
                AbstractC4039n.m8038b(c4032g, c4032g2, c4033h.f13669g);
                C3958e c3958e12 = this.f13682b;
                if (c3958e12.f13378w) {
                    AbstractC4039n.m8038b(c4032g3, c4032g2, c3958e12.f13341R);
                    return;
                }
                return;
            }
        }
        if (z11 || this.f13684d != enumC3957d3) {
            c4033h.m8028b(this);
        } else {
            C3958e c3958e13 = this.f13682b;
            int i6 = c3958e13.f13366k;
            if (i6 == 2) {
                C3958e c3958e14 = c3958e13.f13334K;
                if (c3958e14 != null) {
                    C4033h c4033h2 = c3958e14.f13358e.f13685e;
                    c4033h.f13674l.add(c4033h2);
                    c4033h2.f13673k.add(c4033h);
                    c4033h.f13664b = true;
                    c4033h.f13673k.add(c4032g2);
                    c4033h.f13673k.add(c4032g);
                }
            } else if (i6 == 3 && !c3958e13.m7911s()) {
                C3958e c3958e15 = this.f13682b;
                if (c3958e15.f13365j != 3) {
                    C4033h c4033h3 = c3958e15.f13356d.f13685e;
                    c4033h.f13674l.add(c4033h3);
                    c4033h3.f13673k.add(c4033h);
                    c4033h.f13664b = true;
                    c4033h.f13673k.add(c4032g2);
                    c4033h.f13673k.add(c4032g);
                }
            }
        }
        C3958e c3958e16 = this.f13682b;
        C3956c[] c3956cArr2 = c3958e16.f13330G;
        C3956c c3956c5 = c3956cArr2[2];
        C3956c c3956c6 = c3956c5.f13315d;
        if (c3956c6 != null && c3956cArr2[3].f13315d != null) {
            if (c3958e16.m7911s()) {
                c4032g2.f13668f = this.f13682b.f13330G[2].m7887c();
                c4032g.f13668f = -this.f13682b.f13330G[3].m7887c();
            } else {
                C4032g c4032gM8039h6 = AbstractC4039n.m8039h(this.f13682b.f13330G[2]);
                C4032g c4032gM8039h7 = AbstractC4039n.m8039h(this.f13682b.f13330G[3]);
                c4032gM8039h6.m8028b(this);
                c4032gM8039h7.m8028b(this);
                this.f13690j = 4;
            }
            if (this.f13682b.f13378w) {
                m8041c(c4032g3, c4032g2, 1, this.f13680l);
            }
        } else if (c3956c6 != null) {
            C4032g c4032gM8039h8 = AbstractC4039n.m8039h(c3956c5);
            if (c4032gM8039h8 != null) {
                AbstractC4039n.m8038b(c4032g2, c4032gM8039h8, this.f13682b.f13330G[2].m7887c());
                m8041c(c4032g, c4032g2, 1, c4033h);
                if (this.f13682b.f13378w) {
                    m8041c(c4032g3, c4032g2, 1, this.f13680l);
                }
                if (this.f13684d == enumC3957d3) {
                    C3958e c3958e17 = this.f13682b;
                    if (c3958e17.f13337N > 0.0f) {
                        C4036k c4036k = c3958e17.f13356d;
                        if (c4036k.f13684d == enumC3957d3) {
                            c4036k.f13685e.f13673k.add(c4033h);
                            c4033h.f13674l.add(this.f13682b.f13356d.f13685e);
                            c4033h.f13663a = this;
                        }
                    }
                }
            }
        } else {
            C3956c c3956c7 = c3956cArr2[3];
            if (c3956c7.f13315d != null) {
                C4032g c4032gM8039h9 = AbstractC4039n.m8039h(c3956c7);
                if (c4032gM8039h9 != null) {
                    AbstractC4039n.m8038b(c4032g, c4032gM8039h9, -this.f13682b.f13330G[3].m7887c());
                    m8041c(c4032g2, c4032g, -1, c4033h);
                    if (this.f13682b.f13378w) {
                        m8041c(c4032g3, c4032g2, 1, this.f13680l);
                    }
                }
            } else {
                C3956c c3956c8 = c3956cArr2[4];
                if (c3956c8.f13315d != null) {
                    C4032g c4032gM8039h10 = AbstractC4039n.m8039h(c3956c8);
                    if (c4032gM8039h10 != null) {
                        AbstractC4039n.m8038b(c4032g3, c4032gM8039h10, 0);
                        m8041c(c4032g2, c4032g3, -1, this.f13680l);
                        m8041c(c4032g, c4032g2, 1, c4033h);
                    }
                } else if (!(c3958e16 instanceof C3963j) && (c3958e3 = c3958e16.f13334K) != null) {
                    AbstractC4039n.m8038b(c4032g2, c3958e3.f13358e.f13688h, c3958e16.m7907o());
                    m8041c(c4032g, c4032g2, 1, c4033h);
                    if (this.f13682b.f13378w) {
                        m8041c(c4032g3, c4032g2, 1, this.f13680l);
                    }
                    if (this.f13684d == enumC3957d3) {
                        C3958e c3958e18 = this.f13682b;
                        if (c3958e18.f13337N > 0.0f) {
                            C4036k c4036k2 = c3958e18.f13356d;
                            if (c4036k2.f13684d == enumC3957d3) {
                                c4036k2.f13685e.f13673k.add(c4033h);
                                c4033h.f13674l.add(this.f13682b.f13356d.f13685e);
                                c4033h.f13663a = this;
                            }
                        }
                    }
                }
            }
        }
        if (c4033h.f13674l.size() == 0) {
            c4033h.f13665c = true;
        }
    }

    @Override
    public final void mo8015e() {
        C4032g c4032g = this.f13688h;
        if (c4032g.f13672j) {
            this.f13682b.f13340Q = c4032g.f13669g;
        }
    }

    @Override
    public final void mo8016f() {
        this.f13683c = null;
        this.f13688h.m8029c();
        this.f13689i.m8029c();
        this.f13679k.m8029c();
        this.f13685e.m8029c();
        this.f13687g = false;
    }

    @Override
    public final boolean mo8018k() {
        return this.f13684d != EnumC3957d.f13321c || this.f13682b.f13366k == 0;
    }

    public final void m8037m() {
        this.f13687g = false;
        C4032g c4032g = this.f13688h;
        c4032g.m8029c();
        c4032g.f13672j = false;
        C4032g c4032g2 = this.f13689i;
        c4032g2.m8029c();
        c4032g2.f13672j = false;
        C4032g c4032g3 = this.f13679k;
        c4032g3.m8029c();
        c4032g3.f13672j = false;
        this.f13685e.f13672j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f13682b.f13348Y;
    }
}

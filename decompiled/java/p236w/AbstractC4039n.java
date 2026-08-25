package p236w;

import p215u.AbstractC3885h;
import p225v.C3956c;
import p225v.C3958e;
import p225v.EnumC3957d;

public abstract class AbstractC4039n implements InterfaceC4030e {

    public int f13681a;

    public C3958e f13682b;

    public C4037l f13683c;

    public EnumC3957d f13684d;

    public final C4033h f13685e = new C4033h(this);

    public int f13686f = 0;

    public boolean f13687g = false;

    public final C4032g f13688h = new C4032g(this);

    public final C4032g f13689i = new C4032g(this);

    public int f13690j = 1;

    public AbstractC4039n(C3958e c3958e) {
        this.f13682b = c3958e;
    }

    public static void m8038b(C4032g c4032g, C4032g c4032g2, int i6) {
        c4032g.f13674l.add(c4032g2);
        c4032g.f13668f = i6;
        c4032g2.f13673k.add(c4032g);
    }

    public static C4032g m8039h(C3956c c3956c) {
        C3956c c3956c2 = c3956c.f13315d;
        if (c3956c2 == null) {
            return null;
        }
        int iM7785a = AbstractC3885h.m7785a(c3956c2.f13314c);
        C3958e c3958e = c3956c2.f13313b;
        if (iM7785a == 1) {
            return c3958e.f13356d.f13688h;
        }
        if (iM7785a == 2) {
            return c3958e.f13358e.f13688h;
        }
        if (iM7785a == 3) {
            return c3958e.f13356d.f13689i;
        }
        if (iM7785a == 4) {
            return c3958e.f13358e.f13689i;
        }
        if (iM7785a != 5) {
            return null;
        }
        return c3958e.f13358e.f13679k;
    }

    public static C4032g m8040i(C3956c c3956c, int i6) {
        C3956c c3956c2 = c3956c.f13315d;
        if (c3956c2 == null) {
            return null;
        }
        C3958e c3958e = c3956c2.f13313b;
        AbstractC4039n abstractC4039n = i6 == 0 ? c3958e.f13356d : c3958e.f13358e;
        int iM7785a = AbstractC3885h.m7785a(c3956c2.f13314c);
        if (iM7785a == 1 || iM7785a == 2) {
            return abstractC4039n.f13688h;
        }
        if (iM7785a == 3 || iM7785a == 4) {
            return abstractC4039n.f13689i;
        }
        return null;
    }

    public final void m8041c(C4032g c4032g, C4032g c4032g2, int i6, C4033h c4033h) {
        c4032g.f13674l.add(c4032g2);
        c4032g.f13674l.add(this.f13685e);
        c4032g.f13670h = i6;
        c4032g.f13671i = c4033h;
        c4032g2.f13673k.add(c4032g);
        c4033h.f13673k.add(c4032g);
    }

    public abstract void mo8014d();

    public abstract void mo8015e();

    public abstract void mo8016f();

    public final int m8042g(int i6, int i10) {
        int iMax;
        if (i10 == 0) {
            C3958e c3958e = this.f13682b;
            int i11 = c3958e.f13369n;
            iMax = Math.max(c3958e.f13368m, i6);
            if (i11 > 0) {
                iMax = Math.min(i11, i6);
            }
            if (iMax == i6) {
                return i6;
            }
        } else {
            C3958e c3958e2 = this.f13682b;
            int i12 = c3958e2.f13372q;
            iMax = Math.max(c3958e2.f13371p, i6);
            if (i12 > 0) {
                iMax = Math.min(i12, i6);
            }
            if (iMax == i6) {
                return i6;
            }
        }
        return iMax;
    }

    public long mo8017j() {
        C4033h c4033h = this.f13685e;
        if (c4033h.f13672j) {
            return c4033h.f13669g;
        }
        return 0L;
    }

    public abstract boolean mo8018k();

    public final void m8043l(C3956c c3956c, C3956c c3956c2, int i6) {
        C4032g c4032gM8039h = m8039h(c3956c);
        C4032g c4032gM8039h2 = m8039h(c3956c2);
        if (c4032gM8039h.f13672j && c4032gM8039h2.f13672j) {
            int iM7887c = c3956c.m7887c() + c4032gM8039h.f13669g;
            int iM7887c2 = c4032gM8039h2.f13669g - c3956c2.m7887c();
            int i10 = iM7887c2 - iM7887c;
            C4033h c4033h = this.f13685e;
            if (!c4033h.f13672j) {
                EnumC3957d enumC3957d = this.f13684d;
                EnumC3957d enumC3957d2 = EnumC3957d.f13321c;
                if (enumC3957d == enumC3957d2) {
                    int i11 = this.f13681a;
                    if (i11 == 0) {
                        c4033h.mo8030d(m8042g(i10, i6));
                    } else if (i11 == 1) {
                        c4033h.mo8030d(Math.min(m8042g(c4033h.f13675m, i6), i10));
                    } else if (i11 == 2) {
                        C3958e c3958e = this.f13682b;
                        C3958e c3958e2 = c3958e.f13334K;
                        if (c3958e2 != null) {
                            C4033h c4033h2 = (i6 == 0 ? c3958e2.f13356d : c3958e2.f13358e).f13685e;
                            if (c4033h2.f13672j) {
                                c4033h.mo8030d(m8042g((int) ((c4033h2.f13669g * (i6 == 0 ? c3958e.f13370o : c3958e.f13373r)) + 0.5f), i6));
                            }
                        }
                    } else if (i11 == 3) {
                        C3958e c3958e3 = this.f13682b;
                        AbstractC4039n abstractC4039n = c3958e3.f13356d;
                        EnumC3957d enumC3957d3 = abstractC4039n.f13684d;
                        C4038m c4038m = c3958e3.f13358e;
                        if (enumC3957d3 != enumC3957d2 || abstractC4039n.f13681a != 3 || c4038m.f13684d != enumC3957d2 || c4038m.f13681a != 3) {
                            if (i6 == 0) {
                                abstractC4039n = c4038m;
                            }
                            C4033h c4033h3 = abstractC4039n.f13685e;
                            if (c4033h3.f13672j) {
                                float f = c3958e3.f13337N;
                                c4033h.mo8030d(i6 == 1 ? (int) ((c4033h3.f13669g / f) + 0.5f) : (int) ((f * c4033h3.f13669g) + 0.5f));
                            }
                        }
                    }
                }
            }
            if (c4033h.f13672j) {
                int i12 = c4033h.f13669g;
                C4032g c4032g = this.f13689i;
                C4032g c4032g2 = this.f13688h;
                if (i12 == i10) {
                    c4032g2.mo8030d(iM7887c);
                    c4032g.mo8030d(iM7887c2);
                    return;
                }
                C3958e c3958e4 = this.f13682b;
                float f3 = i6 == 0 ? c3958e4.f13344U : c3958e4.f13345V;
                if (c4032gM8039h == c4032gM8039h2) {
                    iM7887c = c4032gM8039h.f13669g;
                    iM7887c2 = c4032gM8039h2.f13669g;
                    f3 = 0.5f;
                }
                c4032g2.mo8030d((int) ((((iM7887c2 - iM7887c) - i12) * f3) + iM7887c + 0.5f));
                c4032g.mo8030d(c4032g2.f13669g + c4033h.f13669g);
            }
        }
    }
}

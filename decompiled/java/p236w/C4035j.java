package p236w;

import java.util.Iterator;
import p225v.C3954a;
import p225v.C3958e;

public final class C4035j extends AbstractC4039n {
    @Override
    public final void mo8013a(InterfaceC4030e interfaceC4030e) {
        C3954a c3954a = (C3954a) this.f13682b;
        int i6 = c3954a.f13292i0;
        C4032g c4032g = this.f13688h;
        Iterator it = c4032g.f13674l.iterator();
        int i10 = 0;
        int i11 = -1;
        while (it.hasNext()) {
            int i12 = ((C4032g) it.next()).f13669g;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (i6 == 0 || i6 == 2) {
            c4032g.mo8030d(i11 + c3954a.f13294k0);
        } else {
            c4032g.mo8030d(i10 + c3954a.f13294k0);
        }
    }

    @Override
    public final void mo8014d() {
        C3958e c3958e = this.f13682b;
        if (c3958e instanceof C3954a) {
            C4032g c4032g = this.f13688h;
            c4032g.f13664b = true;
            C3954a c3954a = (C3954a) c3958e;
            int i6 = c3954a.f13292i0;
            boolean z7 = c3954a.f13293j0;
            int i10 = 0;
            if (i6 == 0) {
                c4032g.f13667e = 4;
                while (i10 < c3954a.f13457h0) {
                    C3958e c3958e2 = c3954a.f13456g0[i10];
                    if (z7 || c3958e2.f13347X != 8) {
                        C4032g c4032g2 = c3958e2.f13356d.f13688h;
                        c4032g2.f13673k.add(c4032g);
                        c4032g.f13674l.add(c4032g2);
                    }
                    i10++;
                }
                m8032m(this.f13682b.f13356d.f13688h);
                m8032m(this.f13682b.f13356d.f13689i);
                return;
            }
            if (i6 == 1) {
                c4032g.f13667e = 5;
                while (i10 < c3954a.f13457h0) {
                    C3958e c3958e3 = c3954a.f13456g0[i10];
                    if (z7 || c3958e3.f13347X != 8) {
                        C4032g c4032g3 = c3958e3.f13356d.f13689i;
                        c4032g3.f13673k.add(c4032g);
                        c4032g.f13674l.add(c4032g3);
                    }
                    i10++;
                }
                m8032m(this.f13682b.f13356d.f13688h);
                m8032m(this.f13682b.f13356d.f13689i);
                return;
            }
            if (i6 == 2) {
                c4032g.f13667e = 6;
                while (i10 < c3954a.f13457h0) {
                    C3958e c3958e4 = c3954a.f13456g0[i10];
                    if (z7 || c3958e4.f13347X != 8) {
                        C4032g c4032g4 = c3958e4.f13358e.f13688h;
                        c4032g4.f13673k.add(c4032g);
                        c4032g.f13674l.add(c4032g4);
                    }
                    i10++;
                }
                m8032m(this.f13682b.f13358e.f13688h);
                m8032m(this.f13682b.f13358e.f13689i);
                return;
            }
            if (i6 != 3) {
                return;
            }
            c4032g.f13667e = 7;
            while (i10 < c3954a.f13457h0) {
                C3958e c3958e5 = c3954a.f13456g0[i10];
                if (z7 || c3958e5.f13347X != 8) {
                    C4032g c4032g5 = c3958e5.f13358e.f13689i;
                    c4032g5.f13673k.add(c4032g);
                    c4032g.f13674l.add(c4032g5);
                }
                i10++;
            }
            m8032m(this.f13682b.f13358e.f13688h);
            m8032m(this.f13682b.f13358e.f13689i);
        }
    }

    @Override
    public final void mo8015e() {
        C3958e c3958e = this.f13682b;
        if (c3958e instanceof C3954a) {
            int i6 = ((C3954a) c3958e).f13292i0;
            C4032g c4032g = this.f13688h;
            if (i6 == 0 || i6 == 1) {
                c3958e.f13339P = c4032g.f13669g;
            } else {
                c3958e.f13340Q = c4032g.f13669g;
            }
        }
    }

    @Override
    public final void mo8016f() {
        this.f13683c = null;
        this.f13688h.m8029c();
    }

    @Override
    public final boolean mo8018k() {
        return false;
    }

    public final void m8032m(C4032g c4032g) {
        C4032g c4032g2 = this.f13688h;
        c4032g2.f13673k.add(c4032g);
        c4032g.f13674l.add(c4032g2);
    }
}

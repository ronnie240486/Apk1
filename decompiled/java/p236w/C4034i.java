package p236w;

import p225v.C3958e;
import p225v.C3962i;

public final class C4034i extends AbstractC4039n {
    @Override
    public final void mo8013a(InterfaceC4030e interfaceC4030e) {
        C4032g c4032g = this.f13688h;
        if (c4032g.f13665c && !c4032g.f13672j) {
            c4032g.mo8030d((int) ((((C4032g) c4032g.f13674l.get(0)).f13669g * ((C3962i) this.f13682b).f13451g0) + 0.5f));
        }
    }

    @Override
    public final void mo8014d() {
        C3958e c3958e = this.f13682b;
        C3962i c3962i = (C3962i) c3958e;
        int i6 = c3962i.f13452h0;
        int i10 = c3962i.f13453i0;
        int i11 = c3962i.f13455k0;
        C4032g c4032g = this.f13688h;
        if (i11 == 1) {
            if (i6 != -1) {
                c4032g.f13674l.add(c3958e.f13334K.f13356d.f13688h);
                this.f13682b.f13334K.f13356d.f13688h.f13673k.add(c4032g);
                c4032g.f13668f = i6;
            } else if (i10 != -1) {
                c4032g.f13674l.add(c3958e.f13334K.f13356d.f13689i);
                this.f13682b.f13334K.f13356d.f13689i.f13673k.add(c4032g);
                c4032g.f13668f = -i10;
            } else {
                c4032g.f13664b = true;
                c4032g.f13674l.add(c3958e.f13334K.f13356d.f13689i);
                this.f13682b.f13334K.f13356d.f13689i.f13673k.add(c4032g);
            }
            m8031m(this.f13682b.f13356d.f13688h);
            m8031m(this.f13682b.f13356d.f13689i);
            return;
        }
        if (i6 != -1) {
            c4032g.f13674l.add(c3958e.f13334K.f13358e.f13688h);
            this.f13682b.f13334K.f13358e.f13688h.f13673k.add(c4032g);
            c4032g.f13668f = i6;
        } else if (i10 != -1) {
            c4032g.f13674l.add(c3958e.f13334K.f13358e.f13689i);
            this.f13682b.f13334K.f13358e.f13689i.f13673k.add(c4032g);
            c4032g.f13668f = -i10;
        } else {
            c4032g.f13664b = true;
            c4032g.f13674l.add(c3958e.f13334K.f13358e.f13689i);
            this.f13682b.f13334K.f13358e.f13689i.f13673k.add(c4032g);
        }
        m8031m(this.f13682b.f13358e.f13688h);
        m8031m(this.f13682b.f13358e.f13689i);
    }

    @Override
    public final void mo8015e() {
        C3958e c3958e = this.f13682b;
        int i6 = ((C3962i) c3958e).f13455k0;
        C4032g c4032g = this.f13688h;
        if (i6 == 1) {
            c3958e.f13339P = c4032g.f13669g;
        } else {
            c3958e.f13340Q = c4032g.f13669g;
        }
    }

    @Override
    public final void mo8016f() {
        this.f13688h.m8029c();
    }

    @Override
    public final boolean mo8018k() {
        return false;
    }

    public final void m8031m(C4032g c4032g) {
        C4032g c4032g2 = this.f13688h;
        c4032g2.f13673k.add(c4032g);
        c4032g.f13674l.add(c4032g2);
    }
}

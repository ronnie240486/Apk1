package p141n3;

import p055ea.AbstractC2460q;

public final class C3193g implements InterfaceC3190d, InterfaceC3189c {

    public final InterfaceC3190d f10741a;

    public final Object f10742b;

    public volatile C3192f f10743c;

    public volatile InterfaceC3189c f10744d;

    public int f10745e = 3;

    public int f10746f = 3;

    public boolean f10747g;

    public C3193g(Object obj, InterfaceC3190d interfaceC3190d) {
        this.f10742b = obj;
        this.f10741a = interfaceC3190d;
    }

    @Override
    public final boolean mo6401a() {
        boolean z7;
        synchronized (this.f10742b) {
            try {
                z7 = this.f10744d.mo6401a() || this.f10743c.mo6401a();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z7;
    }

    @Override
    public final boolean mo6402b() {
        boolean z7;
        synchronized (this.f10742b) {
            z7 = this.f10745e == 3;
        }
        return z7;
    }

    @Override
    public final boolean mo6403c(InterfaceC3189c interfaceC3189c) {
        boolean z7;
        synchronized (this.f10742b) {
            try {
                InterfaceC3190d interfaceC3190d = this.f10741a;
                z7 = (interfaceC3190d == null || interfaceC3190d.mo6403c(this)) && interfaceC3189c.equals(this.f10743c) && this.f10745e != 2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z7;
    }

    @Override
    public final void clear() {
        synchronized (this.f10742b) {
            this.f10747g = false;
            this.f10745e = 3;
            this.f10746f = 3;
            this.f10744d.clear();
            this.f10743c.clear();
        }
    }

    @Override
    public final boolean mo6404d(InterfaceC3189c interfaceC3189c) {
        if (!(interfaceC3189c instanceof C3193g)) {
            return false;
        }
        C3193g c3193g = (C3193g) interfaceC3189c;
        if (this.f10743c == null) {
            if (c3193g.f10743c != null) {
                return false;
            }
        } else if (!this.f10743c.mo6404d(c3193g.f10743c)) {
            return false;
        }
        if (this.f10744d == null) {
            if (c3193g.f10744d != null) {
                return false;
            }
        } else if (!this.f10744d.mo6404d(c3193g.f10744d)) {
            return false;
        }
        return true;
    }

    @Override
    public final void mo6405e() {
        synchronized (this.f10742b) {
            try {
                this.f10747g = true;
                try {
                    if (this.f10745e != 4 && this.f10746f != 1) {
                        this.f10746f = 1;
                        this.f10744d.mo6405e();
                    }
                    if (this.f10747g && this.f10745e != 1) {
                        this.f10745e = 1;
                        this.f10743c.mo6405e();
                    }
                    this.f10747g = false;
                } catch (Throwable th) {
                    this.f10747g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override
    public final boolean mo6406f(InterfaceC3189c interfaceC3189c) {
        boolean z7;
        synchronized (this.f10742b) {
            try {
                InterfaceC3190d interfaceC3190d = this.f10741a;
                z7 = (interfaceC3190d == null || interfaceC3190d.mo6406f(this)) && interfaceC3189c.equals(this.f10743c) && !mo6401a();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z7;
    }

    @Override
    public final void mo6407g(InterfaceC3189c interfaceC3189c) {
        synchronized (this.f10742b) {
            try {
                if (interfaceC3189c.equals(this.f10744d)) {
                    this.f10746f = 4;
                    return;
                }
                this.f10745e = 4;
                InterfaceC3190d interfaceC3190d = this.f10741a;
                if (interfaceC3190d != null) {
                    interfaceC3190d.mo6407g(this);
                }
                if (!AbstractC2460q.m5489c(this.f10746f)) {
                    this.f10744d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final InterfaceC3190d getRoot() {
        InterfaceC3190d root;
        synchronized (this.f10742b) {
            try {
                InterfaceC3190d interfaceC3190d = this.f10741a;
                root = interfaceC3190d != null ? interfaceC3190d.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override
    public final boolean mo6408h(InterfaceC3189c interfaceC3189c) {
        boolean z7;
        synchronized (this.f10742b) {
            try {
                InterfaceC3190d interfaceC3190d = this.f10741a;
                z7 = (interfaceC3190d == null || interfaceC3190d.mo6408h(this)) && (interfaceC3189c.equals(this.f10743c) || this.f10745e != 4);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z7;
    }

    @Override
    public final boolean mo6409i() {
        boolean z7;
        synchronized (this.f10742b) {
            z7 = this.f10745e == 4;
        }
        return z7;
    }

    @Override
    public final boolean isRunning() {
        boolean z7;
        synchronized (this.f10742b) {
            z7 = true;
            if (this.f10745e != 1) {
                z7 = false;
            }
        }
        return z7;
    }

    @Override
    public final void mo6410j(InterfaceC3189c interfaceC3189c) {
        synchronized (this.f10742b) {
            try {
                if (!interfaceC3189c.equals(this.f10743c)) {
                    this.f10746f = 5;
                    return;
                }
                this.f10745e = 5;
                InterfaceC3190d interfaceC3190d = this.f10741a;
                if (interfaceC3190d != null) {
                    interfaceC3190d.mo6410j(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void pause() {
        synchronized (this.f10742b) {
            try {
                if (!AbstractC2460q.m5489c(this.f10746f)) {
                    this.f10746f = 2;
                    this.f10744d.pause();
                }
                if (!AbstractC2460q.m5489c(this.f10745e)) {
                    this.f10745e = 2;
                    this.f10743c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

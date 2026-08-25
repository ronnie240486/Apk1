package p141n3;

public final class C3188b implements InterfaceC3190d, InterfaceC3189c {

    public final Object f10706a;

    public final Object f10707b;

    public volatile InterfaceC3189c f10708c;

    public volatile InterfaceC3189c f10709d;

    public int f10710e = 3;

    public int f10711f = 3;

    public C3188b(Object obj, InterfaceC3190d interfaceC3190d) {
        this.f10706a = obj;
        this.f10707b = interfaceC3190d;
    }

    @Override
    public final boolean mo6401a() {
        boolean z7;
        synchronized (this.f10706a) {
            try {
                z7 = this.f10708c.mo6401a() || this.f10709d.mo6401a();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z7;
    }

    @Override
    public final boolean mo6402b() {
        boolean z7;
        synchronized (this.f10706a) {
            try {
                z7 = this.f10710e == 3 && this.f10711f == 3;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z7;
    }

    @Override
    public final boolean mo6403c(InterfaceC3189c interfaceC3189c) {
        boolean z7;
        synchronized (this.f10706a) {
            ?? r10 = this.f10707b;
            z7 = (r10 == 0 || r10.mo6403c(this)) && interfaceC3189c.equals(this.f10708c);
        }
        return z7;
    }

    @Override
    public final void clear() {
        synchronized (this.f10706a) {
            try {
                this.f10710e = 3;
                this.f10708c.clear();
                if (this.f10711f != 3) {
                    this.f10711f = 3;
                    this.f10709d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final boolean mo6404d(InterfaceC3189c interfaceC3189c) {
        if (!(interfaceC3189c instanceof C3188b)) {
            return false;
        }
        C3188b c3188b = (C3188b) interfaceC3189c;
        return this.f10708c.mo6404d(c3188b.f10708c) && this.f10709d.mo6404d(c3188b.f10709d);
    }

    @Override
    public final void mo6405e() {
        synchronized (this.f10706a) {
            try {
                if (this.f10710e != 1) {
                    this.f10710e = 1;
                    this.f10708c.mo6405e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final boolean mo6406f(InterfaceC3189c interfaceC3189c) {
        boolean z7;
        boolean zEquals;
        int i6;
        synchronized (this.f10706a) {
            ?? r10 = this.f10707b;
            z7 = false;
            if (r10 == 0 || r10.mo6406f(this)) {
                if (this.f10710e != 5) {
                    zEquals = interfaceC3189c.equals(this.f10708c);
                } else {
                    zEquals = interfaceC3189c.equals(this.f10709d) && ((i6 = this.f10711f) == 4 || i6 == 5);
                }
                if (zEquals) {
                    z7 = true;
                }
            }
        }
        return z7;
    }

    @Override
    public final void mo6407g(InterfaceC3189c interfaceC3189c) {
        synchronized (this.f10706a) {
            try {
                if (interfaceC3189c.equals(this.f10708c)) {
                    this.f10710e = 4;
                } else if (interfaceC3189c.equals(this.f10709d)) {
                    this.f10711f = 4;
                }
                ?? r10 = this.f10707b;
                if (r10 != 0) {
                    r10.mo6407g(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final InterfaceC3190d getRoot() {
        InterfaceC3190d root;
        synchronized (this.f10706a) {
            try {
                ?? r10 = this.f10707b;
                root = r10 != 0 ? r10.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override
    public final boolean mo6408h(InterfaceC3189c interfaceC3189c) {
        boolean z7;
        synchronized (this.f10706a) {
            ?? r10 = this.f10707b;
            z7 = r10 == 0 || r10.mo6408h(this);
        }
        return z7;
    }

    @Override
    public final boolean mo6409i() {
        boolean z7;
        synchronized (this.f10706a) {
            try {
                z7 = this.f10710e == 4 || this.f10711f == 4;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z7;
    }

    @Override
    public final boolean isRunning() {
        boolean z7;
        synchronized (this.f10706a) {
            try {
                z7 = true;
                if (this.f10710e != 1 && this.f10711f != 1) {
                    z7 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z7;
    }

    @Override
    public final void mo6410j(InterfaceC3189c interfaceC3189c) {
        synchronized (this.f10706a) {
            try {
                if (interfaceC3189c.equals(this.f10709d)) {
                    this.f10711f = 5;
                    ?? r10 = this.f10707b;
                    if (r10 != 0) {
                        r10.mo6410j(this);
                    }
                    return;
                }
                this.f10710e = 5;
                if (this.f10711f != 1) {
                    this.f10711f = 1;
                    this.f10709d.mo6405e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void pause() {
        synchronized (this.f10706a) {
            try {
                if (this.f10710e == 1) {
                    this.f10710e = 2;
                    this.f10708c.pause();
                }
                if (this.f10711f == 1) {
                    this.f10711f = 2;
                    this.f10709d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

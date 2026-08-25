package p169p8;

import com.bumptech.glide.AbstractC1466d;
import java.util.concurrent.atomic.AtomicInteger;
import p090i8.AbstractC2711e;
import p090i8.InterfaceC2709c;
import p102j8.InterfaceC2787b;
import p114k8.C2904d;
import p203s8.C3726c;
import p203s8.InterfaceC3724a;
import p203s8.InterfaceC3725b;

public final class RunnableC3379d extends AtomicInteger implements InterfaceC2709c, Runnable, InterfaceC3724a {

    public final InterfaceC2709c f11407a;

    public final AbstractC2711e f11408b;

    public final int f11409c;

    public InterfaceC3725b f11410d;

    public Object f11411e;

    public Throwable f11412f;

    public volatile boolean f11413g;

    public volatile boolean f11414h;

    public int f11415i;

    public boolean f11416j;

    public RunnableC3379d(InterfaceC2709c interfaceC2709c, AbstractC2711e abstractC2711e, int i6) {
        this.f11407a = interfaceC2709c;
        this.f11408b = abstractC2711e;
        this.f11409c = i6;
    }

    @Override
    public final void mo5675a() {
        if (this.f11414h) {
            return;
        }
        this.f11414h = true;
        this.f11411e.mo5675a();
        this.f11408b.mo5675a();
        if (this.f11416j || getAndIncrement() != 0) {
            return;
        }
        this.f11410d.clear();
    }

    @Override
    public final void mo5702b() {
        if (this.f11413g) {
            return;
        }
        this.f11413g = true;
        if (getAndIncrement() == 0) {
            this.f11408b.mo5706c(this);
        }
    }

    @Override
    public final void mo5703c(InterfaceC2787b interfaceC2787b) {
        if (this.f11411e != null) {
            interfaceC2787b.mo5675a();
            AbstractC1466d.m3505y(new C2904d("Disposable already set!"));
            return;
        }
        this.f11411e = interfaceC2787b;
        if (interfaceC2787b instanceof InterfaceC3724a) {
            InterfaceC3724a interfaceC3724a = (InterfaceC3724a) interfaceC2787b;
            int iMo6115e = interfaceC3724a.mo6115e();
            if (iMo6115e == 1) {
                this.f11415i = iMo6115e;
                this.f11410d = interfaceC3724a;
                this.f11413g = true;
                this.f11407a.mo5703c(this);
                if (getAndIncrement() == 0) {
                    this.f11408b.mo5706c(this);
                    return;
                }
                return;
            }
            if (iMo6115e == 2) {
                this.f11415i = iMo6115e;
                this.f11410d = interfaceC3724a;
                this.f11407a.mo5703c(this);
                return;
            }
        }
        this.f11410d = new C3726c(this.f11409c);
        this.f11407a.mo5703c(this);
    }

    @Override
    public final void clear() {
        this.f11410d.clear();
    }

    @Override
    public final void mo5704d(Throwable th) {
        if (this.f11413g) {
            AbstractC1466d.m3505y(th);
            return;
        }
        this.f11412f = th;
        this.f11413g = true;
        if (getAndIncrement() == 0) {
            this.f11408b.mo5706c(this);
        }
    }

    @Override
    public final int mo6115e() {
        this.f11416j = true;
        return 2;
    }

    @Override
    public final void mo5705f(Object obj) {
        if (this.f11413g) {
            return;
        }
        if (this.f11415i != 2) {
            this.f11410d.offer(obj);
        }
        if (getAndIncrement() == 0) {
            this.f11408b.mo5706c(this);
        }
    }

    public final boolean m6874g(boolean z7, boolean z10, InterfaceC2709c interfaceC2709c) {
        if (this.f11414h) {
            this.f11410d.clear();
            return true;
        }
        if (!z7) {
            return false;
        }
        Throwable th = this.f11412f;
        if (th != null) {
            this.f11414h = true;
            this.f11410d.clear();
            interfaceC2709c.mo5704d(th);
            this.f11408b.mo5675a();
            return true;
        }
        if (!z10) {
            return false;
        }
        this.f11414h = true;
        interfaceC2709c.mo5702b();
        this.f11408b.mo5675a();
        return true;
    }

    @Override
    public final boolean isEmpty() {
        return this.f11410d.isEmpty();
    }

    @Override
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override
    public final Object poll() {
        return this.f11410d.poll();
    }

    @Override
    public final void run() {
        if (this.f11416j) {
            int iAddAndGet = 1;
            while (!this.f11414h) {
                boolean z7 = this.f11413g;
                Throwable th = this.f11412f;
                if (z7 && th != null) {
                    this.f11414h = true;
                    this.f11407a.mo5704d(this.f11412f);
                    this.f11408b.mo5675a();
                    return;
                }
                this.f11407a.mo5705f(null);
                if (z7) {
                    this.f11414h = true;
                    Throwable th2 = this.f11412f;
                    if (th2 != null) {
                        this.f11407a.mo5704d(th2);
                    } else {
                        this.f11407a.mo5702b();
                    }
                    this.f11408b.mo5675a();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            return;
        }
        InterfaceC3725b interfaceC3725b = this.f11410d;
        InterfaceC2709c interfaceC2709c = this.f11407a;
        int iAddAndGet2 = 1;
        while (!m6874g(this.f11413g, interfaceC3725b.isEmpty(), interfaceC2709c)) {
            while (true) {
                boolean z10 = this.f11413g;
                try {
                    Object objPoll = interfaceC3725b.poll();
                    boolean z11 = objPoll == null;
                    if (m6874g(z10, z11, interfaceC2709c)) {
                        return;
                    }
                    if (z11) {
                        break;
                    } else {
                        interfaceC2709c.mo5705f(objPoll);
                    }
                } catch (Throwable th3) {
                    AbstractC1466d.m3484G(th3);
                    this.f11414h = true;
                    this.f11411e.mo5675a();
                    interfaceC3725b.clear();
                    interfaceC2709c.mo5704d(th3);
                    this.f11408b.mo5675a();
                    return;
                }
            }
            iAddAndGet2 = addAndGet(-iAddAndGet2);
            if (iAddAndGet2 == 0) {
                return;
            }
        }
    }
}

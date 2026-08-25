package p130m2;

import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.InterfaceC0553v;
import androidx.lifecycle.InterfaceC0555w;
import java.util.concurrent.CancellationException;
import p025c2.C1391l;
import p103j9.AbstractC2796i;
import p150o2.C3246a;
import p185r2.AbstractC3587f;
import p213t9.AbstractC3819b0;
import p213t9.AbstractC3865u;
import p213t9.C3840i0;
import p213t9.C3871x;
import p213t9.InterfaceC3858q0;
import p254x9.AbstractC4172n;
import p275z9.C4362d;

public final class C3071s implements InterfaceC3068p {

    public final C1391l f10523a;

    public final C3061i f10524b;

    public final C3246a f10525c;

    public final AbstractC0541p f10526d;

    public final InterfaceC3858q0 f10527e;

    public C3071s(C1391l c1391l, C3061i c3061i, C3246a c3246a, AbstractC0541p abstractC0541p, InterfaceC3858q0 interfaceC3858q0) {
        this.f10523a = c1391l;
        this.f10524b = c3061i;
        this.f10525c = c3246a;
        this.f10526d = abstractC0541p;
        this.f10527e = interfaceC3858q0;
    }

    @Override
    public final void mo1491b(InterfaceC0555w interfaceC0555w) {
        AbstractC2796i.m5785f(interfaceC0555w, "owner");
    }

    @Override
    public final void mo1492c(InterfaceC0555w interfaceC0555w) {
        AbstractC2796i.m5785f(interfaceC0555w, "owner");
    }

    @Override
    public final void mo6106f() {
        C3246a c3246a = this.f10525c;
        if (c3246a.f10870b.isAttachedToWindow()) {
            return;
        }
        ViewOnAttachStateChangeListenerC3073u viewOnAttachStateChangeListenerC3073uM7210c = AbstractC3587f.m7210c(c3246a.f10870b);
        C3071s c3071s = viewOnAttachStateChangeListenerC3073uM7210c.f10532d;
        if (c3071s != null) {
            AbstractC3865u.m7688c(c3071s.f10527e);
            C3246a c3246a2 = c3071s.f10525c;
            boolean z7 = c3246a2 instanceof InterfaceC0553v;
            AbstractC0541p abstractC0541p = c3071s.f10526d;
            if (z7) {
                abstractC0541p.mo1510c(c3246a2);
            }
            abstractC0541p.mo1510c(c3071s);
        }
        viewOnAttachStateChangeListenerC3073uM7210c.f10532d = this;
        throw new CancellationException("'ViewTarget.view' must be attached to a window.");
    }

    @Override
    public final void onDestroy(InterfaceC0555w interfaceC0555w) {
        ViewOnAttachStateChangeListenerC3073u viewOnAttachStateChangeListenerC3073uM7210c = AbstractC3587f.m7210c(this.f10525c.f10870b);
        synchronized (viewOnAttachStateChangeListenerC3073uM7210c) {
            try {
                C3871x c3871x = viewOnAttachStateChangeListenerC3073uM7210c.f10531c;
                if (c3871x != null) {
                    AbstractC3865u.m7688c(c3871x);
                }
                C3840i0 c3840i0 = C3840i0.f12924a;
                C4362d c4362d = AbstractC3819b0.f12901a;
                viewOnAttachStateChangeListenerC3073uM7210c.f10531c = AbstractC3865u.m7696k(c3840i0, AbstractC4172n.f14112a.f13237f, new C3072t(viewOnAttachStateChangeListenerC3073uM7210c, null), 2);
                viewOnAttachStateChangeListenerC3073uM7210c.f10530b = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void onStart(InterfaceC0555w interfaceC0555w) {
        AbstractC2796i.m5785f(interfaceC0555w, "owner");
    }

    @Override
    public final void start() {
        AbstractC0541p abstractC0541p = this.f10526d;
        abstractC0541p.mo1508a(this);
        C3246a c3246a = this.f10525c;
        if (c3246a instanceof InterfaceC0553v) {
            abstractC0541p.mo1510c(c3246a);
            abstractC0541p.mo1508a(c3246a);
        }
        ViewOnAttachStateChangeListenerC3073u viewOnAttachStateChangeListenerC3073uM7210c = AbstractC3587f.m7210c(c3246a.f10870b);
        C3071s c3071s = viewOnAttachStateChangeListenerC3073uM7210c.f10532d;
        if (c3071s != null) {
            AbstractC3865u.m7688c(c3071s.f10527e);
            C3246a c3246a2 = c3071s.f10525c;
            boolean z7 = c3246a2 instanceof InterfaceC0553v;
            AbstractC0541p abstractC0541p2 = c3071s.f10526d;
            if (z7) {
                abstractC0541p2.mo1510c(c3246a2);
            }
            abstractC0541p2.mo1510c(c3071s);
        }
        viewOnAttachStateChangeListenerC3073uM7210c.f10532d = this;
    }

    @Override
    public final void mo6105a() {
    }

    @Override
    public final void mo1493e(InterfaceC0555w interfaceC0555w) {
    }

    @Override
    public final void onStop(InterfaceC0555w interfaceC0555w) {
    }
}

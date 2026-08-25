package p155o8;

import com.bumptech.glide.AbstractC1466d;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import p090i8.InterfaceC2709c;
import p102j8.InterfaceC2787b;
import p114k8.C2902b;
import p126l8.InterfaceC3013a;
import p135m8.EnumC3085a;
import p145n8.AbstractC3220a;
import p221u6.C3905e;
import p249x4.C4112e;

public final class C3276a extends AtomicReference implements InterfaceC2709c, InterfaceC2787b {

    public final InterfaceC3013a f10964a;

    public final C4112e f10965b;

    public final C4112e f10966c;

    public final C3905e f10967d;

    public C3276a(InterfaceC3013a interfaceC3013a) {
        C4112e c4112e = AbstractC3220a.f10823d;
        C4112e c4112e2 = AbstractC3220a.f10821b;
        C3905e c3905e = AbstractC3220a.f10822c;
        this.f10964a = interfaceC3013a;
        this.f10965b = c4112e;
        this.f10966c = c4112e2;
        this.f10967d = c3905e;
    }

    @Override
    public final void mo5675a() {
        EnumC3085a.m6113b(this);
    }

    @Override
    public final void mo5702b() {
        if (m6563g()) {
            return;
        }
        lazySet(EnumC3085a.f10547a);
        try {
            this.f10966c.getClass();
        } catch (Throwable th) {
            AbstractC1466d.m3484G(th);
            AbstractC1466d.m3505y(th);
        }
    }

    @Override
    public final void mo5703c(InterfaceC2787b interfaceC2787b) {
        if (EnumC3085a.m6114c(this, interfaceC2787b)) {
            try {
                this.f10967d.getClass();
            } catch (Throwable th) {
                AbstractC1466d.m3484G(th);
                interfaceC2787b.mo5675a();
                mo5704d(th);
            }
        }
    }

    @Override
    public final void mo5704d(Throwable th) {
        if (m6563g()) {
            AbstractC1466d.m3505y(th);
            return;
        }
        lazySet(EnumC3085a.f10547a);
        try {
            this.f10965b.accept(th);
        } catch (Throwable th2) {
            AbstractC1466d.m3484G(th2);
            AbstractC1466d.m3505y(new C2902b(Arrays.asList(th, th2)));
        }
    }

    @Override
    public final void mo5705f(Object obj) {
        if (m6563g()) {
            return;
        }
        try {
            this.f10964a.accept(obj);
        } catch (Throwable th) {
            AbstractC1466d.m3484G(th);
            ((InterfaceC2787b) get()).mo5675a();
            mo5704d(th);
        }
    }

    public final boolean m6563g() {
        return get() == EnumC3085a.f10547a;
    }
}

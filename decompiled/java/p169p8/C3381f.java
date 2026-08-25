package p169p8;

import java.util.concurrent.atomic.AtomicReference;
import p090i8.InterfaceC2709c;
import p102j8.InterfaceC2787b;
import p135m8.EnumC3085a;

public final class C3381f extends AtomicReference implements InterfaceC2709c, InterfaceC2787b {

    public final InterfaceC2709c f11419a;

    public final AtomicReference f11420b = new AtomicReference();

    public C3381f(InterfaceC2709c interfaceC2709c) {
        this.f11419a = interfaceC2709c;
    }

    @Override
    public final void mo5675a() {
        EnumC3085a.m6113b(this.f11420b);
        EnumC3085a.m6113b(this);
    }

    @Override
    public final void mo5702b() {
        this.f11419a.mo5702b();
    }

    @Override
    public final void mo5703c(InterfaceC2787b interfaceC2787b) {
        EnumC3085a.m6114c(this.f11420b, interfaceC2787b);
    }

    @Override
    public final void mo5704d(Throwable th) {
        this.f11419a.mo5704d(th);
    }

    @Override
    public final void mo5705f(Object obj) {
        this.f11419a.mo5705f(obj);
    }
}

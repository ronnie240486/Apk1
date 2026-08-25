package p169p8;

import java.util.concurrent.atomic.AtomicReference;
import p090i8.InterfaceC2709c;
import p102j8.InterfaceC2787b;
import p135m8.EnumC3085a;

public final class C3377b extends AtomicReference implements InterfaceC2787b {

    public final InterfaceC2709c f11405a;

    public C3377b(InterfaceC2709c interfaceC2709c) {
        this.f11405a = interfaceC2709c;
    }

    @Override
    public final void mo5675a() {
        EnumC3085a.m6113b(this);
    }

    public final boolean m6872b() {
        return ((InterfaceC2787b) get()) == EnumC3085a.f10547a;
    }

    public final void m6873c(Object obj) {
        if (m6872b()) {
            return;
        }
        this.f11405a.mo5705f(obj);
    }

    @Override
    public final String toString() {
        return C3377b.class.getSimpleName() + "{" + super.toString() + "}";
    }
}

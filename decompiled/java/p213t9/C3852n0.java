package p213t9;

import p091i9.InterfaceC2724l;
import p243w8.C4070l;

public final class C3852n0 implements InterfaceC3820b1, InterfaceC2724l {

    public final InterfaceC2724l f12944a;

    public C3852n0(InterfaceC2724l interfaceC2724l) {
        this.f12944a = interfaceC2724l;
    }

    public final void m7681a(Throwable th) {
        this.f12944a.invoke(th);
    }

    @Override
    public final Object invoke(Object obj) {
        m7681a((Throwable) obj);
        return C4070l.f13734a;
    }

    public final String toString() {
        return "InvokeOnCancel[" + this.f12944a.getClass().getSimpleName() + '@' + AbstractC3865u.m7691f(this) + ']';
    }
}

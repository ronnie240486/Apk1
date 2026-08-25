package p213t9;

import p008a9.InterfaceC0077g;
import p008a9.InterfaceC0078h;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;

public final class C3853o implements InterfaceC0078h {

    public final AbstractC2797j f12945a;

    public final InterfaceC0078h f12946b;

    public C3853o(InterfaceC0078h interfaceC0078h, InterfaceC2724l interfaceC2724l) {
        AbstractC2796i.m5785f(interfaceC0078h, "baseKey");
        this.f12945a = (AbstractC2797j) interfaceC2724l;
        this.f12946b = interfaceC0078h instanceof C3853o ? ((C3853o) interfaceC0078h).f12946b : interfaceC0078h;
    }

    public final InterfaceC0077g m7682a(AbstractC3855p abstractC3855p) {
        return (InterfaceC0077g) this.f12945a.invoke(abstractC3855p);
    }
}

package androidx.lifecycle;

import p008a9.InterfaceC0079i;
import p103j9.AbstractC2796i;
import p213t9.AbstractC3865u;
import p213t9.InterfaceC3861s;

public final class C0545r implements InterfaceC0551u, InterfaceC3861s {

    public final AbstractC0541p f2525a;

    public final InterfaceC0079i f2526b;

    public C0545r(AbstractC0541p abstractC0541p, InterfaceC0079i interfaceC0079i) {
        AbstractC2796i.m5785f(interfaceC0079i, "coroutineContext");
        this.f2525a = abstractC0541p;
        this.f2526b = interfaceC0079i;
        if (abstractC0541p.mo1509b() == EnumC0539o.f2507a) {
            AbstractC3865u.m7686a(interfaceC0079i, null);
        }
    }

    @Override
    public final InterfaceC0079i mo1512d() {
        return this.f2526b;
    }

    @Override
    public final void onStateChanged(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
        AbstractC0541p abstractC0541p = this.f2525a;
        if (abstractC0541p.mo1509b().compareTo(EnumC0539o.f2507a) <= 0) {
            abstractC0541p.mo1510c(this);
            AbstractC3865u.m7686a(this.f2526b, null);
        }
    }
}

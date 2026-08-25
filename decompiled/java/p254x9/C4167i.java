package p254x9;

import p000a.AbstractC0004e;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2790c;
import p103j9.AbstractC2802o;
import p170p9.InterfaceC3383a;
import p213t9.AbstractC3865u;

public final class C4167i extends AbstractC2790c implements InterfaceC2713a, InterfaceC3383a {

    public final boolean f14099g;

    public C4167i(C4168j c4168j) {
        super(c4168j, AbstractC3865u.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", true);
        this.f14099g = false;
    }

    public final InterfaceC3383a m8214b() {
        if (!this.f14099g) {
            InterfaceC3383a interfaceC3383a = this.f9524a;
            if (interfaceC3383a != null) {
                return interfaceC3383a;
            }
            AbstractC2802o.f9541a.getClass();
            this.f9524a = this;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C4167i) {
            C4167i c4167i = (C4167i) obj;
            return m5776a().equals(c4167i.m5776a()) && this.f9527d.equals(c4167i.f9527d) && this.f9528e.equals(c4167i.f9528e) && this.f9525b.equals(c4167i.f9525b);
        }
        if (obj instanceof C4167i) {
            return obj.equals(m8214b());
        }
        return false;
    }

    public final int hashCode() {
        return this.f9528e.hashCode() + AbstractC0004e.m14h(m5776a().hashCode() * 31, 31, this.f9527d);
    }

    @Override
    public final Object invoke() {
        return this.f9525b.getClass().getSimpleName();
    }

    public final String toString() {
        InterfaceC3383a interfaceC3383aM8214b = m8214b();
        return interfaceC3383aM8214b != this ? interfaceC3383aM8214b.toString() : AbstractC0004e.m26t(new StringBuilder("property "), this.f9527d, " (Kotlin reflection is not available)");
    }
}

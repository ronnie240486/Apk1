package p103j9;

import p000a.AbstractC0004e;
import p170p9.InterfaceC3383a;
import p243w8.InterfaceC4059a;

public abstract class AbstractC2795h extends AbstractC2790c implements InterfaceC2794g, InterfaceC3383a, InterfaceC4059a {

    public final int f9534g;

    public final int f9535h;

    public AbstractC2795h(int i6, Class cls, String str, String str2, int i10) {
        super(C2789b.f9523a, cls, str, str2, (i10 & 1) == 1);
        this.f9534g = i6;
        this.f9535h = 0;
    }

    public final InterfaceC3383a m5779b() {
        AbstractC2802o.f9541a.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2795h) {
            AbstractC2795h abstractC2795h = (AbstractC2795h) obj;
            return this.f9527d.equals(abstractC2795h.f9527d) && this.f9528e.equals(abstractC2795h.f9528e) && this.f9535h == abstractC2795h.f9535h && this.f9534g == abstractC2795h.f9534g && this.f9525b.equals(abstractC2795h.f9525b) && m5776a().equals(abstractC2795h.m5776a());
        }
        if (!(obj instanceof AbstractC2795h)) {
            return false;
        }
        InterfaceC3383a interfaceC3383a = this.f9524a;
        if (interfaceC3383a == null) {
            m5779b();
            this.f9524a = this;
            interfaceC3383a = this;
        }
        return obj.equals(interfaceC3383a);
    }

    @Override
    public final int getArity() {
        return this.f9534g;
    }

    public final int hashCode() {
        m5776a();
        return this.f9528e.hashCode() + AbstractC0004e.m14h(m5776a().hashCode() * 31, 31, this.f9527d);
    }

    public final String toString() {
        InterfaceC3383a interfaceC3383a = this.f9524a;
        if (interfaceC3383a == null) {
            m5779b();
            this.f9524a = this;
            interfaceC3383a = this;
        }
        if (interfaceC3383a != this) {
            return interfaceC3383a.toString();
        }
        String str = this.f9527d;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : AbstractC0004e.m24r("function ", str, " (Kotlin reflection is not available)");
    }
}

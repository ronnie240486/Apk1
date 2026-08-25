package p154o7;

import p125l7.AbstractC3011r;
import p125l7.C3004k;
import p125l7.InterfaceC3012s;
import p202s7.C3723a;

public final class C3273n implements InterfaceC3012s {

    public final Class f10934a;

    public final Class f10935b;

    public final AbstractC3011r f10936c;

    public C3273n(Class cls, Class cls2, AbstractC3011r abstractC3011r) {
        this.f10934a = cls;
        this.f10935b = cls2;
        this.f10936c = abstractC3011r;
    }

    @Override
    public final AbstractC3011r mo6089a(C3004k c3004k, C3723a c3723a) {
        Class cls = this.f10934a;
        Class cls2 = c3723a.f12480a;
        if (cls2 == cls || cls2 == this.f10935b) {
            return this.f10936c;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f10935b.getName() + "+" + this.f10934a.getName() + ",adapter=" + this.f10936c + "]";
    }
}

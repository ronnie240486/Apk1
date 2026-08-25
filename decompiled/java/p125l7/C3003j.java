package p125l7;

import p212t7.C3812a;
import p212t7.C3813b;

public final class C3003j extends AbstractC3011r {

    public AbstractC3011r f10294a;

    @Override
    public final Object mo6077a(C3812a c3812a) {
        AbstractC3011r abstractC3011r = this.f10294a;
        if (abstractC3011r != null) {
            return abstractC3011r.mo6077a(c3812a);
        }
        throw new IllegalStateException();
    }

    @Override
    public final void mo6078b(C3813b c3813b, Object obj) {
        AbstractC3011r abstractC3011r = this.f10294a;
        if (abstractC3011r == null) {
            throw new IllegalStateException();
        }
        abstractC3011r.mo6078b(c3813b, obj);
    }
}

package p154o7;

import p125l7.AbstractC3011r;
import p125l7.C3004k;
import p125l7.InterfaceC3012s;
import p202s7.C3723a;

public final class C3272m implements InterfaceC3012s {

    public final int f10931a;

    public final Class f10932b;

    public final AbstractC3011r f10933c;

    public C3272m(Class cls, AbstractC3011r abstractC3011r, int i6) {
        this.f10931a = i6;
        this.f10932b = cls;
        this.f10933c = abstractC3011r;
    }

    @Override
    public final AbstractC3011r mo6089a(C3004k c3004k, C3723a c3723a) {
        switch (this.f10931a) {
            case 0:
                if (c3723a.f12480a == this.f10932b) {
                    return this.f10933c;
                }
                return null;
            default:
                Class cls = this.f10932b;
                Class<?> cls2 = c3723a.f12480a;
                if (cls.isAssignableFrom(cls2)) {
                    return new C3261b(this, cls2);
                }
                return null;
        }
    }

    public final String toString() {
        switch (this.f10931a) {
            case 0:
                return "Factory[type=" + this.f10932b.getName() + ",adapter=" + this.f10933c + "]";
            default:
                return "Factory[typeHierarchy=" + this.f10932b.getName() + ",adapter=" + this.f10933c + "]";
        }
    }
}

package p265ya;

import p003a2.AbstractC0032a;
import p245wa.C4074b;
import va.AbstractC4025a;

public final class C4279a extends AbstractC4025a {

    public static final Object[] f14500b = new Object[0];

    public final C4281c f14501a;

    public C4279a(C4281c c4281c) {
        this.f14501a = c4281c;
    }

    public static C4279a m8342a() {
        return new C4279a(new C4281c());
    }

    public final void m8343b(Object obj) {
        if (this.f14501a.f14504a == null || this.f14501a.f14505b) {
            if (obj == null) {
                obj = C4074b.f13739b;
            }
            C4281c c4281c = this.f14501a;
            c4281c.f14504a = obj;
            AbstractC0032a[] abstractC0032aArr = ((C4280b) c4281c.get()).f14503a;
        }
    }
}

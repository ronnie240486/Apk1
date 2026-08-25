package p181q9;

import java.util.Iterator;
import java.util.List;
import p030c9.AbstractC1438h;
import p091i9.InterfaceC2728p;

public final class C3549g implements InterfaceC3545c {

    public final int f11951a;

    public final Object f11952b;

    public C3549g(int i6, Object obj) {
        this.f11951a = i6;
        this.f11952b = obj;
    }

    @Override
    public final Iterator iterator() {
        switch (this.f11951a) {
            case 0:
                AbstractC1438h abstractC1438h = (AbstractC1438h) this.f11952b;
                C3546d c3546d = new C3546d();
                c3546d.f11950d = abstractC1438h.create(c3546d, c3546d);
                return c3546d;
            case 1:
                return (Iterator) this.f11952b;
            default:
                return ((List) this.f11952b).iterator();
        }
    }

    public C3549g(InterfaceC2728p interfaceC2728p) {
        this.f11951a = 0;
        this.f11952b = (AbstractC1438h) interfaceC2728p;
    }
}

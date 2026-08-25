package p041d7;

import p020b7.InterfaceC1354n;

public final class C2318x0 implements InterfaceC1354n {

    public final Object f8087a;

    public final C2324y0 f8088b;

    public C2318x0(C2324y0 c2324y0, Object obj) {
        this.f8088b = c2324y0;
        this.f8087a = obj;
    }

    @Override
    public final boolean apply(Object obj) {
        C2324y0 c2324y0 = this.f8088b;
        c2324y0.getClass();
        return c2324y0.f8101g.apply(new C2281r1(this.f8087a, obj));
    }
}

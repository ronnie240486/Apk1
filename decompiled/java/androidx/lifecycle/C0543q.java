package androidx.lifecycle;

import p008a9.InterfaceC0074d;
import p030c9.AbstractC1439i;
import p091i9.InterfaceC2728p;
import p156o9.AbstractC3280d;
import p213t9.AbstractC3865u;
import p213t9.InterfaceC3861s;
import p243w8.C4070l;

public final class C0543q extends AbstractC1439i implements InterfaceC2728p {

    public Object f2519b;

    public final C0545r f2520c;

    public C0543q(C0545r c0545r, InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        this.f2520c = c0545r;
    }

    @Override
    public final InterfaceC0074d create(Object obj, InterfaceC0074d interfaceC0074d) {
        C0543q c0543q = new C0543q(this.f2520c, interfaceC0074d);
        c0543q.f2519b = obj;
        return c0543q;
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        C0543q c0543q = (C0543q) create((InterfaceC3861s) obj, (InterfaceC0074d) obj2);
        C4070l c4070l = C4070l.f13734a;
        c0543q.invokeSuspend(c4070l);
        return c4070l;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        AbstractC3280d.m6570I(obj);
        InterfaceC3861s interfaceC3861s = (InterfaceC3861s) this.f2519b;
        C0545r c0545r = this.f2520c;
        AbstractC0541p abstractC0541p = c0545r.f2525a;
        if (abstractC0541p.mo1509b().compareTo(EnumC0539o.f2508b) >= 0) {
            abstractC0541p.mo1508a(c0545r);
        } else {
            AbstractC3865u.m7686a(interfaceC3861s.mo1512d(), null);
        }
        return C4070l.f13734a;
    }
}

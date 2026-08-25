package p130m2;

import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.InterfaceC0553v;
import p008a9.InterfaceC0074d;
import p030c9.AbstractC1439i;
import p091i9.InterfaceC2728p;
import p150o2.C3246a;
import p156o9.AbstractC3280d;
import p213t9.AbstractC3865u;
import p213t9.InterfaceC3861s;
import p243w8.C4070l;

public final class C3072t extends AbstractC1439i implements InterfaceC2728p {

    public final ViewOnAttachStateChangeListenerC3073u f10528b;

    public C3072t(ViewOnAttachStateChangeListenerC3073u viewOnAttachStateChangeListenerC3073u, InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        this.f10528b = viewOnAttachStateChangeListenerC3073u;
    }

    @Override
    public final InterfaceC0074d create(Object obj, InterfaceC0074d interfaceC0074d) {
        return new C3072t(this.f10528b, interfaceC0074d);
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        C3072t c3072t = (C3072t) create((InterfaceC3861s) obj, (InterfaceC0074d) obj2);
        C4070l c4070l = C4070l.f13734a;
        c3072t.invokeSuspend(c4070l);
        return c4070l;
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        AbstractC3280d.m6570I(obj);
        ViewOnAttachStateChangeListenerC3073u viewOnAttachStateChangeListenerC3073u = this.f10528b;
        C3071s c3071s = viewOnAttachStateChangeListenerC3073u.f10532d;
        if (c3071s != null) {
            AbstractC3865u.m7688c(c3071s.f10527e);
            C3246a c3246a = c3071s.f10525c;
            boolean z7 = c3246a instanceof InterfaceC0553v;
            AbstractC0541p abstractC0541p = c3071s.f10526d;
            if (z7) {
                abstractC0541p.mo1510c(c3246a);
            }
            abstractC0541p.mo1510c(c3071s);
        }
        viewOnAttachStateChangeListenerC3073u.f10532d = null;
        return C4070l.f13734a;
    }
}

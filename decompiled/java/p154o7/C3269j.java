package p154o7;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import p125l7.AbstractC3011r;
import p125l7.C3007n;
import p144n7.InterfaceC3215m;
import p212t7.C3812a;
import p212t7.C3813b;

public final class C3269j extends AbstractC3011r {

    public final InterfaceC3215m f10921a;

    public final LinkedHashMap f10922b;

    public C3269j(InterfaceC3215m interfaceC3215m, LinkedHashMap linkedHashMap) {
        this.f10921a = interfaceC3215m;
        this.f10922b = linkedHashMap;
    }

    @Override
    public final Object mo6077a(C3812a c3812a) throws IOException {
        if (c3812a.m7612u() == 9) {
            c3812a.m7608q();
            return null;
        }
        Object objMo135n = this.f10921a.mo135n();
        try {
            c3812a.m7593b();
            while (c3812a.m7599h()) {
                C3268i c3268i = (C3268i) this.f10922b.get(c3812a.m7606o());
                if (c3268i == null || !c3268i.f10914c) {
                    c3812a.m7617z();
                } else {
                    Object objMo6077a = c3268i.f10917f.mo6077a(c3812a);
                    if (objMo6077a != null || !c3268i.f10920i) {
                        c3268i.f10915d.set(objMo135n, objMo6077a);
                    }
                }
            }
            c3812a.m7597f();
            return objMo135n;
        } catch (IllegalAccessException e5) {
            throw new AssertionError(e5);
        } catch (IllegalStateException e10) {
            throw new C3007n(e10);
        }
    }

    @Override
    public final void mo6078b(C3813b c3813b, Object obj) throws IOException {
        if (obj == null) {
            c3813b.m7626i();
            return;
        }
        c3813b.m7620c();
        try {
            for (C3268i c3268i : this.f10922b.values()) {
                boolean z7 = c3268i.f10913b;
                Field field = c3268i.f10915d;
                if (z7 && field.get(obj) != obj) {
                    c3813b.m7624g(c3268i.f10912a);
                    Object obj2 = field.get(obj);
                    boolean z10 = c3268i.f10916e;
                    AbstractC3011r c3271l = c3268i.f10917f;
                    if (!z10) {
                        c3271l = new C3271l(c3268i.f10918g, c3271l, c3268i.f10919h.f12481b);
                    }
                    c3271l.mo6078b(c3813b, obj2);
                }
            }
            c3813b.m7623f();
        } catch (IllegalAccessException e5) {
            throw new AssertionError(e5);
        }
    }
}

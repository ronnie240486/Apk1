package p154o7;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import p055ea.AbstractC2460q;
import p125l7.AbstractC3011r;
import p125l7.C3004k;
import p125l7.C3007n;
import p144n7.InterfaceC3215m;
import p171q.C3388b;
import p212t7.C3812a;
import p212t7.C3813b;

public final class C3264e extends AbstractC3011r {

    public final C3271l f10902a;

    public final C3271l f10903b;

    public final InterfaceC3215m f10904c;

    public final C3262c f10905d;

    public C3264e(C3262c c3262c, C3004k c3004k, Type type, AbstractC3011r abstractC3011r, Type type2, AbstractC3011r abstractC3011r2, InterfaceC3215m interfaceC3215m) {
        this.f10905d = c3262c;
        this.f10902a = new C3271l(c3004k, abstractC3011r, type);
        this.f10903b = new C3271l(c3004k, abstractC3011r2, type2);
        this.f10904c = interfaceC3215m;
    }

    @Override
    public final Object mo6077a(C3812a c3812a) throws IOException {
        int iM7612u = c3812a.m7612u();
        if (iM7612u == 9) {
            c3812a.m7608q();
            return null;
        }
        Map map = (Map) this.f10904c.mo135n();
        C3271l c3271l = this.f10903b;
        C3271l c3271l2 = this.f10902a;
        AbstractC3011r abstractC3011r = c3271l.f10929b;
        AbstractC3011r abstractC3011r2 = c3271l2.f10929b;
        if (iM7612u == 1) {
            c3812a.m7592a();
            while (c3812a.m7599h()) {
                c3812a.m7592a();
                Object objMo6077a = abstractC3011r2.mo6077a(c3812a);
                if (map.put(objMo6077a, abstractC3011r.mo6077a(c3812a)) != null) {
                    throw new C3007n(AbstractC2460q.m5493g(objMo6077a, "duplicate key: "));
                }
                c3812a.m7596e();
            }
            c3812a.m7596e();
        } else {
            c3812a.m7593b();
            while (c3812a.m7599h()) {
                C3388b.f11424b.getClass();
                int iM7595d = c3812a.f12879h;
                if (iM7595d == 0) {
                    iM7595d = c3812a.m7595d();
                }
                if (iM7595d == 13) {
                    c3812a.f12879h = 9;
                } else if (iM7595d == 12) {
                    c3812a.f12879h = 8;
                } else {
                    if (iM7595d != 14) {
                        throw new IllegalStateException("Expected a name but was " + AbstractC2460q.m5503q(c3812a.m7612u()) + c3812a.m7601j());
                    }
                    c3812a.f12879h = 10;
                }
                Object objMo6077a2 = abstractC3011r2.mo6077a(c3812a);
                if (map.put(objMo6077a2, abstractC3011r.mo6077a(c3812a)) != null) {
                    throw new C3007n(AbstractC2460q.m5493g(objMo6077a2, "duplicate key: "));
                }
            }
            c3812a.m7597f();
        }
        return map;
    }

    @Override
    public final void mo6078b(C3813b c3813b, Object obj) throws IOException {
        Map map = (Map) obj;
        if (map == null) {
            c3813b.m7626i();
            return;
        }
        this.f10905d.getClass();
        C3271l c3271l = this.f10903b;
        c3813b.m7620c();
        for (Map.Entry entry : map.entrySet()) {
            c3813b.m7624g(String.valueOf(entry.getKey()));
            c3271l.mo6078b(c3813b, entry.getValue());
        }
        c3813b.m7623f();
    }
}

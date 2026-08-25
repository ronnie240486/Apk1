package p154o7;

import java.io.IOException;
import java.util.ArrayList;
import p125l7.AbstractC3011r;
import p125l7.C3004k;
import p144n7.C3214l;
import p202s7.C3723a;
import p212t7.C3812a;
import p212t7.C3813b;
import p215u.AbstractC3885h;

public final class C3267h extends AbstractC3011r {

    public static final C3260a f10910b = new C3260a(2);

    public final C3004k f10911a;

    public C3267h(C3004k c3004k) {
        this.f10911a = c3004k;
    }

    @Override
    public final Object mo6077a(C3812a c3812a) throws IOException {
        int iM7785a = AbstractC3885h.m7785a(c3812a.m7612u());
        if (iM7785a == 0) {
            ArrayList arrayList = new ArrayList();
            c3812a.m7592a();
            while (c3812a.m7599h()) {
                arrayList.add(mo6077a(c3812a));
            }
            c3812a.m7596e();
            return arrayList;
        }
        if (iM7785a == 2) {
            C3214l c3214l = new C3214l();
            c3812a.m7593b();
            while (c3812a.m7599h()) {
                c3214l.put(c3812a.m7606o(), mo6077a(c3812a));
            }
            c3812a.m7597f();
            return c3214l;
        }
        if (iM7785a == 5) {
            return c3812a.m7610s();
        }
        if (iM7785a == 6) {
            return Double.valueOf(c3812a.m7603l());
        }
        if (iM7785a == 7) {
            return Boolean.valueOf(c3812a.m7602k());
        }
        if (iM7785a != 8) {
            throw new IllegalStateException();
        }
        c3812a.m7608q();
        return null;
    }

    @Override
    public final void mo6078b(C3813b c3813b, Object obj) throws IOException {
        if (obj == null) {
            c3813b.m7626i();
            return;
        }
        Class<?> cls = obj.getClass();
        C3004k c3004k = this.f10911a;
        c3004k.getClass();
        AbstractC3011r abstractC3011rM6081c = c3004k.m6081c(new C3723a(cls));
        if (!(abstractC3011rM6081c instanceof C3267h)) {
            abstractC3011rM6081c.mo6078b(c3813b, obj);
        } else {
            c3813b.m7620c();
            c3813b.m7623f();
        }
    }
}

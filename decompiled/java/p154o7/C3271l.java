package p154o7;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import p125l7.AbstractC3011r;
import p125l7.C3004k;
import p202s7.C3723a;
import p212t7.C3812a;
import p212t7.C3813b;

public final class C3271l extends AbstractC3011r {

    public final C3004k f10928a;

    public final AbstractC3011r f10929b;

    public final Type f10930c;

    public C3271l(C3004k c3004k, AbstractC3011r abstractC3011r, Type type) {
        this.f10928a = c3004k;
        this.f10929b = abstractC3011r;
        this.f10930c = type;
    }

    @Override
    public final Object mo6077a(C3812a c3812a) {
        return this.f10929b.mo6077a(c3812a);
    }

    @Override
    public final void mo6078b(C3813b c3813b, Object obj) {
        Type type = this.f10930c;
        Type type2 = (obj == null || !(type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) ? type : obj.getClass();
        AbstractC3011r abstractC3011r = this.f10929b;
        if (type2 != type) {
            AbstractC3011r abstractC3011rM6081c = this.f10928a.m6081c(new C3723a(type2));
            if (!(abstractC3011rM6081c instanceof C3269j) || (abstractC3011r instanceof C3269j)) {
                abstractC3011r = abstractC3011rM6081c;
            }
        }
        abstractC3011r.mo6078b(c3813b, obj);
    }
}

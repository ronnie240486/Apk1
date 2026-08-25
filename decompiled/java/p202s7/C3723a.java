package p202s7;

import java.lang.reflect.Type;
import p144n7.AbstractC3206d;

public final class C3723a {

    public final Class f12480a;

    public final Type f12481b;

    public final int f12482c;

    public C3723a(Type type) {
        type.getClass();
        Type typeM6486b = AbstractC3206d.m6486b(type);
        this.f12481b = typeM6486b;
        this.f12480a = AbstractC3206d.m6492h(typeM6486b);
        this.f12482c = typeM6486b.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C3723a) {
            if (AbstractC3206d.m6490f(this.f12481b, ((C3723a) obj).f12481b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f12482c;
    }

    public final String toString() {
        return AbstractC3206d.m6494k(this.f12481b);
    }
}

package p243w8;

import java.io.Serializable;
import p103j9.AbstractC2796i;

public final class C4064f implements Serializable {

    public final Object f13727a;

    public final Object f13728b;

    public C4064f(Object obj, Object obj2) {
        this.f13727a = obj;
        this.f13728b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4064f)) {
            return false;
        }
        C4064f c4064f = (C4064f) obj;
        return AbstractC2796i.m5780a(this.f13727a, c4064f.f13727a) && AbstractC2796i.m5780a(this.f13728b, c4064f.f13728b);
    }

    public final int hashCode() {
        Object obj = this.f13727a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f13728b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f13727a + ", " + this.f13728b + ')';
    }
}

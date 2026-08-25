package p130m2;

import java.util.Map;
import p103j9.AbstractC2796i;
import p253x8.C4156s;

public final class C3070r {

    public static final C3070r f10521b = new C3070r(C4156s.f14075a);

    public final Map f10522a;

    public C3070r(Map map) {
        this.f10522a = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3070r) {
            if (AbstractC2796i.m5780a(this.f10522a, ((C3070r) obj).f10522a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f10522a.hashCode();
    }

    public final String toString() {
        return "Tags(tags=" + this.f10522a + ')';
    }
}

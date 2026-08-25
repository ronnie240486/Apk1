package p243w8;

import java.io.Serializable;
import p103j9.AbstractC2796i;

public final class C4065g implements Serializable {

    public final Throwable f13729a;

    public C4065g(Throwable th) {
        AbstractC2796i.m5785f(th, "exception");
        this.f13729a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C4065g) {
            if (AbstractC2796i.m5780a(this.f13729a, ((C4065g) obj).f13729a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13729a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f13729a + ')';
    }
}

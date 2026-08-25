package p020b7;

import java.io.Serializable;

public final class C1360t implements InterfaceC1354n, Serializable {

    public final Object f4175a;

    public C1360t(InterfaceC1354n interfaceC1354n) {
        this.f4175a = interfaceC1354n;
    }

    @Override
    public final boolean apply(Object obj) {
        return !this.f4175a.apply(obj);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof C1360t) {
            return this.f4175a.equals(((C1360t) obj).f4175a);
        }
        return false;
    }

    public final int hashCode() {
        return ~this.f4175a.hashCode();
    }

    public final String toString() {
        return "Predicates.not(" + this.f4175a + ")";
    }
}

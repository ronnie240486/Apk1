package p020b7;

import java.io.Serializable;

public final class C1358r implements InterfaceC1354n, Serializable {

    public final Class f4173a;

    public C1358r(Class cls) {
        this.f4173a = cls;
    }

    @Override
    public final boolean apply(Object obj) {
        return this.f4173a.isInstance(obj);
    }

    @Override
    public final boolean equals(Object obj) {
        return (obj instanceof C1358r) && this.f4173a == ((C1358r) obj).f4173a;
    }

    public final int hashCode() {
        return this.f4173a.hashCode();
    }

    public final String toString() {
        return "Predicates.instanceOf(" + this.f4173a.getName() + ")";
    }
}

package p020b7;

import java.io.Serializable;
import java.util.Collection;

public final class C1357q implements InterfaceC1354n, Serializable {

    public final Collection f4172a;

    public C1357q(Collection collection) {
        collection.getClass();
        this.f4172a = collection;
    }

    @Override
    public final boolean apply(Object obj) {
        try {
            return this.f4172a.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof C1357q) {
            return this.f4172a.equals(((C1357q) obj).f4172a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4172a.hashCode();
    }

    public final String toString() {
        return "Predicates.in(" + this.f4172a + ")";
    }
}

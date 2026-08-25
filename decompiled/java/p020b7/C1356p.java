package p020b7;

import java.io.Serializable;
import p041d7.EnumC2221i4;

public final class C1356p implements InterfaceC1354n, Serializable {

    public final Object f4170a;

    public final EnumC2221i4 f4171b;

    public C1356p(InterfaceC1354n interfaceC1354n, EnumC2221i4 enumC2221i4) {
        interfaceC1354n.getClass();
        this.f4170a = interfaceC1354n;
        this.f4171b = enumC2221i4;
    }

    @Override
    public final boolean apply(Object obj) {
        return this.f4170a.apply(this.f4171b.apply(obj));
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof C1356p)) {
            return false;
        }
        C1356p c1356p = (C1356p) obj;
        return this.f4171b.equals(c1356p.f4171b) && this.f4170a.equals(c1356p.f4170a);
    }

    public final int hashCode() {
        return this.f4171b.hashCode() ^ this.f4170a.hashCode();
    }

    public final String toString() {
        return this.f4170a + "(" + this.f4171b + ")";
    }
}

package p020b7;

import java.io.Serializable;
import java.util.List;

public final class C1355o implements InterfaceC1354n, Serializable {

    public final List f4169a;

    public C1355o(List list) {
        this.f4169a = list;
    }

    @Override
    public final boolean apply(Object obj) {
        int i6 = 0;
        while (true) {
            List list = this.f4169a;
            if (i6 >= list.size()) {
                return true;
            }
            if (!((InterfaceC1354n) list.get(i6)).apply(obj)) {
                return false;
            }
            i6++;
        }
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof C1355o) {
            return this.f4169a.equals(((C1355o) obj).f4169a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4169a.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Predicates.and(");
        boolean z7 = true;
        for (Object obj : this.f4169a) {
            if (!z7) {
                sb.append(',');
            }
            sb.append(obj);
            z7 = false;
        }
        sb.append(')');
        return sb.toString();
    }
}

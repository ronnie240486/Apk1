package p270z3;

import java.util.ArrayList;

public final class C4315i extends AbstractC4321o {

    public final ArrayList f14659a;

    public C4315i(ArrayList arrayList) {
        this.f14659a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4321o)) {
            return false;
        }
        return this.f14659a.equals(((C4315i) ((AbstractC4321o) obj)).f14659a);
    }

    public final int hashCode() {
        return this.f14659a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f14659a + "}";
    }
}

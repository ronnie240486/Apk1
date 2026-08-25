package p128m0;

import java.util.Objects;

public final class C3026b {

    public final Object f10354a;

    public final Object f10355b;

    public C3026b(Object obj, Object obj2) {
        this.f10354a = obj;
        this.f10355b = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C3026b)) {
            return false;
        }
        C3026b c3026b = (C3026b) obj;
        return Objects.equals(c3026b.f10354a, this.f10354a) && Objects.equals(c3026b.f10355b, this.f10355b);
    }

    public final int hashCode() {
        Object obj = this.f10354a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f10355b;
        return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "Pair{" + this.f10354a + " " + this.f10355b + "}";
    }
}

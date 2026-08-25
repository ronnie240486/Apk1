package p140n2;

import p187r4.AbstractC3612b;

public final class C3176a extends AbstractC3612b {

    public final int f10667c;

    public C3176a(int i6) {
        this.f10667c = i6;
        if (i6 <= 0) {
            throw new IllegalArgumentException("px must be > 0.");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3176a) {
            if (this.f10667c == ((C3176a) obj).f10667c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f10667c;
    }

    public final String toString() {
        return String.valueOf(this.f10667c);
    }
}

package p156o9;

public final class C3284h extends C3282f {

    public static final C3284h f10996d = new C3284h(1, 0, 1);

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof C3284h) {
            if (!isEmpty() || !((C3284h) obj).isEmpty()) {
                C3284h c3284h = (C3284h) obj;
                if (this.f10989a == c3284h.f10989a) {
                    if (this.f10990b == c3284h.f10990b) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f10989a * 31) + this.f10990b;
    }

    @Override
    public final boolean isEmpty() {
        return this.f10989a > this.f10990b;
    }

    @Override
    public final String toString() {
        return this.f10989a + ".." + this.f10990b;
    }
}

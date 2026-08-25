package p219u4;

import java.util.Arrays;

public final class C3894b {

    public int f13088a;

    public int f13089b;

    public int f13090c;

    public int f13091d;

    public int f13092e;

    public boolean f13093f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3894b)) {
            return false;
        }
        C3894b c3894b = (C3894b) obj;
        return this.f13088a == c3894b.f13088a && this.f13089b == c3894b.f13089b && this.f13090c == c3894b.f13090c && this.f13091d == c3894b.f13091d && this.f13092e == c3894b.f13092e && this.f13093f == c3894b.f13093f;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f13088a), Integer.valueOf(this.f13089b), Integer.valueOf(this.f13090c), Integer.valueOf(this.f13091d), Integer.valueOf(this.f13092e), Boolean.valueOf(this.f13093f)});
    }
}

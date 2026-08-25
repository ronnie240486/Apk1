package p077h4;

import java.util.Set;

public final class C2653c {

    public final long f9256a;

    public final long f9257b;

    public final Set f9258c;

    public C2653c(long j10, long j11, Set set) {
        this.f9256a = j10;
        this.f9257b = j11;
        this.f9258c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2653c)) {
            return false;
        }
        C2653c c2653c = (C2653c) obj;
        return this.f9256a == c2653c.f9256a && this.f9257b == c2653c.f9257b && this.f9258c.equals(c2653c.f9258c);
    }

    public final int hashCode() {
        long j10 = this.f9256a;
        int i6 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f9257b;
        return this.f9258c.hashCode() ^ ((i6 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f9256a + ", maxAllowedDelay=" + this.f9257b + ", flags=" + this.f9258c + "}";
    }
}

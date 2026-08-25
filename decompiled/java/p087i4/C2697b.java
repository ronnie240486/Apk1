package p087i4;

import p005a4.C0050i;
import p005a4.C0051j;

public final class C2697b {

    public final long f9381a;

    public final C0051j f9382b;

    public final C0050i f9383c;

    public C2697b(long j10, C0051j c0051j, C0050i c0050i) {
        this.f9381a = j10;
        this.f9382b = c0051j;
        this.f9383c = c0050i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2697b)) {
            return false;
        }
        C2697b c2697b = (C2697b) obj;
        return this.f9381a == c2697b.f9381a && this.f9382b.equals(c2697b.f9382b) && this.f9383c.equals(c2697b.f9383c);
    }

    public final int hashCode() {
        long j10 = this.f9381a;
        return this.f9383c.hashCode() ^ ((((((int) ((j10 >>> 32) ^ j10)) ^ 1000003) * 1000003) ^ this.f9382b.hashCode()) * 1000003);
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f9381a + ", transportContext=" + this.f9382b + ", event=" + this.f9383c + "}";
    }
}

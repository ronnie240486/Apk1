package p087i4;

public final class C2696a {

    public static final C2696a f9375f = new C2696a(10485760, 200, 10000, 604800000, 81920);

    public final long f9376a;

    public final int f9377b;

    public final int f9378c;

    public final long f9379d;

    public final int f9380e;

    public C2696a(long j10, int i6, int i10, long j11, int i11) {
        this.f9376a = j10;
        this.f9377b = i6;
        this.f9378c = i10;
        this.f9379d = j11;
        this.f9380e = i11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2696a)) {
            return false;
        }
        C2696a c2696a = (C2696a) obj;
        return this.f9376a == c2696a.f9376a && this.f9377b == c2696a.f9377b && this.f9378c == c2696a.f9378c && this.f9379d == c2696a.f9379d && this.f9380e == c2696a.f9380e;
    }

    public final int hashCode() {
        long j10 = this.f9376a;
        int i6 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f9377b) * 1000003) ^ this.f9378c) * 1000003;
        long j11 = this.f9379d;
        return this.f9380e ^ ((i6 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public final String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f9376a + ", loadBatchSize=" + this.f9377b + ", criticalSectionEnterTimeoutMs=" + this.f9378c + ", eventCleanUpAge=" + this.f9379d + ", maxBlobByteSizePerRow=" + this.f9380e + "}";
    }
}

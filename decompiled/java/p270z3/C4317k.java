package p270z3;

import java.util.Arrays;

public final class C4317k extends AbstractC4324r {

    public final long f14661a;

    public final Integer f14662b;

    public final long f14663c;

    public final byte[] f14664d;

    public final String f14665e;

    public final long f14666f;

    public final C4320n f14667g;

    public C4317k(long j10, Integer num, long j11, byte[] bArr, String str, long j12, C4320n c4320n) {
        this.f14661a = j10;
        this.f14662b = num;
        this.f14663c = j11;
        this.f14664d = bArr;
        this.f14665e = str;
        this.f14666f = j12;
        this.f14667g = c4320n;
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4324r)) {
            return false;
        }
        AbstractC4324r abstractC4324r = (AbstractC4324r) obj;
        C4317k c4317k = (C4317k) abstractC4324r;
        if (this.f14661a == c4317k.f14661a && ((num = this.f14662b) != null ? num.equals(c4317k.f14662b) : c4317k.f14662b == null)) {
            if (this.f14663c == c4317k.f14663c) {
                if (Arrays.equals(this.f14664d, abstractC4324r instanceof C4317k ? ((C4317k) abstractC4324r).f14664d : c4317k.f14664d)) {
                    String str = c4317k.f14665e;
                    String str2 = this.f14665e;
                    if (str2 != null ? str2.equals(str) : str == null) {
                        if (this.f14666f == c4317k.f14666f) {
                            C4320n c4320n = c4317k.f14667g;
                            C4320n c4320n2 = this.f14667g;
                            if (c4320n2 == null) {
                                if (c4320n == null) {
                                    return true;
                                }
                            } else if (c4320n2.equals(c4320n)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f14661a;
        int i6 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f14662b;
        int iHashCode = (i6 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        long j11 = this.f14663c;
        int iHashCode2 = (((iHashCode ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f14664d)) * 1000003;
        String str = this.f14665e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j12 = this.f14666f;
        int i10 = (iHashCode3 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        C4320n c4320n = this.f14667g;
        return i10 ^ (c4320n != null ? c4320n.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f14661a + ", eventCode=" + this.f14662b + ", eventUptimeMs=" + this.f14663c + ", sourceExtension=" + Arrays.toString(this.f14664d) + ", sourceExtensionJsonProto3=" + this.f14665e + ", timezoneOffsetSeconds=" + this.f14666f + ", networkConnectionInfo=" + this.f14667g + "}";
    }
}

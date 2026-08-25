package p270z3;

import java.util.ArrayList;

public final class C4318l extends AbstractC4325s {

    public final long f14668a;

    public final long f14669b;

    public final C4316j f14670c;

    public final Integer f14671d;

    public final String f14672e;

    public final ArrayList f14673f;

    public C4318l(long j10, long j11, C4316j c4316j, Integer num, String str, ArrayList arrayList) {
        EnumC4329w enumC4329w = EnumC4329w.f14683a;
        this.f14668a = j10;
        this.f14669b = j11;
        this.f14670c = c4316j;
        this.f14671d = num;
        this.f14672e = str;
        this.f14673f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4325s)) {
            return false;
        }
        C4318l c4318l = (C4318l) ((AbstractC4325s) obj);
        if (this.f14668a == c4318l.f14668a) {
            if (this.f14669b == c4318l.f14669b) {
                if (this.f14670c.equals(c4318l.f14670c)) {
                    Integer num = c4318l.f14671d;
                    Integer num2 = this.f14671d;
                    if (num2 != null ? num2.equals(num) : num == null) {
                        String str = c4318l.f14672e;
                        String str2 = this.f14672e;
                        if (str2 != null ? str2.equals(str) : str == null) {
                            if (this.f14673f.equals(c4318l.f14673f)) {
                                Object obj2 = EnumC4329w.f14683a;
                                if (obj2.equals(obj2)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f14668a;
        long j11 = this.f14669b;
        int iHashCode = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f14670c.hashCode()) * 1000003;
        Integer num = this.f14671d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f14672e;
        return EnumC4329w.f14683a.hashCode() ^ ((((iHashCode2 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.f14673f.hashCode()) * 1000003);
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f14668a + ", requestUptimeMs=" + this.f14669b + ", clientInfo=" + this.f14670c + ", logSource=" + this.f14671d + ", logSourceName=" + this.f14672e + ", logEvents=" + this.f14673f + ", qosTier=" + EnumC4329w.f14683a + "}";
    }
}

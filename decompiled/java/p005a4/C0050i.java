package p005a4;

import java.util.HashMap;

public final class C0050i {

    public final String f145a;

    public final Integer f146b;

    public final C0055n f147c;

    public final long f148d;

    public final long f149e;

    public final HashMap f150f;

    public C0050i(String str, Integer num, C0055n c0055n, long j10, long j11, HashMap map) {
        this.f145a = str;
        this.f146b = num;
        this.f147c = c0055n;
        this.f148d = j10;
        this.f149e = j11;
        this.f150f = map;
    }

    public final String m200a(String str) {
        String str2 = (String) this.f150f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int m201b(String str) {
        String str2 = (String) this.f150f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final C0049h m202c() {
        C0049h c0049h = new C0049h();
        String str = this.f145a;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        c0049h.f139a = str;
        c0049h.f140b = this.f146b;
        C0055n c0055n = this.f147c;
        if (c0055n == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        c0049h.f141c = c0055n;
        c0049h.f142d = Long.valueOf(this.f148d);
        c0049h.f143e = Long.valueOf(this.f149e);
        c0049h.f144f = new HashMap(this.f150f);
        return c0049h;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0050i)) {
            return false;
        }
        C0050i c0050i = (C0050i) obj;
        if (this.f145a.equals(c0050i.f145a)) {
            Integer num = c0050i.f146b;
            Integer num2 = this.f146b;
            if (num2 != null ? num2.equals(num) : num == null) {
                if (this.f147c.equals(c0050i.f147c) && this.f148d == c0050i.f148d && this.f149e == c0050i.f149e && this.f150f.equals(c0050i.f150f)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f145a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f146b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f147c.hashCode()) * 1000003;
        long j10 = this.f148d;
        int i6 = (iHashCode2 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f149e;
        return ((i6 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f150f.hashCode();
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f145a + ", code=" + this.f146b + ", encodedPayload=" + this.f147c + ", eventMillis=" + this.f148d + ", uptimeMillis=" + this.f149e + ", autoMetadata=" + this.f150f + "}";
    }
}

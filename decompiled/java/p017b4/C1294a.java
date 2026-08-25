package p017b4;

import p000a.AbstractC0004e;
import p215u.AbstractC3885h;

public final class C1294a {

    public final int f4066a;

    public final long f4067b;

    public C1294a(int i6, long j10) {
        if (i6 == 0) {
            throw new NullPointerException("Null status");
        }
        this.f4066a = i6;
        this.f4067b = j10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1294a)) {
            return false;
        }
        C1294a c1294a = (C1294a) obj;
        int i6 = c1294a.f4066a;
        int i10 = this.f4066a;
        if (i10 != 0) {
            return (i10 == i6) && this.f4067b == c1294a.f4067b;
        }
        throw null;
    }

    public final int hashCode() {
        int iM7785a = (AbstractC3885h.m7785a(this.f4066a) ^ 1000003) * 1000003;
        long j10 = this.f4067b;
        return iM7785a ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i6 = this.f4066a;
        if (i6 == 1) {
            str = "OK";
        } else if (i6 == 2) {
            str = "TRANSIENT_ERROR";
        } else if (i6 != 3) {
            str = i6 != 4 ? "null" : "INVALID_PAYLOAD";
        } else {
            str = "FATAL_ERROR";
        }
        sb.append(str);
        sb.append(", nextRequestWaitMillis=");
        return AbstractC0004e.m25s(sb, this.f4067b, "}");
    }
}

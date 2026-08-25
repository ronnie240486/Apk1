package p005a4;

import java.util.Arrays;
import p248x3.C4106b;

public final class C0055n {

    public final C4106b f161a;

    public final byte[] f162b;

    public C0055n(C4106b c4106b, byte[] bArr) {
        if (c4106b == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f161a = c4106b;
        this.f162b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0055n)) {
            return false;
        }
        C0055n c0055n = (C0055n) obj;
        if (this.f161a.equals(c0055n.f161a)) {
            return Arrays.equals(this.f162b, c0055n.f162b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f161a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f162b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f161a + ", bytes=[...]}";
    }
}

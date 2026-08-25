package p005a4;

import android.util.Base64;
import java.util.Arrays;
import p002a1.C0026b;
import p248x3.EnumC4107c;

public final class C0051j {

    public final String f151a;

    public final byte[] f152b;

    public final EnumC4107c f153c;

    public C0051j(String str, byte[] bArr, EnumC4107c enumC4107c) {
        this.f151a = str;
        this.f152b = bArr;
        this.f153c = enumC4107c;
    }

    public static C0026b m203a() {
        C0026b c0026b = new C0026b(1, false);
        c0026b.f56d = EnumC4107c.f13925a;
        return c0026b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0051j)) {
            return false;
        }
        C0051j c0051j = (C0051j) obj;
        return this.f151a.equals(c0051j.f151a) && Arrays.equals(this.f152b, c0051j.f152b) && this.f153c.equals(c0051j.f153c);
    }

    public final int hashCode() {
        return ((((this.f151a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f152b)) * 1000003) ^ this.f153c.hashCode();
    }

    public final String toString() {
        byte[] bArr = this.f152b;
        return "TransportContext(" + this.f151a + ", " + this.f153c + ", " + (bArr == null ? "" : Base64.encodeToString(bArr, 2)) + ")";
    }
}

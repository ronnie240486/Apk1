package p259y2;

import android.graphics.Bitmap;
import p186r3.AbstractC3610n;

public final class C4247j implements InterfaceC4245h {

    public final C4242e f14423a;

    public int f14424b;

    public Bitmap.Config f14425c;

    public C4247j(C4242e c4242e) {
        this.f14423a = c4242e;
    }

    @Override
    public final void mo8282a() {
        this.f14423a.m5119c(this);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C4247j)) {
            return false;
        }
        C4247j c4247j = (C4247j) obj;
        return this.f14424b == c4247j.f14424b && AbstractC3610n.m7234b(this.f14425c, c4247j.f14425c);
    }

    public final int hashCode() {
        int i6 = this.f14424b * 31;
        Bitmap.Config config = this.f14425c;
        return i6 + (config != null ? config.hashCode() : 0);
    }

    public final String toString() {
        return C4248k.m8296c(this.f14424b, this.f14425c);
    }
}

package p067g2;

import android.graphics.drawable.Drawable;
import p036d2.EnumC2137f;
import p103j9.AbstractC2796i;

public final class C2597d extends AbstractC2598e {

    public final Drawable f9052a;

    public final boolean f9053b;

    public final EnumC2137f f9054c;

    public C2597d(Drawable drawable, boolean z7, EnumC2137f enumC2137f) {
        this.f9052a = drawable;
        this.f9053b = z7;
        this.f9054c = enumC2137f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2597d) {
            C2597d c2597d = (C2597d) obj;
            if (AbstractC2796i.m5780a(this.f9052a, c2597d.f9052a) && this.f9053b == c2597d.f9053b && this.f9054c == c2597d.f9054c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9054c.hashCode() + (((this.f9052a.hashCode() * 31) + (this.f9053b ? 1231 : 1237)) * 31);
    }
}

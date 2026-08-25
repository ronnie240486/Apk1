package p067g2;

import p036d2.AbstractC2145n;
import p036d2.EnumC2137f;
import p103j9.AbstractC2796i;

public final class C2606m extends AbstractC2598e {

    public final AbstractC2145n f9075a;

    public final String f9076b;

    public final EnumC2137f f9077c;

    public C2606m(AbstractC2145n abstractC2145n, String str, EnumC2137f enumC2137f) {
        this.f9075a = abstractC2145n;
        this.f9076b = str;
        this.f9077c = enumC2137f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2606m) {
            C2606m c2606m = (C2606m) obj;
            if (AbstractC2796i.m5780a(this.f9075a, c2606m.f9075a) && AbstractC2796i.m5780a(this.f9076b, c2606m.f9076b) && this.f9077c == c2606m.f9077c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f9075a.hashCode() * 31;
        String str = this.f9076b;
        return this.f9077c.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31);
    }
}

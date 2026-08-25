package p130m2;

import p103j9.AbstractC2796i;
import p140n2.EnumC3182g;
import p174q2.InterfaceC3465d;

public final class C3056d {

    public final EnumC3182g f10434a;

    public final InterfaceC3465d f10435b;

    public final EnumC3054b f10436c;

    public final EnumC3054b f10437d;

    public C3056d(EnumC3182g enumC3182g, InterfaceC3465d interfaceC3465d, EnumC3054b enumC3054b, EnumC3054b enumC3054b2) {
        this.f10434a = enumC3182g;
        this.f10435b = interfaceC3465d;
        this.f10436c = enumC3054b;
        this.f10437d = enumC3054b2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3056d) {
            C3056d c3056d = (C3056d) obj;
            c3056d.getClass();
            if (AbstractC2796i.m5780a(null, null) && AbstractC2796i.m5780a(null, null) && this.f10434a == c3056d.f10434a && AbstractC2796i.m5780a(null, null) && AbstractC2796i.m5780a(null, null) && AbstractC2796i.m5780a(null, null) && AbstractC2796i.m5780a(null, null) && AbstractC2796i.m5780a(this.f10435b, c3056d.f10435b) && AbstractC2796i.m5780a(null, null) && AbstractC2796i.m5780a(null, null) && this.f10436c == c3056d.f10436c && this.f10437d == c3056d.f10437d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        EnumC3182g enumC3182g = this.f10434a;
        int iHashCode = (enumC3182g != null ? enumC3182g.hashCode() : 0) * 28629151;
        InterfaceC3465d interfaceC3465d = this.f10435b;
        int iHashCode2 = (iHashCode + (interfaceC3465d != null ? interfaceC3465d.hashCode() : 0)) * 28629151;
        EnumC3054b enumC3054b = this.f10436c;
        int iHashCode3 = (iHashCode2 + (enumC3054b != null ? enumC3054b.hashCode() : 0)) * 31;
        EnumC3054b enumC3054b2 = this.f10437d;
        return (iHashCode3 + (enumC3054b2 != null ? enumC3054b2.hashCode() : 0)) * 31;
    }
}

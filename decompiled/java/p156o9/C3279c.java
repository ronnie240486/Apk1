package p156o9;

import p103j9.AbstractC2796i;

public final class C3279c extends AbstractC3277a {

    public static final int f10974c = 0;

    static {
        new C3279c();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C3279c) {
            char c5 = this.f10968a;
            if (AbstractC2796i.m5787h(1, c5) > 0 && AbstractC2796i.m5787h(1, ((C3279c) obj).f10968a) > 0) {
                return true;
            }
            C3279c c3279c = (C3279c) obj;
            c3279c.getClass();
            if (c5 == c3279c.f10968a) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        char c5 = this.f10968a;
        if (AbstractC2796i.m5787h(1, c5) > 0) {
            return -1;
        }
        return 31 + c5;
    }

    public final String toString() {
        return "\u0001.." + this.f10968a;
    }
}

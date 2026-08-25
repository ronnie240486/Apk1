package p213t9;

import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;

public final class C3847l {

    public final Object f12935a;

    public final InterfaceC2724l f12936b;

    public C3847l(Object obj, InterfaceC2724l interfaceC2724l) {
        this.f12935a = obj;
        this.f12936b = interfaceC2724l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3847l)) {
            return false;
        }
        C3847l c3847l = (C3847l) obj;
        return AbstractC2796i.m5780a(this.f12935a, c3847l.f12935a) && AbstractC2796i.m5780a(this.f12936b, c3847l.f12936b);
    }

    public final int hashCode() {
        Object obj = this.f12935a;
        return this.f12936b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public final String toString() {
        return "CompletedWithCancellation(result=" + this.f12935a + ", onCancellation=" + this.f12936b + ')';
    }
}

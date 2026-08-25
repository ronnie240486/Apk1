package p140n2;

import p103j9.AbstractC2796i;
import p187r4.AbstractC3612b;

public final class C3183h {

    public static final C3183h f10677c;

    public final AbstractC3612b f10678a;

    public final AbstractC3612b f10679b;

    static {
        C3177b c3177b = C3177b.f10668c;
        f10677c = new C3183h(c3177b, c3177b);
    }

    public C3183h(AbstractC3612b abstractC3612b, AbstractC3612b abstractC3612b2) {
        this.f10678a = abstractC3612b;
        this.f10679b = abstractC3612b2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3183h)) {
            return false;
        }
        C3183h c3183h = (C3183h) obj;
        return AbstractC2796i.m5780a(this.f10678a, c3183h.f10678a) && AbstractC2796i.m5780a(this.f10679b, c3183h.f10679b);
    }

    public final int hashCode() {
        return this.f10679b.hashCode() + (this.f10678a.hashCode() * 31);
    }

    public final String toString() {
        return "Size(width=" + this.f10678a + ", height=" + this.f10679b + ')';
    }
}

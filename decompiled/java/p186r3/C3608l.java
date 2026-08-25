package p186r3;

public final class C3608l {

    public Class f12108a;

    public Class f12109b;

    public Class f12110c;

    public C3608l(Class cls, Class cls2, Class cls3) {
        this.f12108a = cls;
        this.f12109b = cls2;
        this.f12110c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3608l.class != obj.getClass()) {
            return false;
        }
        C3608l c3608l = (C3608l) obj;
        return this.f12108a.equals(c3608l.f12108a) && this.f12109b.equals(c3608l.f12109b) && AbstractC3610n.m7234b(this.f12110c, c3608l.f12110c);
    }

    public final int hashCode() {
        int iHashCode = (this.f12109b.hashCode() + (this.f12108a.hashCode() * 31)) * 31;
        Class cls = this.f12110c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f12108a + ", second=" + this.f12109b + '}';
    }
}

package p259y2;

public final class C4241d implements InterfaceC4245h {

    public final C4242e f14402a;

    public int f14403b;

    public Class f14404c;

    public C4241d(C4242e c4242e) {
        this.f14402a = c4242e;
    }

    @Override
    public final void mo8282a() {
        this.f14402a.m5119c(this);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C4241d)) {
            return false;
        }
        C4241d c4241d = (C4241d) obj;
        return this.f14403b == c4241d.f14403b && this.f14404c == c4241d.f14404c;
    }

    public final int hashCode() {
        int i6 = this.f14403b * 31;
        Class cls = this.f14404c;
        return i6 + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "Key{size=" + this.f14403b + "array=" + this.f14404c + '}';
    }
}

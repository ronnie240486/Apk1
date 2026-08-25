package p219u4;

public final class C3893a {

    public final int f13085a;

    public final int f13086b;

    public final boolean f13087c;

    public C3893a(int i6, int i10, boolean z7) {
        this.f13085a = i6;
        this.f13086b = i10;
        this.f13087c = z7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C3893a) && this.f13085a == ((C3893a) obj).f13085a;
    }

    public final int hashCode() {
        return Integer.valueOf(this.f13085a).hashCode();
    }
}

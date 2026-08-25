package p113k7;

public final class C2894a implements InterfaceC2897d {

    public final int f9836a;

    public C2894a(int i6) {
        this.f9836a = i6;
    }

    @Override
    public final Class annotationType() {
        return InterfaceC2897d.class;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterfaceC2897d)) {
            return false;
        }
        C2894a c2894a = (C2894a) ((InterfaceC2897d) obj);
        if (this.f9836a == c2894a.f9836a) {
            Object obj2 = EnumC2896c.f9838a;
            c2894a.getClass();
            if (obj2.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return (14552422 ^ this.f9836a) + (EnumC2896c.f9838a.hashCode() ^ 2041407134);
    }

    @Override
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f9836a + "intEncoding=" + EnumC2896c.f9838a + ')';
    }
}

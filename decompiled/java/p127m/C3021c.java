package p127m;

import java.util.Map;

public final class C3021c implements Map.Entry {

    public final Object f10343a;

    public final Object f10344b;

    public C3021c f10345c;

    public C3021c f10346d;

    public C3021c(Object obj, Object obj2) {
        this.f10343a = obj;
        this.f10344b = obj2;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3021c)) {
            return false;
        }
        C3021c c3021c = (C3021c) obj;
        return this.f10343a.equals(c3021c.f10343a) && this.f10344b.equals(c3021c.f10344b);
    }

    @Override
    public final Object getKey() {
        return this.f10343a;
    }

    @Override
    public final Object getValue() {
        return this.f10344b;
    }

    @Override
    public final int hashCode() {
        return this.f10343a.hashCode() ^ this.f10344b.hashCode();
    }

    @Override
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f10343a + "=" + this.f10344b;
    }
}

package p144n7;

import java.util.Map;

public final class C3213k implements Map.Entry {

    public C3213k f10799a;

    public C3213k f10800b;

    public C3213k f10801c;

    public C3213k f10802d;

    public C3213k f10803e;

    public final Object f10804f;

    public Object f10805g;

    public int f10806h;

    public C3213k() {
        this.f10804f = null;
        this.f10803e = this;
        this.f10802d = this;
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f10804f;
        if (obj2 == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!obj2.equals(entry.getKey())) {
            return false;
        }
        Object obj3 = this.f10805g;
        if (obj3 == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!obj3.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override
    public final Object getKey() {
        return this.f10804f;
    }

    @Override
    public final Object getValue() {
        return this.f10805g;
    }

    @Override
    public final int hashCode() {
        Object obj = this.f10804f;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f10805g;
        return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
    }

    @Override
    public final Object setValue(Object obj) {
        Object obj2 = this.f10805g;
        this.f10805g = obj;
        return obj2;
    }

    public final String toString() {
        return this.f10804f + "=" + this.f10805g;
    }

    public C3213k(C3213k c3213k, Object obj, C3213k c3213k2, C3213k c3213k3) {
        this.f10799a = c3213k;
        this.f10804f = obj;
        this.f10806h = 1;
        this.f10802d = c3213k2;
        this.f10803e = c3213k3;
        c3213k3.f10802d = this;
        c3213k2.f10803e = this;
    }
}

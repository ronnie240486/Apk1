package p144n7;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public final class C3212j extends AbstractSet {

    public final int f10797a;

    public final C3214l f10798b;

    public C3212j(C3214l c3214l, int i6) {
        this.f10797a = i6;
        this.f10798b = c3214l;
    }

    @Override
    public final void clear() {
        switch (this.f10797a) {
            case 0:
                this.f10798b.clear();
                break;
            default:
                this.f10798b.clear();
                break;
        }
    }

    @Override
    public final boolean contains(Object obj) {
        C3213k c3213kM6501a;
        Object obj2;
        Object value;
        switch (this.f10797a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                C3214l c3214l = this.f10798b;
                c3214l.getClass();
                Object key = entry.getKey();
                C3213k c3213k = null;
                if (key != null) {
                    try {
                        c3213kM6501a = c3214l.m6501a(key, false);
                    } catch (ClassCastException unused) {
                        c3213kM6501a = null;
                    }
                    break;
                } else {
                    c3213kM6501a = null;
                }
                if (c3213kM6501a != null && ((obj2 = c3213kM6501a.f10805g) == (value = entry.getValue()) || (obj2 != null && obj2.equals(value)))) {
                    c3213k = c3213kM6501a;
                }
                return c3213k != null;
            default:
                return this.f10798b.containsKey(obj);
        }
    }

    @Override
    public final Iterator iterator() {
        switch (this.f10797a) {
            case 0:
                return new C3211i(this.f10798b, 0);
            default:
                return new C3211i(this.f10798b, 1);
        }
    }

    @Override
    public final boolean remove(Object obj) {
        C3213k c3213kM6501a;
        Object obj2;
        Object value;
        switch (this.f10797a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                C3214l c3214l = this.f10798b;
                c3214l.getClass();
                Object key = entry.getKey();
                C3213k c3213k = null;
                if (key != null) {
                    try {
                        c3213kM6501a = c3214l.m6501a(key, false);
                    } catch (ClassCastException unused) {
                        c3213kM6501a = null;
                    }
                    break;
                } else {
                    c3213kM6501a = null;
                }
                if (c3213kM6501a != null && ((obj2 = c3213kM6501a.f10805g) == (value = entry.getValue()) || (obj2 != null && obj2.equals(value)))) {
                    c3213k = c3213kM6501a;
                }
                if (c3213k == null) {
                    return false;
                }
                c3214l.m6503c(c3213k, true);
                return true;
            default:
                C3214l c3214l2 = this.f10798b;
                c3214l2.getClass();
                C3213k c3213kM6501a2 = null;
                if (obj != null) {
                    try {
                        c3213kM6501a2 = c3214l2.m6501a(obj, false);
                        break;
                    } catch (ClassCastException unused2) {
                    }
                }
                if (c3213kM6501a2 != null) {
                    c3214l2.m6503c(c3213kM6501a2, true);
                }
                return c3213kM6501a2 != null;
        }
    }

    @Override
    public final int size() {
        switch (this.f10797a) {
            case 0:
                break;
        }
        return this.f10798b.f10810c;
    }
}

package p127m;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class C3024f implements Iterable {

    public C3021c f10350a;

    public C3021c f10351b;

    public final WeakHashMap f10352c = new WeakHashMap();

    public int f10353d = 0;

    public C3021c mo6095c(Object obj) {
        C3021c c3021c = this.f10350a;
        while (c3021c != null && !c3021c.f10343a.equals(obj)) {
            c3021c = c3021c.f10345c;
        }
        return c3021c;
    }

    public Object mo6096d(Object obj) {
        C3021c c3021cMo6095c = mo6095c(obj);
        if (c3021cMo6095c == null) {
            return null;
        }
        this.f10353d--;
        WeakHashMap weakHashMap = this.f10352c;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((AbstractC3023e) it.next()).mo6097a(c3021cMo6095c);
            }
        }
        C3021c c3021c = c3021cMo6095c.f10346d;
        if (c3021c != null) {
            c3021c.f10345c = c3021cMo6095c.f10345c;
        } else {
            this.f10350a = c3021cMo6095c.f10345c;
        }
        C3021c c3021c2 = c3021cMo6095c.f10345c;
        if (c3021c2 != null) {
            c3021c2.f10346d = c3021c;
        } else {
            this.f10351b = c3021c;
        }
        c3021cMo6095c.f10345c = null;
        c3021cMo6095c.f10346d = null;
        return c3021cMo6095c.f10344b;
    }

    public final boolean equals(Object obj) {
        C3020b c3020b;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3024f)) {
            return false;
        }
        C3024f c3024f = (C3024f) obj;
        if (this.f10353d != c3024f.f10353d) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = c3024f.iterator();
        while (true) {
            c3020b = (C3020b) it;
            if (!c3020b.hasNext()) {
                break;
            }
            C3020b c3020b2 = (C3020b) it2;
            if (!c3020b2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) c3020b.next();
            Object next = c3020b2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (c3020b.hasNext() || ((C3020b) it2).hasNext()) ? false : true;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            C3020b c3020b = (C3020b) it;
            if (!c3020b.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) c3020b.next()).hashCode();
        }
    }

    @Override
    public final Iterator iterator() {
        C3020b c3020b = new C3020b(this.f10350a, this.f10351b, 0);
        this.f10352c.put(c3020b, Boolean.FALSE);
        return c3020b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            C3020b c3020b = (C3020b) it;
            if (!c3020b.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) c3020b.next()).toString());
            if (c3020b.hasNext()) {
                sb.append(", ");
            }
        }
    }
}

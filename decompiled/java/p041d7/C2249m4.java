package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1354n;
import p029c7.C1427w;

public final class C2249m4 extends C1427w {

    public final Map f7999c;

    public final Object f8000d;

    public C2249m4(C2242l4 c2242l4, Map map, InterfaceC1354n interfaceC1354n) {
        super(c2242l4);
        this.f7999c = map;
        this.f8000d = interfaceC1354n;
    }

    @Override
    public final boolean remove(Object obj) {
        Iterator it = this.f7999c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (this.f8000d.apply(entry) && AbstractC1332b.m3225p(entry.getValue(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean removeAll(Collection collection) {
        Iterator it = this.f7999c.entrySet().iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (this.f8000d.apply(entry) && collection.contains(entry.getValue())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    @Override
    public final boolean retainAll(Collection collection) {
        Iterator it = this.f7999c.entrySet().iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (this.f8000d.apply(entry) && !collection.contains(entry.getValue())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    @Override
    public final Object[] toArray() {
        return AbstractC2182d0.m5156s(iterator()).toArray();
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        return AbstractC2182d0.m5156s(iterator()).toArray(objArr);
    }
}

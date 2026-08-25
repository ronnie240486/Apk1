package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class C2304u4 extends AbstractC2329z {

    public final AbstractC2311w f8073c;

    public C2304u4(AbstractC2311w abstractC2311w) {
        this.f8073c = abstractC2311w;
    }

    @Override
    public int mo5166b(int i6, Object obj) {
        Object obj2;
        AbstractC2182d0.m5141d(i6, "occurrences");
        if (i6 == 0) {
            return count(obj);
        }
        Map mapMo5173d = this.f8073c.mo5173d();
        mapMo5173d.getClass();
        try {
            obj2 = mapMo5173d.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return 0;
        }
        int size = collection.size();
        if (i6 >= size) {
            collection.clear();
        } else {
            Iterator it = collection.iterator();
            for (int i10 = 0; i10 < i6; i10++) {
                it.next();
                it.remove();
            }
        }
        return size;
    }

    @Override
    public final void clear() {
        this.f8073c.clear();
    }

    @Override
    public final boolean contains(Object obj) {
        return this.f8073c.containsKey(obj);
    }

    @Override
    public final int count(Object obj) {
        Object obj2;
        Map mapMo5173d = this.f8073c.mo5173d();
        mapMo5173d.getClass();
        try {
            obj2 = mapMo5173d.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    @Override
    public final int mo5281e() {
        return this.f8073c.mo5173d().size();
    }

    @Override
    public final Set elementSet() {
        return this.f8073c.keySet();
    }

    @Override
    public final Iterator mo5282f() {
        throw new AssertionError("should never be called");
    }

    @Override
    public final Iterator mo5283g() {
        return new C2200f4(this.f8073c.mo5173d().entrySet().iterator(), 2);
    }

    @Override
    public final Iterator iterator() {
        return new C2200f4(this.f8073c.mo5108a().iterator(), 0);
    }

    @Override
    public final int size() {
        return this.f8073c.size();
    }
}

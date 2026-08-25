package p041d7;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class C2195f extends AbstractC2263o4 {

    public final transient Map f7887d;

    public final AbstractC2286s f7888e;

    public C2195f(AbstractC2286s abstractC2286s, Map map) {
        this.f7888e = abstractC2286s;
        this.f7887d = map;
    }

    @Override
    public final Set mo5170a() {
        return new C2181d(this, 0);
    }

    @Override
    public final void clear() {
        AbstractC2286s abstractC2286s = this.f7888e;
        if (this.f7887d == abstractC2286s.f8045f) {
            abstractC2286s.clear();
        } else {
            AbstractC2182d0.m5142e(new C2188e(this));
        }
    }

    @Override
    public final boolean containsKey(Object obj) {
        Map map = this.f7887d;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final C2281r1 m5171d(Map.Entry entry) {
        Object key = entry.getKey();
        return new C2281r1(key, this.f7888e.mo5105s((Collection) entry.getValue(), key));
    }

    @Override
    public final boolean equals(Object obj) {
        return this == obj || this.f7887d.equals(obj);
    }

    @Override
    public final Object get(Object obj) {
        Object obj2;
        Map map = this.f7887d;
        map.getClass();
        try {
            obj2 = map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return null;
        }
        return this.f7888e.mo5105s(collection, obj);
    }

    @Override
    public final int hashCode() {
        return this.f7887d.hashCode();
    }

    @Override
    public Set keySet() {
        return this.f7888e.keySet();
    }

    @Override
    public final Object remove(Object obj) {
        Collection collection = (Collection) this.f7887d.remove(obj);
        if (collection == null) {
            return null;
        }
        AbstractC2286s abstractC2286s = this.f7888e;
        Collection collectionMo5099o = abstractC2286s.mo5099o();
        collectionMo5099o.addAll(collection);
        abstractC2286s.f8046g -= collection.size();
        collection.clear();
        return collectionMo5099o;
    }

    @Override
    public final int size() {
        return this.f7887d.size();
    }

    @Override
    public final String toString() {
        return this.f7887d.toString();
    }
}

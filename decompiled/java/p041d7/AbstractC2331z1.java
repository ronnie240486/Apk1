package p041d7;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

public abstract class AbstractC2331z1 implements Map, Serializable {

    public transient C2194e5 f8112a;

    public transient C2201f5 f8113b;

    public transient C2208g5 f8114c;

    public static C2325y1 m5295a() {
        return new C2325y1(4);
    }

    public static AbstractC2331z1 m5296b(Map map) {
        if (!(map instanceof AbstractC2331z1) || (map instanceof SortedMap)) {
            return m5297c(map.entrySet());
        }
        AbstractC2331z1 abstractC2331z1 = (AbstractC2331z1) map;
        abstractC2331z1.getClass();
        return abstractC2331z1;
    }

    public static C2215h5 m5297c(Collection collection) {
        boolean z7 = collection instanceof Collection;
        C2325y1 c2325y1 = new C2325y1(z7 ? collection.size() : 4);
        if (z7) {
            int size = collection.size() * 2;
            Object[] objArr = c2325y1.f8102a;
            if (size > objArr.length) {
                c2325y1.f8102a = Arrays.copyOf(objArr, AbstractC2267p1.m5254f(objArr.length, size));
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            c2325y1.m5292b(entry.getKey(), entry.getValue());
        }
        return c2325y1.m5291a();
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override
    public final AbstractC2233k2 entrySet() {
        C2194e5 c2194e5 = this.f8112a;
        if (c2194e5 != null) {
            return c2194e5;
        }
        C2215h5 c2215h5 = (C2215h5) this;
        C2194e5 c2194e6 = new C2194e5(c2215h5, c2215h5.f7929e, c2215h5.f7930f);
        this.f8112a = c2194e6;
        return c2194e6;
    }

    @Override
    public final AbstractC2233k2 keySet() {
        C2201f5 c2201f5 = this.f8113b;
        if (c2201f5 != null) {
            return c2201f5;
        }
        C2215h5 c2215h5 = (C2215h5) this;
        C2201f5 c2201f6 = new C2201f5(c2215h5, new C2208g5(c2215h5.f7929e, 0, c2215h5.f7930f));
        this.f8113b = c2201f6;
        return c2201f6;
    }

    @Override
    public final boolean equals(Object obj) {
        return AbstractC2182d0.m5146i(this, obj);
    }

    @Override
    public final AbstractC2274q1 values() {
        C2208g5 c2208g5 = this.f8114c;
        if (c2208g5 != null) {
            return c2208g5;
        }
        C2215h5 c2215h5 = (C2215h5) this;
        C2208g5 c2208g6 = new C2208g5(c2215h5.f7929e, 1, c2215h5.f7930f);
        this.f8114c = c2208g6;
        return c2208g6;
    }

    @Override
    public abstract Object get(Object obj);

    @Override
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override
    public final int hashCode() {
        return AbstractC2182d0.m5153p(entrySet());
    }

    @Override
    public final boolean isEmpty() {
        return ((C2215h5) this).size() == 0;
    }

    @Override
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return AbstractC2182d0.m5135G(this);
    }
}

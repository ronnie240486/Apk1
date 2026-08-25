package p041d7;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import p020b7.AbstractC1332b;

public abstract class AbstractC2286s extends AbstractC2311w implements Serializable {

    public final transient Map f8045f;

    public transient int f8046g;

    public AbstractC2286s(Map map) {
        AbstractC1332b.m3215f(map.isEmpty());
        this.f8045f = map;
    }

    @Override
    public final void clear() {
        Map map = this.f8045f;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.f8046g = 0;
    }

    @Override
    public final boolean containsKey(Object obj) {
        return this.f8045f.containsKey(obj);
    }

    @Override
    public Collection get(Object obj) {
        Collection collectionMo5099o = (Collection) this.f8045f.get(obj);
        if (collectionMo5099o == null) {
            collectionMo5099o = mo5099o();
        }
        return mo5105s(collectionMo5099o, obj);
    }

    @Override
    public Map mo5112i() {
        return new C2195f(this, this.f8045f);
    }

    @Override
    public final Collection mo5113j() {
        return this instanceof InterfaceC2243l5 ? new C2305v(this, 0) : new C2299u(this, 0);
    }

    @Override
    public Set mo5114k() {
        return new C2202g(this, this.f8045f);
    }

    @Override
    public final InterfaceC2310v4 mo5115l() {
        return new C2304u4(this);
    }

    @Override
    public final Collection mo5116m() {
        return new C2299u(this, 1);
    }

    public abstract Collection mo5099o();

    public final C2195f m5260p() {
        Map map = this.f8045f;
        if (map instanceof NavigableMap) {
            return new C2209h(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new C2230k(this, (SortedMap) map) : new C2195f(this, map);
    }

    @Override
    public boolean put(Object obj, Object obj2) {
        Map map = this.f8045f;
        Collection collection = (Collection) map.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.f8046g++;
            return true;
        }
        Collection collectionMo5099o = mo5099o();
        if (!collectionMo5099o.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f8046g++;
        map.put(obj, collectionMo5099o);
        return true;
    }

    public final C2202g m5261q() {
        Map map = this.f8045f;
        if (map instanceof NavigableMap) {
            return new C2216i(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new C2237l(this, (SortedMap) map) : new C2202g(this, map);
    }

    public abstract Collection mo5104r(Collection collection);

    public abstract Collection mo5105s(Collection collection, Object obj);

    @Override
    public final int size() {
        return this.f8046g;
    }
}

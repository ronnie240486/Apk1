package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p020b7.AbstractC1332b;

public abstract class AbstractC2232k1 extends AbstractC2239l1 implements Map {
    @Override
    public void clear() {
        delegate().clear();
    }

    public boolean containsKey(Object obj) {
        return delegate().containsKey(obj);
    }

    @Override
    public abstract Map delegate();

    public Set entrySet() {
        return delegate().entrySet();
    }

    public Object get(Object obj) {
        return delegate().get(obj);
    }

    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set keySet() {
        return delegate().keySet();
    }

    @Override
    public Object put(Object obj, Object obj2) {
        return delegate().put(obj, obj2);
    }

    @Override
    public void putAll(Map<Object, Object> map) {
        delegate().putAll(map);
    }

    @Override
    public Object remove(Object obj) {
        return delegate().remove(obj);
    }

    public int size() {
        return delegate().size();
    }

    public void standardClear() {
        AbstractC2182d0.m5142e(entrySet().iterator());
    }

    public boolean standardContainsKey(Object obj) {
        return AbstractC2182d0.m5143f(new C2200f4(entrySet().iterator(), 0), obj);
    }

    public boolean standardContainsValue(Object obj) {
        return AbstractC2182d0.m5143f(new C2200f4(entrySet().iterator(), 1), obj);
    }

    public boolean standardEquals(Object obj) {
        return AbstractC2182d0.m5146i(this, obj);
    }

    public int standardHashCode() {
        return AbstractC2182d0.m5153p(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    public void standardPutAll(Map<Object, Object> map) {
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Object standardRemove(Object obj) {
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (AbstractC1332b.m3225p(entry.getKey(), obj)) {
                Object value = entry.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    public String standardToString() {
        return AbstractC2182d0.m5135G(this);
    }

    @Override
    public Collection<Object> values() {
        return delegate().values();
    }
}

package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class AbstractC2311w implements InterfaceC2270p4 {

    public transient Collection f8078a;

    public transient Set f8079b;

    public transient InterfaceC2310v4 f8080c;

    public transient Collection f8081d;

    public transient Map f8082e;

    @Override
    public Collection mo5108a() {
        Collection collection = this.f8078a;
        if (collection != null) {
            return collection;
        }
        Collection collectionMo5113j = mo5113j();
        this.f8078a = collectionMo5113j;
        return collectionMo5113j;
    }

    @Override
    public Map mo5173d() {
        Map map = this.f8082e;
        if (map != null) {
            return map;
        }
        Map mapMo5112i = mo5112i();
        this.f8082e = mapMo5112i;
        return mapMo5112i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InterfaceC2270p4) {
            return mo5173d().equals(((InterfaceC2270p4) obj).mo5173d());
        }
        return false;
    }

    @Override
    public InterfaceC2310v4 mo5174f() {
        InterfaceC2310v4 interfaceC2310v4 = this.f8080c;
        if (interfaceC2310v4 != null) {
            return interfaceC2310v4;
        }
        InterfaceC2310v4 interfaceC2310v4Mo5115l = mo5115l();
        this.f8080c = interfaceC2310v4Mo5115l;
        return interfaceC2310v4Mo5115l;
    }

    public final boolean m5285g(Object obj, Object obj2) {
        Collection collection = (Collection) mo5173d().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean mo5175h(Object obj) {
        Iterator it = mo5173d().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return mo5173d().hashCode();
    }

    public abstract Map mo5112i();

    public abstract Collection mo5113j();

    public abstract Set mo5114k();

    @Override
    public Set keySet() {
        Set set = this.f8079b;
        if (set != null) {
            return set;
        }
        Set setMo5114k = mo5114k();
        this.f8079b = setMo5114k;
        return setMo5114k;
    }

    public abstract InterfaceC2310v4 mo5115l();

    public abstract Collection mo5116m();

    public boolean m5286n(Collection collection, Object obj) {
        collection.getClass();
        return !collection.isEmpty() && get(obj).addAll(collection);
    }

    @Override
    public boolean put(Object obj, Object obj2) {
        return get(obj).add(obj2);
    }

    @Override
    public boolean remove(Object obj, Object obj2) {
        Collection collection = (Collection) mo5173d().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public final String toString() {
        return mo5173d().toString();
    }

    @Override
    public Collection values() {
        Collection collection = this.f8081d;
        if (collection != null) {
            return collection;
        }
        Collection collectionMo5116m = mo5116m();
        this.f8081d = collectionMo5116m;
        return collectionMo5116m;
    }
}

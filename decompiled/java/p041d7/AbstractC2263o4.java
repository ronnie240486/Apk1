package p041d7;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;
import p029c7.C1427w;

public abstract class AbstractC2263o4 extends AbstractMap {

    public transient Set f8015a;

    public transient Set f8016b;

    public transient Collection f8017c;

    public abstract Set mo5170a();

    public Set mo5185b() {
        return new C2317x(this);
    }

    public Collection mo5237c() {
        return new C1427w(this);
    }

    @Override
    public final Set entrySet() {
        Set set = this.f8015a;
        if (set != null) {
            return set;
        }
        Set setMo5170a = mo5170a();
        this.f8015a = setMo5170a;
        return setMo5170a;
    }

    @Override
    public Set keySet() {
        Set set = this.f8016b;
        if (set != null) {
            return set;
        }
        Set setMo5185b = mo5185b();
        this.f8016b = setMo5185b;
        return setMo5185b;
    }

    @Override
    public final Collection values() {
        Collection collection = this.f8017c;
        if (collection != null) {
            return collection;
        }
        Collection collectionMo5237c = mo5237c();
        this.f8017c = collectionMo5237c;
        return collectionMo5237c;
    }
}

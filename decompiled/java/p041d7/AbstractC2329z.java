package p041d7;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractC2329z extends AbstractCollection implements InterfaceC2310v4 {

    public transient Set f8109a;

    public transient Set f8110b;

    @Override
    public final boolean add(Object obj) {
        add(1, obj);
        return true;
    }

    @Override
    public final boolean addAll(Collection collection) {
        collection.getClass();
        if (!(collection instanceof InterfaceC2310v4)) {
            if (collection.isEmpty()) {
                return false;
            }
            return AbstractC2182d0.m5138a(this, collection.iterator());
        }
        InterfaceC2310v4 interfaceC2310v4 = (InterfaceC2310v4) collection;
        if (interfaceC2310v4.isEmpty()) {
            return false;
        }
        for (AbstractC2316w4 abstractC2316w4 : interfaceC2310v4.entrySet()) {
            add(abstractC2316w4.mo5264a(), abstractC2316w4.mo5265b());
        }
        return true;
    }

    public Set mo5293c() {
        return new C2317x(this);
    }

    @Override
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    public Set mo5294d() {
        return new C2323y(this, 0);
    }

    public abstract int mo5281e();

    public Set elementSet() {
        Set set = this.f8109a;
        if (set != null) {
            return set;
        }
        Set setMo5293c = mo5293c();
        this.f8109a = setMo5293c;
        return setMo5293c;
    }

    public Set entrySet() {
        Set set = this.f8110b;
        if (set != null) {
            return set;
        }
        Set setMo5294d = mo5294d();
        this.f8110b = setMo5294d;
        return setMo5294d;
    }

    @Override
    public final boolean equals(Object obj) {
        return AbstractC2182d0.m5145h(this, obj);
    }

    public abstract Iterator mo5282f();

    public abstract Iterator mo5283g();

    @Override
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override
    public final boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override
    public final boolean remove(Object obj) {
        return mo5166b(1, obj) > 0;
    }

    @Override
    public final boolean removeAll(Collection collection) {
        if (collection instanceof InterfaceC2310v4) {
            collection = ((InterfaceC2310v4) collection).elementSet();
        }
        return elementSet().removeAll(collection);
    }

    @Override
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        if (collection instanceof InterfaceC2310v4) {
            collection = ((InterfaceC2310v4) collection).elementSet();
        }
        return elementSet().retainAll(collection);
    }

    @Override
    public final String toString() {
        return entrySet().toString();
    }

    public int add(int i6, Object obj) {
        throw new UnsupportedOperationException();
    }
}

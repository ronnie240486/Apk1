package p041d7;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1354n;

public class C2189e0 extends AbstractCollection {

    public final Collection f7876a;

    public final InterfaceC1354n f7877b;

    public C2189e0(Collection collection, InterfaceC1354n interfaceC1354n) {
        this.f7876a = collection;
        this.f7877b = interfaceC1354n;
    }

    @Override
    public final boolean add(Object obj) {
        AbstractC1332b.m3215f(this.f7877b.apply(obj));
        return this.f7876a.add(obj);
    }

    @Override
    public final boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            AbstractC1332b.m3215f(this.f7877b.apply(it.next()));
        }
        return this.f7876a.addAll(collection);
    }

    @Override
    public final void clear() {
        AbstractC2182d0.m5162y(this.f7876a, this.f7877b);
    }

    @Override
    public final boolean contains(Object obj) {
        boolean zContains;
        Collection collection = this.f7876a;
        collection.getClass();
        try {
            zContains = collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            zContains = false;
        }
        if (zContains) {
            return this.f7877b.apply(obj);
        }
        return false;
    }

    @Override
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean isEmpty() {
        Iterator it = this.f7876a.iterator();
        InterfaceC1354n interfaceC1354n = this.f7877b;
        AbstractC1332b.m3219j(interfaceC1354n, "predicate");
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                i6 = -1;
                break;
            }
            if (interfaceC1354n.apply(it.next())) {
                break;
            }
            i6++;
        }
        return true ^ (i6 != -1);
    }

    @Override
    public final Iterator iterator() {
        Iterator it = this.f7876a.iterator();
        it.getClass();
        InterfaceC1354n interfaceC1354n = this.f7877b;
        interfaceC1354n.getClass();
        return new C2287s0(it, interfaceC1354n);
    }

    @Override
    public final boolean remove(Object obj) {
        return contains(obj) && this.f7876a.remove(obj);
    }

    @Override
    public final boolean removeAll(Collection collection) {
        Iterator it = this.f7876a.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.f7877b.apply(next) && collection.contains(next)) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    @Override
    public final boolean retainAll(Collection collection) {
        Iterator it = this.f7876a.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.f7877b.apply(next) && !collection.contains(next)) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    @Override
    public final int size() {
        Iterator it = this.f7876a.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (this.f7877b.apply(it.next())) {
                i6++;
            }
        }
        return i6;
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

package p041d7;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public final class C2250m5 extends AbstractSet {

    public final AbstractC2233k2 f8001a;

    public final AbstractC2233k2 f8002b;

    public C2250m5(AbstractC2233k2 abstractC2233k2, AbstractC2233k2 abstractC2233k3) {
        this.f8001a = abstractC2233k2;
        this.f8002b = abstractC2233k3;
    }

    @Override
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean contains(Object obj) {
        return this.f8001a.contains(obj) && this.f8002b.contains(obj);
    }

    @Override
    public final boolean containsAll(Collection collection) {
        return this.f8001a.containsAll(collection) && this.f8002b.containsAll(collection);
    }

    @Override
    public final boolean isEmpty() {
        return Collections.disjoint(this.f8002b, this.f8001a);
    }

    @Override
    public final Iterator iterator() {
        return new C2287s0(this);
    }

    @Override
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int size() {
        Iterator it = this.f8001a.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (this.f8002b.contains(it.next())) {
                i6++;
            }
        }
        return i6;
    }
}

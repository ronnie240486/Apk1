package p041d7;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public abstract class AbstractC2244m extends AbstractCollection {

    public final Object f7991a;

    public Collection f7992b;

    public final AbstractC2244m f7993c;

    public final Collection f7994d;

    public final AbstractC2286s f7995e;

    public AbstractC2244m(AbstractC2286s abstractC2286s, Object obj, Collection collection, AbstractC2244m abstractC2244m) {
        this.f7995e = abstractC2286s;
        this.f7991a = obj;
        this.f7992b = collection;
        this.f7993c = abstractC2244m;
        this.f7994d = abstractC2244m == null ? null : abstractC2244m.f7992b;
    }

    @Override
    public final boolean add(Object obj) {
        m5241d();
        boolean zIsEmpty = this.f7992b.isEmpty();
        boolean zAdd = this.f7992b.add(obj);
        if (zAdd) {
            this.f7995e.f8046g++;
            if (zIsEmpty) {
                m5240c();
            }
        }
        return zAdd;
    }

    @Override
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = this.f7992b.addAll(collection);
        if (zAddAll) {
            this.f7995e.f8046g += this.f7992b.size() - size;
            if (size == 0) {
                m5240c();
            }
        }
        return zAddAll;
    }

    public final void m5240c() {
        AbstractC2244m abstractC2244m = this.f7993c;
        if (abstractC2244m != null) {
            abstractC2244m.m5240c();
        } else {
            this.f7995e.f8045f.put(this.f7991a, this.f7992b);
        }
    }

    @Override
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f7992b.clear();
        this.f7995e.f8046g -= size;
        m5242e();
    }

    @Override
    public final boolean contains(Object obj) {
        m5241d();
        return this.f7992b.contains(obj);
    }

    @Override
    public final boolean containsAll(Collection collection) {
        m5241d();
        return this.f7992b.containsAll(collection);
    }

    public final void m5241d() {
        Collection collection;
        AbstractC2244m abstractC2244m = this.f7993c;
        if (abstractC2244m != null) {
            abstractC2244m.m5241d();
            if (abstractC2244m.f7992b != this.f7994d) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.f7992b.isEmpty() || (collection = (Collection) this.f7995e.f8045f.get(this.f7991a)) == null) {
                return;
            }
            this.f7992b = collection;
        }
    }

    public final void m5242e() {
        AbstractC2244m abstractC2244m = this.f7993c;
        if (abstractC2244m != null) {
            abstractC2244m.m5242e();
        } else if (this.f7992b.isEmpty()) {
            this.f7995e.f8045f.remove(this.f7991a);
        }
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        m5241d();
        return this.f7992b.equals(obj);
    }

    @Override
    public final int hashCode() {
        m5241d();
        return this.f7992b.hashCode();
    }

    @Override
    public final Iterator iterator() {
        m5241d();
        return new C2188e(this);
    }

    @Override
    public final boolean remove(Object obj) {
        m5241d();
        boolean zRemove = this.f7992b.remove(obj);
        if (zRemove) {
            this.f7995e.f8046g--;
            m5242e();
        }
        return zRemove;
    }

    @Override
    public boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zRemoveAll = this.f7992b.removeAll(collection);
        if (zRemoveAll) {
            this.f7995e.f8046g += this.f7992b.size() - size;
            m5242e();
        }
        return zRemoveAll;
    }

    @Override
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean zRetainAll = this.f7992b.retainAll(collection);
        if (zRetainAll) {
            this.f7995e.f8046g += this.f7992b.size() - size;
            m5242e();
        }
        return zRetainAll;
    }

    @Override
    public final int size() {
        m5241d();
        return this.f7992b.size();
    }

    @Override
    public final String toString() {
        m5241d();
        return this.f7992b.toString();
    }
}

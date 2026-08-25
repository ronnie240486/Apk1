package p253x8;

import java.util.Collection;
import java.util.Iterator;
import p103j9.AbstractC2796i;
import p115k9.InterfaceC2905a;
import qa.C3554b;

public abstract class AbstractC4138a implements Collection, InterfaceC2905a {
    @Override
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (AbstractC2796i.m5780a(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends Object> collection) {
        AbstractC2796i.m5785f(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract int getSize();

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return getSize();
    }

    @Override
    public Object[] toArray() {
        return AbstractC2796i.m5792m(this);
    }

    public String toString() {
        return AbstractC4147j.m8184X(this, ", ", "[", "]", new C3554b(1, this), 24);
    }

    @Override
    public <T> T[] toArray(T[] tArr) {
        AbstractC2796i.m5785f(tArr, "array");
        return (T[]) AbstractC2796i.m5793n(this, tArr);
    }
}

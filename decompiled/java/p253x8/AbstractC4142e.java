package p253x8;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import p103j9.AbstractC2796i;
import p103j9.C2788a;

public abstract class AbstractC4142e extends AbstractC4138a implements List {
    public static final C4139b Companion = new C4139b();
    private static final int maxArraySize = 2147483639;

    @Override
    public void add(int i6, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(int i6, Collection<Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        Companion.getClass();
        AbstractC2796i.m5785f(collection, "other");
        if (size() == collection.size()) {
            Iterator it = collection.iterator();
            Iterator<E> it2 = iterator();
            while (it2.hasNext()) {
                if (!AbstractC2796i.m5780a(it2.next(), it.next())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        Companion.getClass();
        Iterator<E> it = iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }

    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (AbstractC2796i.m5780a(it.next(), obj)) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    @Override
    public Iterator<Object> iterator() {
        return new C2788a(3, this);
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (AbstractC2796i.m5780a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override
    public ListIterator<Object> listIterator() {
        return new C4140c(this, 0);
    }

    @Override
    public Object remove(int i6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object set(int i6, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public List<Object> subList(int i6, int i10) {
        return new C4141d(this, i6, i10);
    }

    @Override
    public ListIterator<Object> listIterator(int i6) {
        return new C4140c(this, i6);
    }
}

package p253x8;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import okhttp3.HttpUrl;
import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;
import p115k9.InterfaceC2905a;

public final class C4155r implements List, Serializable, RandomAccess, InterfaceC2905a {

    public static final C4155r f14074a = new C4155r();

    @Override
    public final void add(int i6, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean addAll(int i6, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean contains(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        AbstractC2796i.m5785f((Void) obj, "element");
        return false;
    }

    @Override
    public final boolean containsAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        return collection.isEmpty();
    }

    @Override
    public final boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @Override
    public final Object get(int i6) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i6 + '.');
    }

    @Override
    public final int hashCode() {
        return 1;
    }

    @Override
    public final int indexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        AbstractC2796i.m5785f((Void) obj, "element");
        return -1;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final Iterator iterator() {
        return C4154q.f14073a;
    }

    @Override
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        AbstractC2796i.m5785f((Void) obj, "element");
        return -1;
    }

    @Override
    public final ListIterator listIterator() {
        return C4154q.f14073a;
    }

    @Override
    public final Object remove(int i6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object set(int i6, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return 0;
    }

    @Override
    public final List subList(int i6, int i10) {
        if (i6 == 0 && i10 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException(AbstractC0004e.m19m(i6, i10, "fromIndex: ", ", toIndex: "));
    }

    @Override
    public final Object[] toArray() {
        return AbstractC2796i.m5792m(this);
    }

    public final String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @Override
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final ListIterator listIterator(int i6) {
        if (i6 == 0) {
            return C4154q.f14073a;
        }
        throw new IndexOutOfBoundsException(AbstractC0004e.m20n(i6, "Index: "));
    }

    @Override
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        AbstractC2796i.m5785f(objArr, "array");
        return AbstractC2796i.m5793n(this, objArr);
    }
}

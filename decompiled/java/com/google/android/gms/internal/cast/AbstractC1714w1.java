package com.google.android.gms.internal.cast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class AbstractC1714w1 extends AbstractC1687t1 implements List, RandomAccess {

    public static final C1696u1 f5716b = new C1696u1(C1504a2.f5202e, 0);

    public static C1504a2 m4052h(Object[] objArr, int i6) {
        return i6 == 0 ? C1504a2.f5202e : new C1504a2(objArr, i6);
    }

    @Override
    public final void add(int i6, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(int i6, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int mo3710c(Object[] objArr) {
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            objArr[i6] = get(i6);
        }
        return size;
    }

    @Override
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override
    public final boolean equals(Object obj) {
        Object next;
        Object next2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i6 = 0; i6 < size; i6++) {
                        Object obj2 = get(i6);
                        Object obj3 = list.get(i6);
                        if (obj2 == obj3 || (obj2 != null && obj2.equals(obj3))) {
                        }
                    }
                    return true;
                }
                C1696u1 c1696u1ListIterator = listIterator(0);
                Iterator it = list.iterator();
                while (c1696u1ListIterator.hasNext()) {
                    if (it.hasNext() && ((next = c1696u1ListIterator.next()) == (next2 = it.next()) || (next != null && next.equals(next2)))) {
                    }
                }
                if (!it.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public AbstractC1714w1 subList(int i6, int i10) {
        AbstractC1503a1.m3701n(i6, i10, size());
        int i11 = i10 - i6;
        if (i11 == size()) {
            return this;
        }
        return i11 == 0 ? C1504a2.f5202e : new C1705v1(this, i6, i11);
    }

    @Override
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i6 = 0; i6 < size; i6++) {
            iHashCode = (iHashCode * 31) + get(i6).hashCode();
        }
        return iHashCode;
    }

    @Override
    public final C1696u1 listIterator(int i6) {
        AbstractC1503a1.m3700l(i6, size());
        return isEmpty() ? f5716b : new C1696u1(this, i6);
    }

    @Override
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            if (obj.equals(get(i6))) {
                return i6;
            }
        }
        return -1;
    }

    @Override
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override
    public final Object remove(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object set(int i6, Object obj) {
        throw new UnsupportedOperationException();
    }
}

package p160p;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class C3338b implements Set {

    public final C3341e f11306a;

    public C3338b(C3341e c3341e) {
        this.f11306a = c3341e;
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
        this.f11306a.clear();
    }

    @Override
    public final boolean contains(Object obj) {
        return this.f11306a.containsKey(obj);
    }

    @Override
    public final boolean containsAll(Collection collection) {
        return this.f11306a.m6782k(collection);
    }

    @Override
    public final boolean equals(Object obj) {
        C3341e c3341e = this.f11306a;
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (c3341e.f11334c == set.size() && c3341e.m6782k(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        C3341e c3341e = this.f11306a;
        int iHashCode = 0;
        for (int i6 = c3341e.f11334c - 1; i6 >= 0; i6--) {
            Object objM6812f = c3341e.m6812f(i6);
            iHashCode += objM6812f == null ? 0 : objM6812f.hashCode();
        }
        return iHashCode;
    }

    @Override
    public final boolean isEmpty() {
        return this.f11306a.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return new C3337a(this.f11306a, 0);
    }

    @Override
    public final boolean remove(Object obj) {
        C3341e c3341e = this.f11306a;
        int iM6810d = c3341e.m6810d(obj);
        if (iM6810d < 0) {
            return false;
        }
        c3341e.mo6814h(iM6810d);
        return true;
    }

    @Override
    public final boolean removeAll(Collection collection) {
        return this.f11306a.m6783l(collection);
    }

    @Override
    public final boolean retainAll(Collection collection) {
        C3341e c3341e = this.f11306a;
        int i6 = c3341e.f11334c;
        for (int i10 = i6 - 1; i10 >= 0; i10--) {
            if (!collection.contains(c3341e.m6812f(i10))) {
                c3341e.mo6814h(i10);
            }
        }
        return i6 != c3341e.f11334c;
    }

    @Override
    public final int size() {
        return this.f11306a.f11334c;
    }

    @Override
    public final Object[] toArray() {
        C3341e c3341e = this.f11306a;
        int i6 = c3341e.f11334c;
        Object[] objArr = new Object[i6];
        for (int i10 = 0; i10 < i6; i10++) {
            objArr[i10] = c3341e.m6812f(i10);
        }
        return objArr;
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        C3341e c3341e = this.f11306a;
        int i6 = c3341e.f11334c;
        if (objArr.length < i6) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i6);
        }
        for (int i10 = 0; i10 < i6; i10++) {
            objArr[i10] = c3341e.m6812f(i10);
        }
        if (objArr.length > i6) {
            objArr[i6] = null;
        }
        return objArr;
    }
}

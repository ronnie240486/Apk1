package p160p;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public final class C3340d implements Collection {

    public final C3341e f11311a;

    public C3340d(C3341e c3341e) {
        this.f11311a = c3341e;
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
        this.f11311a.clear();
    }

    @Override
    public final boolean contains(Object obj) {
        return this.f11311a.m6807a(obj) >= 0;
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
        return this.f11311a.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return new C3337a(this.f11311a, 1);
    }

    @Override
    public final boolean remove(Object obj) {
        C3341e c3341e = this.f11311a;
        int iM6807a = c3341e.m6807a(obj);
        if (iM6807a < 0) {
            return false;
        }
        c3341e.mo6814h(iM6807a);
        return true;
    }

    @Override
    public final boolean removeAll(Collection collection) {
        C3341e c3341e = this.f11311a;
        int i6 = c3341e.f11334c;
        int i10 = 0;
        boolean z7 = false;
        while (i10 < i6) {
            if (collection.contains(c3341e.m6816j(i10))) {
                c3341e.mo6814h(i10);
                i10--;
                i6--;
                z7 = true;
            }
            i10++;
        }
        return z7;
    }

    @Override
    public final boolean retainAll(Collection collection) {
        C3341e c3341e = this.f11311a;
        int i6 = c3341e.f11334c;
        int i10 = 0;
        boolean z7 = false;
        while (i10 < i6) {
            if (!collection.contains(c3341e.m6816j(i10))) {
                c3341e.mo6814h(i10);
                i10--;
                i6--;
                z7 = true;
            }
            i10++;
        }
        return z7;
    }

    @Override
    public final int size() {
        return this.f11311a.f11334c;
    }

    @Override
    public final Object[] toArray() {
        C3341e c3341e = this.f11311a;
        int i6 = c3341e.f11334c;
        Object[] objArr = new Object[i6];
        for (int i10 = 0; i10 < i6; i10++) {
            objArr[i10] = c3341e.m6816j(i10);
        }
        return objArr;
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        C3341e c3341e = this.f11311a;
        int i6 = c3341e.f11334c;
        if (objArr.length < i6) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i6);
        }
        for (int i10 = 0; i10 < i6; i10++) {
            objArr[i10] = c3341e.m6816j(i10);
        }
        if (objArr.length > i6) {
            objArr[i6] = null;
        }
        return objArr;
    }
}

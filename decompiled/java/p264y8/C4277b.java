package p264y8;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import p103j9.AbstractC2796i;
import p156o9.AbstractC3281e;
import p253x8.AbstractC4142e;
import p253x8.AbstractC4143f;
import p253x8.AbstractC4146i;
import p253x8.C4139b;

public final class C4277b extends AbstractC4143f implements RandomAccess, Serializable {

    public Object[] f14491a;

    public final int f14492b;

    public int f14493c;

    public final C4277b f14494d;

    public final C4278c f14495e;

    public C4277b(Object[] objArr, int i6, int i10, C4277b c4277b, C4278c c4278c) {
        AbstractC2796i.m5785f(objArr, "backing");
        AbstractC2796i.m5785f(c4278c, "root");
        this.f14491a = objArr;
        this.f14492b = i6;
        this.f14493c = i10;
        this.f14494d = c4277b;
        this.f14495e = c4278c;
        ((AbstractList) this).modCount = ((AbstractList) c4278c).modCount;
    }

    @Override
    public final boolean add(Object obj) {
        m8330i();
        m8329h();
        m8328g(this.f14492b + this.f14493c, obj);
        return true;
    }

    @Override
    public final boolean addAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        m8330i();
        m8329h();
        int size = collection.size();
        m8327f(this.f14492b + this.f14493c, collection, size);
        return size > 0;
    }

    @Override
    public final int mo8160c() {
        m8329h();
        return this.f14493c;
    }

    @Override
    public final void clear() {
        m8330i();
        m8329h();
        m8332k(this.f14492b, this.f14493c);
    }

    @Override
    public final Object mo8161d(int i6) {
        m8330i();
        m8329h();
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14493c;
        c4139b.getClass();
        C4139b.m8157a(i6, i10);
        return m8331j(this.f14492b + i6);
    }

    @Override
    public final boolean equals(Object obj) {
        m8329h();
        if (obj != this) {
            if (obj instanceof List) {
                if (AbstractC3281e.m6615c(this.f14491a, this.f14492b, this.f14493c, (List) obj)) {
                }
            }
            return false;
        }
        return true;
    }

    public final void m8327f(int i6, Collection collection, int i10) {
        ((AbstractList) this).modCount++;
        C4278c c4278c = this.f14495e;
        C4277b c4277b = this.f14494d;
        if (c4277b != null) {
            c4277b.m8327f(i6, collection, i10);
        } else {
            C4278c c4278c2 = C4278c.f14496d;
            c4278c.m8335f(i6, collection, i10);
        }
        this.f14491a = c4278c.f14497a;
        this.f14493c += i10;
    }

    public final void m8328g(int i6, Object obj) {
        ((AbstractList) this).modCount++;
        C4278c c4278c = this.f14495e;
        C4277b c4277b = this.f14494d;
        if (c4277b != null) {
            c4277b.m8328g(i6, obj);
        } else {
            C4278c c4278c2 = C4278c.f14496d;
            c4278c.m8336g(i6, obj);
        }
        this.f14491a = c4278c.f14497a;
        this.f14493c++;
    }

    @Override
    public final Object get(int i6) {
        m8329h();
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14493c;
        c4139b.getClass();
        C4139b.m8157a(i6, i10);
        return this.f14491a[this.f14492b + i6];
    }

    public final void m8329h() {
        if (((AbstractList) this.f14495e).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public final int hashCode() {
        m8329h();
        Object[] objArr = this.f14491a;
        int i6 = this.f14493c;
        int iHashCode = 1;
        for (int i10 = 0; i10 < i6; i10++) {
            Object obj = objArr[this.f14492b + i10];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void m8330i() {
        if (this.f14495e.f14499c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public final int indexOf(Object obj) {
        m8329h();
        for (int i6 = 0; i6 < this.f14493c; i6++) {
            if (AbstractC2796i.m5780a(this.f14491a[this.f14492b + i6], obj)) {
                return i6;
            }
        }
        return -1;
    }

    @Override
    public final boolean isEmpty() {
        m8329h();
        return this.f14493c == 0;
    }

    @Override
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final Object m8331j(int i6) {
        Object objM8339j;
        ((AbstractList) this).modCount++;
        C4277b c4277b = this.f14494d;
        if (c4277b != null) {
            objM8339j = c4277b.m8331j(i6);
        } else {
            C4278c c4278c = C4278c.f14496d;
            objM8339j = this.f14495e.m8339j(i6);
        }
        this.f14493c--;
        return objM8339j;
    }

    public final void m8332k(int i6, int i10) {
        if (i10 > 0) {
            ((AbstractList) this).modCount++;
        }
        C4277b c4277b = this.f14494d;
        if (c4277b != null) {
            c4277b.m8332k(i6, i10);
        } else {
            C4278c c4278c = C4278c.f14496d;
            this.f14495e.m8340k(i6, i10);
        }
        this.f14493c -= i10;
    }

    public final int m8333l(int i6, int i10, Collection collection, boolean z7) {
        int iM8341l;
        C4277b c4277b = this.f14494d;
        if (c4277b != null) {
            iM8341l = c4277b.m8333l(i6, i10, collection, z7);
        } else {
            C4278c c4278c = C4278c.f14496d;
            iM8341l = this.f14495e.m8341l(i6, i10, collection, z7);
        }
        if (iM8341l > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f14493c -= iM8341l;
        return iM8341l;
    }

    @Override
    public final int lastIndexOf(Object obj) {
        m8329h();
        for (int i6 = this.f14493c - 1; i6 >= 0; i6--) {
            if (AbstractC2796i.m5780a(this.f14491a[this.f14492b + i6], obj)) {
                return i6;
            }
        }
        return -1;
    }

    @Override
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override
    public final boolean remove(Object obj) {
        m8330i();
        m8329h();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            mo8161d(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override
    public final boolean removeAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        m8330i();
        m8329h();
        return m8333l(this.f14492b, this.f14493c, collection, false) > 0;
    }

    @Override
    public final boolean retainAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        m8330i();
        m8329h();
        return m8333l(this.f14492b, this.f14493c, collection, true) > 0;
    }

    @Override
    public final Object set(int i6, Object obj) {
        m8330i();
        m8329h();
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14493c;
        c4139b.getClass();
        C4139b.m8157a(i6, i10);
        Object[] objArr = this.f14491a;
        int i11 = this.f14492b + i6;
        Object obj2 = objArr[i11];
        objArr[i11] = obj;
        return obj2;
    }

    @Override
    public final List subList(int i6, int i10) {
        C4139b c4139b = AbstractC4142e.Companion;
        int i11 = this.f14493c;
        c4139b.getClass();
        C4139b.m8159c(i6, i10, i11);
        return new C4277b(this.f14491a, this.f14492b + i6, i10 - i6, this, this.f14495e);
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        AbstractC2796i.m5785f(objArr, "array");
        m8329h();
        int length = objArr.length;
        int i6 = this.f14493c;
        int i10 = this.f14492b;
        if (length < i6) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f14491a, i10, i6 + i10, objArr.getClass());
            AbstractC2796i.m5784e(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        AbstractC4146i.m8171D(0, i10, i6 + i10, this.f14491a, objArr);
        int i11 = this.f14493c;
        if (i11 < objArr.length) {
            objArr[i11] = null;
        }
        return objArr;
    }

    @Override
    public final String toString() {
        m8329h();
        return AbstractC3281e.m6616d(this.f14491a, this.f14492b, this.f14493c, this);
    }

    @Override
    public final ListIterator listIterator(int i6) {
        m8329h();
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14493c;
        c4139b.getClass();
        C4139b.m8158b(i6, i10);
        return new C4276a(this, i6);
    }

    @Override
    public final void add(int i6, Object obj) {
        m8330i();
        m8329h();
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14493c;
        c4139b.getClass();
        C4139b.m8158b(i6, i10);
        m8328g(this.f14492b + i6, obj);
    }

    @Override
    public final boolean addAll(int i6, Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        m8330i();
        m8329h();
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14493c;
        c4139b.getClass();
        C4139b.m8158b(i6, i10);
        int size = collection.size();
        m8327f(this.f14492b + i6, collection, size);
        return size > 0;
    }

    @Override
    public final Object[] toArray() {
        m8329h();
        Object[] objArr = this.f14491a;
        int i6 = this.f14493c;
        int i10 = this.f14492b;
        return AbstractC4146i.m8175H(objArr, i10, i6 + i10);
    }
}

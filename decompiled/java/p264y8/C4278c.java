package p264y8;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
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

public final class C4278c extends AbstractC4143f implements RandomAccess, Serializable {

    public static final C4278c f14496d;

    public Object[] f14497a;

    public int f14498b;

    public boolean f14499c;

    static {
        C4278c c4278c = new C4278c(0);
        c4278c.f14499c = true;
        f14496d = c4278c;
    }

    public C4278c(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.f14497a = new Object[i6];
    }

    @Override
    public final boolean add(Object obj) {
        m8337h();
        int i6 = this.f14498b;
        ((AbstractList) this).modCount++;
        m8338i(i6, 1);
        this.f14497a[i6] = obj;
        return true;
    }

    @Override
    public final boolean addAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        m8337h();
        int size = collection.size();
        m8335f(this.f14498b, collection, size);
        return size > 0;
    }

    @Override
    public final int mo8160c() {
        return this.f14498b;
    }

    @Override
    public final void clear() {
        m8337h();
        m8340k(0, this.f14498b);
    }

    @Override
    public final Object mo8161d(int i6) {
        m8337h();
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14498b;
        c4139b.getClass();
        C4139b.m8157a(i6, i10);
        return m8339j(i6);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof List)) {
                return false;
            }
            if (!AbstractC3281e.m6615c(this.f14497a, 0, this.f14498b, (List) obj)) {
                return false;
            }
        }
        return true;
    }

    public final void m8335f(int i6, Collection collection, int i10) {
        ((AbstractList) this).modCount++;
        m8338i(i6, i10);
        Iterator it = collection.iterator();
        for (int i11 = 0; i11 < i10; i11++) {
            this.f14497a[i6 + i11] = it.next();
        }
    }

    public final void m8336g(int i6, Object obj) {
        ((AbstractList) this).modCount++;
        m8338i(i6, 1);
        this.f14497a[i6] = obj;
    }

    @Override
    public final Object get(int i6) {
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14498b;
        c4139b.getClass();
        C4139b.m8157a(i6, i10);
        return this.f14497a[i6];
    }

    public final void m8337h() {
        if (this.f14499c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public final int hashCode() {
        Object[] objArr = this.f14497a;
        int i6 = this.f14498b;
        int iHashCode = 1;
        for (int i10 = 0; i10 < i6; i10++) {
            Object obj = objArr[i10];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void m8338i(int i6, int i10) {
        int i11 = this.f14498b + i10;
        if (i11 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f14497a;
        if (i11 > objArr.length) {
            C4139b c4139b = AbstractC4142e.Companion;
            int length = objArr.length;
            c4139b.getClass();
            int i12 = length + (length >> 1);
            if (i12 - i11 < 0) {
                i12 = i11;
            }
            if (i12 - 2147483639 > 0) {
                i12 = i11 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArr2 = this.f14497a;
            AbstractC2796i.m5785f(objArr2, "<this>");
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, i12);
            AbstractC2796i.m5784e(objArrCopyOf, "copyOf(...)");
            this.f14497a = objArrCopyOf;
        }
        Object[] objArr3 = this.f14497a;
        AbstractC4146i.m8171D(i6 + i10, i6, this.f14498b, objArr3, objArr3);
        this.f14498b += i10;
    }

    @Override
    public final int indexOf(Object obj) {
        for (int i6 = 0; i6 < this.f14498b; i6++) {
            if (AbstractC2796i.m5780a(this.f14497a[i6], obj)) {
                return i6;
            }
        }
        return -1;
    }

    @Override
    public final boolean isEmpty() {
        return this.f14498b == 0;
    }

    @Override
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final Object m8339j(int i6) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f14497a;
        Object obj = objArr[i6];
        AbstractC4146i.m8171D(i6, i6 + 1, this.f14498b, objArr, objArr);
        Object[] objArr2 = this.f14497a;
        int i10 = this.f14498b - 1;
        AbstractC2796i.m5785f(objArr2, "<this>");
        objArr2[i10] = null;
        this.f14498b--;
        return obj;
    }

    public final void m8340k(int i6, int i10) {
        if (i10 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f14497a;
        AbstractC4146i.m8171D(i6, i6 + i10, this.f14498b, objArr, objArr);
        Object[] objArr2 = this.f14497a;
        int i11 = this.f14498b;
        AbstractC2796i.m5785f(objArr2, "<this>");
        for (int i12 = i11 - i10; i12 < i11; i12++) {
            objArr2[i12] = null;
        }
        this.f14498b -= i10;
    }

    public final int m8341l(int i6, int i10, Collection collection, boolean z7) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int i13 = i6 + i11;
            if (collection.contains(this.f14497a[i13]) == z7) {
                Object[] objArr = this.f14497a;
                i11++;
                objArr[i12 + i6] = objArr[i13];
                i12++;
            } else {
                i11++;
            }
        }
        int i14 = i10 - i12;
        Object[] objArr2 = this.f14497a;
        AbstractC4146i.m8171D(i6 + i12, i10 + i6, this.f14498b, objArr2, objArr2);
        Object[] objArr3 = this.f14497a;
        int i15 = this.f14498b;
        AbstractC2796i.m5785f(objArr3, "<this>");
        for (int i16 = i15 - i14; i16 < i15; i16++) {
            objArr3[i16] = null;
        }
        if (i14 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f14498b -= i14;
        return i14;
    }

    @Override
    public final int lastIndexOf(Object obj) {
        for (int i6 = this.f14498b - 1; i6 >= 0; i6--) {
            if (AbstractC2796i.m5780a(this.f14497a[i6], obj)) {
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
        m8337h();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            mo8161d(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override
    public final boolean removeAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        m8337h();
        return m8341l(0, this.f14498b, collection, false) > 0;
    }

    @Override
    public final boolean retainAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        m8337h();
        return m8341l(0, this.f14498b, collection, true) > 0;
    }

    @Override
    public final Object set(int i6, Object obj) {
        m8337h();
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14498b;
        c4139b.getClass();
        C4139b.m8157a(i6, i10);
        Object[] objArr = this.f14497a;
        Object obj2 = objArr[i6];
        objArr[i6] = obj;
        return obj2;
    }

    @Override
    public final List subList(int i6, int i10) {
        C4139b c4139b = AbstractC4142e.Companion;
        int i11 = this.f14498b;
        c4139b.getClass();
        C4139b.m8159c(i6, i10, i11);
        return new C4277b(this.f14497a, i6, i10 - i6, null, this);
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        AbstractC2796i.m5785f(objArr, "array");
        int length = objArr.length;
        int i6 = this.f14498b;
        if (length < i6) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f14497a, 0, i6, objArr.getClass());
            AbstractC2796i.m5784e(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        AbstractC4146i.m8171D(0, 0, i6, this.f14497a, objArr);
        int i10 = this.f14498b;
        if (i10 < objArr.length) {
            objArr[i10] = null;
        }
        return objArr;
    }

    @Override
    public final String toString() {
        return AbstractC3281e.m6616d(this.f14497a, 0, this.f14498b, this);
    }

    @Override
    public final ListIterator listIterator(int i6) {
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14498b;
        c4139b.getClass();
        C4139b.m8158b(i6, i10);
        return new C4276a(this, i6);
    }

    @Override
    public final boolean addAll(int i6, Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        m8337h();
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14498b;
        c4139b.getClass();
        C4139b.m8158b(i6, i10);
        int size = collection.size();
        m8335f(i6, collection, size);
        return size > 0;
    }

    @Override
    public final void add(int i6, Object obj) {
        m8337h();
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14498b;
        c4139b.getClass();
        C4139b.m8158b(i6, i10);
        ((AbstractList) this).modCount++;
        m8338i(i6, 1);
        this.f14497a[i6] = obj;
    }

    @Override
    public final Object[] toArray() {
        return AbstractC4146i.m8175H(this.f14497a, 0, this.f14498b);
    }
}

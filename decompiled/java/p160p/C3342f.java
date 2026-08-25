package p160p;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import p103j9.AbstractC2796i;
import p115k9.InterfaceC2905a;
import p171q.AbstractC3387a;
import p253x8.AbstractC4146i;

public final class C3342f implements Collection, Set, InterfaceC2905a {

    public int[] f11315a = AbstractC3387a.f11422a;

    public Object[] f11316b = AbstractC3387a.f11423b;

    public int f11317c;

    public C3342f(int i6) {
        if (i6 > 0) {
            AbstractC3346j.m6805a(this, i6);
        }
    }

    @Override
    public final boolean add(Object obj) {
        int i6;
        int iM6806b;
        int i10 = this.f11317c;
        if (obj == null) {
            iM6806b = AbstractC3346j.m6806b(this, null, 0);
            i6 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i6 = iHashCode;
            iM6806b = AbstractC3346j.m6806b(this, obj, iHashCode);
        }
        if (iM6806b >= 0) {
            return false;
        }
        int i11 = ~iM6806b;
        int[] iArr = this.f11315a;
        if (i10 >= iArr.length) {
            int i12 = 8;
            if (i10 >= 8) {
                i12 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i12 = 4;
            }
            Object[] objArr = this.f11316b;
            AbstractC3346j.m6805a(this, i12);
            if (i10 != this.f11317c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f11315a;
            if (iArr2.length != 0) {
                AbstractC4146i.m8170C(0, 0, iArr.length, iArr, iArr2);
                AbstractC4146i.m8173F(0, objArr.length, 6, objArr, this.f11316b);
            }
        }
        if (i11 < i10) {
            int[] iArr3 = this.f11315a;
            int i13 = i11 + 1;
            AbstractC4146i.m8170C(i13, i11, i10, iArr3, iArr3);
            Object[] objArr2 = this.f11316b;
            AbstractC4146i.m8171D(i13, i11, i10, objArr2, objArr2);
        }
        int i14 = this.f11317c;
        if (i10 == i14) {
            int[] iArr4 = this.f11315a;
            if (i11 < iArr4.length) {
                iArr4[i11] = i6;
                this.f11316b[i11] = obj;
                this.f11317c = i14 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override
    public final boolean addAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        int size = collection.size() + this.f11317c;
        int i6 = this.f11317c;
        int[] iArr = this.f11315a;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f11316b;
            AbstractC3346j.m6805a(this, size);
            int i10 = this.f11317c;
            if (i10 > 0) {
                AbstractC4146i.m8170C(0, 0, i10, iArr, this.f11315a);
                AbstractC4146i.m8173F(0, this.f11317c, 6, objArr, this.f11316b);
            }
        }
        if (this.f11317c != i6) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final Object m6784c(int i6) {
        int i10 = this.f11317c;
        Object[] objArr = this.f11316b;
        Object obj = objArr[i6];
        if (i10 <= 1) {
            clear();
        } else {
            int i11 = i10 - 1;
            int[] iArr = this.f11315a;
            if (iArr.length <= 8 || i10 >= iArr.length / 3) {
                if (i6 < i11) {
                    int i12 = i6 + 1;
                    AbstractC4146i.m8170C(i6, i12, i10, iArr, iArr);
                    Object[] objArr2 = this.f11316b;
                    AbstractC4146i.m8171D(i6, i12, i10, objArr2, objArr2);
                }
                this.f11316b[i11] = null;
            } else {
                AbstractC3346j.m6805a(this, i10 > 8 ? i10 + (i10 >> 1) : 8);
                if (i6 > 0) {
                    AbstractC4146i.m8170C(0, 0, i6, iArr, this.f11315a);
                    AbstractC4146i.m8173F(0, i6, 6, objArr, this.f11316b);
                }
                if (i6 < i11) {
                    int i13 = i6 + 1;
                    AbstractC4146i.m8170C(i6, i13, i10, iArr, this.f11315a);
                    AbstractC4146i.m8171D(i6, i13, i10, objArr, this.f11316b);
                }
            }
            if (i10 != this.f11317c) {
                throw new ConcurrentModificationException();
            }
            this.f11317c = i11;
        }
        return obj;
    }

    @Override
    public final void clear() {
        if (this.f11317c != 0) {
            this.f11315a = AbstractC3387a.f11422a;
            this.f11316b = AbstractC3387a.f11423b;
            this.f11317c = 0;
        }
        if (this.f11317c != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public final boolean contains(Object obj) {
        return (obj == null ? AbstractC3346j.m6806b(this, null, 0) : AbstractC3346j.m6806b(this, obj, obj.hashCode())) >= 0;
    }

    @Override
    public final boolean containsAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && this.f11317c == ((Set) obj).size()) {
            try {
                int i6 = this.f11317c;
                for (int i10 = 0; i10 < i6; i10++) {
                    if (((Set) obj).contains(this.f11316b[i10])) {
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int[] iArr = this.f11315a;
        int i6 = this.f11317c;
        int i10 = 0;
        for (int i11 = 0; i11 < i6; i11++) {
            i10 += iArr[i11];
        }
        return i10;
    }

    @Override
    public final boolean isEmpty() {
        return this.f11317c <= 0;
    }

    @Override
    public final Iterator iterator() {
        return new C3337a(this);
    }

    @Override
    public final boolean remove(Object obj) {
        int iM6806b = obj == null ? AbstractC3346j.m6806b(this, null, 0) : AbstractC3346j.m6806b(this, obj, obj.hashCode());
        if (iM6806b < 0) {
            return false;
        }
        m6784c(iM6806b);
        return true;
    }

    @Override
    public final boolean removeAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override
    public final boolean retainAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        boolean z7 = false;
        for (int i6 = this.f11317c - 1; -1 < i6; i6--) {
            if (!collection.contains(this.f11316b[i6])) {
                m6784c(i6);
                z7 = true;
            }
        }
        return z7;
    }

    @Override
    public final int size() {
        return this.f11317c;
    }

    @Override
    public final Object[] toArray() {
        return AbstractC4146i.m8175H(this.f11316b, 0, this.f11317c);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f11317c * 14);
        sb.append('{');
        int i6 = this.f11317c;
        for (int i10 = 0; i10 < i6; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            Object obj = this.f11316b[i10];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC2796i.m5784e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        AbstractC2796i.m5785f(objArr, "array");
        int i6 = this.f11317c;
        if (objArr.length < i6) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i6);
        } else if (objArr.length > i6) {
            objArr[i6] = null;
        }
        AbstractC4146i.m8171D(0, 0, this.f11317c, this.f11316b, objArr);
        return objArr;
    }
}

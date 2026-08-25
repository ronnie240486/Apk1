package p253x8;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p103j9.AbstractC2796i;

public final class C4145h extends AbstractC4143f {

    public static final Object[] f14069d = new Object[0];

    public int f14070a;

    public Object[] f14071b = f14069d;

    public int f14072c;

    @Override
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override
    public final boolean addAll(Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        m8168k();
        m8163f(collection.size() + mo8160c());
        m8162e(m8167j(mo8160c() + this.f14070a), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        m8168k();
        m8163f(this.f14072c + 1);
        int length = this.f14070a;
        if (length == 0) {
            Object[] objArr = this.f14071b;
            AbstractC2796i.m5785f(objArr, "<this>");
            length = objArr.length;
        }
        int i6 = length - 1;
        this.f14070a = i6;
        this.f14071b[i6] = obj;
        this.f14072c++;
    }

    public final void addLast(Object obj) {
        m8168k();
        m8163f(mo8160c() + 1);
        this.f14071b[m8167j(mo8160c() + this.f14070a)] = obj;
        this.f14072c = mo8160c() + 1;
    }

    @Override
    public final int mo8160c() {
        return this.f14072c;
    }

    @Override
    public final void clear() {
        if (!isEmpty()) {
            m8168k();
            m8166i(this.f14070a, m8167j(mo8160c() + this.f14070a));
        }
        this.f14070a = 0;
        this.f14072c = 0;
    }

    @Override
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public final Object mo8161d(int i6) {
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14072c;
        c4139b.getClass();
        C4139b.m8157a(i6, i10);
        if (i6 == AbstractC4148k.m8191O(this)) {
            return removeLast();
        }
        if (i6 == 0) {
            return removeFirst();
        }
        m8168k();
        int iM8167j = m8167j(this.f14070a + i6);
        Object[] objArr = this.f14071b;
        Object obj = objArr[iM8167j];
        if (i6 < (this.f14072c >> 1)) {
            int i11 = this.f14070a;
            if (iM8167j >= i11) {
                AbstractC4146i.m8171D(i11 + 1, i11, iM8167j, objArr, objArr);
            } else {
                AbstractC4146i.m8171D(1, 0, iM8167j, objArr, objArr);
                Object[] objArr2 = this.f14071b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i12 = this.f14070a;
                AbstractC4146i.m8171D(i12 + 1, i12, objArr2.length - 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.f14071b;
            int i13 = this.f14070a;
            objArr3[i13] = null;
            this.f14070a = m8164g(i13);
        } else {
            int iM8167j2 = m8167j(AbstractC4148k.m8191O(this) + this.f14070a);
            if (iM8167j <= iM8167j2) {
                Object[] objArr4 = this.f14071b;
                AbstractC4146i.m8171D(iM8167j, iM8167j + 1, iM8167j2 + 1, objArr4, objArr4);
            } else {
                Object[] objArr5 = this.f14071b;
                AbstractC4146i.m8171D(iM8167j, iM8167j + 1, objArr5.length, objArr5, objArr5);
                Object[] objArr6 = this.f14071b;
                objArr6[objArr6.length - 1] = objArr6[0];
                AbstractC4146i.m8171D(0, 1, iM8167j2 + 1, objArr6, objArr6);
            }
            this.f14071b[iM8167j2] = null;
        }
        this.f14072c--;
        return obj;
    }

    public final void m8162e(int i6, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f14071b.length;
        while (i6 < length && it.hasNext()) {
            this.f14071b[i6] = it.next();
            i6++;
        }
        int i10 = this.f14070a;
        for (int i11 = 0; i11 < i10 && it.hasNext(); i11++) {
            this.f14071b[i11] = it.next();
        }
        this.f14072c = collection.size() + mo8160c();
    }

    public final void m8163f(int i6) {
        if (i6 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f14071b;
        if (i6 <= objArr.length) {
            return;
        }
        if (objArr == f14069d) {
            if (i6 < 10) {
                i6 = 10;
            }
            this.f14071b = new Object[i6];
            return;
        }
        C4139b c4139b = AbstractC4142e.Companion;
        int length = objArr.length;
        c4139b.getClass();
        int i10 = length + (length >> 1);
        if (i10 - i6 < 0) {
            i10 = i6;
        }
        if (i10 - 2147483639 > 0) {
            i10 = i6 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i10];
        Object[] objArr3 = this.f14071b;
        AbstractC4146i.m8171D(0, this.f14070a, objArr3.length, objArr3, objArr2);
        Object[] objArr4 = this.f14071b;
        int length2 = objArr4.length;
        int i11 = this.f14070a;
        AbstractC4146i.m8171D(length2 - i11, 0, i11, objArr4, objArr2);
        this.f14070a = 0;
        this.f14071b = objArr2;
    }

    public final int m8164g(int i6) {
        Object[] objArr = this.f14071b;
        AbstractC2796i.m5785f(objArr, "<this>");
        if (i6 == objArr.length - 1) {
            return 0;
        }
        return i6 + 1;
    }

    @Override
    public final Object get(int i6) {
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14072c;
        c4139b.getClass();
        C4139b.m8157a(i6, i10);
        return this.f14071b[m8167j(this.f14070a + i6)];
    }

    public final int m8165h(int i6) {
        return i6 < 0 ? i6 + this.f14071b.length : i6;
    }

    public final void m8166i(int i6, int i10) {
        if (i6 < i10) {
            AbstractC4146i.m8176I(this.f14071b, i6, i10);
            return;
        }
        Object[] objArr = this.f14071b;
        AbstractC4146i.m8176I(objArr, i6, objArr.length);
        AbstractC4146i.m8176I(this.f14071b, 0, i10);
    }

    @Override
    public final int indexOf(Object obj) {
        int i6;
        int iM8167j = m8167j(mo8160c() + this.f14070a);
        int length = this.f14070a;
        if (length < iM8167j) {
            while (length < iM8167j) {
                if (AbstractC2796i.m5780a(obj, this.f14071b[length])) {
                    i6 = this.f14070a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iM8167j) {
            return -1;
        }
        int length2 = this.f14071b.length;
        while (length < length2) {
            if (AbstractC2796i.m5780a(obj, this.f14071b[length])) {
                i6 = this.f14070a;
            } else {
                length++;
            }
        }
        for (int i10 = 0; i10 < iM8167j; i10++) {
            if (AbstractC2796i.m5780a(obj, this.f14071b[i10])) {
                length = i10 + this.f14071b.length;
                i6 = this.f14070a;
            }
        }
        return -1;
        return length - i6;
    }

    @Override
    public final boolean isEmpty() {
        return mo8160c() == 0;
    }

    public final int m8167j(int i6) {
        Object[] objArr = this.f14071b;
        return i6 >= objArr.length ? i6 - objArr.length : i6;
    }

    public final void m8168k() {
        ((AbstractList) this).modCount++;
    }

    @Override
    public final int lastIndexOf(Object obj) {
        int length;
        int i6;
        int iM8167j = m8167j(this.f14072c + this.f14070a);
        int i10 = this.f14070a;
        if (i10 < iM8167j) {
            length = iM8167j - 1;
            if (i10 <= length) {
                while (!AbstractC2796i.m5780a(obj, this.f14071b[length])) {
                    if (length != i10) {
                        length--;
                    }
                }
                i6 = this.f14070a;
                return length - i6;
            }
            return -1;
        }
        if (i10 > iM8167j) {
            for (int i11 = iM8167j - 1; -1 < i11; i11--) {
                if (AbstractC2796i.m5780a(obj, this.f14071b[i11])) {
                    length = i11 + this.f14071b.length;
                    i6 = this.f14070a;
                    return length - i6;
                }
            }
            Object[] objArr = this.f14071b;
            AbstractC2796i.m5785f(objArr, "<this>");
            length = objArr.length - 1;
            int i12 = this.f14070a;
            if (i12 <= length) {
                while (!AbstractC2796i.m5780a(obj, this.f14071b[length])) {
                    if (length != i12) {
                        length--;
                    }
                }
                i6 = this.f14070a;
                return length - i6;
            }
        }
        return -1;
    }

    @Override
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        mo8161d(iIndexOf);
        return true;
    }

    @Override
    public final boolean removeAll(Collection collection) {
        int iM8167j;
        AbstractC2796i.m5785f(collection, "elements");
        boolean z7 = false;
        z7 = false;
        z7 = false;
        if (!isEmpty() && this.f14071b.length != 0) {
            int iM8167j2 = m8167j(this.f14072c + this.f14070a);
            int i6 = this.f14070a;
            if (i6 < iM8167j2) {
                iM8167j = i6;
                while (i6 < iM8167j2) {
                    Object obj = this.f14071b[i6];
                    if (collection.contains(obj)) {
                        z7 = true;
                    } else {
                        this.f14071b[iM8167j] = obj;
                        iM8167j++;
                    }
                    i6++;
                }
                AbstractC4146i.m8176I(this.f14071b, iM8167j, iM8167j2);
            } else {
                int length = this.f14071b.length;
                int i10 = i6;
                boolean z10 = false;
                while (i6 < length) {
                    Object[] objArr = this.f14071b;
                    Object obj2 = objArr[i6];
                    objArr[i6] = null;
                    if (collection.contains(obj2)) {
                        z10 = true;
                    } else {
                        this.f14071b[i10] = obj2;
                        i10++;
                    }
                    i6++;
                }
                iM8167j = m8167j(i10);
                for (int i11 = 0; i11 < iM8167j2; i11++) {
                    Object[] objArr2 = this.f14071b;
                    Object obj3 = objArr2[i11];
                    objArr2[i11] = null;
                    if (collection.contains(obj3)) {
                        z10 = true;
                    } else {
                        this.f14071b[iM8167j] = obj3;
                        iM8167j = m8164g(iM8167j);
                    }
                }
                z7 = z10;
            }
            if (z7) {
                m8168k();
                this.f14072c = m8165h(iM8167j - this.f14070a);
            }
        }
        return z7;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        m8168k();
        Object[] objArr = this.f14071b;
        int i6 = this.f14070a;
        Object obj = objArr[i6];
        objArr[i6] = null;
        this.f14070a = m8164g(i6);
        this.f14072c = mo8160c() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        m8168k();
        int iM8167j = m8167j(AbstractC4148k.m8191O(this) + this.f14070a);
        Object[] objArr = this.f14071b;
        Object obj = objArr[iM8167j];
        objArr[iM8167j] = null;
        this.f14072c = mo8160c() - 1;
        return obj;
    }

    @Override
    public final void removeRange(int i6, int i10) {
        C4139b c4139b = AbstractC4142e.Companion;
        int i11 = this.f14072c;
        c4139b.getClass();
        C4139b.m8159c(i6, i10, i11);
        int i12 = i10 - i6;
        if (i12 == 0) {
            return;
        }
        if (i12 == this.f14072c) {
            clear();
            return;
        }
        if (i12 == 1) {
            mo8161d(i6);
            return;
        }
        m8168k();
        if (i6 < this.f14072c - i10) {
            int iM8167j = m8167j((i6 - 1) + this.f14070a);
            int iM8167j2 = m8167j((i10 - 1) + this.f14070a);
            while (i6 > 0) {
                int i13 = iM8167j + 1;
                int iMin = Math.min(i6, Math.min(i13, iM8167j2 + 1));
                Object[] objArr = this.f14071b;
                int i14 = iM8167j2 - iMin;
                int i15 = iM8167j - iMin;
                AbstractC4146i.m8171D(i14 + 1, i15 + 1, i13, objArr, objArr);
                iM8167j = m8165h(i15);
                iM8167j2 = m8165h(i14);
                i6 -= iMin;
            }
            int iM8167j3 = m8167j(this.f14070a + i12);
            m8166i(this.f14070a, iM8167j3);
            this.f14070a = iM8167j3;
        } else {
            int iM8167j4 = m8167j(this.f14070a + i10);
            int iM8167j5 = m8167j(this.f14070a + i6);
            int i16 = this.f14072c;
            while (true) {
                i16 -= i10;
                if (i16 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f14071b;
                i10 = Math.min(i16, Math.min(objArr2.length - iM8167j4, objArr2.length - iM8167j5));
                Object[] objArr3 = this.f14071b;
                int i17 = iM8167j4 + i10;
                AbstractC4146i.m8171D(iM8167j5, iM8167j4, i17, objArr3, objArr3);
                iM8167j4 = m8167j(i17);
                iM8167j5 = m8167j(iM8167j5 + i10);
            }
            int iM8167j6 = m8167j(this.f14072c + this.f14070a);
            m8166i(m8165h(iM8167j6 - i12), iM8167j6);
        }
        this.f14072c -= i12;
    }

    @Override
    public final boolean retainAll(Collection collection) {
        int iM8167j;
        AbstractC2796i.m5785f(collection, "elements");
        boolean z7 = false;
        z7 = false;
        z7 = false;
        if (!isEmpty() && this.f14071b.length != 0) {
            int iM8167j2 = m8167j(this.f14072c + this.f14070a);
            int i6 = this.f14070a;
            if (i6 < iM8167j2) {
                iM8167j = i6;
                while (i6 < iM8167j2) {
                    Object obj = this.f14071b[i6];
                    if (collection.contains(obj)) {
                        this.f14071b[iM8167j] = obj;
                        iM8167j++;
                    } else {
                        z7 = true;
                    }
                    i6++;
                }
                AbstractC4146i.m8176I(this.f14071b, iM8167j, iM8167j2);
            } else {
                int length = this.f14071b.length;
                int i10 = i6;
                boolean z10 = false;
                while (i6 < length) {
                    Object[] objArr = this.f14071b;
                    Object obj2 = objArr[i6];
                    objArr[i6] = null;
                    if (collection.contains(obj2)) {
                        this.f14071b[i10] = obj2;
                        i10++;
                    } else {
                        z10 = true;
                    }
                    i6++;
                }
                iM8167j = m8167j(i10);
                for (int i11 = 0; i11 < iM8167j2; i11++) {
                    Object[] objArr2 = this.f14071b;
                    Object obj3 = objArr2[i11];
                    objArr2[i11] = null;
                    if (collection.contains(obj3)) {
                        this.f14071b[iM8167j] = obj3;
                        iM8167j = m8164g(iM8167j);
                    } else {
                        z10 = true;
                    }
                }
                z7 = z10;
            }
            if (z7) {
                m8168k();
                this.f14072c = m8165h(iM8167j - this.f14070a);
            }
        }
        return z7;
    }

    @Override
    public final Object set(int i6, Object obj) {
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14072c;
        c4139b.getClass();
        C4139b.m8157a(i6, i10);
        int iM8167j = m8167j(this.f14070a + i6);
        Object[] objArr = this.f14071b;
        Object obj2 = objArr[iM8167j];
        objArr[iM8167j] = obj;
        return obj2;
    }

    @Override
    public final Object[] toArray() {
        return toArray(new Object[mo8160c()]);
    }

    @Override
    public final void add(int i6, Object obj) {
        int length;
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14072c;
        c4139b.getClass();
        C4139b.m8158b(i6, i10);
        if (i6 == this.f14072c) {
            addLast(obj);
            return;
        }
        if (i6 == 0) {
            addFirst(obj);
            return;
        }
        m8168k();
        m8163f(this.f14072c + 1);
        int iM8167j = m8167j(this.f14070a + i6);
        int i11 = this.f14072c;
        if (i6 < ((i11 + 1) >> 1)) {
            if (iM8167j == 0) {
                Object[] objArr = this.f14071b;
                AbstractC2796i.m5785f(objArr, "<this>");
                iM8167j = objArr.length;
            }
            int i12 = iM8167j - 1;
            int i13 = this.f14070a;
            if (i13 == 0) {
                Object[] objArr2 = this.f14071b;
                AbstractC2796i.m5785f(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i13 - 1;
            }
            int i14 = this.f14070a;
            if (i12 >= i14) {
                Object[] objArr3 = this.f14071b;
                objArr3[length] = objArr3[i14];
                AbstractC4146i.m8171D(i14, i14 + 1, i12 + 1, objArr3, objArr3);
            } else {
                Object[] objArr4 = this.f14071b;
                AbstractC4146i.m8171D(i14 - 1, i14, objArr4.length, objArr4, objArr4);
                Object[] objArr5 = this.f14071b;
                objArr5[objArr5.length - 1] = objArr5[0];
                AbstractC4146i.m8171D(0, 1, i12 + 1, objArr5, objArr5);
            }
            this.f14071b[i12] = obj;
            this.f14070a = length;
        } else {
            int iM8167j2 = m8167j(i11 + this.f14070a);
            if (iM8167j < iM8167j2) {
                Object[] objArr6 = this.f14071b;
                AbstractC4146i.m8171D(iM8167j + 1, iM8167j, iM8167j2, objArr6, objArr6);
            } else {
                Object[] objArr7 = this.f14071b;
                AbstractC4146i.m8171D(1, 0, iM8167j2, objArr7, objArr7);
                Object[] objArr8 = this.f14071b;
                objArr8[0] = objArr8[objArr8.length - 1];
                AbstractC4146i.m8171D(iM8167j + 1, iM8167j, objArr8.length - 1, objArr8, objArr8);
            }
            this.f14071b[iM8167j] = obj;
        }
        this.f14072c++;
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        AbstractC2796i.m5785f(objArr, "array");
        int length = objArr.length;
        int i6 = this.f14072c;
        if (length < i6) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i6);
            AbstractC2796i.m5783d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) objNewInstance;
        }
        int iM8167j = m8167j(this.f14072c + this.f14070a);
        int i10 = this.f14070a;
        if (i10 < iM8167j) {
            AbstractC4146i.m8173F(i10, iM8167j, 2, this.f14071b, objArr);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f14071b;
            AbstractC4146i.m8171D(0, this.f14070a, objArr2.length, objArr2, objArr);
            Object[] objArr3 = this.f14071b;
            AbstractC4146i.m8171D(objArr3.length - this.f14070a, 0, iM8167j, objArr3, objArr);
        }
        int i11 = this.f14072c;
        if (i11 < objArr.length) {
            objArr[i11] = null;
        }
        return objArr;
    }

    @Override
    public final boolean addAll(int i6, Collection collection) {
        AbstractC2796i.m5785f(collection, "elements");
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14072c;
        c4139b.getClass();
        C4139b.m8158b(i6, i10);
        if (collection.isEmpty()) {
            return false;
        }
        if (i6 == this.f14072c) {
            return addAll(collection);
        }
        m8168k();
        m8163f(collection.size() + this.f14072c);
        int iM8167j = m8167j(this.f14072c + this.f14070a);
        int iM8167j2 = m8167j(this.f14070a + i6);
        int size = collection.size();
        if (i6 < ((this.f14072c + 1) >> 1)) {
            int i11 = this.f14070a;
            int length = i11 - size;
            if (iM8167j2 < i11) {
                Object[] objArr = this.f14071b;
                AbstractC4146i.m8171D(length, i11, objArr.length, objArr, objArr);
                if (size >= iM8167j2) {
                    Object[] objArr2 = this.f14071b;
                    AbstractC4146i.m8171D(objArr2.length - size, 0, iM8167j2, objArr2, objArr2);
                } else {
                    Object[] objArr3 = this.f14071b;
                    AbstractC4146i.m8171D(objArr3.length - size, 0, size, objArr3, objArr3);
                    Object[] objArr4 = this.f14071b;
                    AbstractC4146i.m8171D(0, size, iM8167j2, objArr4, objArr4);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f14071b;
                AbstractC4146i.m8171D(length, i11, iM8167j2, objArr5, objArr5);
            } else {
                Object[] objArr6 = this.f14071b;
                length += objArr6.length;
                int i12 = iM8167j2 - i11;
                int length2 = objArr6.length - length;
                if (length2 >= i12) {
                    AbstractC4146i.m8171D(length, i11, iM8167j2, objArr6, objArr6);
                } else {
                    AbstractC4146i.m8171D(length, i11, i11 + length2, objArr6, objArr6);
                    Object[] objArr7 = this.f14071b;
                    AbstractC4146i.m8171D(0, this.f14070a + length2, iM8167j2, objArr7, objArr7);
                }
            }
            this.f14070a = length;
            m8162e(m8165h(iM8167j2 - size), collection);
        } else {
            int i13 = iM8167j2 + size;
            if (iM8167j2 < iM8167j) {
                int i14 = size + iM8167j;
                Object[] objArr8 = this.f14071b;
                if (i14 <= objArr8.length) {
                    AbstractC4146i.m8171D(i13, iM8167j2, iM8167j, objArr8, objArr8);
                } else if (i13 >= objArr8.length) {
                    AbstractC4146i.m8171D(i13 - objArr8.length, iM8167j2, iM8167j, objArr8, objArr8);
                } else {
                    int length3 = iM8167j - (i14 - objArr8.length);
                    AbstractC4146i.m8171D(0, length3, iM8167j, objArr8, objArr8);
                    Object[] objArr9 = this.f14071b;
                    AbstractC4146i.m8171D(i13, iM8167j2, length3, objArr9, objArr9);
                }
            } else {
                Object[] objArr10 = this.f14071b;
                AbstractC4146i.m8171D(size, 0, iM8167j, objArr10, objArr10);
                Object[] objArr11 = this.f14071b;
                if (i13 >= objArr11.length) {
                    AbstractC4146i.m8171D(i13 - objArr11.length, iM8167j2, objArr11.length, objArr11, objArr11);
                } else {
                    AbstractC4146i.m8171D(0, objArr11.length - size, objArr11.length, objArr11, objArr11);
                    Object[] objArr12 = this.f14071b;
                    AbstractC4146i.m8171D(i13, iM8167j2, objArr12.length - size, objArr12, objArr12);
                }
            }
            m8162e(iM8167j2, collection);
        }
        return true;
    }
}

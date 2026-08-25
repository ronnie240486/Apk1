package p041d7;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import p020b7.AbstractC1332b;
import p187r4.AbstractC3612b;

public final class C2231k0 extends AbstractSet implements Serializable {

    public transient Object f7963a;

    public transient int[] f7964b;

    public transient Object[] f7965c;

    public transient int f7966d;

    public transient int f7967e;

    public transient int[] f7968f;

    public transient int[] f7969g;

    public transient int f7970h;

    public transient int f7971i;

    public static C2231k0 m5226d(int i6) {
        C2231k0 c2231k0 = new C2231k0();
        AbstractC1332b.m3214e("Expected size must be >= 0", i6 >= 0);
        c2231k0.f7966d = AbstractC3612b.m7267i(i6, 1);
        c2231k0.f7970h = -2;
        c2231k0.f7971i = -2;
        return c2231k0;
    }

    @Override
    public final boolean add(Object obj) {
        int iMin;
        if (m5229f()) {
            AbstractC1332b.m3223n("Arrays already allocated", m5229f());
            int i6 = this.f7966d;
            int iM5133E = AbstractC2182d0.m5133E(i6);
            this.f7963a = AbstractC2182d0.m5144g(iM5133E);
            this.f7966d = AbstractC2182d0.m5155r(this.f7966d, 32 - Integer.numberOfLeadingZeros(iM5133E - 1), 31);
            this.f7964b = new int[i6];
            this.f7965c = new Object[i6];
            this.f7968f = new int[i6];
            this.f7969g = new int[i6];
        }
        Set setM5228e = m5228e();
        if (setM5228e != null) {
            return setM5228e.add(obj);
        }
        int[] iArrM5231h = m5231h();
        Object[] objArrM5230g = m5230g();
        int i10 = this.f7967e;
        int i11 = i10 + 1;
        int iM5130B = AbstractC2182d0.m5130B(obj);
        int iM5232i = (1 << (this.f7966d & 31)) - 1;
        int i12 = iM5130B & iM5232i;
        Object obj2 = this.f7963a;
        Objects.requireNonNull(obj2);
        int iM5131C = AbstractC2182d0.m5131C(i12, obj2);
        if (iM5131C != 0) {
            int i13 = ~iM5232i;
            int i14 = iM5130B & i13;
            int i15 = 0;
            while (true) {
                int i16 = iM5131C - 1;
                int i17 = iArrM5231h[i16];
                if ((i17 & i13) == i14 && AbstractC1332b.m3225p(obj, objArrM5230g[i16])) {
                    return false;
                }
                int i18 = i17 & iM5232i;
                i15++;
                if (i18 == 0) {
                    if (i15 < 9) {
                        if (i11 <= iM5232i) {
                            iArrM5231h[i16] = AbstractC2182d0.m5155r(i17, i11, iM5232i);
                            break;
                        }
                        iM5232i = m5232i(iM5232i, AbstractC2182d0.m5158u(iM5232i), iM5130B, i10);
                        break;
                    }
                    LinkedHashSet linkedHashSet = new LinkedHashSet(1 << (this.f7966d & 31), 1.0f);
                    int i19 = this.f7970h;
                    while (i19 >= 0) {
                        linkedHashSet.add(m5230g()[i19]);
                        int[] iArr = this.f7969g;
                        Objects.requireNonNull(iArr);
                        i19 = iArr[i19] - 1;
                    }
                    this.f7963a = linkedHashSet;
                    this.f7964b = null;
                    this.f7965c = null;
                    this.f7966d += 32;
                    this.f7968f = null;
                    this.f7969g = null;
                    return linkedHashSet.add(obj);
                }
                iM5131C = i18;
            }
        } else if (i11 > iM5232i) {
            iM5232i = m5232i(iM5232i, AbstractC2182d0.m5158u(iM5232i), iM5130B, i10);
        } else {
            Object obj3 = this.f7963a;
            Objects.requireNonNull(obj3);
            AbstractC2182d0.m5132D(i12, i11, obj3);
        }
        int length = m5231h().length;
        if (i11 > length && (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.f7964b = Arrays.copyOf(m5231h(), iMin);
            this.f7965c = Arrays.copyOf(m5230g(), iMin);
            int[] iArr2 = this.f7968f;
            Objects.requireNonNull(iArr2);
            this.f7968f = Arrays.copyOf(iArr2, iMin);
            int[] iArr3 = this.f7969g;
            Objects.requireNonNull(iArr3);
            this.f7969g = Arrays.copyOf(iArr3, iMin);
        }
        m5231h()[i10] = AbstractC2182d0.m5155r(iM5130B, 0, iM5232i);
        m5230g()[i10] = obj;
        m5233j(this.f7971i, i10);
        m5233j(i10, -2);
        this.f7967e = i11;
        this.f7966d += 32;
        return true;
    }

    public final void m5227c() {
        if (m5229f()) {
            return;
        }
        this.f7966d += 32;
        Set setM5228e = m5228e();
        if (setM5228e != null) {
            this.f7966d = AbstractC3612b.m7267i(size(), 3);
            setM5228e.clear();
            this.f7963a = null;
            this.f7967e = 0;
            return;
        }
        Arrays.fill(m5230g(), 0, this.f7967e, (Object) null);
        Object obj = this.f7963a;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(m5231h(), 0, this.f7967e, 0);
        this.f7967e = 0;
    }

    @Override
    public final void clear() {
        if (m5229f()) {
            return;
        }
        this.f7970h = -2;
        this.f7971i = -2;
        int[] iArr = this.f7968f;
        if (iArr != null && this.f7969g != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.f7969g, 0, size(), 0);
        }
        m5227c();
    }

    @Override
    public final boolean contains(Object obj) {
        if (m5229f()) {
            return false;
        }
        Set setM5228e = m5228e();
        if (setM5228e != null) {
            return setM5228e.contains(obj);
        }
        int iM5130B = AbstractC2182d0.m5130B(obj);
        int i6 = (1 << (this.f7966d & 31)) - 1;
        Object obj2 = this.f7963a;
        Objects.requireNonNull(obj2);
        int iM5131C = AbstractC2182d0.m5131C(iM5130B & i6, obj2);
        if (iM5131C == 0) {
            return false;
        }
        int i10 = ~i6;
        int i11 = iM5130B & i10;
        do {
            int i12 = iM5131C - 1;
            int i13 = m5231h()[i12];
            if ((i13 & i10) == i11 && AbstractC1332b.m3225p(obj, m5230g()[i12])) {
                return true;
            }
            iM5131C = i13 & i6;
        } while (iM5131C != 0);
        return false;
    }

    public final Set m5228e() {
        Object obj = this.f7963a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    public final boolean m5229f() {
        return this.f7963a == null;
    }

    public final Object[] m5230g() {
        Object[] objArr = this.f7965c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final int[] m5231h() {
        int[] iArr = this.f7964b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final int m5232i(int i6, int i10, int i11, int i12) {
        Object objM5144g = AbstractC2182d0.m5144g(i10);
        int i13 = i10 - 1;
        if (i12 != 0) {
            AbstractC2182d0.m5132D(i11 & i13, i12 + 1, objM5144g);
        }
        Object obj = this.f7963a;
        Objects.requireNonNull(obj);
        int[] iArrM5231h = m5231h();
        for (int i14 = 0; i14 <= i6; i14++) {
            int iM5131C = AbstractC2182d0.m5131C(i14, obj);
            while (iM5131C != 0) {
                int i15 = iM5131C - 1;
                int i16 = iArrM5231h[i15];
                int i17 = ((~i6) & i16) | i14;
                int i18 = i17 & i13;
                int iM5131C2 = AbstractC2182d0.m5131C(i18, objM5144g);
                AbstractC2182d0.m5132D(i18, iM5131C, objM5144g);
                iArrM5231h[i15] = AbstractC2182d0.m5155r(i17, iM5131C2, i13);
                iM5131C = i16 & i6;
            }
        }
        this.f7963a = objM5144g;
        this.f7966d = AbstractC2182d0.m5155r(this.f7966d, 32 - Integer.numberOfLeadingZeros(i13), 31);
        return i13;
    }

    @Override
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public final Iterator iterator() {
        Set setM5228e = m5228e();
        return setM5228e != null ? setM5228e.iterator() : new C2224j0(this);
    }

    public final void m5233j(int i6, int i10) {
        if (i6 == -2) {
            this.f7970h = i10;
        } else {
            int[] iArr = this.f7969g;
            Objects.requireNonNull(iArr);
            iArr[i6] = i10 + 1;
        }
        if (i10 == -2) {
            this.f7971i = i6;
            return;
        }
        int[] iArr2 = this.f7968f;
        Objects.requireNonNull(iArr2);
        iArr2[i10] = i6 + 1;
    }

    @Override
    public final boolean remove(Object obj) {
        int i6;
        int i10;
        if (m5229f()) {
            return false;
        }
        Set setM5228e = m5228e();
        if (setM5228e != null) {
            return setM5228e.remove(obj);
        }
        int i11 = (1 << (this.f7966d & 31)) - 1;
        Object obj2 = this.f7963a;
        Objects.requireNonNull(obj2);
        int iM5160w = AbstractC2182d0.m5160w(obj, null, i11, obj2, m5231h(), m5230g(), null);
        if (iM5160w == -1) {
            return false;
        }
        int size = size() - 1;
        Object obj3 = this.f7963a;
        Objects.requireNonNull(obj3);
        int[] iArrM5231h = m5231h();
        Object[] objArrM5230g = m5230g();
        int size2 = size();
        int i12 = size2 - 1;
        if (iM5160w < i12) {
            Object obj4 = objArrM5230g[i12];
            objArrM5230g[iM5160w] = obj4;
            objArrM5230g[i12] = null;
            iArrM5231h[iM5160w] = iArrM5231h[i12];
            iArrM5231h[i12] = 0;
            int iM5130B = AbstractC2182d0.m5130B(obj4) & i11;
            int iM5131C = AbstractC2182d0.m5131C(iM5130B, obj3);
            if (iM5131C == size2) {
                AbstractC2182d0.m5132D(iM5130B, iM5160w + 1, obj3);
            } else {
                while (true) {
                    i6 = iM5131C - 1;
                    i10 = iArrM5231h[i6];
                    int i13 = i10 & i11;
                    if (i13 == size2) {
                        break;
                    }
                    iM5131C = i13;
                }
                iArrM5231h[i6] = AbstractC2182d0.m5155r(i10, iM5160w + 1, i11);
            }
        } else {
            objArrM5230g[iM5160w] = null;
            iArrM5231h[iM5160w] = 0;
        }
        int[] iArr = this.f7968f;
        Objects.requireNonNull(iArr);
        int i14 = iArr[iM5160w] - 1;
        int[] iArr2 = this.f7969g;
        Objects.requireNonNull(iArr2);
        m5233j(i14, iArr2[iM5160w] - 1);
        if (iM5160w < size) {
            int[] iArr3 = this.f7968f;
            Objects.requireNonNull(iArr3);
            m5233j(iArr3[size] - 1, iM5160w);
            int[] iArr4 = this.f7969g;
            Objects.requireNonNull(iArr4);
            m5233j(iM5160w, iArr4[size] - 1);
        }
        int[] iArr5 = this.f7968f;
        Objects.requireNonNull(iArr5);
        iArr5[size] = 0;
        int[] iArr6 = this.f7969g;
        Objects.requireNonNull(iArr6);
        iArr6[size] = 0;
        this.f7967e--;
        this.f7966d += 32;
        return true;
    }

    @Override
    public final int size() {
        Set setM5228e = m5228e();
        return setM5228e != null ? setM5228e.size() : this.f7967e;
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        int size = size();
        int i6 = 0;
        if (objArr.length < size) {
            if (objArr.length != 0) {
                objArr = Arrays.copyOf(objArr, 0);
            }
            objArr = Arrays.copyOf(objArr, size);
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            objArr[i6] = it.next();
            i6++;
        }
        if (objArr.length > size) {
            objArr[size] = null;
        }
        return objArr;
    }

    @Override
    public final Object[] toArray() {
        Object[] objArr = new Object[size()];
        Iterator<E> it = iterator();
        int i6 = 0;
        while (it.hasNext()) {
            objArr[i6] = it.next();
            i6++;
        }
        return objArr;
    }
}

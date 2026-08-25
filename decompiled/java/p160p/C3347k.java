package p160p;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;
import p171q.AbstractC3387a;
import p253x8.AbstractC4146i;

public class C3347k {

    public int[] f11332a;

    public Object[] f11333b;

    public int f11334c;

    public C3347k(int i6) {
        this.f11332a = i6 == 0 ? AbstractC3387a.f11422a : new int[i6];
        this.f11333b = i6 == 0 ? AbstractC3387a.f11423b : new Object[i6 << 1];
    }

    public final int m6807a(Object obj) {
        int i6 = this.f11334c * 2;
        Object[] objArr = this.f11333b;
        if (obj == null) {
            for (int i10 = 1; i10 < i6; i10 += 2) {
                if (objArr[i10] == null) {
                    return i10 >> 1;
                }
            }
            return -1;
        }
        for (int i11 = 1; i11 < i6; i11 += 2) {
            if (obj.equals(objArr[i11])) {
                return i11 >> 1;
            }
        }
        return -1;
    }

    public final void m6808b(int i6) {
        int i10 = this.f11334c;
        int[] iArr = this.f11332a;
        if (iArr.length < i6) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i6);
            AbstractC2796i.m5784e(iArrCopyOf, "copyOf(this, newSize)");
            this.f11332a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11333b, i6 * 2);
            AbstractC2796i.m5784e(objArrCopyOf, "copyOf(this, newSize)");
            this.f11333b = objArrCopyOf;
        }
        if (this.f11334c != i10) {
            throw new ConcurrentModificationException();
        }
    }

    public final int m6809c(int i6, Object obj) {
        int i10 = this.f11334c;
        if (i10 == 0) {
            return -1;
        }
        int iM6876a = AbstractC3387a.m6876a(i10, i6, this.f11332a);
        if (iM6876a < 0 || AbstractC2796i.m5780a(obj, this.f11333b[iM6876a << 1])) {
            return iM6876a;
        }
        int i11 = iM6876a + 1;
        while (i11 < i10 && this.f11332a[i11] == i6) {
            if (AbstractC2796i.m5780a(obj, this.f11333b[i11 << 1])) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iM6876a - 1; i12 >= 0 && this.f11332a[i12] == i6; i12--) {
            if (AbstractC2796i.m5780a(obj, this.f11333b[i12 << 1])) {
                return i12;
            }
        }
        return ~i11;
    }

    public void clear() {
        if (this.f11334c > 0) {
            this.f11332a = AbstractC3387a.f11422a;
            this.f11333b = AbstractC3387a.f11423b;
            this.f11334c = 0;
        }
        if (this.f11334c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m6810d(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m6807a(obj) >= 0;
    }

    public final int m6810d(Object obj) {
        return obj == null ? m6811e() : m6809c(obj.hashCode(), obj);
    }

    public final int m6811e() {
        int i6 = this.f11334c;
        if (i6 == 0) {
            return -1;
        }
        int iM6876a = AbstractC3387a.m6876a(i6, 0, this.f11332a);
        if (iM6876a < 0 || this.f11333b[iM6876a << 1] == null) {
            return iM6876a;
        }
        int i10 = iM6876a + 1;
        while (i10 < i6 && this.f11332a[i10] == 0) {
            if (this.f11333b[i10 << 1] == null) {
                return i10;
            }
            i10++;
        }
        for (int i11 = iM6876a - 1; i11 >= 0 && this.f11332a[i11] == 0; i11--) {
            if (this.f11333b[i11 << 1] == null) {
                return i11;
            }
        }
        return ~i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof C3347k) {
                int i6 = this.f11334c;
                if (i6 != ((C3347k) obj).f11334c) {
                    return false;
                }
                C3347k c3347k = (C3347k) obj;
                for (int i10 = 0; i10 < i6; i10++) {
                    Object objM6812f = m6812f(i10);
                    Object objM6816j = m6816j(i10);
                    Object obj2 = c3347k.get(objM6812f);
                    if (objM6816j == null) {
                        if (obj2 != null || !c3347k.containsKey(objM6812f)) {
                            return false;
                        }
                    } else if (!objM6816j.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f11334c != ((Map) obj).size()) {
                return false;
            }
            int i11 = this.f11334c;
            for (int i12 = 0; i12 < i11; i12++) {
                Object objM6812f2 = m6812f(i12);
                Object objM6816j2 = m6816j(i12);
                Object obj3 = ((Map) obj).get(objM6812f2);
                if (objM6816j2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objM6812f2)) {
                        return false;
                    }
                } else if (!objM6816j2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object m6812f(int i6) {
        if (i6 < 0 || i6 >= this.f11334c) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return this.f11333b[i6 << 1];
    }

    public void mo6813g(C3341e c3341e) {
        int i6 = c3341e.f11334c;
        m6808b(this.f11334c + i6);
        if (this.f11334c != 0) {
            for (int i10 = 0; i10 < i6; i10++) {
                put(c3341e.m6812f(i10), c3341e.m6816j(i10));
            }
        } else if (i6 > 0) {
            AbstractC4146i.m8170C(0, 0, i6, c3341e.f11332a, this.f11332a);
            AbstractC4146i.m8171D(0, 0, i6 << 1, c3341e.f11333b, this.f11333b);
            this.f11334c = i6;
        }
    }

    public Object get(Object obj) {
        int iM6810d = m6810d(obj);
        if (iM6810d >= 0) {
            return this.f11333b[(iM6810d << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iM6810d = m6810d(obj);
        return iM6810d >= 0 ? this.f11333b[(iM6810d << 1) + 1] : obj2;
    }

    public Object mo6814h(int i6) {
        int i10;
        if (i6 < 0 || i6 >= (i10 = this.f11334c)) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Expected index to be within 0..size()-1, but was ").toString());
        }
        Object[] objArr = this.f11333b;
        int i11 = i6 << 1;
        Object obj = objArr[i11 + 1];
        if (i10 <= 1) {
            clear();
        } else {
            int i12 = i10 - 1;
            int[] iArr = this.f11332a;
            if (iArr.length <= 8 || i10 >= iArr.length / 3) {
                if (i6 < i12) {
                    int i13 = i6 + 1;
                    AbstractC4146i.m8170C(i6, i13, i10, iArr, iArr);
                    Object[] objArr2 = this.f11333b;
                    AbstractC4146i.m8171D(i11, i13 << 1, i10 << 1, objArr2, objArr2);
                }
                Object[] objArr3 = this.f11333b;
                int i14 = i12 << 1;
                objArr3[i14] = null;
                objArr3[i14 + 1] = null;
            } else {
                int i15 = i10 > 8 ? i10 + (i10 >> 1) : 8;
                int[] iArrCopyOf = Arrays.copyOf(iArr, i15);
                AbstractC2796i.m5784e(iArrCopyOf, "copyOf(this, newSize)");
                this.f11332a = iArrCopyOf;
                Object[] objArrCopyOf = Arrays.copyOf(this.f11333b, i15 << 1);
                AbstractC2796i.m5784e(objArrCopyOf, "copyOf(this, newSize)");
                this.f11333b = objArrCopyOf;
                if (i10 != this.f11334c) {
                    throw new ConcurrentModificationException();
                }
                if (i6 > 0) {
                    AbstractC4146i.m8170C(0, 0, i6, iArr, this.f11332a);
                    AbstractC4146i.m8171D(0, 0, i11, objArr, this.f11333b);
                }
                if (i6 < i12) {
                    int i16 = i6 + 1;
                    AbstractC4146i.m8170C(i6, i16, i10, iArr, this.f11332a);
                    AbstractC4146i.m8171D(i11, i16 << 1, i10 << 1, objArr, this.f11333b);
                }
            }
            if (i10 != this.f11334c) {
                throw new ConcurrentModificationException();
            }
            this.f11334c = i12;
        }
        return obj;
    }

    public int hashCode() {
        int[] iArr = this.f11332a;
        Object[] objArr = this.f11333b;
        int i6 = this.f11334c;
        int i10 = 1;
        int i11 = 0;
        int iHashCode = 0;
        while (i11 < i6) {
            Object obj = objArr[i10];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i11];
            i11++;
            i10 += 2;
        }
        return iHashCode;
    }

    public Object mo6815i(int i6, Object obj) {
        if (i6 < 0 || i6 >= this.f11334c) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Expected index to be within 0..size()-1, but was ").toString());
        }
        int i10 = (i6 << 1) + 1;
        Object[] objArr = this.f11333b;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    public final boolean isEmpty() {
        return this.f11334c <= 0;
    }

    public final Object m6816j(int i6) {
        if (i6 < 0 || i6 >= this.f11334c) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return this.f11333b[(i6 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i6 = this.f11334c;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iM6809c = obj != null ? m6809c(iHashCode, obj) : m6811e();
        if (iM6809c >= 0) {
            int i10 = (iM6809c << 1) + 1;
            Object[] objArr = this.f11333b;
            Object obj3 = objArr[i10];
            objArr[i10] = obj2;
            return obj3;
        }
        int i11 = ~iM6809c;
        int[] iArr = this.f11332a;
        if (i6 >= iArr.length) {
            int i12 = 8;
            if (i6 >= 8) {
                i12 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i12 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i12);
            AbstractC2796i.m5784e(iArrCopyOf, "copyOf(this, newSize)");
            this.f11332a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11333b, i12 << 1);
            AbstractC2796i.m5784e(objArrCopyOf, "copyOf(this, newSize)");
            this.f11333b = objArrCopyOf;
            if (i6 != this.f11334c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i11 < i6) {
            int[] iArr2 = this.f11332a;
            int i13 = i11 + 1;
            AbstractC4146i.m8170C(i13, i11, i6, iArr2, iArr2);
            Object[] objArr2 = this.f11333b;
            AbstractC4146i.m8171D(i13 << 1, i11 << 1, this.f11334c << 1, objArr2, objArr2);
        }
        int i14 = this.f11334c;
        if (i6 == i14) {
            int[] iArr3 = this.f11332a;
            if (i11 < iArr3.length) {
                iArr3[i11] = iHashCode;
                Object[] objArr3 = this.f11333b;
                int i15 = i11 << 1;
                objArr3[i15] = obj;
                objArr3[i15 + 1] = obj2;
                this.f11334c = i14 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iM6810d = m6810d(obj);
        if (iM6810d >= 0) {
            return mo6814h(iM6810d);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iM6810d = m6810d(obj);
        if (iM6810d >= 0) {
            return mo6815i(iM6810d, obj2);
        }
        return null;
    }

    public final int size() {
        return this.f11334c;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f11334c * 28);
        sb.append('{');
        int i6 = this.f11334c;
        for (int i10 = 0; i10 < i6; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            Object objM6812f = m6812f(i10);
            if (objM6812f != sb) {
                sb.append(objM6812f);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objM6816j = m6816j(i10);
            if (objM6816j != sb) {
                sb.append(objM6816j);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC2796i.m5784e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iM6810d = m6810d(obj);
        if (iM6810d < 0 || !AbstractC2796i.m5780a(obj2, m6816j(iM6810d))) {
            return false;
        }
        mo6814h(iM6810d);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iM6810d = m6810d(obj);
        if (iM6810d < 0 || !AbstractC2796i.m5780a(obj2, m6816j(iM6810d))) {
            return false;
        }
        mo6815i(iM6810d, obj3);
        return true;
    }
}

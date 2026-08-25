package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import p000a.AbstractC0004e;

public abstract class AbstractC1732y1 extends AbstractC1687t1 implements Set {

    public static final int f5735c = 0;

    public transient AbstractC1714w1 f5736b;

    public static int m4056g(int i6) {
        int iMax = Math.max(i6, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static AbstractC1732y1 m4057h(Object[] objArr, int i6) {
        if (i6 == 0) {
            return C1564g2.f5313j;
        }
        if (i6 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new C1574h2(obj);
        }
        int iM4056g = m4056g(i6);
        Object[] objArr2 = new Object[iM4056g];
        int i10 = iM4056g - 1;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i6; i13++) {
            Object obj2 = objArr[i13];
            if (obj2 == null) {
                throw new NullPointerException(AbstractC0004e.m20n(i13, "at index "));
            }
            int iHashCode = obj2.hashCode();
            int iM3692b = AbstractC1503a1.m3692b(iHashCode);
            while (true) {
                int i14 = iM3692b & i10;
                Object obj3 = objArr2[i14];
                if (obj3 == null) {
                    objArr[i12] = obj2;
                    objArr2[i14] = obj2;
                    i11 += iHashCode;
                    i12++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iM3692b++;
            }
        }
        Arrays.fill(objArr, i12, i6, (Object) null);
        if (i12 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new C1574h2(obj4);
        }
        if (m4056g(i12) < iM4056g / 2) {
            return m4057h(objArr, i12);
        }
        int length = objArr.length;
        if (i12 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i12);
        }
        return new C1564g2(i11, i10, i12, objArr, objArr2);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof AbstractC1732y1) && (this instanceof C1564g2)) {
            AbstractC1732y1 abstractC1732y1 = (AbstractC1732y1) obj;
            abstractC1732y1.getClass();
            if ((abstractC1732y1 instanceof C1564g2) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }
}

package p041d7;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import p000a.AbstractC0004e;
import p020b7.AbstractC1332b;

public abstract class AbstractC2233k2 extends AbstractC2274q1 implements Set {

    public static final int f7972c = 0;

    public transient AbstractC2301u1 f7973b;

    public static int m5234j(int i6) {
        int iMax = Math.max(i6, 2);
        if (iMax >= 751619276) {
            AbstractC1332b.m3214e("collection too large", iMax < 1073741824);
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static AbstractC2233k2 m5235k(Object[] objArr, int i6) {
        if (i6 == 0) {
            return C2222i5.f7947j;
        }
        if (i6 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new C2247m2(obj);
        }
        int iM5234j = m5234j(i6);
        Object[] objArr2 = new Object[iM5234j];
        int i10 = iM5234j - 1;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i6; i13++) {
            Object obj2 = objArr[i13];
            if (obj2 == null) {
                throw new NullPointerException(AbstractC0004e.m20n(i13, "at index "));
            }
            int iHashCode = obj2.hashCode();
            int iM5129A = AbstractC2182d0.m5129A(iHashCode);
            while (true) {
                int i14 = iM5129A & i10;
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
                iM5129A++;
            }
        }
        Arrays.fill(objArr, i12, i6, (Object) null);
        if (i12 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new C2247m2(obj4);
        }
        if (m5234j(i12) < iM5234j / 2) {
            return m5235k(objArr, i12);
        }
        int length = objArr.length;
        if (i12 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i12);
        }
        return new C2222i5(i11, i10, i12, objArr, objArr2);
    }

    public static AbstractC2233k2 m5236l(Collection collection) {
        if ((collection instanceof AbstractC2233k2) && !(collection instanceof SortedSet)) {
            AbstractC2233k2 abstractC2233k2 = (AbstractC2233k2) collection;
            if (!abstractC2233k2.mo5127h()) {
                return abstractC2233k2;
            }
        }
        Object[] array = collection.toArray();
        return m5235k(array, array.length);
    }

    @Override
    public AbstractC2301u1 mo5167c() {
        AbstractC2301u1 abstractC2301u1 = this.f7973b;
        if (abstractC2301u1 != null) {
            return abstractC2301u1;
        }
        AbstractC2301u1 abstractC2301u1Mo5169m = mo5169m();
        this.f7973b = abstractC2301u1Mo5169m;
        return abstractC2301u1Mo5169m;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof AbstractC2233k2) && (this instanceof C2222i5)) {
            AbstractC2233k2 abstractC2233k2 = (AbstractC2233k2) obj;
            abstractC2233k2.getClass();
            if ((abstractC2233k2 instanceof C2222i5) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        return AbstractC2182d0.m5147j(this, obj);
    }

    @Override
    public int hashCode() {
        return AbstractC2182d0.m5153p(this);
    }

    public AbstractC2301u1 mo5169m() {
        Object[] array = toArray(AbstractC2274q1.f8028a);
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        return AbstractC2301u1.m5268j(array, array.length);
    }
}

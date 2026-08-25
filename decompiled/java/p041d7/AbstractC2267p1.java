package p041d7;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractC2267p1 {

    public Object[] f8020a;

    public int f8021b;

    public boolean f8022c;

    public AbstractC2267p1(int i6) {
        AbstractC2182d0.m5141d(i6, "initialCapacity");
        this.f8020a = new Object[i6];
        this.f8021b = 0;
    }

    public static int m5254f(int i6, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
        }
        if (i10 <= i6) {
            return i6;
        }
        int iHighestOneBit = i6 + (i6 >> 1) + 1;
        if (iHighestOneBit < i10) {
            iHighestOneBit = Integer.highestOneBit(i10 - 1) << 1;
        }
        if (iHighestOneBit < 0) {
            return Integer.MAX_VALUE;
        }
        return iHighestOneBit;
    }

    public final void m5255a(Object obj) {
        obj.getClass();
        m5258e(1);
        Object[] objArr = this.f8020a;
        int i6 = this.f8021b;
        this.f8021b = i6 + 1;
        objArr[i6] = obj;
    }

    public abstract AbstractC2267p1 mo5221b(Object obj);

    public void m5256c(Object obj) {
        m5255a(obj);
    }

    public final void m5257d(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            m5258e(collection.size());
            if (collection instanceof AbstractC2274q1) {
                this.f8021b = ((AbstractC2274q1) collection).mo5123d(this.f8020a, this.f8021b);
                return;
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            mo5221b(it.next());
        }
    }

    public final void m5258e(int i6) {
        Object[] objArr = this.f8020a;
        int iM5254f = m5254f(objArr.length, this.f8021b + i6);
        if (iM5254f > objArr.length || this.f8022c) {
            this.f8020a = Arrays.copyOf(this.f8020a, iM5254f);
            this.f8022c = false;
        }
    }
}

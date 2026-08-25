package com.google.android.gms.internal.cast;

import java.util.Iterator;

public final class C1564g2 extends AbstractC1732y1 {

    public static final Object[] f5312i;

    public static final C1564g2 f5313j;

    public final transient Object[] f5314d;

    public final transient int f5315e;

    public final transient Object[] f5316f;

    public final transient int f5317g;

    public final transient int f5318h;

    static {
        Object[] objArr = new Object[0];
        f5312i = objArr;
        f5313j = new C1564g2(0, 0, 0, objArr, objArr);
    }

    public C1564g2(int i6, int i10, int i11, Object[] objArr, Object[] objArr2) {
        this.f5314d = objArr;
        this.f5315e = i6;
        this.f5316f = objArr2;
        this.f5317g = i10;
        this.f5318h = i11;
    }

    @Override
    public final int mo3710c(Object[] objArr) {
        Object[] objArr2 = this.f5314d;
        int i6 = this.f5318h;
        System.arraycopy(objArr2, 0, objArr, 0, i6);
        return i6;
    }

    @Override
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f5316f;
            if (objArr.length != 0) {
                int iM3692b = AbstractC1503a1.m3692b(obj.hashCode());
                while (true) {
                    int i6 = iM3692b & this.f5317g;
                    Object obj2 = objArr[i6];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iM3692b = i6 + 1;
                }
            }
        }
        return false;
    }

    @Override
    public final int mo3711d() {
        return this.f5318h;
    }

    @Override
    public final int mo3712e() {
        return 0;
    }

    @Override
    public final Object[] mo3713f() {
        return this.f5314d;
    }

    @Override
    public final int hashCode() {
        return this.f5315e;
    }

    @Override
    public final Iterator iterator() {
        AbstractC1714w1 abstractC1714w1M4052h = this.f5736b;
        if (abstractC1714w1M4052h == null) {
            abstractC1714w1M4052h = AbstractC1714w1.m4052h(this.f5314d, this.f5318h);
            this.f5736b = abstractC1714w1M4052h;
        }
        return abstractC1714w1M4052h.listIterator(0);
    }

    @Override
    public final int size() {
        return this.f5318h;
    }
}

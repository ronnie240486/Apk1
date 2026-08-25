package com.google.android.gms.internal.cast;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
import p000a.AbstractC0004e;

public final class C1747z7 extends AbstractC1737y6 implements RandomAccess {

    public static final Object[] f5746d;

    public static final C1747z7 f5747e;

    public Object[] f5748b;

    public int f5749c;

    static {
        Object[] objArr = new Object[0];
        f5746d = objArr;
        f5747e = new C1747z7(objArr, 0, false);
    }

    public C1747z7(Object[] objArr, int i6, boolean z7) {
        super(z7);
        this.f5748b = objArr;
        this.f5749c = i6;
    }

    @Override
    public final InterfaceC1629m7 mo3876a(int i6) {
        if (i6 >= this.f5749c) {
            return new C1747z7(i6 == 0 ? f5746d : Arrays.copyOf(this.f5748b, i6), this.f5749c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public final void add(int i6, Object obj) {
        int i10;
        m4058c();
        if (i6 < 0 || i6 > (i10 = this.f5749c)) {
            throw new IndexOutOfBoundsException(AbstractC0004e.m19m(i6, this.f5749c, "Index:", ", Size:"));
        }
        int i11 = i6 + 1;
        Object[] objArr = this.f5748b;
        int length = objArr.length;
        if (i10 < length) {
            System.arraycopy(objArr, i6, objArr, i11, i10 - i6);
        } else {
            Object[] objArr2 = new Object[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f5748b, 0, objArr2, 0, i6);
            System.arraycopy(this.f5748b, i6, objArr2, i11, this.f5749c - i6);
            this.f5748b = objArr2;
        }
        this.f5748b[i6] = obj;
        this.f5749c++;
        ((AbstractList) this).modCount++;
    }

    public final void m4064e(int i6) {
        if (i6 < 0 || i6 >= this.f5749c) {
            throw new IndexOutOfBoundsException(AbstractC0004e.m19m(i6, this.f5749c, "Index:", ", Size:"));
        }
    }

    @Override
    public final Object get(int i6) {
        m4064e(i6);
        return this.f5748b[i6];
    }

    @Override
    public final Object remove(int i6) {
        m4058c();
        m4064e(i6);
        Object[] objArr = this.f5748b;
        Object obj = objArr[i6];
        int i10 = this.f5749c;
        if (i6 < i10 - 1) {
            System.arraycopy(objArr, i6 + 1, objArr, i6, (i10 - i6) - 1);
        }
        this.f5749c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override
    public final Object set(int i6, Object obj) {
        m4058c();
        m4064e(i6);
        Object[] objArr = this.f5748b;
        Object obj2 = objArr[i6];
        objArr[i6] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override
    public final int size() {
        return this.f5749c;
    }

    @Override
    public final boolean add(Object obj) {
        m4058c();
        int i6 = this.f5749c;
        int length = this.f5748b.length;
        if (i6 == length) {
            this.f5748b = Arrays.copyOf(this.f5748b, Math.max(((length * 3) / 2) + 1, 10));
        }
        Object[] objArr = this.f5748b;
        int i10 = this.f5749c;
        this.f5749c = i10 + 1;
        objArr[i10] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}

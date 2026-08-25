package com.google.android.gms.internal.cast;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import p000a.AbstractC0004e;

public final class C1666q7 extends AbstractC1737y6 implements RandomAccess, InterfaceC1619l7 {

    public static final long[] f5568d;

    public static final C1666q7 f5569e;

    public long[] f5570b;

    public int f5571c;

    static {
        long[] jArr = new long[0];
        f5568d = jArr;
        f5569e = new C1666q7(jArr, 0, false);
    }

    public C1666q7(long[] jArr, int i6, boolean z7) {
        super(z7);
        this.f5570b = jArr;
        this.f5571c = i6;
    }

    @Override
    public final InterfaceC1629m7 mo3876a(int i6) {
        if (i6 >= this.f5571c) {
            return new C1666q7(i6 == 0 ? f5568d : Arrays.copyOf(this.f5570b, i6), this.f5571c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public final void add(int i6, Object obj) {
        int i10;
        long jLongValue = ((Long) obj).longValue();
        m4058c();
        if (i6 < 0 || i6 > (i10 = this.f5571c)) {
            throw new IndexOutOfBoundsException(AbstractC0004e.m19m(i6, this.f5571c, "Index:", ", Size:"));
        }
        int i11 = i6 + 1;
        long[] jArr = this.f5570b;
        int length = jArr.length;
        if (i10 < length) {
            System.arraycopy(jArr, i6, jArr, i11, i10 - i6);
        } else {
            long[] jArr2 = new long[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f5570b, 0, jArr2, 0, i6);
            System.arraycopy(this.f5570b, i6, jArr2, i11, this.f5571c - i6);
            this.f5570b = jArr2;
        }
        this.f5570b[i6] = jLongValue;
        this.f5571c++;
        ((AbstractList) this).modCount++;
    }

    @Override
    public final boolean addAll(Collection collection) {
        m4058c();
        Charset charset = AbstractC1639n7.f5472a;
        collection.getClass();
        if (!(collection instanceof C1666q7)) {
            return super.addAll(collection);
        }
        C1666q7 c1666q7 = (C1666q7) collection;
        int i6 = c1666q7.f5571c;
        if (i6 == 0) {
            return false;
        }
        int i10 = this.f5571c;
        if (Integer.MAX_VALUE - i10 < i6) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i6;
        long[] jArr = this.f5570b;
        if (i11 > jArr.length) {
            this.f5570b = Arrays.copyOf(jArr, i11);
        }
        System.arraycopy(c1666q7.f5570b, 0, this.f5570b, this.f5571c, c1666q7.f5571c);
        this.f5571c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final long m3986e(int i6) {
        m3987f(i6);
        return this.f5570b[i6];
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1666q7)) {
            return super.equals(obj);
        }
        C1666q7 c1666q7 = (C1666q7) obj;
        if (this.f5571c != c1666q7.f5571c) {
            return false;
        }
        long[] jArr = c1666q7.f5570b;
        for (int i6 = 0; i6 < this.f5571c; i6++) {
            if (this.f5570b[i6] != jArr[i6]) {
                return false;
            }
        }
        return true;
    }

    public final void m3987f(int i6) {
        if (i6 < 0 || i6 >= this.f5571c) {
            throw new IndexOutOfBoundsException(AbstractC0004e.m19m(i6, this.f5571c, "Index:", ", Size:"));
        }
    }

    @Override
    public final Object get(int i6) {
        m3987f(i6);
        return Long.valueOf(this.f5570b[i6]);
    }

    @Override
    public final int hashCode() {
        int i6 = 1;
        for (int i10 = 0; i10 < this.f5571c; i10++) {
            long j10 = this.f5570b[i10];
            Charset charset = AbstractC1639n7.f5472a;
            i6 = (i6 * 31) + ((int) (j10 ^ (j10 >>> 32)));
        }
        return i6;
    }

    @Override
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i6 = this.f5571c;
        for (int i10 = 0; i10 < i6; i10++) {
            if (this.f5570b[i10] == jLongValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override
    public final Object remove(int i6) {
        m4058c();
        m3987f(i6);
        long[] jArr = this.f5570b;
        long j10 = jArr[i6];
        int i10 = this.f5571c;
        if (i6 < i10 - 1) {
            System.arraycopy(jArr, i6 + 1, jArr, i6, (i10 - i6) - 1);
        }
        this.f5571c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }

    @Override
    public final void removeRange(int i6, int i10) {
        m4058c();
        if (i10 < i6) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f5570b;
        System.arraycopy(jArr, i10, jArr, i6, this.f5571c - i10);
        this.f5571c -= i10 - i6;
        ((AbstractList) this).modCount++;
    }

    @Override
    public final Object set(int i6, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        m4058c();
        m3987f(i6);
        long[] jArr = this.f5570b;
        long j10 = jArr[i6];
        jArr[i6] = jLongValue;
        return Long.valueOf(j10);
    }

    @Override
    public final int size() {
        return this.f5571c;
    }

    @Override
    public final boolean add(Object obj) {
        long jLongValue = ((Long) obj).longValue();
        m4058c();
        int i6 = this.f5571c;
        int length = this.f5570b.length;
        if (i6 == length) {
            long[] jArr = new long[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f5570b, 0, jArr, 0, this.f5571c);
            this.f5570b = jArr;
        }
        long[] jArr2 = this.f5570b;
        int i10 = this.f5571c;
        this.f5571c = i10 + 1;
        jArr2[i10] = jLongValue;
        return true;
    }
}

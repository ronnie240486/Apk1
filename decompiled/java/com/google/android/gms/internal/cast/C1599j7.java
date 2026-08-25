package com.google.android.gms.internal.cast;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
import p000a.AbstractC0004e;

public final class C1599j7 extends AbstractC1737y6 implements RandomAccess, InterfaceC1609k7 {

    public static final int[] f5368d;

    public static final C1599j7 f5369e;

    public int[] f5370b;

    public int f5371c;

    static {
        int[] iArr = new int[0];
        f5368d = iArr;
        f5369e = new C1599j7(0, false, iArr);
    }

    public C1599j7(int i6, boolean z7, int[] iArr) {
        super(z7);
        this.f5370b = iArr;
        this.f5371c = i6;
    }

    @Override
    public final void add(int i6, Object obj) {
        int i10;
        int iIntValue = ((Integer) obj).intValue();
        m4058c();
        if (i6 < 0 || i6 > (i10 = this.f5371c)) {
            throw new IndexOutOfBoundsException(AbstractC0004e.m19m(i6, this.f5371c, "Index:", ", Size:"));
        }
        int i11 = i6 + 1;
        int[] iArr = this.f5370b;
        int length = iArr.length;
        if (i10 < length) {
            System.arraycopy(iArr, i6, iArr, i11, i10 - i6);
        } else {
            int[] iArr2 = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f5370b, 0, iArr2, 0, i6);
            System.arraycopy(this.f5370b, i6, iArr2, i11, this.f5371c - i6);
            this.f5370b = iArr2;
        }
        this.f5370b[i6] = iIntValue;
        this.f5371c++;
        ((AbstractList) this).modCount++;
    }

    @Override
    public final boolean addAll(Collection collection) {
        m4058c();
        Charset charset = AbstractC1639n7.f5472a;
        collection.getClass();
        if (!(collection instanceof C1599j7)) {
            return super.addAll(collection);
        }
        C1599j7 c1599j7 = (C1599j7) collection;
        int i6 = c1599j7.f5371c;
        if (i6 == 0) {
            return false;
        }
        int i10 = this.f5371c;
        if (Integer.MAX_VALUE - i10 < i6) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i6;
        int[] iArr = this.f5370b;
        if (i11 > iArr.length) {
            this.f5370b = Arrays.copyOf(iArr, i11);
        }
        System.arraycopy(c1599j7.f5370b, 0, this.f5370b, this.f5371c, c1599j7.f5371c);
        this.f5371c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int m3877e(int i6) {
        m3880h(i6);
        return this.f5370b[i6];
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1599j7)) {
            return super.equals(obj);
        }
        C1599j7 c1599j7 = (C1599j7) obj;
        if (this.f5371c != c1599j7.f5371c) {
            return false;
        }
        int[] iArr = c1599j7.f5370b;
        for (int i6 = 0; i6 < this.f5371c; i6++) {
            if (this.f5370b[i6] != iArr[i6]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final C1599j7 mo3876a(int i6) {
        if (i6 >= this.f5371c) {
            return new C1599j7(this.f5371c, true, i6 == 0 ? f5368d : Arrays.copyOf(this.f5370b, i6));
        }
        throw new IllegalArgumentException();
    }

    public final void m3879g(int i6) {
        m4058c();
        int i10 = this.f5371c;
        int length = this.f5370b.length;
        if (i10 == length) {
            int[] iArr = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f5370b, 0, iArr, 0, this.f5371c);
            this.f5370b = iArr;
        }
        int[] iArr2 = this.f5370b;
        int i11 = this.f5371c;
        this.f5371c = i11 + 1;
        iArr2[i11] = i6;
    }

    @Override
    public final Object get(int i6) {
        m3880h(i6);
        return Integer.valueOf(this.f5370b[i6]);
    }

    public final void m3880h(int i6) {
        if (i6 < 0 || i6 >= this.f5371c) {
            throw new IndexOutOfBoundsException(AbstractC0004e.m19m(i6, this.f5371c, "Index:", ", Size:"));
        }
    }

    @Override
    public final int hashCode() {
        int i6 = 1;
        for (int i10 = 0; i10 < this.f5371c; i10++) {
            i6 = (i6 * 31) + this.f5370b[i10];
        }
        return i6;
    }

    @Override
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i6 = this.f5371c;
        for (int i10 = 0; i10 < i6; i10++) {
            if (this.f5370b[i10] == iIntValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override
    public final Object remove(int i6) {
        m4058c();
        m3880h(i6);
        int[] iArr = this.f5370b;
        int i10 = iArr[i6];
        int i11 = this.f5371c;
        if (i6 < i11 - 1) {
            System.arraycopy(iArr, i6 + 1, iArr, i6, (i11 - i6) - 1);
        }
        this.f5371c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i10);
    }

    @Override
    public final void removeRange(int i6, int i10) {
        m4058c();
        if (i10 < i6) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f5370b;
        System.arraycopy(iArr, i10, iArr, i6, this.f5371c - i10);
        this.f5371c -= i10 - i6;
        ((AbstractList) this).modCount++;
    }

    @Override
    public final Object set(int i6, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        m4058c();
        m3880h(i6);
        int[] iArr = this.f5370b;
        int i10 = iArr[i6];
        iArr[i6] = iIntValue;
        return Integer.valueOf(i10);
    }

    @Override
    public final int size() {
        return this.f5371c;
    }

    @Override
    public final boolean add(Object obj) {
        m3879g(((Integer) obj).intValue());
        return true;
    }
}

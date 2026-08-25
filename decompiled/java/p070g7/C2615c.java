package p070g7;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import p020b7.AbstractC1332b;
import p187r4.AbstractC3612b;

public final class C2615c extends AbstractList implements RandomAccess, Serializable {

    public final int[] f9096a;

    public final int f9097b;

    public final int f9098c;

    public C2615c(int i6, int i10, int[] iArr) {
        this.f9096a = iArr;
        this.f9097b = i6;
        this.f9098c = i10;
    }

    @Override
    public final boolean contains(Object obj) {
        if (obj instanceof Integer) {
            if (AbstractC3612b.m7251A(this.f9096a, ((Integer) obj).intValue(), this.f9097b, this.f9098c) != -1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2615c)) {
            return super.equals(obj);
        }
        C2615c c2615c = (C2615c) obj;
        int size = size();
        if (c2615c.size() != size) {
            return false;
        }
        for (int i6 = 0; i6 < size; i6++) {
            if (this.f9096a[this.f9097b + i6] != c2615c.f9096a[c2615c.f9097b + i6]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int i6) {
        AbstractC1332b.m3217h(i6, size());
        return Integer.valueOf(this.f9096a[this.f9097b + i6]);
    }

    @Override
    public final int hashCode() {
        int i6 = 1;
        for (int i10 = this.f9097b; i10 < this.f9098c; i10++) {
            i6 = (i6 * 31) + this.f9096a[i10];
        }
        return i6;
    }

    @Override
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int[] iArr = this.f9096a;
        int i6 = this.f9097b;
        int iM7251A = AbstractC3612b.m7251A(iArr, iIntValue, i6, this.f9098c);
        if (iM7251A >= 0) {
            return iM7251A - i6;
        }
        return -1;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final int lastIndexOf(Object obj) {
        int i6;
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            int i10 = this.f9098c;
            do {
                i10--;
                i6 = this.f9097b;
                if (i10 < i6) {
                    i10 = -1;
                    break;
                }
            } while (this.f9096a[i10] != iIntValue);
            if (i10 >= 0) {
                return i10 - i6;
            }
        }
        return -1;
    }

    @Override
    public final Object set(int i6, Object obj) {
        Integer num = (Integer) obj;
        AbstractC1332b.m3217h(i6, size());
        int i10 = this.f9097b + i6;
        int[] iArr = this.f9096a;
        int i11 = iArr[i10];
        num.getClass();
        iArr[i10] = num.intValue();
        return Integer.valueOf(i11);
    }

    @Override
    public final int size() {
        return this.f9098c - this.f9097b;
    }

    @Override
    public final List subList(int i6, int i10) {
        AbstractC1332b.m3221l(i6, i10, size());
        if (i6 == i10) {
            return Collections.emptyList();
        }
        int i11 = this.f9097b;
        return new C2615c(i6 + i11, i11 + i10, this.f9096a);
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 5);
        sb.append('[');
        int[] iArr = this.f9096a;
        int i6 = this.f9097b;
        sb.append(iArr[i6]);
        while (true) {
            i6++;
            if (i6 >= this.f9098c) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(iArr[i6]);
        }
    }
}

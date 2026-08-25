package p171q;

import p103j9.AbstractC2796i;

public abstract class AbstractC3387a {

    public static final int[] f11422a = new int[0];

    public static final Object[] f11423b = new Object[0];

    public static final int m6876a(int i6, int i10, int[] iArr) {
        AbstractC2796i.m5785f(iArr, "array");
        int i11 = i6 - 1;
        int i12 = 0;
        while (i12 <= i11) {
            int i13 = (i12 + i11) >>> 1;
            int i14 = iArr[i13];
            if (i14 < i10) {
                i12 = i13 + 1;
            } else {
                if (i14 <= i10) {
                    return i13;
                }
                i11 = i13 - 1;
            }
        }
        return ~i12;
    }

    public static final int m6877b(long[] jArr, int i6, long j10) {
        AbstractC2796i.m5785f(jArr, "array");
        int i10 = i6 - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            long j11 = jArr[i12];
            if (j11 < j10) {
                i11 = i12 + 1;
            } else {
                if (j11 <= j10) {
                    return i12;
                }
                i10 = i12 - 1;
            }
        }
        return ~i11;
    }
}

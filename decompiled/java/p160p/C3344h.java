package p160p;

import p253x8.AbstractC4146i;

public final class C3344h {

    public int[] f11322a;

    public int f11323b;

    public int f11324c;

    public int f11325d;

    public C3344h() {
        int iHighestOneBit = Integer.bitCount(8) != 1 ? Integer.highestOneBit(7) << 1 : 8;
        this.f11325d = iHighestOneBit - 1;
        this.f11322a = new int[iHighestOneBit];
    }

    public final void m6791a(int i6) {
        int[] iArr = this.f11322a;
        int i10 = this.f11324c;
        iArr[i10] = i6;
        int i11 = this.f11325d & (i10 + 1);
        this.f11324c = i11;
        int i12 = this.f11323b;
        if (i11 == i12) {
            int length = iArr.length;
            int i13 = length - i12;
            int i14 = length << 1;
            if (i14 < 0) {
                throw new RuntimeException("Max array capacity exceeded");
            }
            int[] iArr2 = new int[i14];
            AbstractC4146i.m8170C(0, i12, length, iArr, iArr2);
            AbstractC4146i.m8170C(i13, 0, this.f11323b, this.f11322a, iArr2);
            this.f11322a = iArr2;
            this.f11323b = 0;
            this.f11324c = length;
            this.f11325d = i14 - 1;
        }
    }

    public final int m6792b(int i6) {
        if (i6 < 0 || i6 >= m6793c()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f11322a[this.f11325d & (this.f11323b + i6)];
    }

    public final int m6793c() {
        return (this.f11324c - this.f11323b) & this.f11325d;
    }
}

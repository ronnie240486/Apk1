package p160p;

import p102j8.InterfaceC2787b;
import p253x8.AbstractC4146i;

public final class C3343g {

    public int f11318a;

    public int f11319b;

    public int f11320c;

    public Object[] f11321d;

    public void m6785a(InterfaceC2787b interfaceC2787b) {
        Object obj;
        Object obj2;
        Object[] objArr = this.f11321d;
        int i6 = this.f11318a;
        int iHashCode = interfaceC2787b.hashCode() * (-1640531527);
        int i10 = (iHashCode ^ (iHashCode >>> 16)) & i6;
        Object obj3 = objArr[i10];
        if (obj3 != null) {
            if (obj3.equals(interfaceC2787b)) {
                return;
            }
            do {
                i10 = (i10 + 1) & i6;
                obj2 = objArr[i10];
                if (obj2 == null) {
                }
            } while (!obj2.equals(interfaceC2787b));
            return;
        }
        objArr[i10] = interfaceC2787b;
        int i11 = this.f11319b + 1;
        this.f11319b = i11;
        if (i11 < this.f11320c) {
            return;
        }
        Object[] objArr2 = this.f11321d;
        int length = objArr2.length;
        int i12 = length << 1;
        int i13 = i12 - 1;
        Object[] objArr3 = new Object[i12];
        while (true) {
            int i14 = i11 - 1;
            if (i11 == 0) {
                this.f11318a = i13;
                this.f11320c = (int) (i12 * 0.75f);
                this.f11321d = objArr3;
                return;
            }
            do {
                length--;
                obj = objArr2[length];
            } while (obj == null);
            int iHashCode2 = obj.hashCode() * (-1640531527);
            int i15 = (iHashCode2 ^ (iHashCode2 >>> 16)) & i13;
            if (objArr3[i15] != null) {
                do {
                    i15 = (i15 + 1) & i13;
                } while (objArr3[i15] != null);
            }
            objArr3[i15] = objArr2[length];
            i11 = i14;
        }
    }

    public void m6786b() {
        Object[] objArr = this.f11321d;
        int length = objArr.length;
        int i6 = this.f11318a;
        int i10 = length - i6;
        int i11 = length << 1;
        if (i11 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        Object[] objArr2 = new Object[i11];
        AbstractC4146i.m8171D(0, i6, length, objArr, objArr2);
        AbstractC4146i.m8171D(i10, 0, this.f11318a, this.f11321d, objArr2);
        this.f11321d = objArr2;
        this.f11318a = 0;
        this.f11319b = length;
        this.f11320c = i11 - 1;
    }

    public void m6787c(Object[] objArr, int i6, int i10) {
        int i11;
        Object obj;
        this.f11319b--;
        while (true) {
            int i12 = i6 + 1;
            while (true) {
                i11 = i12 & i10;
                obj = objArr[i11];
                if (obj != null) {
                    int iHashCode = obj.hashCode() * (-1640531527);
                    int i13 = (iHashCode ^ (iHashCode >>> 16)) & i10;
                    if (i6 > i11) {
                        if (i6 >= i13 && i13 > i11) {
                            break;
                        } else {
                            i12 = i11 + 1;
                        }
                    } else if (i6 >= i13 || i13 > i11) {
                        break;
                    } else {
                        i12 = i11 + 1;
                    }
                } else {
                    objArr[i6] = null;
                    return;
                }
            }
            objArr[i6] = obj;
            i6 = i11;
        }
    }

    public void m6788d(int i6) {
        if (i6 <= 0) {
            return;
        }
        if (i6 > m6790f()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i10 = this.f11319b;
        int i11 = i6 < i10 ? i10 - i6 : 0;
        for (int i12 = i11; i12 < i10; i12++) {
            this.f11321d[i12] = null;
        }
        int i13 = this.f11319b;
        int i14 = i13 - i11;
        int i15 = i6 - i14;
        this.f11319b = i13 - i14;
        if (i15 > 0) {
            int length = this.f11321d.length;
            this.f11319b = length;
            int i16 = length - i15;
            for (int i17 = i16; i17 < length; i17++) {
                this.f11321d[i17] = null;
            }
            this.f11319b = i16;
        }
    }

    public void m6789e(int i6) {
        if (i6 <= 0) {
            return;
        }
        if (i6 > m6790f()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.f11321d.length;
        int i10 = this.f11318a;
        if (i6 < length - i10) {
            length = i10 + i6;
        }
        while (i10 < length) {
            this.f11321d[i10] = null;
            i10++;
        }
        int i11 = this.f11318a;
        int i12 = length - i11;
        int i13 = i6 - i12;
        this.f11318a = this.f11320c & (i11 + i12);
        if (i13 > 0) {
            for (int i14 = 0; i14 < i13; i14++) {
                this.f11321d[i14] = null;
            }
            this.f11318a = i13;
        }
    }

    public int m6790f() {
        return (this.f11319b - this.f11318a) & this.f11320c;
    }
}

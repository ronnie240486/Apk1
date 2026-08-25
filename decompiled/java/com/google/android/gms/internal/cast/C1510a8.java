package com.google.android.gms.internal.cast;

public final class C1510a8 {

    public final AbstractC1728x6 f5209a;

    public final String f5210b;

    public final Object[] f5211c;

    public final int f5212d;

    public C1510a8(AbstractC1728x6 abstractC1728x6, String str, Object[] objArr) {
        this.f5209a = abstractC1728x6;
        this.f5210b = str;
        this.f5211c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f5212d = cCharAt;
            return;
        }
        int i6 = cCharAt & 8191;
        int i10 = 13;
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < 55296) {
                this.f5212d = i6 | (cCharAt2 << i10);
                return;
            } else {
                i6 |= (cCharAt2 & 8191) << i10;
                i10 += 13;
                i11 = i12;
            }
        }
    }

    public final AbstractC1728x6 m3726a() {
        return this.f5209a;
    }

    public final int m3727b() {
        int i6 = this.f5212d;
        if ((i6 & 1) != 0) {
            return 1;
        }
        return (i6 & 4) == 4 ? 3 : 2;
    }

    public final String m3728c() {
        return this.f5210b;
    }

    public final Object[] m3729d() {
        return this.f5211c;
    }
}

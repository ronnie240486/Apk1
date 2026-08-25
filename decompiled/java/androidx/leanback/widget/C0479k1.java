package androidx.leanback.widget;

public final class C0479k1 {

    public int f2356c;

    public int f2357d;

    public int f2362i;

    public int f2363j;

    public int f2364k;

    public boolean f2365l;

    public int f2358e = 2;

    public int f2359f = 3;

    public int f2360g = 0;

    public float f2361h = 50.0f;

    public int f2355b = Integer.MIN_VALUE;

    public int f2354a = Integer.MAX_VALUE;

    public final int m1442a() {
        if (this.f2365l) {
            int i6 = this.f2360g;
            int i10 = i6 >= 0 ? this.f2362i - i6 : -i6;
            float f = this.f2361h;
            return f != -1.0f ? i10 - ((int) ((this.f2362i * f) / 100.0f)) : i10;
        }
        int i11 = this.f2360g;
        if (i11 < 0) {
            i11 += this.f2362i;
        }
        float f3 = this.f2361h;
        return f3 != -1.0f ? i11 + ((int) ((this.f2362i * f3) / 100.0f)) : i11;
    }

    public final int m1443b(int i6) {
        int i10;
        int i11;
        int i12 = this.f2362i;
        int iM1442a = m1442a();
        int i13 = this.f2355b;
        boolean z7 = i13 == Integer.MIN_VALUE;
        int i14 = this.f2354a;
        boolean z10 = i14 == Integer.MAX_VALUE;
        if (!z7) {
            int i15 = this.f2363j;
            int i16 = iM1442a - i15;
            if (this.f2365l ? (this.f2359f & 2) != 0 : (this.f2359f & 1) != 0) {
                if (i6 - i13 <= i16) {
                    int i17 = i13 - i15;
                    return (z10 || i17 <= (i11 = this.f2356c)) ? i17 : i11;
                }
            }
        }
        if (!z10) {
            int i18 = this.f2364k;
            int i19 = (i12 - iM1442a) - i18;
            if (this.f2365l ? (1 & this.f2359f) != 0 : (this.f2359f & 2) != 0) {
                if (i14 - i6 <= i19) {
                    int i20 = i14 - (i12 - i18);
                    return (z7 || i20 >= (i10 = this.f2357d)) ? i20 : i10;
                }
            }
        }
        return i6 - iM1442a;
    }

    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1444c(int i6, int i10, int i11, int i12) {
        this.f2355b = i6;
        this.f2354a = i10;
        int i13 = (this.f2362i - this.f2363j) - this.f2364k;
        int iM1442a = m1442a();
        int i14 = this.f2355b;
        boolean z7 = i14 == Integer.MIN_VALUE;
        int i15 = this.f2354a;
        boolean z10 = i15 == Integer.MAX_VALUE;
        if (!z7) {
            if (this.f2365l) {
                this.f2357d = i11 - iM1442a;
            } else {
                this.f2357d = i11 - iM1442a;
            }
        }
        if (!z10) {
            if (this.f2365l) {
                this.f2356c = i12 - iM1442a;
            } else {
                this.f2356c = i12 - iM1442a;
            }
        }
        if (z10 || z7) {
            return;
        }
        if (this.f2365l) {
            int i16 = this.f2359f;
            if ((i16 & 1) != 0) {
                if ((this.f2358e & 1) != 0) {
                    this.f2356c = Math.max(this.f2356c, i11 - iM1442a);
                }
                this.f2357d = Math.min(this.f2357d, this.f2356c);
                return;
            } else {
                if ((i16 & 2) != 0) {
                    if ((this.f2358e & 2) != 0) {
                        this.f2357d = Math.min(this.f2357d, i12 - iM1442a);
                    }
                    this.f2356c = Math.max(this.f2357d, this.f2356c);
                    return;
                }
                return;
            }
        }
        int i17 = this.f2359f;
        if ((i17 & 1) != 0) {
            if ((this.f2358e & 1) != 0) {
                this.f2357d = Math.min(this.f2357d, i12 - iM1442a);
            }
            this.f2356c = Math.max(this.f2357d, this.f2356c);
        } else if ((i17 & 2) != 0) {
            if ((this.f2358e & 2) != 0) {
                this.f2356c = Math.max(this.f2356c, i11 - iM1442a);
            }
            this.f2357d = Math.min(this.f2357d, this.f2356c);
        }
    }

    public final String toString() {
        return " min:" + this.f2355b + " " + this.f2357d + " max:" + this.f2354a + " " + this.f2356c;
    }
}

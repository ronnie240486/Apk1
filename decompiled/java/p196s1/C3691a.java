package p196s1;

public final class C3691a {

    public final int f12344a;

    public int f12345b;

    public int f12346c;

    public int f12347d;

    public int f12348e;

    public int f12349f;

    public int f12350g;

    public int f12351h;

    public int f12352i;

    public final C3692b f12353j;

    public C3691a(C3692b c3692b, int i6, int i10) {
        this.f12353j = c3692b;
        this.f12344a = i6;
        this.f12345b = i10;
        m7442a();
    }

    public final void m7442a() {
        C3692b c3692b = this.f12353j;
        int[] iArr = c3692b.f12355a;
        int[] iArr2 = c3692b.f12356b;
        int i6 = Integer.MAX_VALUE;
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MAX_VALUE;
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MIN_VALUE;
        int i14 = Integer.MIN_VALUE;
        int i15 = 0;
        for (int i16 = this.f12344a; i16 <= this.f12345b; i16++) {
            int i17 = iArr[i16];
            i15 += iArr2[i17];
            int i18 = (i17 >> 10) & 31;
            int i19 = (i17 >> 5) & 31;
            int i20 = i17 & 31;
            if (i18 > i12) {
                i12 = i18;
            }
            if (i18 < i6) {
                i6 = i18;
            }
            if (i19 > i13) {
                i13 = i19;
            }
            if (i19 < i10) {
                i10 = i19;
            }
            if (i20 > i14) {
                i14 = i20;
            }
            if (i20 < i11) {
                i11 = i20;
            }
        }
        this.f12347d = i6;
        this.f12348e = i12;
        this.f12349f = i10;
        this.f12350g = i13;
        this.f12351h = i11;
        this.f12352i = i14;
        this.f12346c = i15;
    }

    public final int m7443b() {
        return ((this.f12352i - this.f12351h) + 1) * ((this.f12350g - this.f12349f) + 1) * ((this.f12348e - this.f12347d) + 1);
    }
}

package p215u;

import java.util.Arrays;

public final class C3886i {

    public boolean f13051a;

    public float f13055e;

    public int f13062l;

    public int f13052b = -1;

    public int f13053c = -1;

    public int f13054d = 0;

    public boolean f13056f = false;

    public final float[] f13057g = new float[9];

    public final float[] f13058h = new float[9];

    public C3880c[] f13059i = new C3880c[16];

    public int f13060j = 0;

    public int f13061k = 0;

    public C3886i(int i6) {
        this.f13062l = i6;
    }

    public final void m7786a(C3880c c3880c) {
        int i6 = 0;
        while (true) {
            int i10 = this.f13060j;
            if (i6 >= i10) {
                C3880c[] c3880cArr = this.f13059i;
                if (i10 >= c3880cArr.length) {
                    this.f13059i = (C3880c[]) Arrays.copyOf(c3880cArr, c3880cArr.length * 2);
                }
                C3880c[] c3880cArr2 = this.f13059i;
                int i11 = this.f13060j;
                c3880cArr2[i11] = c3880c;
                this.f13060j = i11 + 1;
                return;
            }
            if (this.f13059i[i6] == c3880c) {
                return;
            } else {
                i6++;
            }
        }
    }

    public final void m7787b(C3880c c3880c) {
        int i6 = this.f13060j;
        int i10 = 0;
        while (i10 < i6) {
            if (this.f13059i[i10] == c3880c) {
                while (i10 < i6 - 1) {
                    C3880c[] c3880cArr = this.f13059i;
                    int i11 = i10 + 1;
                    c3880cArr[i10] = c3880cArr[i11];
                    i10 = i11;
                }
                this.f13060j--;
                return;
            }
            i10++;
        }
    }

    public final void m7788c() {
        this.f13062l = 5;
        this.f13054d = 0;
        this.f13052b = -1;
        this.f13053c = -1;
        this.f13055e = 0.0f;
        this.f13056f = false;
        int i6 = this.f13060j;
        for (int i10 = 0; i10 < i6; i10++) {
            this.f13059i[i10] = null;
        }
        this.f13060j = 0;
        this.f13061k = 0;
        this.f13051a = false;
        Arrays.fill(this.f13058h, 0.0f);
    }

    public final void m7789d(C3880c c3880c) {
        int i6 = this.f13060j;
        for (int i10 = 0; i10 < i6; i10++) {
            this.f13059i[i10].mo7764h(c3880c, false);
        }
        this.f13060j = 0;
    }

    public final String toString() {
        return "" + this.f13052b;
    }
}

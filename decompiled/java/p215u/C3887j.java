package p215u;

import java.util.Arrays;
import p001a0.C0023f;
import p055ea.AbstractC2460q;

public final class C3887j implements InterfaceC3879b {

    public int f13063a = 16;

    public final int[] f13064b = new int[16];

    public int[] f13065c = new int[16];

    public int[] f13066d = new int[16];

    public float[] f13067e = new float[16];

    public int[] f13068f = new int[16];

    public int[] f13069g = new int[16];

    public int f13070h = 0;

    public int f13071i = -1;

    public final C3881d f13072j;

    public final C0023f f13073k;

    public C3887j(C3881d c3881d, C0023f c0023f) {
        this.f13072j = c3881d;
        this.f13073k = c0023f;
        clear();
    }

    @Override
    public final float mo7746a(int i6) {
        int i10 = this.f13070h;
        int i11 = this.f13071i;
        for (int i12 = 0; i12 < i10; i12++) {
            if (i12 == i6) {
                return this.f13067e[i11];
            }
            i11 = this.f13069g[i11];
            if (i11 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override
    public final float mo7747b(C3886i c3886i, boolean z7) {
        int[] iArr;
        int i6;
        int iM7792n = m7792n(c3886i);
        if (iM7792n == -1) {
            return 0.0f;
        }
        int i10 = c3886i.f13052b;
        int i11 = i10 % 16;
        int[] iArr2 = this.f13064b;
        int i12 = iArr2[i11];
        if (i12 != -1) {
            if (this.f13066d[i12] == i10) {
                int[] iArr3 = this.f13065c;
                iArr2[i11] = iArr3[i12];
                iArr3[i12] = -1;
            } else {
                while (true) {
                    iArr = this.f13065c;
                    i6 = iArr[i12];
                    if (i6 == -1 || this.f13066d[i6] == i10) {
                        break;
                    }
                    i12 = i6;
                }
                if (i6 != -1 && this.f13066d[i6] == i10) {
                    iArr[i12] = iArr[i6];
                    iArr[i6] = -1;
                }
            }
        }
        float f = this.f13067e[iM7792n];
        if (this.f13071i == iM7792n) {
            this.f13071i = this.f13069g[iM7792n];
        }
        this.f13066d[iM7792n] = -1;
        int[] iArr4 = this.f13068f;
        int i13 = iArr4[iM7792n];
        if (i13 != -1) {
            int[] iArr5 = this.f13069g;
            iArr5[i13] = iArr5[iM7792n];
        }
        int i14 = this.f13069g[iM7792n];
        if (i14 != -1) {
            iArr4[i14] = iArr4[iM7792n];
        }
        this.f13070h--;
        c3886i.f13061k--;
        if (z7) {
            c3886i.m7787b(this.f13072j);
        }
        return f;
    }

    @Override
    public final float mo7748c(C3880c c3880c, boolean z7) {
        float fMo7752g = mo7752g(c3880c.f13024a);
        mo7747b(c3880c.f13024a, z7);
        C3887j c3887j = (C3887j) c3880c.f13027d;
        int i6 = c3887j.f13070h;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i6) {
            int i12 = c3887j.f13066d[i11];
            if (i12 != -1) {
                mo7751f(((C3886i[]) this.f13073k.f47e)[i12], c3887j.f13067e[i11] * fMo7752g, z7);
                i10++;
            }
            i11++;
        }
        return fMo7752g;
    }

    @Override
    public final void clear() {
        int i6 = this.f13070h;
        for (int i10 = 0; i10 < i6; i10++) {
            C3886i c3886iMo7754i = mo7754i(i10);
            if (c3886iMo7754i != null) {
                c3886iMo7754i.m7787b(this.f13072j);
            }
        }
        for (int i11 = 0; i11 < this.f13063a; i11++) {
            this.f13066d[i11] = -1;
            this.f13065c[i11] = -1;
        }
        for (int i12 = 0; i12 < 16; i12++) {
            this.f13064b[i12] = -1;
        }
        this.f13070h = 0;
        this.f13071i = -1;
    }

    @Override
    public final int mo7749d() {
        return this.f13070h;
    }

    @Override
    public final boolean mo7750e(C3886i c3886i) {
        return m7792n(c3886i) != -1;
    }

    @Override
    public final void mo7751f(C3886i c3886i, float f, boolean z7) {
        if (f <= -0.001f || f >= 0.001f) {
            int iM7792n = m7792n(c3886i);
            if (iM7792n == -1) {
                mo7753h(c3886i, f);
                return;
            }
            float[] fArr = this.f13067e;
            float f3 = fArr[iM7792n] + f;
            fArr[iM7792n] = f3;
            if (f3 <= -0.001f || f3 >= 0.001f) {
                return;
            }
            fArr[iM7792n] = 0.0f;
            mo7747b(c3886i, z7);
        }
    }

    @Override
    public final float mo7752g(C3886i c3886i) {
        int iM7792n = m7792n(c3886i);
        if (iM7792n != -1) {
            return this.f13067e[iM7792n];
        }
        return 0.0f;
    }

    @Override
    public final void mo7753h(C3886i c3886i, float f) {
        if (f > -0.001f && f < 0.001f) {
            mo7747b(c3886i, true);
            return;
        }
        int i6 = 0;
        if (this.f13070h == 0) {
            m7791m(0, c3886i, f);
            m7790l(c3886i, 0);
            this.f13071i = 0;
            return;
        }
        int iM7792n = m7792n(c3886i);
        if (iM7792n != -1) {
            this.f13067e[iM7792n] = f;
            return;
        }
        int i10 = this.f13070h + 1;
        int i11 = this.f13063a;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            this.f13066d = Arrays.copyOf(this.f13066d, i12);
            this.f13067e = Arrays.copyOf(this.f13067e, i12);
            this.f13068f = Arrays.copyOf(this.f13068f, i12);
            this.f13069g = Arrays.copyOf(this.f13069g, i12);
            this.f13065c = Arrays.copyOf(this.f13065c, i12);
            for (int i13 = this.f13063a; i13 < i12; i13++) {
                this.f13066d[i13] = -1;
                this.f13065c[i13] = -1;
            }
            this.f13063a = i12;
        }
        int i14 = this.f13070h;
        int i15 = this.f13071i;
        int i16 = -1;
        for (int i17 = 0; i17 < i14; i17++) {
            int i18 = this.f13066d[i15];
            int i19 = c3886i.f13052b;
            if (i18 == i19) {
                this.f13067e[i15] = f;
                return;
            }
            if (i18 < i19) {
                i16 = i15;
            }
            i15 = this.f13069g[i15];
            if (i15 == -1) {
                break;
            }
        }
        while (true) {
            if (i6 >= this.f13063a) {
                i6 = -1;
                break;
            } else if (this.f13066d[i6] == -1) {
                break;
            } else {
                i6++;
            }
        }
        m7791m(i6, c3886i, f);
        if (i16 != -1) {
            this.f13068f[i6] = i16;
            int[] iArr = this.f13069g;
            iArr[i6] = iArr[i16];
            iArr[i16] = i6;
        } else {
            this.f13068f[i6] = -1;
            if (this.f13070h > 0) {
                this.f13069g[i6] = this.f13071i;
                this.f13071i = i6;
            } else {
                this.f13069g[i6] = -1;
            }
        }
        int i20 = this.f13069g[i6];
        if (i20 != -1) {
            this.f13068f[i20] = i6;
        }
        m7790l(c3886i, i6);
    }

    @Override
    public final C3886i mo7754i(int i6) {
        int i10 = this.f13070h;
        if (i10 == 0) {
            return null;
        }
        int i11 = this.f13071i;
        for (int i12 = 0; i12 < i10; i12++) {
            if (i12 == i6 && i11 != -1) {
                return ((C3886i[]) this.f13073k.f47e)[this.f13066d[i11]];
            }
            i11 = this.f13069g[i11];
            if (i11 == -1) {
                break;
            }
        }
        return null;
    }

    @Override
    public final void mo7755j(float f) {
        int i6 = this.f13070h;
        int i10 = this.f13071i;
        for (int i11 = 0; i11 < i6; i11++) {
            float[] fArr = this.f13067e;
            fArr[i10] = fArr[i10] / f;
            i10 = this.f13069g[i10];
            if (i10 == -1) {
                return;
            }
        }
    }

    @Override
    public final void mo7756k() {
        int i6 = this.f13070h;
        int i10 = this.f13071i;
        for (int i11 = 0; i11 < i6; i11++) {
            float[] fArr = this.f13067e;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f13069g[i10];
            if (i10 == -1) {
                return;
            }
        }
    }

    public final void m7790l(C3886i c3886i, int i6) {
        int[] iArr;
        int i10 = c3886i.f13052b % 16;
        int[] iArr2 = this.f13064b;
        int i11 = iArr2[i10];
        if (i11 == -1) {
            iArr2[i10] = i6;
        } else {
            while (true) {
                iArr = this.f13065c;
                int i12 = iArr[i11];
                if (i12 == -1) {
                    break;
                } else {
                    i11 = i12;
                }
            }
            iArr[i11] = i6;
        }
        this.f13065c[i6] = -1;
    }

    public final void m7791m(int i6, C3886i c3886i, float f) {
        this.f13066d[i6] = c3886i.f13052b;
        this.f13067e[i6] = f;
        this.f13068f[i6] = -1;
        this.f13069g[i6] = -1;
        c3886i.m7786a(this.f13072j);
        c3886i.f13061k++;
        this.f13070h++;
    }

    public final int m7792n(C3886i c3886i) {
        if (this.f13070h == 0) {
            return -1;
        }
        int i6 = c3886i.f13052b;
        int i10 = this.f13064b[i6 % 16];
        if (i10 == -1) {
            return -1;
        }
        if (this.f13066d[i10] == i6) {
            return i10;
        }
        do {
            i10 = this.f13065c[i10];
            if (i10 == -1) {
                break;
            }
        } while (this.f13066d[i10] != i6);
        if (i10 != -1 && this.f13066d[i10] == i6) {
            return i10;
        }
        return -1;
    }

    public final String toString() {
        String strM5494h;
        String strM5494h2;
        String strM5494h3 = hashCode() + " { ";
        int i6 = this.f13070h;
        for (int i10 = 0; i10 < i6; i10++) {
            C3886i c3886iMo7754i = mo7754i(i10);
            if (c3886iMo7754i != null) {
                String str = strM5494h3 + c3886iMo7754i + " = " + mo7746a(i10) + " ";
                int iM7792n = m7792n(c3886iMo7754i);
                String strM5494h4 = AbstractC2460q.m5494h(str, "[p: ");
                int i11 = this.f13068f[iM7792n];
                C0023f c0023f = this.f13073k;
                if (i11 != -1) {
                    StringBuilder sbM5498l = AbstractC2460q.m5498l(strM5494h4);
                    sbM5498l.append(((C3886i[]) c0023f.f47e)[this.f13066d[this.f13068f[iM7792n]]]);
                    strM5494h = sbM5498l.toString();
                } else {
                    strM5494h = AbstractC2460q.m5494h(strM5494h4, "none");
                }
                String strM5494h5 = AbstractC2460q.m5494h(strM5494h, ", n: ");
                if (this.f13069g[iM7792n] != -1) {
                    StringBuilder sbM5498l2 = AbstractC2460q.m5498l(strM5494h5);
                    sbM5498l2.append(((C3886i[]) c0023f.f47e)[this.f13066d[this.f13069g[iM7792n]]]);
                    strM5494h2 = sbM5498l2.toString();
                } else {
                    strM5494h2 = AbstractC2460q.m5494h(strM5494h5, "none");
                }
                strM5494h3 = AbstractC2460q.m5494h(strM5494h2, "]");
            }
        }
        return AbstractC2460q.m5494h(strM5494h3, " }");
    }
}

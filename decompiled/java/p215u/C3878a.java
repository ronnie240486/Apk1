package p215u;

import java.util.Arrays;
import p001a0.C0023f;
import p055ea.AbstractC2460q;

public final class C3878a implements InterfaceC3879b {

    public final C3880c f13015b;

    public final C0023f f13016c;

    public int f13014a = 0;

    public int f13017d = 8;

    public int[] f13018e = new int[8];

    public int[] f13019f = new int[8];

    public float[] f13020g = new float[8];

    public int f13021h = -1;

    public int f13022i = -1;

    public boolean f13023j = false;

    public C3878a(C3880c c3880c, C0023f c0023f) {
        this.f13015b = c3880c;
        this.f13016c = c0023f;
    }

    @Override
    public final float mo7746a(int i6) {
        int i10 = this.f13021h;
        for (int i11 = 0; i10 != -1 && i11 < this.f13014a; i11++) {
            if (i11 == i6) {
                return this.f13020g[i10];
            }
            i10 = this.f13019f[i10];
        }
        return 0.0f;
    }

    @Override
    public final float mo7747b(C3886i c3886i, boolean z7) {
        int i6 = this.f13021h;
        if (i6 == -1) {
            return 0.0f;
        }
        int i10 = 0;
        int i11 = -1;
        while (i6 != -1 && i10 < this.f13014a) {
            if (this.f13018e[i6] == c3886i.f13052b) {
                if (i6 == this.f13021h) {
                    this.f13021h = this.f13019f[i6];
                } else {
                    int[] iArr = this.f13019f;
                    iArr[i11] = iArr[i6];
                }
                if (z7) {
                    c3886i.m7787b(this.f13015b);
                }
                c3886i.f13061k--;
                this.f13014a--;
                this.f13018e[i6] = -1;
                if (this.f13023j) {
                    this.f13022i = i6;
                }
                return this.f13020g[i6];
            }
            i10++;
            i11 = i6;
            i6 = this.f13019f[i6];
        }
        return 0.0f;
    }

    @Override
    public final float mo7748c(C3880c c3880c, boolean z7) {
        float fMo7752g = mo7752g(c3880c.f13024a);
        mo7747b(c3880c.f13024a, z7);
        InterfaceC3879b interfaceC3879b = c3880c.f13027d;
        int iMo7749d = interfaceC3879b.mo7749d();
        for (int i6 = 0; i6 < iMo7749d; i6++) {
            C3886i c3886iMo7754i = interfaceC3879b.mo7754i(i6);
            mo7751f(c3886iMo7754i, interfaceC3879b.mo7752g(c3886iMo7754i) * fMo7752g, z7);
        }
        return fMo7752g;
    }

    @Override
    public final void clear() {
        int i6 = this.f13021h;
        for (int i10 = 0; i6 != -1 && i10 < this.f13014a; i10++) {
            C3886i c3886i = ((C3886i[]) this.f13016c.f47e)[this.f13018e[i6]];
            if (c3886i != null) {
                c3886i.m7787b(this.f13015b);
            }
            i6 = this.f13019f[i6];
        }
        this.f13021h = -1;
        this.f13022i = -1;
        this.f13023j = false;
        this.f13014a = 0;
    }

    @Override
    public final int mo7749d() {
        return this.f13014a;
    }

    @Override
    public final boolean mo7750e(C3886i c3886i) {
        int i6 = this.f13021h;
        if (i6 == -1) {
            return false;
        }
        for (int i10 = 0; i6 != -1 && i10 < this.f13014a; i10++) {
            if (this.f13018e[i6] == c3886i.f13052b) {
                return true;
            }
            i6 = this.f13019f[i6];
        }
        return false;
    }

    @Override
    public final void mo7751f(C3886i c3886i, float f, boolean z7) {
        if (f <= -0.001f || f >= 0.001f) {
            int i6 = this.f13021h;
            C3880c c3880c = this.f13015b;
            if (i6 == -1) {
                this.f13021h = 0;
                this.f13020g[0] = f;
                this.f13018e[0] = c3886i.f13052b;
                this.f13019f[0] = -1;
                c3886i.f13061k++;
                c3886i.m7786a(c3880c);
                this.f13014a++;
                if (this.f13023j) {
                    return;
                }
                int i10 = this.f13022i + 1;
                this.f13022i = i10;
                int[] iArr = this.f13018e;
                if (i10 >= iArr.length) {
                    this.f13023j = true;
                    this.f13022i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i11 = -1;
            for (int i12 = 0; i6 != -1 && i12 < this.f13014a; i12++) {
                int i13 = this.f13018e[i6];
                int i14 = c3886i.f13052b;
                if (i13 == i14) {
                    float[] fArr = this.f13020g;
                    float f3 = fArr[i6] + f;
                    if (f3 > -0.001f && f3 < 0.001f) {
                        f3 = 0.0f;
                    }
                    fArr[i6] = f3;
                    if (f3 == 0.0f) {
                        if (i6 == this.f13021h) {
                            this.f13021h = this.f13019f[i6];
                        } else {
                            int[] iArr2 = this.f13019f;
                            iArr2[i11] = iArr2[i6];
                        }
                        if (z7) {
                            c3886i.m7787b(c3880c);
                        }
                        if (this.f13023j) {
                            this.f13022i = i6;
                        }
                        c3886i.f13061k--;
                        this.f13014a--;
                        return;
                    }
                    return;
                }
                if (i13 < i14) {
                    i11 = i6;
                }
                i6 = this.f13019f[i6];
            }
            int length = this.f13022i;
            int i15 = length + 1;
            if (this.f13023j) {
                int[] iArr3 = this.f13018e;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i15;
            }
            int[] iArr4 = this.f13018e;
            if (length >= iArr4.length && this.f13014a < iArr4.length) {
                int i16 = 0;
                while (true) {
                    int[] iArr5 = this.f13018e;
                    if (i16 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i16] == -1) {
                        length = i16;
                        break;
                    }
                    i16++;
                }
            }
            int[] iArr6 = this.f13018e;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i17 = this.f13017d * 2;
                this.f13017d = i17;
                this.f13023j = false;
                this.f13022i = length - 1;
                this.f13020g = Arrays.copyOf(this.f13020g, i17);
                this.f13018e = Arrays.copyOf(this.f13018e, this.f13017d);
                this.f13019f = Arrays.copyOf(this.f13019f, this.f13017d);
            }
            this.f13018e[length] = c3886i.f13052b;
            this.f13020g[length] = f;
            if (i11 != -1) {
                int[] iArr7 = this.f13019f;
                iArr7[length] = iArr7[i11];
                iArr7[i11] = length;
            } else {
                this.f13019f[length] = this.f13021h;
                this.f13021h = length;
            }
            c3886i.f13061k++;
            c3886i.m7786a(c3880c);
            this.f13014a++;
            if (!this.f13023j) {
                this.f13022i++;
            }
            int i18 = this.f13022i;
            int[] iArr8 = this.f13018e;
            if (i18 >= iArr8.length) {
                this.f13023j = true;
                this.f13022i = iArr8.length - 1;
            }
        }
    }

    @Override
    public final float mo7752g(C3886i c3886i) {
        int i6 = this.f13021h;
        for (int i10 = 0; i6 != -1 && i10 < this.f13014a; i10++) {
            if (this.f13018e[i6] == c3886i.f13052b) {
                return this.f13020g[i6];
            }
            i6 = this.f13019f[i6];
        }
        return 0.0f;
    }

    @Override
    public final void mo7753h(C3886i c3886i, float f) {
        if (f == 0.0f) {
            mo7747b(c3886i, true);
            return;
        }
        int i6 = this.f13021h;
        C3880c c3880c = this.f13015b;
        if (i6 == -1) {
            this.f13021h = 0;
            this.f13020g[0] = f;
            this.f13018e[0] = c3886i.f13052b;
            this.f13019f[0] = -1;
            c3886i.f13061k++;
            c3886i.m7786a(c3880c);
            this.f13014a++;
            if (this.f13023j) {
                return;
            }
            int i10 = this.f13022i + 1;
            this.f13022i = i10;
            int[] iArr = this.f13018e;
            if (i10 >= iArr.length) {
                this.f13023j = true;
                this.f13022i = iArr.length - 1;
                return;
            }
            return;
        }
        int i11 = -1;
        for (int i12 = 0; i6 != -1 && i12 < this.f13014a; i12++) {
            int i13 = this.f13018e[i6];
            int i14 = c3886i.f13052b;
            if (i13 == i14) {
                this.f13020g[i6] = f;
                return;
            }
            if (i13 < i14) {
                i11 = i6;
            }
            i6 = this.f13019f[i6];
        }
        int length = this.f13022i;
        int i15 = length + 1;
        if (this.f13023j) {
            int[] iArr2 = this.f13018e;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i15;
        }
        int[] iArr3 = this.f13018e;
        if (length >= iArr3.length && this.f13014a < iArr3.length) {
            int i16 = 0;
            while (true) {
                int[] iArr4 = this.f13018e;
                if (i16 >= iArr4.length) {
                    break;
                }
                if (iArr4[i16] == -1) {
                    length = i16;
                    break;
                }
                i16++;
            }
        }
        int[] iArr5 = this.f13018e;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i17 = this.f13017d * 2;
            this.f13017d = i17;
            this.f13023j = false;
            this.f13022i = length - 1;
            this.f13020g = Arrays.copyOf(this.f13020g, i17);
            this.f13018e = Arrays.copyOf(this.f13018e, this.f13017d);
            this.f13019f = Arrays.copyOf(this.f13019f, this.f13017d);
        }
        this.f13018e[length] = c3886i.f13052b;
        this.f13020g[length] = f;
        if (i11 != -1) {
            int[] iArr6 = this.f13019f;
            iArr6[length] = iArr6[i11];
            iArr6[i11] = length;
        } else {
            this.f13019f[length] = this.f13021h;
            this.f13021h = length;
        }
        c3886i.f13061k++;
        c3886i.m7786a(c3880c);
        int i18 = this.f13014a + 1;
        this.f13014a = i18;
        if (!this.f13023j) {
            this.f13022i++;
        }
        int[] iArr7 = this.f13018e;
        if (i18 >= iArr7.length) {
            this.f13023j = true;
        }
        if (this.f13022i >= iArr7.length) {
            this.f13023j = true;
            this.f13022i = iArr7.length - 1;
        }
    }

    @Override
    public final C3886i mo7754i(int i6) {
        int i10 = this.f13021h;
        for (int i11 = 0; i10 != -1 && i11 < this.f13014a; i11++) {
            if (i11 == i6) {
                return ((C3886i[]) this.f13016c.f47e)[this.f13018e[i10]];
            }
            i10 = this.f13019f[i10];
        }
        return null;
    }

    @Override
    public final void mo7755j(float f) {
        int i6 = this.f13021h;
        for (int i10 = 0; i6 != -1 && i10 < this.f13014a; i10++) {
            float[] fArr = this.f13020g;
            fArr[i6] = fArr[i6] / f;
            i6 = this.f13019f[i6];
        }
    }

    @Override
    public final void mo7756k() {
        int i6 = this.f13021h;
        for (int i10 = 0; i6 != -1 && i10 < this.f13014a; i10++) {
            float[] fArr = this.f13020g;
            fArr[i6] = fArr[i6] * (-1.0f);
            i6 = this.f13019f[i6];
        }
    }

    public final String toString() {
        int i6 = this.f13021h;
        String string = "";
        for (int i10 = 0; i6 != -1 && i10 < this.f13014a; i10++) {
            StringBuilder sbM5498l = AbstractC2460q.m5498l(AbstractC2460q.m5494h(string, " -> "));
            sbM5498l.append(this.f13020g[i6]);
            sbM5498l.append(" : ");
            StringBuilder sbM5498l2 = AbstractC2460q.m5498l(sbM5498l.toString());
            sbM5498l2.append(((C3886i[]) this.f13016c.f47e)[this.f13018e[i6]]);
            string = sbM5498l2.toString();
            i6 = this.f13019f[i6];
        }
        return string;
    }
}

package p215u;

import java.util.Arrays;
import p001a0.C0022e;

public final class C3884g extends C3880c {

    public C3886i[] f13047f;

    public C3886i[] f13048g;

    public int f13049h;

    public C3883f f13050i;

    @Override
    public final C3886i mo7760d(boolean[] zArr) {
        int i6 = -1;
        for (int i10 = 0; i10 < this.f13049h; i10++) {
            C3886i[] c3886iArr = this.f13047f;
            C3886i c3886i = c3886iArr[i10];
            if (!zArr[c3886i.f13052b]) {
                C3883f c3883f = this.f13050i;
                c3883f.f13045a = c3886i;
                int i11 = 8;
                if (i6 != -1) {
                    C3886i c3886i2 = c3886iArr[i6];
                    while (i11 >= 0) {
                        float f = c3886i2.f13058h[i11];
                        float f3 = c3883f.f13045a.f13058h[i11];
                        if (f3 != f) {
                            if (f3 >= f) {
                                break;
                            }
                            i6 = i10;
                            break;
                            break;
                        }
                        i11--;
                    }
                } else {
                    while (i11 >= 0) {
                        float f4 = c3883f.f13045a.f13058h[i11];
                        if (f4 > 0.0f) {
                            break;
                        }
                        if (f4 < 0.0f) {
                            i6 = i10;
                            break;
                        }
                        i11--;
                    }
                }
            }
        }
        if (i6 == -1) {
            return null;
        }
        return this.f13047f[i6];
    }

    @Override
    public final void mo7764h(C3880c c3880c, boolean z7) {
        C3886i c3886i = c3880c.f13024a;
        if (c3886i == null) {
            return;
        }
        InterfaceC3879b interfaceC3879b = c3880c.f13027d;
        int iMo7749d = interfaceC3879b.mo7749d();
        for (int i6 = 0; i6 < iMo7749d; i6++) {
            C3886i c3886iMo7754i = interfaceC3879b.mo7754i(i6);
            float fMo7746a = interfaceC3879b.mo7746a(i6);
            C3883f c3883f = this.f13050i;
            c3883f.f13045a = c3886iMo7754i;
            boolean z10 = c3886iMo7754i.f13051a;
            float[] fArr = c3886i.f13058h;
            if (z10) {
                boolean z11 = true;
                for (int i10 = 0; i10 < 9; i10++) {
                    float[] fArr2 = c3883f.f13045a.f13058h;
                    float f = (fArr[i10] * fMo7746a) + fArr2[i10];
                    fArr2[i10] = f;
                    if (Math.abs(f) < 1.0E-4f) {
                        c3883f.f13045a.f13058h[i10] = 0.0f;
                    } else {
                        z11 = false;
                    }
                }
                if (z11) {
                    c3883f.f13046b.m7784j(c3883f.f13045a);
                }
            } else {
                for (int i11 = 0; i11 < 9; i11++) {
                    float f3 = fArr[i11];
                    if (f3 != 0.0f) {
                        float f4 = f3 * fMo7746a;
                        if (Math.abs(f4) < 1.0E-4f) {
                            f4 = 0.0f;
                        }
                        c3883f.f13045a.f13058h[i11] = f4;
                    } else {
                        c3883f.f13045a.f13058h[i11] = 0.0f;
                    }
                }
                m7783i(c3886iMo7754i);
            }
            this.f13025b = (c3880c.f13025b * fMo7746a) + this.f13025b;
        }
        m7784j(c3886i);
    }

    public final void m7783i(C3886i c3886i) {
        int i6;
        int i10 = this.f13049h + 1;
        C3886i[] c3886iArr = this.f13047f;
        if (i10 > c3886iArr.length) {
            C3886i[] c3886iArr2 = (C3886i[]) Arrays.copyOf(c3886iArr, c3886iArr.length * 2);
            this.f13047f = c3886iArr2;
            this.f13048g = (C3886i[]) Arrays.copyOf(c3886iArr2, c3886iArr2.length * 2);
        }
        C3886i[] c3886iArr3 = this.f13047f;
        int i11 = this.f13049h;
        c3886iArr3[i11] = c3886i;
        int i12 = i11 + 1;
        this.f13049h = i12;
        if (i12 > 1 && c3886iArr3[i11].f13052b > c3886i.f13052b) {
            int i13 = 0;
            while (true) {
                i6 = this.f13049h;
                if (i13 >= i6) {
                    break;
                }
                this.f13048g[i13] = this.f13047f[i13];
                i13++;
            }
            Arrays.sort(this.f13048g, 0, i6, new C0022e(8));
            for (int i14 = 0; i14 < this.f13049h; i14++) {
                this.f13047f[i14] = this.f13048g[i14];
            }
        }
        c3886i.f13051a = true;
        c3886i.m7786a(this);
    }

    public final void m7784j(C3886i c3886i) {
        int i6 = 0;
        while (i6 < this.f13049h) {
            if (this.f13047f[i6] == c3886i) {
                while (true) {
                    int i10 = this.f13049h;
                    if (i6 >= i10 - 1) {
                        this.f13049h = i10 - 1;
                        c3886i.f13051a = false;
                        return;
                    } else {
                        C3886i[] c3886iArr = this.f13047f;
                        int i11 = i6 + 1;
                        c3886iArr[i6] = c3886iArr[i11];
                        i6 = i11;
                    }
                }
            } else {
                i6++;
            }
        }
    }

    @Override
    public final String toString() {
        String str = " goal -> (" + this.f13025b + ") : ";
        for (int i6 = 0; i6 < this.f13049h; i6++) {
            C3886i c3886i = this.f13047f[i6];
            C3883f c3883f = this.f13050i;
            c3883f.f13045a = c3886i;
            str = str + c3883f + " ";
        }
        return str;
    }
}

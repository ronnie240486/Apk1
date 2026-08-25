package p194s;

import java.util.Arrays;
import p187r4.AbstractC3612b;

public final class C3678b extends AbstractC3612b {

    public final int f12312c = 1;

    public double[] f12313d;

    public Object[] f12314e;

    public C3678b() {
    }

    @Override
    public final double mo7275q(double d) {
        switch (this.f12312c) {
            case 0:
                C3677a[] c3677aArr = (C3677a[]) this.f12314e;
                double d10 = c3677aArr[0].f12296c;
                if (d < d10) {
                    d = d10;
                } else if (d > c3677aArr[c3677aArr.length - 1].f12297d) {
                    d = c3677aArr[c3677aArr.length - 1].f12297d;
                }
                for (int i6 = 0; i6 < c3677aArr.length; i6++) {
                    C3677a c3677a = c3677aArr[i6];
                    if (d <= c3677a.f12297d) {
                        if (c3677a.f12311r) {
                            return c3677a.m7425b(d);
                        }
                        c3677a.m7427d(d);
                        C3677a c3677a2 = c3677aArr[i6];
                        return c3677a2.f12305l + (c3677a2.f12303j * c3677a2.f12308o);
                    }
                }
                return Double.NaN;
            default:
                double[] dArr = this.f12313d;
                int length = dArr.length;
                double d11 = dArr[0];
                double[][] dArr2 = (double[][]) this.f12314e;
                if (d <= d11) {
                    return dArr2[0][0];
                }
                int i10 = length - 1;
                if (d >= dArr[i10]) {
                    return dArr2[i10][0];
                }
                int i11 = 0;
                while (i11 < i10) {
                    double d12 = dArr[i11];
                    if (d == d12) {
                        return dArr2[i11][0];
                    }
                    int i12 = i11 + 1;
                    double d13 = dArr[i12];
                    if (d < d13) {
                        double d14 = (d - d12) / (d13 - d12);
                        return (dArr2[i12][0] * d14) + ((1.0d - d14) * dArr2[i11][0]);
                    }
                    i11 = i12;
                }
                return 0.0d;
        }
    }

    @Override
    public final void mo7276r(double d, double[] dArr) {
        switch (this.f12312c) {
            case 0:
                C3677a[] c3677aArr = (C3677a[]) this.f12314e;
                double d10 = c3677aArr[0].f12296c;
                if (d < d10) {
                    d = d10;
                }
                if (d > c3677aArr[c3677aArr.length - 1].f12297d) {
                    d = c3677aArr[c3677aArr.length - 1].f12297d;
                }
                for (int i6 = 0; i6 < c3677aArr.length; i6++) {
                    C3677a c3677a = c3677aArr[i6];
                    if (d <= c3677a.f12297d) {
                        if (c3677a.f12311r) {
                            dArr[0] = c3677a.m7425b(d);
                            dArr[1] = c3677aArr[i6].m7426c(d);
                        } else {
                            c3677a.m7427d(d);
                            C3677a c3677a2 = c3677aArr[i6];
                            dArr[0] = (c3677a2.f12303j * c3677a2.f12308o) + c3677a2.f12305l;
                            dArr[1] = (c3677a2.f12304k * c3677a2.f12309p) + c3677a2.f12306m;
                        }
                    }
                    break;
                }
                break;
            default:
                double[] dArr2 = this.f12313d;
                int length = dArr2.length;
                double[][] dArr3 = (double[][]) this.f12314e;
                int i10 = 0;
                int length2 = dArr3[0].length;
                if (d <= dArr2[0]) {
                    for (int i11 = 0; i11 < length2; i11++) {
                        dArr[i11] = dArr3[0][i11];
                    }
                } else {
                    int i12 = length - 1;
                    if (d >= dArr2[i12]) {
                        while (i10 < length2) {
                            dArr[i10] = dArr3[i12][i10];
                            i10++;
                        }
                    } else {
                        int i13 = 0;
                        while (i13 < i12) {
                            if (d == dArr2[i13]) {
                                for (int i14 = 0; i14 < length2; i14++) {
                                    dArr[i14] = dArr3[i13][i14];
                                }
                            }
                            int i15 = i13 + 1;
                            double d11 = dArr2[i15];
                            if (d < d11) {
                                double d12 = dArr2[i13];
                                double d13 = (d - d12) / (d11 - d12);
                                while (i10 < length2) {
                                    dArr[i10] = (dArr3[i15][i10] * d13) + ((1.0d - d13) * dArr3[i13][i10]);
                                    i10++;
                                }
                            } else {
                                i13 = i15;
                            }
                        }
                    }
                }
                break;
        }
    }

    @Override
    public final void mo7277s(double d, float[] fArr) {
        switch (this.f12312c) {
            case 0:
                C3677a[] c3677aArr = (C3677a[]) this.f12314e;
                double d10 = c3677aArr[0].f12296c;
                if (d < d10) {
                    d = d10;
                } else if (d > c3677aArr[c3677aArr.length - 1].f12297d) {
                    d = c3677aArr[c3677aArr.length - 1].f12297d;
                }
                for (int i6 = 0; i6 < c3677aArr.length; i6++) {
                    C3677a c3677a = c3677aArr[i6];
                    if (d <= c3677a.f12297d) {
                        if (c3677a.f12311r) {
                            fArr[0] = (float) c3677a.m7425b(d);
                            fArr[1] = (float) c3677aArr[i6].m7426c(d);
                        } else {
                            c3677a.m7427d(d);
                            C3677a c3677a2 = c3677aArr[i6];
                            fArr[0] = (float) ((c3677a2.f12303j * c3677a2.f12308o) + c3677a2.f12305l);
                            fArr[1] = (float) ((c3677a2.f12304k * c3677a2.f12309p) + c3677a2.f12306m);
                        }
                    }
                    break;
                }
                break;
            default:
                double[] dArr = this.f12313d;
                int length = dArr.length;
                double[][] dArr2 = (double[][]) this.f12314e;
                int i10 = 0;
                int length2 = dArr2[0].length;
                if (d <= dArr[0]) {
                    for (int i11 = 0; i11 < length2; i11++) {
                        fArr[i11] = (float) dArr2[0][i11];
                    }
                } else {
                    int i12 = length - 1;
                    if (d >= dArr[i12]) {
                        while (i10 < length2) {
                            fArr[i10] = (float) dArr2[i12][i10];
                            i10++;
                        }
                    } else {
                        int i13 = 0;
                        while (i13 < i12) {
                            if (d == dArr[i13]) {
                                for (int i14 = 0; i14 < length2; i14++) {
                                    fArr[i14] = (float) dArr2[i13][i14];
                                }
                            }
                            int i15 = i13 + 1;
                            double d11 = dArr[i15];
                            if (d < d11) {
                                double d12 = dArr[i13];
                                double d13 = (d - d12) / (d11 - d12);
                                while (i10 < length2) {
                                    fArr[i10] = (float) ((dArr2[i15][i10] * d13) + ((1.0d - d13) * dArr2[i13][i10]));
                                    i10++;
                                }
                            } else {
                                i13 = i15;
                            }
                        }
                    }
                }
                break;
        }
    }

    @Override
    public final double mo7278u(double d) {
        switch (this.f12312c) {
            case 0:
                C3677a[] c3677aArr = (C3677a[]) this.f12314e;
                double d10 = c3677aArr[0].f12296c;
                if (d < d10) {
                    d = d10;
                }
                if (d > c3677aArr[c3677aArr.length - 1].f12297d) {
                    d = c3677aArr[c3677aArr.length - 1].f12297d;
                }
                for (int i6 = 0; i6 < c3677aArr.length; i6++) {
                    C3677a c3677a = c3677aArr[i6];
                    if (d <= c3677a.f12297d) {
                        if (c3677a.f12311r) {
                            return c3677a.f12305l;
                        }
                        c3677a.m7427d(d);
                        return c3677aArr[i6].m7424a();
                    }
                }
                return Double.NaN;
            default:
                double[] dArr = this.f12313d;
                int length = dArr.length;
                double d11 = dArr[0];
                if (d < d11) {
                    d = d11;
                } else {
                    d11 = dArr[length - 1];
                    if (d >= d11) {
                        d = d11;
                    }
                }
                int i10 = 0;
                while (i10 < length - 1) {
                    int i11 = i10 + 1;
                    double d12 = dArr[i11];
                    if (d <= d12) {
                        double d13 = d12 - dArr[i10];
                        double[][] dArr2 = (double[][]) this.f12314e;
                        return (dArr2[i11][0] - dArr2[i10][0]) / d13;
                    }
                    i10 = i11;
                }
                return 0.0d;
        }
    }

    @Override
    public final void mo7279v(double d, double[] dArr) {
        switch (this.f12312c) {
            case 0:
                C3677a[] c3677aArr = (C3677a[]) this.f12314e;
                double d10 = c3677aArr[0].f12296c;
                if (d < d10) {
                    d = d10;
                } else if (d > c3677aArr[c3677aArr.length - 1].f12297d) {
                    d = c3677aArr[c3677aArr.length - 1].f12297d;
                }
                for (int i6 = 0; i6 < c3677aArr.length; i6++) {
                    C3677a c3677a = c3677aArr[i6];
                    if (d <= c3677a.f12297d) {
                        if (c3677a.f12311r) {
                            dArr[0] = c3677a.f12305l;
                            dArr[1] = c3677a.f12306m;
                        } else {
                            c3677a.m7427d(d);
                            dArr[0] = c3677aArr[i6].m7424a();
                            C3677a c3677a2 = c3677aArr[i6];
                            double d11 = c3677a2.f12303j * c3677a2.f12309p;
                            double d12 = (-c3677a2.f12304k) * c3677a2.f12308o;
                            double dHypot = c3677a2.f12307n / Math.hypot(d11, d12);
                            dArr[1] = c3677a2.f12310q ? (-d12) * dHypot : d12 * dHypot;
                        }
                    }
                    break;
                }
                break;
            default:
                double[] dArr2 = this.f12313d;
                int length = dArr2.length;
                double[][] dArr3 = (double[][]) this.f12314e;
                int length2 = dArr3[0].length;
                double d13 = dArr2[0];
                if (d <= d13) {
                    d = d13;
                } else {
                    d13 = dArr2[length - 1];
                    if (d >= d13) {
                        d = d13;
                    }
                }
                int i10 = 0;
                while (i10 < length - 1) {
                    int i11 = i10 + 1;
                    double d14 = dArr2[i11];
                    if (d <= d14) {
                        double d15 = d14 - dArr2[i10];
                        for (int i12 = 0; i12 < length2; i12++) {
                            dArr[i12] = (dArr3[i11][i12] - dArr3[i10][i12]) / d15;
                        }
                    } else {
                        i10 = i11;
                    }
                    break;
                }
                break;
        }
    }

    @Override
    public final double[] mo7280w() {
        switch (this.f12312c) {
            case 0:
                break;
        }
        return this.f12313d;
    }

    public C3678b(int[] iArr, double[] dArr, double[][] dArr2) {
        double[] dArr3;
        C3678b c3678b = this;
        double[] dArr4 = dArr;
        c3678b.f12313d = dArr4;
        int i6 = 1;
        c3678b.f12314e = new C3677a[dArr4.length - 1];
        ?? r10 = 0;
        int i10 = 0;
        int i11 = 1;
        int i12 = 1;
        while (true) {
            C3677a[] c3677aArr = (C3677a[]) c3678b.f12314e;
            if (i10 >= c3677aArr.length) {
                return;
            }
            int i13 = iArr[i10];
            if (i13 == 0) {
                i12 = 3;
            } else if (i13 == i6) {
                i11 = 1;
                i12 = 1;
            } else if (i13 == 2) {
                i11 = 2;
                i12 = 2;
            } else if (i13 == 3) {
                i11 = i11 == i6 ? 2 : 1;
                i12 = i11;
            }
            double d = dArr4[i10];
            int i14 = i10 + 1;
            double d10 = dArr4[i14];
            double[] dArr5 = dArr2[i10];
            double d11 = dArr5[r10];
            double d12 = dArr5[i6];
            double[] dArr6 = dArr2[i14];
            int i15 = i10;
            int i16 = i11;
            double d13 = dArr6[r10];
            double d14 = dArr6[i6];
            C3677a c3677a = new C3677a();
            c3677a.f12311r = r10;
            boolean z7 = i12 == i6;
            c3677a.f12310q = z7;
            c3677a.f12296c = d;
            c3677a.f12297d = d10;
            double d15 = d10 - d;
            double d16 = 1.0d / d15;
            c3677a.f12302i = d16;
            if (3 == i12) {
                c3677a.f12311r = true;
            }
            int i17 = i12;
            double d17 = d13 - d11;
            double d18 = d14 - d12;
            if (c3677a.f12311r || Math.abs(d17) < 0.001d || Math.abs(d18) < 0.001d) {
                c3677a.f12311r = true;
                c3677a.f12298e = d11;
                c3677a.f12299f = d13;
                c3677a.f12300g = d12;
                c3677a.f12301h = d14;
                double dHypot = Math.hypot(d18, d17);
                c3677a.f12295b = dHypot;
                c3677a.f12307n = dHypot * d16;
                c3677a.f12305l = d17 / d15;
                c3677a.f12306m = d18 / d15;
            } else {
                c3677a.f12294a = new double[101];
                c3677a.f12303j = ((double) (z7 ? -1 : 1)) * d17;
                c3677a.f12304k = d18 * ((double) (z7 ? 1 : -1));
                c3677a.f12305l = z7 ? d13 : d11;
                c3677a.f12306m = z7 ? d12 : d14;
                double d19 = d12 - d14;
                int i18 = 0;
                double dHypot2 = 0.0d;
                double d20 = 0.0d;
                double d21 = 0.0d;
                while (true) {
                    dArr3 = C3677a.f12293s;
                    if (i18 >= 91) {
                        break;
                    }
                    double radians = Math.toRadians((((double) i18) * 90.0d) / ((double) 90));
                    double dSin = Math.sin(radians) * d17;
                    double dCos = Math.cos(radians) * d19;
                    if (i18 > 0) {
                        dHypot2 += Math.hypot(dSin - d20, dCos - d21);
                        dArr3[i18] = dHypot2;
                    }
                    i18++;
                    d21 = dCos;
                    d20 = dSin;
                    d19 = d19;
                }
                c3677a.f12295b = dHypot2;
                for (int i19 = 0; i19 < 91; i19++) {
                    dArr3[i19] = dArr3[i19] / dHypot2;
                }
                int i20 = 0;
                while (true) {
                    double[] dArr7 = c3677a.f12294a;
                    if (i20 >= dArr7.length) {
                        break;
                    }
                    double length = ((double) i20) / ((double) (dArr7.length - 1));
                    int iBinarySearch = Arrays.binarySearch(dArr3, length);
                    if (iBinarySearch >= 0) {
                        dArr7[i20] = iBinarySearch / 90;
                    } else if (iBinarySearch == -1) {
                        dArr7[i20] = 0.0d;
                    } else {
                        int i21 = -iBinarySearch;
                        int i22 = i21 - 2;
                        double d22 = dArr3[i22];
                        dArr7[i20] = (((length - d22) / (dArr3[i21 - 1] - d22)) + ((double) i22)) / ((double) 90);
                    }
                    i20++;
                }
                c3677a.f12307n = c3677a.f12295b * c3677a.f12302i;
            }
            c3677aArr[i15] = c3677a;
            c3678b = this;
            dArr4 = dArr;
            i12 = i17;
            i10 = i14;
            i11 = i16;
            r10 = 0;
            i6 = 1;
        }
    }
}

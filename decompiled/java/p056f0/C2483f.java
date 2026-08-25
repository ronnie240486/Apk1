package p056f0;

import android.graphics.Path;
import android.util.Log;
import androidx.media3.container.MdtaMetadataEntry;
import com.bumptech.glide.AbstractC1466d;

public final class C2483f {

    public char f8686a;

    public final float[] f8687b;

    public C2483f(char c5, float[] fArr) {
        this.f8686a = c5;
        this.f8687b = fArr;
    }

    public static void m5519a(Path path, float f, float f3, float f4, float f5, float f10, float f11, float f12, boolean z7, boolean z10) {
        double d;
        double d10;
        double radians = Math.toRadians(f12);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d11 = f;
        double d12 = f3;
        double d13 = (d12 * dSin) + (d11 * dCos);
        double d14 = d11;
        double d15 = f10;
        double d16 = d13 / d15;
        double d17 = f11;
        double d18 = ((d12 * dCos) + (((double) (-f)) * dSin)) / d17;
        double d19 = d12;
        double d20 = f5;
        double d21 = ((d20 * dSin) + (((double) f4) * dCos)) / d15;
        double d22 = ((d20 * dCos) + (((double) (-f4)) * dSin)) / d17;
        double d23 = d16 - d21;
        double d24 = d18 - d22;
        double d25 = (d16 + d21) / 2.0d;
        double d26 = (d18 + d22) / 2.0d;
        double d27 = (d24 * d24) + (d23 * d23);
        if (d27 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d28 = (1.0d / d27) - 0.25d;
        if (d28 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d27);
            float fSqrt = (float) (Math.sqrt(d27) / 1.99999d);
            m5519a(path, f, f3, f4, f5, f10 * fSqrt, f11 * fSqrt, f12, z7, z10);
            return;
        }
        double dSqrt = Math.sqrt(d28);
        double d29 = d23 * dSqrt;
        double d30 = dSqrt * d24;
        if (z7 == z10) {
            d = d25 - d30;
            d10 = d26 + d29;
        } else {
            d = d25 + d30;
            d10 = d26 - d29;
        }
        double dAtan2 = Math.atan2(d18 - d10, d16 - d);
        double dAtan3 = Math.atan2(d22 - d10, d21 - d) - dAtan2;
        int i6 = 0;
        if (z10 != (dAtan3 >= 0.0d)) {
            dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
        }
        double d31 = d * d15;
        double d32 = d10 * d17;
        double d33 = (d31 * dCos) - (d32 * dSin);
        double d34 = (d32 * dCos) + (d31 * dSin);
        int iCeil = (int) Math.ceil(Math.abs((dAtan3 * 4.0d) / 3.141592653589793d));
        double dCos2 = Math.cos(radians);
        double dSin2 = Math.sin(radians);
        double dCos3 = Math.cos(dAtan2);
        double dSin3 = Math.sin(dAtan2);
        double d35 = -d15;
        double d36 = d35 * dCos2;
        double d37 = d17 * dSin2;
        double d38 = (d36 * dSin3) - (d37 * dCos3);
        double d39 = d35 * dSin2;
        double d40 = d17 * dCos2;
        double d41 = (dCos3 * d40) + (dSin3 * d39);
        double d42 = dAtan3 / ((double) iCeil);
        double d43 = dAtan2;
        while (i6 < iCeil) {
            double d44 = d43 + d42;
            double dSin4 = Math.sin(d44);
            double dCos4 = Math.cos(d44);
            double d45 = d42;
            double d46 = (((d15 * dCos2) * dCos4) + d33) - (d37 * dSin4);
            double d47 = d33;
            double d48 = (d40 * dSin4) + (d15 * dSin2 * dCos4) + d34;
            double d49 = (d36 * dSin4) - (d37 * dCos4);
            double d50 = (dCos4 * d40) + (dSin4 * d39);
            double d51 = d44 - d43;
            double dTan = Math.tan(d51 / 2.0d);
            double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d51)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d38 * dSqrt2) + d14), (float) ((d41 * dSqrt2) + d19), (float) (d46 - (dSqrt2 * d49)), (float) (d48 - (dSqrt2 * d50)), (float) d46, (float) d48);
            i6++;
            d40 = d40;
            d39 = d39;
            iCeil = iCeil;
            dCos2 = dCos2;
            d43 = d44;
            d15 = d15;
            d41 = d50;
            d38 = d49;
            d14 = d46;
            d19 = d48;
            d42 = d45;
            d33 = d47;
        }
    }

    public static void m5520b(C2483f[] c2483fArr, Path path) {
        int i6;
        int i10;
        float f;
        float f3;
        float f4;
        float f5;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        C2483f[] c2483fArr2 = c2483fArr;
        float[] fArr = new float[6];
        int length = c2483fArr2.length;
        char c5 = 'm';
        int i11 = 0;
        while (i11 < length) {
            C2483f c2483f = c2483fArr2[i11];
            char c8 = c2483f.f8686a;
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f20 = fArr[2];
            float f21 = fArr[3];
            float f22 = fArr[4];
            float f23 = fArr[5];
            switch (c8) {
                case 'A':
                case 'a':
                    i6 = 7;
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32:
                case 'c':
                    i6 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i6 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i6 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f22, f23);
                    f18 = f22;
                    f20 = f18;
                    f19 = f23;
                    f21 = f19;
                default:
                    i6 = 2;
                    break;
            }
            float f24 = f22;
            float f25 = f23;
            float f26 = f18;
            float f27 = f19;
            int i12 = 0;
            while (true) {
                float[] fArr2 = c2483f.f8687b;
                if (i12 < fArr2.length) {
                    if (c8 != 'A') {
                        if (c8 != 'C') {
                            if (c8 == 'H') {
                                i10 = i12;
                                c8 = c8;
                                i11 = i11;
                                length = length;
                                c2483f = c2483f;
                                path.lineTo(fArr2[i10], f27);
                                f26 = fArr2[i10];
                            } else if (c8 == 'Q') {
                                i10 = i12;
                                float f28 = fArr2[i10];
                                int i13 = i10 + 1;
                                float f29 = fArr2[i13];
                                int i14 = i10 + 2;
                                int i15 = i10 + 3;
                                path.quadTo(f28, f29, fArr2[i14], fArr2[i15]);
                                f = fArr2[i10];
                                f3 = fArr2[i13];
                                f26 = fArr2[i14];
                                f27 = fArr2[i15];
                            } else if (c8 == 'V') {
                                i10 = i12;
                                c8 = c8;
                                i11 = i11;
                                length = length;
                                c2483f = c2483f;
                                path.lineTo(f26, fArr2[i10]);
                                f27 = fArr2[i10];
                            } else if (c8 != 'a') {
                                if (c8 != 'c') {
                                    if (c8 != 'h') {
                                        if (c8 == 'q') {
                                            i10 = i12;
                                            float f30 = f27;
                                            float f31 = f26;
                                            int i16 = i10 + 1;
                                            int i17 = i10 + 2;
                                            int i18 = i10 + 3;
                                            path.rQuadTo(fArr2[i10], fArr2[i16], fArr2[i17], fArr2[i18]);
                                            float f32 = f31 + fArr2[i10];
                                            float f33 = fArr2[i16] + f30;
                                            float f34 = f31 + fArr2[i17];
                                            f27 = f30 + fArr2[i18];
                                            f21 = f33;
                                            f20 = f32;
                                            f26 = f34;
                                        } else if (c8 == 'v') {
                                            i10 = i12;
                                            path.rLineTo(0.0f, fArr2[i10]);
                                            f27 += fArr2[i10];
                                        } else if (c8 == 'L') {
                                            i10 = i12;
                                            int i19 = i10 + 1;
                                            path.lineTo(fArr2[i10], fArr2[i19]);
                                            f26 = fArr2[i10];
                                            f27 = fArr2[i19];
                                        } else if (c8 == 'M') {
                                            i10 = i12;
                                            f26 = fArr2[i10];
                                            f27 = fArr2[i10 + 1];
                                            if (i10 > 0) {
                                                path.lineTo(f26, f27);
                                            } else {
                                                path.moveTo(f26, f27);
                                                f25 = f27;
                                                f24 = f26;
                                            }
                                        } else if (c8 == 'S') {
                                            i10 = i12;
                                            float f35 = f27;
                                            float f36 = f26;
                                            if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                                f12 = (f35 * 2.0f) - f21;
                                                f13 = (f36 * 2.0f) - f20;
                                            } else {
                                                f13 = f36;
                                                f12 = f35;
                                            }
                                            int i20 = i10 + 1;
                                            int i21 = i10 + 2;
                                            int i22 = i10 + 3;
                                            path.cubicTo(f13, f12, fArr2[i10], fArr2[i20], fArr2[i21], fArr2[i22]);
                                            float f37 = fArr2[i10];
                                            float f38 = fArr2[i20];
                                            f26 = fArr2[i21];
                                            f27 = fArr2[i22];
                                            f21 = f38;
                                            f20 = f37;
                                        } else if (c8 == 'T') {
                                            i10 = i12;
                                            float f39 = f27;
                                            float f40 = f26;
                                            if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                                f4 = (f40 * 2.0f) - f20;
                                                f5 = (f39 * 2.0f) - f21;
                                            } else {
                                                f4 = f40;
                                                f5 = f39;
                                            }
                                            int i23 = i10 + 1;
                                            path.quadTo(f4, f5, fArr2[i10], fArr2[i23]);
                                            f10 = fArr2[i10];
                                            f11 = fArr2[i23];
                                        } else if (c8 == 'l') {
                                            i10 = i12;
                                            int i24 = i10 + 1;
                                            path.rLineTo(fArr2[i10], fArr2[i24]);
                                            f26 += fArr2[i10];
                                            f27 += fArr2[i24];
                                        } else if (c8 == 'm') {
                                            i10 = i12;
                                            float f41 = fArr2[i10];
                                            f26 += f41;
                                            float f42 = fArr2[i10 + 1];
                                            f27 += f42;
                                            if (i10 > 0) {
                                                path.rLineTo(f41, f42);
                                            } else {
                                                path.rMoveTo(f41, f42);
                                                f25 = f27;
                                                f24 = f26;
                                            }
                                        } else if (c8 == 's') {
                                            if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                                float f43 = f26 - f20;
                                                f14 = f27 - f21;
                                                f15 = f43;
                                            } else {
                                                f14 = 0.0f;
                                                f15 = 0.0f;
                                            }
                                            int i25 = i12 + 1;
                                            int i26 = i12 + 2;
                                            int i27 = i12 + 3;
                                            i10 = i12;
                                            float f44 = f27;
                                            float f45 = f26;
                                            path.rCubicTo(f15, f14, fArr2[i12], fArr2[i25], fArr2[i26], fArr2[i27]);
                                            f4 = f45 + fArr2[i10];
                                            f5 = f44 + fArr2[i25];
                                            f10 = f45 + fArr2[i26];
                                            f11 = fArr2[i27] + f44;
                                        } else if (c8 != 't') {
                                            i10 = i12;
                                        } else {
                                            if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                                f16 = f26 - f20;
                                                f17 = f27 - f21;
                                            } else {
                                                f17 = 0.0f;
                                                f16 = 0.0f;
                                            }
                                            int i28 = i12 + 1;
                                            path.rQuadTo(f16, f17, fArr2[i12], fArr2[i28]);
                                            float f46 = f16 + f26;
                                            float f47 = f17 + f27;
                                            f26 += fArr2[i12];
                                            f27 += fArr2[i28];
                                            f21 = f47;
                                            i10 = i12;
                                            f20 = f46;
                                        }
                                        c2483f = c2483f;
                                    } else {
                                        i10 = i12;
                                        path.rLineTo(fArr2[i10], 0.0f);
                                        f26 += fArr2[i10];
                                    }
                                    c2483f = c2483f;
                                } else {
                                    i10 = i12;
                                    float f48 = f27;
                                    float f49 = f26;
                                    int i29 = i10 + 2;
                                    int i30 = i10 + 3;
                                    int i31 = i10 + 4;
                                    int i32 = i10 + 5;
                                    path.rCubicTo(fArr2[i10], fArr2[i10 + 1], fArr2[i29], fArr2[i30], fArr2[i31], fArr2[i32]);
                                    f4 = f49 + fArr2[i29];
                                    f5 = f48 + fArr2[i30];
                                    f10 = f49 + fArr2[i31];
                                    f11 = fArr2[i32] + f48;
                                }
                                f21 = f5;
                                f20 = f4;
                                f26 = f10;
                                f27 = f11;
                                c2483f = c2483f;
                            } else {
                                i10 = i12;
                                float f50 = f27;
                                float f51 = f26;
                                int i33 = i10 + 5;
                                int i34 = i10 + 6;
                                m5519a(path, f51, f50, fArr2[i33] + f51, fArr2[i34] + f50, fArr2[i10], fArr2[i10 + 1], fArr2[i10 + 2], fArr2[i10 + 3] != 0.0f, fArr2[i10 + 4] != 0.0f);
                                f26 = f51 + fArr2[i33];
                                f27 = f50 + fArr2[i34];
                            }
                            i12 = i10 + i6;
                            c2483f = c2483f;
                            length = length;
                            c5 = c8;
                            c8 = c5;
                            i11 = i11;
                        } else {
                            i10 = i12;
                            int i35 = i10 + 2;
                            int i36 = i10 + 3;
                            int i37 = i10 + 4;
                            int i38 = i10 + 5;
                            path.cubicTo(fArr2[i10], fArr2[i10 + 1], fArr2[i35], fArr2[i36], fArr2[i37], fArr2[i38]);
                            f26 = fArr2[i37];
                            f27 = fArr2[i38];
                            f = fArr2[i35];
                            f3 = fArr2[i36];
                        }
                        f20 = f;
                        f21 = f3;
                        i12 = i10 + i6;
                        c2483f = c2483f;
                        length = length;
                        c5 = c8;
                        c8 = c5;
                        i11 = i11;
                    } else {
                        i10 = i12;
                        int i39 = i10 + 5;
                        int i40 = i10 + 6;
                        m5519a(path, f26, f27, fArr2[i39], fArr2[i40], fArr2[i10], fArr2[i10 + 1], fArr2[i10 + 2], fArr2[i10 + 3] != 0.0f, fArr2[i10 + 4] != 0.0f);
                        f26 = fArr2[i39];
                        f27 = fArr2[i40];
                    }
                    f21 = f27;
                    f20 = f26;
                    i12 = i10 + i6;
                    c2483f = c2483f;
                    length = length;
                    c5 = c8;
                    c8 = c5;
                    i11 = i11;
                }
            }
            fArr[0] = f26;
            fArr[1] = f27;
            fArr[2] = f20;
            fArr[3] = f21;
            fArr[4] = f24;
            fArr[5] = f25;
            c5 = c2483f.f8686a;
            i11++;
            c2483fArr2 = c2483fArr;
            length = length;
        }
    }

    public C2483f(C2483f c2483f) {
        this.f8686a = c2483f.f8686a;
        float[] fArr = c2483f.f8687b;
        this.f8687b = AbstractC1466d.m3487e(fArr, fArr.length);
    }
}

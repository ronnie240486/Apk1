package p046e0;

import android.graphics.Color;
import p056f0.AbstractC2478a;

public final class C2342a {

    public float f8179a;

    public float f8180b;

    public float f8181c;

    public float f8182d;

    public float f8183e;

    public float f8184f;

    public C2342a(float f, float f3, float f4, float f5, float f10, float f11) {
        this.f8179a = f;
        this.f8180b = f3;
        this.f8181c = f4;
        this.f8182d = f5;
        this.f8183e = f10;
        this.f8184f = f11;
    }

    public static C2342a m5312b(int i6) {
        C2356o c2356o = C2356o.f8212k;
        float fM5321g = AbstractC2343b.m5321g(Color.red(i6));
        float fM5321g2 = AbstractC2343b.m5321g(Color.green(i6));
        float fM5321g3 = AbstractC2343b.m5321g(Color.blue(i6));
        float[][] fArr = AbstractC2343b.f8188d;
        float[] fArr2 = fArr[0];
        float f = (fArr2[2] * fM5321g3) + (fArr2[1] * fM5321g2) + (fArr2[0] * fM5321g);
        float[] fArr3 = fArr[1];
        float f3 = (fArr3[2] * fM5321g3) + (fArr3[1] * fM5321g2) + (fArr3[0] * fM5321g);
        float[] fArr4 = fArr[2];
        float f4 = (fM5321g3 * fArr4[2]) + (fM5321g2 * fArr4[1]) + (fM5321g * fArr4[0]);
        float[][] fArr5 = AbstractC2343b.f8185a;
        float[] fArr6 = fArr5[0];
        float f5 = (fArr6[2] * f4) + (fArr6[1] * f3) + (fArr6[0] * f);
        float[] fArr7 = fArr5[1];
        float f10 = (fArr7[2] * f4) + (fArr7[1] * f3) + (fArr7[0] * f);
        float[] fArr8 = fArr5[2];
        float f11 = (f4 * fArr8[2]) + (f3 * fArr8[1]) + (f * fArr8[0]);
        float[] fArr9 = c2356o.f8219g;
        float f12 = fArr9[0] * f5;
        float f13 = fArr9[1] * f10;
        float f14 = fArr9[2] * f11;
        float fAbs = Math.abs(f12);
        float f15 = c2356o.f8220h;
        float fPow = (float) Math.pow(((double) (fAbs * f15)) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (Math.abs(f13) * f15)) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (Math.abs(f14) * f15)) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f12) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f13) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f14) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d = fSignum3;
        float f16 = ((float) (((((double) fSignum2) * (-12.0d)) + (((double) fSignum) * 11.0d)) + d)) / 11.0f;
        float f17 = ((float) (((double) (fSignum + fSignum2)) - (d * 2.0d))) / 9.0f;
        float f18 = fSignum2 * 20.0f;
        float f19 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f18)) / 20.0f;
        float f20 = (((fSignum * 40.0f) + f18) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f17, f16)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f21 = fAtan2;
        float f22 = (3.1415927f * f21) / 180.0f;
        float f23 = f20 * c2356o.f8214b;
        float f24 = c2356o.f8213a;
        float f25 = c2356o.f8216d;
        float fPow4 = ((float) Math.pow(f23 / f24, c2356o.f8222j * f25)) * 100.0f;
        Math.sqrt(fPow4 / 100.0f);
        float f26 = f24 + 4.0f;
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, c2356o.f8218f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) f21) < 20.14d ? 360.0f + f21 : f21)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * c2356o.f8217e) * c2356o.f8215c) * ((float) Math.sqrt((f17 * f17) + (f16 * f16)))) / (f19 + 0.305f), 0.9d));
        float fSqrt = fPow5 * ((float) Math.sqrt(((double) fPow4) / 100.0d));
        float f27 = c2356o.f8221i * fSqrt;
        Math.sqrt((fPow5 * f25) / f26);
        float f28 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((f27 * 0.0228f) + 1.0f)) * 43.85965f;
        double d10 = f22;
        return new C2342a(f21, fSqrt, fPow4, f28, fLog * ((float) Math.cos(d10)), fLog * ((float) Math.sin(d10)));
    }

    public static C2342a m5313c(float f, float f3, float f4) {
        C2356o c2356o = C2356o.f8212k;
        float f5 = c2356o.f8216d;
        double d = ((double) f) / 100.0d;
        Math.sqrt(d);
        float f10 = c2356o.f8213a + 4.0f;
        float f11 = c2356o.f8221i * f3;
        Math.sqrt(((f3 / ((float) Math.sqrt(d))) * c2356o.f8216d) / f10);
        float f12 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float fLog = ((float) Math.log((((double) f11) * 0.0228d) + 1.0d)) * 43.85965f;
        double d10 = (3.1415927f * f4) / 180.0f;
        return new C2342a(f4, f3, f, f12, fLog * ((float) Math.cos(d10)), fLog * ((float) Math.sin(d10)));
    }

    public void m5314a(float f, float f3, int i6, int i10, float[] fArr) {
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f10 = (f - 0.5f) * 2.0f;
        float f11 = (f3 - 0.5f) * 2.0f;
        float f12 = f4 + this.f8181c;
        float f13 = f5 + this.f8182d;
        float f14 = (this.f8179a * f10) + f12;
        float f15 = (this.f8180b * f11) + f13;
        float radians = (float) Math.toRadians(this.f8184f);
        float radians2 = (float) Math.toRadians(this.f8183e);
        double d = radians;
        double d10 = i10 * f11;
        float fSin = (((float) ((Math.sin(d) * ((double) ((-i6) * f10))) - (Math.cos(d) * d10))) * radians2) + f14;
        float fCos = (radians2 * ((float) ((Math.cos(d) * ((double) (i6 * f10))) - (Math.sin(d) * d10)))) + f15;
        fArr[0] = fSin;
        fArr[1] = fCos;
    }

    public int m5315d(C2356o c2356o) {
        float fSqrt;
        float f = this.f8180b;
        double d = f;
        float f3 = this.f8181c;
        if (d != 0.0d) {
            double d10 = f3;
            if (d10 == 0.0d) {
                fSqrt = 0.0f;
            } else {
                fSqrt = f / ((float) Math.sqrt(d10 / 100.0d));
            }
        } else {
            fSqrt = 0.0f;
        }
        float fPow = (float) Math.pow(((double) fSqrt) / Math.pow(1.64d - Math.pow(0.29d, c2356o.f8218f), 0.73d), 1.1111111111111112d);
        double d11 = (this.f8179a * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + d11) + 3.8d)) * 0.25f;
        float fPow2 = c2356o.f8213a * ((float) Math.pow(((double) f3) / 100.0d, (1.0d / ((double) c2356o.f8216d)) / ((double) c2356o.f8222j)));
        float f4 = fCos * 3846.1538f * c2356o.f8217e * c2356o.f8215c;
        float f5 = fPow2 / c2356o.f8214b;
        float fSin = (float) Math.sin(d11);
        float fCos2 = (float) Math.cos(d11);
        float f10 = (((0.305f + f5) * 23.0f) * fPow) / (((fPow * 108.0f) * fSin) + (((11.0f * fPow) * fCos2) + (f4 * 23.0f)));
        float f11 = fCos2 * f10;
        float f12 = f10 * fSin;
        float f13 = f5 * 460.0f;
        float f14 = ((288.0f * f12) + ((451.0f * f11) + f13)) / 1403.0f;
        float f15 = ((f13 - (891.0f * f11)) - (261.0f * f12)) / 1403.0f;
        float f16 = ((f13 - (f11 * 220.0f)) - (f12 * 6300.0f)) / 1403.0f;
        float fMax = (float) Math.max(0.0d, (((double) Math.abs(f14)) * 27.13d) / (400.0d - ((double) Math.abs(f14))));
        float fSignum = Math.signum(f14);
        float f17 = 100.0f / c2356o.f8220h;
        float fPow3 = fSignum * f17 * ((float) Math.pow(fMax, 2.380952380952381d));
        float fSignum2 = Math.signum(f15) * f17 * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f15)) * 27.13d) / (400.0d - ((double) Math.abs(f15)))), 2.380952380952381d));
        float fSignum3 = Math.signum(f16) * f17 * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f16)) * 27.13d) / (400.0d - ((double) Math.abs(f16)))), 2.380952380952381d));
        float[] fArr = c2356o.f8219g;
        float f18 = fPow3 / fArr[0];
        float f19 = fSignum2 / fArr[1];
        float f20 = fSignum3 / fArr[2];
        float[][] fArr2 = AbstractC2343b.f8186b;
        float[] fArr3 = fArr2[0];
        float f21 = (fArr3[2] * f20) + (fArr3[1] * f19) + (fArr3[0] * f18);
        float[] fArr4 = fArr2[1];
        float f22 = (fArr4[2] * f20) + (fArr4[1] * f19) + (fArr4[0] * f18);
        float[] fArr5 = fArr2[2];
        return AbstractC2478a.m5507b(f21, f22, (f20 * fArr5[2]) + (f19 * fArr5[1]) + (f18 * fArr5[0]));
    }
}

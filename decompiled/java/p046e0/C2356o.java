package p046e0;

public final class C2356o {

    public static final C2356o f8212k;

    public final float f8213a;

    public final float f8214b;

    public final float f8215c;

    public final float f8216d;

    public final float f8217e;

    public final float f8218f;

    public final float[] f8219g;

    public final float f8220h;

    public final float f8221i;

    public final float f8222j;

    static {
        float[] fArr = AbstractC2343b.f8187c;
        float fM5327o = (float) ((((double) AbstractC2343b.m5327o()) * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = AbstractC2343b.f8185a;
        float f = fArr[0];
        float[] fArr3 = fArr2[0];
        float f3 = fArr3[0] * f;
        float f4 = fArr[1];
        float f5 = (fArr3[1] * f4) + f3;
        float f10 = fArr[2];
        float f11 = (fArr3[2] * f10) + f5;
        float[] fArr4 = fArr2[1];
        float f12 = (fArr4[2] * f10) + (fArr4[1] * f4) + (fArr4[0] * f);
        float[] fArr5 = fArr2[2];
        float f13 = (f10 * fArr5[2]) + (f4 * fArr5[1]) + (f * fArr5[0]);
        float f14 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float fExp = (1.0f - (((float) Math.exp(((-fM5327o) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d = fExp;
        if (d > 1.0d) {
            fExp = 1.0f;
        } else if (d < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f11) * fExp) + 1.0f) - fExp, (((100.0f / f12) * fExp) + 1.0f) - fExp, (((100.0f / f13) * fExp) + 1.0f) - fExp};
        float f15 = 1.0f / ((5.0f * fM5327o) + 1.0f);
        float f16 = f15 * f15 * f15 * f15;
        float f17 = 1.0f - f16;
        float fCbrt = (0.1f * f17 * f17 * ((float) Math.cbrt(((double) fM5327o) * 5.0d))) + (f16 * fM5327o);
        float fM5327o2 = AbstractC2343b.m5327o() / fArr[1];
        double d10 = fM5327o2;
        float fSqrt = ((float) Math.sqrt(d10)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d10, 0.2d));
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * fCbrt) * f11)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * fCbrt) * f12)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[2] * fCbrt) * f13)) / 100.0d, 0.42d)};
        float f18 = fArr7[0];
        float f19 = (f18 * 400.0f) / (f18 + 27.13f);
        float f20 = fArr7[1];
        float f21 = (f20 * 400.0f) / (f20 + 27.13f);
        float f22 = fArr7[2];
        float[] fArr8 = {f19, f21, (400.0f * f22) / (f22 + 27.13f)};
        f8212k = new C2356o(fM5327o2, ((fArr8[2] * 0.05f) + (fArr8[0] * 2.0f) + fArr8[1]) * fPow, fPow, fPow, f14, 1.0f, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public C2356o(float f, float f3, float f4, float f5, float f10, float f11, float[] fArr, float f12, float f13, float f14) {
        this.f8218f = f;
        this.f8213a = f3;
        this.f8214b = f4;
        this.f8215c = f5;
        this.f8216d = f10;
        this.f8217e = f11;
        this.f8219g = fArr;
        this.f8220h = f12;
        this.f8221i = f13;
        this.f8222j = f14;
    }
}

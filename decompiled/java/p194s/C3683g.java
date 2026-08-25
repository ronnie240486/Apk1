package p194s;

import p205t.AbstractInterpolatorC3776p;

public final class C3683g extends AbstractInterpolatorC3776p {

    public float f12327a;

    public float f12328b;

    public float f12329c;

    public float f12330d;

    public float f12331e;

    public float f12332f;

    public float f12333g;

    public float f12334h;

    public float f12335i;

    public int f12336j;

    public boolean f12337k = false;

    public float f12338l;

    public float f12339m;

    @Override
    public final float mo7435a() {
        return this.f12337k ? -m7436b(this.f12339m) : m7436b(this.f12339m);
    }

    public final float m7436b(float f) {
        float f3;
        float f4;
        float f5 = this.f12330d;
        if (f <= f5) {
            f3 = this.f12327a;
            f4 = this.f12328b;
        } else {
            int i6 = this.f12336j;
            if (i6 == 1) {
                return 0.0f;
            }
            f -= f5;
            f5 = this.f12331e;
            if (f >= f5) {
                if (i6 == 2) {
                    return this.f12334h;
                }
                float f10 = f - f5;
                float f11 = this.f12332f;
                if (f10 >= f11) {
                    return this.f12335i;
                }
                float f12 = this.f12329c;
                return f12 - ((f10 * f12) / f11);
            }
            f3 = this.f12328b;
            f4 = this.f12329c;
        }
        return (((f4 - f3) * f) / f5) + f3;
    }

    public final void m7437c(float f, float f3, float f4, float f5, float f10) {
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        this.f12327a = f;
        float f11 = f / f4;
        float f12 = (f11 * f) / 2.0f;
        if (f < 0.0f) {
            float fSqrt = (float) Math.sqrt((f3 - ((((-f) / f4) * f) / 2.0f)) * f4);
            if (fSqrt < f5) {
                this.f12336j = 2;
                this.f12327a = f;
                this.f12328b = fSqrt;
                this.f12329c = 0.0f;
                float f13 = (fSqrt - f) / f4;
                this.f12330d = f13;
                this.f12331e = fSqrt / f4;
                this.f12333g = ((f + fSqrt) * f13) / 2.0f;
                this.f12334h = f3;
                this.f12335i = f3;
                return;
            }
            this.f12336j = 3;
            this.f12327a = f;
            this.f12328b = f5;
            this.f12329c = f5;
            float f14 = (f5 - f) / f4;
            this.f12330d = f14;
            float f15 = f5 / f4;
            this.f12332f = f15;
            float f16 = ((f + f5) * f14) / 2.0f;
            float f17 = (f15 * f5) / 2.0f;
            this.f12331e = ((f3 - f16) - f17) / f5;
            this.f12333g = f16;
            this.f12334h = f3 - f17;
            this.f12335i = f3;
            return;
        }
        if (f12 >= f3) {
            this.f12336j = 1;
            this.f12327a = f;
            this.f12328b = 0.0f;
            this.f12333g = f3;
            this.f12330d = (2.0f * f3) / f;
            return;
        }
        float f18 = f3 - f12;
        float f19 = f18 / f;
        if (f19 + f11 < f10) {
            this.f12336j = 2;
            this.f12327a = f;
            this.f12328b = f;
            this.f12329c = 0.0f;
            this.f12333g = f18;
            this.f12334h = f3;
            this.f12330d = f19;
            this.f12331e = f11;
            return;
        }
        float fSqrt2 = (float) Math.sqrt(((f * f) / 2.0f) + (f4 * f3));
        float f20 = (fSqrt2 - f) / f4;
        this.f12330d = f20;
        float f21 = fSqrt2 / f4;
        this.f12331e = f21;
        if (fSqrt2 < f5) {
            this.f12336j = 2;
            this.f12327a = f;
            this.f12328b = fSqrt2;
            this.f12329c = 0.0f;
            this.f12330d = f20;
            this.f12331e = f21;
            this.f12333g = ((f + fSqrt2) * f20) / 2.0f;
            this.f12334h = f3;
            return;
        }
        this.f12336j = 3;
        this.f12327a = f;
        this.f12328b = f5;
        this.f12329c = f5;
        float f22 = (f5 - f) / f4;
        this.f12330d = f22;
        float f23 = f5 / f4;
        this.f12332f = f23;
        float f24 = ((f + f5) * f22) / 2.0f;
        float f25 = (f23 * f5) / 2.0f;
        this.f12331e = ((f3 - f24) - f25) / f5;
        this.f12333g = f24;
        this.f12334h = f3 - f25;
        this.f12335i = f3;
    }

    @Override
    public final float getInterpolation(float f) {
        float f3;
        float f4 = this.f12330d;
        if (f <= f4) {
            float f5 = this.f12327a;
            f3 = ((((this.f12328b - f5) * f) * f) / (f4 * 2.0f)) + (f5 * f);
        } else {
            int i6 = this.f12336j;
            if (i6 == 1) {
                f3 = this.f12333g;
            } else {
                float f10 = f - f4;
                float f11 = this.f12331e;
                if (f10 < f11) {
                    float f12 = this.f12333g;
                    float f13 = this.f12328b;
                    f3 = ((((this.f12329c - f13) * f10) * f10) / (f11 * 2.0f)) + (f13 * f10) + f12;
                } else if (i6 == 2) {
                    f3 = this.f12334h;
                } else {
                    float f14 = f10 - f11;
                    float f15 = this.f12332f;
                    if (f14 < f15) {
                        float f16 = this.f12334h;
                        float f17 = this.f12329c * f14;
                        f3 = (f16 + f17) - ((f17 * f14) / (f15 * 2.0f));
                    } else {
                        f3 = this.f12335i;
                    }
                }
            }
        }
        this.f12339m = f;
        return this.f12337k ? this.f12338l - f3 : this.f12338l + f3;
    }
}

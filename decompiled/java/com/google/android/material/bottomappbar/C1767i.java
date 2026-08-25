package com.google.android.material.bottomappbar;

import p055ea.AbstractC2460q;
import p221u6.C3905e;
import p221u6.C3923w;

public final class C1767i extends C3905e implements Cloneable {

    public float f5952c;

    public float f5953d;

    public float f5954e;

    public float f5955f;

    public float f5956g;

    public float f5957h;

    @Override
    public final void mo4119g(float f, float f3, float f4, C3923w c3923w) {
        float f5;
        float f10;
        float f11 = this.f5954e;
        if (f11 == 0.0f) {
            c3923w.m7835d(f, 0.0f);
            return;
        }
        float f12 = ((this.f5953d * 2.0f) + f11) / 2.0f;
        float f13 = f4 * this.f5952c;
        float f14 = f3 + this.f5956g;
        float fM5490d = AbstractC2460q.m5490d(1.0f, f4, f12, this.f5955f * f4);
        if (fM5490d / f12 >= 1.0f) {
            c3923w.m7835d(f, 0.0f);
            return;
        }
        float f15 = this.f5957h;
        float f16 = f15 * f4;
        boolean z7 = f15 == -1.0f || Math.abs((f15 * 2.0f) - f11) < 0.1f;
        if (z7) {
            f5 = fM5490d;
            f10 = 0.0f;
        } else {
            f10 = 1.75f;
            f5 = 0.0f;
        }
        float f17 = f12 + f13;
        float f18 = f5 + f13;
        float fSqrt = (float) Math.sqrt((f17 * f17) - (f18 * f18));
        float f19 = f14 - fSqrt;
        float f20 = f14 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f18));
        float f21 = (90.0f - degrees) + f10;
        c3923w.m7835d(f19, 0.0f);
        float f22 = f13 * 2.0f;
        c3923w.m7832a(f19 - f13, 0.0f, f19 + f13, f22, 270.0f, degrees);
        if (z7) {
            c3923w.m7832a(f14 - f12, (-f12) - f5, f14 + f12, f12 - f5, 180.0f - f21, (f21 * 2.0f) - 180.0f);
        } else {
            float f23 = this.f5953d;
            float f24 = f16 * 2.0f;
            float f25 = f14 - f12;
            c3923w.m7832a(f25, -(f16 + f23), f25 + f23 + f24, f23 + f16, 180.0f - f21, ((f21 * 2.0f) - 180.0f) / 2.0f);
            float f26 = f14 + f12;
            float f27 = this.f5953d;
            c3923w.m7835d(f26 - ((f27 / 2.0f) + f16), f27 + f16);
            float f28 = this.f5953d;
            c3923w.m7832a(f26 - (f24 + f28), -(f16 + f28), f26, f28 + f16, 90.0f, f21 - 90.0f);
        }
        c3923w.m7832a(f20 - f13, 0.0f, f20 + f13, f22, 270.0f - degrees, degrees);
        c3923w.m7835d(f, 0.0f);
    }

    public final void m4120k(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f5955f = f;
    }
}

package com.google.android.material.navigation;

import android.animation.ValueAnimator;

public final class C1841a implements ValueAnimator.AnimatorUpdateListener {

    public final float f6518a;

    public final AbstractC1844d f6519b;

    public C1841a(AbstractC1844d abstractC1844d, float f) {
        this.f6519b = abstractC1844d;
        this.f6518a = f;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f6519b.m4295b(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f6518a);
    }
}

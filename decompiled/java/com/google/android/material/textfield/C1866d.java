package com.google.android.material.textfield;

import android.animation.ValueAnimator;

public final class C1866d implements ValueAnimator.AnimatorUpdateListener {

    public final int f6833a;

    public final C1867e f6834b;

    public C1866d(C1867e c1867e, int i6) {
        this.f6833a = i6;
        this.f6834b = c1867e;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f6833a) {
            case 0:
                this.f6834b.f6869c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                C1867e c1867e = this.f6834b;
                c1867e.f6869c.setScaleX(fFloatValue);
                c1867e.f6869c.setScaleY(fFloatValue);
                break;
        }
    }
}

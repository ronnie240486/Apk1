package com.google.android.material.slider;

import android.animation.ValueAnimator;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p262y5.AbstractC4268a;
import p273z6.C4357a;

public final class C1856b implements ValueAnimator.AnimatorUpdateListener {

    public final BaseSlider f6670a;

    public C1856b(BaseSlider baseSlider) {
        this.f6670a = baseSlider;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        BaseSlider baseSlider = this.f6670a;
        for (C4357a c4357a : baseSlider.f6642k) {
            c4357a.f14794L = 1.2f;
            c4357a.f14792J = fFloatValue;
            c4357a.f14793K = fFloatValue;
            c4357a.f14795M = AbstractC4268a.m8310b(0.0f, 1.0f, 0.19f, 1.0f, fFloatValue);
            c4357a.invalidateSelf();
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        baseSlider.postInvalidateOnAnimation();
    }
}

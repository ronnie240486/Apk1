package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import com.google.android.material.internal.AbstractC1811a0;
import p001a0.C0019b;
import p273z6.C4357a;

public final class C1857c extends AnimatorListenerAdapter {

    public final BaseSlider f6671a;

    public C1857c(BaseSlider baseSlider) {
        this.f6671a = baseSlider;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        BaseSlider baseSlider = this.f6671a;
        for (C4357a c4357a : baseSlider.f6642k) {
            ViewGroup viewGroupM4246f = AbstractC1811a0.m4246f(baseSlider);
            ((ViewOverlay) (viewGroupM4246f == null ? null : new C0019b(viewGroupM4246f)).f38b).remove(c4357a);
        }
    }
}

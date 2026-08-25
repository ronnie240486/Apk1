package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import com.google.android.gms.internal.cast.AbstractC1642o1;
import com.google.android.gms.internal.cast.C1603k1;

public final class C1496d extends AnimatorListenerAdapter {

    public final C1497e f4811a;

    public C1496d(C1497e c1497e) {
        this.f4811a = c1497e;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        AnimatorSet animatorSet = new AnimatorSet();
        C1497e c1497e = this.f4811a;
        InnerZoneDrawable innerZoneDrawable = c1497e.f4816e;
        ObjectAnimator duration = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", 1.0f, 1.1f).setDuration(500L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", 1.1f, 1.0f).setDuration(500L);
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(innerZoneDrawable, PropertyValuesHolder.ofFloat("pulseScale", 1.1f, 2.0f), PropertyValuesHolder.ofFloat("pulseAlpha", 1.0f, 0.0f)).setDuration(500L);
        animatorSet.play(duration);
        animatorSet.play(duration2).with(duration3).after(duration);
        animatorSet.setInterpolator(AbstractC1642o1.f5485c);
        animatorSet.setStartDelay(500L);
        animatorSet.addListener(new C1603k1(animatorSet));
        c1497e.f4818g = animatorSet;
        animatorSet.start();
    }
}

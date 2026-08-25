package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class C1749b implements ValueAnimator.AnimatorUpdateListener {

    public final CoordinatorLayout f5862a;

    public final AppBarLayout f5863b;

    public final AppBarLayout.BaseBehavior f5864c;

    public C1749b(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f5864c = baseBehavior;
        this.f5862a = coordinatorLayout;
        this.f5863b = appBarLayout;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f5864c.m4094B(this.f5862a, this.f5863b, iIntValue);
    }
}

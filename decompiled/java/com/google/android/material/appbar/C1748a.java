package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import java.util.Iterator;
import p221u6.C3908h;

public final class C1748a implements ValueAnimator.AnimatorUpdateListener {

    public final C3908h f5860a;

    public final AppBarLayout f5861b;

    public C1748a(AppBarLayout appBarLayout, C3908h c3908h) {
        this.f5861b = appBarLayout;
        this.f5860a = c3908h;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f5860a.m7808m(fFloatValue);
        AppBarLayout appBarLayout = this.f5861b;
        Drawable drawable = appBarLayout.f5794r;
        if (drawable instanceof C3908h) {
            ((C3908h) drawable).m7808m(fFloatValue);
        }
        Iterator it = appBarLayout.f5792p.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            throw null;
        }
    }
}

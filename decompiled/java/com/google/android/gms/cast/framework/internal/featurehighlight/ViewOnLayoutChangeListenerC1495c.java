package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Interpolator;
import com.google.android.gms.internal.cast.AbstractC1642o1;

public final class ViewOnLayoutChangeListenerC1495c implements View.OnLayoutChangeListener {

    public final C1497e f4810a;

    public ViewOnLayoutChangeListenerC1495c(C1497e c1497e) {
        this.f4810a = c1497e;
    }

    @Override
    public final void onLayoutChange(View view, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        C1497e c1497e = this.f4810a;
        if (c1497e.f4817f == null) {
            throw new IllegalStateException("Target view must be set before animation");
        }
        c1497e.setVisibility(0);
        ObjectAnimator duration = ObjectAnimator.ofFloat(c1497e.f4824m.asView(), "alpha", 0.0f, 1.0f).setDuration(350L);
        Interpolator interpolator = AbstractC1642o1.f5483a;
        duration.setInterpolator(interpolator);
        Rect rect = c1497e.f4813b;
        float fExactCenterX = rect.exactCenterX();
        OuterHighlightDrawable outerHighlightDrawable = c1497e.f4815d;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(outerHighlightDrawable, PropertyValuesHolder.ofFloat("scale", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationX", fExactCenterX - outerHighlightDrawable.f4802i, 0.0f), PropertyValuesHolder.ofFloat("translationY", rect.exactCenterY() - outerHighlightDrawable.f4803j, 0.0f), PropertyValuesHolder.ofInt("alpha", 0, outerHighlightDrawable.f4806m));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(interpolator);
        Animator duration2 = objectAnimatorOfPropertyValuesHolder.setDuration(350L);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(c1497e.f4816e, PropertyValuesHolder.ofFloat("scale", 0.0f, 1.0f), PropertyValuesHolder.ofInt("alpha", 0, 255));
        objectAnimatorOfPropertyValuesHolder2.setInterpolator(interpolator);
        Animator duration3 = objectAnimatorOfPropertyValuesHolder2.setDuration(350L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.addListener(new C1496d(c1497e));
        AnimatorSet animatorSet2 = c1497e.f4818g;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        c1497e.f4818g = animatorSet;
        animatorSet.start();
        c1497e.removeOnLayoutChangeListener(this);
    }
}

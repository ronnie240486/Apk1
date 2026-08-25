package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Rect;
import android.preference.PreferenceManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import com.google.android.gms.internal.cast.AbstractC1503a1;
import com.google.android.gms.internal.cast.AbstractC1642o1;
import com.google.android.gms.internal.cast.C1640o;
import com.google.android.gms.internal.cast.RunnableC1631n;
import org.bitspark.android.Spark;
import p002a1.C0026b;
import p007a7.C0067d;

public final class C1493a extends GestureDetector.SimpleOnGestureListener {

    public final C1497e f4807a;

    public C1493a(C1497e c1497e) {
        this.f4807a = c1497e;
    }

    @Override
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        C0026b c0026b;
        AnimatorSet animatorSet;
        int i6 = 1;
        float x10 = motionEvent.getX();
        float y7 = motionEvent.getY();
        C1497e c1497e = this.f4807a;
        if (c1497e.f4822k != null) {
            if (c1497e.f4814c.contains(Math.round(x10), Math.round(y7))) {
                OuterHighlightDrawable outerHighlightDrawable = c1497e.f4815d;
                if (AbstractC1503a1.m3691a(x10, y7, outerHighlightDrawable.f4802i, outerHighlightDrawable.f4803j) >= outerHighlightDrawable.f4800g) {
                    c0026b = c1497e.f4822k;
                    if (((C1640o) c0026b.f56d).f5479f) {
                        Spark spark = (Spark) c0026b.f54b;
                        PreferenceManager.getDefaultSharedPreferences(spark).edit().putBoolean("googlecast-introOverlayShown", true).apply();
                        RunnableC1631n runnableC1631n = new RunnableC1631n(c0026b, i6, spark);
                        C1497e c1497e2 = (C1497e) c0026b.f55c;
                        ObjectAnimator duration = ObjectAnimator.ofFloat(c1497e2.f4824m.asView(), "alpha", 0.0f).setDuration(200L);
                        Interpolator interpolator = AbstractC1642o1.f5484b;
                        duration.setInterpolator(interpolator);
                        Rect rect = c1497e2.f4813b;
                        float fExactCenterX = rect.exactCenterX();
                        OuterHighlightDrawable outerHighlightDrawable2 = c1497e2.f4815d;
                        float f = fExactCenterX - outerHighlightDrawable2.f4802i;
                        float fExactCenterY = rect.exactCenterY() - outerHighlightDrawable2.f4803j;
                        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(outerHighlightDrawable2, PropertyValuesHolder.ofFloat("scale", 0.0f), PropertyValuesHolder.ofFloat("translationX", 0.0f, f), PropertyValuesHolder.ofFloat("translationY", 0.0f, fExactCenterY), PropertyValuesHolder.ofInt("alpha", 0));
                        objectAnimatorOfPropertyValuesHolder.setInterpolator(interpolator);
                        Animator duration2 = objectAnimatorOfPropertyValuesHolder.setDuration(200L);
                        Animator animatorM3609a = c1497e2.f4816e.m3609a();
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        animatorSet2.playTogether(duration, duration2, animatorM3609a);
                        animatorSet2.addListener(new C0067d(2, c1497e2, runnableC1631n, false));
                        animatorSet = c1497e2.f4818g;
                        if (animatorSet != null) {
                            animatorSet.cancel();
                        }
                        c1497e2.f4818g = animatorSet2;
                        animatorSet2.start();
                    }
                }
            } else {
                c0026b = c1497e.f4822k;
                if (((C1640o) c0026b.f56d).f5479f) {
                    Spark spark2 = (Spark) c0026b.f54b;
                    PreferenceManager.getDefaultSharedPreferences(spark2).edit().putBoolean("googlecast-introOverlayShown", true).apply();
                    RunnableC1631n runnableC1631n2 = new RunnableC1631n(c0026b, i6, spark2);
                    C1497e c1497e3 = (C1497e) c0026b.f55c;
                    ObjectAnimator duration3 = ObjectAnimator.ofFloat(c1497e3.f4824m.asView(), "alpha", 0.0f).setDuration(200L);
                    Interpolator interpolator2 = AbstractC1642o1.f5484b;
                    duration3.setInterpolator(interpolator2);
                    Rect rect2 = c1497e3.f4813b;
                    float fExactCenterX2 = rect2.exactCenterX();
                    OuterHighlightDrawable outerHighlightDrawable3 = c1497e3.f4815d;
                    float f3 = fExactCenterX2 - outerHighlightDrawable3.f4802i;
                    float fExactCenterY2 = rect2.exactCenterY() - outerHighlightDrawable3.f4803j;
                    ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(outerHighlightDrawable3, PropertyValuesHolder.ofFloat("scale", 0.0f), PropertyValuesHolder.ofFloat("translationX", 0.0f, f3), PropertyValuesHolder.ofFloat("translationY", 0.0f, fExactCenterY2), PropertyValuesHolder.ofInt("alpha", 0));
                    objectAnimatorOfPropertyValuesHolder2.setInterpolator(interpolator2);
                    Animator duration4 = objectAnimatorOfPropertyValuesHolder2.setDuration(200L);
                    Animator animatorM3609a2 = c1497e3.f4816e.m3609a();
                    AnimatorSet animatorSet3 = new AnimatorSet();
                    animatorSet3.playTogether(duration3, duration4, animatorM3609a2);
                    animatorSet3.addListener(new C0067d(2, c1497e3, runnableC1631n2, false));
                    animatorSet = c1497e3.f4818g;
                    if (animatorSet != null) {
                        animatorSet.cancel();
                    }
                    c1497e3.f4818g = animatorSet3;
                    animatorSet3.start();
                }
            }
        }
        return true;
    }
}

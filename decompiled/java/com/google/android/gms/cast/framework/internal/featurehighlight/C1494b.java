package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.preference.PreferenceManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.mediarouter.app.MediaRouteButton;
import com.google.android.gms.internal.cast.AbstractC1642o1;
import com.google.android.gms.internal.cast.C1640o;
import com.google.android.gms.internal.cast.RunnableC1631n;
import org.bitspark.android.Spark;
import p002a1.C0026b;
import p007a7.C0067d;

public final class C1494b extends GestureDetector.SimpleOnGestureListener {

    public final MediaRouteButton f4808a;

    public final C0026b f4809b;

    public C1494b(MediaRouteButton mediaRouteButton, C0026b c0026b) {
        this.f4808a = mediaRouteButton;
        this.f4809b = c0026b;
    }

    @Override
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        MediaRouteButton mediaRouteButton = this.f4808a;
        if (mediaRouteButton.getParent() != null) {
            mediaRouteButton.performClick();
        }
        C0026b c0026b = this.f4809b;
        if (((C1640o) c0026b.f56d).f5479f) {
            Spark spark = (Spark) c0026b.f54b;
            PreferenceManager.getDefaultSharedPreferences(spark).edit().putBoolean("googlecast-introOverlayShown", true).apply();
            RunnableC1631n runnableC1631n = new RunnableC1631n(c0026b, 0, spark);
            C1497e c1497e = (C1497e) c0026b.f55c;
            ObjectAnimator duration = ObjectAnimator.ofFloat(c1497e.f4824m.asView(), "alpha", 0.0f).setDuration(200L);
            Interpolator interpolator = AbstractC1642o1.f5484b;
            duration.setInterpolator(interpolator);
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(c1497e.f4815d, PropertyValuesHolder.ofFloat("scale", 1.125f), PropertyValuesHolder.ofInt("alpha", 0));
            objectAnimatorOfPropertyValuesHolder.setInterpolator(interpolator);
            Animator duration2 = objectAnimatorOfPropertyValuesHolder.setDuration(200L);
            Animator animatorM3609a = c1497e.f4816e.m3609a();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(duration, duration2, animatorM3609a);
            animatorSet.addListener(new C0067d(1, c1497e, runnableC1631n, false));
            AnimatorSet animatorSet2 = c1497e.f4818g;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            c1497e.f4818g = animatorSet;
            animatorSet.start();
        }
        return true;
    }
}

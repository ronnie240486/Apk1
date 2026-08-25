package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import p138n0.ViewTreeObserverOnPreDrawListenerC3163v;

public final class RunnableC0435w extends AnimationSet implements Runnable {

    public final ViewGroup f2015a;

    public final View f2016b;

    public boolean f2017c;

    public boolean f2018d;

    public boolean f2019e;

    public RunnableC0435w(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f2019e = true;
        this.f2015a = viewGroup;
        this.f2016b = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override
    public final boolean getTransformation(long j10, Transformation transformation) {
        this.f2019e = true;
        if (this.f2017c) {
            return !this.f2018d;
        }
        if (!super.getTransformation(j10, transformation)) {
            this.f2017c = true;
            ViewTreeObserverOnPreDrawListenerC3163v.m6358a(this.f2015a, this);
        }
        return true;
    }

    @Override
    public final void run() {
        boolean z7 = this.f2017c;
        ViewGroup viewGroup = this.f2015a;
        if (z7 || !this.f2019e) {
            viewGroup.endViewTransition(this.f2016b);
            this.f2018d = true;
        } else {
            this.f2019e = false;
            viewGroup.post(this);
        }
    }

    @Override
    public final boolean getTransformation(long j10, Transformation transformation, float f) {
        this.f2019e = true;
        if (this.f2017c) {
            return !this.f2018d;
        }
        if (!super.getTransformation(j10, transformation, f)) {
            this.f2017c = true;
            ViewTreeObserverOnPreDrawListenerC3163v.m6358a(this.f2015a, this);
        }
        return true;
    }
}

package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Property;
import android.view.View;
import com.p2serv.android.p032ds.R;

public final class C0445f extends AnimatorListenerAdapter {

    public boolean f2047a = false;

    public float f2048b;

    public final View f2049c;

    public final float f2050d;

    public final float f2051e;

    public final int f2052f;

    public final Property f2053g;

    public C0445f(View view, Property property, float f, float f3, int i6) {
        this.f2053g = property;
        this.f2049c = view;
        this.f2051e = f;
        this.f2050d = f3;
        this.f2052f = i6;
        view.setVisibility(0);
    }

    @Override
    public final void onAnimationCancel(Animator animator) {
        View view = this.f2049c;
        view.setTag(R.id.lb_slide_transition_value, new float[]{view.getTranslationX(), view.getTranslationY()});
        this.f2053g.set(view, Float.valueOf(this.f2051e));
        this.f2047a = true;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        boolean z7 = this.f2047a;
        View view = this.f2049c;
        if (!z7) {
            this.f2053g.set(view, Float.valueOf(this.f2051e));
        }
        view.setVisibility(this.f2052f);
    }

    @Override
    public final void onAnimationPause(Animator animator) {
        Property property = this.f2053g;
        View view = this.f2049c;
        this.f2048b = ((Float) property.get(view)).floatValue();
        property.set(view, Float.valueOf(this.f2050d));
        view.setVisibility(this.f2052f);
    }

    @Override
    public final void onAnimationResume(Animator animator) {
        Float fValueOf = Float.valueOf(this.f2048b);
        Property property = this.f2053g;
        View view = this.f2049c;
        property.set(view, fValueOf);
        view.setVisibility(0);
    }
}

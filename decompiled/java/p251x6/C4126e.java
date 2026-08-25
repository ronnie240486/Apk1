package p251x6;

import android.animation.ValueAnimator;
import android.view.View;

public final class C4126e implements ValueAnimator.AnimatorUpdateListener {

    public final View f14016a;

    public final View f14017b;

    public final C4128g f14018c;

    public C4126e(C4128g c4128g, View view, View view2) {
        this.f14018c = c4128g;
        this.f14016a = view;
        this.f14017b = view2;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f14018c.m8143c(this.f14016a, this.f14017b, valueAnimator.getAnimatedFraction());
    }
}

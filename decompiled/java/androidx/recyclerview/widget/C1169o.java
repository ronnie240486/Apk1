package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

public final class C1169o implements ValueAnimator.AnimatorUpdateListener {

    public final C1172p f3634a;

    public C1169o(C1172p c1172p) {
        this.f3634a = c1172p;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        C1172p c1172p = this.f3634a;
        c1172p.f3648c.setAlpha(iFloatValue);
        c1172p.f3649d.setAlpha(iFloatValue);
        c1172p.f3664s.invalidate();
    }
}

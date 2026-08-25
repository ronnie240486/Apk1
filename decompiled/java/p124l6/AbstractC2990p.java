package p124l6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import p221u6.C3908h;

public abstract class AbstractC2990p extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

    public boolean f10250a;

    public float f10251b;

    public float f10252c;

    public final C2993s f10253d;

    public AbstractC2990p(C2993s c2993s) {
        this.f10253d = c2993s;
    }

    public abstract float mo6054a();

    @Override
    public final void onAnimationEnd(Animator animator) {
        float f = (int) this.f10252c;
        C3908h c3908h = this.f10253d.f10264b;
        if (c3908h != null) {
            c3908h.m7808m(f);
        }
        this.f10250a = false;
    }

    @Override
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        boolean z7 = this.f10250a;
        C2993s c2993s = this.f10253d;
        if (!z7) {
            C3908h c3908h = c2993s.f10264b;
            this.f10251b = c3908h == null ? 0.0f : c3908h.f13126a.f13119m;
            this.f10252c = mo6054a();
            this.f10250a = true;
        }
        float f = this.f10251b;
        float animatedFraction = (int) ((valueAnimator.getAnimatedFraction() * (this.f10252c - f)) + f);
        C3908h c3908h2 = c2993s.f10264b;
        if (c3908h2 != null) {
            c3908h2.m7808m(animatedFraction);
        }
    }
}

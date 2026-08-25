package p251x6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class C4127f extends AnimatorListenerAdapter {

    public final int f14019a;

    public final C4128g f14020b;

    public C4127f(C4128g c4128g, int i6) {
        this.f14020b = c4128g;
        this.f14019a = i6;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        this.f14020b.f14023b = this.f14019a;
    }

    @Override
    public final void onAnimationStart(Animator animator) {
        this.f14020b.f14023b = this.f14019a;
    }
}

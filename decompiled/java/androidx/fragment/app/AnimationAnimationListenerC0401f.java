package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

public final class AnimationAnimationListenerC0401f implements Animation.AnimationListener {

    public final ViewGroup f1839a;

    public final View f1840b;

    public final C0403g f1841c;

    public AnimationAnimationListenerC0401f(ViewGroup viewGroup, View view, C0403g c0403g) {
        this.f1839a = viewGroup;
        this.f1840b = view;
        this.f1841c = c0403g;
    }

    @Override
    public final void onAnimationEnd(Animation animation) {
        this.f1839a.post(new RunnableC0399e(0, this));
    }

    @Override
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override
    public final void onAnimationStart(Animation animation) {
    }
}

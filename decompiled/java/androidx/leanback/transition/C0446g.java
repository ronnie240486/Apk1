package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.transition.Transition;
import android.view.View;
import com.p2serv.android.p032ds.R;

public final class C0446g extends AnimatorListenerAdapter implements Transition.TransitionListener {

    public final View f2054a;

    public final View f2055b;

    public final int f2056c;

    public final int f2057d;

    public int[] f2058e;

    public float f2059f;

    public float f2060g;

    public final float f2061h;

    public final float f2062i;

    public C0446g(View view, View view2, int i6, int i10, float f, float f3) {
        this.f2055b = view;
        this.f2054a = view2;
        this.f2056c = i6 - Math.round(view.getTranslationX());
        this.f2057d = i10 - Math.round(view.getTranslationY());
        this.f2061h = f;
        this.f2062i = f3;
        int[] iArr = (int[]) view2.getTag(R.id.transitionPosition);
        this.f2058e = iArr;
        if (iArr != null) {
            view2.setTag(R.id.transitionPosition, null);
        }
    }

    @Override
    public final void onAnimationCancel(Animator animator) {
        if (this.f2058e == null) {
            this.f2058e = new int[2];
        }
        int[] iArr = this.f2058e;
        float f = this.f2056c;
        View view = this.f2055b;
        iArr[0] = Math.round(view.getTranslationX() + f);
        this.f2058e[1] = Math.round(view.getTranslationY() + this.f2057d);
        this.f2054a.setTag(R.id.transitionPosition, this.f2058e);
    }

    @Override
    public final void onAnimationPause(Animator animator) {
        View view = this.f2055b;
        this.f2059f = view.getTranslationX();
        this.f2060g = view.getTranslationY();
        view.setTranslationX(this.f2061h);
        view.setTranslationY(this.f2062i);
    }

    @Override
    public final void onAnimationResume(Animator animator) {
        float f = this.f2059f;
        View view = this.f2055b;
        view.setTranslationX(f);
        view.setTranslationY(this.f2060g);
    }

    @Override
    public final void onTransitionEnd(Transition transition) {
        float f = this.f2061h;
        View view = this.f2055b;
        view.setTranslationX(f);
        view.setTranslationY(this.f2062i);
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
    }

    @Override
    public final void onTransitionCancel(Transition transition) {
    }

    @Override
    public final void onTransitionPause(Transition transition) {
    }

    @Override
    public final void onTransitionResume(Transition transition) {
    }

    @Override
    public final void onTransitionStart(Transition transition) {
    }
}

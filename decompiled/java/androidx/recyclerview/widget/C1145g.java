package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

public final class C1145g extends AnimatorListenerAdapter {

    public final AbstractC1174p1 f3564a;

    public final int f3565b;

    public final View f3566c;

    public final int f3567d;

    public final ViewPropertyAnimator f3568e;

    public final C1157k f3569f;

    public C1145g(C1157k c1157k, AbstractC1174p1 abstractC1174p1, int i6, View view, int i10, ViewPropertyAnimator viewPropertyAnimator) {
        this.f3569f = c1157k;
        this.f3564a = abstractC1174p1;
        this.f3565b = i6;
        this.f3566c = view;
        this.f3567d = i10;
        this.f3568e = viewPropertyAnimator;
    }

    @Override
    public final void onAnimationCancel(Animator animator) {
        int i6 = this.f3565b;
        View view = this.f3566c;
        if (i6 != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f3567d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        this.f3568e.setListener(null);
        C1157k c1157k = this.f3569f;
        AbstractC1174p1 abstractC1174p1 = this.f3564a;
        c1157k.m2990c(abstractC1174p1);
        c1157k.f3609p.remove(abstractC1174p1);
        c1157k.m2958i();
    }

    @Override
    public final void onAnimationStart(Animator animator) {
        this.f3569f.getClass();
    }
}

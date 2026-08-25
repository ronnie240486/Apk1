package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

public final class C1148h extends AnimatorListenerAdapter {

    public final int f3573a;

    public final C1151i f3574b;

    public final ViewPropertyAnimator f3575c;

    public final View f3576d;

    public final C1157k f3577e;

    public C1148h(C1157k c1157k, C1151i c1151i, ViewPropertyAnimator viewPropertyAnimator, View view, int i6) {
        this.f3573a = i6;
        this.f3577e = c1157k;
        this.f3574b = c1151i;
        this.f3575c = viewPropertyAnimator;
        this.f3576d = view;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        switch (this.f3573a) {
            case 0:
                this.f3575c.setListener(null);
                View view = this.f3576d;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                C1151i c1151i = this.f3574b;
                AbstractC1174p1 abstractC1174p1 = c1151i.f3578a;
                C1157k c1157k = this.f3577e;
                c1157k.m2990c(abstractC1174p1);
                c1157k.f3611r.remove(c1151i.f3578a);
                c1157k.m2958i();
                break;
            default:
                this.f3575c.setListener(null);
                View view2 = this.f3576d;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                C1151i c1151i2 = this.f3574b;
                AbstractC1174p1 abstractC1174p2 = c1151i2.f3579b;
                C1157k c1157k2 = this.f3577e;
                c1157k2.m2990c(abstractC1174p2);
                c1157k2.f3611r.remove(c1151i2.f3579b);
                c1157k2.m2958i();
                break;
        }
    }

    @Override
    public final void onAnimationStart(Animator animator) {
        switch (this.f3573a) {
            case 0:
                AbstractC1174p1 abstractC1174p1 = this.f3574b.f3578a;
                this.f3577e.getClass();
                break;
            default:
                AbstractC1174p1 abstractC1174p2 = this.f3574b.f3579b;
                this.f3577e.getClass();
                break;
        }
    }
}

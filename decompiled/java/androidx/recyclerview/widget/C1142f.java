package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

public final class C1142f extends AnimatorListenerAdapter {

    public final int f3559a = 1;

    public final AbstractC1174p1 f3560b;

    public final View f3561c;

    public final ViewPropertyAnimator f3562d;

    public final C1157k f3563e;

    public C1142f(C1157k c1157k, AbstractC1174p1 abstractC1174p1, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f3563e = c1157k;
        this.f3560b = abstractC1174p1;
        this.f3562d = viewPropertyAnimator;
        this.f3561c = view;
    }

    @Override
    public void onAnimationCancel(Animator animator) {
        switch (this.f3559a) {
            case 1:
                this.f3561c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        switch (this.f3559a) {
            case 0:
                this.f3562d.setListener(null);
                this.f3561c.setAlpha(1.0f);
                C1157k c1157k = this.f3563e;
                AbstractC1174p1 abstractC1174p1 = this.f3560b;
                c1157k.m2990c(abstractC1174p1);
                c1157k.f3610q.remove(abstractC1174p1);
                c1157k.m2958i();
                break;
            default:
                this.f3562d.setListener(null);
                C1157k c1157k2 = this.f3563e;
                AbstractC1174p1 abstractC1174p2 = this.f3560b;
                c1157k2.m2990c(abstractC1174p2);
                c1157k2.f3608o.remove(abstractC1174p2);
                c1157k2.m2958i();
                break;
        }
    }

    @Override
    public final void onAnimationStart(Animator animator) {
        switch (this.f3559a) {
            case 0:
                this.f3563e.getClass();
                break;
            default:
                this.f3563e.getClass();
                break;
        }
    }

    public C1142f(C1157k c1157k, AbstractC1174p1 abstractC1174p1, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f3563e = c1157k;
        this.f3560b = abstractC1174p1;
        this.f3561c = view;
        this.f3562d = viewPropertyAnimator;
    }
}

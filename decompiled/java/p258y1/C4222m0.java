package p258y1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;

public final class C4222m0 extends AnimatorListenerAdapter implements InterfaceC4236y {

    public final View f14344a;

    public final int f14345b;

    public final ViewGroup f14346c;

    public boolean f14348e;

    public boolean f14349f = false;

    public final boolean f14347d = true;

    public C4222m0(View view, int i6) {
        this.f14344a = view;
        this.f14345b = i6;
        this.f14346c = (ViewGroup) view.getParent();
        m8268f(true);
    }

    @Override
    public final void mo8251b() {
        m8268f(false);
    }

    @Override
    public final void mo8252c() {
        m8268f(true);
    }

    @Override
    public final void mo8254e(Transition transition) {
        if (!this.f14349f) {
            AbstractC4210g0.m8258c(this.f14345b, this.f14344a);
            ViewGroup viewGroup = this.f14346c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        m8268f(false);
        transition.m3065u(this);
    }

    public final void m8268f(boolean z7) {
        ViewGroup viewGroup;
        if (!this.f14347d || this.f14348e == z7 || (viewGroup = this.f14346c) == null) {
            return;
        }
        this.f14348e = z7;
        AbstractC4233v.m8276j(viewGroup, z7);
    }

    @Override
    public final void onAnimationCancel(Animator animator) {
        this.f14349f = true;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        if (!this.f14349f) {
            AbstractC4210g0.m8258c(this.f14345b, this.f14344a);
            ViewGroup viewGroup = this.f14346c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        m8268f(false);
    }

    @Override
    public final void onAnimationPause(Animator animator) {
        if (this.f14349f) {
            return;
        }
        AbstractC4210g0.m8258c(this.f14345b, this.f14344a);
    }

    @Override
    public final void onAnimationResume(Animator animator) {
        if (this.f14349f) {
            return;
        }
        AbstractC4210g0.m8258c(0, this.f14344a);
    }

    @Override
    public final void mo8255a() {
    }

    @Override
    public final void mo8253d() {
    }

    @Override
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override
    public final void onAnimationStart(Animator animator) {
    }
}

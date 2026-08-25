package androidx.mediarouter.app;

import android.view.animation.Animation;

public final class AnimationAnimationListenerC1104o implements Animation.AnimationListener {

    public final int f3288a;

    public final Object f3289b;

    public AnimationAnimationListenerC1104o(int i6, Object obj) {
        this.f3288a = i6;
        this.f3289b = obj;
    }

    @Override
    public final void onAnimationEnd(Animation animation) {
        switch (this.f3288a) {
            case 0:
                break;
            case 1:
                ((DialogC1116u) this.f3289b).m2794m(true);
                break;
            default:
                DialogC1109q0 dialogC1109q0 = ((C1105o0) this.f3289b).f3299j;
                dialogC1109q0.f3345x = false;
                dialogC1109q0.m2780q();
                break;
        }
    }

    @Override
    public final void onAnimationRepeat(Animation animation) {
        int i6 = this.f3288a;
    }

    @Override
    public final void onAnimationStart(Animation animation) {
        switch (this.f3288a) {
            case 0:
                DialogC1116u dialogC1116u = (DialogC1116u) this.f3289b;
                OverlayListView overlayListView = dialogC1116u.f3369D;
                for (C1111r0 c1111r0 : overlayListView.f3174a) {
                    if (!c1111r0.f3358j) {
                        c1111r0.f3357i = overlayListView.getDrawingTime();
                        c1111r0.f3358j = true;
                    }
                }
                dialogC1116u.f3369D.postDelayed(dialogC1116u.f3415o0, dialogC1116u.f3401h0);
                break;
            case 1:
                break;
            default:
                ((C1105o0) this.f3289b).f3299j.f3345x = true;
                break;
        }
    }

    private final void m2762a(Animation animation) {
    }

    private final void m2763b(Animation animation) {
    }

    private final void m2764c(Animation animation) {
    }

    private final void m2765d(Animation animation) {
    }

    private final void m2766e(Animation animation) {
    }
}

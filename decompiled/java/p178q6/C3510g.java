package p178q6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class C3510g extends AnimatorListenerAdapter {

    public final int f11819a;

    public final C3511h f11820b;

    public C3510g(C3511h c3511h, int i6) {
        this.f11819a = i6;
        this.f11820b = c3511h;
    }

    @Override
    public void onAnimationEnd(Animator animator) {
        switch (this.f11819a) {
            case 1:
                super.onAnimationEnd(animator);
                C3511h c3511h = this.f11820b;
                c3511h.mo7155a();
                C3506c c3506c = c3511h.f11833k;
                if (c3506c != null) {
                    c3506c.m7147a();
                }
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override
    public void onAnimationRepeat(Animator animator) {
        switch (this.f11819a) {
            case 0:
                super.onAnimationRepeat(animator);
                C3511h c3511h = this.f11820b;
                c3511h.f11830h = (c3511h.f11830h + 4) % c3511h.f11829g.f11811c.length;
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }
}

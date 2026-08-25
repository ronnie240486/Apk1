package p178q6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class C3521r extends AnimatorListenerAdapter {

    public final int f11870a;

    public final C3522s f11871b;

    public C3521r(C3522s c3522s, int i6) {
        this.f11870a = i6;
        this.f11871b = c3522s;
    }

    @Override
    public void onAnimationEnd(Animator animator) {
        switch (this.f11870a) {
            case 1:
                super.onAnimationEnd(animator);
                C3522s c3522s = this.f11871b;
                c3522s.mo7155a();
                C3506c c3506c = c3522s.f11882k;
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
        switch (this.f11870a) {
            case 0:
                super.onAnimationRepeat(animator);
                C3522s c3522s = this.f11871b;
                c3522s.f11879h = (c3522s.f11879h + 1) % c3522s.f11878g.f11811c.length;
                c3522s.f11880i = true;
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }
}

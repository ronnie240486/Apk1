package p124l6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p156o9.AbstractC3281e;

public final class C2984j extends AnimatorListenerAdapter {

    public boolean f10229a;

    public final boolean f10230b;

    public final C2982h f10231c;

    public final AbstractC2991q f10232d;

    public C2984j(AbstractC2991q abstractC2991q, boolean z7, C2982h c2982h) {
        this.f10232d = abstractC2991q;
        this.f10230b = z7;
        this.f10231c = c2982h;
    }

    @Override
    public final void onAnimationCancel(Animator animator) {
        this.f10229a = true;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        AbstractC2991q abstractC2991q = this.f10232d;
        abstractC2991q.f10280r = 0;
        abstractC2991q.f10274l = null;
        if (this.f10229a) {
            return;
        }
        boolean z7 = this.f10230b;
        abstractC2991q.f10284v.m4235a(z7 ? 8 : 4, z7);
        C2982h c2982h = this.f10231c;
        if (c2982h != null) {
            ((AbstractC3281e) c2982h.f10225b).mo4118D((FloatingActionButton) c2982h.f10226c);
        }
    }

    @Override
    public final void onAnimationStart(Animator animator) {
        AbstractC2991q abstractC2991q = this.f10232d;
        abstractC2991q.f10284v.m4235a(0, this.f10230b);
        abstractC2991q.f10280r = 1;
        abstractC2991q.f10274l = animator;
        this.f10229a = false;
    }
}

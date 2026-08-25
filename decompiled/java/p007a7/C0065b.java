package p007a7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import p124l6.AbstractC2991q;
import p124l6.C2982h;
import p156o9.AbstractC3281e;

public final class C0065b extends AnimatorListenerAdapter {

    public final int f184a = 1;

    public final boolean f185b;

    public final Object f186c;

    public final Object f187d;

    public C0065b(boolean z7, View view, View view2) {
        this.f185b = z7;
        this.f186c = view;
        this.f187d = view2;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        switch (this.f184a) {
            case 0:
                if (!this.f185b) {
                    ((View) this.f186c).setVisibility(4);
                    View view = (View) this.f187d;
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                }
                break;
            default:
                AbstractC2991q abstractC2991q = (AbstractC2991q) this.f187d;
                abstractC2991q.f10280r = 0;
                abstractC2991q.f10274l = null;
                C2982h c2982h = (C2982h) this.f186c;
                if (c2982h != null) {
                    ((AbstractC3281e) c2982h.f10225b).mo4117E();
                }
                break;
        }
    }

    @Override
    public final void onAnimationStart(Animator animator) {
        switch (this.f184a) {
            case 0:
                if (this.f185b) {
                    ((View) this.f186c).setVisibility(0);
                    View view = (View) this.f187d;
                    view.setAlpha(0.0f);
                    view.setVisibility(4);
                }
                break;
            default:
                AbstractC2991q abstractC2991q = (AbstractC2991q) this.f187d;
                abstractC2991q.f10284v.m4235a(0, this.f185b);
                abstractC2991q.f10280r = 2;
                abstractC2991q.f10274l = animator;
                break;
        }
    }

    public C0065b(AbstractC2991q abstractC2991q, boolean z7, C2982h c2982h) {
        this.f187d = abstractC2991q;
        this.f185b = z7;
        this.f186c = c2982h;
    }
}

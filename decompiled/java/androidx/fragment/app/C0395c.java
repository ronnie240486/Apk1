package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import p000a.AbstractC0004e;

public final class C0395c extends AnimatorListenerAdapter {

    public final ViewGroup f1827a;

    public final View f1828b;

    public final boolean f1829c;

    public final C0434v0 f1830d;

    public final C0403g f1831e;

    public C0395c(ViewGroup viewGroup, View view, boolean z7, C0434v0 c0434v0, C0403g c0403g) {
        this.f1827a = viewGroup;
        this.f1828b = view;
        this.f1829c = z7;
        this.f1830d = c0434v0;
        this.f1831e = c0403g;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f1827a;
        View view = this.f1828b;
        viewGroup.endViewTransition(view);
        if (this.f1829c) {
            AbstractC0004e.m7a(this.f1830d.f2007a, view);
        }
        this.f1831e.m373d();
    }
}

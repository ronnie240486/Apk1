package com.google.android.material.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import p006a6.C0062a;
import p262y5.AbstractC4268a;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    public int f5900a;

    public int f5901b;

    public int f5902c;

    public ViewPropertyAnimator f5903d;

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5900a = 0;
        this.f5901b = 2;
        this.f5902c = 0;
    }

    @Override
    public boolean mo926h(CoordinatorLayout coordinatorLayout, View view, int i6) {
        this.f5900a = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        return false;
    }

    @Override
    public final void mo930l(CoordinatorLayout coordinatorLayout, View view, int i6, int i10, int i11, int[] iArr) {
        if (i6 > 0) {
            if (this.f5901b == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.f5903d;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.f5901b = 1;
            this.f5903d = view.animate().translationY(this.f5900a + this.f5902c).setInterpolator(AbstractC4268a.f14471c).setDuration(175L).setListener(new C0062a(0, this));
            return;
        }
        if (i6 >= 0 || this.f5901b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this.f5903d;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
            view.clearAnimation();
        }
        this.f5901b = 2;
        this.f5903d = view.animate().translationY(0).setInterpolator(AbstractC4268a.f14472d).setDuration(225L).setListener(new C0062a(0, this));
    }

    @Override
    public boolean mo934p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6, int i10) {
        return i6 == 2;
    }

    public HideBottomViewOnScrollBehavior() {
        this.f5900a = 0;
        this.f5901b = 2;
        this.f5902c = 0;
    }
}

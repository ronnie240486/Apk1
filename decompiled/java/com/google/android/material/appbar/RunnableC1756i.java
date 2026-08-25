package com.google.android.material.appbar;

import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public final class RunnableC1756i implements Runnable {

    public final CoordinatorLayout f5874a;

    public final View f5875b;

    public final HeaderBehavior f5876c;

    public RunnableC1756i(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, View view) {
        this.f5876c = headerBehavior;
        this.f5874a = coordinatorLayout;
        this.f5875b = view;
    }

    @Override
    public final void run() {
        HeaderBehavior headerBehavior;
        OverScroller overScroller;
        View view = this.f5875b;
        if (view == null || (overScroller = (headerBehavior = this.f5876c).f5842d) == null) {
            return;
        }
        boolean zComputeScrollOffset = overScroller.computeScrollOffset();
        CoordinatorLayout coordinatorLayout = this.f5874a;
        if (!zComputeScrollOffset) {
            headerBehavior.mo4084z(coordinatorLayout, view);
            return;
        }
        headerBehavior.m4094B(coordinatorLayout, view, headerBehavior.f5842d.getCurrY());
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        view.postOnAnimation(this);
    }
}

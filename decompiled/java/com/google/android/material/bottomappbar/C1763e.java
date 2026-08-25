package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

public final class C1763e extends AnimatorListenerAdapter {

    public boolean f5942a;

    public final ActionMenuView f5943b;

    public final int f5944c;

    public final boolean f5945d;

    public final BottomAppBar f5946e;

    public C1763e(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i6, boolean z7) {
        this.f5946e = bottomAppBar;
        this.f5943b = actionMenuView;
        this.f5944c = i6;
        this.f5945d = z7;
    }

    @Override
    public final void onAnimationCancel(Animator animator) {
        this.f5942a = true;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        if (this.f5942a) {
            return;
        }
        BottomAppBar bottomAppBar = this.f5946e;
        bottomAppBar.getClass();
        bottomAppBar.m4116K(this.f5943b, this.f5944c, this.f5945d, false);
    }
}

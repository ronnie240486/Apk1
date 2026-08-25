package com.google.android.material.bottomappbar;

import androidx.appcompat.widget.ActionMenuView;

public final class RunnableC1764f implements Runnable {

    public final ActionMenuView f5947a;

    public final int f5948b;

    public final boolean f5949c;

    public final BottomAppBar f5950d;

    public RunnableC1764f(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i6, boolean z7) {
        this.f5950d = bottomAppBar;
        this.f5947a = actionMenuView;
        this.f5948b = i6;
        this.f5949c = z7;
    }

    @Override
    public final void run() {
        int i6 = this.f5948b;
        boolean z7 = this.f5949c;
        BottomAppBar bottomAppBar = this.f5950d;
        ActionMenuView actionMenuView = this.f5947a;
        actionMenuView.setTranslationX(bottomAppBar.m4110E(actionMenuView, i6, z7));
    }
}

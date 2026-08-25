package com.google.android.material.appbar;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import p148o0.AbstractC3236k;
import p148o0.InterfaceC3244s;

public final class C1751d implements InterfaceC3244s {

    public final CoordinatorLayout f5866a;

    public final AppBarLayout f5867b;

    public final View f5868c;

    public final int f5869d;

    public final AppBarLayout.BaseBehavior f5870e;

    public C1751d(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i6) {
        this.f5870e = baseBehavior;
        this.f5866a = coordinatorLayout;
        this.f5867b = appBarLayout;
        this.f5868c = view;
        this.f5869d = i6;
    }

    @Override
    public final boolean perform(View view, AbstractC3236k abstractC3236k) {
        View view2 = this.f5868c;
        int i6 = this.f5869d;
        this.f5870e.m4076E(this.f5866a, this.f5867b, view2, i6, new int[]{0, 0});
        return true;
    }
}

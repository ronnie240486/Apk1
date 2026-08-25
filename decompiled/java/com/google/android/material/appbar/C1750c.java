package com.google.android.material.appbar;

import android.view.View;
import android.widget.ScrollView;
import p138n0.C3103b;
import p148o0.C3233h;

public final class C1750c extends C3103b {

    public final AppBarLayout.BaseBehavior f5865d;

    public C1750c(AppBarLayout.BaseBehavior baseBehavior) {
        this.f5865d = baseBehavior;
    }

    @Override
    public final void mo1136d(View view, C3233h c3233h) {
        this.f10576a.onInitializeAccessibilityNodeInfo(view, c3233h.f10862a);
        c3233h.m6552n(this.f5865d.f5801o);
        c3233h.m6547i(ScrollView.class.getName());
    }
}

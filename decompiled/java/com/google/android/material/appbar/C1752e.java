package com.google.android.material.appbar;

import android.view.View;
import p148o0.AbstractC3236k;
import p148o0.InterfaceC3244s;

public final class C1752e implements InterfaceC3244s {

    public final AppBarLayout f5871a;

    public final boolean f5872b;

    public C1752e(AppBarLayout appBarLayout, boolean z7) {
        this.f5871a = appBarLayout;
        this.f5872b = z7;
    }

    @Override
    public final boolean perform(View view, AbstractC3236k abstractC3236k) {
        this.f5871a.setExpanded(this.f5872b);
        return true;
    }
}

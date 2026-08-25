package com.google.android.material.bottomappbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p156o9.AbstractC3281e;

public final class C1762d extends AbstractC3281e {

    public final int f5940f;

    public final BottomAppBar f5941g;

    public C1762d(BottomAppBar bottomAppBar, int i6) {
        this.f5941g = bottomAppBar;
        this.f5940f = i6;
    }

    @Override
    public final void mo4118D(FloatingActionButton floatingActionButton) {
        int i6 = BottomAppBar.f5910r0;
        floatingActionButton.setTranslationX(this.f5941g.m4111F(this.f5940f));
        floatingActionButton.m4229m(new C1761c(this), true);
    }
}

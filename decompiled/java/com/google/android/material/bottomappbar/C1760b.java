package com.google.android.material.bottomappbar;

import android.animation.AnimatorSet;
import android.view.View;
import com.google.android.material.internal.C1819e0;
import com.google.android.material.internal.InterfaceC1817d0;
import p138n0.C3153r1;

public final class C1760b implements InterfaceC1817d0 {

    public final BottomAppBar f5938a;

    public C1760b(BottomAppBar bottomAppBar) {
        this.f5938a = bottomAppBar;
    }

    @Override
    public C3153r1 mo443o(View view, C3153r1 c3153r1, C1819e0 c1819e0) {
        boolean z7;
        BottomAppBar bottomAppBar = this.f5938a;
        if (bottomAppBar.f5919g0) {
            bottomAppBar.f5925m0 = c3153r1.m6325a();
        }
        boolean z10 = false;
        if (bottomAppBar.f5920h0) {
            z7 = bottomAppBar.f5927o0 != c3153r1.m6326b();
            bottomAppBar.f5927o0 = c3153r1.m6326b();
        } else {
            z7 = false;
        }
        if (bottomAppBar.f5921i0) {
            boolean z11 = bottomAppBar.f5926n0 != c3153r1.m6327c();
            bottomAppBar.f5926n0 = c3153r1.m6327c();
            z10 = z11;
        }
        if (z7 || z10) {
            AnimatorSet animatorSet = bottomAppBar.f5915c0;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = bottomAppBar.f5914b0;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            bottomAppBar.m4114I();
            bottomAppBar.m4113H();
        }
        return c3153r1;
    }
}

package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public final class C1759a extends AnimatorListenerAdapter {

    public final int f5936a;

    public final BottomAppBar f5937b;

    public C1759a(BottomAppBar bottomAppBar, int i6) {
        this.f5936a = i6;
        this.f5937b = bottomAppBar;
    }

    @Override
    public void onAnimationEnd(Animator animator) {
        BottomAppBar bottomAppBar = this.f5937b;
        switch (this.f5936a) {
            case 1:
                int i6 = BottomAppBar.f5910r0;
                bottomAppBar.getClass();
                bottomAppBar.f5914b0 = null;
                break;
            case 2:
                int i10 = BottomAppBar.f5910r0;
                bottomAppBar.getClass();
                bottomAppBar.f5922j0 = false;
                bottomAppBar.f5915c0 = null;
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override
    public final void onAnimationStart(Animator animator) {
        BottomAppBar bottomAppBar = this.f5937b;
        switch (this.f5936a) {
            case 0:
                if (!bottomAppBar.f5922j0) {
                    bottomAppBar.m4112G(bottomAppBar.f5916d0, bottomAppBar.f5923k0);
                }
                break;
            case 1:
                int i6 = BottomAppBar.f5910r0;
                bottomAppBar.getClass();
                break;
            case 2:
                int i10 = BottomAppBar.f5910r0;
                bottomAppBar.getClass();
                break;
            default:
                bottomAppBar.f5928p0.onAnimationStart(animator);
                FloatingActionButton floatingActionButtonM4108C = bottomAppBar.m4108C();
                if (floatingActionButtonM4108C != null) {
                    floatingActionButtonM4108C.setTranslationX(bottomAppBar.getFabTranslationX());
                }
                break;
        }
    }
}

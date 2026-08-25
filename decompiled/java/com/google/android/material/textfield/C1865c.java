package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class C1865c extends AnimatorListenerAdapter {

    public final int f6831a;

    public final C1867e f6832b;

    public C1865c(C1867e c1867e, int i6) {
        this.f6831a = i6;
        this.f6832b = c1867e;
    }

    @Override
    public void onAnimationEnd(Animator animator) {
        switch (this.f6831a) {
            case 1:
                this.f6832b.f6867a.setEndIconVisible(false);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override
    public void onAnimationStart(Animator animator) {
        switch (this.f6831a) {
            case 0:
                this.f6832b.f6867a.setEndIconVisible(true);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}

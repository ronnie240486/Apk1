package com.google.android.material.appbar;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;

public abstract class AbstractC1758k {

    public static final int[] f5881a = {R.attr.stateListAnimator};

    public static void m4101a(AppBarLayout appBarLayout, float f) {
        int integer = appBarLayout.getResources().getInteger(com.p2serv.android.p032ds.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j10 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, com.p2serv.android.p032ds.R.attr.state_liftable, -2130969749}, ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(j10));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(appBarLayout, "elevation", f).setDuration(j10));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(0L));
        appBarLayout.setStateListAnimator(stateListAnimator);
    }
}

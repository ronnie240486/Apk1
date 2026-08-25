package com.google.android.material.bottomappbar;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.C0311c;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;

public final class ViewOnLayoutChangeListenerC1765g implements View.OnLayoutChangeListener {

    public final BottomAppBar.Behavior f5951a;

    public ViewOnLayoutChangeListenerC1765g(BottomAppBar.Behavior behavior) {
        this.f5951a = behavior;
    }

    @Override
    public final void onLayoutChange(View view, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        BottomAppBar.Behavior behavior = this.f5951a;
        BottomAppBar bottomAppBar = (BottomAppBar) behavior.f5931f.get();
        if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
            view.removeOnLayoutChangeListener(this);
            return;
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
        int measuredWidth = floatingActionButton.getMeasuredWidth();
        int measuredHeight = floatingActionButton.getMeasuredHeight();
        Rect rect = behavior.f5930e;
        rect.set(0, 0, measuredWidth, measuredHeight);
        floatingActionButton.m4227j(rect);
        int iHeight = rect.height();
        bottomAppBar.m4115J(iHeight);
        bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().f13168e.mo7794a(new RectF(rect)));
        C0311c c0311c = (C0311c) view.getLayoutParams();
        if (behavior.f5932g == 0) {
            ((ViewGroup.MarginLayoutParams) c0311c).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
            ((ViewGroup.MarginLayoutParams) c0311c).leftMargin = bottomAppBar.getLeftInset();
            ((ViewGroup.MarginLayoutParams) c0311c).rightMargin = bottomAppBar.getRightInset();
            boolean zM4249i = AbstractC1811a0.m4249i(floatingActionButton);
            int i17 = bottomAppBar.f5912V;
            if (zM4249i) {
                ((ViewGroup.MarginLayoutParams) c0311c).leftMargin += i17;
            } else {
                ((ViewGroup.MarginLayoutParams) c0311c).rightMargin += i17;
            }
        }
    }
}

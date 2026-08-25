package com.google.android.material.navigationrail;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.navigation.AbstractC1846f;
import com.google.android.material.navigation.AbstractC1852l;
import com.p2serv.android.p032ds.R;
import p002a1.C0026b;
import p101j7.C2782c;
import p167p6.C3374b;
import p250x5.AbstractC4121a;

public class NavigationRailView extends AbstractC1852l {

    public final int f6591f;

    public final View f6592g;

    public final Boolean f6593h;

    public final Boolean f6594i;

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    private C3374b getNavigationRailMenuView() {
        return (C3374b) getMenuView();
    }

    @Override
    public final AbstractC1846f mo4121a(Context context) {
        return new C3374b(context);
    }

    public View getHeaderView() {
        return this.f6592g;
    }

    public int getItemMinimumHeight() {
        return ((C3374b) getMenuView()).getItemMinimumHeight();
    }

    @Override
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        C3374b navigationRailMenuView = getNavigationRailMenuView();
        View view = this.f6592g;
        int i13 = 0;
        boolean z10 = (view == null || view.getVisibility() == 8) ? false : true;
        int i14 = this.f6591f;
        if (z10) {
            int bottom = this.f6592g.getBottom() + i14;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i13 = bottom - top;
            }
        } else if ((navigationRailMenuView.f11402F.gravity & 112) == 48) {
            i13 = i14;
        }
        if (i13 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i13, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i13);
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i6) != 1073741824 && suggestedMinimumWidth > 0) {
            i6 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i6), getPaddingRight() + getPaddingLeft() + suggestedMinimumWidth), 1073741824);
        }
        super.onMeasure(i6, i10);
        View view = this.f6592g;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        measureChild(getNavigationRailMenuView(), i6, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f6592g.getMeasuredHeight()) - this.f6591f, Integer.MIN_VALUE));
    }

    public void setItemMinimumHeight(int i6) {
        ((C3374b) getMenuView()).setItemMinimumHeight(i6);
    }

    public void setMenuGravity(int i6) {
        getNavigationRailMenuView().setMenuGravity(i6);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6, R.style.Widget_MaterialComponents_NavigationRailView);
        this.f6593h = null;
        this.f6594i = null;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        this.f6591f = dimensionPixelSize;
        C0026b c0026bM4251k = AbstractC1811a0.m4251k(getContext(), attributeSet, AbstractC4121a.f13969M, i6, R.style.Widget_MaterialComponents_NavigationRailView, new int[0]);
        TypedArray typedArray = (TypedArray) c0026bM4251k.f55c;
        int resourceId = typedArray.getResourceId(0, 0);
        if (resourceId != 0) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
            View view = this.f6592g;
            if (view != null) {
                removeView(view);
                this.f6592g = null;
            }
            this.f6592g = viewInflate;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = dimensionPixelSize;
            addView(viewInflate, 0, layoutParams);
        }
        setMenuGravity(typedArray.getInt(2, 49));
        if (typedArray.hasValue(1)) {
            setItemMinimumHeight(typedArray.getDimensionPixelSize(1, -1));
        }
        if (typedArray.hasValue(4)) {
            this.f6593h = Boolean.valueOf(typedArray.getBoolean(4, false));
        }
        if (typedArray.hasValue(3)) {
            this.f6594i = Boolean.valueOf(typedArray.getBoolean(3, false));
        }
        c0026bM4251k.m120F();
        AbstractC1811a0.m4244d(this, new C2782c(26, this));
    }
}

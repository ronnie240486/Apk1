package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.C0311c;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p123l5.AbstractC2973a;
import p138n0.AbstractC3155s0;
import p138n0.C3153r1;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    public final Rect f5848c;

    public final Rect f5849d;

    public int f5850e;

    public int f5851f;

    public HeaderScrollingViewBehavior() {
        this.f5848c = new Rect();
        this.f5849d = new Rect();
        this.f5850e = 0;
    }

    @Override
    public boolean mo927i(CoordinatorLayout coordinatorLayout, View view, int i6, int i10, int i11) {
        AppBarLayout appBarLayoutMo4085w;
        C3153r1 lastWindowInsets;
        int i12 = view.getLayoutParams().height;
        if ((i12 != -1 && i12 != -2) || (appBarLayoutMo4085w = mo4085w(coordinatorLayout.m909o(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i11);
        if (size > 0) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (appBarLayoutMo4085w.getFitsSystemWindows() && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.m6325a() + lastWindowInsets.m6328d();
            }
        } else {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.m915w(i6, i10, View.MeasureSpec.makeMeasureSpec((size + mo4087y(appBarLayoutMo4085w)) - appBarLayoutMo4085w.getMeasuredHeight(), i12 == -1 ? 1073741824 : Integer.MIN_VALUE), view);
        return true;
    }

    @Override
    public final void mo4095u(CoordinatorLayout coordinatorLayout, View view, int i6) {
        AppBarLayout appBarLayoutMo4085w = mo4085w(coordinatorLayout.m909o(view));
        int iM6016g = 0;
        if (appBarLayoutMo4085w == null) {
            coordinatorLayout.m914v(i6, view);
            this.f5850e = 0;
            return;
        }
        C0311c c0311c = (C0311c) view.getLayoutParams();
        int paddingLeft = coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0311c).leftMargin;
        int bottom = appBarLayoutMo4085w.getBottom() + ((ViewGroup.MarginLayoutParams) c0311c).topMargin;
        int width = (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) c0311c).rightMargin;
        int bottom2 = ((appBarLayoutMo4085w.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) c0311c).bottomMargin;
        Rect rect = this.f5848c;
        rect.set(paddingLeft, bottom, width, bottom2);
        C3153r1 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                rect.left = lastWindowInsets.m6326b() + rect.left;
                rect.right -= lastWindowInsets.m6327c();
            }
        }
        int i10 = c0311c.f1444c;
        int i11 = i10 == 0 ? 8388659 : i10;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Rect rect2 = this.f5849d;
        Gravity.apply(i11, measuredWidth, measuredHeight, rect, rect2, i6);
        if (this.f5851f != 0) {
            float fMo4086x = mo4086x(appBarLayoutMo4085w);
            int i12 = this.f5851f;
            iM6016g = AbstractC2973a.m6016g((int) (fMo4086x * i12), 0, i12);
        }
        view.layout(rect2.left, rect2.top - iM6016g, rect2.right, rect2.bottom - iM6016g);
        this.f5850e = rect2.top - appBarLayoutMo4085w.getBottom();
    }

    public abstract AppBarLayout mo4085w(ArrayList arrayList);

    public float mo4086x(View view) {
        return 1.0f;
    }

    public int mo4087y(View view) {
        return view.getMeasuredHeight();
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5848c = new Rect();
        this.f5849d = new Rect();
        this.f5850e = 0;
    }
}

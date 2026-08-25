package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.C0311c;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.InterfaceC0309a;
import androidx.customview.view.AbsSavedState;
import com.bumptech.glide.AbstractC1465c;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.C1816d;
import com.p2serv.android.p032ds.R;
import com.youth.banner.config.BannerConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import p001a0.C0019b;
import p007a7.C0069f;
import p055ea.AbstractC2460q;
import p123l5.AbstractC2973a;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p138n0.C3153r1;
import p138n0.InterfaceC3139n;
import p143n5.AbstractC3198d;
import p148o0.C3228c;
import p156o9.AbstractC3280d;
import p160p.C3347k;
import p221u6.C3908h;
import p250x5.AbstractC4121a;
import p262y5.AbstractC4268a;
import p263y6.AbstractC4275a;

public class AppBarLayout extends LinearLayout implements InterfaceC0309a {

    public int f5777a;

    public int f5778b;

    public int f5779c;

    public int f5780d;

    public boolean f5781e;

    public int f5782f;

    public C3153r1 f5783g;

    public ArrayList f5784h;

    public boolean f5785i;

    public boolean f5786j;

    public boolean f5787k;

    public boolean f5788l;

    public int f5789m;

    public WeakReference f5790n;

    public ValueAnimator f5791o;

    public final ArrayList f5792p;

    public int[] f5793q;

    public Drawable f5794r;

    public Behavior f5795s;

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        public int f5807a;

        public final C0069f f5808b;

        public final Interpolator f5809c;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5807a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4121a.f13985b);
            this.f5807a = typedArrayObtainStyledAttributes.getInt(1, 0);
            this.f5808b = typedArrayObtainStyledAttributes.getInt(0, 0) != 1 ? null : new C0069f(12);
            if (typedArrayObtainStyledAttributes.hasValue(2)) {
                this.f5809c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        @Override
        public final boolean mo920b(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override
        public final boolean mo922d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            int iM6016g;
            CoordinatorLayout.Behavior behavior = ((C0311c) view2.getLayoutParams()).f1442a;
            if (behavior instanceof BaseBehavior) {
                int bottom = (view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f5796j + this.f5850e;
                if (this.f5851f == 0) {
                    iM6016g = 0;
                } else {
                    float fMo4086x = mo4086x(view2);
                    int i6 = this.f5851f;
                    iM6016g = AbstractC2973a.m6016g((int) (fMo4086x * i6), 0, i6);
                }
                AbstractC3155s0.m6340j(bottom - iM6016g, view);
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.f5788l) {
                    appBarLayout.m4069e(appBarLayout.m4070f(view));
                }
            }
            return false;
        }

        @Override
        public final void mo923e(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                AbstractC3155s0.m6343m(C3228c.f10844h.m6512a(), coordinatorLayout);
                AbstractC3155s0.m6344n(C3228c.f10845i.m6512a(), coordinatorLayout);
                AbstractC3155s0.m6338h(0, coordinatorLayout);
                AbstractC3155s0.m6347q(coordinatorLayout, null);
            }
        }

        @Override
        public final boolean mo931m(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z7) {
            AppBarLayout appBarLayout;
            ArrayList arrayListM909o = coordinatorLayout.m909o(view);
            int size = arrayListM909o.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    appBarLayout = null;
                    break;
                }
                View view2 = (View) arrayListM909o.get(i6);
                if (view2 instanceof AppBarLayout) {
                    appBarLayout = (AppBarLayout) view2;
                    break;
                }
                i6++;
            }
            if (appBarLayout != null) {
                rect.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect2 = this.f5848c;
                rect2.set(0, 0, width, height);
                if (!rect2.contains(rect)) {
                    appBarLayout.m4068d(false, !z7, true);
                    return true;
                }
            }
            return false;
        }

        @Override
        public final AppBarLayout mo4085w(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = (View) arrayList.get(i6);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override
        public final float mo4086x(View view) {
            int i6;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                CoordinatorLayout.Behavior behavior = ((C0311c) appBarLayout.getLayoutParams()).f1442a;
                int iMo4080t = behavior instanceof BaseBehavior ? ((BaseBehavior) behavior).mo4080t() : 0;
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iMo4080t > downNestedPreScrollRange) && (i6 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iMo4080t / i6) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override
        public final int mo4087y(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : view.getMeasuredHeight();
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4121a.f13974R);
            this.f5851f = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    public static LayoutParams m4065a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LayoutParams layoutParams2 = new LayoutParams((LinearLayout.LayoutParams) layoutParams);
            layoutParams2.f5807a = 1;
            return layoutParams2;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            LayoutParams layoutParams3 = new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            layoutParams3.f5807a = 1;
            return layoutParams3;
        }
        LayoutParams layoutParams4 = new LayoutParams(layoutParams);
        layoutParams4.f5807a = 1;
        return layoutParams4;
    }

    public final void m4066b() {
        Behavior behavior = this.f5795s;
        BaseBehavior.SavedState savedStateM4077F = (behavior == null || this.f5778b == -1 || this.f5782f != 0) ? null : behavior.m4077F(AbsSavedState.f1688b, this);
        this.f5778b = -1;
        this.f5779c = -1;
        this.f5780d = -1;
        if (savedStateM4077F != null) {
            Behavior behavior2 = this.f5795s;
            if (behavior2.f5799m != null) {
                return;
            }
            behavior2.f5799m = savedStateM4077F;
        }
    }

    public final void m4067c(int i6) {
        this.f5777a = i6;
        if (!willNotDraw()) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            postInvalidateOnAnimation();
        }
        ArrayList arrayList = this.f5784h;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                InterfaceC1754g interfaceC1754g = (InterfaceC1754g) this.f5784h.get(i10);
                if (interfaceC1754g != null) {
                    CollapsingToolbarLayout collapsingToolbarLayout = ((C1755h) interfaceC1754g).f5873a;
                    collapsingToolbarLayout.f5835w = i6;
                    C3153r1 c3153r1 = collapsingToolbarLayout.f5837y;
                    int iM6328d = c3153r1 != null ? c3153r1.m6328d() : 0;
                    int childCount = collapsingToolbarLayout.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        View childAt = collapsingToolbarLayout.getChildAt(i11);
                        CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) childAt.getLayoutParams();
                        C1757j c1757jM4088b = CollapsingToolbarLayout.m4088b(childAt);
                        int i12 = layoutParams.f5839a;
                        if (i12 == 1) {
                            c1757jM4088b.m4100b(AbstractC2973a.m6016g(-i6, 0, ((collapsingToolbarLayout.getHeight() - CollapsingToolbarLayout.m4088b(childAt).f5878b) - childAt.getHeight()) - ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.LayoutParams) childAt.getLayoutParams())).bottomMargin));
                        } else if (i12 == 2) {
                            c1757jM4088b.m4100b(Math.round((-i6) * layoutParams.f5840b));
                        }
                    }
                    collapsingToolbarLayout.m4091d();
                    if (collapsingToolbarLayout.f5828p != null && iM6328d > 0) {
                        WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                        collapsingToolbarLayout.postInvalidateOnAnimation();
                    }
                    int height = collapsingToolbarLayout.getHeight();
                    WeakHashMap weakHashMap3 = AbstractC3155s0.f10642a;
                    int minimumHeight = (height - collapsingToolbarLayout.getMinimumHeight()) - iM6328d;
                    float scrimVisibleHeightTrigger = height - collapsingToolbarLayout.getScrimVisibleHeightTrigger();
                    float f = minimumHeight;
                    float fMin = Math.min(1.0f, scrimVisibleHeightTrigger / f);
                    C1816d c1816d = collapsingToolbarLayout.f5823k;
                    c1816d.f6399e = fMin;
                    c1816d.f6401f = AbstractC2460q.m5490d(1.0f, fMin, 0.5f, fMin);
                    c1816d.f6403g = collapsingToolbarLayout.f5835w + minimumHeight;
                    c1816d.m4272q(Math.abs(i6) / f);
                }
            }
        }
    }

    @Override
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void m4068d(boolean z7, boolean z10, boolean z11) {
        this.f5782f = (z7 ? 1 : 2) | (z10 ? 4 : 0) | (z11 ? 8 : 0);
        requestLayout();
    }

    @Override
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f5794r == null || getTopInset() <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(0.0f, -this.f5777a);
        this.f5794r.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f5794r;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean m4069e(boolean z7) {
        if (this.f5785i || this.f5787k == z7) {
            return false;
        }
        this.f5787k = z7;
        refreshDrawableState();
        if (!this.f5788l || !(getBackground() instanceof C3908h)) {
            return true;
        }
        C3908h c3908h = (C3908h) getBackground();
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        float f = z7 ? 0.0f : dimension;
        if (!z7) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.f5791o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, dimension);
        this.f5791o = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.f5791o.setInterpolator(AbstractC4268a.f14469a);
        this.f5791o.addUpdateListener(new C1748a(this, c3908h));
        this.f5791o.start();
        return true;
    }

    public final boolean m4070f(View view) {
        int i6;
        if (this.f5790n == null && (i6 = this.f5789m) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i6) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f5789m);
            }
            if (viewFindViewById != null) {
                this.f5790n = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.f5790n;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public final boolean m4071g() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8) {
            return false;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return !childAt.getFitsSystemWindows();
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.f5807a = 1;
        return layoutParams;
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m4065a(layoutParams);
    }

    @Override
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f5795s = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i6 = this.f5779c;
        if (i6 != -1) {
            return i6;
        }
        int i10 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i11 = layoutParams.f5807a;
            if ((i11 & 5) != 5) {
                if (i10 > 0) {
                    break;
                }
            } else {
                int i12 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i11 & 8) != 0) {
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    minimumHeight = childAt.getMinimumHeight();
                } else {
                    if ((i11 & 2) != 0) {
                        WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        iMin = i12 + measuredHeight;
                    }
                    if (childCount == 0) {
                        WeakHashMap weakHashMap3 = AbstractC3155s0.f10642a;
                        if (childAt.getFitsSystemWindows()) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                    }
                    i10 += iMin;
                }
                iMin = minimumHeight + i12;
                if (childCount == 0) {
                    WeakHashMap weakHashMap4 = AbstractC3155s0.f10642a;
                    if (childAt.getFitsSystemWindows()) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                }
                i10 += iMin;
            }
        }
        int iMax = Math.max(0, i10);
        this.f5779c = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i6 = this.f5780d;
        if (i6 != -1) {
            return i6;
        }
        int childCount = getChildCount();
        int minimumHeight = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
            int i11 = layoutParams.f5807a;
            if ((i11 & 1) == 0) {
                break;
            }
            minimumHeight += measuredHeight;
            if ((i11 & 2) != 0) {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                minimumHeight -= childAt.getMinimumHeight();
                break;
            }
        }
        int iMax = Math.max(0, minimumHeight);
        this.f5780d = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f5789m;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int minimumHeight = getMinimumHeight();
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f5782f;
    }

    public Drawable getStatusBarForeground() {
        return this.f5794r;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        C3153r1 c3153r1 = this.f5783g;
        if (c3153r1 != null) {
            return c3153r1.m6328d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i6 = this.f5778b;
        if (i6 != -1) {
            return i6;
        }
        int childCount = getChildCount();
        int minimumHeight = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i11 = layoutParams.f5807a;
            if ((i11 & 1) == 0) {
                break;
            }
            int topInset = measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + minimumHeight;
            if (i10 == 0) {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                if (childAt.getFitsSystemWindows()) {
                    topInset -= getTopInset();
                }
            }
            minimumHeight = topInset;
            if ((i11 & 2) != 0) {
                WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                minimumHeight -= childAt.getMinimumHeight();
                break;
            }
        }
        int iMax = Math.max(0, minimumHeight);
        this.f5778b = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC3280d.m6568E(this);
    }

    @Override
    public final int[] onCreateDrawableState(int i6) {
        if (this.f5793q == null) {
            this.f5793q = new int[4];
        }
        int[] iArr = this.f5793q;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i6 + iArr.length);
        boolean z7 = this.f5786j;
        iArr[0] = z7 ? R.attr.state_liftable : -2130969748;
        iArr[1] = (z7 && this.f5787k) ? R.attr.state_lifted : -2130969749;
        iArr[2] = z7 ? R.attr.state_collapsible : -2130969746;
        iArr[3] = (z7 && this.f5787k) ? R.attr.state_collapsed : -2130969745;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.f5790n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f5790n = null;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        boolean z10 = true;
        super.onLayout(z7, i6, i10, i11, i12);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (getFitsSystemWindows() && m4071g()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                AbstractC3155s0.m6340j(topInset, getChildAt(childCount));
            }
        }
        m4066b();
        this.f5781e = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            if (((LayoutParams) getChildAt(i13).getLayoutParams()).f5809c != null) {
                this.f5781e = true;
                break;
            }
        }
        Drawable drawable = this.f5794r;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f5785i) {
            return;
        }
        if (!this.f5788l) {
            int childCount3 = getChildCount();
            int i14 = 0;
            while (true) {
                if (i14 >= childCount3) {
                    z10 = false;
                    break;
                }
                int i15 = ((LayoutParams) getChildAt(i14).getLayoutParams()).f5807a;
                if ((i15 & 1) == 1 && (i15 & 10) != 0) {
                    break;
                } else {
                    i14++;
                }
            }
        }
        if (this.f5786j != z10) {
            this.f5786j = z10;
            refreshDrawableState();
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != 1073741824) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (getFitsSystemWindows() && m4071g()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = AbstractC2973a.m6016g(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i10));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        m4066b();
    }

    @Override
    public void setElevation(float f) {
        super.setElevation(f);
        AbstractC3280d.m6565B(this, f);
    }

    public void setExpanded(boolean z7) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        m4068d(z7, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z7) {
        this.f5788l = z7;
    }

    public void setLiftOnScrollTargetViewId(int i6) {
        this.f5789m = i6;
        WeakReference weakReference = this.f5790n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f5790n = null;
    }

    public void setLiftableOverrideEnabled(boolean z7) {
        this.f5785i = z7;
    }

    @Override
    public void setOrientation(int i6) {
        if (i6 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i6);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f5794r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f5794r = drawableMutate;
            boolean z7 = false;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f5794r.setState(getDrawableState());
                }
                Drawable drawable3 = this.f5794r;
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                AbstractC3198d.m6442Q(drawable3, getLayoutDirection());
                this.f5794r.setVisible(getVisibility() == 0, false);
                this.f5794r.setCallback(this);
            }
            if (this.f5794r != null && getTopInset() > 0) {
                z7 = true;
            }
            setWillNotDraw(true ^ z7);
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i6) {
        setStatusBarForeground(new ColorDrawable(i6));
    }

    public void setStatusBarForegroundResource(int i6) {
        setStatusBarForeground(AbstractC1465c.m3473h(getContext(), i6));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        AbstractC1758k.m4101a(this, f);
    }

    @Override
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        boolean z7 = i6 == 0;
        Drawable drawable = this.f5794r;
        if (drawable != null) {
            drawable.setVisible(z7, false);
        }
    }

    @Override
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5794r;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_Design_AppBarLayout), attributeSet, i6);
        this.f5778b = -1;
        this.f5779c = -1;
        this.f5780d = -1;
        this.f5782f = 0;
        this.f5792p = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        int i10 = Build.VERSION.SDK_INT;
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context3, attributeSet, AbstractC1758k.f5881a, i6, R.style.Widget_Design_AppBarLayout, new int[0]);
        try {
            if (typedArrayM4250j.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayM4250j.getResourceId(0, 0)));
            }
            typedArrayM4250j.recycle();
            TypedArray typedArrayM4250j2 = AbstractC1811a0.m4250j(context2, attributeSet, AbstractC4121a.f13983a, i6, R.style.Widget_Design_AppBarLayout, new int[0]);
            Drawable drawable = typedArrayM4250j2.getDrawable(0);
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            setBackground(drawable);
            if (getBackground() instanceof ColorDrawable) {
                ColorDrawable colorDrawable = (ColorDrawable) getBackground();
                C3908h c3908h = new C3908h();
                c3908h.m7809n(ColorStateList.valueOf(colorDrawable.getColor()));
                c3908h.m7806k(context2);
                setBackground(c3908h);
            }
            if (typedArrayM4250j2.hasValue(4)) {
                m4068d(typedArrayM4250j2.getBoolean(4, false), false, false);
            }
            if (typedArrayM4250j2.hasValue(3)) {
                AbstractC1758k.m4101a(this, typedArrayM4250j2.getDimensionPixelSize(3, 0));
            }
            if (i10 >= 26) {
                if (typedArrayM4250j2.hasValue(2)) {
                    setKeyboardNavigationCluster(typedArrayM4250j2.getBoolean(2, false));
                }
                if (typedArrayM4250j2.hasValue(1)) {
                    setTouchscreenBlocksFocus(typedArrayM4250j2.getBoolean(1, false));
                }
            }
            this.f5788l = typedArrayM4250j2.getBoolean(5, false);
            this.f5789m = typedArrayM4250j2.getResourceId(6, -1);
            setStatusBarForeground(typedArrayM4250j2.getDrawable(7));
            typedArrayM4250j2.recycle();
            AbstractC3119g0.m6182u(this, new C0019b(13, this));
        } catch (Throwable th) {
            typedArrayM4250j.recycle();
            throw th;
        }
    }

    @Override
    public final LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m4065a(layoutParams);
    }

    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        public int f5796j;

        public int f5797k;

        public ValueAnimator f5798l;

        public SavedState f5799m;

        public WeakReference f5800n;

        public boolean f5801o;

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new C1753f();

            public boolean f5802c;

            public boolean f5803d;

            public int f5804e;

            public float f5805f;

            public boolean f5806g;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f5802c = parcel.readByte() != 0;
                this.f5803d = parcel.readByte() != 0;
                this.f5804e = parcel.readInt();
                this.f5805f = parcel.readFloat();
                this.f5806g = parcel.readByte() != 0;
            }

            @Override
            public final void writeToParcel(Parcel parcel, int i6) {
                super.writeToParcel(parcel, i6);
                parcel.writeByte(this.f5802c ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f5803d ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f5804e);
                parcel.writeFloat(this.f5805f);
                parcel.writeByte(this.f5806g ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
            this.f5844f = -1;
            this.f5846h = -1;
        }

        public static View m4072D(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = coordinatorLayout.getChildAt(i6);
                if ((childAt instanceof InterfaceC3139n) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public static void m4073I(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i6, int i10, boolean z7) {
            View childAt;
            boolean zM4070f;
            int iAbs = Math.abs(i6);
            int childCount = appBarLayout.getChildCount();
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    childAt = null;
                    break;
                }
                childAt = appBarLayout.getChildAt(i11);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    break;
                } else {
                    i11++;
                }
            }
            if (childAt != null) {
                int i12 = ((LayoutParams) childAt.getLayoutParams()).f5807a;
                if ((i12 & 1) != 0) {
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    int minimumHeight = childAt.getMinimumHeight();
                    if (i10 <= 0 || (i12 & 12) == 0 ? (i12 & 2) == 0 || (-i6) < (childAt.getBottom() - minimumHeight) - appBarLayout.getTopInset() : (-i6) < (childAt.getBottom() - minimumHeight) - appBarLayout.getTopInset()) {
                        zM4070f = false;
                    } else {
                        zM4070f = true;
                    }
                } else {
                    zM4070f = false;
                }
            } else {
                zM4070f = false;
            }
            if (appBarLayout.f5788l) {
                zM4070f = appBarLayout.m4070f(m4072D(coordinatorLayout));
            }
            boolean zM4069e = appBarLayout.m4069e(zM4070f);
            if (!z7) {
                if (zM4069e) {
                    List list = (List) ((C3347k) coordinatorLayout.f1423b.f45c).get(appBarLayout);
                    ArrayList arrayList = coordinatorLayout.f1425d;
                    arrayList.clear();
                    if (list != null) {
                        arrayList.addAll(list);
                    }
                    int size = arrayList.size();
                    for (int i13 = 0; i13 < size; i13++) {
                        CoordinatorLayout.Behavior behavior = ((C0311c) ((View) arrayList.get(i13)).getLayoutParams()).f1442a;
                        if (behavior instanceof ScrollingViewBehavior) {
                            if (((ScrollingViewBehavior) behavior).f5851f == 0) {
                                return;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            appBarLayout.jumpDrawablesToCurrentState();
        }

        @Override
        public final int mo4074A(CoordinatorLayout coordinatorLayout, View view, int i6, int i10, int i11) {
            int top;
            int topInset;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int iMo4080t = mo4080t();
            int i12 = 0;
            if (i10 == 0 || iMo4080t < i10 || iMo4080t > i11) {
                this.f5796j = 0;
            } else {
                int iM6016g = AbstractC2973a.m6016g(i6, i10, i11);
                if (iMo4080t != iM6016g) {
                    if (!appBarLayout.f5781e) {
                        top = iM6016g;
                        break;
                    }
                    int iAbs = Math.abs(iM6016g);
                    int childCount = appBarLayout.getChildCount();
                    int i13 = 0;
                    while (true) {
                        if (i13 < childCount) {
                            View childAt = appBarLayout.getChildAt(i13);
                            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                            Interpolator interpolator = layoutParams.f5809c;
                            if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                                i13++;
                            } else if (interpolator != null) {
                                int i14 = layoutParams.f5807a;
                                if ((i14 & 1) != 0) {
                                    topInset = childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                                    if ((i14 & 2) != 0) {
                                        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                                        topInset -= childAt.getMinimumHeight();
                                    }
                                } else {
                                    topInset = 0;
                                }
                                WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                                if (childAt.getFitsSystemWindows()) {
                                    topInset -= appBarLayout.getTopInset();
                                }
                                if (topInset > 0) {
                                    float f = topInset;
                                    top = (childAt.getTop() + Math.round(interpolator.getInterpolation((iAbs - childAt.getTop()) / f) * f)) * Integer.signum(iM6016g);
                                    break;
                                }
                            }
                        }
                        top = iM6016g;
                        break;
                    }
                    boolean zM4098v = m4098v(top);
                    int i15 = iMo4080t - iM6016g;
                    this.f5796j = iM6016g - top;
                    if (zM4098v) {
                        for (int i16 = 0; i16 < appBarLayout.getChildCount(); i16++) {
                            LayoutParams layoutParams2 = (LayoutParams) appBarLayout.getChildAt(i16).getLayoutParams();
                            C0069f c0069f = layoutParams2.f5808b;
                            if (c0069f != null && (layoutParams2.f5807a & 1) != 0) {
                                View childAt2 = appBarLayout.getChildAt(i16);
                                float fM4097s = m4097s();
                                Rect rect = (Rect) c0069f.f196b;
                                childAt2.getDrawingRect(rect);
                                appBarLayout.offsetDescendantRectToMyCoords(childAt2, rect);
                                rect.offset(0, -appBarLayout.getTopInset());
                                float fAbs = rect.top - Math.abs(fM4097s);
                                if (fAbs <= 0.0f) {
                                    float fAbs2 = Math.abs(fAbs / rect.height());
                                    float f3 = 1.0f - (fAbs2 >= 0.0f ? fAbs2 > 1.0f ? 1.0f : fAbs2 : 0.0f);
                                    float fHeight = (-fAbs) - ((rect.height() * 0.3f) * (1.0f - (f3 * f3)));
                                    childAt2.setTranslationY(fHeight);
                                    Rect rect2 = (Rect) c0069f.f197c;
                                    childAt2.getDrawingRect(rect2);
                                    rect2.offset(0, (int) (-fHeight));
                                    WeakHashMap weakHashMap3 = AbstractC3155s0.f10642a;
                                    childAt2.setClipBounds(rect2);
                                } else {
                                    WeakHashMap weakHashMap4 = AbstractC3155s0.f10642a;
                                    childAt2.setClipBounds(null);
                                    childAt2.setTranslationY(0.0f);
                                }
                            }
                        }
                    }
                    if (!zM4098v && appBarLayout.f5781e) {
                        coordinatorLayout.m907m(appBarLayout);
                    }
                    appBarLayout.m4067c(m4097s());
                    m4073I(coordinatorLayout, appBarLayout, iM6016g, iM6016g < iMo4080t ? -1 : 1, false);
                    i12 = i15;
                }
            }
            m4079H(coordinatorLayout, appBarLayout);
            return i12;
        }

        public final void m4075C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i6) {
            int iAbs = Math.abs(mo4080t() - i6);
            float fAbs = Math.abs(0.0f);
            int iRound = fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int iMo4080t = mo4080t();
            if (iMo4080t == i6) {
                ValueAnimator valueAnimator = this.f5798l;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f5798l.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f5798l;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f5798l = valueAnimator3;
                valueAnimator3.setInterpolator(AbstractC4268a.f14473e);
                this.f5798l.addUpdateListener(new C1749b(this, coordinatorLayout, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.f5798l.setDuration(Math.min(iRound, BannerConfig.SCROLL_TIME));
            this.f5798l.setIntValues(iMo4080t, i6);
            this.f5798l.start();
        }

        public final void m4076E(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i6, int[] iArr) {
            int i10;
            int downNestedPreScrollRange;
            if (i6 != 0) {
                if (i6 < 0) {
                    int i11 = -appBarLayout.getTotalScrollRange();
                    i10 = i11;
                    downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange() + i11;
                } else {
                    i10 = -appBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i10 != downNestedPreScrollRange) {
                    iArr[1] = mo4074A(coordinatorLayout, appBarLayout, mo4080t() - i6, i10, downNestedPreScrollRange);
                }
            }
            if (appBarLayout.f5788l) {
                appBarLayout.m4069e(appBarLayout.m4070f(view));
            }
        }

        public final SavedState m4077F(Parcelable parcelable, AppBarLayout appBarLayout) {
            int iM4097s = m4097s();
            int childCount = appBarLayout.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = appBarLayout.getChildAt(i6);
                int bottom = childAt.getBottom() + iM4097s;
                if (childAt.getTop() + iM4097s <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.f1688b;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z7 = iM4097s == 0;
                    savedState.f5803d = z7;
                    savedState.f5802c = !z7 && (-iM4097s) >= appBarLayout.getTotalScrollRange();
                    savedState.f5804e = i6;
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    savedState.f5806g = bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight();
                    savedState.f5805f = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        public final void m4078G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int iMo4080t = mo4080t() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount) {
                    i6 = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i6);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if ((layoutParams.f5807a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i10 = -iMo4080t;
                if (top <= i10 && bottom >= i10) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 >= 0) {
                View childAt2 = appBarLayout.getChildAt(i6);
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                int i11 = layoutParams2.f5807a;
                if ((i11 & 17) == 17) {
                    int topInset = -childAt2.getTop();
                    int minimumHeight = -childAt2.getBottom();
                    if (i6 == 0) {
                        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                        if (appBarLayout.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                            topInset -= appBarLayout.getTopInset();
                        }
                    }
                    if ((i11 & 2) == 2) {
                        WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                        minimumHeight += childAt2.getMinimumHeight();
                    } else if ((i11 & 5) == 5) {
                        WeakHashMap weakHashMap3 = AbstractC3155s0.f10642a;
                        int minimumHeight2 = childAt2.getMinimumHeight() + minimumHeight;
                        if (iMo4080t < minimumHeight2) {
                            topInset = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if ((i11 & 32) == 32) {
                        topInset += ((LinearLayout.LayoutParams) layoutParams2).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                    }
                    if (iMo4080t < (minimumHeight + topInset) / 2) {
                        topInset = minimumHeight;
                    }
                    m4075C(coordinatorLayout, appBarLayout, AbstractC2973a.m6016g(topInset + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        public final void m4079H(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            View childAt;
            AbstractC3155s0.m6343m(C3228c.f10844h.m6512a(), coordinatorLayout);
            AbstractC3155s0.m6344n(C3228c.f10845i.m6512a(), coordinatorLayout);
            boolean z7 = false;
            AbstractC3155s0.m6338h(0, coordinatorLayout);
            if (appBarLayout.getTotalScrollRange() == 0) {
                return;
            }
            int childCount = coordinatorLayout.getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount) {
                    childAt = null;
                    break;
                }
                childAt = coordinatorLayout.getChildAt(i6);
                if (((C0311c) childAt.getLayoutParams()).f1442a instanceof ScrollingViewBehavior) {
                    break;
                } else {
                    i6++;
                }
            }
            View view = childAt;
            if (view == null) {
                return;
            }
            int childCount2 = appBarLayout.getChildCount();
            for (int i10 = 0; i10 < childCount2; i10++) {
                if (((LayoutParams) appBarLayout.getChildAt(i10).getLayoutParams()).f5807a != 0) {
                    if (AbstractC3155s0.m6334d(coordinatorLayout) == null) {
                        AbstractC3155s0.m6347q(coordinatorLayout, new C1750c(this));
                    }
                    boolean z10 = true;
                    if (mo4080t() != (-appBarLayout.getTotalScrollRange())) {
                        AbstractC3155s0.m6345o(coordinatorLayout, C3228c.f10844h, new C1752e(appBarLayout, false));
                        z7 = true;
                    }
                    if (mo4080t() == 0) {
                        z10 = z7;
                    } else if (view.canScrollVertically(-1)) {
                        int i11 = -appBarLayout.getDownNestedPreScrollRange();
                        if (i11 != 0) {
                            AbstractC3155s0.m6345o(coordinatorLayout, C3228c.f10845i, new C1751d(this, coordinatorLayout, appBarLayout, view, i11));
                        } else {
                            z10 = z7;
                        }
                    } else {
                        AbstractC3155s0.m6345o(coordinatorLayout, C3228c.f10845i, new C1752e(appBarLayout, true));
                    }
                    this.f5801o = z10;
                    return;
                }
            }
        }

        @Override
        public final boolean mo926h(CoordinatorLayout coordinatorLayout, View view, int i6) {
            int iRound;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.mo926h(coordinatorLayout, appBarLayout, i6);
            int pendingAction = appBarLayout.getPendingAction();
            SavedState savedState = this.f5799m;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z7 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i10 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z7) {
                            m4075C(coordinatorLayout, appBarLayout, i10);
                        } else {
                            m4094B(coordinatorLayout, appBarLayout, i10);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z7) {
                            m4075C(coordinatorLayout, appBarLayout, 0);
                        } else {
                            m4094B(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (savedState.f5802c) {
                m4094B(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (savedState.f5803d) {
                m4094B(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(savedState.f5804e);
                int i11 = -childAt.getBottom();
                if (this.f5799m.f5806g) {
                    iRound = appBarLayout.getTopInset() + childAt.getMinimumHeight() + i11;
                } else {
                    iRound = Math.round(childAt.getHeight() * this.f5799m.f5805f) + i11;
                }
                m4094B(coordinatorLayout, appBarLayout, iRound);
            }
            appBarLayout.f5782f = 0;
            this.f5799m = null;
            m4098v(AbstractC2973a.m6016g(m4097s(), -appBarLayout.getTotalScrollRange(), 0));
            m4073I(coordinatorLayout, appBarLayout, m4097s(), 0, true);
            appBarLayout.m4067c(m4097s());
            m4079H(coordinatorLayout, appBarLayout);
            return true;
        }

        @Override
        public final boolean mo927i(CoordinatorLayout coordinatorLayout, View view, int i6, int i10, int i11) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((C0311c) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.m915w(i6, i10, View.MeasureSpec.makeMeasureSpec(0, 0), appBarLayout);
            return true;
        }

        @Override
        public final void mo929k(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i10, int[] iArr, int i11) {
            m4076E(coordinatorLayout, (AppBarLayout) view, view2, i10, iArr);
        }

        @Override
        public final void mo930l(CoordinatorLayout coordinatorLayout, View view, int i6, int i10, int i11, int[] iArr) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i11 < 0) {
                iArr[1] = mo4074A(coordinatorLayout, appBarLayout, mo4080t() - i11, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i11 == 0) {
                m4079H(coordinatorLayout, appBarLayout);
            }
        }

        @Override
        public final void mo932n(View view, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                this.f5799m = (SavedState) parcelable;
            } else {
                this.f5799m = null;
            }
        }

        @Override
        public final Parcelable mo933o(View view) {
            android.view.AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            SavedState savedStateM4077F = m4077F(absSavedState, (AppBarLayout) view);
            return savedStateM4077F == null ? absSavedState : savedStateM4077F;
        }

        @Override
        public final boolean mo934p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6, int i10) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z7 = (i6 & 2) != 0 && (appBarLayout.f5788l || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()));
            if (z7 && (valueAnimator = this.f5798l) != null) {
                valueAnimator.cancel();
            }
            this.f5800n = null;
            this.f5797k = i10;
            return z7;
        }

        @Override
        public final void mo935q(CoordinatorLayout coordinatorLayout, View view, View view2, int i6) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.f5797k == 0 || i6 == 1) {
                m4078G(coordinatorLayout, appBarLayout);
                if (appBarLayout.f5788l) {
                    appBarLayout.m4069e(appBarLayout.m4070f(view2));
                }
            }
            this.f5800n = new WeakReference(view2);
        }

        @Override
        public final int mo4080t() {
            return m4097s() + this.f5796j;
        }

        @Override
        public final boolean mo4081w(View view) {
            WeakReference weakReference = this.f5800n;
            if (weakReference == null) {
                return true;
            }
            View view2 = (View) weakReference.get();
            return (view2 == null || !view2.isShown() || view2.canScrollVertically(-1)) ? false : true;
        }

        @Override
        public final int mo4082x(View view) {
            return -((AppBarLayout) view).getDownNestedScrollRange();
        }

        @Override
        public final int mo4083y(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        @Override
        public final void mo4084z(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            m4078G(coordinatorLayout, appBarLayout);
            if (appBarLayout.f5788l) {
                appBarLayout.m4069e(appBarLayout.m4070f(m4072D(coordinatorLayout)));
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.f5807a = 1;
        return layoutParams;
    }

    @Override
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}

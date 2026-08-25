package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.ViewTreeObserverOnGlobalLayoutListenerC0255q;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.C1822h;
import com.google.android.material.internal.C1824j;
import com.google.android.material.internal.C1829o;
import com.google.android.material.internal.C1832r;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import java.util.WeakHashMap;
import p001a0.C0019b;
import p002a1.C0026b;
import p034d0.AbstractC2115a;
import p093j.C2748i;
import p105k.C2840n;
import p138n0.AbstractC3155s0;
import p138n0.C3153r1;
import p156o9.AbstractC3280d;
import p201s6.AbstractC3722c;
import p221u6.AbstractC3914n;
import p221u6.C3901a;
import p221u6.C3907g;
import p221u6.C3908h;
import p221u6.C3912l;
import p221u6.C3913m;
import p221u6.C3915o;
import p222u7.AbstractC3928d;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class NavigationView extends ScrimInsetsFrameLayout {

    public static final int[] f6503r = {R.attr.state_checked};

    public static final int[] f6504s = {-16842910};

    public final C1822h f6505f;

    public final C1832r f6506g;

    public final int f6507h;

    public final int[] f6508i;

    public C2748i f6509j;

    public final ViewTreeObserverOnGlobalLayoutListenerC0255q f6510k;

    public boolean f6511l;

    public boolean f6512m;

    public final int f6513n;

    public final int f6514o;

    public Path f6515p;

    public final RectF f6516q;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1854n();

        public Bundle f6517c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6517c = parcel.readBundle(classLoader);
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeBundle(this.f6517c);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.navigationViewStyle);
    }

    private MenuInflater getMenuInflater() {
        if (this.f6509j == null) {
            this.f6509j = new C2748i(getContext());
        }
        return this.f6509j;
    }

    @Override
    public final void mo4234a(C3153r1 c3153r1) {
        C1832r c1832r = this.f6506g;
        c1832r.getClass();
        int iM6328d = c3153r1.m6328d();
        if (c1832r.f6473x != iM6328d) {
            c1832r.f6473x = iM6328d;
            int i6 = (c1832r.f6451b.getChildCount() == 0 && c1832r.f6471v) ? c1832r.f6473x : 0;
            NavigationMenuView navigationMenuView = c1832r.f6450a;
            navigationMenuView.setPadding(0, i6, 0, navigationMenuView.getPaddingBottom());
        }
        NavigationMenuView navigationMenuView2 = c1832r.f6450a;
        navigationMenuView2.setPadding(0, navigationMenuView2.getPaddingTop(), 0, c3153r1.m6325a());
        AbstractC3155s0.m6332b(c1832r.f6451b, c3153r1);
    }

    public final ColorStateList m4287b(int i6) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i6, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListM7848k = AbstractC3928d.m7848k(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(com.p2serv.android.p032ds.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i10 = typedValue.data;
        int defaultColor = colorStateListM7848k.getDefaultColor();
        int[] iArr = f6504s;
        return new ColorStateList(new int[][]{iArr, f6503r, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListM7848k.getColorForState(iArr, defaultColor), i10, defaultColor});
    }

    public final InsetDrawable m4288c(C0026b c0026b, ColorStateList colorStateList) {
        TypedArray typedArray = (TypedArray) c0026b.f55c;
        C3908h c3908h = new C3908h(C3913m.m7821a(getContext(), typedArray.getResourceId(17, 0), typedArray.getResourceId(18, 0), new C3901a(0)).m7819a());
        c3908h.m7809n(colorStateList);
        return new InsetDrawable((Drawable) c3908h, typedArray.getDimensionPixelSize(22, 0), typedArray.getDimensionPixelSize(23, 0), typedArray.getDimensionPixelSize(21, 0), typedArray.getDimensionPixelSize(20, 0));
    }

    @Override
    public final void dispatchDraw(Canvas canvas) {
        if (this.f6515p == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipPath(this.f6515p);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    public MenuItem getCheckedItem() {
        return this.f6506g.f6454e.f6441b;
    }

    public int getDividerInsetEnd() {
        return this.f6506g.f6468s;
    }

    public int getDividerInsetStart() {
        return this.f6506g.f6467r;
    }

    public int getHeaderCount() {
        return this.f6506g.f6451b.getChildCount();
    }

    public Drawable getItemBackground() {
        return this.f6506g.f6461l;
    }

    public int getItemHorizontalPadding() {
        return this.f6506g.f6463n;
    }

    public int getItemIconPadding() {
        return this.f6506g.f6465p;
    }

    public ColorStateList getItemIconTintList() {
        return this.f6506g.f6460k;
    }

    public int getItemMaxLines() {
        return this.f6506g.f6472w;
    }

    public ColorStateList getItemTextColor() {
        return this.f6506g.f6459j;
    }

    public int getItemVerticalPadding() {
        return this.f6506g.f6464o;
    }

    public Menu getMenu() {
        return this.f6505f;
    }

    public int getSubheaderInsetEnd() {
        this.f6506g.getClass();
        return 0;
    }

    public int getSubheaderInsetStart() {
        return this.f6506g.f6469t;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC3280d.m6568E(this);
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f6510k);
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int mode = View.MeasureSpec.getMode(i6);
        int i11 = this.f6507h;
        if (mode == Integer.MIN_VALUE) {
            i6 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i6), i11), 1073741824);
        } else if (mode == 0) {
            i6 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        }
        super.onMeasure(i6, i10);
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1689a);
        this.f6505f.m5835t(savedState.f6517c);
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f6517c = bundle;
        this.f6505f.m5837v(bundle);
        return savedState;
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        int i13;
        super.onSizeChanged(i6, i10, i11, i12);
        boolean z7 = getParent() instanceof DrawerLayout;
        RectF rectF = this.f6516q;
        if (!z7 || (i13 = this.f6514o) <= 0 || !(getBackground() instanceof C3908h)) {
            this.f6515p = null;
            rectF.setEmpty();
            return;
        }
        C3908h c3908h = (C3908h) getBackground();
        C3912l c3912lM7826f = c3908h.f13126a.f13107a.m7826f();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (Gravity.getAbsoluteGravity(this.f6513n, getLayoutDirection()) == 3) {
            float f = i13;
            c3912lM7826f.f13156f = new C3901a(f);
            c3912lM7826f.f13157g = new C3901a(f);
        } else {
            float f3 = i13;
            c3912lM7826f.f13155e = new C3901a(f3);
            c3912lM7826f.f13158h = new C3901a(f3);
        }
        c3908h.setShapeAppearanceModel(c3912lM7826f.m7819a());
        if (this.f6515p == null) {
            this.f6515p = new Path();
        }
        this.f6515p.reset();
        rectF.set(0.0f, 0.0f, i6, i10);
        C3915o c3915o = AbstractC3914n.f13176a;
        C3907g c3907g = c3908h.f13126a;
        c3915o.m7827a(c3907g.f13107a, c3907g.f13115i, rectF, null, this.f6515p);
        invalidate();
    }

    public void setBottomInsetScrimEnabled(boolean z7) {
        this.f6512m = z7;
    }

    public void setCheckedItem(int i6) {
        MenuItem menuItemFindItem = this.f6505f.findItem(i6);
        if (menuItemFindItem != null) {
            this.f6506g.f6454e.m4278b((C2840n) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(int i6) {
        C1832r c1832r = this.f6506g;
        c1832r.f6468s = i6;
        c1832r.mo712j(false);
    }

    public void setDividerInsetStart(int i6) {
        C1832r c1832r = this.f6506g;
        c1832r.f6467r = i6;
        c1832r.mo712j(false);
    }

    @Override
    public void setElevation(float f) {
        super.setElevation(f);
        AbstractC3280d.m6565B(this, f);
    }

    public void setItemBackground(Drawable drawable) {
        C1832r c1832r = this.f6506g;
        c1832r.f6461l = drawable;
        c1832r.mo712j(false);
    }

    public void setItemBackgroundResource(int i6) {
        setItemBackground(AbstractC2115a.m5069b(getContext(), i6));
    }

    public void setItemHorizontalPadding(int i6) {
        C1832r c1832r = this.f6506g;
        c1832r.f6463n = i6;
        c1832r.mo712j(false);
    }

    public void setItemHorizontalPaddingResource(int i6) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i6);
        C1832r c1832r = this.f6506g;
        c1832r.f6463n = dimensionPixelSize;
        c1832r.mo712j(false);
    }

    public void setItemIconPadding(int i6) {
        C1832r c1832r = this.f6506g;
        c1832r.f6465p = i6;
        c1832r.mo712j(false);
    }

    public void setItemIconPaddingResource(int i6) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i6);
        C1832r c1832r = this.f6506g;
        c1832r.f6465p = dimensionPixelSize;
        c1832r.mo712j(false);
    }

    public void setItemIconSize(int i6) {
        C1832r c1832r = this.f6506g;
        if (c1832r.f6466q != i6) {
            c1832r.f6466q = i6;
            c1832r.f6470u = true;
            c1832r.mo712j(false);
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        C1832r c1832r = this.f6506g;
        c1832r.f6460k = colorStateList;
        c1832r.mo712j(false);
    }

    public void setItemMaxLines(int i6) {
        C1832r c1832r = this.f6506g;
        c1832r.f6472w = i6;
        c1832r.mo712j(false);
    }

    public void setItemTextAppearance(int i6) {
        C1832r c1832r = this.f6506g;
        c1832r.f6458i = i6;
        c1832r.mo712j(false);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        C1832r c1832r = this.f6506g;
        c1832r.f6459j = colorStateList;
        c1832r.mo712j(false);
    }

    public void setItemVerticalPadding(int i6) {
        C1832r c1832r = this.f6506g;
        c1832r.f6464o = i6;
        c1832r.mo712j(false);
    }

    public void setItemVerticalPaddingResource(int i6) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i6);
        C1832r c1832r = this.f6506g;
        c1832r.f6464o = dimensionPixelSize;
        c1832r.mo712j(false);
    }

    @Override
    public void setOverScrollMode(int i6) {
        super.setOverScrollMode(i6);
        C1832r c1832r = this.f6506g;
        if (c1832r != null) {
            c1832r.f6475z = i6;
            NavigationMenuView navigationMenuView = c1832r.f6450a;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i6);
            }
        }
    }

    public void setSubheaderInsetEnd(int i6) {
        C1832r c1832r = this.f6506g;
        c1832r.f6469t = i6;
        c1832r.mo712j(false);
    }

    public void setSubheaderInsetStart(int i6) {
        C1832r c1832r = this.f6506g;
        c1832r.f6469t = i6;
        c1832r.mo712j(false);
    }

    public void setTopInsetScrimEnabled(boolean z7) {
        this.f6511l = z7;
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_Design_NavigationView), attributeSet, i6);
        C1832r c1832r = new C1832r();
        this.f6506g = c1832r;
        this.f6508i = new int[2];
        this.f6511l = true;
        this.f6512m = true;
        this.f6513n = 0;
        this.f6514o = 0;
        this.f6516q = new RectF();
        Context context2 = getContext();
        C1822h c1822h = new C1822h(context2);
        this.f6505f = c1822h;
        C0026b c0026bM4251k = AbstractC1811a0.m4251k(context2, attributeSet, AbstractC4121a.f13970N, i6, com.p2serv.android.p032ds.R.style.Widget_Design_NavigationView, new int[0]);
        TypedArray typedArray = (TypedArray) c0026bM4251k.f55c;
        if (typedArray.hasValue(1)) {
            Drawable drawableM140t = c0026bM4251k.m140t(1);
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            setBackground(drawableM140t);
        }
        this.f6514o = typedArray.getDimensionPixelSize(7, 0);
        this.f6513n = typedArray.getInt(0, 0);
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            C3913m c3913mM7819a = C3913m.m7822b(context2, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_Design_NavigationView).m7819a();
            Drawable background = getBackground();
            C3908h c3908h = new C3908h(c3913mM7819a);
            if (background instanceof ColorDrawable) {
                c3908h.m7809n(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            c3908h.m7806k(context2);
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            setBackground(c3908h);
        }
        if (typedArray.hasValue(8)) {
            setElevation(typedArray.getDimensionPixelSize(8, 0));
        }
        setFitsSystemWindows(typedArray.getBoolean(2, false));
        this.f6507h = typedArray.getDimensionPixelSize(3, 0);
        ColorStateList colorStateListM139s = typedArray.hasValue(30) ? c0026bM4251k.m139s(30) : null;
        int resourceId = typedArray.hasValue(33) ? typedArray.getResourceId(33, 0) : 0;
        if (resourceId == 0 && colorStateListM139s == null) {
            colorStateListM139s = m4287b(R.attr.textColorSecondary);
        }
        ColorStateList colorStateListM139s2 = typedArray.hasValue(14) ? c0026bM4251k.m139s(14) : m4287b(R.attr.textColorSecondary);
        int resourceId2 = typedArray.hasValue(24) ? typedArray.getResourceId(24, 0) : 0;
        if (typedArray.hasValue(13)) {
            setItemIconSize(typedArray.getDimensionPixelSize(13, 0));
        }
        ColorStateList colorStateListM139s3 = typedArray.hasValue(25) ? c0026bM4251k.m139s(25) : null;
        if (resourceId2 == 0 && colorStateListM139s3 == null) {
            colorStateListM139s3 = m4287b(R.attr.textColorPrimary);
        }
        Drawable drawableM140t2 = c0026bM4251k.m140t(10);
        if (drawableM140t2 == null && (typedArray.hasValue(17) || typedArray.hasValue(18))) {
            drawableM140t2 = m4288c(c0026bM4251k, AbstractC1466d.m3492j(getContext(), c0026bM4251k, 19));
            ColorStateList colorStateListM3492j = AbstractC1466d.m3492j(context2, c0026bM4251k, 16);
            if (colorStateListM3492j != null) {
                c1832r.f6462m = new RippleDrawable(AbstractC3722c.m7485b(colorStateListM3492j), null, m4288c(c0026bM4251k, null));
                c1832r.mo712j(false);
            }
        }
        if (typedArray.hasValue(11)) {
            setItemHorizontalPadding(typedArray.getDimensionPixelSize(11, 0));
        }
        if (typedArray.hasValue(26)) {
            setItemVerticalPadding(typedArray.getDimensionPixelSize(26, 0));
        }
        setDividerInsetStart(typedArray.getDimensionPixelSize(6, 0));
        setDividerInsetEnd(typedArray.getDimensionPixelSize(5, 0));
        setSubheaderInsetStart(typedArray.getDimensionPixelSize(32, 0));
        setSubheaderInsetEnd(typedArray.getDimensionPixelSize(31, 0));
        setTopInsetScrimEnabled(typedArray.getBoolean(34, this.f6511l));
        setBottomInsetScrimEnabled(typedArray.getBoolean(4, this.f6512m));
        int dimensionPixelSize = typedArray.getDimensionPixelSize(12, 0);
        setItemMaxLines(typedArray.getInt(15, 1));
        c1822h.f9691e = new C0019b(20, this);
        c1832r.f6453d = 1;
        c1832r.mo713k(context2, c1822h);
        if (resourceId != 0) {
            c1832r.f6456g = resourceId;
            c1832r.mo712j(false);
        }
        c1832r.f6457h = colorStateListM139s;
        c1832r.mo712j(false);
        c1832r.f6460k = colorStateListM139s2;
        c1832r.mo712j(false);
        int overScrollMode = getOverScrollMode();
        c1832r.f6475z = overScrollMode;
        NavigationMenuView navigationMenuView = c1832r.f6450a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(overScrollMode);
        }
        if (resourceId2 != 0) {
            c1832r.f6458i = resourceId2;
            c1832r.mo712j(false);
        }
        c1832r.f6459j = colorStateListM139s3;
        c1832r.mo712j(false);
        c1832r.f6461l = drawableM140t2;
        c1832r.mo712j(false);
        c1832r.f6465p = dimensionPixelSize;
        c1832r.mo712j(false);
        c1822h.m5826b(c1832r, c1822h.f9687a);
        if (c1832r.f6450a == null) {
            NavigationMenuView navigationMenuView2 = (NavigationMenuView) c1832r.f6455f.inflate(com.p2serv.android.p032ds.R.layout.design_navigation_menu, (ViewGroup) this, false);
            c1832r.f6450a = navigationMenuView2;
            navigationMenuView2.setAccessibilityDelegateCompat(new C1829o(c1832r, c1832r.f6450a));
            if (c1832r.f6454e == null) {
                c1832r.f6454e = new C1824j(c1832r);
            }
            int i10 = c1832r.f6475z;
            if (i10 != -1) {
                c1832r.f6450a.setOverScrollMode(i10);
            }
            c1832r.f6451b = (LinearLayout) c1832r.f6455f.inflate(com.p2serv.android.p032ds.R.layout.design_navigation_item_header, (ViewGroup) c1832r.f6450a, false);
            c1832r.f6450a.setAdapter(c1832r.f6454e);
        }
        addView(c1832r.f6450a);
        if (typedArray.hasValue(27)) {
            int resourceId3 = typedArray.getResourceId(27, 0);
            C1824j c1824j = c1832r.f6454e;
            if (c1824j != null) {
                c1824j.f6442c = true;
            }
            getMenuInflater().inflate(resourceId3, c1822h);
            C1824j c1824j2 = c1832r.f6454e;
            if (c1824j2 != null) {
                c1824j2.f6442c = false;
            }
            c1832r.mo712j(false);
        }
        if (typedArray.hasValue(9)) {
            c1832r.f6451b.addView(c1832r.f6455f.inflate(typedArray.getResourceId(9, 0), (ViewGroup) c1832r.f6451b, false));
            NavigationMenuView navigationMenuView3 = c1832r.f6450a;
            navigationMenuView3.setPadding(0, 0, 0, navigationMenuView3.getPaddingBottom());
        }
        c0026bM4251k.m120F();
        this.f6510k = new ViewTreeObserverOnGlobalLayoutListenerC0255q(3, this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f6510k);
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f6505f.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.f6506g.f6454e.m4278b((C2840n) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public void setNavigationItemSelectedListener(InterfaceC1853m interfaceC1853m) {
    }
}

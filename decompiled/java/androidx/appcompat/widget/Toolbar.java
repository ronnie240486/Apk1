package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.ActionBar$LayoutParams;
import androidx.appcompat.app.C0155q0;
import androidx.appcompat.app.C0157r0;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.customview.view.AbsSavedState;
import com.bumptech.glide.AbstractC1465c;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import p000a.AbstractC0004e;
import p000a.RunnableC0005f;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p093j.C2748i;
import p105k.C2840n;
import p105k.MenuC2838l;
import p124l6.C2982h;
import p138n0.AbstractC3155s0;
import p187r4.AbstractC3612b;

public class Toolbar extends ViewGroup {

    public ColorStateList f807A;

    public boolean f808B;

    public boolean f809C;

    public final ArrayList f810D;

    public final ArrayList f811E;

    public final int[] f812F;

    public final C2982h f813G;

    public ArrayList f814H;

    public InterfaceC0264r3 f815I;

    public final C0249o3 f816J;

    public C0284v3 f817K;

    public C0225k f818L;

    public C0259q3 f819M;

    public C0157r0 f820N;

    public C0155q0 f821O;

    public boolean f822P;

    public OnBackInvokedCallback f823Q;

    public OnBackInvokedDispatcher f824R;

    public boolean f825S;

    public final RunnableC0005f f826T;

    public ActionMenuView f827a;

    public AppCompatTextView f828b;

    public AppCompatTextView f829c;

    public AppCompatImageButton f830d;

    public AppCompatImageView f831e;

    public final Drawable f832f;

    public final CharSequence f833g;

    public AppCompatImageButton f834h;

    public View f835i;

    public Context f836j;

    public int f837k;

    public int f838l;

    public int f839m;

    public final int f840n;

    public final int f841o;

    public int f842p;

    public int f843q;

    public int f844r;

    public int f845s;

    public C0243n2 f846t;

    public int f847u;

    public int f848v;

    public final int f849w;

    public CharSequence f850x;

    public CharSequence f851y;

    public ColorStateList f852z;

    public static class LayoutParams extends ActionBar$LayoutParams {

        public int f853b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f853b = 0;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0269s3();

        public int f854c;

        public boolean f855d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f854c = parcel.readInt();
            this.f855d = parcel.readInt() != 0;
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f854c);
            parcel.writeInt(this.f855d ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i6 = 0; i6 < menu.size(); i6++) {
            arrayList.add(menu.getItem(i6));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new C2748i(getContext());
    }

    public static LayoutParams m609h() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.f853b = 0;
        layoutParams.f247a = 8388627;
        return layoutParams;
    }

    public static LayoutParams m610i(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(layoutParams2);
            layoutParams3.f853b = 0;
            layoutParams3.f853b = layoutParams2.f853b;
            return layoutParams3;
        }
        if (layoutParams instanceof ActionBar$LayoutParams) {
            LayoutParams layoutParams4 = new LayoutParams((ActionBar$LayoutParams) layoutParams);
            layoutParams4.f853b = 0;
            return layoutParams4;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            LayoutParams layoutParams5 = new LayoutParams(layoutParams);
            layoutParams5.f853b = 0;
            return layoutParams5;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        LayoutParams layoutParams6 = new LayoutParams(marginLayoutParams);
        layoutParams6.f853b = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin = marginLayoutParams.bottomMargin;
        return layoutParams6;
    }

    public static int m611l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int m612m(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void m613a(int i6, ArrayList arrayList) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean z7 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i6, getLayoutDirection());
        arrayList.clear();
        if (!z7) {
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f853b == 0 && m629u(childAt) && m620j(layoutParams.f247a) == absoluteGravity) {
                    arrayList.add(childAt);
                }
            }
            return;
        }
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            View childAt2 = getChildAt(i11);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f853b == 0 && m629u(childAt2) && m620j(layoutParams2.f247a) == absoluteGravity) {
                arrayList.add(childAt2);
            }
        }
    }

    public final void m614b(View view, boolean z7) {
        LayoutParams layoutParamsM610i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParamsM610i = m609h();
        } else {
            layoutParamsM610i = !checkLayoutParams(layoutParams) ? m610i(layoutParams) : (LayoutParams) layoutParams;
        }
        layoutParamsM610i.f853b = 1;
        if (!z7 || this.f835i == null) {
            addView(view, layoutParamsM610i);
        } else {
            view.setLayoutParams(layoutParamsM610i);
            this.f811E.add(view);
        }
    }

    public final void m615c() {
        if (this.f834h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f834h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f832f);
            this.f834h.setContentDescription(this.f833g);
            LayoutParams layoutParamsM609h = m609h();
            layoutParamsM609h.f247a = (this.f840n & 112) | 8388611;
            layoutParamsM609h.f853b = 2;
            this.f834h.setLayoutParams(layoutParamsM609h);
            this.f834h.setOnClickListener(new ViewOnClickListenerC0122a(2, this));
        }
    }

    @Override
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public final void m616d() {
        if (this.f846t == null) {
            C0243n2 c0243n2 = new C0243n2();
            c0243n2.f1011a = 0;
            c0243n2.f1012b = 0;
            c0243n2.f1013c = Integer.MIN_VALUE;
            c0243n2.f1014d = Integer.MIN_VALUE;
            c0243n2.f1015e = 0;
            c0243n2.f1016f = 0;
            c0243n2.f1017g = false;
            c0243n2.f1018h = false;
            this.f846t = c0243n2;
        }
    }

    public final void m617e() {
        m618f();
        ActionMenuView actionMenuView = this.f827a;
        if (actionMenuView.f576p == null) {
            MenuC2838l menuC2838l = (MenuC2838l) actionMenuView.getMenu();
            if (this.f819M == null) {
                this.f819M = new C0259q3(this);
            }
            this.f827a.setExpandedActionViewsExclusive(true);
            menuC2838l.m5826b(this.f819M, this.f836j);
            m631w();
        }
    }

    public final void m618f() {
        if (this.f827a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f827a = actionMenuView;
            actionMenuView.setPopupTheme(this.f837k);
            this.f827a.setOnMenuItemClickListener(this.f816J);
            ActionMenuView actionMenuView2 = this.f827a;
            C0157r0 c0157r0 = this.f820N;
            C0249o3 c0249o3 = new C0249o3(this);
            actionMenuView2.f581u = c0157r0;
            actionMenuView2.f582v = c0249o3;
            LayoutParams layoutParamsM609h = m609h();
            layoutParamsM609h.f247a = (this.f840n & 112) | 8388613;
            this.f827a.setLayoutParams(layoutParamsM609h);
            m614b(this.f827a, false);
        }
    }

    public final void m619g() {
        if (this.f830d == null) {
            this.f830d = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams layoutParamsM609h = m609h();
            layoutParamsM609h.f247a = (this.f840n & 112) | 8388611;
            this.f830d.setLayoutParams(layoutParamsM609h);
        }
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m609h();
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m610i(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        AppCompatImageButton appCompatImageButton = this.f834h;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        AppCompatImageButton appCompatImageButton = this.f834h;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        C0243n2 c0243n2 = this.f846t;
        if (c0243n2 != null) {
            return c0243n2.f1017g ? c0243n2.f1011a : c0243n2.f1012b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i6 = this.f848v;
        return i6 != Integer.MIN_VALUE ? i6 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        C0243n2 c0243n2 = this.f846t;
        if (c0243n2 != null) {
            return c0243n2.f1011a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        C0243n2 c0243n2 = this.f846t;
        if (c0243n2 != null) {
            return c0243n2.f1012b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        C0243n2 c0243n2 = this.f846t;
        if (c0243n2 != null) {
            return c0243n2.f1017g ? c0243n2.f1012b : c0243n2.f1011a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i6 = this.f847u;
        return i6 != Integer.MIN_VALUE ? i6 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuC2838l menuC2838l;
        ActionMenuView actionMenuView = this.f827a;
        return (actionMenuView == null || (menuC2838l = actionMenuView.f576p) == null || !menuC2838l.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f848v, 0));
    }

    public int getCurrentContentInsetLeft() {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f847u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        AppCompatImageView appCompatImageView = this.f831e;
        if (appCompatImageView != null) {
            return appCompatImageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        AppCompatImageView appCompatImageView = this.f831e;
        if (appCompatImageView != null) {
            return appCompatImageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        m617e();
        return this.f827a.getMenu();
    }

    public View getNavButtonView() {
        return this.f830d;
    }

    public CharSequence getNavigationContentDescription() {
        AppCompatImageButton appCompatImageButton = this.f830d;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        AppCompatImageButton appCompatImageButton = this.f830d;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public C0225k getOuterActionMenuPresenter() {
        return this.f818L;
    }

    public Drawable getOverflowIcon() {
        m617e();
        return this.f827a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f836j;
    }

    public int getPopupTheme() {
        return this.f837k;
    }

    public CharSequence getSubtitle() {
        return this.f851y;
    }

    public final TextView getSubtitleTextView() {
        return this.f829c;
    }

    public CharSequence getTitle() {
        return this.f850x;
    }

    public int getTitleMarginBottom() {
        return this.f845s;
    }

    public int getTitleMarginEnd() {
        return this.f843q;
    }

    public int getTitleMarginStart() {
        return this.f842p;
    }

    public int getTitleMarginTop() {
        return this.f844r;
    }

    public final TextView getTitleTextView() {
        return this.f828b;
    }

    public InterfaceC0222j1 getWrapper() {
        if (this.f817K == null) {
            this.f817K = new C0284v3(this, true);
        }
        return this.f817K;
    }

    public final int m620j(int i6) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int layoutDirection = getLayoutDirection();
        int absoluteGravity = Gravity.getAbsoluteGravity(i6, layoutDirection) & 7;
        if (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) {
            return absoluteGravity;
        }
        return layoutDirection == 1 ? 5 : 3;
    }

    public final int m621k(int i6, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i10 = i6 > 0 ? (measuredHeight - i6) / 2 : 0;
        int i11 = layoutParams.f247a & 112;
        if (i11 != 16 && i11 != 48 && i11 != 80) {
            i11 = this.f849w & 112;
        }
        if (i11 == 48) {
            return getPaddingTop() - i10;
        }
        if (i11 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i10;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        if (iMax < i12) {
            iMax = i12;
        } else {
            int i13 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (i13 < i14) {
                iMax = Math.max(0, iMax - (i14 - i13));
            }
        }
        return paddingTop + iMax;
    }

    public final void m622n() {
        Iterator it = this.f814H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it2 = ((CopyOnWriteArrayList) this.f813G.f10226c).iterator();
        if (it2.hasNext()) {
            throw AbstractC0004e.m18l(it2);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f814H = currentMenuItems2;
    }

    public final boolean m623o(View view) {
        return view.getParent() == this || this.f811E.contains(view);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m631w();
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f826T);
        m631w();
    }

    @Override
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f809C = false;
        }
        if (!this.f809C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f809C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f809C = false;
        }
        return true;
    }

    @Override
    public void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        int iM625q;
        int iM626r;
        int iMax;
        int iMin;
        boolean zM629u;
        boolean zM629u2;
        int measuredHeight;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        boolean z10;
        int i13;
        int i14;
        int paddingTop;
        int i15;
        int iMax2;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int iMax3;
        int i21;
        int i22;
        int i23;
        int i24;
        ArrayList arrayList;
        int size;
        int iM625q2;
        int i25;
        int i26;
        int size2;
        int i27;
        int size3;
        int i28;
        int i29;
        int i30;
        int measuredWidth;
        int i31;
        int i32;
        int size4;
        int i33;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean z11 = getLayoutDirection() == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i34 = width - paddingRight;
        int[] iArr = this.f812F;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = getMinimumHeight();
        int iMin2 = minimumHeight >= 0 ? Math.min(minimumHeight, i12 - i10) : 0;
        if (m629u(this.f830d)) {
            if (z11) {
                iM626r = m626r(this.f830d, i34, iMin2, iArr);
                iM625q = paddingLeft;
            } else {
                iM625q = m625q(this.f830d, paddingLeft, iMin2, iArr);
            }
            if (m629u(this.f834h)) {
                if (z11) {
                    iM626r = m626r(this.f834h, iM626r, iMin2, iArr);
                } else {
                    iM625q = m625q(this.f834h, iM625q, iMin2, iArr);
                }
            }
            if (m629u(this.f827a)) {
                if (z11) {
                    iM625q = m625q(this.f827a, iM625q, iMin2, iArr);
                } else {
                    iM626r = m626r(this.f827a, iM626r, iMin2, iArr);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - iM625q);
            iArr[1] = Math.max(0, currentContentInsetRight - (i34 - iM626r));
            iMax = Math.max(iM625q, currentContentInsetLeft);
            iMin = Math.min(iM626r, i34 - currentContentInsetRight);
            if (m629u(this.f835i)) {
                if (z11) {
                    iMin = m626r(this.f835i, iMin, iMin2, iArr);
                } else {
                    iMax = m625q(this.f835i, iMax, iMin2, iArr);
                }
            }
            if (m629u(this.f831e)) {
                if (z11) {
                    iMin = m626r(this.f831e, iMin, iMin2, iArr);
                } else {
                    iMax = m625q(this.f831e, iMax, iMin2, iArr);
                }
            }
            zM629u = m629u(this.f828b);
            zM629u2 = m629u(this.f829c);
            if (zM629u) {
                LayoutParams layoutParams3 = (LayoutParams) this.f828b.getLayoutParams();
                measuredHeight = ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + this.f828b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin;
            } else {
                measuredHeight = 0;
            }
            if (zM629u2) {
                LayoutParams layoutParams4 = (LayoutParams) this.f829c.getLayoutParams();
                measuredHeight += this.f829c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin;
            }
            if (!zM629u || zM629u2) {
                if (zM629u) {
                    appCompatTextView = this.f828b;
                } else {
                    appCompatTextView = this.f829c;
                }
                if (zM629u2) {
                    appCompatTextView2 = this.f829c;
                } else {
                    appCompatTextView2 = this.f828b;
                }
                layoutParams = (LayoutParams) appCompatTextView.getLayoutParams();
                layoutParams2 = (LayoutParams) appCompatTextView2.getLayoutParams();
                z10 = (!zM629u && this.f828b.getMeasuredWidth() > 0) || (zM629u2 && this.f829c.getMeasuredWidth() > 0);
                i13 = this.f849w & 112;
                i14 = iMin2;
                if (i13 == 48) {
                    paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.f844r;
                } else if (i13 != 80) {
                    iMax3 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    i21 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.f844r;
                    if (iMax3 < i21) {
                        iMax3 = i21;
                    } else {
                        i22 = (((height - paddingBottom) - measuredHeight) - iMax3) - paddingTop2;
                        i23 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        i24 = this.f845s;
                        if (i22 < i23 + i24) {
                            iMax3 = Math.max(0, iMax3 - ((((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + i24) - i22));
                        }
                    }
                    paddingTop = paddingTop2 + iMax3;
                } else {
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) - this.f845s) - measuredHeight;
                }
                if (z11) {
                    if (z10) {
                        i18 = this.f842p;
                    } else {
                        i18 = 0;
                    }
                    int i35 = i18 - iArr[1];
                    iMin -= Math.max(0, i35);
                    iArr[1] = Math.max(0, -i35);
                    if (zM629u) {
                        LayoutParams layoutParams5 = (LayoutParams) this.f828b.getLayoutParams();
                        int measuredWidth2 = iMin - this.f828b.getMeasuredWidth();
                        int measuredHeight2 = this.f828b.getMeasuredHeight() + paddingTop;
                        this.f828b.layout(measuredWidth2, paddingTop, iMin, measuredHeight2);
                        i19 = measuredWidth2 - this.f843q;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin;
                    } else {
                        i19 = iMin;
                    }
                    if (zM629u2) {
                        int i36 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f829c.getLayoutParams())).topMargin;
                        this.f829c.layout(iMin - this.f829c.getMeasuredWidth(), i36, iMin, this.f829c.getMeasuredHeight() + i36);
                        i20 = iMin - this.f843q;
                    } else {
                        i20 = iMin;
                    }
                    if (z10) {
                        iMin = Math.min(i19, i20);
                    }
                    iMax = iMax;
                } else {
                    if (z10) {
                        i15 = this.f842p;
                    } else {
                        i15 = 0;
                    }
                    int i37 = i15 - iArr[0];
                    iMax2 = Math.max(0, i37) + iMax;
                    iArr[0] = Math.max(0, -i37);
                    if (zM629u) {
                        LayoutParams layoutParams6 = (LayoutParams) this.f828b.getLayoutParams();
                        int measuredWidth3 = this.f828b.getMeasuredWidth() + iMax2;
                        int measuredHeight3 = this.f828b.getMeasuredHeight() + paddingTop;
                        this.f828b.layout(iMax2, paddingTop, measuredWidth3, measuredHeight3);
                        i16 = measuredWidth3 + this.f843q;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin;
                    } else {
                        i16 = iMax2;
                    }
                    if (zM629u2) {
                        int i38 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f829c.getLayoutParams())).topMargin;
                        int measuredWidth4 = this.f829c.getMeasuredWidth() + iMax2;
                        this.f829c.layout(iMax2, i38, measuredWidth4, this.f829c.getMeasuredHeight() + i38);
                        i17 = measuredWidth4 + this.f843q;
                    } else {
                        i17 = iMax2;
                    }
                    if (z10) {
                        iMax = Math.max(i16, i17);
                    } else {
                        iMax = iMax2;
                    }
                }
            } else {
                paddingLeft = paddingLeft;
                i14 = iMin2;
            }
            arrayList = this.f810D;
            m613a(3, arrayList);
            size = arrayList.size();
            iM625q2 = iMax;
            for (i25 = 0; i25 < size; i25++) {
                iM625q2 = m625q((View) arrayList.get(i25), iM625q2, i14, iArr);
            }
            i26 = i14;
            m613a(5, arrayList);
            size2 = arrayList.size();
            for (i27 = 0; i27 < size2; i27++) {
                iMin = m626r((View) arrayList.get(i27), iMin, i26, iArr);
            }
            m613a(1, arrayList);
            int i39 = iArr[0];
            int i40 = iArr[1];
            size3 = arrayList.size();
            i28 = i40;
            i29 = i39;
            i30 = 0;
            measuredWidth = 0;
            while (i30 < size3) {
                View view = (View) arrayList.get(i30);
                LayoutParams layoutParams7 = (LayoutParams) view.getLayoutParams();
                int i41 = ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin - i29;
                int i42 = ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin - i28;
                int iMax4 = Math.max(0, i41);
                int iMax5 = Math.max(0, i42);
                int iMax6 = Math.max(0, -i41);
                int iMax7 = Math.max(0, -i42);
                measuredWidth += view.getMeasuredWidth() + iMax4 + iMax5;
                i30++;
                i28 = iMax7;
                i29 = iMax6;
            }
            i31 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
            i32 = measuredWidth + i31;
            if (i31 >= iM625q2) {
                if (i32 > iMin) {
                    iM625q2 = i31 - (i32 - iMin);
                } else {
                    iM625q2 = i31;
                }
            }
            size4 = arrayList.size();
            for (i33 = 0; i33 < size4; i33++) {
                iM625q2 = m625q((View) arrayList.get(i33), iM625q2, i26, iArr);
            }
            arrayList.clear();
        }
        iM625q = paddingLeft;
        iM626r = i34;
        if (m629u(this.f834h)) {
            if (z11) {
                iM626r = m626r(this.f834h, iM626r, iMin2, iArr);
            } else {
                iM625q = m625q(this.f834h, iM625q, iMin2, iArr);
            }
        }
        if (m629u(this.f827a)) {
            if (z11) {
                iM625q = m625q(this.f827a, iM625q, iMin2, iArr);
            } else {
                iM626r = m626r(this.f827a, iM626r, iMin2, iArr);
            }
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iM625q);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i34 - iM626r));
        iMax = Math.max(iM625q, currentContentInsetLeft2);
        iMin = Math.min(iM626r, i34 - currentContentInsetRight2);
        if (m629u(this.f835i)) {
            if (z11) {
                iMin = m626r(this.f835i, iMin, iMin2, iArr);
            } else {
                iMax = m625q(this.f835i, iMax, iMin2, iArr);
            }
        }
        if (m629u(this.f831e)) {
            if (z11) {
                iMin = m626r(this.f831e, iMin, iMin2, iArr);
            } else {
                iMax = m625q(this.f831e, iMax, iMin2, iArr);
            }
        }
        zM629u = m629u(this.f828b);
        zM629u2 = m629u(this.f829c);
        if (zM629u) {
            LayoutParams layoutParams8 = (LayoutParams) this.f828b.getLayoutParams();
            measuredHeight = ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin + this.f828b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin;
        } else {
            measuredHeight = 0;
        }
        if (zM629u2) {
            LayoutParams layoutParams9 = (LayoutParams) this.f829c.getLayoutParams();
            measuredHeight += this.f829c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin;
        }
        if (zM629u) {
            if (zM629u) {
                appCompatTextView = this.f828b;
            } else {
                appCompatTextView = this.f829c;
            }
            if (zM629u2) {
                appCompatTextView2 = this.f829c;
            } else {
                appCompatTextView2 = this.f828b;
            }
            layoutParams = (LayoutParams) appCompatTextView.getLayoutParams();
            layoutParams2 = (LayoutParams) appCompatTextView2.getLayoutParams();
            if (zM629u) {
            }
            i13 = this.f849w & 112;
            i14 = iMin2;
            if (i13 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.f844r;
            } else if (i13 != 80) {
                iMax3 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i21 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.f844r;
                if (iMax3 < i21) {
                    iMax3 = i21;
                } else {
                    i22 = (((height - paddingBottom) - measuredHeight) - iMax3) - paddingTop2;
                    i23 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    i24 = this.f845s;
                    if (i22 < i23 + i24) {
                        iMax3 = Math.max(0, iMax3 - ((((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + i24) - i22));
                    }
                }
                paddingTop = paddingTop2 + iMax3;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) - this.f845s) - measuredHeight;
            }
            if (z11) {
                if (z10) {
                    i18 = this.f842p;
                } else {
                    i18 = 0;
                }
                int i310 = i18 - iArr[1];
                iMin -= Math.max(0, i310);
                iArr[1] = Math.max(0, -i310);
                if (zM629u) {
                    LayoutParams layoutParams10 = (LayoutParams) this.f828b.getLayoutParams();
                    int measuredWidth5 = iMin - this.f828b.getMeasuredWidth();
                    int measuredHeight4 = this.f828b.getMeasuredHeight() + paddingTop;
                    this.f828b.layout(measuredWidth5, paddingTop, iMin, measuredHeight4);
                    i19 = measuredWidth5 - this.f843q;
                    paddingTop = measuredHeight4 + ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin;
                } else {
                    i19 = iMin;
                }
                if (zM629u2) {
                    int i311 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f829c.getLayoutParams())).topMargin;
                    this.f829c.layout(iMin - this.f829c.getMeasuredWidth(), i311, iMin, this.f829c.getMeasuredHeight() + i311);
                    i20 = iMin - this.f843q;
                } else {
                    i20 = iMin;
                }
                if (z10) {
                    iMin = Math.min(i19, i20);
                }
                iMax = iMax;
            } else {
                if (z10) {
                    i15 = this.f842p;
                } else {
                    i15 = 0;
                }
                int i312 = i15 - iArr[0];
                iMax2 = Math.max(0, i312) + iMax;
                iArr[0] = Math.max(0, -i312);
                if (zM629u) {
                    LayoutParams layoutParams11 = (LayoutParams) this.f828b.getLayoutParams();
                    int measuredWidth6 = this.f828b.getMeasuredWidth() + iMax2;
                    int measuredHeight5 = this.f828b.getMeasuredHeight() + paddingTop;
                    this.f828b.layout(iMax2, paddingTop, measuredWidth6, measuredHeight5);
                    i16 = measuredWidth6 + this.f843q;
                    paddingTop = measuredHeight5 + ((ViewGroup.MarginLayoutParams) layoutParams11).bottomMargin;
                } else {
                    i16 = iMax2;
                }
                if (zM629u2) {
                    int i313 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f829c.getLayoutParams())).topMargin;
                    int measuredWidth7 = this.f829c.getMeasuredWidth() + iMax2;
                    this.f829c.layout(iMax2, i313, measuredWidth7, this.f829c.getMeasuredHeight() + i313);
                    i17 = measuredWidth7 + this.f843q;
                } else {
                    i17 = iMax2;
                }
                if (z10) {
                    iMax = Math.max(i16, i17);
                } else {
                    iMax = iMax2;
                }
            }
        } else {
            if (zM629u) {
                appCompatTextView = this.f828b;
            } else {
                appCompatTextView = this.f829c;
            }
            if (zM629u2) {
                appCompatTextView2 = this.f829c;
            } else {
                appCompatTextView2 = this.f828b;
            }
            layoutParams = (LayoutParams) appCompatTextView.getLayoutParams();
            layoutParams2 = (LayoutParams) appCompatTextView2.getLayoutParams();
            if (zM629u) {
            }
            i13 = this.f849w & 112;
            i14 = iMin2;
            if (i13 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.f844r;
            } else if (i13 != 80) {
                iMax3 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i21 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.f844r;
                if (iMax3 < i21) {
                    iMax3 = i21;
                } else {
                    i22 = (((height - paddingBottom) - measuredHeight) - iMax3) - paddingTop2;
                    i23 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    i24 = this.f845s;
                    if (i22 < i23 + i24) {
                        iMax3 = Math.max(0, iMax3 - ((((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + i24) - i22));
                    }
                }
                paddingTop = paddingTop2 + iMax3;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) - this.f845s) - measuredHeight;
            }
            if (z11) {
                if (z10) {
                    i18 = this.f842p;
                } else {
                    i18 = 0;
                }
                int i314 = i18 - iArr[1];
                iMin -= Math.max(0, i314);
                iArr[1] = Math.max(0, -i314);
                if (zM629u) {
                    LayoutParams layoutParams12 = (LayoutParams) this.f828b.getLayoutParams();
                    int measuredWidth8 = iMin - this.f828b.getMeasuredWidth();
                    int measuredHeight6 = this.f828b.getMeasuredHeight() + paddingTop;
                    this.f828b.layout(measuredWidth8, paddingTop, iMin, measuredHeight6);
                    i19 = measuredWidth8 - this.f843q;
                    paddingTop = measuredHeight6 + ((ViewGroup.MarginLayoutParams) layoutParams12).bottomMargin;
                } else {
                    i19 = iMin;
                }
                if (zM629u2) {
                    int i315 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f829c.getLayoutParams())).topMargin;
                    this.f829c.layout(iMin - this.f829c.getMeasuredWidth(), i315, iMin, this.f829c.getMeasuredHeight() + i315);
                    i20 = iMin - this.f843q;
                } else {
                    i20 = iMin;
                }
                if (z10) {
                    iMin = Math.min(i19, i20);
                }
                iMax = iMax;
            } else {
                if (z10) {
                    i15 = this.f842p;
                } else {
                    i15 = 0;
                }
                int i316 = i15 - iArr[0];
                iMax2 = Math.max(0, i316) + iMax;
                iArr[0] = Math.max(0, -i316);
                if (zM629u) {
                    LayoutParams layoutParams13 = (LayoutParams) this.f828b.getLayoutParams();
                    int measuredWidth9 = this.f828b.getMeasuredWidth() + iMax2;
                    int measuredHeight7 = this.f828b.getMeasuredHeight() + paddingTop;
                    this.f828b.layout(iMax2, paddingTop, measuredWidth9, measuredHeight7);
                    i16 = measuredWidth9 + this.f843q;
                    paddingTop = measuredHeight7 + ((ViewGroup.MarginLayoutParams) layoutParams13).bottomMargin;
                } else {
                    i16 = iMax2;
                }
                if (zM629u2) {
                    int i317 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f829c.getLayoutParams())).topMargin;
                    int measuredWidth10 = this.f829c.getMeasuredWidth() + iMax2;
                    this.f829c.layout(iMax2, i317, measuredWidth10, this.f829c.getMeasuredHeight() + i317);
                    i17 = measuredWidth10 + this.f843q;
                } else {
                    i17 = iMax2;
                }
                if (z10) {
                    iMax = Math.max(i16, i17);
                } else {
                    iMax = iMax2;
                }
            }
        }
        arrayList = this.f810D;
        m613a(3, arrayList);
        size = arrayList.size();
        iM625q2 = iMax;
        while (i25 < size) {
            iM625q2 = m625q((View) arrayList.get(i25), iM625q2, i14, iArr);
        }
        i26 = i14;
        m613a(5, arrayList);
        size2 = arrayList.size();
        while (i27 < size2) {
            iMin = m626r((View) arrayList.get(i27), iMin, i26, iArr);
        }
        m613a(1, arrayList);
        int i318 = iArr[0];
        int i43 = iArr[1];
        size3 = arrayList.size();
        i28 = i43;
        i29 = i318;
        i30 = 0;
        measuredWidth = 0;
        while (i30 < size3) {
            View view2 = (View) arrayList.get(i30);
            LayoutParams layoutParams14 = (LayoutParams) view2.getLayoutParams();
            int i44 = ((ViewGroup.MarginLayoutParams) layoutParams14).leftMargin - i29;
            int i45 = ((ViewGroup.MarginLayoutParams) layoutParams14).rightMargin - i28;
            int iMax8 = Math.max(0, i44);
            int iMax9 = Math.max(0, i45);
            int iMax10 = Math.max(0, -i44);
            int iMax11 = Math.max(0, -i45);
            measuredWidth += view2.getMeasuredWidth() + iMax8 + iMax9;
            i30++;
            i28 = iMax11;
            i29 = iMax10;
        }
        i31 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        i32 = measuredWidth + i31;
        if (i31 >= iM625q2) {
            if (i32 > iMin) {
                iM625q2 = i31 - (i32 - iMin);
            } else {
                iM625q2 = i31;
            }
        }
        size4 = arrayList.size();
        while (i33 < size4) {
            iM625q2 = m625q((View) arrayList.get(i33), iM625q2, i26, iArr);
        }
        arrayList.clear();
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int iM611l;
        int iMax;
        int iCombineMeasuredStates;
        int iM611l2;
        int iCombineMeasuredStates2;
        int iMax2;
        int iM612m;
        boolean zM648a = AbstractC0189c4.m648a(this);
        int i11 = !zM648a ? 1 : 0;
        int i12 = 0;
        if (m629u(this.f830d)) {
            m628t(this.f830d, i6, 0, i10, this.f841o);
            iM611l = m611l(this.f830d) + this.f830d.getMeasuredWidth();
            iMax = Math.max(0, m612m(this.f830d) + this.f830d.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f830d.getMeasuredState());
        } else {
            iM611l = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (m629u(this.f834h)) {
            m628t(this.f834h, i6, 0, i10, this.f841o);
            iM611l = m611l(this.f834h) + this.f834h.getMeasuredWidth();
            iMax = Math.max(iMax, m612m(this.f834h) + this.f834h.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f834h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iM611l);
        int iMax4 = Math.max(0, currentContentInsetStart - iM611l);
        int[] iArr = this.f812F;
        iArr[zM648a ? 1 : 0] = iMax4;
        if (m629u(this.f827a)) {
            m628t(this.f827a, i6, iMax3, i10, this.f841o);
            iM611l2 = m611l(this.f827a) + this.f827a.getMeasuredWidth();
            iMax = Math.max(iMax, m612m(this.f827a) + this.f827a.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f827a.getMeasuredState());
        } else {
            iM611l2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iM611l2);
        iArr[i11] = Math.max(0, currentContentInsetEnd - iM611l2);
        if (m629u(this.f835i)) {
            iMax5 += m627s(this.f835i, i6, iMax5, i10, 0, iArr);
            iMax = Math.max(iMax, m612m(this.f835i) + this.f835i.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f835i.getMeasuredState());
        }
        if (m629u(this.f831e)) {
            iMax5 += m627s(this.f831e, i6, iMax5, i10, 0, iArr);
            iMax = Math.max(iMax, m612m(this.f831e) + this.f831e.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f831e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((LayoutParams) childAt.getLayoutParams()).f853b == 0 && m629u(childAt)) {
                iMax5 += m627s(childAt, i6, iMax5, i10, 0, iArr);
                iMax = Math.max(iMax, m612m(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i14 = this.f844r + this.f845s;
        int i15 = this.f842p + this.f843q;
        if (m629u(this.f828b)) {
            m627s(this.f828b, i6, iMax5 + i15, i10, i14, iArr);
            int iM611l3 = m611l(this.f828b) + this.f828b.getMeasuredWidth();
            iM612m = m612m(this.f828b) + this.f828b.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f828b.getMeasuredState());
            iMax2 = iM611l3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            iM612m = 0;
        }
        if (m629u(this.f829c)) {
            iMax2 = Math.max(iMax2, m627s(this.f829c, i6, iMax5 + i15, i10, iM612m + i14, iArr));
            iM612m += m612m(this.f829c) + this.f829c.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f829c.getMeasuredState());
        }
        int iMax6 = Math.max(iMax, iM612m);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax6;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + iMax5 + iMax2, getSuggestedMinimumWidth()), i6, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i10, iCombineMeasuredStates2 << 16);
        if (!this.f822P) {
            i12 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i16 = 0; i16 < childCount2; i16++) {
            View childAt2 = getChildAt(i16);
            if (m629u(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i12 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i12);
    }

    @Override
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1689a);
        ActionMenuView actionMenuView = this.f827a;
        MenuC2838l menuC2838l = actionMenuView != null ? actionMenuView.f576p : null;
        int i6 = savedState.f854c;
        if (i6 != 0 && this.f819M != null && menuC2838l != null && (menuItemFindItem = menuC2838l.findItem(i6)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.f855d) {
            RunnableC0005f runnableC0005f = this.f826T;
            removeCallbacks(runnableC0005f);
            post(runnableC0005f);
        }
    }

    @Override
    public final void onRtlPropertiesChanged(int i6) {
        super.onRtlPropertiesChanged(i6);
        m616d();
        C0243n2 c0243n2 = this.f846t;
        boolean z7 = i6 == 1;
        if (z7 == c0243n2.f1017g) {
            return;
        }
        c0243n2.f1017g = z7;
        if (!c0243n2.f1018h) {
            c0243n2.f1011a = c0243n2.f1015e;
            c0243n2.f1012b = c0243n2.f1016f;
            return;
        }
        if (z7) {
            int i10 = c0243n2.f1014d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = c0243n2.f1015e;
            }
            c0243n2.f1011a = i10;
            int i11 = c0243n2.f1013c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = c0243n2.f1016f;
            }
            c0243n2.f1012b = i11;
            return;
        }
        int i12 = c0243n2.f1013c;
        if (i12 == Integer.MIN_VALUE) {
            i12 = c0243n2.f1015e;
        }
        c0243n2.f1011a = i12;
        int i13 = c0243n2.f1014d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = c0243n2.f1016f;
        }
        c0243n2.f1012b = i13;
    }

    @Override
    public Parcelable onSaveInstanceState() {
        C2840n c2840n;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        C0259q3 c0259q3 = this.f819M;
        if (c0259q3 != null && (c2840n = c0259q3.f1041b) != null) {
            savedState.f854c = c2840n.f9717a;
        }
        savedState.f855d = m624p();
        return savedState;
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f808B = false;
        }
        if (!this.f808B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f808B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f808B = false;
        }
        return true;
    }

    public final boolean m624p() {
        C0225k c0225k;
        ActionMenuView actionMenuView = this.f827a;
        return (actionMenuView == null || (c0225k = actionMenuView.f580t) == null || !c0225k.m711h()) ? false : true;
    }

    public final int m625q(View view, int i6, int i10, int[] iArr) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int iMax = Math.max(0, i11) + i6;
        iArr[0] = Math.max(0, -i11);
        int iM621k = m621k(i10, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iM621k, iMax + measuredWidth, view.getMeasuredHeight() + iM621k);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + iMax;
    }

    public final int m626r(View view, int i6, int i10, int[] iArr) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int iMax = i6 - Math.max(0, i11);
        iArr[1] = Math.max(0, -i11);
        int iM621k = m621k(i10, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iM621k, iMax, view.getMeasuredHeight() + iM621k);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    public final int m627s(View view, int i6, int i10, int i11, int i12, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i13 = marginLayoutParams.leftMargin - iArr[0];
        int i14 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i14) + Math.max(0, i13);
        iArr[0] = Math.max(0, -i13);
        iArr[1] = Math.max(0, -i14);
        view.measure(ViewGroup.getChildMeasureSpec(i6, getPaddingRight() + getPaddingLeft() + iMax + i10, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i11, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i12, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public void setBackInvokedCallbackEnabled(boolean z7) {
        if (this.f825S != z7) {
            this.f825S = z7;
            m631w();
        }
    }

    public void setCollapseContentDescription(int i6) {
        setCollapseContentDescription(i6 != 0 ? getContext().getText(i6) : null);
    }

    public void setCollapseIcon(int i6) {
        setCollapseIcon(AbstractC1465c.m3473h(getContext(), i6));
    }

    public void setCollapsible(boolean z7) {
        this.f822P = z7;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i6) {
        if (i6 < 0) {
            i6 = Integer.MIN_VALUE;
        }
        if (i6 != this.f848v) {
            this.f848v = i6;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i6) {
        if (i6 < 0) {
            i6 = Integer.MIN_VALUE;
        }
        if (i6 != this.f847u) {
            this.f847u = i6;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i6) {
        setLogo(AbstractC1465c.m3473h(getContext(), i6));
    }

    public void setLogoDescription(int i6) {
        setLogoDescription(getContext().getText(i6));
    }

    public void setNavigationContentDescription(int i6) {
        setNavigationContentDescription(i6 != 0 ? getContext().getText(i6) : null);
    }

    public void setNavigationIcon(int i6) {
        setNavigationIcon(AbstractC1465c.m3473h(getContext(), i6));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m619g();
        this.f830d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(InterfaceC0264r3 interfaceC0264r3) {
        this.f815I = interfaceC0264r3;
    }

    public void setOverflowIcon(Drawable drawable) {
        m617e();
        this.f827a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i6) {
        if (this.f837k != i6) {
            this.f837k = i6;
            if (i6 == 0) {
                this.f836j = getContext();
            } else {
                this.f836j = new ContextThemeWrapper(getContext(), i6);
            }
        }
    }

    public void setSubtitle(int i6) {
        setSubtitle(getContext().getText(i6));
    }

    public void setSubtitleTextColor(int i6) {
        setSubtitleTextColor(ColorStateList.valueOf(i6));
    }

    public void setTitle(int i6) {
        setTitle(getContext().getText(i6));
    }

    public void setTitleMarginBottom(int i6) {
        this.f845s = i6;
        requestLayout();
    }

    public void setTitleMarginEnd(int i6) {
        this.f843q = i6;
        requestLayout();
    }

    public void setTitleMarginStart(int i6) {
        this.f842p = i6;
        requestLayout();
    }

    public void setTitleMarginTop(int i6) {
        this.f844r = i6;
        requestLayout();
    }

    public void setTitleTextColor(int i6) {
        setTitleTextColor(ColorStateList.valueOf(i6));
    }

    public final void m628t(View view, int i6, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i12 >= 0) {
            if (mode != 0) {
                i12 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i12);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean m629u(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final boolean m630v() {
        C0225k c0225k;
        ActionMenuView actionMenuView = this.f827a;
        return (actionMenuView == null || (c0225k = actionMenuView.f580t) == null || !c0225k.m716n()) ? false : true;
    }

    public final void m631w() {
        boolean z7;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        int i6 = 0;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherM753a = AbstractC0254p3.m753a(this);
            C0259q3 c0259q3 = this.f819M;
            if (c0259q3 == null || c0259q3.f1041b == null || onBackInvokedDispatcherM753a == null) {
                z7 = false;
            } else {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                if (isAttachedToWindow() && this.f825S) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
            if (z7 && this.f824R == null) {
                if (this.f823Q == null) {
                    this.f823Q = AbstractC0254p3.m754b(new RunnableC0244n3(this, i6));
                }
                AbstractC0254p3.m755c(onBackInvokedDispatcherM753a, this.f823Q);
                this.f824R = onBackInvokedDispatcherM753a;
                return;
            }
            if (z7 || (onBackInvokedDispatcher = this.f824R) == null) {
                return;
            }
            AbstractC0254p3.m756d(onBackInvokedDispatcher, this.f823Q);
            this.f824R = null;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f849w = 8388627;
        this.f810D = new ArrayList();
        this.f811E = new ArrayList();
        this.f812F = new int[2];
        this.f813G = new C2982h(new RunnableC0244n3(this, 1));
        this.f814H = new ArrayList();
        this.f816J = new C0249o3(this);
        this.f826T = new RunnableC0005f(3, this);
        Context context2 = getContext();
        int[] iArr = AbstractC2341a.f8178z;
        C0026b c0026bM111C = C0026b.m111C(context2, attributeSet, iArr, i6);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, (TypedArray) c0026bM111C.f55c, i6, 0);
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        this.f838l = typedArray.getResourceId(28, 0);
        this.f839m = typedArray.getResourceId(19, 0);
        this.f849w = typedArray.getInteger(0, 8388627);
        this.f840n = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.f845s = dimensionPixelOffset;
        this.f844r = dimensionPixelOffset;
        this.f843q = dimensionPixelOffset;
        this.f842p = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f842p = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f843q = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f844r = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f845s = dimensionPixelOffset5;
        }
        this.f841o = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        m616d();
        C0243n2 c0243n2 = this.f846t;
        c0243n2.f1018h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            c0243n2.f1015e = dimensionPixelSize;
            c0243n2.f1011a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            c0243n2.f1016f = dimensionPixelSize2;
            c0243n2.f1012b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            c0243n2.m739a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f847u = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.f848v = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f832f = c0026bM111C.m140t(4);
        this.f833g = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f836j = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable drawableM140t = c0026bM111C.m140t(16);
        if (drawableM140t != null) {
            setNavigationIcon(drawableM140t);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableM140t2 = c0026bM111C.m140t(11);
        if (drawableM140t2 != null) {
            setLogo(drawableM140t2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(c0026bM111C.m139s(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(c0026bM111C.m139s(20));
        }
        if (typedArray.hasValue(14)) {
            getMenuInflater().inflate(typedArray.getResourceId(14, 0), getMenu());
        }
        c0026bM111C.m120F();
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m615c();
        }
        AppCompatImageButton appCompatImageButton = this.f834h;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            m615c();
            this.f834h.setImageDrawable(drawable);
        } else {
            AppCompatImageButton appCompatImageButton = this.f834h;
            if (appCompatImageButton != null) {
                appCompatImageButton.setImageDrawable(this.f832f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f831e == null) {
                this.f831e = new AppCompatImageView(getContext(), null);
            }
            if (!m623o(this.f831e)) {
                m614b(this.f831e, true);
            }
        } else {
            AppCompatImageView appCompatImageView = this.f831e;
            if (appCompatImageView != null && m623o(appCompatImageView)) {
                removeView(this.f831e);
                this.f811E.remove(this.f831e);
            }
        }
        AppCompatImageView appCompatImageView2 = this.f831e;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f831e == null) {
            this.f831e = new AppCompatImageView(getContext(), null);
        }
        AppCompatImageView appCompatImageView = this.f831e;
        if (appCompatImageView != null) {
            appCompatImageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m619g();
        }
        AppCompatImageButton appCompatImageButton = this.f830d;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
            AbstractC3612b.m7256L(this.f830d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m619g();
            if (!m623o(this.f830d)) {
                m614b(this.f830d, true);
            }
        } else {
            AppCompatImageButton appCompatImageButton = this.f830d;
            if (appCompatImageButton != null && m623o(appCompatImageButton)) {
                removeView(this.f830d);
                this.f811E.remove(this.f830d);
            }
        }
        AppCompatImageButton appCompatImageButton2 = this.f830d;
        if (appCompatImageButton2 != null) {
            appCompatImageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f829c;
            if (appCompatTextView != null && m623o(appCompatTextView)) {
                removeView(this.f829c);
                this.f811E.remove(this.f829c);
            }
        } else {
            if (this.f829c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.f829c = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f829c.setEllipsize(TextUtils.TruncateAt.END);
                int i6 = this.f839m;
                if (i6 != 0) {
                    this.f829c.setTextAppearance(context, i6);
                }
                ColorStateList colorStateList = this.f807A;
                if (colorStateList != null) {
                    this.f829c.setTextColor(colorStateList);
                }
            }
            if (!m623o(this.f829c)) {
                m614b(this.f829c, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f829c;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.f851y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f807A = colorStateList;
        AppCompatTextView appCompatTextView = this.f829c;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f828b;
            if (appCompatTextView != null && m623o(appCompatTextView)) {
                removeView(this.f828b);
                this.f811E.remove(this.f828b);
            }
        } else {
            if (this.f828b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.f828b = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f828b.setEllipsize(TextUtils.TruncateAt.END);
                int i6 = this.f838l;
                if (i6 != 0) {
                    this.f828b.setTextAppearance(context, i6);
                }
                ColorStateList colorStateList = this.f852z;
                if (colorStateList != null) {
                    this.f828b.setTextColor(colorStateList);
                }
            }
            if (!m623o(this.f828b)) {
                m614b(this.f828b, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f828b;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.f850x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f852z = colorStateList;
        AppCompatTextView appCompatTextView = this.f828b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }
}

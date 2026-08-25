package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.app.C0157r0;
import androidx.appcompat.view.menu.ActionMenuItemView;
import p001a0.C0019b;
import p105k.C2840n;
import p105k.InterfaceC2823a0;
import p105k.InterfaceC2836j;
import p105k.InterfaceC2837k;
import p105k.InterfaceC2850x;
import p105k.MenuC2838l;

public class ActionMenuView extends LinearLayoutCompat implements InterfaceC2837k, InterfaceC2823a0 {

    public InterfaceC0240n f575A;

    public MenuC2838l f576p;

    public Context f577q;

    public int f578r;

    public boolean f579s;

    public C0225k f580t;

    public C0157r0 f581u;

    public InterfaceC2836j f582v;

    public boolean f583w;

    public int f584x;

    public final int f585y;

    public final int f586z;

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        public boolean f587a;

        public int f588b;

        public int f589c;

        public boolean f590d;

        public boolean f591e;

        public boolean f592f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f585y = (int) (56.0f * f);
        this.f586z = (int) (f * 4.0f);
        this.f577q = context;
        this.f578r = 0;
    }

    public static LayoutParams m558l() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.f587a = false;
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    public static LayoutParams m559m(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            return m558l();
        }
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams3 = (LayoutParams) layoutParams;
            layoutParams2 = new LayoutParams(layoutParams3);
            layoutParams2.f587a = layoutParams3.f587a;
        } else {
            layoutParams2 = new LayoutParams(layoutParams);
        }
        if (((LinearLayout.LayoutParams) layoutParams2).gravity <= 0) {
            ((LinearLayout.LayoutParams) layoutParams2).gravity = 16;
        }
        return layoutParams2;
    }

    @Override
    public final boolean mo535a(C2840n c2840n) {
        return this.f576p.m5832q(c2840n, null, 0);
    }

    @Override
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override
    public final void mo536d(MenuC2838l menuC2838l) {
        this.f576p = menuC2838l;
    }

    @Override
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m558l();
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m559m(layoutParams);
    }

    public Menu getMenu() {
        if (this.f576p == null) {
            Context context = getContext();
            MenuC2838l menuC2838l = new MenuC2838l(context);
            this.f576p = menuC2838l;
            menuC2838l.f9691e = new C0019b(5, this);
            C0225k c0225k = new C0225k(context);
            this.f580t = c0225k;
            c0225k.f964m = true;
            c0225k.f965n = true;
            InterfaceC2850x c0235m = this.f581u;
            if (c0235m == null) {
                c0235m = new C0235m();
            }
            c0225k.f9613e = c0235m;
            this.f576p.m5826b(c0225k, this.f577q);
            C0225k c0225k2 = this.f580t;
            c0225k2.f9616h = this;
            this.f576p = c0225k2.f9611c;
        }
        return this.f576p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        C0225k c0225k = this.f580t;
        C0215i c0215i = c0225k.f961j;
        if (c0215i != null) {
            return c0215i.getDrawable();
        }
        if (c0225k.f963l) {
            return c0225k.f962k;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f578r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override
    public final LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        return m558l();
    }

    @Override
    public final LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override
    public final LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m559m(layoutParams);
    }

    public final boolean m563n(int i6) {
        boolean zMo530a = false;
        if (i6 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i6 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i6);
        if (i6 < getChildCount() && (childAt instanceof InterfaceC0230l)) {
            zMo530a = ((InterfaceC0230l) childAt).mo530a();
        }
        return (i6 <= 0 || !(childAt2 instanceof InterfaceC0230l)) ? zMo530a : zMo530a | ((InterfaceC0230l) childAt2).mo531b();
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0225k c0225k = this.f580t;
        if (c0225k != null) {
            c0225k.mo712j(false);
            if (this.f580t.m711h()) {
                this.f580t.m708c();
                this.f580t.m716n();
            }
        }
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0225k c0225k = this.f580t;
        if (c0225k != null) {
            c0225k.m708c();
            C0195e c0195e = c0225k.f972u;
            if (c0195e == null || !c0195e.m5855b()) {
                return;
            }
            c0195e.f9763i.dismiss();
        }
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        int width;
        int paddingLeft;
        if (!this.f583w) {
            super.onLayout(z7, i6, i10, i11, i12);
            return;
        }
        int childCount = getChildCount();
        int i13 = (i12 - i10) / 2;
        int dividerWidth = getDividerWidth();
        int i14 = i11 - i6;
        int paddingRight = (i14 - getPaddingRight()) - getPaddingLeft();
        boolean zM648a = AbstractC0189c4.m648a(this);
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f587a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (m563n(i17)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zM648a) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i18 = i13 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i18, width, measuredHeight + i18);
                    paddingRight -= measuredWidth;
                    i15 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    m563n(i17);
                    i16++;
                }
            }
        }
        if (childCount == 1 && i15 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i19 = (i14 / 2) - (measuredWidth2 / 2);
            int i20 = i13 - (measuredHeight2 / 2);
            childAt2.layout(i19, i20, measuredWidth2 + i19, measuredHeight2 + i20);
            return;
        }
        int i21 = i16 - (i15 ^ 1);
        int iMax = Math.max(0, i21 > 0 ? paddingRight / i21 : 0);
        if (zM648a) {
            int width2 = getWidth() - getPaddingRight();
            for (int i22 = 0; i22 < childCount; i22++) {
                View childAt3 = getChildAt(i22);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f587a) {
                    int i23 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i24 = i13 - (measuredHeight3 / 2);
                    childAt3.layout(i23 - measuredWidth3, i24, i23, measuredHeight3 + i24);
                    width2 = i23 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i25 = 0; i25 < childCount; i25++) {
            View childAt4 = getChildAt(i25);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f587a) {
                int i26 = paddingLeft2 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i27 = i13 - (measuredHeight4 / 2);
                childAt4.layout(i26, i27, i26 + measuredWidth4, measuredHeight4 + i27);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + iMax + i26;
            }
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int i11;
        boolean z7;
        int i12;
        boolean z10;
        int i13;
        ?? r10;
        int i14;
        MenuC2838l menuC2838l;
        boolean z11 = this.f583w;
        boolean z12 = View.MeasureSpec.getMode(i6) == 1073741824;
        this.f583w = z12;
        if (z11 != z12) {
            this.f584x = 0;
        }
        int size = View.MeasureSpec.getSize(i6);
        if (this.f583w && (menuC2838l = this.f576p) != null && size != this.f584x) {
            this.f584x = size;
            menuC2838l.mo4279p(true);
        }
        int childCount = getChildCount();
        if (!this.f583w || childCount <= 0) {
            for (int i15 = 0; i15 < childCount; i15++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i15).getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
            }
            super.onMeasure(i6, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i6);
        int size3 = View.MeasureSpec.getSize(i10);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingBottom, -2);
        int i16 = size2 - paddingRight;
        int i17 = this.f585y;
        int i18 = i16 / i17;
        int i19 = i16 % i17;
        if (i18 == 0) {
            setMeasuredDimension(i16, 0);
            return;
        }
        int i20 = (i19 / i18) + i17;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i21 = 0;
        int iMax2 = 0;
        int i22 = 0;
        boolean z13 = false;
        long j10 = 0;
        int i23 = 0;
        while (true) {
            i11 = this.f586z;
            if (i22 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i22);
            int i24 = size3;
            int i25 = i16;
            if (childAt.getVisibility() != 8) {
                boolean z14 = childAt instanceof ActionMenuItemView;
                int i26 = i21 + 1;
                if (z14) {
                    childAt.setPadding(i11, 0, i11, 0);
                }
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                layoutParams2.f592f = false;
                layoutParams2.f589c = 0;
                layoutParams2.f588b = 0;
                layoutParams2.f590d = false;
                ((LinearLayout.LayoutParams) layoutParams2).leftMargin = 0;
                ((LinearLayout.LayoutParams) layoutParams2).rightMargin = 0;
                layoutParams2.f591e = z14 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i27 = layoutParams2.f587a ? 1 : i18;
                LayoutParams layoutParams3 = (LayoutParams) childAt.getLayoutParams();
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z14 ? (ActionMenuItemView) childAt : null;
                boolean z15 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                if (i27 <= 0 || (z15 && i27 < 2)) {
                    i14 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i27 * i20, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i14 = measuredWidth / i20;
                    if (measuredWidth % i20 != 0) {
                        i14++;
                    }
                    if (z15 && i14 < 2) {
                        i14 = 2;
                    }
                }
                layoutParams3.f590d = !layoutParams3.f587a && z15;
                layoutParams3.f588b = i14;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i14 * i20, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i14);
                if (layoutParams2.f590d) {
                    i23++;
                }
                if (layoutParams2.f587a) {
                    z13 = true;
                }
                i18 -= i14;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i14 == 1) {
                    j10 |= (long) (1 << i22);
                }
                i21 = i26;
            }
            i22++;
            size3 = i24;
            i16 = i25;
            paddingBottom = paddingBottom;
            mode = mode;
        }
        int i28 = mode;
        int i29 = i16;
        int i30 = size3;
        boolean z16 = z13 && i21 == 2;
        boolean z17 = false;
        while (true) {
            if (i23 <= 0 || i18 <= 0) {
                z7 = z17;
                break;
            }
            int i31 = Integer.MAX_VALUE;
            int i32 = 0;
            int i33 = 0;
            long j11 = 0;
            while (i33 < childCount2) {
                LayoutParams layoutParams4 = (LayoutParams) getChildAt(i33).getLayoutParams();
                boolean z18 = z17;
                if (layoutParams4.f590d) {
                    int i34 = layoutParams4.f588b;
                    if (i34 < i31) {
                        j11 = 1 << i33;
                        i31 = i34;
                        i32 = 1;
                    } else if (i34 == i31) {
                        j11 |= 1 << i33;
                        i32++;
                    }
                }
                i33++;
                z17 = z18;
            }
            z7 = z17;
            j10 |= j11;
            if (i32 > i18) {
                break;
            }
            int i35 = i31 + 1;
            int i36 = 0;
            while (i36 < childCount2) {
                View childAt2 = getChildAt(i36);
                LayoutParams layoutParams5 = (LayoutParams) childAt2.getLayoutParams();
                int i37 = iMax;
                int i38 = childMeasureSpec;
                int i39 = childCount2;
                long j12 = 1 << i36;
                if ((j11 & j12) != 0) {
                    if (z16 && layoutParams5.f591e) {
                        r10 = 1;
                        r10 = 1;
                        if (i18 == 1) {
                            childAt2.setPadding(i11 + i20, 0, i11, 0);
                        }
                    } else {
                        r10 = 1;
                    }
                    layoutParams5.f588b += r10;
                    layoutParams5.f592f = r10;
                    i18--;
                } else if (layoutParams5.f588b == i35) {
                    j10 |= j12;
                }
                i36++;
                childMeasureSpec = i38;
                iMax = i37;
                childCount2 = i39;
            }
            z17 = true;
        }
        int i40 = iMax;
        int i41 = childMeasureSpec;
        int i42 = childCount2;
        boolean z19 = !z13 && i21 == 1;
        if (i18 <= 0 || j10 == 0 || (i18 >= i21 - 1 && !z19 && iMax2 <= 1)) {
            i12 = i42;
            z10 = z7;
        } else {
            float fBitCount = Long.bitCount(j10);
            if (!z19) {
                if ((j10 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f591e) {
                    fBitCount -= 0.5f;
                }
                int i43 = i42 - 1;
                if ((j10 & ((long) (1 << i43))) != 0 && !((LayoutParams) getChildAt(i43).getLayoutParams()).f591e) {
                    fBitCount -= 0.5f;
                }
            }
            int i44 = fBitCount > 0.0f ? (int) ((i18 * i20) / fBitCount) : 0;
            boolean z20 = z7;
            i12 = i42;
            for (int i45 = 0; i45 < i12; i45++) {
                if ((j10 & ((long) (1 << i45))) != 0) {
                    View childAt3 = getChildAt(i45);
                    LayoutParams layoutParams6 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams6.f589c = i44;
                        layoutParams6.f592f = true;
                        if (i45 == 0 && !layoutParams6.f591e) {
                            ((LinearLayout.LayoutParams) layoutParams6).leftMargin = (-i44) / 2;
                        }
                        z20 = true;
                    } else if (layoutParams6.f587a) {
                        layoutParams6.f589c = i44;
                        layoutParams6.f592f = true;
                        ((LinearLayout.LayoutParams) layoutParams6).rightMargin = (-i44) / 2;
                        z20 = true;
                    } else {
                        if (i45 != 0) {
                            ((LinearLayout.LayoutParams) layoutParams6).leftMargin = i44 / 2;
                        }
                        if (i45 != i12 - 1) {
                            ((LinearLayout.LayoutParams) layoutParams6).rightMargin = i44 / 2;
                        }
                    }
                }
            }
            z10 = z20;
        }
        if (z10) {
            int i46 = 0;
            while (i46 < i12) {
                View childAt4 = getChildAt(i46);
                LayoutParams layoutParams7 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams7.f592f) {
                    i13 = i41;
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams7.f588b * i20) + layoutParams7.f589c, 1073741824), i13);
                } else {
                    i13 = i41;
                }
                i46++;
                i41 = i13;
            }
        }
        setMeasuredDimension(i29, i28 != 1073741824 ? i40 : i30);
    }

    public void setExpandedActionViewsExclusive(boolean z7) {
        this.f580t.f969r = z7;
    }

    public void setOnMenuItemClickListener(InterfaceC0240n interfaceC0240n) {
        this.f575A = interfaceC0240n;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        C0225k c0225k = this.f580t;
        C0215i c0215i = c0225k.f961j;
        if (c0215i != null) {
            c0215i.setImageDrawable(drawable);
        } else {
            c0225k.f963l = true;
            c0225k.f962k = drawable;
        }
    }

    public void setOverflowReserved(boolean z7) {
        this.f579s = z7;
    }

    public void setPopupTheme(int i6) {
        if (this.f578r != i6) {
            this.f578r = i6;
            if (i6 == 0) {
                this.f577q = getContext();
            } else {
                this.f577q = new ContextThemeWrapper(getContext(), i6);
            }
        }
    }

    public void setPresenter(C0225k c0225k) {
        this.f580t = c0225k;
        c0225k.f9616h = this;
        this.f576p = c0225k.f9611c;
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}

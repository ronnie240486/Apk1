package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.app.C0169x0;
import com.bumptech.glide.AbstractC1465c;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p006a6.C0062a;
import p056f0.C2480c;
import p093j.C2749j;
import p105k.InterfaceC2850x;
import p105k.MenuC2838l;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3126i1;
import p138n0.AbstractC3155s0;
import p138n0.C3114e1;
import p138n0.C3120g1;
import p138n0.C3123h1;
import p138n0.C3144o1;
import p138n0.C3151r;
import p138n0.C3153r1;
import p138n0.InterfaceC3145p;
import p138n0.InterfaceC3148q;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0217i1, InterfaceC3145p, InterfaceC3148q {

    public static final int[] f546B = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    public final C3151r f547A;

    public int f548a;

    public int f549b;

    public ContentFrameLayout f550c;

    public ActionBarContainer f551d;

    public InterfaceC0222j1 f552e;

    public Drawable f553f;

    public boolean f554g;

    public boolean f555h;

    public boolean f556i;

    public boolean f557j;

    public boolean f558k;

    public int f559l;

    public int f560m;

    public final Rect f561n;

    public final Rect f562o;

    public final Rect f563p;

    public C3153r1 f564q;

    public C3153r1 f565r;

    public C3153r1 f566s;

    public C3153r1 f567t;

    public InterfaceC0190d f568u;

    public OverScroller f569v;

    public ViewPropertyAnimator f570w;

    public final C0062a f571x;

    public final RunnableC0184c f572y;

    public final RunnableC0184c f573z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f549b = 0;
        this.f561n = new Rect();
        this.f562o = new Rect();
        this.f563p = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        C3153r1 c3153r1 = C3153r1.f10640b;
        this.f564q = c3153r1;
        this.f565r = c3153r1;
        this.f566s = c3153r1;
        this.f567t = c3153r1;
        this.f571x = new C0062a(2, this);
        this.f572y = new RunnableC0184c(this, 0);
        this.f573z = new RunnableC0184c(this, 1);
        m550e(context);
        this.f547A = new C3151r();
    }

    public static boolean m546c(View view, Rect rect, boolean z7) {
        boolean z10;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        int i10 = rect.left;
        if (i6 != i10) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i10;
            z10 = true;
        } else {
            z10 = false;
        }
        int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        int i12 = rect.top;
        if (i11 != i12) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i12;
            z10 = true;
        }
        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int i14 = rect.right;
        if (i13 != i14) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i14;
            z10 = true;
        }
        if (z7) {
            int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int i16 = rect.bottom;
            if (i15 != i16) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i16;
                return true;
            }
        }
        return z10;
    }

    @Override
    public final void mo547a(View view, View view2, int i6, int i10) {
        if (i10 == 0) {
            onNestedScrollAccepted(view, view2, i6);
        }
    }

    @Override
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void m549d() {
        removeCallbacks(this.f572y);
        removeCallbacks(this.f573z);
        ViewPropertyAnimator viewPropertyAnimator = this.f570w;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f553f == null || this.f554g) {
            return;
        }
        if (this.f551d.getVisibility() == 0) {
            translationY = (int) (this.f551d.getTranslationY() + this.f551d.getBottom() + 0.5f);
        } else {
            translationY = 0;
        }
        this.f553f.setBounds(0, translationY, getWidth(), this.f553f.getIntrinsicHeight() + translationY);
        this.f553f.draw(canvas);
    }

    public final void m550e(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f546B);
        this.f548a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f553f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f554g = context.getApplicationInfo().targetSdkVersion < 19;
        this.f569v = new OverScroller(context);
    }

    @Override
    public final void mo551f(int i6, View view) {
        if (i6 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override
    public final void mo552g(View view, int i6, int i10, int i11, int i12, int i13, int[] iArr) {
        mo554i(view, i6, i10, i11, i12, i13);
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f551d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override
    public int getNestedScrollAxes() {
        C3151r c3151r = this.f547A;
        return c3151r.f10635b | c3151r.f10634a;
    }

    public CharSequence getTitle() {
        m556k();
        return ((C0284v3) this.f552e).f1098a.getTitle();
    }

    public final void m553h(int i6) {
        m556k();
        if (i6 == 2) {
            ((C0284v3) this.f552e).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i6 == 5) {
            ((C0284v3) this.f552e).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i6 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override
    public final void mo554i(View view, int i6, int i10, int i11, int i12, int i13) {
        if (i13 == 0) {
            onNestedScroll(view, i6, i10, i11, i12);
        }
    }

    @Override
    public final boolean mo555j(View view, View view2, int i6, int i10) {
        return i10 == 0 && onStartNestedScroll(view, view2, i6);
    }

    public final void m556k() {
        InterfaceC0222j1 wrapper;
        if (this.f550c == null) {
            this.f550c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f551d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof InterfaceC0222j1) {
                wrapper = (InterfaceC0222j1) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f552e = wrapper;
        }
    }

    public final void m557l(MenuC2838l menuC2838l, InterfaceC2850x interfaceC2850x) {
        m556k();
        C0284v3 c0284v3 = (C0284v3) this.f552e;
        C0225k c0225k = c0284v3.f1110m;
        Toolbar toolbar = c0284v3.f1098a;
        if (c0225k == null) {
            C0225k c0225k2 = new C0225k(toolbar.getContext());
            c0284v3.f1110m = c0225k2;
            c0225k2.f9617i = R.id.action_menu_presenter;
        }
        C0225k c0225k3 = c0284v3.f1110m;
        c0225k3.f9613e = interfaceC2850x;
        if (menuC2838l == null && toolbar.f827a == null) {
            return;
        }
        toolbar.m618f();
        MenuC2838l menuC2838l2 = toolbar.f827a.f576p;
        if (menuC2838l2 == menuC2838l) {
            return;
        }
        if (menuC2838l2 != null) {
            menuC2838l2.m5833r(toolbar.f818L);
            menuC2838l2.m5833r(toolbar.f819M);
        }
        if (toolbar.f819M == null) {
            toolbar.f819M = new C0259q3(toolbar);
        }
        c0225k3.f969r = true;
        if (menuC2838l != null) {
            menuC2838l.m5826b(c0225k3, toolbar.f836j);
            menuC2838l.m5826b(toolbar.f819M, toolbar.f836j);
        } else {
            c0225k3.mo713k(toolbar.f836j, null);
            toolbar.f819M.mo713k(toolbar.f836j, null);
            c0225k3.mo712j(true);
            toolbar.f819M.mo712j(true);
        }
        toolbar.f827a.setPopupTheme(toolbar.f837k);
        toolbar.f827a.setPresenter(c0225k3);
        toolbar.f818L = c0225k3;
        toolbar.m631w();
    }

    @Override
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        m556k();
        C3153r1 c3153r1M6324h = C3153r1.m6324h(windowInsets, this);
        boolean zM546c = m546c(this.f551d, new Rect(c3153r1M6324h.m6326b(), c3153r1M6324h.m6328d(), c3153r1M6324h.m6327c(), c3153r1M6324h.m6325a()), false);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        Rect rect = this.f561n;
        AbstractC3119g0.m6163b(this, c3153r1M6324h, rect);
        int i6 = rect.left;
        int i10 = rect.top;
        int i11 = rect.right;
        int i12 = rect.bottom;
        C3144o1 c3144o1 = c3153r1M6324h.f10641a;
        C3153r1 c3153r1Mo6230m = c3144o1.mo6230m(i6, i10, i11, i12);
        this.f564q = c3153r1Mo6230m;
        boolean z7 = true;
        if (!this.f565r.equals(c3153r1Mo6230m)) {
            this.f565r = this.f564q;
            zM546c = true;
        }
        Rect rect2 = this.f562o;
        if (rect2.equals(rect)) {
            z7 = zM546c;
        } else {
            rect2.set(rect);
        }
        if (z7) {
            requestLayout();
        }
        return c3144o1.mo6251a().f10641a.mo6237c().f10641a.mo6236b().m6330g();
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m550e(getContext());
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3113e0.m6130c(this);
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m549d();
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i14, i15, measuredWidth + i14, measuredHeight + i15);
            }
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int measuredHeight;
        AbstractC3126i1 c3120g1;
        m556k();
        measureChildWithMargins(this.f551d, i6, 0, i10, 0);
        LayoutParams layoutParams = (LayoutParams) this.f551d.getLayoutParams();
        int iMax = Math.max(0, this.f551d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int iMax2 = Math.max(0, this.f551d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f551d.getMeasuredState());
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean z7 = (getWindowSystemUiVisibility() & 256) != 0;
        if (z7) {
            measuredHeight = this.f548a;
            if (this.f556i && this.f551d.getTabContainer() != null) {
                measuredHeight += this.f548a;
            }
        } else {
            measuredHeight = this.f551d.getVisibility() != 8 ? this.f551d.getMeasuredHeight() : 0;
        }
        Rect rect = this.f561n;
        Rect rect2 = this.f563p;
        rect2.set(rect);
        C3153r1 c3153r1 = this.f564q;
        this.f566s = c3153r1;
        if (this.f555h || z7) {
            C2480c c2480cM5515a = C2480c.m5515a(c3153r1.m6326b(), this.f566s.m6328d() + measuredHeight, this.f566s.m6327c(), this.f566s.m6325a());
            C3153r1 c3153r2 = this.f566s;
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                c3120g1 = new C3123h1(c3153r2);
            } else {
                c3120g1 = i11 >= 29 ? new C3120g1(c3153r2) : new C3114e1(c3153r2);
            }
            c3120g1.mo6134d(c2480cM5515a);
            this.f566s = c3120g1.mo6132b();
        } else {
            rect2.top += measuredHeight;
            rect2.bottom = rect2.bottom;
            this.f566s = c3153r1.f10641a.mo6230m(0, measuredHeight, 0, 0);
        }
        m546c(this.f550c, rect2, true);
        if (!this.f567t.equals(this.f566s)) {
            C3153r1 c3153r3 = this.f566s;
            this.f567t = c3153r3;
            AbstractC3155s0.m6332b(this.f550c, c3153r3);
        }
        measureChildWithMargins(this.f550c, i6, 0, i10, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f550c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f550c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f550c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f550c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i6, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i10, iCombineMeasuredStates2 << 16));
    }

    @Override
    public final boolean onNestedFling(View view, float f, float f3, boolean z7) {
        if (!this.f557j || !z7) {
            return false;
        }
        this.f569v.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f569v.getFinalY() > this.f551d.getHeight()) {
            m549d();
            this.f573z.run();
        } else {
            m549d();
            this.f572y.run();
        }
        this.f558k = true;
        return true;
    }

    @Override
    public final boolean onNestedPreFling(View view, float f, float f3) {
        return false;
    }

    @Override
    public final void onNestedScroll(View view, int i6, int i10, int i11, int i12) {
        int i13 = this.f559l + i10;
        this.f559l = i13;
        setActionBarHideOffset(i13);
    }

    @Override
    public final void onNestedScrollAccepted(View view, View view2, int i6) {
        C0169x0 c0169x0;
        C2749j c2749j;
        this.f547A.f10634a = i6;
        this.f559l = getActionBarHideOffset();
        m549d();
        InterfaceC0190d interfaceC0190d = this.f568u;
        if (interfaceC0190d == null || (c2749j = (c0169x0 = (C0169x0) interfaceC0190d).f466J) == null) {
            return;
        }
        c2749j.m5714a();
        c0169x0.f466J = null;
    }

    @Override
    public final boolean onStartNestedScroll(View view, View view2, int i6) {
        if ((i6 & 2) == 0 || this.f551d.getVisibility() != 0) {
            return false;
        }
        return this.f557j;
    }

    @Override
    public final void onStopNestedScroll(View view) {
        if (!this.f557j || this.f558k) {
            return;
        }
        if (this.f559l <= this.f551d.getHeight()) {
            m549d();
            postDelayed(this.f572y, 600L);
        } else {
            m549d();
            postDelayed(this.f573z, 600L);
        }
    }

    @Override
    public final void onWindowSystemUiVisibilityChanged(int i6) {
        super.onWindowSystemUiVisibilityChanged(i6);
        m556k();
        int i10 = this.f560m ^ i6;
        this.f560m = i6;
        boolean z7 = (i6 & 4) == 0;
        boolean z10 = (i6 & 256) != 0;
        InterfaceC0190d interfaceC0190d = this.f568u;
        if (interfaceC0190d != null) {
            C0169x0 c0169x0 = (C0169x0) interfaceC0190d;
            c0169x0.f462F = !z10;
            if (z7 || !z10) {
                if (c0169x0.f463G) {
                    c0169x0.f463G = false;
                    c0169x0.m521Y(true);
                }
            } else if (!c0169x0.f463G) {
                c0169x0.f463G = true;
                c0169x0.m521Y(true);
            }
        }
        if ((i10 & 256) == 0 || this.f568u == null) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3113e0.m6130c(this);
    }

    @Override
    public final void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        this.f549b = i6;
        InterfaceC0190d interfaceC0190d = this.f568u;
        if (interfaceC0190d != null) {
            ((C0169x0) interfaceC0190d).f461E = i6;
        }
    }

    public void setActionBarHideOffset(int i6) {
        m549d();
        this.f551d.setTranslationY(-Math.max(0, Math.min(i6, this.f551d.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC0190d interfaceC0190d) {
        this.f568u = interfaceC0190d;
        if (getWindowToken() != null) {
            ((C0169x0) this.f568u).f461E = this.f549b;
            int i6 = this.f560m;
            if (i6 != 0) {
                onWindowSystemUiVisibilityChanged(i6);
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                AbstractC3113e0.m6130c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z7) {
        this.f556i = z7;
    }

    public void setHideOnContentScrollEnabled(boolean z7) {
        if (z7 != this.f557j) {
            this.f557j = z7;
            if (z7) {
                return;
            }
            m549d();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i6) {
        m556k();
        C0284v3 c0284v3 = (C0284v3) this.f552e;
        c0284v3.f1101d = i6 != 0 ? AbstractC1465c.m3473h(c0284v3.f1098a.getContext(), i6) : null;
        c0284v3.m800d();
    }

    public void setLogo(int i6) {
        m556k();
        C0284v3 c0284v3 = (C0284v3) this.f552e;
        c0284v3.f1102e = i6 != 0 ? AbstractC1465c.m3473h(c0284v3.f1098a.getContext(), i6) : null;
        c0284v3.m800d();
    }

    public void setOverlayMode(boolean z7) {
        this.f555h = z7;
        this.f554g = z7 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    @Override
    public void setWindowCallback(Window.Callback callback) {
        m556k();
        ((C0284v3) this.f552e).f1108k = callback;
    }

    @Override
    public void setWindowTitle(CharSequence charSequence) {
        m556k();
        C0284v3 c0284v3 = (C0284v3) this.f552e;
        if (c0284v3.f1104g) {
            return;
        }
        c0284v3.f1105h = charSequence;
        if ((c0284v3.f1099b & 8) != 0) {
            Toolbar toolbar = c0284v3.f1098a;
            toolbar.setTitle(charSequence);
            if (c0284v3.f1104g) {
                AbstractC3155s0.m6348r(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        m556k();
        C0284v3 c0284v3 = (C0284v3) this.f552e;
        c0284v3.f1101d = drawable;
        c0284v3.m800d();
    }

    public void setShowingForActionMode(boolean z7) {
    }

    public void setUiOptions(int i6) {
    }

    @Override
    public final void onNestedPreScroll(View view, int i6, int i10, int[] iArr) {
    }

    @Override
    public final void mo548b(View view, int i6, int i10, int[] iArr, int i11) {
    }
}

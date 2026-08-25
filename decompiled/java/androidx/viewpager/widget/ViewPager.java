package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.appcompat.widget.C0175a2;
import androidx.customview.view.AbsSavedState;
import androidx.fragment.app.AbstractC0410j0;
import androidx.fragment.app.AbstractC0418n0;
import androidx.fragment.app.AbstractComponentCallbacksC0427s;
import androidx.fragment.app.C0391a;
import androidx.fragment.app.C0426r0;
import com.youth.banner.config.BannerConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import p000a.RunnableC0005f;
import p001a0.C0022e;
import p007a7.C0069f;
import p015b2.AbstractC1249a;
import p015b2.C1255g;
import p015b2.C1256h;
import p015b2.InterfaceC1254f;
import p015b2.InterfaceC1257i;
import p015b2.InterfaceC1258j;
import p015b2.InterpolatorC1253e;
import p034d0.AbstractC2115a;
import p055ea.AbstractC2460q;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;

public class ViewPager extends ViewGroup {

    public static final int[] f3851W = {R.attr.layout_gravity};

    public static final C0022e f3852b0 = new C0022e(1);

    public static final InterpolatorC1253e f3853c0 = new InterpolatorC1253e(0);

    public final int f3854A;

    public float f3855B;

    public float f3856C;

    public float f3857D;

    public float f3858E;

    public int f3859F;

    public VelocityTracker f3860G;

    public final int f3861H;

    public final int f3862I;

    public final int f3863J;

    public final int f3864K;

    public final EdgeEffect f3865L;

    public final EdgeEffect f3866M;

    public boolean f3867N;

    public boolean f3868O;

    public int f3869P;

    public ArrayList f3870Q;

    public InterfaceC1258j f3871R;

    public InterfaceC1258j f3872S;

    public ArrayList f3873T;

    public final RunnableC0005f f3874U;

    public int f3875V;

    public int f3876a;

    public final ArrayList f3877b;

    public final C1255g f3878c;

    public final Rect f3879d;

    public AbstractC1249a f3880e;

    public int f3881f;

    public int f3882g;

    public Parcelable f3883h;

    public final Scroller f3884i;

    public boolean f3885j;

    public C0175a2 f3886k;

    public int f3887l;

    public Drawable f3888m;

    public int f3889n;

    public int f3890o;

    public float f3891p;

    public float f3892q;

    public int f3893r;

    public boolean f3894s;

    public boolean f3895t;

    public boolean f3896u;

    public int f3897v;

    public boolean f3898w;

    public boolean f3899x;

    public final int f3900y;

    public int f3901z;

    public static class LayoutParams extends ViewGroup.LayoutParams {

        public boolean f3902a;

        public final int f3903b;

        public float f3904c;

        public boolean f3905d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3904c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f3851W);
            this.f3903b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1205a();

        public int f3906c;

        public Parcelable f3907d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f3906c = parcel.readInt();
            this.f3907d = parcel.readParcelable(classLoader);
        }

        public final String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f3906c + "}";
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f3906c);
            parcel.writeParcelable(this.f3907d, i6);
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3877b = new ArrayList();
        this.f3878c = new C1255g();
        this.f3879d = new Rect();
        this.f3882g = -1;
        this.f3891p = -3.4028235E38f;
        this.f3892q = Float.MAX_VALUE;
        this.f3897v = 1;
        this.f3859F = -1;
        this.f3867N = true;
        this.f3874U = new RunnableC0005f(6, this);
        this.f3875V = 0;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.f3884i = new Scroller(context2, f3853c0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.f3854A = viewConfiguration.getScaledPagingTouchSlop();
        this.f3861H = (int) (400.0f * f);
        this.f3862I = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3865L = new EdgeEffect(context2);
        this.f3866M = new EdgeEffect(context2);
        this.f3863J = (int) (25.0f * f);
        this.f3864K = (int) (2.0f * f);
        this.f3900y = (int) (f * 16.0f);
        AbstractC3155s0.m6347q(this, new C1256h(0, this));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        AbstractC3119g0.m6182u(this, new C0069f(this));
    }

    public static boolean m3081c(int i6, int i10, int i11, View view, boolean z7) {
        int i12;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i13 = i10 + scrollX;
                if (i13 >= childAt.getLeft() && i13 < childAt.getRight() && (i12 = i11 + scrollY) >= childAt.getTop() && i12 < childAt.getBottom() && m3081c(i6, i13 - childAt.getLeft(), i12 - childAt.getTop(), childAt, true)) {
                    return true;
                }
            }
        }
        return z7 && view.canScrollHorizontally(-i6);
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z7) {
        if (this.f3895t != z7) {
            this.f3895t = z7;
        }
    }

    public final C1255g m3082a(int i6, int i10) {
        C1255g c1255g = new C1255g();
        c1255g.f3979b = i6;
        AbstractC0418n0 abstractC0418n0 = (AbstractC0418n0) this.f3880e;
        C0391a c0391a = abstractC0418n0.f1915d;
        AbstractC0410j0 abstractC0410j0 = abstractC0418n0.f1914c;
        if (c0391a == null) {
            abstractC0410j0.getClass();
            abstractC0418n0.f1915d = new C0391a(abstractC0410j0);
        }
        long j10 = i6;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM1264z = abstractC0410j0.m1264z("android:switcher:" + getId() + ":" + j10);
        if (abstractComponentCallbacksC0427sM1264z != null) {
            C0391a c0391a2 = abstractC0418n0.f1915d;
            c0391a2.getClass();
            c0391a2.m1187b(new C0426r0(7, abstractComponentCallbacksC0427sM1264z));
        } else {
            abstractComponentCallbacksC0427sM1264z = abstractC0418n0.mo1287h(i6);
            abstractC0418n0.f1915d.m1191f(getId(), abstractComponentCallbacksC0427sM1264z, "android:switcher:" + getId() + ":" + j10, 1);
        }
        if (abstractComponentCallbacksC0427sM1264z != abstractC0418n0.f1916e) {
            if (abstractComponentCallbacksC0427sM1264z.f1948C) {
                abstractComponentCallbacksC0427sM1264z.f1948C = false;
            }
            abstractComponentCallbacksC0427sM1264z.m1317P(false);
        }
        c1255g.f3978a = abstractComponentCallbacksC0427sM1264z;
        this.f3880e.getClass();
        c1255g.f3981d = 1.0f;
        ArrayList arrayList = this.f3877b;
        if (i10 < 0 || i10 >= arrayList.size()) {
            arrayList.add(c1255g);
        } else {
            arrayList.add(i10, c1255g);
        }
        return c1255g;
    }

    @Override
    public final void addFocusables(ArrayList arrayList, int i6, int i10) {
        C1255g c1255gM3088h;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() == 0 && (c1255gM3088h = m3088h(childAt)) != null && c1255gM3088h.f3979b == this.f3881f) {
                    childAt.addFocusables(arrayList, i6, i10);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i10 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override
    public final void addTouchables(ArrayList arrayList) {
        C1255g c1255gM3088h;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0 && (c1255gM3088h = m3088h(childAt)) != null && c1255gM3088h.f3979b == this.f3881f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override
    public final void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z7 = layoutParams2.f3902a | (view.getClass().getAnnotation(InterfaceC1254f.class) != null);
        layoutParams2.f3902a = z7;
        if (!this.f3894s) {
            super.addView(view, i6, layoutParams);
        } else {
            if (z7) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f3905d = true;
            addViewInLayout(view, i6, layoutParams);
        }
    }

    public final boolean m3083b(int i6) {
        boolean zRequestFocus;
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
            break;
        }
        if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(viewFindFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    viewFindFocus = null;
                    break;
                }
                if (parent == this) {
                    break;
                }
                parent = parent.getParent();
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i6);
        boolean zM3093m = false;
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            Rect rect = this.f3879d;
            if (i6 == 17) {
                int i10 = m3087g(viewFindNextFocus, rect).left;
                int i11 = m3087g(viewFindFocus, rect).left;
                if (viewFindFocus == null || i10 < i11) {
                    zRequestFocus = viewFindNextFocus.requestFocus();
                    zM3093m = zRequestFocus;
                } else {
                    int i12 = this.f3881f;
                    if (i12 > 0) {
                        m3101u(i12 - 1, true);
                        zM3093m = true;
                    }
                }
            } else if (i6 == 66) {
                zRequestFocus = (viewFindFocus == null || m3087g(viewFindNextFocus, rect).left > m3087g(viewFindFocus, rect).left) ? viewFindNextFocus.requestFocus() : m3093m();
                zM3093m = zRequestFocus;
            }
        } else if (i6 == 17 || i6 == 1) {
            int i13 = this.f3881f;
            if (i13 > 0) {
                m3101u(i13 - 1, true);
                zM3093m = true;
            }
        } else if (i6 == 66 || i6 == 2) {
            zM3093m = m3093m();
        }
        if (zM3093m) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i6));
        }
        return zM3093m;
    }

    @Override
    public final boolean canScrollHorizontally(int i6) {
        if (this.f3880e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i6 < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.f3891p));
        }
        return i6 > 0 && scrollX < ((int) (((float) clientWidth) * this.f3892q));
    }

    @Override
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override
    public final void computeScroll() {
        this.f3885j = true;
        Scroller scroller = this.f3884i;
        if (scroller.isFinished() || !scroller.computeScrollOffset()) {
            m3084d(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = scroller.getCurrX();
        int currY = scroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!m3094n(currX)) {
                scroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        postInvalidateOnAnimation();
    }

    public final void m3084d(boolean z7) {
        Scroller scroller = this.f3884i;
        boolean z10 = this.f3875V == 2;
        if (z10) {
            setScrollingCacheEnabled(false);
            if (!scroller.isFinished()) {
                scroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = scroller.getCurrX();
                int currY = scroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m3094n(currX);
                    }
                }
            }
        }
        this.f3896u = false;
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f3877b;
            if (i6 >= arrayList.size()) {
                break;
            }
            C1255g c1255g = (C1255g) arrayList.get(i6);
            if (c1255g.f3980c) {
                c1255g.f3980c = false;
                z10 = true;
            }
            i6++;
        }
        if (z10) {
            RunnableC0005f runnableC0005f = this.f3874U;
            if (!z7) {
                runnableC0005f.run();
            } else {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                postOnAnimation(runnableC0005f);
            }
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean zM3083b;
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        if (keyEvent.getAction() != 0) {
            zM3083b = false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode == 22) {
                    zM3083b = keyEvent.hasModifiers(2) ? m3093m() : m3083b(66);
                } else if (keyCode != 61) {
                    zM3083b = false;
                } else if (keyEvent.hasNoModifiers()) {
                    zM3083b = m3083b(2);
                } else if (keyEvent.hasModifiers(1)) {
                    zM3083b = m3083b(1);
                } else {
                    zM3083b = false;
                }
            } else if (keyEvent.hasModifiers(2)) {
                int i6 = this.f3881f;
                if (i6 > 0) {
                    m3101u(i6 - 1, true);
                    zM3083b = true;
                } else {
                    zM3083b = false;
                }
            } else {
                zM3083b = m3083b(17);
            }
        }
        return zM3083b;
    }

    @Override
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C1255g c1255gM3088h;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0 && (c1255gM3088h = m3088h(childAt)) != null && c1255gM3088h.f3979b == this.f3881f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final void draw(Canvas canvas) {
        AbstractC1249a abstractC1249a;
        EdgeEffect edgeEffect = this.f3866M;
        EdgeEffect edgeEffect2 = this.f3865L;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (abstractC1249a = this.f3880e) != null && abstractC1249a.mo3131c() > 1)) {
            if (!edgeEffect2.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.f3891p * width);
                edgeEffect2.setSize(height, width);
                zDraw = edgeEffect2.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!edgeEffect.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f3892q + 1.0f)) * width2);
                edgeEffect.setSize(height2, width2);
                zDraw |= edgeEffect.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            edgeEffect2.finish();
            edgeEffect.finish();
        }
        if (zDraw) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            postInvalidateOnAnimation();
        }
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3888m;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void m3085e() {
        int iMo3131c = this.f3880e.mo3131c();
        this.f3876a = iMo3131c;
        ArrayList arrayList = this.f3877b;
        boolean z7 = arrayList.size() < (this.f3897v * 2) + 1 && arrayList.size() < iMo3131c;
        int i6 = this.f3881f;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            C1255g c1255g = (C1255g) arrayList.get(i10);
            AbstractC1249a abstractC1249a = this.f3880e;
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c1255g.f3978a;
            abstractC1249a.getClass();
        }
        Collections.sort(arrayList, f3852b0);
        if (z7) {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i11).getLayoutParams();
                if (!layoutParams.f3902a) {
                    layoutParams.f3904c = 0.0f;
                }
            }
            m3102v(i6, 0, false, true);
            requestLayout();
        }
    }

    public final void m3086f(int i6) {
        InterfaceC1258j interfaceC1258j = this.f3871R;
        if (interfaceC1258j != null) {
            interfaceC1258j.onPageSelected(i6);
        }
        ArrayList arrayList = this.f3870Q;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                InterfaceC1258j interfaceC1258j2 = (InterfaceC1258j) this.f3870Q.get(i10);
                if (interfaceC1258j2 != null) {
                    interfaceC1258j2.onPageSelected(i6);
                }
            }
        }
        InterfaceC1258j interfaceC1258j3 = this.f3872S;
        if (interfaceC1258j3 != null) {
            interfaceC1258j3.onPageSelected(i6);
        }
    }

    public final Rect m3087g(View view, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.f3904c = 0.0f;
        return layoutParams;
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public AbstractC1249a getAdapter() {
        return this.f3880e;
    }

    @Override
    public final int getChildDrawingOrder(int i6, int i10) {
        throw null;
    }

    public int getCurrentItem() {
        return this.f3881f;
    }

    public int getOffscreenPageLimit() {
        return this.f3897v;
    }

    public int getPageMargin() {
        return this.f3887l;
    }

    public final C1255g m3088h(View view) {
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f3877b;
            if (i6 >= arrayList.size()) {
                return null;
            }
            C1255g c1255g = (C1255g) arrayList.get(i6);
            AbstractC1249a abstractC1249a = this.f3880e;
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c1255g.f3978a;
            ((AbstractC0418n0) abstractC1249a).getClass();
            if (abstractComponentCallbacksC0427s.f1951F == view) {
                return c1255g;
            }
            i6++;
        }
    }

    public final C1255g m3089i() {
        C1255g c1255g;
        int i6;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.f3887l / clientWidth : 0.0f;
        C1255g c1255g2 = null;
        float f4 = 0.0f;
        int i10 = -1;
        int i11 = 0;
        boolean z7 = true;
        while (true) {
            ArrayList arrayList = this.f3877b;
            if (i11 >= arrayList.size()) {
                return c1255g2;
            }
            C1255g c1255g3 = (C1255g) arrayList.get(i11);
            if (z7 || c1255g3.f3979b == (i6 = i10 + 1)) {
                c1255g = c1255g3;
            } else {
                float f5 = f + f4 + f3;
                C1255g c1255g4 = this.f3878c;
                c1255g4.f3982e = f5;
                c1255g4.f3979b = i6;
                this.f3880e.getClass();
                c1255g4.f3981d = 1.0f;
                i11--;
                c1255g = c1255g4;
            }
            f = c1255g.f3982e;
            float f10 = c1255g.f3981d + f + f3;
            if (!z7 && scrollX < f) {
                return c1255g2;
            }
            if (scrollX < f10 || i11 == arrayList.size() - 1) {
                return c1255g;
            }
            int i12 = c1255g.f3979b;
            float f11 = c1255g.f3981d;
            i11++;
            z7 = false;
            C1255g c1255g5 = c1255g;
            i10 = i12;
            f4 = f11;
            c1255g2 = c1255g5;
        }
    }

    public final C1255g m3090j(int i6) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f3877b;
            if (i10 >= arrayList.size()) {
                return null;
            }
            C1255g c1255g = (C1255g) arrayList.get(i10);
            if (c1255g.f3979b == i6) {
                return c1255g;
            }
            i10++;
        }
    }

    public final void m3091k(int i6, float f, int i10) {
        int iMax;
        int width;
        int left;
        if (this.f3869P > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f3902a) {
                    int i12 = layoutParams.f3903b & 7;
                    if (i12 != 1) {
                        if (i12 == 3) {
                            width = childAt.getWidth() + paddingLeft;
                        } else if (i12 != 5) {
                            width = paddingLeft;
                        } else {
                            iMax = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = width;
                    } else {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i13 = iMax;
                    width = paddingLeft;
                    paddingLeft = i13;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                    paddingLeft = width;
                }
            }
        }
        InterfaceC1258j interfaceC1258j = this.f3871R;
        if (interfaceC1258j != null) {
            interfaceC1258j.mo3134a(i6, f);
        }
        ArrayList arrayList = this.f3870Q;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i14 = 0; i14 < size; i14++) {
                InterfaceC1258j interfaceC1258j2 = (InterfaceC1258j) this.f3870Q.get(i14);
                if (interfaceC1258j2 != null) {
                    interfaceC1258j2.mo3134a(i6, f);
                }
            }
        }
        InterfaceC1258j interfaceC1258j3 = this.f3872S;
        if (interfaceC1258j3 != null) {
            interfaceC1258j3.mo3134a(i6, f);
        }
        this.f3868O = true;
    }

    public final void m3092l(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3859F) {
            int i6 = actionIndex == 0 ? 1 : 0;
            this.f3855B = motionEvent.getX(i6);
            this.f3859F = motionEvent.getPointerId(i6);
            VelocityTracker velocityTracker = this.f3860G;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean m3093m() {
        AbstractC1249a abstractC1249a = this.f3880e;
        if (abstractC1249a == null || this.f3881f >= abstractC1249a.mo3131c() - 1) {
            return false;
        }
        m3101u(this.f3881f + 1, true);
        return true;
    }

    public final boolean m3094n(int i6) {
        if (this.f3877b.size() == 0) {
            if (this.f3867N) {
                return false;
            }
            this.f3868O = false;
            m3091k(0, 0.0f, 0);
            if (this.f3868O) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C1255g c1255gM3089i = m3089i();
        int clientWidth = getClientWidth();
        int i10 = this.f3887l;
        int i11 = clientWidth + i10;
        float f = clientWidth;
        int i12 = c1255gM3089i.f3979b;
        float f3 = ((i6 / f) - c1255gM3089i.f3982e) / (c1255gM3089i.f3981d + (i10 / f));
        this.f3868O = false;
        m3091k(i12, f3, (int) (i11 * f3));
        if (this.f3868O) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean m3095o(float f) {
        boolean z7;
        boolean z10;
        float f3 = this.f3855B - f;
        this.f3855B = f;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.f3891p * clientWidth;
        float f5 = this.f3892q * clientWidth;
        ArrayList arrayList = this.f3877b;
        boolean z11 = false;
        C1255g c1255g = (C1255g) arrayList.get(0);
        C1255g c1255g2 = (C1255g) AbstractC2460q.m5491e(1, arrayList);
        if (c1255g.f3979b != 0) {
            f4 = c1255g.f3982e * clientWidth;
            z7 = false;
        } else {
            z7 = true;
        }
        if (c1255g2.f3979b != this.f3880e.mo3131c() - 1) {
            f5 = c1255g2.f3982e * clientWidth;
            z10 = false;
        } else {
            z10 = true;
        }
        if (scrollX < f4) {
            if (z7) {
                this.f3865L.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z11 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z10) {
                this.f3866M.onPull(Math.abs(scrollX - f5) / clientWidth);
                z11 = true;
            }
            scrollX = f5;
        }
        int i6 = (int) scrollX;
        this.f3855B = (scrollX - i6) + this.f3855B;
        scrollTo(i6, getScrollY());
        m3094n(i6);
        return z11;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3867N = true;
    }

    @Override
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f3874U);
        Scroller scroller = this.f3884i;
        if (scroller != null && !scroller.isFinished()) {
            this.f3884i.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override
    public final void onDraw(Canvas canvas) {
        int i6;
        float f;
        super.onDraw(canvas);
        if (this.f3887l <= 0 || this.f3888m == null) {
            return;
        }
        ArrayList arrayList = this.f3877b;
        if (arrayList.size() <= 0 || this.f3880e == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f3 = width;
        float f4 = this.f3887l / f3;
        int i10 = 0;
        C1255g c1255g = (C1255g) arrayList.get(0);
        float f5 = c1255g.f3982e;
        int size = arrayList.size();
        int i11 = c1255g.f3979b;
        int i12 = ((C1255g) arrayList.get(size - 1)).f3979b;
        while (i11 < i12) {
            while (true) {
                i6 = c1255g.f3979b;
                if (i11 <= i6 || i10 >= size) {
                    break;
                }
                i10++;
                c1255g = (C1255g) arrayList.get(i10);
            }
            if (i11 == i6) {
                float f10 = c1255g.f3982e;
                float f11 = c1255g.f3981d;
                f = (f10 + f11) * f3;
                f5 = f10 + f11 + f4;
            } else {
                this.f3880e.getClass();
                f = (f5 + 1.0f) * f3;
                f5 = 1.0f + f4 + f5;
            }
            if (this.f3887l + f > scrollX) {
                this.f3888m.setBounds(Math.round(f), this.f3889n, Math.round(this.f3887l + f), this.f3890o);
                this.f3888m.draw(canvas);
            }
            if (f > scrollX + width) {
                return;
            }
            i11++;
            arrayList = arrayList;
            f4 = f4;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i6 = this.f3854A;
        Scroller scroller = this.f3884i;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m3099s();
            return false;
        }
        if (action != 0) {
            if (this.f3898w) {
                return true;
            }
            if (this.f3899x) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.f3857D = x10;
            this.f3855B = x10;
            float y7 = motionEvent.getY();
            this.f3858E = y7;
            this.f3856C = y7;
            this.f3859F = motionEvent.getPointerId(0);
            this.f3899x = false;
            this.f3885j = true;
            scroller.computeScrollOffset();
            if (this.f3875V != 2 || Math.abs(scroller.getFinalX() - scroller.getCurrX()) <= this.f3864K) {
                m3084d(false);
                this.f3898w = false;
            } else {
                scroller.abortAnimation();
                this.f3896u = false;
                m3096p();
                this.f3898w = true;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        } else if (action == 2) {
            int i10 = this.f3859F;
            if (i10 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i10);
                float x11 = motionEvent.getX(iFindPointerIndex);
                float f = x11 - this.f3855B;
                float fAbs = Math.abs(f);
                float y9 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y9 - this.f3858E);
                if (f != 0.0f) {
                    float f3 = this.f3855B;
                    if ((f3 >= this.f3901z || f <= 0.0f) && ((f3 <= getWidth() - this.f3901z || f >= 0.0f) && m3081c((int) f, (int) x11, (int) y9, this, false))) {
                        this.f3855B = x11;
                        this.f3856C = y9;
                        this.f3899x = true;
                        return false;
                    }
                }
                float f4 = i6;
                if (fAbs > f4 && fAbs * 0.5f > fAbs2) {
                    this.f3898w = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                    float f5 = this.f3857D;
                    float f10 = i6;
                    this.f3855B = f > 0.0f ? f5 + f10 : f5 - f10;
                    this.f3856C = y9;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > f4) {
                    this.f3899x = true;
                }
                if (this.f3898w && m3095o(x11)) {
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            m3092l(motionEvent);
        }
        if (this.f3860G == null) {
            this.f3860G = VelocityTracker.obtain();
        }
        this.f3860G.addMovement(motionEvent);
        return this.f3898w;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        boolean z10;
        C1255g c1255gM3088h;
        int iMax;
        int measuredWidth;
        int iMax2;
        int measuredHeight;
        int childCount = getChildCount();
        int i13 = i11 - i6;
        int i14 = i12 - i10;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f3902a) {
                    int i17 = layoutParams.f3903b;
                    int i18 = i17 & 7;
                    int i19 = i17 & 112;
                    if (i18 != 1) {
                        if (i18 == 3) {
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i18 != 5) {
                            measuredWidth = paddingLeft;
                        } else {
                            iMax = (i13 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i19 != 16) {
                            if (i19 != 48) {
                                measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i19 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                iMax2 = (i14 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i20 = paddingLeft + scrollX;
                            childAt.layout(i20, paddingTop, childAt.getMeasuredWidth() + i20, childAt.getMeasuredHeight() + paddingTop);
                            i15++;
                            paddingTop = measuredHeight;
                            paddingLeft = measuredWidth;
                        } else {
                            iMax2 = Math.max((i14 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i21 = iMax2;
                        measuredHeight = paddingTop;
                        paddingTop = i21;
                        int i22 = paddingLeft + scrollX;
                        childAt.layout(i22, paddingTop, childAt.getMeasuredWidth() + i22, childAt.getMeasuredHeight() + paddingTop);
                        i15++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax = Math.max((i13 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i23 = iMax;
                    measuredWidth = paddingLeft;
                    paddingLeft = i23;
                    if (i19 != 16) {
                        if (i19 != 48) {
                            measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                        } else if (i19 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            iMax2 = (i14 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        int i24 = paddingLeft + scrollX;
                        childAt.layout(i24, paddingTop, childAt.getMeasuredWidth() + i24, childAt.getMeasuredHeight() + paddingTop);
                        i15++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax2 = Math.max((i14 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    }
                    int i25 = iMax2;
                    measuredHeight = paddingTop;
                    paddingTop = i25;
                    int i26 = paddingLeft + scrollX;
                    childAt.layout(i26, paddingTop, childAt.getMeasuredWidth() + i26, childAt.getMeasuredHeight() + paddingTop);
                    i15++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i27 = (i13 - paddingLeft) - paddingRight;
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt2 = getChildAt(i28);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f3902a && (c1255gM3088h = m3088h(childAt2)) != null) {
                    float f = i27;
                    int i29 = ((int) (c1255gM3088h.f3982e * f)) + paddingLeft;
                    if (layoutParams2.f3905d) {
                        layoutParams2.f3905d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.f3904c), 1073741824), View.MeasureSpec.makeMeasureSpec((i14 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i29, paddingTop, childAt2.getMeasuredWidth() + i29, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.f3889n = paddingTop;
        this.f3890o = i14 - paddingBottom;
        this.f3869P = i15;
        if (this.f3867N) {
            z10 = false;
            m3100t(this.f3881f, 0, false, false);
        } else {
            z10 = false;
        }
        this.f3867N = z10;
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i11;
        int i12;
        int i13;
        setMeasuredDimension(View.getDefaultSize(0, i6), View.getDefaultSize(0, i10));
        int measuredWidth = getMeasuredWidth();
        this.f3901z = Math.min(measuredWidth / 10, this.f3900y);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i14 = 0;
        while (true) {
            boolean z7 = true;
            int i15 = 1073741824;
            if (i14 >= childCount) {
                break;
            }
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f3902a) {
                int i16 = layoutParams2.f3903b;
                int i17 = i16 & 7;
                int i18 = i16 & 112;
                boolean z10 = i18 == 48 || i18 == 80;
                if (i17 != 3 && i17 != 5) {
                    z7 = false;
                }
                int i19 = Integer.MIN_VALUE;
                if (z10) {
                    i19 = 1073741824;
                } else {
                    i11 = z7 ? 1073741824 : Integer.MIN_VALUE;
                    i12 = ((ViewGroup.LayoutParams) layoutParams2).width;
                    if (i12 != -2) {
                        if (i12 == -1) {
                            i12 = paddingLeft;
                        }
                        i19 = 1073741824;
                    } else {
                        i12 = paddingLeft;
                    }
                    i13 = ((ViewGroup.LayoutParams) layoutParams2).height;
                    if (i13 != -2) {
                        i13 = measuredHeight;
                        i15 = i11;
                    } else if (i13 == -1) {
                        i13 = measuredHeight;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i12, i19), View.MeasureSpec.makeMeasureSpec(i13, i15));
                    if (z10) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (z7) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
                i12 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i12 != -2) {
                    if (i12 == -1) {
                        i12 = paddingLeft;
                    }
                    i19 = 1073741824;
                } else {
                    i12 = paddingLeft;
                }
                i13 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i13 != -2) {
                    i13 = measuredHeight;
                    i15 = i11;
                } else if (i13 == -1) {
                    i13 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i12, i19), View.MeasureSpec.makeMeasureSpec(i13, i15));
                if (z10) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z7) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i14++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f3893r = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f3894s = true;
        m3096p();
        this.f3894s = false;
        int childCount2 = getChildCount();
        for (int i20 = 0; i20 < childCount2; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f3902a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.f3904c), 1073741824), this.f3893r);
            }
        }
    }

    @Override
    public final boolean onRequestFocusInDescendants(int i6, Rect rect) {
        int i10;
        int i11;
        int i12;
        C1255g c1255gM3088h;
        int childCount = getChildCount();
        if ((i6 & 2) != 0) {
            i11 = childCount;
            i10 = 0;
            i12 = 1;
        } else {
            i10 = childCount - 1;
            i11 = -1;
            i12 = -1;
        }
        while (i10 != i11) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (c1255gM3088h = m3088h(childAt)) != null && c1255gM3088h.f3979b == this.f3881f && childAt.requestFocus(i6, rect)) {
                return true;
            }
            i10 += i12;
        }
        return false;
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1689a);
        if (this.f3880e != null) {
            m3102v(savedState.f3906c, 0, false, true);
        } else {
            this.f3882g = savedState.f3906c;
            this.f3883h = savedState.f3907d;
        }
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3906c = this.f3881f;
        AbstractC1249a abstractC1249a = this.f3880e;
        if (abstractC1249a != null) {
            abstractC1249a.getClass();
            savedState.f3907d = null;
        }
        return savedState;
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        super.onSizeChanged(i6, i10, i11, i12);
        if (i6 != i11) {
            int i13 = this.f3887l;
            m3098r(i6, i11, i13, i13);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractC1249a abstractC1249a;
        int i6 = this.f3854A;
        boolean zM3099s = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (abstractC1249a = this.f3880e) == null || abstractC1249a.mo3131c() == 0) {
            return false;
        }
        if (this.f3860G == null) {
            this.f3860G = VelocityTracker.obtain();
        }
        this.f3860G.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f3884i.abortAnimation();
            this.f3896u = false;
            m3096p();
            float x10 = motionEvent.getX();
            this.f3857D = x10;
            this.f3855B = x10;
            float y7 = motionEvent.getY();
            this.f3858E = y7;
            this.f3856C = y7;
            this.f3859F = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.f3855B = motionEvent.getX(actionIndex);
                        this.f3859F = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        m3092l(motionEvent);
                        this.f3855B = motionEvent.getX(motionEvent.findPointerIndex(this.f3859F));
                    }
                } else if (this.f3898w) {
                    m3100t(this.f3881f, 0, true, false);
                    zM3099s = m3099s();
                }
            } else if (!this.f3898w) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f3859F);
                if (iFindPointerIndex == -1) {
                    zM3099s = m3099s();
                } else {
                    float x11 = motionEvent.getX(iFindPointerIndex);
                    float fAbs = Math.abs(x11 - this.f3855B);
                    float y9 = motionEvent.getY(iFindPointerIndex);
                    float fAbs2 = Math.abs(y9 - this.f3856C);
                    if (fAbs > i6 && fAbs > fAbs2) {
                        this.f3898w = true;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        float f = this.f3857D;
                        float f3 = i6;
                        this.f3855B = x11 - f > 0.0f ? f + f3 : f - f3;
                        this.f3856C = y9;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.f3898w) {
                        zM3099s = m3095o(motionEvent.getX(motionEvent.findPointerIndex(this.f3859F)));
                    }
                }
            } else if (this.f3898w) {
                zM3099s = m3095o(motionEvent.getX(motionEvent.findPointerIndex(this.f3859F)));
            }
        } else if (this.f3898w) {
            VelocityTracker velocityTracker = this.f3860G;
            velocityTracker.computeCurrentVelocity(1000, this.f3862I);
            int xVelocity = (int) velocityTracker.getXVelocity(this.f3859F);
            this.f3896u = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            C1255g c1255gM3089i = m3089i();
            float f4 = clientWidth;
            float f5 = this.f3887l / f4;
            int iMax = c1255gM3089i.f3979b;
            float f10 = ((scrollX / f4) - c1255gM3089i.f3982e) / (c1255gM3089i.f3981d + f5);
            if (Math.abs((int) (motionEvent.getX(motionEvent.findPointerIndex(this.f3859F)) - this.f3857D)) <= this.f3863J || Math.abs(xVelocity) <= this.f3861H) {
                iMax += (int) (f10 + (iMax >= this.f3881f ? 0.4f : 0.6f));
            } else if (xVelocity <= 0) {
                iMax++;
            }
            ArrayList arrayList = this.f3877b;
            if (arrayList.size() > 0) {
                iMax = Math.max(((C1255g) arrayList.get(0)).f3979b, Math.min(iMax, ((C1255g) AbstractC2460q.m5491e(1, arrayList)).f3979b));
            }
            m3102v(iMax, xVelocity, true, true);
            zM3099s = m3099s();
        }
        if (zM3099s) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            postInvalidateOnAnimation();
        }
        return true;
    }

    public final void m3096p() {
        m3097q(this.f3881f);
    }

    public final void m3097q(int i6) {
        C1255g c1255gM3090j;
        String hexString;
        ArrayList arrayList;
        C1255g c1255gM3082a;
        C1255g c1255gM3088h;
        C1255g c1255gM3088h2;
        int i10;
        int i11;
        C1255g c1255g;
        C1255g c1255g2;
        C1255g c1255g3;
        int i12 = this.f3881f;
        if (i12 != i6) {
            c1255gM3090j = m3090j(i12);
            this.f3881f = i6;
        } else {
            c1255gM3090j = null;
        }
        if (this.f3880e == null || this.f3896u || getWindowToken() == null) {
            return;
        }
        this.f3880e.mo1286g(this);
        int i13 = this.f3897v;
        int iMax = Math.max(0, this.f3881f - i13);
        int iMo3131c = this.f3880e.mo3131c();
        int iMin = Math.min(iMo3131c - 1, this.f3881f + i13);
        if (iMo3131c != this.f3876a) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f3876a + ", found: " + iMo3131c + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.f3880e.getClass());
        }
        int i14 = 0;
        while (true) {
            arrayList = this.f3877b;
            if (i14 < arrayList.size()) {
                c1255gM3082a = (C1255g) arrayList.get(i14);
                int i15 = c1255gM3082a.f3979b;
                int i16 = this.f3881f;
                if (i15 >= i16) {
                    if (i15 != i16) {
                        break;
                    } else {
                        break;
                    }
                }
                i14++;
            }
            c1255gM3082a = null;
            break;
        }
        if (c1255gM3082a == null && iMo3131c > 0) {
            c1255gM3082a = m3082a(this.f3881f, i14);
        }
        if (c1255gM3082a != null) {
            int i17 = i14 - 1;
            C1255g c1255g4 = i17 >= 0 ? (C1255g) arrayList.get(i17) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (getPaddingLeft() / clientWidth) + (2.0f - c1255gM3082a.f3981d);
            float f = 0.0f;
            for (int i18 = this.f3881f - 1; i18 >= 0; i18--) {
                if (f < paddingLeft || i18 >= iMax) {
                    if (c1255g4 == null || i18 != c1255g4.f3979b) {
                        f += m3082a(i18, i17 + 1).f3981d;
                        i14++;
                        if (i17 >= 0) {
                            c1255g3 = (C1255g) arrayList.get(i17);
                        } else {
                            c1255g3 = null;
                        }
                    } else {
                        f += c1255g4.f3981d;
                        i17--;
                        if (i17 >= 0) {
                            c1255g3 = (C1255g) arrayList.get(i17);
                        } else {
                            c1255g3 = null;
                        }
                    }
                    c1255g4 = c1255g3;
                } else {
                    if (c1255g4 == null) {
                        break;
                    }
                    if (i18 == c1255g4.f3979b && !c1255g4.f3980c) {
                        arrayList.remove(i17);
                        this.f3880e.mo1283a(c1255g4.f3978a);
                        i17--;
                        i14--;
                        if (i17 >= 0) {
                            c1255g3 = (C1255g) arrayList.get(i17);
                        } else {
                            c1255g3 = null;
                        }
                        c1255g4 = c1255g3;
                    }
                }
            }
            float f3 = c1255gM3082a.f3981d;
            int i19 = i14 + 1;
            if (f3 < 2.0f) {
                C1255g c1255g5 = i19 < arrayList.size() ? (C1255g) arrayList.get(i19) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i20 = i19;
                for (int i21 = this.f3881f + 1; i21 < iMo3131c; i21++) {
                    if (f3 >= paddingRight && i21 > iMin) {
                        if (c1255g5 == null) {
                            break;
                        }
                        if (i21 == c1255g5.f3979b && !c1255g5.f3980c) {
                            arrayList.remove(i20);
                            this.f3880e.mo1283a(c1255g5.f3978a);
                            if (i20 < arrayList.size()) {
                                c1255g5 = (C1255g) arrayList.get(i20);
                            } else {
                                c1255g5 = null;
                            }
                        }
                    } else if (c1255g5 == null || i21 != c1255g5.f3979b) {
                        C1255g c1255gM3082a2 = m3082a(i21, i20);
                        i20++;
                        f3 += c1255gM3082a2.f3981d;
                        if (i20 < arrayList.size()) {
                            c1255g5 = (C1255g) arrayList.get(i20);
                        } else {
                            c1255g5 = null;
                        }
                    } else {
                        f3 += c1255g5.f3981d;
                        i20++;
                        if (i20 < arrayList.size()) {
                            c1255g5 = (C1255g) arrayList.get(i20);
                        } else {
                            c1255g5 = null;
                        }
                    }
                }
            }
            int iMo3131c2 = this.f3880e.mo3131c();
            int clientWidth2 = getClientWidth();
            float f4 = clientWidth2 > 0 ? this.f3887l / clientWidth2 : 0.0f;
            if (c1255gM3090j != null) {
                int i22 = c1255gM3090j.f3979b;
                int i23 = c1255gM3082a.f3979b;
                if (i22 < i23) {
                    float f5 = c1255gM3090j.f3982e + c1255gM3090j.f3981d + f4;
                    int i24 = i22 + 1;
                    int i25 = 0;
                    while (i24 <= c1255gM3082a.f3979b && i25 < arrayList.size()) {
                        Object obj = arrayList.get(i25);
                        while (true) {
                            c1255g2 = (C1255g) obj;
                            if (i24 <= c1255g2.f3979b || i25 >= arrayList.size() - 1) {
                                break;
                            }
                            i25++;
                            obj = arrayList.get(i25);
                        }
                        while (i24 < c1255g2.f3979b) {
                            this.f3880e.getClass();
                            f5 += 1.0f + f4;
                            i24++;
                        }
                        c1255g2.f3982e = f5;
                        f5 += c1255g2.f3981d + f4;
                        i24++;
                    }
                } else if (i22 > i23) {
                    int size = arrayList.size() - 1;
                    float f10 = c1255gM3090j.f3982e;
                    while (true) {
                        i22--;
                        if (i22 < c1255gM3082a.f3979b || size < 0) {
                            break;
                        }
                        Object obj2 = arrayList.get(size);
                        while (true) {
                            c1255g = (C1255g) obj2;
                            if (i22 >= c1255g.f3979b || size <= 0) {
                                break;
                            }
                            size--;
                            obj2 = arrayList.get(size);
                        }
                        while (i22 > c1255g.f3979b) {
                            this.f3880e.getClass();
                            f10 -= 1.0f + f4;
                            i22--;
                        }
                        f10 -= c1255g.f3981d + f4;
                        c1255g.f3982e = f10;
                    }
                }
            }
            int size2 = arrayList.size();
            float f11 = c1255gM3082a.f3982e;
            int i26 = c1255gM3082a.f3979b;
            int i27 = i26 - 1;
            this.f3891p = i26 == 0 ? f11 : -3.4028235E38f;
            int i28 = iMo3131c2 - 1;
            this.f3892q = i26 == i28 ? (c1255gM3082a.f3981d + f11) - 1.0f : Float.MAX_VALUE;
            int i29 = i14 - 1;
            while (i29 >= 0) {
                C1255g c1255g6 = (C1255g) arrayList.get(i29);
                while (true) {
                    i11 = c1255g6.f3979b;
                    if (i27 <= i11) {
                        break;
                    }
                    i27--;
                    this.f3880e.getClass();
                    f11 -= 1.0f + f4;
                }
                f11 -= c1255g6.f3981d + f4;
                c1255g6.f3982e = f11;
                if (i11 == 0) {
                    this.f3891p = f11;
                }
                i29--;
                i27--;
            }
            float f12 = c1255gM3082a.f3982e + c1255gM3082a.f3981d + f4;
            int i30 = c1255gM3082a.f3979b;
            while (true) {
                i30++;
                if (i19 >= size2) {
                    break;
                }
                C1255g c1255g7 = (C1255g) arrayList.get(i19);
                while (true) {
                    i10 = c1255g7.f3979b;
                    if (i30 >= i10) {
                        break;
                    }
                    i30++;
                    this.f3880e.getClass();
                    f12 += 1.0f + f4;
                }
                if (i10 == i28) {
                    this.f3892q = (c1255g7.f3981d + f12) - 1.0f;
                }
                c1255g7.f3982e = f12;
                f12 += c1255g7.f3981d + f4;
                i19++;
            }
            this.f3880e.mo1285e(this, this.f3881f, c1255gM3082a.f3978a);
        }
        this.f3880e.mo1284b();
        int childCount = getChildCount();
        for (int i31 = 0; i31 < childCount; i31++) {
            View childAt = getChildAt(i31);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.getClass();
            if (!layoutParams.f3902a && layoutParams.f3904c == 0.0f && (c1255gM3088h2 = m3088h(childAt)) != null) {
                layoutParams.f3904c = c1255gM3088h2.f3981d;
            }
        }
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            if (viewFindFocus == null) {
                c1255gM3088h = null;
                break;
            }
            while (true) {
                Object parent = viewFindFocus.getParent();
                if (parent == this) {
                    c1255gM3088h = m3088h(viewFindFocus);
                    break;
                } else {
                    if (parent == null || !(parent instanceof View)) {
                        c1255gM3088h = null;
                        break;
                    }
                    viewFindFocus = (View) parent;
                }
            }
            if (c1255gM3088h == null || c1255gM3088h.f3979b != this.f3881f) {
                for (int i32 = 0; i32 < getChildCount(); i32++) {
                    View childAt2 = getChildAt(i32);
                    C1255g c1255gM3088h3 = m3088h(childAt2);
                    if (c1255gM3088h3 != null && c1255gM3088h3.f3979b == this.f3881f && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    public final void m3098r(int i6, int i10, int i11, int i12) {
        if (i10 > 0 && !this.f3877b.isEmpty()) {
            if (!this.f3884i.isFinished()) {
                this.f3884i.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i10 - getPaddingLeft()) - getPaddingRight()) + i12)) * (((i6 - getPaddingLeft()) - getPaddingRight()) + i11)), getScrollY());
                return;
            }
        }
        C1255g c1255gM3090j = m3090j(this.f3881f);
        int iMin = (int) ((c1255gM3090j != null ? Math.min(c1255gM3090j.f3982e, this.f3892q) : 0.0f) * ((i6 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            m3084d(false);
            scrollTo(iMin, getScrollY());
        }
    }

    @Override
    public final void removeView(View view) {
        if (this.f3894s) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final boolean m3099s() {
        this.f3859F = -1;
        this.f3898w = false;
        this.f3899x = false;
        VelocityTracker velocityTracker = this.f3860G;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3860G = null;
        }
        this.f3865L.onRelease();
        this.f3866M.onRelease();
        return this.f3865L.isFinished() || this.f3866M.isFinished();
    }

    public void setAdapter(AbstractC1249a abstractC1249a) {
        ArrayList arrayList;
        AbstractC1249a abstractC1249a2 = this.f3880e;
        if (abstractC1249a2 != null) {
            synchronized (abstractC1249a2) {
                abstractC1249a2.f3971b = null;
            }
            this.f3880e.mo1286g(this);
            int i6 = 0;
            while (true) {
                arrayList = this.f3877b;
                if (i6 >= arrayList.size()) {
                    break;
                }
                C1255g c1255g = (C1255g) arrayList.get(i6);
                AbstractC1249a abstractC1249a3 = this.f3880e;
                int i10 = c1255g.f3979b;
                abstractC1249a3.mo1283a(c1255g.f3978a);
                i6++;
            }
            this.f3880e.mo1284b();
            arrayList.clear();
            int i11 = 0;
            while (i11 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i11).getLayoutParams()).f3902a) {
                    removeViewAt(i11);
                    i11--;
                }
                i11++;
            }
            this.f3881f = 0;
            scrollTo(0, 0);
        }
        AbstractC1249a abstractC1249a4 = this.f3880e;
        this.f3880e = abstractC1249a;
        this.f3876a = 0;
        if (abstractC1249a != null) {
            if (this.f3886k == null) {
                this.f3886k = new C0175a2(1, this);
            }
            this.f3880e.m3133f(this.f3886k);
            this.f3896u = false;
            boolean z7 = this.f3867N;
            this.f3867N = true;
            this.f3876a = this.f3880e.mo3131c();
            if (this.f3882g >= 0) {
                this.f3880e.getClass();
                m3102v(this.f3882g, 0, false, true);
                this.f3882g = -1;
            } else if (z7) {
                requestLayout();
            } else {
                m3096p();
            }
        }
        ArrayList arrayList2 = this.f3873T;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        int size = this.f3873T.size();
        for (int i12 = 0; i12 < size; i12++) {
            ((InterfaceC1257i) this.f3873T.get(i12)).mo3135b(this, abstractC1249a4, abstractC1249a);
        }
    }

    public void setCurrentItem(int i6) {
        this.f3896u = false;
        m3102v(i6, 0, !this.f3867N, false);
    }

    public void setOffscreenPageLimit(int i6) {
        if (i6 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i6 + " too small; defaulting to 1");
            i6 = 1;
        }
        if (i6 != this.f3897v) {
            this.f3897v = i6;
            m3096p();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(InterfaceC1258j interfaceC1258j) {
        this.f3871R = interfaceC1258j;
    }

    public void setPageMargin(int i6) {
        int i10 = this.f3887l;
        this.f3887l = i6;
        int width = getWidth();
        m3098r(width, width, i6, i10);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f3888m = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i6) {
        if (this.f3875V == i6) {
            return;
        }
        this.f3875V = i6;
        InterfaceC1258j interfaceC1258j = this.f3871R;
        if (interfaceC1258j != null) {
            interfaceC1258j.onPageScrollStateChanged(i6);
        }
        ArrayList arrayList = this.f3870Q;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                InterfaceC1258j interfaceC1258j2 = (InterfaceC1258j) this.f3870Q.get(i10);
                if (interfaceC1258j2 != null) {
                    interfaceC1258j2.onPageScrollStateChanged(i6);
                }
            }
        }
        InterfaceC1258j interfaceC1258j3 = this.f3872S;
        if (interfaceC1258j3 != null) {
            interfaceC1258j3.onPageScrollStateChanged(i6);
        }
    }

    public final void m3100t(int i6, int i10, boolean z7, boolean z10) {
        int iMax;
        int scrollX;
        int iAbs;
        Scroller scroller = this.f3884i;
        C1255g c1255gM3090j = m3090j(i6);
        if (c1255gM3090j != null) {
            iMax = (int) (Math.max(this.f3891p, Math.min(c1255gM3090j.f3982e, this.f3892q)) * getClientWidth());
        } else {
            iMax = 0;
        }
        if (!z7) {
            if (z10) {
                m3086f(i6);
            }
            m3084d(false);
            scrollTo(iMax, 0);
            m3094n(iMax);
            return;
        }
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
        } else {
            if (scroller == null || scroller.isFinished()) {
                scrollX = getScrollX();
            } else {
                scrollX = this.f3885j ? scroller.getCurrX() : scroller.getStartX();
                scroller.abortAnimation();
                setScrollingCacheEnabled(false);
            }
            int i11 = scrollX;
            int scrollY = getScrollY();
            int i12 = iMax - i11;
            int i13 = 0 - scrollY;
            if (i12 == 0 && i13 == 0) {
                m3084d(false);
                m3096p();
                setScrollState(0);
            } else {
                setScrollingCacheEnabled(true);
                setScrollState(2);
                int clientWidth = getClientWidth();
                int i14 = clientWidth / 2;
                float f = clientWidth;
                float f3 = i14;
                float fSin = (((float) Math.sin((Math.min(1.0f, (Math.abs(i12) * 1.0f) / f) - 0.5f) * 0.47123894f)) * f3) + f3;
                int iAbs2 = Math.abs(i10);
                if (iAbs2 > 0) {
                    iAbs = Math.round(Math.abs(fSin / iAbs2) * 1000.0f) * 4;
                } else {
                    this.f3880e.getClass();
                    iAbs = (int) (((Math.abs(i12) / ((f * 1.0f) + this.f3887l)) + 1.0f) * 100.0f);
                }
                int iMin = Math.min(iAbs, BannerConfig.SCROLL_TIME);
                this.f3885j = false;
                this.f3884i.startScroll(i11, scrollY, i12, i13, iMin);
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                postInvalidateOnAnimation();
            }
        }
        if (z10) {
            m3086f(i6);
        }
    }

    public final void m3101u(int i6, boolean z7) {
        this.f3896u = false;
        m3102v(i6, 0, z7, false);
    }

    public final void m3102v(int i6, int i10, boolean z7, boolean z10) {
        AbstractC1249a abstractC1249a = this.f3880e;
        if (abstractC1249a == null || abstractC1249a.mo3131c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        ArrayList arrayList = this.f3877b;
        if (!z10 && this.f3881f == i6 && arrayList.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i6 < 0) {
            i6 = 0;
        } else if (i6 >= this.f3880e.mo3131c()) {
            i6 = this.f3880e.mo3131c() - 1;
        }
        int i11 = this.f3897v;
        int i12 = this.f3881f;
        if (i6 > i12 + i11 || i6 < i12 - i11) {
            for (int i13 = 0; i13 < arrayList.size(); i13++) {
                ((C1255g) arrayList.get(i13)).f3980c = true;
            }
        }
        boolean z11 = this.f3881f != i6;
        if (!this.f3867N) {
            m3097q(i6);
            m3100t(i6, i10, z7, z11);
        } else {
            this.f3881f = i6;
            if (z11) {
                m3086f(i6);
            }
            requestLayout();
        }
    }

    @Override
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3888m;
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i6) {
        setPageMarginDrawable(AbstractC2115a.m5069b(getContext(), i6));
    }
}

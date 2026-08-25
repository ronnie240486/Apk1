package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.widget.C0376i;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p034d0.AbstractC2115a;
import p056f0.C2480c;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p138n0.C3153r1;
import p148o0.C3228c;
import p187r4.C3624n;
import p226v0.C3968d;
import p257y0.AbstractC4196a;
import p267z0.C4284b;
import p267z0.InterfaceC4285c;
import p267z0.ViewOnApplyWindowInsetsListenerC4283a;

public class DrawerLayout extends ViewGroup {

    public static final int[] f1704C = {R.attr.colorPrimaryDark};

    public static final int[] f1705D = {R.attr.layout_gravity};

    public static final boolean f1706E;

    public static final boolean f1707F;

    public static final boolean f1708G;

    public Matrix f1709A;

    public final C3624n f1710B;

    public final C0376i f1711a;

    public float f1712b;

    public final int f1713c;

    public int f1714d;

    public float f1715e;

    public final Paint f1716f;

    public final C3968d f1717g;

    public final C3968d f1718h;

    public final C0390b f1719i;

    public final C0390b f1720j;

    public int f1721k;

    public boolean f1722l;

    public boolean f1723m;

    public int f1724n;

    public int f1725o;

    public int f1726p;

    public int f1727q;

    public boolean f1728r;

    public ArrayList f1729s;

    public float f1730t;

    public float f1731u;

    public Drawable f1732v;

    public WindowInsets f1733w;

    public boolean f1734x;

    public final ArrayList f1735y;

    public Rect f1736z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        public int f1737a;

        public float f1738b;

        public boolean f1739c;

        public int f1740d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1737a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f1705D);
            this.f1737a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0389a();

        public int f1741c;

        public int f1742d;

        public int f1743e;

        public int f1744f;

        public int f1745g;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1741c = 0;
            this.f1741c = parcel.readInt();
            this.f1742d = parcel.readInt();
            this.f1743e = parcel.readInt();
            this.f1744f = parcel.readInt();
            this.f1745g = parcel.readInt();
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f1741c);
            parcel.writeInt(this.f1742d);
            parcel.writeInt(this.f1743e);
            parcel.writeInt(this.f1744f);
            parcel.writeInt(this.f1745g);
        }
    }

    static {
        int i6 = Build.VERSION.SDK_INT;
        f1706E = true;
        f1707F = true;
        f1708G = i6 >= 29;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.drawerLayoutStyle);
    }

    public static boolean m1161i(View view) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return (view.getImportantForAccessibility() == 4 || view.getImportantForAccessibility() == 2) ? false : true;
    }

    public static boolean m1162j(View view) {
        return ((LayoutParams) view.getLayoutParams()).f1737a == 0;
    }

    public static boolean m1163k(View view) {
        if (m1164l(view)) {
            return (((LayoutParams) view.getLayoutParams()).f1740d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public static boolean m1164l(View view) {
        int i6 = ((LayoutParams) view.getLayoutParams()).f1737a;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i6, view.getLayoutDirection());
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    public final boolean m1165a(int i6, View view) {
        return (m1172h(view) & i6) == i6;
    }

    @Override
    public final void addFocusables(ArrayList arrayList, int i6, int i10) {
        ArrayList arrayList2;
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        int i11 = 0;
        boolean z7 = false;
        while (true) {
            arrayList2 = this.f1735y;
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (!m1164l(childAt)) {
                arrayList2.add(childAt);
            } else if (m1163k(childAt)) {
                childAt.addFocusables(arrayList, i6, i10);
                z7 = true;
            }
            i11++;
        }
        if (!z7) {
            int size = arrayList2.size();
            for (int i12 = 0; i12 < size; i12++) {
                View view = (View) arrayList2.get(i12);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i6, i10);
                }
            }
        }
        arrayList2.clear();
    }

    @Override
    public final void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i6, layoutParams);
        if (m1169e() != null || m1164l(view)) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            view.setImportantForAccessibility(4);
        } else {
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            view.setImportantForAccessibility(1);
        }
        if (f1706E) {
            return;
        }
        AbstractC3155s0.m6347q(view, this.f1711a);
    }

    public final void m1166b(View view) {
        if (!m1164l(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f1723m) {
            layoutParams.f1738b = 0.0f;
            layoutParams.f1740d = 0;
        } else {
            layoutParams.f1740d |= 4;
            if (m1165a(3, view)) {
                this.f1717g.m7964s(view, -view.getWidth(), view.getTop());
            } else {
                this.f1718h.m7964s(view, getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public final void m1167c(boolean z7) {
        boolean zM7964s;
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (m1164l(childAt) && (!z7 || layoutParams.f1739c)) {
                int width = childAt.getWidth();
                if (m1165a(3, childAt)) {
                    int top = childAt.getTop();
                    zM7964s = this.f1717g.m7964s(childAt, -width, top);
                } else {
                    zM7964s = this.f1718h.m7964s(childAt, getWidth(), childAt.getTop());
                }
                z10 |= zM7964s;
                layoutParams.f1739c = false;
            }
        }
        C0390b c0390b = this.f1719i;
        c0390b.f1749f.removeCallbacks(c0390b.f1748e);
        C0390b c0390b2 = this.f1720j;
        c0390b2.f1749f.removeCallbacks(c0390b2.f1748e);
        if (z10) {
            invalidate();
        }
    }

    @Override
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override
    public final void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i6 = 0; i6 < childCount; i6++) {
            fMax = Math.max(fMax, ((LayoutParams) getChildAt(i6).getLayoutParams()).f1738b);
        }
        this.f1715e = fMax;
        boolean zM7952g = this.f1717g.m7952g();
        boolean zM7952g2 = this.f1718h.m7952g();
        if (zM7952g || zM7952g2) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            postInvalidateOnAnimation();
        }
    }

    public final View m1168d(int i6) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i6, getLayoutDirection()) & 7;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((m1172h(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    @Override
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean zDispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f1715e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y7 = motionEvent.getY();
        for (int i6 = childCount - 1; i6 >= 0; i6--) {
            View childAt = getChildAt(i6);
            if (this.f1736z == null) {
                this.f1736z = new Rect();
            }
            childAt.getHitRect(this.f1736z);
            if (this.f1736z.contains((int) x10, (int) y7) && !m1162j(childAt)) {
                if (childAt.getMatrix().isIdentity()) {
                    float scrollX = getScrollX() - childAt.getLeft();
                    float scrollY = getScrollY() - childAt.getTop();
                    motionEvent.offsetLocation(scrollX, scrollY);
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                } else {
                    float scrollX2 = getScrollX() - childAt.getLeft();
                    float scrollY2 = getScrollY() - childAt.getTop();
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.offsetLocation(scrollX2, scrollY2);
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.f1709A == null) {
                            this.f1709A = new Matrix();
                        }
                        matrix.invert(this.f1709A);
                        motionEventObtain.transform(this.f1709A);
                    }
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (zDispatchGenericMotionEvent) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public final boolean drawChild(Canvas canvas, View view, long j10) {
        Drawable background;
        int height = getHeight();
        boolean zM1162j = m1162j(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i6 = 0;
        if (zM1162j) {
            int childCount = getChildCount();
            int i10 = 0;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt != view && childAt.getVisibility() == 0 && (background = childAt.getBackground()) != null && background.getOpacity() == -1 && m1164l(childAt) && childAt.getHeight() >= height) {
                    if (m1165a(3, childAt)) {
                        int right = childAt.getRight();
                        if (right > i10) {
                            i10 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i10, 0, width, getHeight());
            i6 = i10;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(iSave);
        float f = this.f1715e;
        if (f > 0.0f && zM1162j) {
            int i12 = this.f1714d;
            Paint paint = this.f1716f;
            paint.setColor((((int) ((((-16777216) & i12) >>> 24) * f)) << 24) | (i12 & 16777215));
            canvas.drawRect(i6, 0.0f, width, getHeight(), paint);
        }
        return zDrawChild;
    }

    public final View m1169e() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if ((((LayoutParams) childAt.getLayoutParams()).f1740d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public final View m1170f() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (m1164l(childAt)) {
                if (!m1164l(childAt)) {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
                if (((LayoutParams) childAt.getLayoutParams()).f1738b > 0.0f) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public final int m1171g(View view) {
        if (!m1164l(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        int i6 = ((LayoutParams) view.getLayoutParams()).f1737a;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int layoutDirection = getLayoutDirection();
        if (i6 == 3) {
            int i10 = this.f1724n;
            if (i10 != 3) {
                return i10;
            }
            int i11 = layoutDirection == 0 ? this.f1726p : this.f1727q;
            if (i11 != 3) {
                return i11;
            }
        } else if (i6 == 5) {
            int i12 = this.f1725o;
            if (i12 != 3) {
                return i12;
            }
            int i13 = layoutDirection == 0 ? this.f1727q : this.f1726p;
            if (i13 != 3) {
                return i13;
            }
        } else if (i6 == 8388611) {
            int i14 = this.f1726p;
            if (i14 != 3) {
                return i14;
            }
            int i15 = layoutDirection == 0 ? this.f1724n : this.f1725o;
            if (i15 != 3) {
                return i15;
            }
        } else if (i6 == 8388613) {
            int i16 = this.f1727q;
            if (i16 != 3) {
                return i16;
            }
            int i17 = layoutDirection == 0 ? this.f1725o : this.f1724n;
            if (i17 != 3) {
                return i17;
            }
        }
        return 0;
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.f1737a = 0;
        return layoutParams;
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(layoutParams2);
            layoutParams3.f1737a = 0;
            layoutParams3.f1737a = layoutParams2.f1737a;
            return layoutParams3;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            LayoutParams layoutParams4 = new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            layoutParams4.f1737a = 0;
            return layoutParams4;
        }
        LayoutParams layoutParams5 = new LayoutParams(layoutParams);
        layoutParams5.f1737a = 0;
        return layoutParams5;
    }

    public float getDrawerElevation() {
        if (f1707F) {
            return this.f1712b;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f1732v;
    }

    public final int m1172h(View view) {
        int i6 = ((LayoutParams) view.getLayoutParams()).f1737a;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return Gravity.getAbsoluteGravity(i6, getLayoutDirection());
    }

    public final void m1173m(View view) {
        if (!m1164l(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f1723m) {
            layoutParams.f1738b = 1.0f;
            layoutParams.f1740d = 1;
            m1177q(view, true);
            m1176p(view);
        } else {
            layoutParams.f1740d |= 2;
            if (m1165a(3, view)) {
                this.f1717g.m7964s(view, 0, view.getTop());
            } else {
                this.f1718h.m7964s(view, getWidth() - view.getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public final void m1174n(int i6, int i10) {
        View viewM1168d;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i10, getLayoutDirection());
        if (i10 == 3) {
            this.f1724n = i6;
        } else if (i10 == 5) {
            this.f1725o = i6;
        } else if (i10 == 8388611) {
            this.f1726p = i6;
        } else if (i10 == 8388613) {
            this.f1727q = i6;
        }
        if (i6 != 0) {
            (absoluteGravity == 3 ? this.f1717g : this.f1718h).m7946a();
        }
        if (i6 != 1) {
            if (i6 == 2 && (viewM1168d = m1168d(absoluteGravity)) != null) {
                m1173m(viewM1168d);
                return;
            }
            return;
        }
        View viewM1168d2 = m1168d(absoluteGravity);
        if (viewM1168d2 != null) {
            m1166b(viewM1168d2);
        }
    }

    public final void m1175o(View view, float f) {
        int size;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f == layoutParams.f1738b) {
            return;
        }
        layoutParams.f1738b = f;
        ArrayList arrayList = this.f1729s;
        if (arrayList != null && (size = arrayList.size() - 1) >= 0) {
            throw AbstractC0004e.m17k(size, this.f1729s);
        }
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1723m = true;
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1723m = true;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f1734x || this.f1732v == null) {
            return;
        }
        WindowInsets windowInsets = this.f1733w;
        int systemWindowInsetTop = windowInsets != null ? windowInsets.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f1732v.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f1732v.draw(canvas);
        }
    }

    @Override
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        View viewM7953h;
        int actionMasked = motionEvent.getActionMasked();
        C3968d c3968d = this.f1717g;
        boolean zM7963r = c3968d.m7963r(motionEvent) | this.f1718h.m7963r(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                m1167c(true);
                this.f1728r = false;
            } else if (actionMasked == 2) {
                int length = c3968d.f13481d.length;
                for (int i6 = 0; i6 < length; i6++) {
                    if ((c3968d.f13488k & (1 << i6)) != 0) {
                        float f = c3968d.f13483f[i6] - c3968d.f13481d[i6];
                        float f3 = c3968d.f13484g[i6] - c3968d.f13482e[i6];
                        float f4 = (f3 * f3) + (f * f);
                        int i10 = c3968d.f13479b;
                        if (f4 > i10 * i10) {
                            C0390b c0390b = this.f1719i;
                            c0390b.f1749f.removeCallbacks(c0390b.f1748e);
                            C0390b c0390b2 = this.f1720j;
                            c0390b2.f1749f.removeCallbacks(c0390b2.f1748e);
                            break;
                        }
                    }
                }
            } else if (actionMasked == 3) {
                m1167c(true);
                this.f1728r = false;
            }
            z7 = false;
        } else {
            float x10 = motionEvent.getX();
            float y7 = motionEvent.getY();
            this.f1730t = x10;
            this.f1731u = y7;
            z7 = this.f1715e > 0.0f && (viewM7953h = c3968d.m7953h((int) x10, (int) y7)) != null && m1162j(viewM7953h);
            this.f1728r = false;
        }
        if (zM7963r || z7) {
            return true;
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (((LayoutParams) getChildAt(i11).getLayoutParams()).f1739c) {
                return true;
            }
        }
        return this.f1728r;
    }

    @Override
    public final boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (i6 != 4 || m1170f() == null) {
            return super.onKeyDown(i6, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override
    public final boolean onKeyUp(int i6, KeyEvent keyEvent) {
        if (i6 != 4) {
            return super.onKeyUp(i6, keyEvent);
        }
        View viewM1170f = m1170f();
        if (viewM1170f != null && m1171g(viewM1170f) == 0) {
            m1167c(false);
        }
        return viewM1170f != null;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        WindowInsets rootWindowInsets;
        float f;
        int i13;
        this.f1722l = true;
        int i14 = i11 - i6;
        int childCount = getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m1162j(childAt)) {
                    int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i16, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i16, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m1165a(3, childAt)) {
                        float f3 = measuredWidth;
                        i13 = (-measuredWidth) + ((int) (layoutParams.f1738b * f3));
                        f = (measuredWidth + i13) / f3;
                    } else {
                        float f4 = measuredWidth;
                        int i17 = i14 - ((int) (layoutParams.f1738b * f4));
                        f = (i14 - i17) / f4;
                        i13 = i17;
                    }
                    boolean z10 = f != layoutParams.f1738b;
                    int i18 = layoutParams.f1737a & 112;
                    if (i18 == 16) {
                        int i19 = i12 - i10;
                        int i20 = (i19 - measuredHeight) / 2;
                        int i21 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i20 < i21) {
                            i20 = i21;
                        } else {
                            int i22 = i20 + measuredHeight;
                            int i23 = i19 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i22 > i23) {
                                i20 = i23 - measuredHeight;
                            }
                        }
                        childAt.layout(i13, i20, measuredWidth + i13, measuredHeight + i20);
                    } else if (i18 != 80) {
                        int i24 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        childAt.layout(i13, i24, measuredWidth + i13, measuredHeight + i24);
                    } else {
                        int i25 = i12 - i10;
                        childAt.layout(i13, (i25 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i13, i25 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    if (z10) {
                        m1175o(childAt, f);
                    }
                    int i26 = layoutParams.f1738b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i26) {
                        childAt.setVisibility(i26);
                    }
                }
            }
        }
        if (f1708G && (rootWindowInsets = getRootWindowInsets()) != null) {
            C2480c c2480cMo6273j = C3153r1.m6324h(rootWindowInsets, null).f10641a.mo6273j();
            C3968d c3968d = this.f1717g;
            c3968d.f13492o = Math.max(c3968d.f13493p, c2480cMo6273j.f8681a);
            C3968d c3968d2 = this.f1718h;
            c3968d2.f13492o = Math.max(c3968d2.f13493p, c2480cMo6273j.f8683c);
        }
        this.f1722l = false;
        this.f1723m = false;
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        boolean z7;
        String hexString;
        int i11 = 3;
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i6);
        int size2 = View.MeasureSpec.getSize(i10);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        if (this.f1733w != null) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (getFitsSystemWindows()) {
                z7 = true;
            } else {
                z7 = false;
            }
        } else {
            z7 = false;
        }
        WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
        int layoutDirection = getLayoutDirection();
        int childCount = getChildCount();
        int i12 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z7) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(layoutParams.f1737a, layoutDirection);
                    if (childAt.getFitsSystemWindows()) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets = this.f1733w;
                        if (absoluteGravity == i11) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                    } else {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = this.f1733w;
                        if (absoluteGravity == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (m1162j(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
                } else {
                    if (!m1164l(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i12 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (f1707F) {
                        float fM6170i = AbstractC3119g0.m6170i(childAt);
                        float f = this.f1712b;
                        if (fM6170i != f) {
                            AbstractC3119g0.m6180s(childAt, f);
                        }
                    }
                    int iM1172h = m1172h(childAt);
                    int i13 = iM1172h & 7;
                    boolean z12 = i13 == 3;
                    if ((z12 && z10) || (!z12 && z11)) {
                        StringBuilder sb = new StringBuilder("Child drawer has absolute gravity ");
                        if ((iM1172h & 3) != 3) {
                            hexString = (iM1172h & 5) == 5 ? "RIGHT" : Integer.toHexString(i13);
                        } else {
                            hexString = "LEFT";
                        }
                        throw new IllegalStateException(AbstractC0004e.m26t(sb, hexString, " but this DrawerLayout already has a drawer view along that edge"));
                    }
                    if (z12) {
                        z10 = true;
                    } else {
                        z11 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i6, this.f1713c + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i10, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                }
                i12++;
                i11 = 3;
            }
            i12++;
            i11 = 3;
        }
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        View viewM1168d;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1689a);
        int i6 = savedState.f1741c;
        if (i6 != 0 && (viewM1168d = m1168d(i6)) != null) {
            m1173m(viewM1168d);
        }
        int i10 = savedState.f1742d;
        if (i10 != 3) {
            m1174n(i10, 3);
        }
        int i11 = savedState.f1743e;
        if (i11 != 3) {
            m1174n(i11, 5);
        }
        int i12 = savedState.f1744f;
        if (i12 != 3) {
            m1174n(i12, 8388611);
        }
        int i13 = savedState.f1745g;
        if (i13 != 3) {
            m1174n(i13, 8388613);
        }
    }

    @Override
    public final void onRtlPropertiesChanged(int i6) {
        if (f1707F) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        getLayoutDirection();
        getLayoutDirection();
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1741c = 0;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
            int i10 = layoutParams.f1740d;
            boolean z7 = i10 == 1;
            boolean z10 = i10 == 2;
            if (z7 || z10) {
                savedState.f1741c = layoutParams.f1737a;
                break;
            }
        }
        savedState.f1742d = this.f1724n;
        savedState.f1743e = this.f1725o;
        savedState.f1744f = this.f1726p;
        savedState.f1745g = this.f1727q;
        return savedState;
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        View viewM1169e;
        C3968d c3968d = this.f1717g;
        c3968d.m7956k(motionEvent);
        this.f1718h.m7956k(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x10 = motionEvent.getX();
            float y7 = motionEvent.getY();
            this.f1730t = x10;
            this.f1731u = y7;
            this.f1728r = false;
        } else if (action == 1) {
            float x11 = motionEvent.getX();
            float y9 = motionEvent.getY();
            View viewM7953h = c3968d.m7953h((int) x11, (int) y9);
            if (viewM7953h != null && m1162j(viewM7953h)) {
                float f = x11 - this.f1730t;
                float f3 = y9 - this.f1731u;
                int i6 = c3968d.f13479b;
                z7 = (f3 * f3) + (f * f) >= ((float) (i6 * i6)) || (viewM1169e = m1169e()) == null || m1171g(viewM1169e) == 2;
            }
            m1167c(z7);
        } else if (action == 3) {
            m1167c(true);
            this.f1728r = false;
        }
        return true;
    }

    public final void m1176p(View view) {
        C3228c c3228c = C3228c.f10848l;
        AbstractC3155s0.m6343m(c3228c.m6512a(), view);
        if (!m1163k(view) || m1171g(view) == 2) {
            return;
        }
        AbstractC3155s0.m6345o(view, c3228c, this.f1710B);
    }

    public final void m1177q(View view, boolean z7) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if ((z7 || m1164l(childAt)) && !(z7 && childAt == view)) {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                childAt.setImportantForAccessibility(4);
            } else {
                WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
                childAt.setImportantForAccessibility(1);
            }
        }
    }

    @Override
    public final void requestDisallowInterceptTouchEvent(boolean z7) {
        super.requestDisallowInterceptTouchEvent(z7);
        if (z7) {
            m1167c(true);
        }
    }

    @Override
    public final void requestLayout() {
        if (this.f1722l) {
            return;
        }
        super.requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.f1712b = f;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (m1164l(childAt)) {
                float f3 = this.f1712b;
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                AbstractC3119g0.m6180s(childAt, f3);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(InterfaceC4285c interfaceC4285c) {
        if (interfaceC4285c != null) {
            if (this.f1729s == null) {
                this.f1729s = new ArrayList();
            }
            this.f1729s.add(interfaceC4285c);
        }
    }

    public void setDrawerLockMode(int i6) {
        m1174n(i6, 3);
        m1174n(i6, 5);
    }

    public void setScrimColor(int i6) {
        this.f1714d = i6;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f1732v = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i6) {
        this.f1732v = new ColorDrawable(i6);
        invalidate();
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1711a = new C0376i(3);
        this.f1714d = -1728053248;
        this.f1716f = new Paint();
        this.f1723m = true;
        this.f1724n = 3;
        this.f1725o = 3;
        this.f1726p = 3;
        this.f1727q = 3;
        this.f1710B = new C3624n(11, this);
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f1713c = (int) ((64.0f * f) + 0.5f);
        float f3 = f * 400.0f;
        C0390b c0390b = new C0390b(this, 3);
        this.f1719i = c0390b;
        C0390b c0390b2 = new C0390b(this, 5);
        this.f1720j = c0390b2;
        C3968d c3968d = new C3968d(getContext(), this, c0390b);
        c3968d.f13479b = (int) (c3968d.f13479b * 1.0f);
        this.f1717g = c3968d;
        c3968d.f13494q = 1;
        c3968d.f13491n = f3;
        c0390b.f1747d = c3968d;
        C3968d c3968d2 = new C3968d(getContext(), this, c0390b2);
        c3968d2.f13479b = (int) (1.0f * c3968d2.f13479b);
        this.f1718h = c3968d2;
        c3968d2.f13494q = 2;
        c3968d2.f13491n = f3;
        c0390b2.f1747d = c3968d2;
        setFocusableInTouchMode(true);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setImportantForAccessibility(1);
        AbstractC3155s0.m6347q(this, new C4284b(this));
        setMotionEventSplittingEnabled(false);
        if (getFitsSystemWindows()) {
            setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC4283a());
            setSystemUiVisibility(1280);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f1704C);
            try {
                this.f1732v = typedArrayObtainStyledAttributes.getDrawable(0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC4196a.f14264a, i6, 0);
        try {
            if (typedArrayObtainStyledAttributes2.hasValue(0)) {
                this.f1712b = typedArrayObtainStyledAttributes2.getDimension(0, 0.0f);
            } else {
                this.f1712b = getResources().getDimension(com.p2serv.android.p032ds.R.dimen.def_drawer_elevation);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.f1735y = new ArrayList();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th2;
        }
    }

    public void setStatusBarBackground(int i6) {
        this.f1732v = i6 != 0 ? AbstractC2115a.m5069b(getContext(), i6) : null;
        invalidate();
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}

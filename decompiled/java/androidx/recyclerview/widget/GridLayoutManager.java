package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.appcompat.app.AbstractC0127c0;
import androidx.media3.common.C0565C;
import androidx.media3.extractor.p010ts.TsExtractor;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import p000a.AbstractC0004e;
import p148o0.C3228c;
import p148o0.C3232g;
import p148o0.C3233h;

public class GridLayoutManager extends LinearLayoutManager {

    public static final Set f3444l = Collections.unmodifiableSet(new HashSet(Arrays.asList(17, 66, 33, Integer.valueOf(TsExtractor.TS_STREAM_TYPE_HDMV_DTS))));

    public boolean f3445a;

    public int f3446b;

    public int[] f3447c;

    public View[] f3448d;

    public final SparseIntArray f3449e;

    public final SparseIntArray f3450f;

    public AbstractC0127c0 f3451g;

    public final Rect f3452h;

    public int f3453i;

    public int f3454j;

    public int f3455k;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i6, int i10) {
        super(context, attributeSet, i6, i10);
        this.f3445a = false;
        this.f3446b = -1;
        this.f3449e = new SparseIntArray();
        this.f3450f = new SparseIntArray();
        this.f3451g = new C1187u();
        this.f3452h = new Rect();
        this.f3453i = -1;
        this.f3454j = -1;
        this.f3455k = -1;
        m2811C(AbstractC1197x0.getProperties(context, attributeSet, i6, i10).f3462b);
    }

    public final int m2809A(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        if (!c1162l1.f3621g) {
            return this.f3451g.mo377j(i6);
        }
        int i10 = this.f3449e.get(i6, -1);
        if (i10 != -1) {
            return i10;
        }
        int iM2926b = c1140e1.m2926b(i6);
        if (iM2926b != -1) {
            return this.f3451g.mo377j(iM2926b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i6);
        return 1;
    }

    public final void m2810B(View view, int i6, boolean z7) {
        int childMeasureSpec;
        int childMeasureSpec2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f3466b;
        int i10 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i11 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int iM2819x = m2819x(layoutParams.f3456e, layoutParams.f3457f);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = AbstractC1197x0.getChildMeasureSpec(iM2819x, i6, i11, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            childMeasureSpec = AbstractC1197x0.getChildMeasureSpec(this.mOrientationHelper.mo2893l(), getHeightMode(), i10, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec3 = AbstractC1197x0.getChildMeasureSpec(iM2819x, i6, i10, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec4 = AbstractC1197x0.getChildMeasureSpec(this.mOrientationHelper.mo2893l(), getWidthMode(), i11, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z7 ? shouldReMeasureChild(view, childMeasureSpec2, childMeasureSpec, layoutParams2) : shouldMeasureChild(view, childMeasureSpec2, childMeasureSpec, layoutParams2)) {
            view.measure(childMeasureSpec2, childMeasureSpec);
        }
    }

    public final void m2811C(int i6) {
        if (i6 == this.f3446b) {
            return;
        }
        this.f3445a = true;
        if (i6 < 1) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Span count should be at least 1. Provided "));
        }
        this.f3446b = i6;
        this.f3451g.m378k();
        requestLayout();
    }

    public final void m2812D() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        m2813r(height - paddingTop);
    }

    @Override
    public final boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override
    public final void collectPrefetchPositionsForLayoutState(C1162l1 c1162l1, C1199y c1199y, InterfaceC1194w0 interfaceC1194w0) {
        int i6;
        int iMo377j = this.f3446b;
        for (int i10 = 0; i10 < this.f3446b && (i6 = c1199y.f3733d) >= 0 && i6 < c1162l1.m2970b() && iMo377j > 0; i10++) {
            int i11 = c1199y.f3733d;
            ((C1178r) interfaceC1194w0).m2986a(i11, Math.max(0, c1199y.f3736g));
            iMo377j -= this.f3451g.mo377j(i11);
            c1199y.f3733d += c1199y.f3734e;
        }
    }

    @Override
    public final View findReferenceChild(C1140e1 c1140e1, C1162l1 c1162l1, boolean z7, boolean z10) {
        int i6;
        int childCount;
        int childCount2 = getChildCount();
        int i10 = 1;
        if (z10) {
            childCount = getChildCount() - 1;
            i6 = -1;
            i10 = -1;
        } else {
            i6 = childCount2;
            childCount = 0;
        }
        int iM2970b = c1162l1.m2970b();
        ensureLayoutState();
        int iMo2892k = this.mOrientationHelper.mo2892k();
        int iMo2888g = this.mOrientationHelper.mo2888g();
        View view = null;
        View view2 = null;
        while (childCount != i6) {
            View childAt = getChildAt(childCount);
            int position = getPosition(childAt);
            if (position >= 0 && position < iM2970b && m2821z(position, c1140e1, c1162l1) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).f3465a.isRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.mo2886e(childAt) < iMo2888g && this.mOrientationHelper.mo2883b(childAt) >= iMo2892k) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            childCount += i10;
        }
        return view != null ? view : view2;
    }

    @Override
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override
    public final RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override
    public final int getColumnCountForAccessibility(C1140e1 c1140e1, C1162l1 c1162l1) {
        if (this.mOrientation == 1) {
            return Math.min(this.f3446b, getItemCount());
        }
        if (c1162l1.m2970b() < 1) {
            return 0;
        }
        return m2820y(c1162l1.m2970b() - 1, c1140e1, c1162l1) + 1;
    }

    @Override
    public final int getRowCountForAccessibility(C1140e1 c1140e1, C1162l1 c1162l1) {
        if (this.mOrientation == 0) {
            return Math.min(this.f3446b, getItemCount());
        }
        if (c1162l1.m2970b() < 1) {
            return 0;
        }
        return m2820y(c1162l1.m2970b() - 1, c1140e1, c1162l1) + 1;
    }

    @Override
    public final void layoutChunk(C1140e1 c1140e1, C1162l1 c1162l1, C1199y c1199y, C1196x c1196x) {
        int i6;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int iMo2885d;
        int iMo2885d2;
        int i16;
        int iMo2885d3;
        int childMeasureSpec;
        int childMeasureSpec2;
        boolean z7;
        int i17;
        View viewM3012b;
        int iMo2891j = this.mOrientationHelper.mo2891j();
        boolean z10 = iMo2891j != 1073741824;
        int i18 = getChildCount() > 0 ? this.f3447c[this.f3446b] : 0;
        if (z10) {
            m2812D();
        }
        boolean z11 = c1199y.f3734e == 1;
        int iM2821z = this.f3446b;
        if (!z11) {
            iM2821z = m2821z(c1199y.f3733d, c1140e1, c1162l1) + m2809A(c1199y.f3733d, c1140e1, c1162l1);
        }
        int i19 = 0;
        while (i19 < this.f3446b && (i17 = c1199y.f3733d) >= 0 && i17 < c1162l1.m2970b() && iM2821z > 0) {
            int i20 = c1199y.f3733d;
            int iM2809A = m2809A(i20, c1140e1, c1162l1);
            if (iM2809A > this.f3446b) {
                StringBuilder sbM28v = AbstractC0004e.m28v("Item at position ", i20, " requires ", iM2809A, " spans but GridLayoutManager has only ");
                sbM28v.append(this.f3446b);
                sbM28v.append(" spans.");
                throw new IllegalArgumentException(sbM28v.toString());
            }
            iM2821z -= iM2809A;
            if (iM2821z < 0 || (viewM3012b = c1199y.m3012b(c1140e1)) == null) {
                break;
            }
            this.f3448d[i19] = viewM3012b;
            i19++;
        }
        if (i19 == 0) {
            c1196x.f3727b = true;
            return;
        }
        if (z11) {
            i10 = i19;
            i6 = 0;
            i11 = 1;
        } else {
            i6 = i19 - 1;
            i10 = -1;
            i11 = -1;
        }
        int i21 = 0;
        while (i6 != i10) {
            View view = this.f3448d[i6];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int iM2809A2 = m2809A(getPosition(view), c1140e1, c1162l1);
            layoutParams.f3457f = iM2809A2;
            layoutParams.f3456e = i21;
            i21 += iM2809A2;
            i6 += i11;
        }
        float f = 0.0f;
        int i22 = 0;
        for (int i23 = 0; i23 < i19; i23++) {
            View view2 = this.f3448d[i23];
            if (c1199y.f3740k != null) {
                z7 = false;
                if (z11) {
                    addDisappearingView(view2);
                } else {
                    addDisappearingView(view2, 0);
                }
            } else if (z11) {
                addView(view2);
                z7 = false;
            } else {
                z7 = false;
                addView(view2, 0);
            }
            calculateItemDecorationsForChild(view2, this.f3452h);
            m2810B(view2, iMo2891j, z7);
            int iMo2884c = this.mOrientationHelper.mo2884c(view2);
            if (iMo2884c > i22) {
                i22 = iMo2884c;
            }
            float fMo2885d = (this.mOrientationHelper.mo2885d(view2) * 1.0f) / ((LayoutParams) view2.getLayoutParams()).f3457f;
            if (fMo2885d > f) {
                f = fMo2885d;
            }
        }
        if (z10) {
            m2813r(Math.max(Math.round(f * this.f3446b), i18));
            i22 = 0;
            for (int i24 = 0; i24 < i19; i24++) {
                View view3 = this.f3448d[i24];
                m2810B(view3, 1073741824, true);
                int iMo2884c2 = this.mOrientationHelper.mo2884c(view3);
                if (iMo2884c2 > i22) {
                    i22 = iMo2884c2;
                }
            }
        }
        for (int i25 = 0; i25 < i19; i25++) {
            View view4 = this.f3448d[i25];
            if (this.mOrientationHelper.mo2884c(view4) != i22) {
                LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
                Rect rect = layoutParams2.f3466b;
                int i26 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                int i27 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                int iM2819x = m2819x(layoutParams2.f3456e, layoutParams2.f3457f);
                if (this.mOrientation == 1) {
                    childMeasureSpec2 = AbstractC1197x0.getChildMeasureSpec(iM2819x, 1073741824, i27, ((ViewGroup.MarginLayoutParams) layoutParams2).width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i22 - i26, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i22 - i27, 1073741824);
                    childMeasureSpec = AbstractC1197x0.getChildMeasureSpec(iM2819x, 1073741824, i26, ((ViewGroup.MarginLayoutParams) layoutParams2).height, false);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                if (shouldReMeasureChild(view4, childMeasureSpec2, childMeasureSpec, (RecyclerView.LayoutParams) view4.getLayoutParams())) {
                    view4.measure(childMeasureSpec2, childMeasureSpec);
                }
            }
        }
        int i28 = 0;
        c1196x.f3726a = i22;
        if (this.mOrientation != 1) {
            if (c1199y.f3735f == -1) {
                int i29 = c1199y.f3731b;
                i13 = i29 - i22;
                i12 = i29;
            } else {
                int i30 = c1199y.f3731b;
                i12 = i30 + i22;
                i13 = i30;
            }
            i14 = 0;
            i15 = 0;
        } else if (c1199y.f3735f == -1) {
            i15 = c1199y.f3731b;
            i14 = i15 - i22;
            i13 = 0;
            i12 = 0;
        } else {
            int i31 = c1199y.f3731b;
            i14 = i31;
            i12 = 0;
            i15 = i31 + i22;
            i13 = 0;
        }
        while (i28 < i19) {
            View view5 = this.f3448d[i28];
            LayoutParams layoutParams3 = (LayoutParams) view5.getLayoutParams();
            if (this.mOrientation != 1) {
                int paddingTop = getPaddingTop() + this.f3447c[layoutParams3.f3456e];
                iMo2885d = i13;
                iMo2885d2 = i12;
                i16 = paddingTop;
                iMo2885d3 = this.mOrientationHelper.mo2885d(view5) + paddingTop;
            } else if (isLayoutRTL()) {
                int paddingLeft = getPaddingLeft() + this.f3447c[this.f3446b - layoutParams3.f3456e];
                iMo2885d2 = paddingLeft;
                i16 = i14;
                iMo2885d3 = i15;
                iMo2885d = paddingLeft - this.mOrientationHelper.mo2885d(view5);
            } else {
                int paddingLeft2 = getPaddingLeft() + this.f3447c[layoutParams3.f3456e];
                iMo2885d2 = this.mOrientationHelper.mo2885d(view5) + paddingLeft2;
                i16 = i14;
                iMo2885d3 = i15;
                iMo2885d = paddingLeft2;
            }
            layoutDecoratedWithMargins(view5, iMo2885d, i16, iMo2885d2, iMo2885d3);
            if (layoutParams3.f3465a.isRemoved() || layoutParams3.f3465a.isUpdated()) {
                c1196x.f3728c = true;
            }
            c1196x.f3729d |= view5.hasFocusable();
            i28++;
            i13 = iMo2885d;
            i12 = iMo2885d2;
            i14 = i16;
            i15 = iMo2885d3;
        }
        Arrays.fill(this.f3448d, (Object) null);
    }

    @Override
    public final void onAnchorReady(C1140e1 c1140e1, C1162l1 c1162l1, C1193w c1193w, int i6) {
        super.onAnchorReady(c1140e1, c1162l1, c1193w, i6);
        m2812D();
        if (c1162l1.m2970b() > 0 && !c1162l1.f3621g) {
            boolean z7 = i6 == 1;
            int iM2821z = m2821z(c1193w.f3720b, c1140e1, c1162l1);
            if (z7) {
                while (iM2821z > 0) {
                    int i10 = c1193w.f3720b;
                    if (i10 <= 0) {
                        break;
                    }
                    int i11 = i10 - 1;
                    c1193w.f3720b = i11;
                    iM2821z = m2821z(i11, c1140e1, c1162l1);
                }
            } else {
                int iM2970b = c1162l1.m2970b() - 1;
                int i12 = c1193w.f3720b;
                while (i12 < iM2970b) {
                    int i13 = i12 + 1;
                    int iM2821z2 = m2821z(i13, c1140e1, c1162l1);
                    if (iM2821z2 <= iM2821z) {
                        break;
                    }
                    i12 = i13;
                    iM2821z = iM2821z2;
                }
                c1193w.f3720b = i12;
            }
        }
        m2814s();
    }

    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View onFocusSearchFailed(View view, int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        int childCount;
        int childCount2;
        int i10;
        View view2;
        View view3;
        int i11;
        int i12;
        int i13;
        int i14;
        C1140e1 c1140e2 = c1140e1;
        C1162l1 c1162l2 = c1162l1;
        View viewFindContainingItemView = findContainingItemView(view);
        View view4 = null;
        if (viewFindContainingItemView == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) viewFindContainingItemView.getLayoutParams();
        int i15 = layoutParams.f3456e;
        int i16 = layoutParams.f3457f + i15;
        if (super.onFocusSearchFailed(view, i6, c1140e1, c1162l1) == null) {
            return null;
        }
        if ((convertFocusDirectionToLayoutDirection(i6) == 1) != this.mShouldReverseLayout) {
            childCount2 = getChildCount() - 1;
            childCount = -1;
            i10 = -1;
        } else {
            childCount = getChildCount();
            childCount2 = 0;
            i10 = 1;
        }
        boolean z7 = this.mOrientation == 1 && isLayoutRTL();
        int iM2820y = m2820y(childCount2, c1140e2, c1162l2);
        int i17 = childCount2;
        int iMin = 0;
        int i18 = -1;
        int i19 = -1;
        int iMin2 = 0;
        View view5 = null;
        while (i17 != childCount) {
            int iM2820y2 = m2820y(i17, c1140e2, c1162l2);
            View childAt = getChildAt(i17);
            if (childAt == viewFindContainingItemView) {
                break;
            }
            if (!childAt.hasFocusable() || iM2820y2 == iM2820y) {
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                int i20 = layoutParams2.f3456e;
                view2 = viewFindContainingItemView;
                int i21 = layoutParams2.f3457f + i20;
                if (childAt.hasFocusable() && i20 == i15 && i21 == i16) {
                    return childAt;
                }
                if (!(childAt.hasFocusable() && view4 == null) && (childAt.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int iMin3 = Math.min(i21, i16) - Math.max(i20, i15);
                    if (!childAt.hasFocusable()) {
                        if (view4 == null) {
                            i11 = iMin;
                            i12 = childCount;
                            if (isViewPartiallyVisible(childAt, false, true)) {
                                i13 = iMin2;
                                if (iMin3 > i13) {
                                    i14 = i19;
                                } else if (iMin3 == i13) {
                                    i14 = i19;
                                    if (z7 == (i20 > i14)) {
                                    }
                                    i17 += i10;
                                    c1140e2 = c1140e1;
                                    c1162l2 = c1162l1;
                                    viewFindContainingItemView = view2;
                                    childCount = i12;
                                } else {
                                    i14 = i19;
                                }
                                if (childAt.hasFocusable()) {
                                    i18 = layoutParams2.f3456e;
                                    i19 = i14;
                                    iMin2 = i13;
                                    view5 = view3;
                                    view4 = childAt;
                                    iMin = Math.min(i21, i16) - Math.max(i20, i15);
                                } else {
                                    int i22 = layoutParams2.f3456e;
                                    iMin2 = Math.min(i21, i16) - Math.max(i20, i15);
                                    i19 = i22;
                                    iMin = i11;
                                    view5 = childAt;
                                }
                                i17 += i10;
                                c1140e2 = c1140e1;
                                c1162l2 = c1162l1;
                                viewFindContainingItemView = view2;
                                childCount = i12;
                            }
                            i19 = i14;
                            iMin2 = i13;
                            iMin = i11;
                            view5 = view3;
                            i17 += i10;
                            c1140e2 = c1140e1;
                            c1162l2 = c1162l1;
                            viewFindContainingItemView = view2;
                            childCount = i12;
                        }
                        i14 = i19;
                        i13 = iMin2;
                        i19 = i14;
                        iMin2 = i13;
                        iMin = i11;
                        view5 = view3;
                        i17 += i10;
                        c1140e2 = c1140e1;
                        c1162l2 = c1162l1;
                        viewFindContainingItemView = view2;
                        childCount = i12;
                    } else if (iMin3 <= iMin) {
                        if (iMin3 == iMin) {
                        }
                    }
                } else {
                    view3 = view5;
                }
                i11 = iMin;
                i12 = childCount;
                i14 = i19;
                i13 = iMin2;
                if (childAt.hasFocusable()) {
                    i18 = layoutParams2.f3456e;
                    i19 = i14;
                    iMin2 = i13;
                    view5 = view3;
                    view4 = childAt;
                    iMin = Math.min(i21, i16) - Math.max(i20, i15);
                } else {
                    int i23 = layoutParams2.f3456e;
                    iMin2 = Math.min(i21, i16) - Math.max(i20, i15);
                    i19 = i23;
                    iMin = i11;
                    view5 = childAt;
                }
                i17 += i10;
                c1140e2 = c1140e1;
                c1162l2 = c1162l1;
                viewFindContainingItemView = view2;
                childCount = i12;
            } else {
                if (view4 != null) {
                    break;
                }
                view2 = viewFindContainingItemView;
                view3 = view5;
            }
            i11 = iMin;
            i12 = childCount;
            i14 = i19;
            i13 = iMin2;
            i19 = i14;
            iMin2 = i13;
            iMin = i11;
            view5 = view3;
            i17 += i10;
            c1140e2 = c1140e1;
            c1162l2 = c1162l1;
            viewFindContainingItemView = view2;
            childCount = i12;
        }
        return view4 != null ? view4 : view5;
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(C1140e1 c1140e1, C1162l1 c1162l1, C3233h c3233h) {
        super.onInitializeAccessibilityNodeInfo(c1140e1, c1162l1, c3233h);
        c3233h.m6547i(GridView.class.getName());
        AbstractC1158k0 abstractC1158k0 = this.mRecyclerView.mAdapter;
        if (abstractC1158k0 == null || abstractC1158k0.getItemCount() <= 1) {
            return;
        }
        c3233h.m6541b(C3228c.f10855s);
    }

    @Override
    public final void onInitializeAccessibilityNodeInfoForItem(C1140e1 c1140e1, C1162l1 c1162l1, View view, C3233h c3233h) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, c3233h);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int iM2820y = m2820y(layoutParams2.f3465a.getLayoutPosition(), c1140e1, c1162l1);
        if (this.mOrientation == 0) {
            c3233h.m6549k(C3232g.m6538a(layoutParams2.f3456e, layoutParams2.f3457f, iM2820y, 1, false));
        } else {
            c3233h.m6549k(C3232g.m6538a(iM2820y, 1, layoutParams2.f3456e, layoutParams2.f3457f, false));
        }
    }

    @Override
    public final void onItemsAdded(RecyclerView recyclerView, int i6, int i10) {
        this.f3451g.m378k();
        ((SparseIntArray) this.f3451g.f269b).clear();
    }

    @Override
    public final void onItemsChanged(RecyclerView recyclerView) {
        this.f3451g.m378k();
        ((SparseIntArray) this.f3451g.f269b).clear();
    }

    @Override
    public final void onItemsMoved(RecyclerView recyclerView, int i6, int i10, int i11) {
        this.f3451g.m378k();
        ((SparseIntArray) this.f3451g.f269b).clear();
    }

    @Override
    public final void onItemsRemoved(RecyclerView recyclerView, int i6, int i10) {
        this.f3451g.m378k();
        ((SparseIntArray) this.f3451g.f269b).clear();
    }

    @Override
    public final void onItemsUpdated(RecyclerView recyclerView, int i6, int i10, Object obj) {
        this.f3451g.m378k();
        ((SparseIntArray) this.f3451g.f269b).clear();
    }

    @Override
    public final void onLayoutChildren(C1140e1 c1140e1, C1162l1 c1162l1) {
        boolean z7 = c1162l1.f3621g;
        SparseIntArray sparseIntArray = this.f3450f;
        SparseIntArray sparseIntArray2 = this.f3449e;
        if (z7) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
                int layoutPosition = layoutParams.f3465a.getLayoutPosition();
                sparseIntArray2.put(layoutPosition, layoutParams.f3457f);
                sparseIntArray.put(layoutPosition, layoutParams.f3456e);
            }
        }
        super.onLayoutChildren(c1140e1, c1162l1);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override
    public final void onLayoutCompleted(C1162l1 c1162l1) {
        View viewFindViewByPosition;
        super.onLayoutCompleted(c1162l1);
        this.f3445a = false;
        int i6 = this.f3453i;
        if (i6 == -1 || (viewFindViewByPosition = findViewByPosition(i6)) == null) {
            return;
        }
        viewFindViewByPosition.sendAccessibilityEvent(C0565C.BUFFER_FLAG_NOT_DEPENDED_ON);
        this.f3453i = -1;
    }

    @Override
    public final boolean performAccessibilityAction(int i6, Bundle bundle) {
        View childAt;
        AbstractC1174p1 childViewHolder;
        int iIntValue;
        int i10;
        if (i6 != C3228c.f10855s.m6512a() || i6 == -1) {
            if (i6 != 16908343 || bundle == null) {
                return super.performAccessibilityAction(i6, bundle);
            }
            int i11 = bundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT", -1);
            int i12 = bundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT", -1);
            if (i11 != -1 && i12 != -1) {
                int itemCount = this.mRecyclerView.mAdapter.getItemCount();
                int i13 = 0;
                while (true) {
                    if (i13 >= itemCount) {
                        i13 = -1;
                        break;
                    }
                    RecyclerView recyclerView = this.mRecyclerView;
                    int iM2821z = m2821z(i13, recyclerView.mRecycler, recyclerView.mState);
                    RecyclerView recyclerView2 = this.mRecyclerView;
                    int iM2820y = m2820y(i13, recyclerView2.mRecycler, recyclerView2.mState);
                    if (this.mOrientation != 1) {
                        if (iM2821z == i11 && iM2820y == i12) {
                            break;
                        }
                        i13++;
                    } else {
                        if (iM2821z == i12 && iM2820y == i11) {
                            break;
                        }
                        i13++;
                    }
                }
                if (i13 > -1) {
                    scrollToPositionWithOffset(i13, 0);
                    return true;
                }
            }
            return false;
        }
        int i14 = 0;
        while (true) {
            if (i14 >= getChildCount()) {
                childAt = null;
                break;
            }
            View childAt2 = getChildAt(i14);
            Objects.requireNonNull(childAt2);
            if (childAt2.isAccessibilityFocused()) {
                childAt = getChildAt(i14);
                break;
            }
            i14++;
        }
        if (childAt == null || bundle == null) {
            return false;
        }
        int i15 = bundle.getInt("android.view.accessibility.action.ARGUMENT_DIRECTION_INT", -1);
        if (!f3444l.contains(Integer.valueOf(i15)) || (childViewHolder = this.mRecyclerView.getChildViewHolder(childAt)) == null) {
            return false;
        }
        int absoluteAdapterPosition = childViewHolder.getAbsoluteAdapterPosition();
        int iM2816u = m2816u(absoluteAdapterPosition);
        int iM2815t = m2815t(absoluteAdapterPosition);
        if (iM2816u >= 0 && iM2815t >= 0) {
            if (!m2817v(absoluteAdapterPosition).contains(Integer.valueOf(this.f3454j)) || !m2818w(m2815t(absoluteAdapterPosition), absoluteAdapterPosition).contains(Integer.valueOf(this.f3455k))) {
                this.f3454j = iM2816u;
                this.f3455k = iM2815t;
            }
            int i16 = this.f3454j;
            if (i16 == -1) {
                i16 = iM2816u;
            }
            int i17 = this.f3455k;
            if (i17 != -1) {
                iM2815t = i17;
            }
            if (i15 == 17) {
                iIntValue = absoluteAdapterPosition - 1;
                while (true) {
                    if (iIntValue >= 0) {
                        int iM2816u2 = m2816u(iIntValue);
                        int iM2815t2 = m2815t(iIntValue);
                        if (iM2816u2 >= 0 && iM2815t2 >= 0) {
                            if (this.mOrientation != 1) {
                                if (m2817v(iIntValue).contains(Integer.valueOf(i16)) && iM2815t2 < iM2815t) {
                                    this.f3455k = iM2815t2;
                                    break;
                                }
                                iIntValue--;
                            } else {
                                if ((iM2816u2 == i16 && iM2815t2 < iM2815t) || iM2816u2 < i16) {
                                    this.f3454j = iM2816u2;
                                    this.f3455k = iM2815t2;
                                    break;
                                }
                                iIntValue--;
                            }
                        }
                    }
                    iIntValue = -1;
                    break;
                }
            }
            if (i15 == 33) {
                iIntValue = absoluteAdapterPosition - 1;
                while (true) {
                    if (iIntValue >= 0) {
                        int iM2816u3 = m2816u(iIntValue);
                        int iM2815t3 = m2815t(iIntValue);
                        if (iM2816u3 >= 0 && iM2815t3 >= 0) {
                            if (this.mOrientation != 1) {
                                if (iM2816u3 < i16 && iM2815t3 == iM2815t) {
                                    this.f3454j = ((Integer) Collections.max(m2817v(iIntValue))).intValue();
                                    break;
                                }
                                iIntValue--;
                            } else {
                                if (iM2816u3 < i16 && m2818w(m2815t(iIntValue), iIntValue).contains(Integer.valueOf(iM2815t))) {
                                    this.f3454j = iM2816u3;
                                    break;
                                }
                                iIntValue--;
                            }
                        }
                    }
                    iIntValue = -1;
                    break;
                }
            }
            if (i15 == 66) {
                iIntValue = absoluteAdapterPosition + 1;
                while (true) {
                    if (iIntValue < getItemCount()) {
                        int iM2816u4 = m2816u(iIntValue);
                        int iM2815t4 = m2815t(iIntValue);
                        if (iM2816u4 >= 0 && iM2815t4 >= 0) {
                            if (this.mOrientation != 1) {
                                if (iM2815t4 > iM2815t && m2817v(iIntValue).contains(Integer.valueOf(i16))) {
                                    this.f3455k = iM2815t4;
                                    break;
                                }
                                iIntValue++;
                            } else {
                                if ((iM2816u4 == i16 && iM2815t4 > iM2815t) || iM2816u4 > i16) {
                                    this.f3454j = iM2816u4;
                                    this.f3455k = iM2815t4;
                                    break;
                                }
                                iIntValue++;
                            }
                        }
                    }
                    iIntValue = -1;
                    break;
                }
            }
            if (i15 == 130) {
                iIntValue = absoluteAdapterPosition + 1;
                while (true) {
                    if (iIntValue < getItemCount()) {
                        int iM2816u5 = m2816u(iIntValue);
                        int iM2815t5 = m2815t(iIntValue);
                        if (iM2816u5 >= 0 && iM2815t5 >= 0) {
                            if (this.mOrientation != 1) {
                                if (iM2816u5 > i16 && iM2815t5 == iM2815t) {
                                    this.f3454j = m2816u(iIntValue);
                                    break;
                                }
                                iIntValue++;
                            } else {
                                if (iM2816u5 > i16 && (iM2815t5 == iM2815t || m2818w(m2815t(iIntValue), iIntValue).contains(Integer.valueOf(iM2815t)))) {
                                    this.f3454j = iM2816u5;
                                    break;
                                }
                                iIntValue++;
                            }
                        }
                    }
                    iIntValue = -1;
                    break;
                }
            }
            return false;
            if (iIntValue == -1 && (i10 = this.mOrientation) == 0) {
                if (i15 != 17) {
                    if (i15 == 66) {
                        if (iM2816u < 0 || i10 == 1) {
                            iIntValue = -1;
                            break loop2;
                        }
                        TreeMap treeMap = new TreeMap();
                        int i18 = 0;
                        loop5: while (true) {
                            if (i18 < getItemCount()) {
                                Iterator it = m2817v(i18).iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Integer num = (Integer) it.next();
                                        if (num.intValue() >= 0) {
                                            if (!treeMap.containsKey(num)) {
                                                treeMap.put(num, Integer.valueOf(i18));
                                            }
                                        }
                                    } else {
                                        i18++;
                                    }
                                }
                            } else {
                                Iterator it2 = treeMap.keySet().iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        Integer num2 = (Integer) it2.next();
                                        int iIntValue2 = num2.intValue();
                                        if (iIntValue2 > iM2816u) {
                                            iIntValue = ((Integer) treeMap.get(num2)).intValue();
                                            this.f3454j = iIntValue2;
                                            this.f3455k = 0;
                                            break;
                                        }
                                    }
                                }
                            }
                            iIntValue = -1;
                            break loop2;
                        }
                    }
                } else {
                    if (iM2816u < 0 || i10 == 1) {
                        iIntValue = -1;
                        break loop2;
                    }
                    TreeMap treeMap2 = new TreeMap(Collections.reverseOrder());
                    int i19 = 0;
                    loop2: while (true) {
                        if (i19 < getItemCount()) {
                            Iterator it3 = m2817v(i19).iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    Integer num3 = (Integer) it3.next();
                                    if (num3.intValue() >= 0) {
                                        treeMap2.put(num3, Integer.valueOf(i19));
                                    }
                                } else {
                                    i19++;
                                }
                            }
                        } else {
                            Iterator it4 = treeMap2.keySet().iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    Integer num4 = (Integer) it4.next();
                                    int iIntValue3 = num4.intValue();
                                    if (iIntValue3 < iM2816u) {
                                        iIntValue = ((Integer) treeMap2.get(num4)).intValue();
                                        this.f3454j = iIntValue3;
                                        this.f3455k = m2815t(iIntValue);
                                        break;
                                    }
                                }
                            }
                        }
                        iIntValue = -1;
                        break loop2;
                    }
                }
            }
            if (iIntValue != -1) {
                scrollToPosition(iIntValue);
                this.f3453i = iIntValue;
                return true;
            }
        }
        return false;
    }

    public final void m2813r(int i6) {
        int i10;
        int[] iArr = this.f3447c;
        int i11 = this.f3446b;
        if (iArr == null || iArr.length != i11 + 1 || iArr[iArr.length - 1] != i6) {
            iArr = new int[i11 + 1];
        }
        int i12 = 0;
        iArr[0] = 0;
        int i13 = i6 / i11;
        int i14 = i6 % i11;
        int i15 = 0;
        for (int i16 = 1; i16 <= i11; i16++) {
            i12 += i14;
            if (i12 <= 0 || i11 - i12 >= i14) {
                i10 = i13;
            } else {
                i10 = i13 + 1;
                i12 -= i11;
            }
            i15 += i10;
            iArr[i16] = i15;
        }
        this.f3447c = iArr;
    }

    public final void m2814s() {
        View[] viewArr = this.f3448d;
        if (viewArr == null || viewArr.length != this.f3446b) {
            this.f3448d = new View[this.f3446b];
        }
    }

    @Override
    public final int scrollHorizontallyBy(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        m2812D();
        m2814s();
        return super.scrollHorizontallyBy(i6, c1140e1, c1162l1);
    }

    @Override
    public final int scrollVerticallyBy(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        m2812D();
        m2814s();
        return super.scrollVerticallyBy(i6, c1140e1, c1162l1);
    }

    @Override
    public final void setMeasuredDimension(Rect rect, int i6, int i10) {
        int iChooseSize;
        int iChooseSize2;
        if (this.f3447c == null) {
            super.setMeasuredDimension(rect, i6, i10);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            iChooseSize2 = AbstractC1197x0.chooseSize(i10, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.f3447c;
            iChooseSize = AbstractC1197x0.chooseSize(i6, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            iChooseSize = AbstractC1197x0.chooseSize(i6, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.f3447c;
            iChooseSize2 = AbstractC1197x0.chooseSize(i10, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    @Override
    public final void setStackFromEnd(boolean z7) {
        if (z7) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override
    public final boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f3445a;
    }

    public final int m2815t(int i6) {
        if (this.mOrientation == 0) {
            RecyclerView recyclerView = this.mRecyclerView;
            return m2820y(i6, recyclerView.mRecycler, recyclerView.mState);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        return m2821z(i6, recyclerView2.mRecycler, recyclerView2.mState);
    }

    public final int m2816u(int i6) {
        if (this.mOrientation == 1) {
            RecyclerView recyclerView = this.mRecyclerView;
            return m2820y(i6, recyclerView.mRecycler, recyclerView.mState);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        return m2821z(i6, recyclerView2.mRecycler, recyclerView2.mState);
    }

    public final HashSet m2817v(int i6) {
        return m2818w(m2816u(i6), i6);
    }

    public final HashSet m2818w(int i6, int i10) {
        HashSet hashSet = new HashSet();
        RecyclerView recyclerView = this.mRecyclerView;
        int iM2809A = m2809A(i10, recyclerView.mRecycler, recyclerView.mState);
        for (int i11 = i6; i11 < i6 + iM2809A; i11++) {
            hashSet.add(Integer.valueOf(i11));
        }
        return hashSet;
    }

    public final int m2819x(int i6, int i10) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.f3447c;
            return iArr[i10 + i6] - iArr[i6];
        }
        int[] iArr2 = this.f3447c;
        int i11 = this.f3446b;
        return iArr2[i11 - i6] - iArr2[(i11 - i6) - i10];
    }

    public final int m2820y(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        if (!c1162l1.f3621g) {
            return this.f3451g.m375h(i6, this.f3446b);
        }
        int iM2926b = c1140e1.m2926b(i6);
        if (iM2926b != -1) {
            return this.f3451g.m375h(iM2926b, this.f3446b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i6);
        return 0;
    }

    public final int m2821z(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        if (!c1162l1.f3621g) {
            return this.f3451g.mo376i(i6, this.f3446b);
        }
        int i10 = this.f3450f.get(i6, -1);
        if (i10 != -1) {
            return i10;
        }
        int iM2926b = c1140e1.m2926b(i6);
        if (iM2926b != -1) {
            return this.f3451g.mo376i(iM2926b, this.f3446b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i6);
        return 0;
    }

    @Override
    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            LayoutParams layoutParams2 = new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            layoutParams2.f3456e = -1;
            layoutParams2.f3457f = 0;
            return layoutParams2;
        }
        LayoutParams layoutParams3 = new LayoutParams(layoutParams);
        layoutParams3.f3456e = -1;
        layoutParams3.f3457f = 0;
        return layoutParams3;
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        public int f3456e;

        public int f3457f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3456e = -1;
            this.f3457f = 0;
        }

        public LayoutParams(int i6, int i10) {
            super(i6, i10);
            this.f3456e = -1;
            this.f3457f = 0;
        }
    }

    public GridLayoutManager(int i6) {
        super(1);
        this.f3445a = false;
        this.f3446b = -1;
        this.f3449e = new SparseIntArray();
        this.f3450f = new SparseIntArray();
        this.f3451g = new C1187u();
        this.f3452h = new Rect();
        this.f3453i = -1;
        this.f3454j = -1;
        this.f3455k = -1;
        m2811C(i6);
    }

    public GridLayoutManager() {
        super(1);
        this.f3445a = false;
        this.f3446b = -1;
        this.f3449e = new SparseIntArray();
        this.f3450f = new SparseIntArray();
        this.f3451g = new C1187u();
        this.f3452h = new Rect();
        this.f3453i = -1;
        this.f3454j = -1;
        this.f3455k = -1;
        m2811C(7);
    }
}

package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import p055ea.AbstractC2460q;
import p148o0.C3232g;
import p148o0.C3233h;
import p187r4.AbstractC3612b;

public class StaggeredGridLayoutManager extends AbstractC1197x0 implements InterfaceC1156j1 {

    public final int f3470a;

    public final C1201y1[] f3471b;

    public final AbstractC1135d0 f3472c;

    public final AbstractC1135d0 f3473d;

    public final int f3474e;

    public int f3475f;

    public final C1190v f3476g;

    public boolean f3477h;

    public final BitSet f3479j;

    public final C1195w1 f3482m;

    public final int f3483n;

    public boolean f3484o;

    public boolean f3485p;

    public SavedState f3486q;

    public int f3487r;

    public final Rect f3488s;

    public final C1189u1 f3489t;

    public boolean f3490u;

    public final boolean f3491v;

    public int[] f3492w;

    public final RunnableC1163m f3493x;

    public boolean f3478i = false;

    public int f3480k = -1;

    public int f3481l = Integer.MIN_VALUE;

    public static class LayoutParams extends RecyclerView.LayoutParams {

        public C1201y1 f3494e;

        public boolean f3495f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1198x1();

        public int f3500a;

        public int f3501b;

        public int f3502c;

        public int[] f3503d;

        public int f3504e;

        public int[] f3505f;

        public ArrayList f3506g;

        public boolean f3507h;

        public boolean f3508i;

        public boolean f3509j;

        @Override
        public final int describeContents() {
            return 0;
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f3500a);
            parcel.writeInt(this.f3501b);
            parcel.writeInt(this.f3502c);
            if (this.f3502c > 0) {
                parcel.writeIntArray(this.f3503d);
            }
            parcel.writeInt(this.f3504e);
            if (this.f3504e > 0) {
                parcel.writeIntArray(this.f3505f);
            }
            parcel.writeInt(this.f3507h ? 1 : 0);
            parcel.writeInt(this.f3508i ? 1 : 0);
            parcel.writeInt(this.f3509j ? 1 : 0);
            parcel.writeList(this.f3506g);
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i6, int i10) {
        this.f3470a = -1;
        this.f3477h = false;
        C1195w1 c1195w1 = new C1195w1();
        this.f3482m = c1195w1;
        this.f3483n = 2;
        this.f3488s = new Rect();
        this.f3489t = new C1189u1(this);
        this.f3490u = false;
        this.f3491v = true;
        this.f3493x = new RunnableC1163m(1, this);
        RecyclerView$LayoutManager$Properties properties = AbstractC1197x0.getProperties(context, attributeSet, i6, i10);
        int i11 = properties.f3461a;
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i11 != this.f3474e) {
            this.f3474e = i11;
            AbstractC1135d0 abstractC1135d0 = this.f3472c;
            this.f3472c = this.f3473d;
            this.f3473d = abstractC1135d0;
            requestLayout();
        }
        int i12 = properties.f3462b;
        assertNotInLayoutOrScroll(null);
        if (i12 != this.f3470a) {
            c1195w1.m3000b();
            requestLayout();
            this.f3470a = i12;
            this.f3479j = new BitSet(this.f3470a);
            this.f3471b = new C1201y1[this.f3470a];
            for (int i13 = 0; i13 < this.f3470a; i13++) {
                this.f3471b[i13] = new C1201y1(this, i13);
            }
            requestLayout();
        }
        boolean z7 = properties.f3463c;
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.f3486q;
        if (savedState != null && savedState.f3507h != z7) {
            savedState.f3507h = z7;
        }
        this.f3477h = z7;
        requestLayout();
        C1190v c1190v = new C1190v();
        c1190v.f3709a = true;
        c1190v.f3714f = 0;
        c1190v.f3715g = 0;
        this.f3476g = c1190v;
        this.f3472c = AbstractC1135d0.m2921a(this, this.f3474e);
        this.f3473d = AbstractC1135d0.m2921a(this, 1 - this.f3474e);
    }

    public static int m2837F(int i6, int i10, int i11) {
        if (i10 == 0 && i11 == 0) {
            return i6;
        }
        int mode = View.MeasureSpec.getMode(i6);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i6) - i10) - i11), mode) : i6;
    }

    public final void m2838A() {
        if (this.f3474e == 1 || !isLayoutRTL()) {
            this.f3478i = this.f3477h;
        } else {
            this.f3478i = !this.f3477h;
        }
    }

    public final void m2839B(int i6) {
        C1190v c1190v = this.f3476g;
        c1190v.f3713e = i6;
        c1190v.f3712d = this.f3478i != (i6 == -1) ? -1 : 1;
    }

    public final void m2840C(int i6, int i10) {
        for (int i11 = 0; i11 < this.f3470a; i11++) {
            if (!this.f3471b[i11].f3742a.isEmpty()) {
                m2842E(this.f3471b[i11], i6, i10);
            }
        }
    }

    public final void m2841D(int i6, C1162l1 c1162l1) {
        int iMo2893l;
        int iMo2893l2;
        int i10;
        C1190v c1190v = this.f3476g;
        boolean z7 = false;
        c1190v.f3710b = 0;
        c1190v.f3711c = i6;
        if (isSmoothScrolling() && (i10 = c1162l1.f3615a) != -1) {
            if (this.f3478i == (i10 < i6)) {
                iMo2893l = this.f3472c.mo2893l();
            } else {
                iMo2893l2 = this.f3472c.mo2893l();
                iMo2893l = 0;
            }
            if (getClipToPadding()) {
                c1190v.f3714f = this.f3472c.mo2892k() - iMo2893l2;
                c1190v.f3715g = this.f3472c.mo2888g() + iMo2893l;
            } else {
                c1190v.f3715g = this.f3472c.mo2887f() + iMo2893l;
                c1190v.f3714f = -iMo2893l2;
            }
            c1190v.f3716h = false;
            c1190v.f3709a = true;
            if (this.f3472c.mo2890i() == 0 && this.f3472c.mo2887f() == 0) {
                z7 = true;
            }
            c1190v.f3717i = z7;
        }
        iMo2893l = 0;
        iMo2893l2 = 0;
        if (getClipToPadding()) {
            c1190v.f3714f = this.f3472c.mo2892k() - iMo2893l2;
            c1190v.f3715g = this.f3472c.mo2888g() + iMo2893l;
        } else {
            c1190v.f3715g = this.f3472c.mo2887f() + iMo2893l;
            c1190v.f3714f = -iMo2893l2;
        }
        c1190v.f3716h = false;
        c1190v.f3709a = true;
        if (this.f3472c.mo2890i() == 0) {
            z7 = true;
        }
        c1190v.f3717i = z7;
    }

    public final void m2842E(C1201y1 c1201y1, int i6, int i10) {
        int i11 = c1201y1.f3745d;
        int i12 = c1201y1.f3746e;
        if (i6 == -1) {
            int i13 = c1201y1.f3743b;
            if (i13 == Integer.MIN_VALUE) {
                c1201y1.m3015c();
                i13 = c1201y1.f3743b;
            }
            if (i13 + i11 <= i10) {
                this.f3479j.set(i12, false);
                return;
            }
            return;
        }
        int i14 = c1201y1.f3744c;
        if (i14 == Integer.MIN_VALUE) {
            c1201y1.m3014b();
            i14 = c1201y1.f3744c;
        }
        if (i14 - i11 >= i10) {
            this.f3479j.set(i12, false);
        }
    }

    @Override
    public final void assertNotInLayoutOrScroll(String str) {
        if (this.f3486q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override
    public final boolean canScrollHorizontally() {
        return this.f3474e == 0;
    }

    @Override
    public final boolean canScrollVertically() {
        return this.f3474e == 1;
    }

    @Override
    public final boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override
    public final void collectAdjacentPrefetchPositions(int i6, int i10, C1162l1 c1162l1, InterfaceC1194w0 interfaceC1194w0) {
        C1190v c1190v;
        int iM3020h;
        int iM3022j;
        if (this.f3474e != 0) {
            i6 = i10;
        }
        if (getChildCount() == 0 || i6 == 0) {
            return;
        }
        m2862w(i6, c1162l1);
        int[] iArr = this.f3492w;
        if (iArr == null || iArr.length < this.f3470a) {
            this.f3492w = new int[this.f3470a];
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = this.f3470a;
            c1190v = this.f3476g;
            if (i11 >= i13) {
                break;
            }
            if (c1190v.f3712d == -1) {
                iM3020h = c1190v.f3714f;
                iM3022j = this.f3471b[i11].m3022j(iM3020h);
            } else {
                iM3020h = this.f3471b[i11].m3020h(c1190v.f3715g);
                iM3022j = c1190v.f3715g;
            }
            int i14 = iM3020h - iM3022j;
            if (i14 >= 0) {
                this.f3492w[i12] = i14;
                i12++;
            }
            i11++;
        }
        Arrays.sort(this.f3492w, 0, i12);
        for (int i15 = 0; i15 < i12; i15++) {
            int i16 = c1190v.f3711c;
            if (i16 < 0 || i16 >= c1162l1.m2970b()) {
                return;
            }
            ((C1178r) interfaceC1194w0).m2986a(c1190v.f3711c, this.f3492w[i15]);
            c1190v.f3711c += c1190v.f3712d;
        }
    }

    @Override
    public final int computeHorizontalScrollExtent(C1162l1 c1162l1) {
        return m2845f(c1162l1);
    }

    @Override
    public final int computeHorizontalScrollOffset(C1162l1 c1162l1) {
        return m2846g(c1162l1);
    }

    @Override
    public final int computeHorizontalScrollRange(C1162l1 c1162l1) {
        return m2847h(c1162l1);
    }

    @Override
    public final PointF computeScrollVectorForPosition(int i6) {
        int iM2843d = m2843d(i6);
        PointF pointF = new PointF();
        if (iM2843d == 0) {
            return null;
        }
        if (this.f3474e == 0) {
            pointF.x = iM2843d;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iM2843d;
        }
        return pointF;
    }

    @Override
    public final int computeVerticalScrollExtent(C1162l1 c1162l1) {
        return m2845f(c1162l1);
    }

    @Override
    public final int computeVerticalScrollOffset(C1162l1 c1162l1) {
        return m2846g(c1162l1);
    }

    @Override
    public final int computeVerticalScrollRange(C1162l1 c1162l1) {
        return m2847h(c1162l1);
    }

    public final int m2843d(int i6) {
        if (getChildCount() == 0) {
            return this.f3478i ? 1 : -1;
        }
        return (i6 < m2853n()) != this.f3478i ? -1 : 1;
    }

    public final boolean m2844e() {
        int iM2853n;
        int iM2854o;
        if (getChildCount() == 0 || this.f3483n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f3478i) {
            iM2853n = m2854o();
            iM2854o = m2853n();
        } else {
            iM2853n = m2853n();
            iM2854o = m2854o();
        }
        C1195w1 c1195w1 = this.f3482m;
        if (iM2853n == 0 && m2858s() != null) {
            c1195w1.m3000b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.f3490u) {
            return false;
        }
        int i6 = this.f3478i ? -1 : 1;
        int i10 = iM2854o + 1;
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3003e = c1195w1.m3003e(iM2853n, i10, i6);
        if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3003e == null) {
            this.f3490u = false;
            c1195w1.m3002d(i10);
            return false;
        }
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3003e2 = c1195w1.m3003e(iM2853n, staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3003e.f3496a, i6 * (-1));
        if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3003e2 == null) {
            c1195w1.m3002d(staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3003e.f3496a);
        } else {
            c1195w1.m3002d(staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3003e2.f3496a + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    public final int m2845f(C1162l1 c1162l1) {
        if (getChildCount() == 0) {
            return 0;
        }
        AbstractC1135d0 abstractC1135d0 = this.f3472c;
        boolean z7 = !this.f3491v;
        return AbstractC3612b.m7264f(c1162l1, abstractC1135d0, m2850k(z7), m2849j(z7), this, this.f3491v);
    }

    public final int m2846g(C1162l1 c1162l1) {
        if (getChildCount() == 0) {
            return 0;
        }
        AbstractC1135d0 abstractC1135d0 = this.f3472c;
        boolean z7 = !this.f3491v;
        return AbstractC3612b.m7265g(c1162l1, abstractC1135d0, m2850k(z7), m2849j(z7), this, this.f3491v, this.f3478i);
    }

    @Override
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.f3474e == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override
    public final RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override
    public final int getColumnCountForAccessibility(C1140e1 c1140e1, C1162l1 c1162l1) {
        if (this.f3474e == 1) {
            return Math.min(this.f3470a, c1162l1.m2970b());
        }
        return -1;
    }

    @Override
    public final int getRowCountForAccessibility(C1140e1 c1140e1, C1162l1 c1162l1) {
        if (this.f3474e == 0) {
            return Math.min(this.f3470a, c1162l1.m2970b());
        }
        return -1;
    }

    public final int m2847h(C1162l1 c1162l1) {
        if (getChildCount() == 0) {
            return 0;
        }
        AbstractC1135d0 abstractC1135d0 = this.f3472c;
        boolean z7 = !this.f3491v;
        return AbstractC3612b.m7266h(c1162l1, abstractC1135d0, m2850k(z7), m2849j(z7), this, this.f3491v);
    }

    public final int m2848i(C1140e1 c1140e1, C1190v c1190v, C1162l1 c1162l1) {
        C1201y1 c1201y1;
        int i6;
        int iMo2884c;
        int i10;
        boolean z7;
        ?? r10;
        int i11;
        int iMo2892k;
        int iMo2884c2;
        int iMo2884c3;
        View view;
        LayoutParams layoutParams;
        int i12;
        ?? r11;
        int i13;
        boolean z10;
        boolean z11;
        int i14;
        int i15;
        int i16;
        C1140e1 c1140e2 = c1140e1;
        char c5 = 0;
        int i17 = 1;
        this.f3479j.set(0, this.f3470a, true);
        C1190v c1190v2 = this.f3476g;
        int i18 = c1190v2.f3717i ? c1190v.f3713e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : c1190v.f3713e == 1 ? c1190v.f3715g + c1190v.f3710b : c1190v.f3714f - c1190v.f3710b;
        m2840C(c1190v.f3713e, i18);
        int iMo2888g = this.f3478i ? this.f3472c.mo2888g() : this.f3472c.mo2892k();
        boolean z12 = false;
        while (true) {
            int i19 = c1190v.f3711c;
            if (!(i19 >= 0 && i19 < c1162l1.m2970b()) || (!c1190v2.f3717i && this.f3479j.isEmpty())) {
                break;
            }
            View view2 = c1140e2.m2935l(c1190v.f3711c, Long.MAX_VALUE).itemView;
            c1190v.f3711c += c1190v.f3712d;
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            int layoutPosition = layoutParams2.f3465a.getLayoutPosition();
            C1195w1 c1195w1 = this.f3482m;
            int[] iArr = c1195w1.f3724a;
            int i20 = (iArr == null || layoutPosition >= iArr.length) ? -1 : iArr[layoutPosition];
            boolean z13 = i20 == -1;
            if (z13) {
                if (layoutParams2.f3495f) {
                    c1201y1 = this.f3471b[c5];
                } else {
                    if (m2861v(c1190v.f3713e)) {
                        i15 = this.f3470a - i17;
                        i14 = -1;
                        i16 = -1;
                    } else {
                        i14 = this.f3470a;
                        i15 = 0;
                        i16 = 1;
                    }
                    C1201y1 c1201y2 = null;
                    if (c1190v.f3713e == i17) {
                        int iMo2892k2 = this.f3472c.mo2892k();
                        int i21 = Integer.MAX_VALUE;
                        while (i15 != i14) {
                            C1201y1 c1201y3 = this.f3471b[i15];
                            int iM3020h = c1201y3.m3020h(iMo2892k2);
                            if (iM3020h < i21) {
                                i21 = iM3020h;
                                c1201y2 = c1201y3;
                            }
                            i15 += i16;
                        }
                    } else {
                        int iMo2888g2 = this.f3472c.mo2888g();
                        int i22 = Integer.MIN_VALUE;
                        while (i15 != i14) {
                            C1201y1 c1201y4 = this.f3471b[i15];
                            int iM3022j = c1201y4.m3022j(iMo2888g2);
                            if (iM3022j > i22) {
                                c1201y2 = c1201y4;
                                i22 = iM3022j;
                            }
                            i15 += i16;
                        }
                    }
                    c1201y1 = c1201y2;
                }
                c1195w1.m3001c(layoutPosition);
                c1195w1.f3724a[layoutPosition] = c1201y1.f3746e;
            } else {
                c1201y1 = this.f3471b[i20];
            }
            C1201y1 c1201y5 = c1201y1;
            layoutParams2.f3494e = c1201y5;
            if (c1190v.f3713e == 1) {
                addView(view2);
            } else {
                addView(view2, 0);
            }
            if (!layoutParams2.f3495f) {
                i6 = i18;
                if (this.f3474e == 1) {
                    m2859t(view2, AbstractC1197x0.getChildMeasureSpec(this.f3475f, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams2).width, false), AbstractC1197x0.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams2).height, true));
                } else {
                    m2859t(view2, AbstractC1197x0.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams2).width, true), AbstractC1197x0.getChildMeasureSpec(this.f3475f, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams2).height, false));
                }
            } else if (this.f3474e == 1) {
                i6 = i18;
                m2859t(view2, this.f3487r, AbstractC1197x0.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams2).height, true));
            } else {
                i6 = i18;
                m2859t(view2, AbstractC1197x0.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams2).width, true), this.f3487r);
            }
            if (c1190v.f3713e == 1) {
                int iM2855p = layoutParams2.f3495f ? m2855p(iMo2888g) : c1201y5.m3020h(iMo2888g);
                int iMo2884c4 = this.f3472c.mo2884c(view2) + iM2855p;
                if (z13 && layoutParams2.f3495f) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3498c = new int[this.f3470a];
                    for (int i23 = 0; i23 < this.f3470a; i23++) {
                        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3498c[i23] = iM2855p - this.f3471b[i23].m3020h(iM2855p);
                    }
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3497b = -1;
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f3496a = layoutPosition;
                    c1195w1.m2999a(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                }
                i10 = iMo2884c4;
                iMo2884c = iM2855p;
            } else {
                int iM2856q = layoutParams2.f3495f ? m2856q(iMo2888g) : c1201y5.m3022j(iMo2888g);
                iMo2884c = iM2856q - this.f3472c.mo2884c(view2);
                if (z13 && layoutParams2.f3495f) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f3498c = new int[this.f3470a];
                    for (int i24 = 0; i24 < this.f3470a; i24++) {
                        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f3498c[i24] = this.f3471b[i24].m3022j(iM2856q) - iM2856q;
                    }
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f3497b = 1;
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f3496a = layoutPosition;
                    c1195w1.m2999a(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2);
                }
                i10 = iM2856q;
            }
            if (layoutParams2.f3495f && c1190v.f3712d == -1) {
                if (z13) {
                    z7 = true;
                    this.f3490u = true;
                } else {
                    if (c1190v.f3713e == 1) {
                        int iM3020h2 = this.f3471b[0].m3020h(Integer.MIN_VALUE);
                        int i25 = 1;
                        while (true) {
                            if (i25 >= this.f3470a) {
                                z10 = true;
                                z11 = true;
                            } else if (this.f3471b[i25].m3020h(Integer.MIN_VALUE) != iM3020h2) {
                                z10 = true;
                                z11 = false;
                            } else {
                                i25++;
                            }
                        }
                    } else {
                        int iM3022j2 = this.f3471b[0].m3022j(Integer.MIN_VALUE);
                        int i26 = 1;
                        while (true) {
                            if (i26 >= this.f3470a) {
                                z10 = true;
                                z11 = true;
                            } else if (this.f3471b[i26].m3022j(Integer.MIN_VALUE) != iM3022j2) {
                                z10 = true;
                                z11 = false;
                            } else {
                                i26++;
                            }
                        }
                    }
                    r10 = z10;
                    if (!z11) {
                        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f = c1195w1.m3004f(layoutPosition);
                        if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f != null) {
                            staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f.f3499d = z10;
                        }
                        this.f3490u = z10;
                        r10 = z10;
                    }
                }
                if (c1190v.f3713e == r10) {
                    if (layoutParams2.f3495f) {
                        r11 = this.f3470a - r10;
                        while (i13 >= 0) {
                            i13 = r11;
                            this.f3471b[i13].m3013a(view2);
                            i13--;
                        }
                        i13 = r11;
                    } else {
                        layoutParams2.f3494e.m3013a(view2);
                    }
                } else if (layoutParams2.f3495f) {
                    for (i11 = this.f3470a - 1; i11 >= 0; i11--) {
                        this.f3471b[i11].m3025m(view2);
                    }
                } else {
                    layoutParams2.f3494e.m3025m(view2);
                }
                if (isLayoutRTL() || this.f3474e != 1) {
                    if (layoutParams2.f3495f) {
                        iMo2892k = this.f3473d.mo2892k();
                    } else {
                        iMo2892k = (c1201y5.f3746e * this.f3475f) + this.f3473d.mo2892k();
                    }
                    iMo2884c2 = iMo2892k;
                    iMo2884c3 = this.f3473d.mo2884c(view2) + iMo2892k;
                } else {
                    int iMo2888g3 = layoutParams2.f3495f ? this.f3473d.mo2888g() : this.f3473d.mo2888g() - (((this.f3470a - 1) - c1201y5.f3746e) * this.f3475f);
                    iMo2884c3 = iMo2888g3;
                    iMo2884c2 = iMo2888g3 - this.f3473d.mo2884c(view2);
                }
                if (this.f3474e == 1) {
                    view = view2;
                    layoutDecoratedWithMargins(view2, iMo2884c2, iMo2884c, iMo2884c3, i10);
                    layoutParams = layoutParams2;
                } else {
                    view = view2;
                    int i27 = i10;
                    layoutParams = layoutParams2;
                    layoutDecoratedWithMargins(view, iMo2884c, iMo2884c2, i27, iMo2884c3);
                }
                if (layoutParams.f3495f) {
                    i12 = i6;
                    m2840C(c1190v2.f3713e, i12);
                } else {
                    i12 = i6;
                    m2842E(c1201y5, c1190v2.f3713e, i12);
                }
                m2863x(c1140e1, c1190v2);
                if (!c1190v2.f3716h && view.hasFocusable()) {
                    if (layoutParams.f3495f) {
                        this.f3479j.clear();
                    } else {
                        this.f3479j.set(c1201y5.f3746e, false);
                    }
                }
                c1140e2 = c1140e1;
                i18 = i12;
                z12 = true;
                c5 = 0;
                i17 = 1;
            } else {
                z7 = true;
            }
            r10 = z7;
            if (c1190v.f3713e == r10) {
                if (layoutParams2.f3495f) {
                    r11 = this.f3470a - r10;
                    while (i13 >= 0) {
                        i13 = r11;
                        this.f3471b[i13].m3013a(view2);
                        i13--;
                    }
                    i13 = r11;
                } else {
                    layoutParams2.f3494e.m3013a(view2);
                }
            } else if (layoutParams2.f3495f) {
                while (i11 >= 0) {
                    this.f3471b[i11].m3025m(view2);
                }
            } else {
                layoutParams2.f3494e.m3025m(view2);
            }
            if (isLayoutRTL()) {
                if (layoutParams2.f3495f) {
                    iMo2892k = this.f3473d.mo2892k();
                } else {
                    iMo2892k = (c1201y5.f3746e * this.f3475f) + this.f3473d.mo2892k();
                }
                iMo2884c2 = iMo2892k;
                iMo2884c3 = this.f3473d.mo2884c(view2) + iMo2892k;
            } else {
                if (layoutParams2.f3495f) {
                    iMo2892k = this.f3473d.mo2892k();
                } else {
                    iMo2892k = (c1201y5.f3746e * this.f3475f) + this.f3473d.mo2892k();
                }
                iMo2884c2 = iMo2892k;
                iMo2884c3 = this.f3473d.mo2884c(view2) + iMo2892k;
            }
            if (this.f3474e == 1) {
                view = view2;
                layoutDecoratedWithMargins(view2, iMo2884c2, iMo2884c, iMo2884c3, i10);
                layoutParams = layoutParams2;
            } else {
                view = view2;
                int i28 = i10;
                layoutParams = layoutParams2;
                layoutDecoratedWithMargins(view, iMo2884c, iMo2884c2, i28, iMo2884c3);
            }
            if (layoutParams.f3495f) {
                i12 = i6;
                m2840C(c1190v2.f3713e, i12);
            } else {
                i12 = i6;
                m2842E(c1201y5, c1190v2.f3713e, i12);
            }
            m2863x(c1140e1, c1190v2);
            if (!c1190v2.f3716h) {
            }
            c1140e2 = c1140e1;
            i18 = i12;
            z12 = true;
            c5 = 0;
            i17 = 1;
        }
        C1140e1 c1140e3 = c1140e2;
        if (!z12) {
            m2863x(c1140e3, c1190v2);
        }
        int iMo2892k3 = c1190v2.f3713e == -1 ? this.f3472c.mo2892k() - m2856q(this.f3472c.mo2892k()) : m2855p(this.f3472c.mo2888g()) - this.f3472c.mo2888g();
        if (iMo2892k3 > 0) {
            return Math.min(c1190v.f3710b, iMo2892k3);
        }
        return 0;
    }

    @Override
    public final boolean isAutoMeasureEnabled() {
        return this.f3483n != 0;
    }

    public final boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    @Override
    public final boolean isLayoutReversed() {
        return this.f3477h;
    }

    public final View m2849j(boolean z7) {
        int iMo2892k = this.f3472c.mo2892k();
        int iMo2888g = this.f3472c.mo2888g();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int iMo2886e = this.f3472c.mo2886e(childAt);
            int iMo2883b = this.f3472c.mo2883b(childAt);
            if (iMo2883b > iMo2892k && iMo2886e < iMo2888g) {
                if (iMo2883b <= iMo2888g || !z7) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final View m2850k(boolean z7) {
        int iMo2892k = this.f3472c.mo2892k();
        int iMo2888g = this.f3472c.mo2888g();
        int childCount = getChildCount();
        View view = null;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int iMo2886e = this.f3472c.mo2886e(childAt);
            if (this.f3472c.mo2883b(childAt) > iMo2892k && iMo2886e < iMo2888g) {
                if (iMo2886e >= iMo2892k || !z7) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void m2851l(C1140e1 c1140e1, C1162l1 c1162l1, boolean z7) {
        int iMo2888g;
        int iM2855p = m2855p(Integer.MIN_VALUE);
        if (iM2855p != Integer.MIN_VALUE && (iMo2888g = this.f3472c.mo2888g() - iM2855p) > 0) {
            int i6 = iMo2888g - (-scrollBy(-iMo2888g, c1140e1, c1162l1));
            if (!z7 || i6 <= 0) {
                return;
            }
            this.f3472c.mo2896p(i6);
        }
    }

    public final void m2852m(C1140e1 c1140e1, C1162l1 c1162l1, boolean z7) {
        int iMo2892k;
        int iM2856q = m2856q(Integer.MAX_VALUE);
        if (iM2856q != Integer.MAX_VALUE && (iMo2892k = iM2856q - this.f3472c.mo2892k()) > 0) {
            int iScrollBy = iMo2892k - scrollBy(iMo2892k, c1140e1, c1162l1);
            if (!z7 || iScrollBy <= 0) {
                return;
            }
            this.f3472c.mo2896p(-iScrollBy);
        }
    }

    public final int m2853n() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public final int m2854o() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    @Override
    public final void offsetChildrenHorizontal(int i6) {
        super.offsetChildrenHorizontal(i6);
        for (int i10 = 0; i10 < this.f3470a; i10++) {
            C1201y1 c1201y1 = this.f3471b[i10];
            int i11 = c1201y1.f3743b;
            if (i11 != Integer.MIN_VALUE) {
                c1201y1.f3743b = i11 + i6;
            }
            int i12 = c1201y1.f3744c;
            if (i12 != Integer.MIN_VALUE) {
                c1201y1.f3744c = i12 + i6;
            }
        }
    }

    @Override
    public final void offsetChildrenVertical(int i6) {
        super.offsetChildrenVertical(i6);
        for (int i10 = 0; i10 < this.f3470a; i10++) {
            C1201y1 c1201y1 = this.f3471b[i10];
            int i11 = c1201y1.f3743b;
            if (i11 != Integer.MIN_VALUE) {
                c1201y1.f3743b = i11 + i6;
            }
            int i12 = c1201y1.f3744c;
            if (i12 != Integer.MIN_VALUE) {
                c1201y1.f3744c = i12 + i6;
            }
        }
    }

    @Override
    public final void onAdapterChanged(AbstractC1158k0 abstractC1158k0, AbstractC1158k0 abstractC1158k1) {
        this.f3482m.m3000b();
        for (int i6 = 0; i6 < this.f3470a; i6++) {
            this.f3471b[i6].m3016d();
        }
    }

    @Override
    public final void onDetachedFromWindow(RecyclerView recyclerView, C1140e1 c1140e1) {
        onDetachedFromWindow(recyclerView);
        removeCallbacks(this.f3493x);
        for (int i6 = 0; i6 < this.f3470a; i6++) {
            this.f3471b[i6].m3016d();
        }
        recyclerView.requestLayout();
    }

    @Override
    public final View onFocusSearchFailed(View view, int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        View viewFindContainingItemView;
        int i10;
        View viewM3021i;
        if (getChildCount() == 0 || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        m2838A();
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 17) {
                    if (i6 != 33) {
                        if (i6 == 66 ? this.f3474e == 0 : !(i6 != 130 || this.f3474e != 1)) {
                            i10 = 1;
                        }
                    } else if (this.f3474e == 1) {
                        i10 = -1;
                    }
                    i10 = Integer.MIN_VALUE;
                } else if (this.f3474e == 0) {
                    i10 = -1;
                } else {
                    i10 = Integer.MIN_VALUE;
                }
            } else if (this.f3474e != 1 && isLayoutRTL()) {
                i10 = -1;
            } else {
                i10 = 1;
            }
        } else if (this.f3474e != 1 && isLayoutRTL()) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        if (i10 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) viewFindContainingItemView.getLayoutParams();
        boolean z7 = layoutParams.f3495f;
        C1201y1 c1201y1 = layoutParams.f3494e;
        int iM2854o = i10 == 1 ? m2854o() : m2853n();
        m2841D(iM2854o, c1162l1);
        m2839B(i10);
        C1190v c1190v = this.f3476g;
        c1190v.f3711c = c1190v.f3712d + iM2854o;
        c1190v.f3710b = (int) (this.f3472c.mo2893l() * 0.33333334f);
        c1190v.f3716h = true;
        c1190v.f3709a = false;
        m2848i(c1140e1, c1190v, c1162l1);
        this.f3484o = this.f3478i;
        if (!z7 && (viewM3021i = c1201y1.m3021i(iM2854o, i10)) != null && viewM3021i != viewFindContainingItemView) {
            return viewM3021i;
        }
        if (m2861v(i10)) {
            for (int i11 = this.f3470a - 1; i11 >= 0; i11--) {
                View viewM3021i2 = this.f3471b[i11].m3021i(iM2854o, i10);
                if (viewM3021i2 != null && viewM3021i2 != viewFindContainingItemView) {
                    return viewM3021i2;
                }
            }
        } else {
            for (int i12 = 0; i12 < this.f3470a; i12++) {
                View viewM3021i3 = this.f3471b[i12].m3021i(iM2854o, i10);
                if (viewM3021i3 != null && viewM3021i3 != viewFindContainingItemView) {
                    return viewM3021i3;
                }
            }
        }
        boolean z10 = (this.f3477h ^ true) == (i10 == -1);
        if (!z7) {
            View viewFindViewByPosition = findViewByPosition(z10 ? c1201y1.m3017e() : c1201y1.m3018f());
            if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                return viewFindViewByPosition;
            }
        }
        if (m2861v(i10)) {
            for (int i13 = this.f3470a - 1; i13 >= 0; i13--) {
                if (i13 != c1201y1.f3746e) {
                    View viewFindViewByPosition2 = findViewByPosition(z10 ? this.f3471b[i13].m3017e() : this.f3471b[i13].m3018f());
                    if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                        return viewFindViewByPosition2;
                    }
                }
            }
        } else {
            for (int i14 = 0; i14 < this.f3470a; i14++) {
                View viewFindViewByPosition3 = findViewByPosition(z10 ? this.f3471b[i14].m3017e() : this.f3471b[i14].m3018f());
                if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                    return viewFindViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewM2850k = m2850k(false);
            View viewM2849j = m2849j(false);
            if (viewM2850k == null || viewM2849j == null) {
                return;
            }
            int position = getPosition(viewM2850k);
            int position2 = getPosition(viewM2849j);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(C1140e1 c1140e1, C1162l1 c1162l1, C3233h c3233h) {
        super.onInitializeAccessibilityNodeInfo(c1140e1, c1162l1, c3233h);
        c3233h.m6547i("androidx.recyclerview.widget.StaggeredGridLayoutManager");
    }

    @Override
    public final void onInitializeAccessibilityNodeInfoForItem(C1140e1 c1140e1, C1162l1 c1162l1, View view, C3233h c3233h) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, c3233h);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.f3474e == 0) {
            C1201y1 c1201y1 = layoutParams2.f3494e;
            c3233h.m6549k(C3232g.m6538a(c1201y1 == null ? -1 : c1201y1.f3746e, layoutParams2.f3495f ? this.f3470a : 1, -1, -1, false));
        } else {
            C1201y1 c1201y2 = layoutParams2.f3494e;
            c3233h.m6549k(C3232g.m6538a(-1, -1, c1201y2 == null ? -1 : c1201y2.f3746e, layoutParams2.f3495f ? this.f3470a : 1, false));
        }
    }

    @Override
    public final void onItemsAdded(RecyclerView recyclerView, int i6, int i10) {
        m2857r(i6, i10, 1);
    }

    @Override
    public final void onItemsChanged(RecyclerView recyclerView) {
        this.f3482m.m3000b();
        requestLayout();
    }

    @Override
    public final void onItemsMoved(RecyclerView recyclerView, int i6, int i10, int i11) {
        m2857r(i6, i10, 8);
    }

    @Override
    public final void onItemsRemoved(RecyclerView recyclerView, int i6, int i10) {
        m2857r(i6, i10, 2);
    }

    @Override
    public final void onItemsUpdated(RecyclerView recyclerView, int i6, int i10, Object obj) {
        m2857r(i6, i10, 4);
    }

    @Override
    public final void onLayoutChildren(C1140e1 c1140e1, C1162l1 c1162l1) {
        m2860u(c1140e1, c1162l1, true);
    }

    @Override
    public final void onLayoutCompleted(C1162l1 c1162l1) {
        this.f3480k = -1;
        this.f3481l = Integer.MIN_VALUE;
        this.f3486q = null;
        this.f3489t.m2994a();
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f3486q = savedState;
            if (this.f3480k != -1) {
                savedState.f3503d = null;
                savedState.f3502c = 0;
                savedState.f3500a = -1;
                savedState.f3501b = -1;
                savedState.f3503d = null;
                savedState.f3502c = 0;
                savedState.f3504e = 0;
                savedState.f3505f = null;
                savedState.f3506g = null;
            }
            requestLayout();
        }
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        int iM3022j;
        int iMo2892k;
        int[] iArr;
        SavedState savedState = this.f3486q;
        if (savedState != null) {
            SavedState savedState2 = new SavedState();
            savedState2.f3502c = savedState.f3502c;
            savedState2.f3500a = savedState.f3500a;
            savedState2.f3501b = savedState.f3501b;
            savedState2.f3503d = savedState.f3503d;
            savedState2.f3504e = savedState.f3504e;
            savedState2.f3505f = savedState.f3505f;
            savedState2.f3507h = savedState.f3507h;
            savedState2.f3508i = savedState.f3508i;
            savedState2.f3509j = savedState.f3509j;
            savedState2.f3506g = savedState.f3506g;
            return savedState2;
        }
        SavedState savedState3 = new SavedState();
        savedState3.f3507h = this.f3477h;
        savedState3.f3508i = this.f3484o;
        savedState3.f3509j = this.f3485p;
        C1195w1 c1195w1 = this.f3482m;
        if (c1195w1 == null || (iArr = c1195w1.f3724a) == null) {
            savedState3.f3504e = 0;
        } else {
            savedState3.f3505f = iArr;
            savedState3.f3504e = iArr.length;
            savedState3.f3506g = c1195w1.f3725b;
        }
        if (getChildCount() > 0) {
            savedState3.f3500a = this.f3484o ? m2854o() : m2853n();
            View viewM2849j = this.f3478i ? m2849j(true) : m2850k(true);
            savedState3.f3501b = viewM2849j != null ? getPosition(viewM2849j) : -1;
            int i6 = this.f3470a;
            savedState3.f3502c = i6;
            savedState3.f3503d = new int[i6];
            for (int i10 = 0; i10 < this.f3470a; i10++) {
                if (this.f3484o) {
                    iM3022j = this.f3471b[i10].m3020h(Integer.MIN_VALUE);
                    if (iM3022j != Integer.MIN_VALUE) {
                        iMo2892k = this.f3472c.mo2888g();
                        iM3022j -= iMo2892k;
                    }
                } else {
                    iM3022j = this.f3471b[i10].m3022j(Integer.MIN_VALUE);
                    if (iM3022j != Integer.MIN_VALUE) {
                        iMo2892k = this.f3472c.mo2892k();
                        iM3022j -= iMo2892k;
                    }
                }
                savedState3.f3503d[i10] = iM3022j;
            }
        } else {
            savedState3.f3500a = -1;
            savedState3.f3501b = -1;
            savedState3.f3502c = 0;
        }
        return savedState3;
    }

    @Override
    public final void onScrollStateChanged(int i6) {
        if (i6 == 0) {
            m2844e();
        }
    }

    public final int m2855p(int i6) {
        int iM3020h = this.f3471b[0].m3020h(i6);
        for (int i10 = 1; i10 < this.f3470a; i10++) {
            int iM3020h2 = this.f3471b[i10].m3020h(i6);
            if (iM3020h2 > iM3020h) {
                iM3020h = iM3020h2;
            }
        }
        return iM3020h;
    }

    public final int m2856q(int i6) {
        int iM3022j = this.f3471b[0].m3022j(i6);
        for (int i10 = 1; i10 < this.f3470a; i10++) {
            int iM3022j2 = this.f3471b[i10].m3022j(i6);
            if (iM3022j2 < iM3022j) {
                iM3022j = iM3022j2;
            }
        }
        return iM3022j;
    }

    public final void m2857r(int i6, int i10, int i11) {
        int i12;
        int i13;
        C1195w1 c1195w1;
        int iM2854o;
        int iM2854o2 = this.f3478i ? m2854o() : m2853n();
        if (i11 == 8) {
            if (i6 < i10) {
                i12 = i10 + 1;
            } else {
                i12 = i6 + 1;
                i13 = i10;
            }
            c1195w1 = this.f3482m;
            c1195w1.m3005g(i13);
            if (i11 != 1) {
                c1195w1.m3006h(i6, i10);
            } else if (i11 != 2) {
                c1195w1.m3007i(i6, i10);
            } else if (i11 == 8) {
                c1195w1.m3007i(i6, 1);
                c1195w1.m3006h(i10, 1);
            }
            if (i12 <= iM2854o2) {
                return;
            }
            if (this.f3478i) {
                iM2854o = m2853n();
            } else {
                iM2854o = m2854o();
            }
            if (i13 <= iM2854o) {
                requestLayout();
            }
        }
        i12 = i6 + i10;
        i13 = i6;
        c1195w1 = this.f3482m;
        c1195w1.m3005g(i13);
        if (i11 != 1) {
            c1195w1.m3006h(i6, i10);
        } else if (i11 != 2) {
            c1195w1.m3007i(i6, i10);
        } else if (i11 == 8) {
            c1195w1.m3007i(i6, 1);
            c1195w1.m3006h(i10, 1);
        }
        if (i12 <= iM2854o2) {
            return;
        }
        if (this.f3478i) {
            iM2854o = m2853n();
        } else {
            iM2854o = m2854o();
        }
        if (i13 <= iM2854o) {
            requestLayout();
        }
    }

    public final View m2858s() {
        int i6;
        boolean z7;
        boolean z10;
        boolean z11;
        int childCount = getChildCount();
        int i10 = childCount - 1;
        BitSet bitSet = new BitSet(this.f3470a);
        bitSet.set(0, this.f3470a, true);
        byte b8 = (this.f3474e == 1 && isLayoutRTL()) ? (byte) 1 : (byte) -1;
        if (this.f3478i) {
            childCount = -1;
        } else {
            i10 = 0;
        }
        int i11 = i10 < childCount ? 1 : -1;
        while (i10 != childCount) {
            View childAt = getChildAt(i10);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.f3494e.f3746e)) {
                C1201y1 c1201y1 = layoutParams.f3494e;
                if (this.f3478i) {
                    int i12 = c1201y1.f3744c;
                    if (i12 == Integer.MIN_VALUE) {
                        c1201y1.m3014b();
                        i12 = c1201y1.f3744c;
                    }
                    if (i12 < this.f3472c.mo2888g()) {
                        z10 = ((LayoutParams) ((View) AbstractC2460q.m5491e(1, c1201y1.f3742a)).getLayoutParams()).f3495f;
                        z11 = !z10;
                    } else {
                        z11 = false;
                    }
                } else {
                    int i13 = c1201y1.f3743b;
                    if (i13 == Integer.MIN_VALUE) {
                        c1201y1.m3015c();
                        i13 = c1201y1.f3743b;
                    }
                    if (i13 > this.f3472c.mo2892k()) {
                        z10 = ((LayoutParams) ((View) c1201y1.f3742a.get(0)).getLayoutParams()).f3495f;
                        z11 = !z10;
                    } else {
                        z11 = false;
                    }
                }
                if (z11) {
                    return childAt;
                }
                bitSet.clear(layoutParams.f3494e.f3746e);
            }
            if (!layoutParams.f3495f && (i6 = i10 + i11) != childCount) {
                View childAt2 = getChildAt(i6);
                if (this.f3478i) {
                    int iMo2883b = this.f3472c.mo2883b(childAt);
                    int iMo2883b2 = this.f3472c.mo2883b(childAt2);
                    if (iMo2883b < iMo2883b2) {
                        return childAt;
                    }
                    if (iMo2883b == iMo2883b2) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                } else {
                    int iMo2886e = this.f3472c.mo2886e(childAt);
                    int iMo2886e2 = this.f3472c.mo2886e(childAt2);
                    if (iMo2886e > iMo2886e2) {
                        return childAt;
                    }
                    if (iMo2886e == iMo2886e2) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                }
                if (z7) {
                    if ((layoutParams.f3494e.f3746e - ((LayoutParams) childAt2.getLayoutParams()).f3494e.f3746e < 0) != (b8 < 0)) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            i10 += i11;
        }
        return null;
    }

    public final int scrollBy(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        if (getChildCount() == 0 || i6 == 0) {
            return 0;
        }
        m2862w(i6, c1162l1);
        C1190v c1190v = this.f3476g;
        int iM2848i = m2848i(c1140e1, c1190v, c1162l1);
        if (c1190v.f3710b >= iM2848i) {
            i6 = i6 < 0 ? -iM2848i : iM2848i;
        }
        this.f3472c.mo2896p(-i6);
        this.f3484o = this.f3478i;
        c1190v.f3710b = 0;
        m2863x(c1140e1, c1190v);
        return i6;
    }

    @Override
    public final int scrollHorizontallyBy(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        return scrollBy(i6, c1140e1, c1162l1);
    }

    @Override
    public final void scrollToPosition(int i6) {
        SavedState savedState = this.f3486q;
        if (savedState != null && savedState.f3500a != i6) {
            savedState.f3503d = null;
            savedState.f3502c = 0;
            savedState.f3500a = -1;
            savedState.f3501b = -1;
        }
        this.f3480k = i6;
        this.f3481l = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override
    public final int scrollVerticallyBy(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        return scrollBy(i6, c1140e1, c1162l1);
    }

    @Override
    public final void setMeasuredDimension(Rect rect, int i6, int i10) {
        int iChooseSize;
        int iChooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.f3474e == 1) {
            iChooseSize2 = AbstractC1197x0.chooseSize(i10, rect.height() + paddingBottom, getMinimumHeight());
            iChooseSize = AbstractC1197x0.chooseSize(i6, (this.f3475f * this.f3470a) + paddingRight, getMinimumWidth());
        } else {
            iChooseSize = AbstractC1197x0.chooseSize(i6, rect.width() + paddingRight, getMinimumWidth());
            iChooseSize2 = AbstractC1197x0.chooseSize(i10, (this.f3475f * this.f3470a) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    @Override
    public final void smoothScrollToPosition(RecyclerView recyclerView, C1162l1 c1162l1, int i6) {
        C1123a0 c1123a0 = new C1123a0(recyclerView.getContext());
        c1123a0.setTargetPosition(i6);
        startSmoothScroll(c1123a0);
    }

    @Override
    public final boolean supportsPredictiveItemAnimations() {
        return this.f3486q == null;
    }

    public final void m2859t(View view, int i6, int i10) {
        Rect rect = this.f3488s;
        calculateItemDecorationsForChild(view, rect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iM2837F = m2837F(i6, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int iM2837F2 = m2837F(i10, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.bottom);
        if (shouldMeasureChild(view, iM2837F, iM2837F2, layoutParams)) {
            view.measure(iM2837F, iM2837F2);
        }
    }

    public final void m2860u(C1140e1 c1140e1, C1162l1 c1162l1, boolean z7) {
        boolean z10;
        SavedState savedState;
        int childCount;
        int i6;
        int position;
        int position2;
        int childCount2;
        int i10;
        SavedState savedState2 = this.f3486q;
        C1189u1 c1189u1 = this.f3489t;
        if (!(savedState2 == null && this.f3480k == -1) && c1162l1.m2970b() == 0) {
            removeAndRecycleAllViews(c1140e1);
            c1189u1.m2994a();
            return;
        }
        boolean z11 = (c1189u1.f3706e && this.f3480k == -1 && this.f3486q == null) ? false : true;
        C1195w1 c1195w1 = this.f3482m;
        StaggeredGridLayoutManager staggeredGridLayoutManager = c1189u1.f3708g;
        if (z11) {
            c1189u1.m2994a();
            SavedState savedState3 = this.f3486q;
            if (savedState3 != null) {
                int i11 = savedState3.f3502c;
                if (i11 > 0) {
                    if (i11 == this.f3470a) {
                        for (int i12 = 0; i12 < this.f3470a; i12++) {
                            this.f3471b[i12].m3016d();
                            SavedState savedState4 = this.f3486q;
                            int iMo2888g = savedState4.f3503d[i12];
                            if (iMo2888g != Integer.MIN_VALUE) {
                                iMo2888g += savedState4.f3508i ? this.f3472c.mo2888g() : this.f3472c.mo2892k();
                            }
                            C1201y1 c1201y1 = this.f3471b[i12];
                            c1201y1.f3743b = iMo2888g;
                            c1201y1.f3744c = iMo2888g;
                        }
                    } else {
                        savedState3.f3503d = null;
                        savedState3.f3502c = 0;
                        savedState3.f3504e = 0;
                        savedState3.f3505f = null;
                        savedState3.f3506g = null;
                        savedState3.f3500a = savedState3.f3501b;
                    }
                }
                SavedState savedState5 = this.f3486q;
                this.f3485p = savedState5.f3509j;
                boolean z12 = savedState5.f3507h;
                assertNotInLayoutOrScroll(null);
                SavedState savedState6 = this.f3486q;
                if (savedState6 != null && savedState6.f3507h != z12) {
                    savedState6.f3507h = z12;
                }
                this.f3477h = z12;
                requestLayout();
                m2838A();
                SavedState savedState7 = this.f3486q;
                int i13 = savedState7.f3500a;
                if (i13 != -1) {
                    this.f3480k = i13;
                    c1189u1.f3704c = savedState7.f3508i;
                } else {
                    c1189u1.f3704c = this.f3478i;
                }
                if (savedState7.f3504e > 1) {
                    c1195w1.f3724a = savedState7.f3505f;
                    c1195w1.f3725b = savedState7.f3506g;
                }
            } else {
                m2838A();
                c1189u1.f3704c = this.f3478i;
            }
            if (c1162l1.f3621g || (i10 = this.f3480k) == -1) {
                if (this.f3484o) {
                    int iM2970b = c1162l1.m2970b();
                    childCount2 = getChildCount() - 1;
                    while (true) {
                        if (childCount2 < 0) {
                            position2 = 0;
                            break;
                        }
                        position2 = getPosition(getChildAt(childCount2));
                        if (position2 < 0 && position2 < iM2970b) {
                            break;
                        } else {
                            childCount2--;
                        }
                    }
                } else {
                    int iM2970b2 = c1162l1.m2970b();
                    childCount = getChildCount();
                    i6 = 0;
                    while (true) {
                        if (i6 >= childCount) {
                            position2 = 0;
                            break;
                        }
                        position = getPosition(getChildAt(i6));
                        if (position < 0 && position < iM2970b2) {
                            position2 = position;
                            break;
                        }
                        i6++;
                    }
                }
                c1189u1.f3702a = position2;
                c1189u1.f3703b = Integer.MIN_VALUE;
            } else if (i10 < 0 || i10 >= c1162l1.m2970b()) {
                this.f3480k = -1;
                this.f3481l = Integer.MIN_VALUE;
                if (this.f3484o) {
                    int iM2970b3 = c1162l1.m2970b();
                    childCount2 = getChildCount() - 1;
                    while (true) {
                        if (childCount2 < 0) {
                            position2 = 0;
                            break;
                        } else {
                            position2 = getPosition(getChildAt(childCount2));
                            if (position2 < 0) {
                            }
                            childCount2--;
                        }
                    }
                } else {
                    int iM2970b4 = c1162l1.m2970b();
                    childCount = getChildCount();
                    i6 = 0;
                    while (true) {
                        if (i6 >= childCount) {
                            position2 = 0;
                            break;
                        } else {
                            position = getPosition(getChildAt(i6));
                            if (position < 0) {
                            }
                            i6++;
                        }
                    }
                }
                c1189u1.f3702a = position2;
                c1189u1.f3703b = Integer.MIN_VALUE;
            } else {
                SavedState savedState8 = this.f3486q;
                if (savedState8 == null || savedState8.f3500a == -1 || savedState8.f3502c < 1) {
                    View viewFindViewByPosition = findViewByPosition(this.f3480k);
                    if (viewFindViewByPosition != null) {
                        c1189u1.f3702a = this.f3478i ? m2854o() : m2853n();
                        if (this.f3481l != Integer.MIN_VALUE) {
                            if (c1189u1.f3704c) {
                                c1189u1.f3703b = (this.f3472c.mo2888g() - this.f3481l) - this.f3472c.mo2883b(viewFindViewByPosition);
                            } else {
                                c1189u1.f3703b = (this.f3472c.mo2892k() + this.f3481l) - this.f3472c.mo2886e(viewFindViewByPosition);
                            }
                        } else if (this.f3472c.mo2884c(viewFindViewByPosition) > this.f3472c.mo2893l()) {
                            c1189u1.f3703b = c1189u1.f3704c ? this.f3472c.mo2888g() : this.f3472c.mo2892k();
                        } else {
                            int iMo2886e = this.f3472c.mo2886e(viewFindViewByPosition) - this.f3472c.mo2892k();
                            if (iMo2886e < 0) {
                                c1189u1.f3703b = -iMo2886e;
                            } else {
                                int iMo2888g2 = this.f3472c.mo2888g() - this.f3472c.mo2883b(viewFindViewByPosition);
                                if (iMo2888g2 < 0) {
                                    c1189u1.f3703b = iMo2888g2;
                                } else {
                                    c1189u1.f3703b = Integer.MIN_VALUE;
                                }
                            }
                        }
                    } else {
                        int i14 = this.f3480k;
                        c1189u1.f3702a = i14;
                        int i15 = this.f3481l;
                        if (i15 == Integer.MIN_VALUE) {
                            boolean z13 = m2843d(i14) == 1;
                            c1189u1.f3704c = z13;
                            c1189u1.f3703b = z13 ? staggeredGridLayoutManager.f3472c.mo2888g() : staggeredGridLayoutManager.f3472c.mo2892k();
                        } else if (c1189u1.f3704c) {
                            c1189u1.f3703b = staggeredGridLayoutManager.f3472c.mo2888g() - i15;
                        } else {
                            c1189u1.f3703b = staggeredGridLayoutManager.f3472c.mo2892k() + i15;
                        }
                        c1189u1.f3705d = true;
                    }
                } else {
                    c1189u1.f3703b = Integer.MIN_VALUE;
                    c1189u1.f3702a = this.f3480k;
                }
            }
            c1189u1.f3706e = true;
        }
        if (this.f3486q == null && this.f3480k == -1 && (c1189u1.f3704c != this.f3484o || isLayoutRTL() != this.f3485p)) {
            c1195w1.m3000b();
            c1189u1.f3705d = true;
        }
        if (getChildCount() > 0 && ((savedState = this.f3486q) == null || savedState.f3502c < 1)) {
            if (c1189u1.f3705d) {
                for (int i16 = 0; i16 < this.f3470a; i16++) {
                    this.f3471b[i16].m3016d();
                    int i17 = c1189u1.f3703b;
                    if (i17 != Integer.MIN_VALUE) {
                        C1201y1 c1201y2 = this.f3471b[i16];
                        c1201y2.f3743b = i17;
                        c1201y2.f3744c = i17;
                    }
                }
            } else if (z11 || c1189u1.f3707f == null) {
                for (int i18 = 0; i18 < this.f3470a; i18++) {
                    C1201y1 c1201y3 = this.f3471b[i18];
                    boolean z14 = this.f3478i;
                    int i19 = c1189u1.f3703b;
                    int iM3020h = z14 ? c1201y3.m3020h(Integer.MIN_VALUE) : c1201y3.m3022j(Integer.MIN_VALUE);
                    c1201y3.m3016d();
                    if (iM3020h != Integer.MIN_VALUE) {
                        StaggeredGridLayoutManager staggeredGridLayoutManager2 = c1201y3.f3747f;
                        if ((!z14 || iM3020h >= staggeredGridLayoutManager2.f3472c.mo2888g()) && (z14 || iM3020h <= staggeredGridLayoutManager2.f3472c.mo2892k())) {
                            if (i19 != Integer.MIN_VALUE) {
                                iM3020h += i19;
                            }
                            c1201y3.f3744c = iM3020h;
                            c1201y3.f3743b = iM3020h;
                        }
                    }
                }
                C1201y1[] c1201y1Arr = this.f3471b;
                int length = c1201y1Arr.length;
                int[] iArr = c1189u1.f3707f;
                if (iArr == null || iArr.length < length) {
                    c1189u1.f3707f = new int[staggeredGridLayoutManager.f3471b.length];
                }
                for (int i20 = 0; i20 < length; i20++) {
                    c1189u1.f3707f[i20] = c1201y1Arr[i20].m3022j(Integer.MIN_VALUE);
                }
            } else {
                for (int i21 = 0; i21 < this.f3470a; i21++) {
                    C1201y1 c1201y4 = this.f3471b[i21];
                    c1201y4.m3016d();
                    int i22 = c1189u1.f3707f[i21];
                    c1201y4.f3743b = i22;
                    c1201y4.f3744c = i22;
                }
            }
        }
        detachAndScrapAttachedViews(c1140e1);
        C1190v c1190v = this.f3476g;
        c1190v.f3709a = false;
        this.f3490u = false;
        int iMo2893l = this.f3473d.mo2893l();
        this.f3475f = iMo2893l / this.f3470a;
        this.f3487r = View.MeasureSpec.makeMeasureSpec(iMo2893l, this.f3473d.mo2890i());
        m2841D(c1189u1.f3702a, c1162l1);
        if (c1189u1.f3704c) {
            m2839B(-1);
            m2848i(c1140e1, c1190v, c1162l1);
            m2839B(1);
            c1190v.f3711c = c1189u1.f3702a + c1190v.f3712d;
            m2848i(c1140e1, c1190v, c1162l1);
        } else {
            m2839B(1);
            m2848i(c1140e1, c1190v, c1162l1);
            m2839B(-1);
            c1190v.f3711c = c1189u1.f3702a + c1190v.f3712d;
            m2848i(c1140e1, c1190v, c1162l1);
        }
        if (this.f3473d.mo2890i() != 1073741824) {
            int childCount3 = getChildCount();
            float fMax = 0.0f;
            for (int i23 = 0; i23 < childCount3; i23++) {
                View childAt = getChildAt(i23);
                float fMo2884c = this.f3473d.mo2884c(childAt);
                if (fMo2884c >= fMax) {
                    if (((LayoutParams) childAt.getLayoutParams()).f3495f) {
                        fMo2884c = (fMo2884c * 1.0f) / this.f3470a;
                    }
                    fMax = Math.max(fMax, fMo2884c);
                }
            }
            int i24 = this.f3475f;
            int iRound = Math.round(fMax * this.f3470a);
            if (this.f3473d.mo2890i() == Integer.MIN_VALUE) {
                iRound = Math.min(iRound, this.f3473d.mo2893l());
            }
            this.f3475f = iRound / this.f3470a;
            this.f3487r = View.MeasureSpec.makeMeasureSpec(iRound, this.f3473d.mo2890i());
            if (this.f3475f != i24) {
                for (int i25 = 0; i25 < childCount3; i25++) {
                    View childAt2 = getChildAt(i25);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.f3495f) {
                        if (isLayoutRTL() && this.f3474e == 1) {
                            int i26 = -((this.f3470a - 1) - layoutParams.f3494e.f3746e);
                            childAt2.offsetLeftAndRight((this.f3475f * i26) - (i26 * i24));
                        } else {
                            int i27 = layoutParams.f3494e.f3746e;
                            int i28 = this.f3475f * i27;
                            int i29 = i27 * i24;
                            if (this.f3474e == 1) {
                                childAt2.offsetLeftAndRight(i28 - i29);
                            } else {
                                childAt2.offsetTopAndBottom(i28 - i29);
                            }
                        }
                    }
                }
            }
        }
        if (getChildCount() > 0) {
            if (this.f3478i) {
                m2851l(c1140e1, c1162l1, true);
                m2852m(c1140e1, c1162l1, false);
            } else {
                m2852m(c1140e1, c1162l1, true);
                m2851l(c1140e1, c1162l1, false);
            }
        }
        if (z7 && !c1162l1.f3621g && this.f3483n != 0 && getChildCount() > 0 && (this.f3490u || m2858s() != null)) {
            removeCallbacks(this.f3493x);
            z10 = m2844e();
        }
        if (c1162l1.f3621g) {
            c1189u1.m2994a();
        }
        this.f3484o = c1189u1.f3704c;
        this.f3485p = isLayoutRTL();
        if (z10) {
            c1189u1.m2994a();
            m2860u(c1140e1, c1162l1, false);
        }
    }

    public final boolean m2861v(int i6) {
        if (this.f3474e == 0) {
            return (i6 == -1) != this.f3478i;
        }
        return ((i6 == -1) == this.f3478i) == isLayoutRTL();
    }

    public final void m2862w(int i6, C1162l1 c1162l1) {
        int iM2853n;
        int i10;
        if (i6 > 0) {
            iM2853n = m2854o();
            i10 = 1;
        } else {
            iM2853n = m2853n();
            i10 = -1;
        }
        C1190v c1190v = this.f3476g;
        c1190v.f3709a = true;
        m2841D(iM2853n, c1162l1);
        m2839B(i10);
        c1190v.f3711c = iM2853n + c1190v.f3712d;
        c1190v.f3710b = Math.abs(i6);
    }

    public final void m2863x(C1140e1 c1140e1, C1190v c1190v) {
        int iMin;
        if (!c1190v.f3709a || c1190v.f3717i) {
            return;
        }
        if (c1190v.f3710b == 0) {
            if (c1190v.f3713e == -1) {
                m2864y(c1190v.f3715g, c1140e1);
                return;
            } else {
                m2865z(c1190v.f3714f, c1140e1);
                return;
            }
        }
        int i6 = 1;
        if (c1190v.f3713e == -1) {
            int i10 = c1190v.f3714f;
            int iM3022j = this.f3471b[0].m3022j(i10);
            while (i6 < this.f3470a) {
                int iM3022j2 = this.f3471b[i6].m3022j(i10);
                if (iM3022j2 > iM3022j) {
                    iM3022j = iM3022j2;
                }
                i6++;
            }
            int i11 = i10 - iM3022j;
            m2864y(i11 < 0 ? c1190v.f3715g : c1190v.f3715g - Math.min(i11, c1190v.f3710b), c1140e1);
            return;
        }
        int i12 = c1190v.f3715g;
        int iM3020h = this.f3471b[0].m3020h(i12);
        while (i6 < this.f3470a) {
            int iM3020h2 = this.f3471b[i6].m3020h(i12);
            if (iM3020h2 < iM3020h) {
                iM3020h = iM3020h2;
            }
            i6++;
        }
        int i13 = iM3020h - c1190v.f3715g;
        if (i13 < 0) {
            iMin = c1190v.f3714f;
        } else {
            iMin = Math.min(i13, c1190v.f3710b) + c1190v.f3714f;
        }
        m2865z(iMin, c1140e1);
    }

    public final void m2864y(int i6, C1140e1 c1140e1) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f3472c.mo2886e(childAt) < i6 || this.f3472c.mo2895o(childAt) < i6) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f3495f) {
                for (int i10 = 0; i10 < this.f3470a; i10++) {
                    if (this.f3471b[i10].f3742a.size() == 1) {
                        return;
                    }
                }
                for (int i11 = 0; i11 < this.f3470a; i11++) {
                    this.f3471b[i11].m3023k();
                }
            } else if (layoutParams.f3494e.f3742a.size() == 1) {
                return;
            } else {
                layoutParams.f3494e.m3023k();
            }
            removeAndRecycleView(childAt, c1140e1);
        }
    }

    public final void m2865z(int i6, C1140e1 c1140e1) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f3472c.mo2883b(childAt) > i6 || this.f3472c.mo2894n(childAt) > i6) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f3495f) {
                for (int i10 = 0; i10 < this.f3470a; i10++) {
                    if (this.f3471b[i10].f3742a.size() == 1) {
                        return;
                    }
                }
                for (int i11 = 0; i11 < this.f3470a; i11++) {
                    this.f3471b[i11].m3024l();
                }
            } else if (layoutParams.f3494e.f3742a.size() == 1) {
                return;
            } else {
                layoutParams.f3494e.m3024l();
            }
            removeAndRecycleView(childAt, c1140e1);
        }
    }

    @Override
    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }
}

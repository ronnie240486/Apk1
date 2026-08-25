package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.FocusFinder;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.GridView;
import androidx.leanback.widget.picker.Picker;
import androidx.media3.common.C0565C;
import androidx.media3.extractor.p010ts.TsExtractor;
import androidx.recyclerview.widget.AbstractC1135d0;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1159k1;
import androidx.recyclerview.widget.AbstractC1174p1;
import androidx.recyclerview.widget.AbstractC1197x0;
import androidx.recyclerview.widget.C1127b0;
import androidx.recyclerview.widget.C1140e1;
import androidx.recyclerview.widget.C1162l1;
import androidx.recyclerview.widget.C1178r;
import androidx.recyclerview.widget.InterfaceC1194w0;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.cast.framework.internal.featurehighlight.C1498f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p001a0.C0023f;
import p002a1.C0026b;
import p084i1.C2678a;
import p084i1.C2681d;
import p101j7.C2782c;
import p103j9.AbstractC2796i;
import p130m2.C3066n;
import p138n0.AbstractC3155s0;
import p148o0.C3228c;
import p148o0.C3232g;
import p148o0.C3233h;
import p160p.C3343g;
import p160p.C3344h;
import p171q.C3388b;

public final class GridLayoutManager extends AbstractC1197x0 {

    public static final Rect f2087R = new Rect();

    public static final int[] f2088S = new int[2];

    public int f2089A;

    public int f2090B;

    public int f2091C;

    public int f2092D;

    public int f2093E;

    public int f2094F;

    public AbstractC0488p f2095G;

    public int f2096H;

    public final C0023f f2097I;

    public final C0026b f2098J;

    public int f2099K;

    public int f2100L;

    public final int[] f2101M;

    public final C0476j1 f2102N;

    public C0457d0 f2103O;

    public final RunnableC0447a f2104P;

    public final C0490q f2105Q;

    public float f2106a;

    public int f2107b;

    public AbstractC0474j f2108c;

    public int f2109d;

    public AbstractC1135d0 f2110e;

    public int f2111f;

    public C1162l1 f2112g;

    public int f2113h;

    public int f2114i;

    public final SparseIntArray f2115j;

    public int[] f2116k;

    public AudioManager f2117l;

    public C1140e1 f2118m;

    public int f2119n;

    public ArrayList f2120o;

    public int f2121p;

    public AbstractC0494s f2122q;

    public C0498u f2123r;

    public int f2124s;

    public int f2125t;

    public int f2126u;

    public int f2127v;

    public int f2128w;

    public int[] f2129x;

    public int f2130y;

    public int f2131z;

    @SuppressLint({"BanParcelableUsage"})
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0500v();

        public int f2132a;

        public Bundle f2133b;

        @Override
        public final int describeContents() {
            return 0;
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f2132a);
            parcel.writeBundle(this.f2133b);
        }
    }

    public GridLayoutManager() {
        this(null);
    }

    public static int m1348h(View view) {
        C0496t c0496t;
        if (view == null || (c0496t = (C0496t) view.getLayoutParams()) == null || c0496t.f3465a.isRemoved()) {
            return -1;
        }
        return c0496t.f3465a.getAbsoluteAdapterPosition();
    }

    public final void m1349A() {
        int i6 = this.f2119n;
        if ((65600 & i6) == 65536) {
            AbstractC0488p abstractC0488p = this.f2095G;
            int i10 = this.f2121p;
            int i11 = (i6 & 262144) != 0 ? -this.f2100L : this.f2099K + this.f2100L;
            while (true) {
                int i12 = abstractC0488p.f2383g;
                if (i12 >= abstractC0488p.f2382f && i12 > i10) {
                    if (!abstractC0488p.f2379c) {
                        if (abstractC0488p.f2378b.m1470d(i12) < i11) {
                            break;
                        }
                        abstractC0488p.f2378b.m1472f(abstractC0488p.f2383g);
                        abstractC0488p.f2383g--;
                    } else {
                        if (abstractC0488p.f2378b.m1470d(i12) > i11) {
                            break;
                        }
                        abstractC0488p.f2378b.m1472f(abstractC0488p.f2383g);
                        abstractC0488p.f2383g--;
                    }
                } else {
                    break;
                }
            }
            if (abstractC0488p.f2383g < abstractC0488p.f2382f) {
                abstractC0488p.f2383g = -1;
                abstractC0488p.f2382f = -1;
            }
        }
    }

    public final void m1350B() {
        int i6 = this.f2119n;
        if ((65600 & i6) == 65536) {
            AbstractC0488p abstractC0488p = this.f2095G;
            int i10 = this.f2121p;
            int i11 = (i6 & 262144) != 0 ? this.f2099K + this.f2100L : -this.f2100L;
            while (true) {
                int i12 = abstractC0488p.f2383g;
                int i13 = abstractC0488p.f2382f;
                if (i12 >= i13 && i13 < i10) {
                    int iM1471e = abstractC0488p.f2378b.m1471e(i13);
                    if (!abstractC0488p.f2379c) {
                        if (abstractC0488p.f2378b.m1470d(abstractC0488p.f2382f) + iM1471e > i11) {
                            break;
                        }
                        abstractC0488p.f2378b.m1472f(abstractC0488p.f2382f);
                        abstractC0488p.f2382f++;
                    } else {
                        if (abstractC0488p.f2378b.m1470d(abstractC0488p.f2382f) - iM1471e < i11) {
                            break;
                        }
                        abstractC0488p.f2378b.m1472f(abstractC0488p.f2382f);
                        abstractC0488p.f2382f++;
                    }
                } else {
                    break;
                }
            }
            if (abstractC0488p.f2383g < abstractC0488p.f2382f) {
                abstractC0488p.f2383g = -1;
                abstractC0488p.f2382f = -1;
            }
        }
    }

    public final void m1351C(C1140e1 c1140e1, C1162l1 c1162l1) {
        int i6 = this.f2111f;
        if (i6 == 0) {
            this.f2118m = c1140e1;
            this.f2112g = c1162l1;
            this.f2113h = 0;
            this.f2114i = 0;
        }
        this.f2111f = i6 + 1;
    }

    public final int m1352D(int i6) {
        int i10;
        int i11 = this.f2119n;
        if ((i11 & 64) == 0 && (i11 & 3) != 1) {
            C0023f c0023f = this.f2097I;
            if (i6 > 0) {
                C0479k1 c0479k1 = (C0479k1) c0023f.f46d;
                if (c0479k1.f2354a != Integer.MAX_VALUE && i6 > (i10 = c0479k1.f2356c)) {
                    i6 = i10;
                }
            } else if (i6 < 0) {
                C0479k1 c0479k2 = (C0479k1) c0023f.f46d;
                if (c0479k2.f2355b != Integer.MIN_VALUE && i6 < (i10 = c0479k2.f2357d)) {
                    i6 = i10;
                }
            }
        }
        if (i6 == 0) {
            return 0;
        }
        int i12 = -i6;
        int childCount = getChildCount();
        if (this.f2109d == 1) {
            for (int i13 = 0; i13 < childCount; i13++) {
                getChildAt(i13).offsetTopAndBottom(i12);
            }
        } else {
            for (int i14 = 0; i14 < childCount; i14++) {
                getChildAt(i14).offsetLeftAndRight(i12);
            }
        }
        if ((this.f2119n & 3) == 1) {
            m1363O();
            return i6;
        }
        int childCount2 = getChildCount();
        if ((this.f2119n & 262144) == 0 ? i6 >= 0 : i6 <= 0) {
            m1365d();
        } else {
            m1383w();
        }
        boolean z7 = getChildCount() > childCount2;
        int childCount3 = getChildCount();
        if ((262144 & this.f2119n) == 0 ? i6 >= 0 : i6 <= 0) {
            m1350B();
        } else {
            m1349A();
        }
        if (z7 | (getChildCount() < childCount3)) {
            m1362N();
        }
        this.f2108c.invalidate();
        m1363O();
        return i6;
    }

    public final int m1353E(int i6) {
        int i10 = 0;
        if (i6 == 0) {
            return 0;
        }
        int i11 = -i6;
        int childCount = getChildCount();
        if (this.f2109d == 0) {
            while (i10 < childCount) {
                getChildAt(i10).offsetTopAndBottom(i11);
                i10++;
            }
        } else {
            while (i10 < childCount) {
                getChildAt(i10).offsetLeftAndRight(i11);
                i10++;
            }
        }
        this.f2126u += i6;
        m1364P();
        this.f2108c.invalidate();
        return i6;
    }

    public final void m1354F(int i6, boolean z7) {
        View viewFindViewByPosition = findViewByPosition(i6);
        boolean zIsSmoothScrolling = isSmoothScrolling();
        if (!zIsSmoothScrolling && !this.f2108c.isLayoutRequested() && viewFindViewByPosition != null && m1348h(viewFindViewByPosition) == i6) {
            this.f2119n |= 32;
            m1356H(viewFindViewByPosition, z7);
            this.f2119n &= -33;
            return;
        }
        int i10 = this.f2119n;
        if ((i10 & 512) == 0 || (i10 & 64) != 0) {
            this.f2121p = i6;
            this.f2124s = Integer.MIN_VALUE;
            return;
        }
        if (z7 && !this.f2108c.isLayoutRequested()) {
            this.f2121p = i6;
            this.f2124s = Integer.MIN_VALUE;
            if (this.f2095G == null) {
                Log.w("GridLayoutManager:" + this.f2108c.getId(), "setSelectionSmooth should not be called before first layout pass");
                return;
            }
            C0492r c0492r = new C0492r(this);
            c0492r.setTargetPosition(i6);
            startSmoothScroll(c0492r);
            int targetPosition = c0492r.getTargetPosition();
            if (targetPosition != this.f2121p) {
                this.f2121p = targetPosition;
                return;
            }
            return;
        }
        if (zIsSmoothScrolling) {
            AbstractC0494s abstractC0494s = this.f2122q;
            if (abstractC0494s != null) {
                abstractC0494s.f2434a = true;
            }
            this.f2108c.stopScroll();
        }
        if (!this.f2108c.isLayoutRequested() && viewFindViewByPosition != null && m1348h(viewFindViewByPosition) == i6) {
            this.f2119n |= 32;
            m1356H(viewFindViewByPosition, z7);
            this.f2119n &= -33;
        } else {
            this.f2121p = i6;
            this.f2124s = Integer.MIN_VALUE;
            this.f2119n |= 256;
            requestLayout();
        }
    }

    public final void m1355G(View view, View view2, boolean z7, int i6, int i10) {
        if ((this.f2119n & 64) != 0) {
            return;
        }
        int iM1348h = m1348h(view);
        if (view != null && view2 != null) {
            ((C0496t) view.getLayoutParams()).getClass();
        }
        if (iM1348h != this.f2121p) {
            this.f2121p = iM1348h;
            this.f2124s = 0;
            if ((this.f2119n & 3) != 1) {
                m1366e();
            }
            if (this.f2108c.m2836a()) {
                this.f2108c.invalidate();
            }
        }
        if (view == null) {
            return;
        }
        if (!view.hasFocus() && this.f2108c.hasFocus()) {
            view.requestFocus();
        }
        if ((this.f2119n & 131072) == 0 && z7) {
            return;
        }
        int[] iArr = f2088S;
        if (!m1374n(view, view2, iArr) && i6 == 0 && i10 == 0) {
            return;
        }
        int i11 = iArr[0] + i6;
        int i12 = iArr[1] + i10;
        if ((this.f2119n & 3) == 1) {
            m1352D(i11);
            m1353E(i12);
            return;
        }
        if (this.f2109d != 0) {
            i12 = i11;
            i11 = i12;
        }
        if (z7) {
            this.f2108c.smoothScrollBy(i11, i12);
        } else {
            this.f2108c.scrollBy(i11, i12);
            m1367f();
        }
    }

    public final void m1356H(View view, boolean z7) {
        m1355G(view, view.findFocus(), z7, 0, 0);
    }

    public final void m1357I(int i6) {
        if (i6 < 0 && i6 != -2) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Invalid row height: "));
        }
        this.f2127v = i6;
    }

    public final void m1358J(int i6, boolean z7) {
        if (this.f2121p == i6 || i6 == -1) {
            return;
        }
        m1354F(i6, z7);
    }

    public final void m1359K() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            m1360L(getChildAt(i6));
        }
    }

    public final void m1360L(View view) {
        C0496t c0496t = (C0496t) view.getLayoutParams();
        c0496t.getClass();
        C0026b c0026b = this.f2098J;
        C0508z c0508z = (C0508z) c0026b.f55c;
        c0496t.f2441i = AbstractC0448a0.m1404a(view, c0508z, c0508z.f2456e);
        C0508z c0508z2 = (C0508z) c0026b.f54b;
        c0496t.f2442j = AbstractC0448a0.m1404a(view, c0508z2, c0508z2.f2456e);
    }

    public final void m1361M() {
        if (getChildCount() <= 0) {
            this.f2113h = 0;
        } else {
            this.f2113h = this.f2095G.f2382f - ((C0496t) getChildAt(0).getLayoutParams()).f3465a.getLayoutPosition();
        }
    }

    public final void m1362N() {
        int i6 = (this.f2119n & (-1025)) | (m1385y(false) ? 1024 : 0);
        this.f2119n = i6;
        if ((i6 & 1024) != 0) {
            AbstractC0474j abstractC0474j = this.f2108c;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            abstractC0474j.postOnAnimation(this.f2104P);
        }
    }

    public final void m1363O() {
        int i6;
        int i10;
        int iM2970b;
        int i11;
        int i12;
        int i13;
        int top;
        int i14;
        int top2;
        int i15;
        if (this.f2112g.m2970b() == 0) {
            return;
        }
        if ((this.f2119n & 262144) == 0) {
            i11 = this.f2095G.f2383g;
            int iM2970b2 = this.f2112g.m2970b() - 1;
            i6 = this.f2095G.f2382f;
            i10 = iM2970b2;
            iM2970b = 0;
        } else {
            AbstractC0488p abstractC0488p = this.f2095G;
            int i16 = abstractC0488p.f2382f;
            i6 = abstractC0488p.f2383g;
            i10 = 0;
            iM2970b = this.f2112g.m2970b() - 1;
            i11 = i16;
        }
        if (i11 < 0 || i6 < 0) {
            return;
        }
        boolean z7 = i11 == i10;
        boolean z10 = i6 == iM2970b;
        int iM1453i = Integer.MIN_VALUE;
        int iM1452g = Integer.MAX_VALUE;
        C0023f c0023f = this.f2097I;
        if (!z7) {
            C0479k1 c0479k1 = (C0479k1) c0023f.f46d;
            if (c0479k1.f2354a == Integer.MAX_VALUE && !z10 && c0479k1.f2355b == Integer.MIN_VALUE) {
                return;
            }
        }
        int[] iArr = f2088S;
        if (z7) {
            iM1452g = this.f2095G.m1452g(true, iArr);
            View viewFindViewByPosition = findViewByPosition(iArr[1]);
            if (this.f2109d == 0) {
                C0496t c0496t = (C0496t) viewFindViewByPosition.getLayoutParams();
                c0496t.getClass();
                top2 = viewFindViewByPosition.getLeft() + c0496t.f2437e;
                i15 = c0496t.f2441i;
            } else {
                C0496t c0496t2 = (C0496t) viewFindViewByPosition.getLayoutParams();
                c0496t2.getClass();
                top2 = viewFindViewByPosition.getTop() + c0496t2.f2438f;
                i15 = c0496t2.f2442j;
            }
            i12 = top2 + i15;
            ((C0496t) viewFindViewByPosition.getLayoutParams()).getClass();
        } else {
            i12 = Integer.MAX_VALUE;
        }
        if (z10) {
            iM1453i = this.f2095G.m1453i(false, iArr);
            View viewFindViewByPosition2 = findViewByPosition(iArr[1]);
            if (this.f2109d == 0) {
                C0496t c0496t3 = (C0496t) viewFindViewByPosition2.getLayoutParams();
                c0496t3.getClass();
                top = viewFindViewByPosition2.getLeft() + c0496t3.f2437e;
                i14 = c0496t3.f2441i;
            } else {
                C0496t c0496t4 = (C0496t) viewFindViewByPosition2.getLayoutParams();
                c0496t4.getClass();
                top = viewFindViewByPosition2.getTop() + c0496t4.f2438f;
                i14 = c0496t4.f2442j;
            }
            i13 = top + i14;
        } else {
            i13 = Integer.MIN_VALUE;
        }
        ((C0479k1) c0023f.f46d).m1444c(iM1453i, iM1452g, i13, i12);
    }

    public final void m1364P() {
        C0479k1 c0479k1 = (C0479k1) this.f2097I.f47e;
        int i6 = c0479k1.f2363j - this.f2126u;
        int iM1375o = m1375o() + i6;
        c0479k1.m1444c(i6, iM1375o, i6, iM1375o);
    }

    @Override
    public final boolean canScrollHorizontally() {
        return this.f2109d == 0 || this.f2093E > 1;
    }

    @Override
    public final boolean canScrollVertically() {
        return this.f2109d == 1 || this.f2093E > 1;
    }

    @Override
    public final boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof C0496t;
    }

    @Override
    public final void collectAdjacentPrefetchPositions(int i6, int i10, C1162l1 c1162l1, InterfaceC1194w0 interfaceC1194w0) {
        try {
            m1351C(null, c1162l1);
            if (this.f2109d != 0) {
                i6 = i10;
            }
            if (getChildCount() != 0 && i6 != 0) {
                this.f2095G.mo1413e(i6 < 0 ? -this.f2100L : this.f2099K + this.f2100L, i6, (C1178r) interfaceC1194w0);
            }
        } finally {
            m1381u();
        }
    }

    @Override
    public final void collectInitialPrefetchPositions(int i6, InterfaceC1194w0 interfaceC1194w0) {
        int i10 = this.f2108c.f2349e;
        if (i6 == 0 || i10 == 0) {
            return;
        }
        int iMax = Math.max(0, Math.min(this.f2121p - ((i10 - 1) / 2), i6 - i10));
        for (int i11 = iMax; i11 < i6 && i11 < iMax + i10; i11++) {
            ((C1178r) interfaceC1194w0).m2986a(i11, 0);
        }
    }

    public final void m1365d() {
        this.f2095G.mo1412b((this.f2119n & 262144) != 0 ? (-this.f2100L) - this.f2114i : this.f2099K + this.f2100L + this.f2114i, false);
    }

    public final void m1366e() {
        ArrayList arrayList = this.f2120o;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int i6 = this.f2121p;
        View viewFindViewByPosition = i6 == -1 ? null : findViewByPosition(i6);
        if (viewFindViewByPosition != null) {
            m1368g(this.f2108c, this.f2108c.getChildViewHolder(viewFindViewByPosition), this.f2121p);
        } else {
            m1368g(this.f2108c, null, -1);
        }
        if ((this.f2119n & 3) == 1 || this.f2108c.isLayoutRequested()) {
            return;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (getChildAt(i10).isLayoutRequested()) {
                AbstractC0474j abstractC0474j = this.f2108c;
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                abstractC0474j.postOnAnimation(this.f2104P);
                return;
            }
        }
    }

    public final void m1367f() {
        ArrayList arrayList = this.f2120o;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int i6 = this.f2121p;
        View viewFindViewByPosition = i6 == -1 ? null : findViewByPosition(i6);
        if (viewFindViewByPosition == null) {
            ArrayList arrayList2 = this.f2120o;
            if (arrayList2 == null) {
                return;
            }
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                ((AbstractC0469h0) this.f2120o.get(size)).getClass();
            }
            return;
        }
        this.f2108c.getChildViewHolder(viewFindViewByPosition);
        ArrayList arrayList3 = this.f2120o;
        if (arrayList3 == null) {
            return;
        }
        for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
            ((AbstractC0469h0) this.f2120o.get(size2)).getClass();
        }
    }

    public final void m1368g(RecyclerView recyclerView, AbstractC1174p1 abstractC1174p1, int i6) {
        ArrayList arrayList = this.f2120o;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C2678a c2678a = (C2678a) ((AbstractC0469h0) this.f2120o.get(size));
            c2678a.getClass();
            Picker picker = c2678a.f9314a;
            int iIndexOf = picker.f2403b.indexOf((VerticalGridView) recyclerView);
            picker.m1462f(iIndexOf);
            if (abstractC1174p1 != null) {
                picker.mo1455a(iIndexOf, ((C2681d) picker.f2404c.get(iIndexOf)).f9322b + i6);
            }
        }
    }

    @Override
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new C0496t(-2, -2);
    }

    @Override
    public final RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new C0496t(context, attributeSet);
    }

    @Override
    public final int getColumnCountForAccessibility(C1140e1 c1140e1, C1162l1 c1162l1) {
        AbstractC0488p abstractC0488p;
        return (this.f2109d != 1 || (abstractC0488p = this.f2095G) == null) ? super.getColumnCountForAccessibility(c1140e1, c1162l1) : abstractC0488p.f2381e;
    }

    @Override
    public final int getDecoratedBottom(View view) {
        return super.getDecoratedBottom(view) - ((C0496t) view.getLayoutParams()).f2440h;
    }

    @Override
    public final void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        C0496t c0496t = (C0496t) view.getLayoutParams();
        rect.left += c0496t.f2437e;
        rect.top += c0496t.f2438f;
        rect.right -= c0496t.f2439g;
        rect.bottom -= c0496t.f2440h;
    }

    @Override
    public final int getDecoratedLeft(View view) {
        return super.getDecoratedLeft(view) + ((C0496t) view.getLayoutParams()).f2437e;
    }

    @Override
    public final int getDecoratedRight(View view) {
        return super.getDecoratedRight(view) - ((C0496t) view.getLayoutParams()).f2439g;
    }

    @Override
    public final int getDecoratedTop(View view) {
        return super.getDecoratedTop(view) + ((C0496t) view.getLayoutParams()).f2438f;
    }

    @Override
    public final int getRowCountForAccessibility(C1140e1 c1140e1, C1162l1 c1162l1) {
        AbstractC0488p abstractC0488p;
        return (this.f2109d != 0 || (abstractC0488p = this.f2095G) == null) ? super.getRowCountForAccessibility(c1140e1, c1162l1) : abstractC0488p.f2381e;
    }

    public final int m1369i(View view) {
        C0496t c0496t = (C0496t) view.getLayoutParams();
        return getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) c0496t).topMargin + ((ViewGroup.MarginLayoutParams) c0496t).bottomMargin;
    }

    public final int m1370j(View view) {
        C0496t c0496t = (C0496t) view.getLayoutParams();
        return getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) c0496t).leftMargin + ((ViewGroup.MarginLayoutParams) c0496t).rightMargin;
    }

    public final int m1371k(int i6) {
        int i10 = this.f2109d;
        int i11 = 2;
        if (i10 != 0) {
            if (i10 == 1) {
                if (i6 != 17) {
                    if (i6 == 33) {
                        return 0;
                    }
                    if (i6 != 66) {
                        if (i6 == 130) {
                            return 1;
                        }
                    } else if ((this.f2119n & 524288) == 0) {
                        i11 = 3;
                    }
                } else if ((this.f2119n & 524288) != 0) {
                    i11 = 3;
                }
            }
            return 17;
        }
        if (i6 != 17) {
            if (i6 != 33) {
                if (i6 != 66) {
                    if (i6 != 130) {
                        i11 = 17;
                    } else {
                        i11 = 3;
                    }
                } else if ((this.f2119n & 262144) == 0) {
                    i11 = 1;
                } else {
                    i11 = 0;
                }
            }
        } else if ((this.f2119n & 262144) == 0) {
            i11 = 0;
        } else {
            i11 = 1;
        }
        return i11;
    }

    public final int m1372l(int i6) {
        int i10 = this.f2128w;
        if (i10 != 0) {
            return i10;
        }
        int[] iArr = this.f2129x;
        if (iArr == null) {
            return 0;
        }
        return iArr[i6];
    }

    public final int m1373m(int i6) {
        int iM1372l = 0;
        if ((this.f2119n & 524288) != 0) {
            for (int i10 = this.f2093E - 1; i10 > i6; i10--) {
                iM1372l += m1372l(i10) + this.f2091C;
            }
            return iM1372l;
        }
        int iM1372l2 = 0;
        while (iM1372l < i6) {
            iM1372l2 += m1372l(iM1372l) + this.f2091C;
            iM1372l++;
        }
        return iM1372l2;
    }

    public final boolean m1374n(View view, View view2, int[] iArr) {
        View viewFindViewByPosition;
        int i6;
        int iMo2883b;
        int left;
        int i10;
        int iM1443b;
        int top;
        int i11;
        int left2;
        int i12;
        int i13 = this.f2096H;
        C0023f c0023f = this.f2097I;
        if (i13 != 1 && i13 != 2) {
            C0479k1 c0479k1 = (C0479k1) c0023f.f46d;
            if (this.f2109d == 0) {
                C0496t c0496t = (C0496t) view.getLayoutParams();
                c0496t.getClass();
                top = view.getLeft() + c0496t.f2437e;
                i11 = c0496t.f2441i;
            } else {
                C0496t c0496t2 = (C0496t) view.getLayoutParams();
                c0496t2.getClass();
                top = view.getTop() + c0496t2.f2438f;
                i11 = c0496t2.f2442j;
            }
            int iM1443b2 = c0479k1.m1443b(top + i11);
            if (view2 != null) {
                ((C0496t) view.getLayoutParams()).getClass();
            }
            if (this.f2109d == 0) {
                C0496t c0496t3 = (C0496t) view.getLayoutParams();
                c0496t3.getClass();
                left2 = view.getTop() + c0496t3.f2438f;
                i12 = c0496t3.f2442j;
            } else {
                C0496t c0496t4 = (C0496t) view.getLayoutParams();
                c0496t4.getClass();
                left2 = view.getLeft() + c0496t4.f2437e;
                i12 = c0496t4.f2441i;
            }
            int iM1443b3 = ((C0479k1) c0023f.f47e).m1443b(left2 + i12);
            if (iM1443b2 == 0 && iM1443b3 == 0) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
            iArr[0] = iM1443b2;
            iArr[1] = iM1443b3;
            return true;
        }
        int iM1348h = m1348h(view);
        int iMo2886e = this.f2110e.mo2886e(view);
        int iMo2883b2 = this.f2110e.mo2883b(view);
        C0479k1 c0479k2 = (C0479k1) c0023f.f46d;
        int i14 = c0479k2.f2363j;
        int i15 = (c0479k2.f2362i - i14) - c0479k2.f2364k;
        C0486o c0486oMo1417k = this.f2095G.mo1417k(iM1348h);
        int i16 = c0486oMo1417k == null ? -1 : c0486oMo1417k.f2374a;
        View viewFindViewByPosition2 = null;
        if (iMo2886e < i14) {
            if (this.f2096H == 2) {
                View view3 = view;
                while (true) {
                    AbstractC0488p abstractC0488p = this.f2095G;
                    if (!abstractC0488p.mo1418m(abstractC0488p.f2379c ? Integer.MIN_VALUE : Integer.MAX_VALUE, true)) {
                        viewFindViewByPosition = null;
                        viewFindViewByPosition2 = view3;
                        break;
                    }
                    AbstractC0488p abstractC0488p2 = this.f2095G;
                    C3344h c3344h = abstractC0488p2.mo1416j(abstractC0488p2.f2382f, iM1348h)[i16];
                    View viewFindViewByPosition3 = findViewByPosition(c3344h.m6792b(0));
                    if (iMo2883b2 - this.f2110e.mo2886e(viewFindViewByPosition3) > i15) {
                        if (c3344h.m6793c() <= 2) {
                            viewFindViewByPosition = null;
                            viewFindViewByPosition2 = viewFindViewByPosition3;
                            break;
                        }
                        viewFindViewByPosition = null;
                        viewFindViewByPosition2 = findViewByPosition(c3344h.m6792b(2));
                        break;
                    }
                    view3 = viewFindViewByPosition3;
                }
            } else {
                viewFindViewByPosition = null;
                viewFindViewByPosition2 = view;
            }
        } else if (iMo2883b2 <= i15 + i14) {
            viewFindViewByPosition = null;
        } else if (this.f2096H == 2) {
            do {
                AbstractC0488p abstractC0488p3 = this.f2095G;
                C3344h c3344h2 = abstractC0488p3.mo1416j(iM1348h, abstractC0488p3.f2383g)[i16];
                viewFindViewByPosition = findViewByPosition(c3344h2.m6792b(c3344h2.m6793c() - 1));
                if (this.f2110e.mo2883b(viewFindViewByPosition) - iMo2886e > i15) {
                    viewFindViewByPosition = null;
                    break;
                }
            } while (this.f2095G.m1449a());
            if (viewFindViewByPosition == null) {
                viewFindViewByPosition2 = view;
            }
        } else {
            viewFindViewByPosition = view;
        }
        if (viewFindViewByPosition2 == null) {
            if (viewFindViewByPosition != null) {
                iMo2883b = this.f2110e.mo2883b(viewFindViewByPosition);
                i14 += i15;
            } else {
                i6 = 0;
            }
            if (viewFindViewByPosition2 != null) {
                view = viewFindViewByPosition2;
            } else if (viewFindViewByPosition != null) {
                view = viewFindViewByPosition;
            }
            if (this.f2109d == 0) {
                C0496t c0496t5 = (C0496t) view.getLayoutParams();
                c0496t5.getClass();
                left = view.getTop() + c0496t5.f2438f;
                i10 = c0496t5.f2442j;
            } else {
                C0496t c0496t6 = (C0496t) view.getLayoutParams();
                c0496t6.getClass();
                left = view.getLeft() + c0496t6.f2437e;
                i10 = c0496t6.f2441i;
            }
            iM1443b = ((C0479k1) c0023f.f47e).m1443b(left + i10);
            if (i6 != 0 && iM1443b == 0) {
                return false;
            }
            iArr[0] = i6;
            iArr[1] = iM1443b;
            return true;
        }
        iMo2883b = this.f2110e.mo2886e(viewFindViewByPosition2);
        i6 = iMo2883b - i14;
        if (viewFindViewByPosition2 != null) {
            view = viewFindViewByPosition2;
        } else if (viewFindViewByPosition != null) {
            view = viewFindViewByPosition;
        }
        if (this.f2109d == 0) {
            C0496t c0496t7 = (C0496t) view.getLayoutParams();
            c0496t7.getClass();
            left = view.getTop() + c0496t7.f2438f;
            i10 = c0496t7.f2442j;
        } else {
            C0496t c0496t8 = (C0496t) view.getLayoutParams();
            c0496t8.getClass();
            left = view.getLeft() + c0496t8.f2437e;
            i10 = c0496t8.f2441i;
        }
        iM1443b = ((C0479k1) c0023f.f47e).m1443b(left + i10);
        if (i6 != 0) {
        }
        iArr[0] = i6;
        iArr[1] = iM1443b;
        return true;
    }

    public final int m1375o() {
        int i6 = (this.f2119n & 524288) != 0 ? 0 : this.f2093E - 1;
        return m1372l(i6) + m1373m(i6);
    }

    @Override
    public final void onAdapterChanged(AbstractC1158k0 abstractC1158k0, AbstractC1158k0 abstractC1158k1) {
        if (abstractC1158k0 != null) {
            this.f2095G = null;
            this.f2129x = null;
            this.f2119n &= -1025;
            this.f2121p = -1;
            this.f2124s = 0;
            C1498f c1498f = (C1498f) this.f2102N.f2353c;
            if (c1498f != null) {
                c1498f.m3619i(-1);
            }
        }
        if (abstractC1158k1 instanceof C0457d0) {
            this.f2103O = (C0457d0) abstractC1158k1;
        } else {
            this.f2103O = null;
        }
        super.onAdapterChanged(abstractC1158k0, abstractC1158k1);
    }

    @Override
    public final boolean onAddFocusables(RecyclerView recyclerView, ArrayList arrayList, int i6, int i10) {
        int i11;
        View childAt;
        AbstractC0474j abstractC0474j;
        View viewFindContainingItemView;
        if ((this.f2119n & 32768) != 0) {
            return true;
        }
        if (!recyclerView.hasFocus()) {
            int size = arrayList.size();
            if (this.f2096H != 0) {
                C0479k1 c0479k1 = (C0479k1) this.f2097I.f46d;
                int i12 = c0479k1.f2363j;
                int i13 = ((c0479k1.f2362i - i12) - c0479k1.f2364k) + i12;
                int childCount = getChildCount();
                for (int i14 = 0; i14 < childCount; i14++) {
                    View childAt2 = getChildAt(i14);
                    if (childAt2.getVisibility() == 0 && this.f2110e.mo2886e(childAt2) >= i12 && this.f2110e.mo2883b(childAt2) <= i13) {
                        childAt2.addFocusables(arrayList, i6, i10);
                    }
                }
                if (arrayList.size() == size) {
                    int childCount2 = getChildCount();
                    for (int i15 = 0; i15 < childCount2; i15++) {
                        View childAt3 = getChildAt(i15);
                        if (childAt3.getVisibility() == 0) {
                            childAt3.addFocusables(arrayList, i6, i10);
                        }
                    }
                }
            } else {
                View viewFindViewByPosition = findViewByPosition(this.f2121p);
                if (viewFindViewByPosition != null) {
                    viewFindViewByPosition.addFocusables(arrayList, i6, i10);
                }
            }
            if (arrayList.size() == size && recyclerView.isFocusable()) {
                arrayList.add(recyclerView);
            }
        } else {
            if (this.f2123r != null) {
                return true;
            }
            int iM1371k = m1371k(i6);
            View viewFindFocus = recyclerView.findFocus();
            if (viewFindFocus == null || (abstractC0474j = this.f2108c) == null || viewFindFocus == abstractC0474j || (viewFindContainingItemView = findContainingItemView(viewFindFocus)) == null) {
                i11 = -1;
                break;
            }
            int childCount3 = getChildCount();
            i11 = 0;
            while (true) {
                if (i11 >= childCount3) {
                    i11 = -1;
                    break;
                }
                if (getChildAt(i11) == viewFindContainingItemView) {
                    break;
                }
                i11++;
            }
            int iM1348h = m1348h(getChildAt(i11));
            View viewFindViewByPosition2 = iM1348h == -1 ? null : findViewByPosition(iM1348h);
            if (viewFindViewByPosition2 != null) {
                viewFindViewByPosition2.addFocusables(arrayList, i6, i10);
            }
            if (this.f2095G == null || getChildCount() == 0) {
                return true;
            }
            if ((iM1371k == 3 || iM1371k == 2) && this.f2095G.f2381e <= 1) {
                return true;
            }
            AbstractC0488p abstractC0488p = this.f2095G;
            int i16 = (abstractC0488p == null || viewFindViewByPosition2 == null) ? -1 : abstractC0488p.mo1417k(iM1348h).f2374a;
            int size2 = arrayList.size();
            int i17 = (iM1371k == 1 || iM1371k == 3) ? 1 : -1;
            int childCount4 = i17 > 0 ? getChildCount() - 1 : 0;
            int childCount5 = i11 == -1 ? i17 > 0 ? 0 : getChildCount() - 1 : i11 + i17;
            while (true) {
                if (i17 <= 0) {
                    if (childCount5 < childCount4) {
                        break;
                    }
                    childAt = getChildAt(childCount5);
                    if (childAt.getVisibility() != 0) {
                    }
                    childCount5 += i17;
                } else {
                    if (childCount5 > childCount4) {
                        break;
                    }
                    childAt = getChildAt(childCount5);
                    if (childAt.getVisibility() != 0 && childAt.hasFocusable()) {
                        if (viewFindViewByPosition2 == null) {
                            childAt.addFocusables(arrayList, i6, i10);
                            if (arrayList.size() > size2) {
                                break;
                            }
                        } else {
                            int iM1348h2 = m1348h(getChildAt(childCount5));
                            C0486o c0486oMo1417k = this.f2095G.mo1417k(iM1348h2);
                            if (c0486oMo1417k != null) {
                                int i18 = c0486oMo1417k.f2374a;
                                if (iM1371k == 1) {
                                    if (i18 == i16 && iM1348h2 > iM1348h) {
                                        childAt.addFocusables(arrayList, i6, i10);
                                        if (arrayList.size() > size2) {
                                            break;
                                        }
                                    }
                                } else if (iM1371k == 0) {
                                    if (i18 == i16 && iM1348h2 < iM1348h) {
                                        childAt.addFocusables(arrayList, i6, i10);
                                        if (arrayList.size() > size2) {
                                            break;
                                        }
                                    }
                                } else if (iM1371k == 3) {
                                    if (i18 != i16) {
                                        if (i18 < i16) {
                                            break;
                                        }
                                        childAt.addFocusables(arrayList, i6, i10);
                                    }
                                } else if (iM1371k == 2 && i18 != i16) {
                                    if (i18 > i16) {
                                        break;
                                    }
                                    childAt.addFocusables(arrayList, i6, i10);
                                }
                            }
                        }
                    }
                    childCount5 += i17;
                }
            }
        }
        return true;
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(C1140e1 c1140e1, C1162l1 c1162l1, C3233h c3233h) {
        m1351C(c1140e1, c1162l1);
        int iM2970b = c1162l1.m2970b();
        int i6 = this.f2119n;
        boolean z7 = (262144 & i6) != 0;
        if ((i6 & 2048) == 0 || (iM2970b > 1 && !m1379s(0))) {
            if (Build.VERSION.SDK_INT < 23) {
                c3233h.m6540a(8192);
            } else if (this.f2109d == 0) {
                c3233h.m6541b(z7 ? C3228c.f10853q : C3228c.f10851o);
            } else {
                c3233h.m6541b(C3228c.f10850n);
            }
            c3233h.m6552n(true);
        }
        if ((this.f2119n & 4096) == 0 || (iM2970b > 1 && !m1379s(iM2970b - 1))) {
            if (Build.VERSION.SDK_INT < 23) {
                c3233h.m6540a(4096);
            } else if (this.f2109d == 0) {
                c3233h.m6541b(z7 ? C3228c.f10851o : C3228c.f10853q);
            } else {
                c3233h.m6541b(C3228c.f10852p);
            }
            c3233h.m6552n(true);
        }
        c3233h.m6548j(C2782c.m5751x(getRowCountForAccessibility(c1140e1, c1162l1), getColumnCountForAccessibility(c1140e1, c1162l1), getSelectionModeForAccessibility(c1140e1, c1162l1), isLayoutHierarchical(c1140e1, c1162l1)));
        c3233h.m6547i(GridView.class.getName());
        m1381u();
    }

    @Override
    public final void onInitializeAccessibilityNodeInfoForItem(C1140e1 c1140e1, C1162l1 c1162l1, View view, C3233h c3233h) {
        C0486o c0486oMo1417k;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.f2095G == null || !(layoutParams instanceof C0496t)) {
            return;
        }
        int absoluteAdapterPosition = ((C0496t) layoutParams).f3465a.getAbsoluteAdapterPosition();
        int i6 = -1;
        if (absoluteAdapterPosition >= 0 && (c0486oMo1417k = this.f2095G.mo1417k(absoluteAdapterPosition)) != null) {
            i6 = c0486oMo1417k.f2374a;
        }
        if (i6 < 0) {
            return;
        }
        int i10 = absoluteAdapterPosition / this.f2095G.f2381e;
        if (this.f2109d == 0) {
            c3233h.m6549k(C3232g.m6538a(i6, 1, i10, 1, false));
        } else {
            c3233h.m6549k(C3232g.m6538a(i10, 1, i6, 1, false));
        }
    }

    @Override
    public final View onInterceptFocusSearch(View view, int i6) {
        View viewFindNextFocus;
        View viewFindNextFocus2;
        if ((this.f2119n & 32768) != 0) {
            return view;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (i6 == 2 || i6 == 1) {
            if (canScrollVertically()) {
                viewFindNextFocus = focusFinder.findNextFocus(this.f2108c, view, i6 == 2 ? TsExtractor.TS_STREAM_TYPE_HDMV_DTS : 33);
            } else {
                viewFindNextFocus = null;
            }
            if (canScrollHorizontally()) {
                viewFindNextFocus2 = focusFinder.findNextFocus(this.f2108c, view, (getLayoutDirection() == 1) ^ (i6 == 2) ? 66 : 17);
            } else {
                viewFindNextFocus2 = viewFindNextFocus;
            }
        } else {
            viewFindNextFocus2 = focusFinder.findNextFocus(this.f2108c, view, i6);
        }
        if (viewFindNextFocus2 != null) {
            return viewFindNextFocus2;
        }
        if (this.f2108c.getDescendantFocusability() == 393216) {
            return this.f2108c.getParent().focusSearch(view, i6);
        }
        int iM1371k = m1371k(i6);
        boolean z7 = this.f2108c.getScrollState() != 0;
        if (iM1371k == 1) {
            if (z7 || (this.f2119n & 4096) == 0) {
                viewFindNextFocus2 = view;
            }
            if ((this.f2119n & 131072) != 0 && !m1378r()) {
                m1384x(true);
                viewFindNextFocus2 = view;
            }
        } else if (iM1371k == 0) {
            if (z7 || (this.f2119n & 2048) == 0) {
                viewFindNextFocus2 = view;
            }
            if ((this.f2119n & 131072) != 0 && !m1377q()) {
                m1384x(false);
                viewFindNextFocus2 = view;
            }
        } else if (iM1371k == 3) {
        }
        if (viewFindNextFocus2 != null) {
            return viewFindNextFocus2;
        }
        View viewFocusSearch = this.f2108c.getParent().focusSearch(view, i6);
        if (viewFocusSearch != null) {
            return viewFocusSearch;
        }
        return view != null ? view : this.f2108c;
    }

    @Override
    public final void onItemsAdded(RecyclerView recyclerView, int i6, int i10) {
        AbstractC0488p abstractC0488p;
        int i11;
        int i12 = this.f2121p;
        if (i12 != -1 && (abstractC0488p = this.f2095G) != null && abstractC0488p.f2382f >= 0 && (i11 = this.f2124s) != Integer.MIN_VALUE && i6 <= i12 + i11) {
            this.f2124s = i11 + i10;
        }
        C1498f c1498f = (C1498f) this.f2102N.f2353c;
        if (c1498f != null) {
            c1498f.m3619i(-1);
        }
    }

    @Override
    public final void onItemsChanged(RecyclerView recyclerView) {
        this.f2124s = 0;
        C1498f c1498f = (C1498f) this.f2102N.f2353c;
        if (c1498f != null) {
            c1498f.m3619i(-1);
        }
    }

    @Override
    public final void onItemsMoved(RecyclerView recyclerView, int i6, int i10, int i11) {
        int i12;
        int i13 = this.f2121p;
        if (i13 != -1 && (i12 = this.f2124s) != Integer.MIN_VALUE) {
            int i14 = i13 + i12;
            if (i6 <= i14 && i14 < i6 + i11) {
                this.f2124s = (i10 - i6) + i12;
            } else if (i6 < i14 && i10 > i14 - i11) {
                this.f2124s = i12 - i11;
            } else if (i6 > i14 && i10 < i14) {
                this.f2124s = i12 + i11;
            }
        }
        C1498f c1498f = (C1498f) this.f2102N.f2353c;
        if (c1498f != null) {
            c1498f.m3619i(-1);
        }
    }

    @Override
    public final void onItemsRemoved(RecyclerView recyclerView, int i6, int i10) {
        AbstractC0488p abstractC0488p;
        int i11;
        int i12;
        int i13 = this.f2121p;
        if (i13 != -1 && (abstractC0488p = this.f2095G) != null && abstractC0488p.f2382f >= 0 && (i11 = this.f2124s) != Integer.MIN_VALUE && i6 <= (i12 = i13 + i11)) {
            if (i6 + i10 > i12) {
                this.f2121p = (i6 - i12) + i11 + i13;
                this.f2124s = Integer.MIN_VALUE;
            } else {
                this.f2124s = i11 - i10;
            }
        }
        C1498f c1498f = (C1498f) this.f2102N.f2353c;
        if (c1498f != null) {
            c1498f.m3619i(-1);
        }
    }

    @Override
    public final void onItemsUpdated(RecyclerView recyclerView, int i6, int i10) {
        int i11 = i10 + i6;
        while (i6 < i11) {
            C0476j1 c0476j1 = this.f2102N;
            C1498f c1498f = (C1498f) c0476j1.f2353c;
            if (c1498f != null && c1498f.m3617g() != 0) {
                ((C1498f) c0476j1.f2353c).m3615e(Integer.toString(i6));
            }
            i6++;
        }
    }

    @Override
    public final void onLayoutChildren(C1140e1 c1140e1, C1162l1 c1162l1) {
        int i6;
        int i10;
        int i11;
        SparseIntArray sparseIntArray;
        View view;
        int i12;
        boolean z7;
        int i13;
        int i14;
        AbstractC0488p c0452b1;
        boolean z10;
        int i15;
        int width;
        int left;
        int right;
        int i16;
        List list;
        int size;
        SparseIntArray sparseIntArray2;
        AbstractC0488p abstractC0488p;
        int i17;
        int i18;
        C0486o c0486oMo1417k;
        int i19;
        C0486o c0486oMo1417k2;
        if (this.f2093E != 0 && c1162l1.m2970b() >= 0) {
            if ((this.f2119n & 64) != 0 && getChildCount() > 0) {
                this.f2119n |= 128;
                return;
            }
            int i20 = this.f2119n;
            if ((i20 & 512) == 0) {
                this.f2095G = null;
                this.f2129x = null;
                this.f2119n = i20 & (-1025);
                removeAndRecycleAllViews(c1140e1);
                return;
            }
            this.f2119n = (i20 & (-4)) | 1;
            m1351C(c1140e1, c1162l1);
            int iMax = Integer.MIN_VALUE;
            if (c1162l1.f3621g) {
                m1361M();
                int childCount = getChildCount();
                if (this.f2095G != null && childCount > 0) {
                    int oldPosition = this.f2108c.getChildViewHolder(getChildAt(0)).getOldPosition();
                    int oldPosition2 = this.f2108c.getChildViewHolder(getChildAt(childCount - 1)).getOldPosition();
                    int iMin = Integer.MAX_VALUE;
                    for (int i21 = 0; i21 < childCount; i21++) {
                        View childAt = getChildAt(i21);
                        C0496t c0496t = (C0496t) childAt.getLayoutParams();
                        int childAdapterPosition = this.f2108c.getChildAdapterPosition(childAt);
                        if (c0496t.f3465a.isUpdated() || c0496t.f3465a.isRemoved() || childAt.isLayoutRequested() || ((!childAt.hasFocus() && this.f2121p == c0496t.f3465a.getAbsoluteAdapterPosition()) || ((childAt.hasFocus() && this.f2121p != c0496t.f3465a.getAbsoluteAdapterPosition()) || childAdapterPosition < oldPosition || childAdapterPosition > oldPosition2))) {
                            iMin = Math.min(iMin, this.f2110e.mo2886e(childAt));
                            iMax = Math.max(iMax, this.f2110e.mo2883b(childAt));
                        }
                    }
                    if (iMax > iMin) {
                        this.f2114i = iMax - iMin;
                    }
                    m1365d();
                    m1383w();
                }
                this.f2119n &= -4;
                m1381u();
                return;
            }
            boolean z11 = c1162l1.f3625k;
            SparseIntArray sparseIntArray3 = this.f2115j;
            if (z11) {
                sparseIntArray3.clear();
                int childCount2 = getChildCount();
                for (int i22 = 0; i22 < childCount2; i22++) {
                    int oldPosition3 = this.f2108c.getChildViewHolder(getChildAt(i22)).getOldPosition();
                    if (oldPosition3 >= 0 && (c0486oMo1417k2 = this.f2095G.mo1417k(oldPosition3)) != null) {
                        sparseIntArray3.put(oldPosition3, c0486oMo1417k2.f2374a);
                    }
                }
            }
            boolean z12 = !isSmoothScrolling() && this.f2096H == 0;
            int i23 = this.f2121p;
            if (i23 != -1 && (i19 = this.f2124s) != Integer.MIN_VALUE) {
                this.f2121p = i23 + i19;
            }
            this.f2124s = 0;
            View viewFindViewByPosition = findViewByPosition(this.f2121p);
            int i24 = this.f2121p;
            boolean zHasFocus = this.f2108c.hasFocus();
            AbstractC0488p abstractC0488p2 = this.f2095G;
            int i25 = abstractC0488p2 != null ? abstractC0488p2.f2382f : -1;
            int i26 = abstractC0488p2 != null ? abstractC0488p2.f2383g : -1;
            if (this.f2109d == 0) {
                i10 = c1162l1.f3629o;
                i6 = c1162l1.f3630p;
            } else {
                i6 = c1162l1.f3629o;
                i10 = c1162l1.f3630p;
            }
            int i27 = i10;
            int i28 = i6;
            int i29 = i27;
            int iM2970b = this.f2112g.m2970b();
            if (iM2970b == 0) {
                this.f2121p = -1;
            } else {
                int i30 = this.f2121p;
                if (i30 >= iM2970b) {
                    this.f2121p = iM2970b - 1;
                } else if (i30 == -1 && iM2970b > 0) {
                    this.f2121p = 0;
                }
            }
            boolean z13 = this.f2112g.f3620f;
            C0023f c0023f = this.f2097I;
            if (z13 || (abstractC0488p = this.f2095G) == null || abstractC0488p.f2382f < 0 || (this.f2119n & 256) != 0 || abstractC0488p.f2381e != this.f2093E) {
                i11 = i29;
                sparseIntArray = sparseIntArray3;
                view = viewFindViewByPosition;
                i12 = i24;
                z7 = zHasFocus;
                i13 = i28;
                int i31 = this.f2119n;
                this.f2119n = i31 & (-257);
                AbstractC0488p abstractC0488p3 = this.f2095G;
                if (abstractC0488p3 == null || this.f2093E != abstractC0488p3.f2381e) {
                    i14 = this.f2093E;
                    if (i14 == 1) {
                        c0452b1 = new C0452b1();
                    } else {
                        C0461e1 c0461e1 = new C0461e1();
                        C3343g c3343g = new C3343g();
                        int iHighestOneBit = Integer.bitCount(64) != 1 ? Integer.highestOneBit(63) << 1 : 64;
                        c3343g.f11320c = iHighestOneBit - 1;
                        c3343g.f11321d = new Object[iHighestOneBit];
                        c0461e1.f2327j = c3343g;
                        c0461e1.f2328k = -1;
                        c0461e1.m1454n(i14);
                        c0452b1 = c0461e1;
                    }
                    this.f2095G = c0452b1;
                    c0452b1.f2378b = this.f2105Q;
                    if ((this.f2119n & 262144) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    c0452b1.f2379c = z10;
                } else if (((i31 & 262144) != 0) != abstractC0488p3.f2379c) {
                    i14 = this.f2093E;
                    if (i14 == 1) {
                        c0452b1 = new C0452b1();
                    } else {
                        C0461e1 c0461e2 = new C0461e1();
                        C3343g c3343g2 = new C3343g();
                        if (Integer.bitCount(64) != 1) {
                        }
                        c3343g2.f11320c = iHighestOneBit - 1;
                        c3343g2.f11321d = new Object[iHighestOneBit];
                        c0461e2.f2327j = c3343g2;
                        c0461e2.f2328k = -1;
                        c0461e2.m1454n(i14);
                        c0452b1 = c0461e2;
                    }
                    this.f2095G = c0452b1;
                    c0452b1.f2378b = this.f2105Q;
                    if ((this.f2119n & 262144) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    c0452b1.f2379c = z10;
                }
                C0479k1 c0479k1 = (C0479k1) c0023f.f46d;
                c0479k1.f2355b = Integer.MIN_VALUE;
                c0479k1.f2354a = Integer.MAX_VALUE;
                int width2 = getWidth();
                C0479k1 c0479k2 = (C0479k1) c0023f.f45c;
                c0479k2.f2362i = width2;
                int height = getHeight();
                C0479k1 c0479k3 = (C0479k1) c0023f.f44b;
                c0479k3.f2362i = height;
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                c0479k2.f2363j = paddingLeft;
                c0479k2.f2364k = paddingRight;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                c0479k3.f2363j = paddingTop;
                c0479k3.f2364k = paddingBottom;
                this.f2099K = ((C0479k1) c0023f.f46d).f2362i;
                this.f2126u = 0;
                m1364P();
                this.f2095G.f2380d = this.f2090B;
                detachAndScrapAttachedViews(this.f2118m);
                AbstractC0488p abstractC0488p4 = this.f2095G;
                abstractC0488p4.f2383g = -1;
                abstractC0488p4.f2382f = -1;
                C0479k1 c0479k4 = (C0479k1) c0023f.f46d;
                c0479k4.f2355b = Integer.MIN_VALUE;
                c0479k4.f2357d = Integer.MIN_VALUE;
                c0479k4.f2354a = Integer.MAX_VALUE;
                c0479k4.f2356c = Integer.MAX_VALUE;
                int i32 = this.f2119n;
                this.f2119n = i32 & (-5);
                this.f2119n = (i32 & (-21)) | (z12 ? 16 : 0);
                if (z12 && (i25 < 0 || (i15 = this.f2121p) > i26 || i15 < i25)) {
                    i25 = this.f2121p;
                    i26 = i25;
                }
                abstractC0488p4.f2385i = i25;
                if (i26 != -1) {
                    while (this.f2095G.m1449a() && findViewByPosition(i26) == null) {
                    }
                }
            } else {
                ((C0479k1) c0023f.f45c).f2362i = getWidth();
                int height2 = getHeight();
                C0479k1 c0479k5 = (C0479k1) c0023f.f44b;
                c0479k5.f2362i = height2;
                int paddingLeft2 = getPaddingLeft();
                int paddingRight2 = getPaddingRight();
                C0479k1 c0479k6 = (C0479k1) c0023f.f45c;
                c0479k6.f2363j = paddingLeft2;
                c0479k6.f2364k = paddingRight2;
                int paddingTop2 = getPaddingTop();
                int paddingBottom2 = getPaddingBottom();
                c0479k5.f2363j = paddingTop2;
                c0479k5.f2364k = paddingBottom2;
                this.f2099K = ((C0479k1) c0023f.f46d).f2362i;
                m1364P();
                AbstractC0488p abstractC0488p5 = this.f2095G;
                abstractC0488p5.f2380d = this.f2090B;
                this.f2119n |= 4;
                abstractC0488p5.f2385i = this.f2121p;
                int childCount3 = getChildCount();
                int i33 = this.f2095G.f2382f;
                this.f2119n &= -9;
                int i34 = i33;
                int i35 = 0;
                while (true) {
                    if (i35 < childCount3) {
                        View childAt2 = getChildAt(i35);
                        if (i34 == m1348h(childAt2) && (c0486oMo1417k = this.f2095G.mo1417k(i34)) != null) {
                            int i36 = i29;
                            int iM1373m = (m1373m(c0486oMo1417k.f2374a) + ((C0479k1) c0023f.f47e).f2363j) - this.f2126u;
                            int iMo2886e = this.f2110e.mo2886e(childAt2);
                            C0023f c0023f2 = c0023f;
                            Rect rect = f2087R;
                            getDecoratedBoundsWithMargins(childAt2, rect);
                            view = viewFindViewByPosition;
                            int iWidth = this.f2109d == 0 ? rect.width() : rect.height();
                            if (((C0496t) childAt2.getLayoutParams()).f3465a.needsUpdate()) {
                                this.f2119n |= 8;
                                detachAndScrapView(childAt2, this.f2118m);
                                childAt2 = m1376p(i34);
                                addView(childAt2, i35);
                            }
                            View view2 = childAt2;
                            m1382v(view2);
                            int iM1370j = this.f2109d == 0 ? m1370j(view2) : m1369i(view2);
                            i12 = i24;
                            int i37 = iM1370j;
                            sparseIntArray = sparseIntArray3;
                            i11 = i36;
                            z7 = zHasFocus;
                            i17 = i35;
                            i13 = i28;
                            i18 = i34;
                            m1380t(view2, c0486oMo1417k.f2374a, iMo2886e, iMo2886e + iM1370j, iM1373m);
                            if (iWidth == i37) {
                                i35 = i17 + 1;
                                i34 = i18 + 1;
                                i29 = i11;
                                c0023f = c0023f2;
                                zHasFocus = z7;
                                i28 = i13;
                                viewFindViewByPosition = view;
                                i24 = i12;
                                sparseIntArray3 = sparseIntArray;
                            }
                        } else {
                            i11 = i29;
                            sparseIntArray = sparseIntArray3;
                            view = viewFindViewByPosition;
                            i12 = i24;
                            z7 = zHasFocus;
                            i13 = i28;
                            i17 = i35;
                            i18 = i34;
                        }
                        int i38 = this.f2095G.f2383g;
                        for (int i39 = childCount3 - 1; i39 >= i17; i39--) {
                            detachAndScrapView(getChildAt(i39), this.f2118m);
                        }
                        this.f2095G.mo1426l(i18);
                        if ((this.f2119n & C0565C.DEFAULT_BUFFER_SEGMENT_SIZE) != 0) {
                            m1365d();
                            int i40 = this.f2121p;
                            if (i40 >= 0 && i40 <= i38) {
                                while (true) {
                                    AbstractC0488p abstractC0488p6 = this.f2095G;
                                    if (abstractC0488p6.f2383g >= this.f2121p) {
                                        break;
                                    } else {
                                        abstractC0488p6.m1449a();
                                    }
                                }
                            }
                        } else {
                            while (this.f2095G.m1449a() && this.f2095G.f2383g < i38) {
                            }
                        }
                    } else {
                        i11 = i29;
                        sparseIntArray = sparseIntArray3;
                        view = viewFindViewByPosition;
                        i12 = i24;
                        z7 = zHasFocus;
                        i13 = i28;
                    }
                    m1363O();
                    m1364P();
                }
            }
            while (true) {
                m1363O();
                AbstractC0488p abstractC0488p7 = this.f2095G;
                int i41 = abstractC0488p7.f2382f;
                int i42 = abstractC0488p7.f2383g;
                int i43 = -i11;
                int i44 = i13;
                int i45 = -i44;
                View viewFindViewByPosition2 = findViewByPosition(this.f2121p);
                if (viewFindViewByPosition2 != null && z12) {
                    m1355G(viewFindViewByPosition2, viewFindViewByPosition2.findFocus(), false, i43, i45);
                }
                if (viewFindViewByPosition2 != null && z7 && !viewFindViewByPosition2.hasFocus()) {
                    viewFindViewByPosition2.requestFocus();
                } else if (!z7 && !this.f2108c.hasFocus()) {
                    if (viewFindViewByPosition2 == null || !viewFindViewByPosition2.hasFocusable()) {
                        int childCount4 = getChildCount();
                        for (int i46 = 0; i46 < childCount4; i46++) {
                            viewFindViewByPosition2 = getChildAt(i46);
                            if (viewFindViewByPosition2 != null && viewFindViewByPosition2.hasFocusable()) {
                                this.f2108c.focusableViewAvailable(viewFindViewByPosition2);
                                break;
                            }
                        }
                    } else {
                        this.f2108c.focusableViewAvailable(viewFindViewByPosition2);
                    }
                    View view3 = viewFindViewByPosition2;
                    if (z12 && view3 != null && view3.hasFocus()) {
                        m1355G(view3, view3.findFocus(), false, i43, i45);
                    }
                }
                m1365d();
                m1383w();
                AbstractC0488p abstractC0488p8 = this.f2095G;
                if (abstractC0488p8.f2382f == i41 && abstractC0488p8.f2383g == i42) {
                    break;
                } else {
                    i13 = i44;
                }
            }
            m1350B();
            m1349A();
            if (c1162l1.f3625k && (size = (list = this.f2118m.f3552d).size()) != 0) {
                int[] iArr = this.f2116k;
                if (iArr == null || size > iArr.length) {
                    int length = iArr == null ? 16 : iArr.length;
                    while (length < size) {
                        length <<= 1;
                    }
                    this.f2116k = new int[length];
                }
                int i47 = 0;
                for (int i48 = 0; i48 < size; i48++) {
                    int absoluteAdapterPosition = ((AbstractC1174p1) list.get(i48)).getAbsoluteAdapterPosition();
                    if (absoluteAdapterPosition >= 0) {
                        this.f2116k[i47] = absoluteAdapterPosition;
                        i47++;
                    }
                }
                if (i47 > 0) {
                    Arrays.sort(this.f2116k, 0, i47);
                    AbstractC0488p abstractC0488p9 = this.f2095G;
                    int[] iArr2 = this.f2116k;
                    int i49 = abstractC0488p9.f2383g;
                    int iBinarySearch = i49 >= 0 ? Arrays.binarySearch(iArr2, 0, i47, i49) : 0;
                    Object[] objArr = abstractC0488p9.f2377a;
                    if (iBinarySearch < 0) {
                        int i50 = (-iBinarySearch) - 1;
                        int iM1470d = abstractC0488p9.f2379c ? (abstractC0488p9.f2378b.m1470d(i49) - abstractC0488p9.f2378b.m1471e(i49)) - abstractC0488p9.f2380d : abstractC0488p9.f2380d + abstractC0488p9.f2378b.m1471e(i49) + abstractC0488p9.f2378b.m1470d(i49);
                        while (i50 < i47) {
                            int i51 = iArr2[i50];
                            SparseIntArray sparseIntArray4 = sparseIntArray;
                            int i52 = sparseIntArray4.get(i51);
                            int i53 = i52 < 0 ? 0 : i52;
                            int iM1468b = abstractC0488p9.f2378b.m1468b(i51, true, objArr, true);
                            abstractC0488p9.f2378b.m1467a(objArr[0], i51, iM1468b, i53, iM1470d);
                            iM1470d = abstractC0488p9.f2379c ? (iM1470d - iM1468b) - abstractC0488p9.f2380d : iM1470d + iM1468b + abstractC0488p9.f2380d;
                            i50++;
                            sparseIntArray = sparseIntArray4;
                        }
                    }
                    sparseIntArray2 = sparseIntArray;
                    int i54 = abstractC0488p9.f2382f;
                    int iBinarySearch2 = i54 >= 0 ? Arrays.binarySearch(iArr2, 0, i47, i54) : 0;
                    if (iBinarySearch2 < 0) {
                        int iM1470d2 = abstractC0488p9.f2379c ? abstractC0488p9.f2378b.m1470d(i54) : abstractC0488p9.f2378b.m1470d(i54);
                        for (int i55 = (-iBinarySearch2) - 2; i55 >= 0; i55--) {
                            int i56 = iArr2[i55];
                            int i57 = sparseIntArray2.get(i56);
                            int i58 = i57 < 0 ? 0 : i57;
                            int iM1468b2 = abstractC0488p9.f2378b.m1468b(i56, false, objArr, true);
                            iM1470d2 = abstractC0488p9.f2379c ? iM1470d2 + abstractC0488p9.f2380d + iM1468b2 : (iM1470d2 - abstractC0488p9.f2380d) - iM1468b2;
                            abstractC0488p9.f2378b.m1467a(objArr[0], i56, iM1468b2, i58, iM1470d2);
                        }
                    }
                } else {
                    sparseIntArray2 = sparseIntArray;
                }
                sparseIntArray2.clear();
            }
            int i59 = this.f2119n;
            if ((i59 & 1024) != 0) {
                this.f2119n = i59 & (-1025);
            } else {
                m1362N();
            }
            if (((this.f2119n & 4) != 0 && ((i16 = this.f2121p) != i12 || findViewByPosition(i16) != view || (this.f2119n & 8) != 0)) || (this.f2119n & 20) == 16) {
                m1366e();
            }
            m1367f();
            int i60 = this.f2119n;
            if ((i60 & 64) != 0) {
                if (this.f2109d == 1) {
                    width = -getHeight();
                    if (getChildCount() > 0 && (left = getChildAt(0).getTop()) < 0) {
                        width += left;
                    }
                } else if ((i60 & 262144) != 0) {
                    width = getWidth();
                    if (getChildCount() > 0 && (right = getChildAt(0).getRight()) > width) {
                        width = right;
                    }
                } else {
                    width = -getWidth();
                    if (getChildCount() > 0 && (left = getChildAt(0).getLeft()) < 0) {
                        width += left;
                    }
                }
                m1352D(width);
            }
            this.f2119n &= -4;
            m1381u();
        }
    }

    @Override
    public final void onMeasure(C1140e1 c1140e1, C1162l1 c1162l1, int i6, int i10) {
        int size;
        int size2;
        int mode;
        int paddingLeft;
        int paddingRight;
        int iM1375o;
        m1351C(c1140e1, c1162l1);
        if (this.f2109d == 0) {
            size2 = View.MeasureSpec.getSize(i6);
            size = View.MeasureSpec.getSize(i10);
            mode = View.MeasureSpec.getMode(i10);
            paddingLeft = getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            size = View.MeasureSpec.getSize(i6);
            size2 = View.MeasureSpec.getSize(i10);
            mode = View.MeasureSpec.getMode(i6);
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        int i11 = paddingRight + paddingLeft;
        this.f2130y = size;
        int i12 = this.f2127v;
        if (i12 == -2) {
            int i13 = this.f2094F;
            if (i13 == 0) {
                i13 = 1;
            }
            this.f2093E = i13;
            this.f2128w = 0;
            int[] iArr = this.f2129x;
            if (iArr == null || iArr.length != i13) {
                this.f2129x = new int[i13];
            }
            if (this.f2112g.f3621g) {
                m1361M();
            }
            m1385y(true);
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(m1375o() + i11, this.f2130y);
            } else if (mode == 0) {
                iM1375o = m1375o();
                size = iM1375o + i11;
            } else {
                if (mode != 1073741824) {
                    throw new IllegalStateException("wrong spec");
                }
                size = this.f2130y;
            }
        } else {
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    if (i12 == 0) {
                        i12 = size - i11;
                    }
                    this.f2128w = i12;
                    int i14 = this.f2094F;
                    if (i14 == 0) {
                        i14 = 1;
                    }
                    this.f2093E = i14;
                    iM1375o = ((i14 - 1) * this.f2091C) + (i12 * i14);
                    size = iM1375o + i11;
                } else if (mode != 1073741824) {
                    throw new IllegalStateException("wrong spec");
                }
            }
            int i15 = this.f2094F;
            if (i15 == 0 && i12 == 0) {
                this.f2093E = 1;
                this.f2128w = size - i11;
            } else if (i15 == 0) {
                this.f2128w = i12;
                int i16 = this.f2091C;
                this.f2093E = (size + i16) / (i12 + i16);
            } else if (i12 == 0) {
                this.f2093E = i15;
                this.f2128w = ((size - i11) - ((i15 - 1) * this.f2091C)) / i15;
            } else {
                this.f2093E = i15;
                this.f2128w = i12;
            }
            if (mode == Integer.MIN_VALUE) {
                int i17 = this.f2128w;
                int i18 = this.f2093E;
                int i19 = ((i18 - 1) * this.f2091C) + (i17 * i18) + i11;
                if (i19 < size) {
                    size = i19;
                }
            }
        }
        if (this.f2109d == 0) {
            setMeasuredDimension(size2, size);
        } else {
            setMeasuredDimension(size, size2);
        }
        m1381u();
    }

    @Override
    public final boolean onRequestChildFocus(RecyclerView recyclerView, C1162l1 c1162l1, View view, View view2) {
        if ((this.f2119n & 32768) == 0 && m1348h(view) != -1 && (this.f2119n & 35) == 0) {
            m1355G(view, view2, true, 0, 0);
        }
        return true;
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f2121p = savedState.f2132a;
            this.f2124s = 0;
            Bundle bundle = savedState.f2133b;
            C0476j1 c0476j1 = this.f2102N;
            C1498f c1498f = (C1498f) c0476j1.f2353c;
            if (c1498f != null && bundle != null) {
                c1498f.m3619i(-1);
                for (String str : bundle.keySet()) {
                    ((C1498f) c0476j1.f2353c).m3614d(str, bundle.getSparseParcelableArray(str));
                }
            }
            this.f2119n |= 256;
            requestLayout();
        }
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        Bundle bundle;
        SavedState savedState = new SavedState();
        savedState.f2133b = Bundle.EMPTY;
        savedState.f2132a = this.f2121p;
        C0476j1 c0476j1 = this.f2102N;
        C1498f c1498f = (C1498f) c0476j1.f2353c;
        if (c1498f == null || c1498f.m3617g() == 0) {
            bundle = null;
        } else {
            C1498f c1498f2 = (C1498f) c0476j1.f2353c;
            c1498f2.getClass();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            synchronized (((C3388b) c1498f2.f4831g)) {
                Set<Map.Entry> setEntrySet = ((C3066n) c1498f2.f4830f).f10511a.entrySet();
                AbstractC2796i.m5784e(setEntrySet, "map.entries");
                for (Map.Entry entry : setEntrySet) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            bundle = new Bundle();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                bundle.putSparseParcelableArray((String) entry2.getKey(), (SparseArray) entry2.getValue());
            }
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int iM1348h = m1348h(childAt);
            if (iM1348h != -1 && this.f2102N.f2351a != 0) {
                String string = Integer.toString(iM1348h);
                SparseArray<Parcelable> sparseArray = new SparseArray<>();
                childAt.saveHierarchyState(sparseArray);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray(string, sparseArray);
            }
        }
        savedState.f2133b = bundle;
        return savedState;
    }

    public final View m1376p(int i6) {
        View view = this.f2118m.m2935l(i6, Long.MAX_VALUE).itemView;
        C0496t c0496t = (C0496t) view.getLayoutParams();
        AbstractC1174p1 childViewHolder = this.f2108c.getChildViewHolder(view);
        if (childViewHolder instanceof InterfaceC0484n) {
            ((InterfaceC0484n) childViewHolder).mo1420a();
        }
        C0457d0 c0457d0 = this.f2103O;
        if (c0457d0 != null) {
            InterfaceC0484n interfaceC0484n = (InterfaceC0484n) c0457d0.f2324b.get(childViewHolder.getItemViewType());
            if (interfaceC0484n != null) {
                interfaceC0484n.mo1420a();
            }
        }
        c0496t.getClass();
        return view;
    }

    @Override
    public final boolean performAccessibilityAction(C1140e1 c1140e1, C1162l1 c1162l1, int i6, Bundle bundle) {
        if ((this.f2119n & 131072) != 0) {
            m1351C(c1140e1, c1162l1);
            boolean z7 = (this.f2119n & 262144) != 0;
            if (Build.VERSION.SDK_INT >= 23) {
                if (this.f2109d == 0) {
                    if (i6 == C3228c.f10851o.m6512a()) {
                        if (z7) {
                            i6 = 4096;
                        } else {
                            i6 = 8192;
                        }
                    } else if (i6 == C3228c.f10853q.m6512a()) {
                        if (z7) {
                            i6 = 8192;
                        } else {
                            i6 = 4096;
                        }
                    }
                } else if (i6 == C3228c.f10850n.m6512a()) {
                    i6 = 8192;
                } else if (i6 == C3228c.f10852p.m6512a()) {
                    i6 = 4096;
                }
            }
            int i10 = this.f2121p;
            boolean z10 = i10 == 0 && i6 == 8192;
            boolean z11 = i10 == c1162l1.m2970b() - 1 && i6 == 4096;
            if (z10 || z11) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(4096);
                this.f2108c.onInitializeAccessibilityEvent(accessibilityEventObtain);
                AbstractC0474j abstractC0474j = this.f2108c;
                abstractC0474j.requestSendAccessibilityEvent(abstractC0474j, accessibilityEventObtain);
            } else if (i6 == 4096) {
                m1384x(true);
                m1386z(1, false);
            } else if (i6 == 8192) {
                m1384x(false);
                m1386z(-1, false);
            }
            m1381u();
        }
        return true;
    }

    public final boolean m1377q() {
        return getItemCount() == 0 || this.f2108c.findViewHolderForAdapterPosition(0) != null;
    }

    public final boolean m1378r() {
        int itemCount = getItemCount();
        return itemCount == 0 || this.f2108c.findViewHolderForAdapterPosition(itemCount - 1) != null;
    }

    @Override
    public final void removeAndRecycleAllViews(C1140e1 c1140e1) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            removeAndRecycleViewAt(childCount, c1140e1);
        }
    }

    @Override
    public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z7) {
        return false;
    }

    public final boolean m1379s(int i6) {
        AbstractC1174p1 abstractC1174p1FindViewHolderForAdapterPosition = this.f2108c.findViewHolderForAdapterPosition(i6);
        return abstractC1174p1FindViewHolderForAdapterPosition != null && abstractC1174p1FindViewHolderForAdapterPosition.itemView.getLeft() >= 0 && abstractC1174p1FindViewHolderForAdapterPosition.itemView.getRight() <= this.f2108c.getWidth() && abstractC1174p1FindViewHolderForAdapterPosition.itemView.getTop() >= 0 && abstractC1174p1FindViewHolderForAdapterPosition.itemView.getBottom() <= this.f2108c.getHeight();
    }

    @Override
    public final int scrollHorizontallyBy(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        if ((this.f2119n & 512) == 0 || this.f2095G == null) {
            return 0;
        }
        m1351C(c1140e1, c1162l1);
        this.f2119n = (this.f2119n & (-4)) | 2;
        int iM1352D = this.f2109d == 0 ? m1352D(i6) : m1353E(i6);
        m1381u();
        this.f2119n &= -4;
        return iM1352D;
    }

    @Override
    public final void scrollToPosition(int i6) {
        m1358J(i6, false);
    }

    @Override
    public final int scrollVerticallyBy(int i6, C1140e1 c1140e1, C1162l1 c1162l1) {
        int i10 = this.f2119n;
        if ((i10 & 512) == 0 || this.f2095G == null) {
            return 0;
        }
        this.f2119n = (i10 & (-4)) | 2;
        m1351C(c1140e1, c1162l1);
        int iM1352D = this.f2109d == 1 ? m1352D(i6) : m1353E(i6);
        m1381u();
        this.f2119n &= -4;
        return iM1352D;
    }

    public final void setOrientation(int i6) {
        if (i6 == 0 || i6 == 1) {
            this.f2109d = i6;
            this.f2110e = AbstractC1135d0.m2921a(this, i6);
            C0023f c0023f = this.f2097I;
            c0023f.getClass();
            C0479k1 c0479k1 = (C0479k1) c0023f.f44b;
            C0479k1 c0479k2 = (C0479k1) c0023f.f45c;
            if (i6 == 0) {
                c0023f.f46d = c0479k2;
                c0023f.f47e = c0479k1;
            } else {
                c0023f.f46d = c0479k1;
                c0023f.f47e = c0479k2;
            }
            C0026b c0026b = this.f2098J;
            c0026b.getClass();
            if (i6 == 0) {
                c0026b.f56d = (C0508z) c0026b.f55c;
            } else {
                c0026b.f56d = (C0508z) c0026b.f54b;
            }
            this.f2119n |= 256;
        }
    }

    @Override
    public final void smoothScrollToPosition(RecyclerView recyclerView, C1162l1 c1162l1, int i6) {
        m1358J(i6, true);
    }

    @Override
    public final void startSmoothScroll(AbstractC1159k1 abstractC1159k1) {
        AbstractC0494s abstractC0494s = this.f2122q;
        if (abstractC0494s != null) {
            abstractC0494s.f2434a = true;
        }
        super.startSmoothScroll(abstractC1159k1);
        if (!abstractC1159k1.isRunning() || !(abstractC1159k1 instanceof AbstractC0494s)) {
            this.f2122q = null;
            this.f2123r = null;
            return;
        }
        AbstractC0494s abstractC0494s2 = (AbstractC0494s) abstractC1159k1;
        this.f2122q = abstractC0494s2;
        if (abstractC0494s2 instanceof C0498u) {
            this.f2123r = (C0498u) abstractC0494s2;
        } else {
            this.f2123r = null;
        }
    }

    @Override
    public final boolean supportsPredictiveItemAnimations() {
        return true;
    }

    public final void m1380t(View view, int i6, int i10, int i11, int i12) {
        int iM1372l;
        int i13;
        int iM1369i = this.f2109d == 0 ? m1369i(view) : m1370j(view);
        int i14 = this.f2128w;
        if (i14 > 0) {
            iM1369i = Math.min(iM1369i, i14);
        }
        int i15 = this.f2092D;
        int i16 = i15 & 112;
        int absoluteGravity = (this.f2119n & 786432) != 0 ? Gravity.getAbsoluteGravity(i15 & 8388615, 1) : i15 & 7;
        int i17 = this.f2109d;
        if ((i17 != 0 || i16 != 48) && (i17 != 1 || absoluteGravity != 3)) {
            if ((i17 == 0 && i16 == 80) || (i17 == 1 && absoluteGravity == 5)) {
                iM1372l = m1372l(i6) - iM1369i;
            } else if ((i17 == 0 && i16 == 16) || (i17 == 1 && absoluteGravity == 1)) {
                iM1372l = (m1372l(i6) - iM1369i) / 2;
            }
            i12 += iM1372l;
        }
        if (this.f2109d == 0) {
            i13 = iM1369i + i12;
        } else {
            int i18 = iM1369i + i12;
            int i19 = i12;
            i12 = i10;
            i10 = i19;
            i13 = i11;
            i11 = i18;
        }
        C0496t c0496t = (C0496t) view.getLayoutParams();
        layoutDecoratedWithMargins(view, i10, i12, i11, i13);
        Rect rect = f2087R;
        super.getDecoratedBoundsWithMargins(view, rect);
        int i20 = i10 - rect.left;
        int i21 = i12 - rect.top;
        int i22 = rect.right - i11;
        int i23 = rect.bottom - i13;
        c0496t.f2437e = i20;
        c0496t.f2438f = i21;
        c0496t.f2439g = i22;
        c0496t.f2440h = i23;
        m1360L(view);
    }

    public final void m1381u() {
        int i6 = this.f2111f - 1;
        this.f2111f = i6;
        if (i6 == 0) {
            this.f2118m = null;
            this.f2112g = null;
            this.f2113h = 0;
            this.f2114i = 0;
        }
    }

    public final void m1382v(View view) {
        int childMeasureSpec;
        int childMeasureSpec2;
        C0496t c0496t = (C0496t) view.getLayoutParams();
        Rect rect = f2087R;
        calculateItemDecorationsForChild(view, rect);
        int i6 = ((ViewGroup.MarginLayoutParams) c0496t).leftMargin + ((ViewGroup.MarginLayoutParams) c0496t).rightMargin + rect.left + rect.right;
        int i10 = ((ViewGroup.MarginLayoutParams) c0496t).topMargin + ((ViewGroup.MarginLayoutParams) c0496t).bottomMargin + rect.top + rect.bottom;
        int iMakeMeasureSpec = this.f2127v == -2 ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(this.f2128w, 1073741824);
        if (this.f2109d == 0) {
            childMeasureSpec = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i6, ((ViewGroup.MarginLayoutParams) c0496t).width);
            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, i10, ((ViewGroup.MarginLayoutParams) c0496t).height);
        } else {
            int childMeasureSpec3 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i10, ((ViewGroup.MarginLayoutParams) c0496t).height);
            childMeasureSpec = ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, i6, ((ViewGroup.MarginLayoutParams) c0496t).width);
            childMeasureSpec2 = childMeasureSpec3;
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final void m1383w() {
        this.f2095G.mo1418m((this.f2119n & 262144) != 0 ? this.f2099K + this.f2100L + this.f2114i : (-this.f2100L) - this.f2114i, false);
    }

    public final void m1384x(boolean z7) {
        int i6;
        if (z7) {
            if (m1378r()) {
                return;
            }
        } else if (m1377q()) {
            return;
        }
        C0498u c0498u = this.f2123r;
        if (c0498u == null) {
            C0498u c0498u2 = new C0498u(this, z7 ? 1 : -1, this.f2093E > 1);
            this.f2124s = 0;
            startSmoothScroll(c0498u2);
        } else {
            GridLayoutManager gridLayoutManager = c0498u.f2446e;
            if (z7) {
                int i10 = c0498u.f2445d;
                if (i10 < gridLayoutManager.f2107b) {
                    c0498u.f2445d = i10 + 1;
                }
            } else {
                int i11 = c0498u.f2445d;
                if (i11 > (-gridLayoutManager.f2107b)) {
                    c0498u.f2445d = i11 - 1;
                }
            }
        }
        if (this.f2109d == 0) {
            i6 = 4;
            if (getLayoutDirection() != 1 ? !z7 : z7) {
                i6 = 3;
            }
        } else {
            i6 = z7 ? 2 : 1;
        }
        if (this.f2117l == null) {
            this.f2117l = (AudioManager) this.f2108c.getContext().getSystemService("audio");
        }
        this.f2117l.playSoundEffect(i6);
    }

    public final boolean m1385y(boolean z7) {
        if (this.f2128w != 0 || this.f2129x == null) {
            return false;
        }
        AbstractC0488p abstractC0488p = this.f2095G;
        C3344h[] c3344hArrMo1416j = abstractC0488p == null ? null : abstractC0488p.mo1416j(abstractC0488p.f2382f, abstractC0488p.f2383g);
        boolean z10 = false;
        int i6 = -1;
        for (int i10 = 0; i10 < this.f2093E; i10++) {
            C3344h c3344h = c3344hArrMo1416j == null ? null : c3344hArrMo1416j[i10];
            int iM6793c = c3344h == null ? 0 : c3344h.m6793c();
            int i11 = -1;
            for (int i12 = 0; i12 < iM6793c; i12 += 2) {
                int iM6792b = c3344h.m6792b(i12 + 1);
                for (int iM6792b2 = c3344h.m6792b(i12); iM6792b2 <= iM6792b; iM6792b2++) {
                    View viewFindViewByPosition = findViewByPosition(iM6792b2 - this.f2113h);
                    if (viewFindViewByPosition != null) {
                        if (z7) {
                            m1382v(viewFindViewByPosition);
                        }
                        int iM1369i = this.f2109d == 0 ? m1369i(viewFindViewByPosition) : m1370j(viewFindViewByPosition);
                        if (iM1369i > i11) {
                            i11 = iM1369i;
                        }
                    }
                }
            }
            int iM2970b = this.f2112g.m2970b();
            if (!this.f2108c.hasFixedSize() && z7 && i11 < 0 && iM2970b > 0) {
                if (i6 < 0) {
                    int i13 = this.f2121p;
                    if (i13 < 0) {
                        i13 = 0;
                    } else if (i13 >= iM2970b) {
                        i13 = iM2970b - 1;
                    }
                    if (getChildCount() > 0) {
                        int layoutPosition = this.f2108c.getChildViewHolder(getChildAt(0)).getLayoutPosition();
                        int layoutPosition2 = this.f2108c.getChildViewHolder(getChildAt(getChildCount() - 1)).getLayoutPosition();
                        if (i13 >= layoutPosition && i13 <= layoutPosition2) {
                            i13 = i13 - layoutPosition <= layoutPosition2 - i13 ? layoutPosition - 1 : layoutPosition2 + 1;
                            if (i13 < 0 && layoutPosition2 < iM2970b - 1) {
                                i13 = layoutPosition2 + 1;
                            } else if (i13 >= iM2970b && layoutPosition > 0) {
                                i13 = layoutPosition - 1;
                            }
                        }
                    }
                    if (i13 >= 0 && i13 < iM2970b) {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                        View view = this.f2118m.m2935l(i13, Long.MAX_VALUE).itemView;
                        int[] iArr = this.f2101M;
                        if (view != null) {
                            C0496t c0496t = (C0496t) view.getLayoutParams();
                            Rect rect = f2087R;
                            calculateItemDecorationsForChild(view, rect);
                            view.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0496t).leftMargin + ((ViewGroup.MarginLayoutParams) c0496t).rightMargin + rect.left + rect.right, ((ViewGroup.MarginLayoutParams) c0496t).width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0496t).topMargin + ((ViewGroup.MarginLayoutParams) c0496t).bottomMargin + rect.top + rect.bottom, ((ViewGroup.MarginLayoutParams) c0496t).height));
                            iArr[0] = m1370j(view);
                            iArr[1] = m1369i(view);
                            this.f2118m.m2932i(view);
                        }
                        i6 = this.f2109d == 0 ? iArr[1] : iArr[0];
                    }
                }
                if (i6 >= 0) {
                    i11 = i6;
                }
            }
            if (i11 < 0) {
                i11 = 0;
            }
            int[] iArr2 = this.f2129x;
            if (iArr2[i10] != i11) {
                iArr2[i10] = i11;
                z10 = true;
            }
        }
        return z10;
    }

    public final int m1386z(int i6, boolean z7) {
        C0486o c0486oMo1417k;
        AbstractC0488p abstractC0488p = this.f2095G;
        if (abstractC0488p == null) {
            return i6;
        }
        int i10 = this.f2121p;
        int i11 = (i10 == -1 || (c0486oMo1417k = abstractC0488p.mo1417k(i10)) == null) ? -1 : c0486oMo1417k.f2374a;
        int childCount = getChildCount();
        View view = null;
        for (int i12 = 0; i12 < childCount && i6 != 0; i12++) {
            int i13 = i6 > 0 ? i12 : (childCount - 1) - i12;
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 0 && (!hasFocus() || childAt.hasFocusable())) {
                int iM1348h = m1348h(getChildAt(i13));
                C0486o c0486oMo1417k2 = this.f2095G.mo1417k(iM1348h);
                int i14 = c0486oMo1417k2 == null ? -1 : c0486oMo1417k2.f2374a;
                if (i11 == -1) {
                    i10 = iM1348h;
                    view = childAt;
                    i11 = i14;
                } else if (i14 == i11 && ((i6 > 0 && iM1348h > i10) || (i6 < 0 && iM1348h < i10))) {
                    i6 = i6 > 0 ? i6 - 1 : i6 + 1;
                    i10 = iM1348h;
                    view = childAt;
                }
            }
        }
        if (view != null) {
            if (z7) {
                if (hasFocus()) {
                    this.f2119n |= 32;
                    view.requestFocus();
                    this.f2119n &= -33;
                }
                this.f2121p = i10;
            } else {
                m1356H(view, true);
            }
        }
        return i6;
    }

    public GridLayoutManager(AbstractC0474j abstractC0474j) {
        this.f2106a = 1.0f;
        this.f2107b = 10;
        this.f2109d = 0;
        this.f2110e = new C1127b0(this);
        this.f2115j = new SparseIntArray();
        this.f2119n = 221696;
        this.f2120o = null;
        this.f2121p = -1;
        this.f2124s = 0;
        this.f2092D = 8388659;
        this.f2094F = 1;
        this.f2096H = 0;
        this.f2097I = new C0023f(1);
        this.f2098J = new C0026b(9);
        this.f2101M = new int[2];
        C0476j1 c0476j1 = new C0476j1();
        c0476j1.f2351a = 0;
        c0476j1.f2352b = 100;
        this.f2102N = c0476j1;
        this.f2104P = new RunnableC0447a(1, this);
        this.f2105Q = new C0490q(this);
        this.f2108c = abstractC0474j;
        this.f2125t = -1;
        setItemPrefetchEnabled(false);
    }

    @Override
    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0496t) {
            return new C0496t((C0496t) layoutParams);
        }
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            return new C0496t((RecyclerView.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0496t((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0496t(layoutParams);
    }

    @Override
    public final void onLayoutCompleted(C1162l1 c1162l1) {
    }
}

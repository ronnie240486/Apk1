package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;
import p055ea.AbstractC2460q;

public final class C1201y1 {

    public final ArrayList f3742a = new ArrayList();

    public int f3743b = Integer.MIN_VALUE;

    public int f3744c = Integer.MIN_VALUE;

    public int f3745d = 0;

    public final int f3746e;

    public final StaggeredGridLayoutManager f3747f;

    public C1201y1(StaggeredGridLayoutManager staggeredGridLayoutManager, int i6) {
        this.f3747f = staggeredGridLayoutManager;
        this.f3746e = i6;
    }

    public final void m3013a(View view) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.f3494e = this;
        ArrayList arrayList = this.f3742a;
        arrayList.add(view);
        this.f3744c = Integer.MIN_VALUE;
        if (arrayList.size() == 1) {
            this.f3743b = Integer.MIN_VALUE;
        }
        if (layoutParams.f3465a.isRemoved() || layoutParams.f3465a.isUpdated()) {
            this.f3745d = this.f3747f.f3472c.mo2884c(view) + this.f3745d;
        }
    }

    public final void m3014b() {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f;
        View view = (View) AbstractC2460q.m5491e(1, this.f3742a);
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f3747f;
        this.f3744c = staggeredGridLayoutManager.f3472c.mo2883b(view);
        if (layoutParams.f3495f && (staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f = staggeredGridLayoutManager.f3482m.m3004f(layoutParams.f3465a.getLayoutPosition())) != null && staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f.f3497b == 1) {
            int i6 = this.f3744c;
            int[] iArr = staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f.f3498c;
            this.f3744c = i6 + (iArr == null ? 0 : iArr[this.f3746e]);
        }
    }

    public final void m3015c() {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f;
        View view = (View) this.f3742a.get(0);
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f3747f;
        this.f3743b = staggeredGridLayoutManager.f3472c.mo2886e(view);
        if (layoutParams.f3495f && (staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f = staggeredGridLayoutManager.f3482m.m3004f(layoutParams.f3465a.getLayoutPosition())) != null && staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f.f3497b == -1) {
            int i6 = this.f3743b;
            int[] iArr = staggeredGridLayoutManager$LazySpanLookup$FullSpanItemM3004f.f3498c;
            this.f3743b = i6 - (iArr != null ? iArr[this.f3746e] : 0);
        }
    }

    public final void m3016d() {
        this.f3742a.clear();
        this.f3743b = Integer.MIN_VALUE;
        this.f3744c = Integer.MIN_VALUE;
        this.f3745d = 0;
    }

    public final int m3017e() {
        boolean z7 = this.f3747f.f3477h;
        ArrayList arrayList = this.f3742a;
        return z7 ? m3019g(arrayList.size() - 1, -1) : m3019g(0, arrayList.size());
    }

    public final int m3018f() {
        boolean z7 = this.f3747f.f3477h;
        ArrayList arrayList = this.f3742a;
        return z7 ? m3019g(0, arrayList.size()) : m3019g(arrayList.size() - 1, -1);
    }

    public final int m3019g(int i6, int i10) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f3747f;
        int iMo2892k = staggeredGridLayoutManager.f3472c.mo2892k();
        int iMo2888g = staggeredGridLayoutManager.f3472c.mo2888g();
        int i11 = i10 > i6 ? 1 : -1;
        while (i6 != i10) {
            View view = (View) this.f3742a.get(i6);
            int iMo2886e = staggeredGridLayoutManager.f3472c.mo2886e(view);
            int iMo2883b = staggeredGridLayoutManager.f3472c.mo2883b(view);
            boolean z7 = iMo2886e <= iMo2888g;
            boolean z10 = iMo2883b >= iMo2892k;
            if (z7 && z10 && (iMo2886e < iMo2892k || iMo2883b > iMo2888g)) {
                return staggeredGridLayoutManager.getPosition(view);
            }
            i6 += i11;
        }
        return -1;
    }

    public final int m3020h(int i6) {
        int i10 = this.f3744c;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (this.f3742a.size() == 0) {
            return i6;
        }
        m3014b();
        return this.f3744c;
    }

    public final View m3021i(int i6, int i10) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f3747f;
        ArrayList arrayList = this.f3742a;
        View view = null;
        if (i10 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f3477h && staggeredGridLayoutManager.getPosition(view2) >= i6) || ((!staggeredGridLayoutManager.f3477h && staggeredGridLayoutManager.getPosition(view2) <= i6) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
        } else {
            int size2 = arrayList.size();
            int i11 = 0;
            while (i11 < size2) {
                View view3 = (View) arrayList.get(i11);
                if ((staggeredGridLayoutManager.f3477h && staggeredGridLayoutManager.getPosition(view3) <= i6) || ((!staggeredGridLayoutManager.f3477h && staggeredGridLayoutManager.getPosition(view3) >= i6) || !view3.hasFocusable())) {
                    break;
                }
                i11++;
                view = view3;
            }
        }
        return view;
    }

    public final int m3022j(int i6) {
        int i10 = this.f3743b;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (this.f3742a.size() == 0) {
            return i6;
        }
        m3015c();
        return this.f3743b;
    }

    public final void m3023k() {
        ArrayList arrayList = this.f3742a;
        int size = arrayList.size();
        View view = (View) arrayList.remove(size - 1);
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.f3494e = null;
        if (layoutParams.f3465a.isRemoved() || layoutParams.f3465a.isUpdated()) {
            this.f3745d -= this.f3747f.f3472c.mo2884c(view);
        }
        if (size == 1) {
            this.f3743b = Integer.MIN_VALUE;
        }
        this.f3744c = Integer.MIN_VALUE;
    }

    public final void m3024l() {
        ArrayList arrayList = this.f3742a;
        View view = (View) arrayList.remove(0);
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.f3494e = null;
        if (arrayList.size() == 0) {
            this.f3744c = Integer.MIN_VALUE;
        }
        if (layoutParams.f3465a.isRemoved() || layoutParams.f3465a.isUpdated()) {
            this.f3745d -= this.f3747f.f3472c.mo2884c(view);
        }
        this.f3743b = Integer.MIN_VALUE;
    }

    public final void m3025m(View view) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.f3494e = this;
        ArrayList arrayList = this.f3742a;
        arrayList.add(0, view);
        this.f3743b = Integer.MIN_VALUE;
        if (arrayList.size() == 1) {
            this.f3744c = Integer.MIN_VALUE;
        }
        if (layoutParams.f3465a.isRemoved() || layoutParams.f3465a.isUpdated()) {
            this.f3745d = this.f3747f.f3472c.mo2884c(view) + this.f3745d;
        }
    }
}

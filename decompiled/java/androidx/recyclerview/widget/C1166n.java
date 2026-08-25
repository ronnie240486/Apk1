package androidx.recyclerview.widget;

public final class C1166n extends AbstractC1128b1 {

    public final C1172p f3633a;

    public C1166n(C1172p c1172p) {
        this.f3633a = c1172p;
    }

    @Override
    public final void onScrolled(RecyclerView recyclerView, int i6, int i10) {
        int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        C1172p c1172p = this.f3633a;
        int iComputeVerticalScrollRange = c1172p.f3664s.computeVerticalScrollRange();
        int i11 = c1172p.f3663r;
        int i12 = iComputeVerticalScrollRange - i11;
        int i13 = c1172p.f3646a;
        c1172p.f3665t = i12 > 0 && i11 >= i13;
        int iComputeHorizontalScrollRange = c1172p.f3664s.computeHorizontalScrollRange();
        int i14 = c1172p.f3662q;
        boolean z7 = iComputeHorizontalScrollRange - i14 > 0 && i14 >= i13;
        c1172p.f3666u = z7;
        boolean z10 = c1172p.f3665t;
        if (!z10 && !z7) {
            if (c1172p.f3667v != 0) {
                c1172p.m2978d(0);
                return;
            }
            return;
        }
        if (z10) {
            float f = i11;
            c1172p.f3657l = (int) ((((f / 2.0f) + iComputeVerticalScrollOffset) * f) / iComputeVerticalScrollRange);
            c1172p.f3656k = Math.min(i11, (i11 * i11) / iComputeVerticalScrollRange);
        }
        if (c1172p.f3666u) {
            float f3 = iComputeHorizontalScrollOffset;
            float f4 = i14;
            c1172p.f3660o = (int) ((((f4 / 2.0f) + f3) * f4) / iComputeHorizontalScrollRange);
            c1172p.f3659n = Math.min(i14, (i14 * i14) / iComputeHorizontalScrollRange);
        }
        int i15 = c1172p.f3667v;
        if (i15 == 0 || i15 == 1) {
            c1172p.m2978d(1);
        }
    }
}

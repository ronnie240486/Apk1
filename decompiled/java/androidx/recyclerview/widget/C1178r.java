package androidx.recyclerview.widget;

import java.util.Arrays;

public final class C1178r implements InterfaceC1194w0 {

    public int f3674a;

    public int f3675b;

    public int[] f3676c;

    public int f3677d;

    public final void m2986a(int i6, int i10) {
        if (i6 < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i11 = this.f3677d;
        int i12 = i11 * 2;
        int[] iArr = this.f3676c;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.f3676c = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i12 >= iArr.length) {
            int[] iArr3 = new int[i11 * 4];
            this.f3676c = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = this.f3676c;
        iArr4[i12] = i6;
        iArr4[i12 + 1] = i10;
        this.f3677d++;
    }

    public final void m2987b(RecyclerView recyclerView, boolean z7) {
        this.f3677d = 0;
        int[] iArr = this.f3676c;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        AbstractC1197x0 abstractC1197x0 = recyclerView.mLayout;
        if (recyclerView.mAdapter == null || abstractC1197x0 == null || !abstractC1197x0.isItemPrefetchEnabled()) {
            return;
        }
        if (z7) {
            if (!recyclerView.mAdapterHelper.m2877g()) {
                abstractC1197x0.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
            }
        } else if (!recyclerView.hasPendingAdapterUpdates()) {
            abstractC1197x0.collectAdjacentPrefetchPositions(this.f3674a, this.f3675b, recyclerView.mState, this);
        }
        int i6 = this.f3677d;
        if (i6 > abstractC1197x0.mPrefetchMaxCountObserved) {
            abstractC1197x0.mPrefetchMaxCountObserved = i6;
            abstractC1197x0.mPrefetchMaxObservedInInitialPrefetch = z7;
            recyclerView.mRecycler.m2937n();
        }
    }
}

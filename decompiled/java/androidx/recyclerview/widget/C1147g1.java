package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public final class C1147g1 extends AbstractC1164m0 {

    public final RecyclerView f3572a;

    public C1147g1(RecyclerView recyclerView) {
        this.f3572a = recyclerView;
    }

    public final void m2946a() {
        RecyclerView recyclerView = this.f3572a;
        if (!recyclerView.mHasFixedSize || !recyclerView.mIsAttached) {
            recyclerView.mAdapterUpdateDuringMeasure = true;
            recyclerView.requestLayout();
        } else {
            Runnable runnable = recyclerView.mUpdateChildViewsRunnable;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            recyclerView.postOnAnimation(runnable);
        }
    }

    @Override
    public final void onChanged() {
        RecyclerView recyclerView = this.f3572a;
        recyclerView.assertNotInLayoutOrScroll(null);
        recyclerView.mState.f3620f = true;
        recyclerView.processDataSetCompletelyChanged(true);
        if (recyclerView.mAdapterHelper.m2877g()) {
            return;
        }
        recyclerView.requestLayout();
    }

    @Override
    public final void onItemRangeChanged(int i6, int i10, Object obj) {
        RecyclerView recyclerView = this.f3572a;
        recyclerView.assertNotInLayoutOrScroll(null);
        C1126b c1126b = recyclerView.mAdapterHelper;
        if (i10 < 1) {
            c1126b.getClass();
            return;
        }
        ArrayList arrayList = c1126b.f3515b;
        arrayList.add(c1126b.m2878h(4, i6, i10, obj));
        c1126b.f3519f |= 4;
        if (arrayList.size() == 1) {
            m2946a();
        }
    }

    @Override
    public final void onItemRangeInserted(int i6, int i10) {
        RecyclerView recyclerView = this.f3572a;
        recyclerView.assertNotInLayoutOrScroll(null);
        C1126b c1126b = recyclerView.mAdapterHelper;
        if (i10 < 1) {
            c1126b.getClass();
            return;
        }
        ArrayList arrayList = c1126b.f3515b;
        arrayList.add(c1126b.m2878h(1, i6, i10, null));
        c1126b.f3519f |= 1;
        if (arrayList.size() == 1) {
            m2946a();
        }
    }

    @Override
    public final void onItemRangeMoved(int i6, int i10, int i11) {
        RecyclerView recyclerView = this.f3572a;
        recyclerView.assertNotInLayoutOrScroll(null);
        C1126b c1126b = recyclerView.mAdapterHelper;
        c1126b.getClass();
        if (i6 == i10) {
            return;
        }
        if (i11 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        ArrayList arrayList = c1126b.f3515b;
        arrayList.add(c1126b.m2878h(8, i6, i10, null));
        c1126b.f3519f |= 8;
        if (arrayList.size() == 1) {
            m2946a();
        }
    }

    @Override
    public final void onItemRangeRemoved(int i6, int i10) {
        RecyclerView recyclerView = this.f3572a;
        recyclerView.assertNotInLayoutOrScroll(null);
        C1126b c1126b = recyclerView.mAdapterHelper;
        if (i10 < 1) {
            c1126b.getClass();
            return;
        }
        ArrayList arrayList = c1126b.f3515b;
        arrayList.add(c1126b.m2878h(2, i6, i10, null));
        c1126b.f3519f |= 2;
        if (arrayList.size() == 1) {
            m2946a();
        }
    }

    @Override
    public final void onStateRestorationPolicyChanged() {
        AbstractC1158k0 abstractC1158k0;
        RecyclerView recyclerView = this.f3572a;
        if (recyclerView.mPendingSavedState == null || (abstractC1158k0 = recyclerView.mAdapter) == null || !abstractC1158k0.canRestoreState()) {
            return;
        }
        recyclerView.requestLayout();
    }
}

package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import p138n0.InterfaceC3124i;

public final class C1152i0 implements InterfaceC3124i, InterfaceC1137d2, InterfaceC1176q0 {

    public final Object f3584a;

    public C1152i0(Object obj) {
        this.f3584a = obj;
    }

    public void m2947a(C1122a c1122a) {
        int i6 = c1122a.f3510a;
        RecyclerView recyclerView = (RecyclerView) this.f3584a;
        if (i6 == 1) {
            recyclerView.mLayout.onItemsAdded(recyclerView, c1122a.f3511b, c1122a.f3513d);
            return;
        }
        if (i6 == 2) {
            recyclerView.mLayout.onItemsRemoved(recyclerView, c1122a.f3511b, c1122a.f3513d);
        } else if (i6 == 4) {
            recyclerView.mLayout.onItemsUpdated(recyclerView, c1122a.f3511b, c1122a.f3513d, c1122a.f3512c);
        } else {
            if (i6 != 8) {
                return;
            }
            recyclerView.mLayout.onItemsMoved(recyclerView, c1122a.f3511b, c1122a.f3513d, 1);
        }
    }

    public AbstractC1174p1 m2948b(int i6) {
        RecyclerView recyclerView = (RecyclerView) this.f3584a;
        AbstractC1174p1 abstractC1174p1FindViewHolderForPosition = recyclerView.findViewHolderForPosition(i6, true);
        if (abstractC1174p1FindViewHolderForPosition == null) {
            return null;
        }
        C1134d c1134d = recyclerView.mChildHelper;
        if (!c1134d.f3535c.contains(abstractC1174p1FindViewHolderForPosition.itemView)) {
            return abstractC1174p1FindViewHolderForPosition;
        }
        if (RecyclerView.sVerboseLoggingEnabled) {
            Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
        }
        return null;
    }

    public void m2949c(int i6) {
        RecyclerView recyclerView = (RecyclerView) this.f3584a;
        View childAt = recyclerView.getChildAt(i6);
        if (childAt != null) {
            recyclerView.dispatchChildDetached(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i6);
    }

    @Override
    public boolean mo91g(float f) {
        int i6;
        int i10;
        RecyclerView recyclerView = (RecyclerView) this.f3584a;
        if (recyclerView.mLayout.canScrollVertically()) {
            i10 = (int) f;
            i6 = 0;
        } else {
            i6 = recyclerView.mLayout.canScrollHorizontally() ? (int) f : 0;
            i10 = 0;
        }
        if (i6 == 0 && i10 == 0) {
            return false;
        }
        recyclerView.stopScroll();
        return recyclerView.flingNoThresholdCheck(i6, i10);
    }

    @Override
    public float mo96m() {
        float f;
        RecyclerView recyclerView = (RecyclerView) this.f3584a;
        if (recyclerView.mLayout.canScrollVertically()) {
            f = recyclerView.mScaledVerticalScrollFactor;
        } else {
            if (!recyclerView.mLayout.canScrollHorizontally()) {
                return 0.0f;
            }
            f = recyclerView.mScaledHorizontalScrollFactor;
        }
        return -f;
    }

    @Override
    public void mo98o() {
        ((RecyclerView) this.f3584a).stopScroll();
    }
}

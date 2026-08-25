package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import p138n0.C3103b;
import p148o0.C3233h;

public class C1180r1 extends C3103b {

    public final RecyclerView f3680d;

    public final C1177q1 f3681e;

    public C1180r1(RecyclerView recyclerView) {
        this.f3680d = recyclerView;
        C1177q1 c1177q1 = this.f3681e;
        if (c1177q1 != null) {
            this.f3681e = c1177q1;
        } else {
            this.f3681e = new C1177q1(this);
        }
    }

    @Override
    public final void mo1135c(View view, AccessibilityEvent accessibilityEvent) {
        super.mo1135c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.f3680d.hasPendingAdapterUpdates()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override
    public void mo1136d(View view, C3233h c3233h) {
        this.f10576a.onInitializeAccessibilityNodeInfo(view, c3233h.f10862a);
        RecyclerView recyclerView = this.f3680d;
        if (recyclerView.hasPendingAdapterUpdates() || recyclerView.getLayoutManager() == null) {
            return;
        }
        recyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(c3233h);
    }

    @Override
    public final boolean mo1137g(View view, int i6, Bundle bundle) {
        if (super.mo1137g(view, i6, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f3680d;
        if (recyclerView.hasPendingAdapterUpdates() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        return recyclerView.getLayoutManager().performAccessibilityAction(i6, bundle);
    }
}

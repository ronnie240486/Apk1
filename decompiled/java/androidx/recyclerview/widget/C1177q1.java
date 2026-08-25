package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.WeakHashMap;
import p101j7.C2782c;
import p138n0.C3103b;
import p148o0.C3233h;

public final class C1177q1 extends C3103b {

    public final C1180r1 f3672d;

    public final WeakHashMap f3673e = new WeakHashMap();

    public C1177q1(C1180r1 c1180r1) {
        this.f3672d = c1180r1;
    }

    @Override
    public final boolean mo2980a(View view, AccessibilityEvent accessibilityEvent) {
        C3103b c3103b = (C3103b) this.f3673e.get(view);
        return c3103b != null ? c3103b.mo2980a(view, accessibilityEvent) : this.f10576a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override
    public final C2782c mo2981b(View view) {
        C3103b c3103b = (C3103b) this.f3673e.get(view);
        return c3103b != null ? c3103b.mo2981b(view) : super.mo2981b(view);
    }

    @Override
    public final void mo1135c(View view, AccessibilityEvent accessibilityEvent) {
        C3103b c3103b = (C3103b) this.f3673e.get(view);
        if (c3103b != null) {
            c3103b.mo1135c(view, accessibilityEvent);
        } else {
            super.mo1135c(view, accessibilityEvent);
        }
    }

    @Override
    public final void mo1136d(View view, C3233h c3233h) {
        C1180r1 c1180r1 = this.f3672d;
        boolean zHasPendingAdapterUpdates = c1180r1.f3680d.hasPendingAdapterUpdates();
        View.AccessibilityDelegate accessibilityDelegate = this.f10576a;
        AccessibilityNodeInfo accessibilityNodeInfo = c3233h.f10862a;
        if (!zHasPendingAdapterUpdates) {
            RecyclerView recyclerView = c1180r1.f3680d;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, c3233h);
                C3103b c3103b = (C3103b) this.f3673e.get(view);
                if (c3103b != null) {
                    c3103b.mo1136d(view, c3233h);
                    return;
                } else {
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    return;
                }
            }
        }
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
    }

    @Override
    public final void mo2982e(View view, AccessibilityEvent accessibilityEvent) {
        C3103b c3103b = (C3103b) this.f3673e.get(view);
        if (c3103b != null) {
            c3103b.mo2982e(view, accessibilityEvent);
        } else {
            super.mo2982e(view, accessibilityEvent);
        }
    }

    @Override
    public final boolean mo2983f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        C3103b c3103b = (C3103b) this.f3673e.get(viewGroup);
        return c3103b != null ? c3103b.mo2983f(viewGroup, view, accessibilityEvent) : this.f10576a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override
    public final boolean mo1137g(View view, int i6, Bundle bundle) {
        C1180r1 c1180r1 = this.f3672d;
        if (!c1180r1.f3680d.hasPendingAdapterUpdates()) {
            RecyclerView recyclerView = c1180r1.f3680d;
            if (recyclerView.getLayoutManager() != null) {
                C3103b c3103b = (C3103b) this.f3673e.get(view);
                if (c3103b != null) {
                    if (c3103b.mo1137g(view, i6, bundle)) {
                        return true;
                    }
                } else if (super.mo1137g(view, i6, bundle)) {
                    return true;
                }
                return recyclerView.getLayoutManager().performAccessibilityActionForItem(view, i6, bundle);
            }
        }
        return super.mo1137g(view, i6, bundle);
    }

    @Override
    public final void mo2984h(View view, int i6) {
        C3103b c3103b = (C3103b) this.f3673e.get(view);
        if (c3103b != null) {
            c3103b.mo2984h(view, i6);
        } else {
            super.mo2984h(view, i6);
        }
    }

    @Override
    public final void mo2985i(View view, AccessibilityEvent accessibilityEvent) {
        C3103b c3103b = (C3103b) this.f3673e.get(view);
        if (c3103b != null) {
            c3103b.mo2985i(view, accessibilityEvent);
        } else {
            super.mo2985i(view, accessibilityEvent);
        }
    }
}

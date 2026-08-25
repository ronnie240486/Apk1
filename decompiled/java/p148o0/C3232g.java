package p148o0;

import android.view.accessibility.AccessibilityNodeInfo;

public final class C3232g {

    public final AccessibilityNodeInfo.CollectionItemInfo f10860a;

    public C3232g(AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo) {
        this.f10860a = collectionItemInfo;
    }

    public static C3232g m6538a(int i6, int i10, int i11, int i12, boolean z7) {
        return new C3232g(AccessibilityNodeInfo.CollectionItemInfo.obtain(i6, i10, i11, i12, false, z7));
    }
}

package p148o0;

import android.view.accessibility.AccessibilityNodeInfo;

public abstract class AbstractC3230e {
    public static C3232g m6516a(boolean z7, int i6, int i10, int i11, int i12, boolean z10, String str, String str2) {
        return new C3232g(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z7).setColumnIndex(i6).setRowIndex(i10).setColumnSpan(i11).setRowSpan(i12).setSelected(z10).setRowTitle(str).setColumnTitle(str2).build());
    }

    public static C3233h m6517b(AccessibilityNodeInfo accessibilityNodeInfo, int i6, int i10) {
        AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i6, i10);
        if (child != null) {
            return new C3233h(child, 0);
        }
        return null;
    }

    public static String m6518c(Object obj) {
        return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
    }

    public static String m6519d(Object obj) {
        return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
    }

    public static AccessibilityNodeInfo.ExtraRenderingInfo m6520e(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getExtraRenderingInfo();
    }

    public static C3233h m6521f(AccessibilityNodeInfo accessibilityNodeInfo, int i6) {
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent(i6);
        if (parent != null) {
            return new C3233h(parent, 0);
        }
        return null;
    }

    public static String m6522g(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getUniqueId();
    }

    public static boolean m6523h(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isTextSelectable();
    }

    public static void m6524i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z7) {
        accessibilityNodeInfo.setTextSelectable(z7);
    }

    public static void m6525j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        accessibilityNodeInfo.setUniqueId(str);
    }
}

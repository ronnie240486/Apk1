package p148o0;

import android.view.accessibility.AccessibilityNodeInfo;

public abstract class AbstractC3229d {
    public static Object m6513a(int i6, float f, float f3, float f4) {
        return new AccessibilityNodeInfo.RangeInfo(i6, f, f3, f4);
    }

    public static CharSequence m6514b(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getStateDescription();
    }

    public static void m6515c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setStateDescription(charSequence);
    }
}

package p148o0;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.time.Duration;

public abstract class AbstractC3231f {
    public static AccessibilityNodeInfo.AccessibilityAction m6526a() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
    }

    public static void m6527b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.getBoundsInWindow(rect);
    }

    public static CharSequence m6528c(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getContainerTitle();
    }

    public static long m6529d(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
    }

    public static boolean m6530e(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
    }

    public static boolean m6531f(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isAccessibilityDataSensitive();
    }

    public static void m6532g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z7) {
        accessibilityNodeInfo.setAccessibilityDataSensitive(z7);
    }

    public static void m6533h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.setBoundsInWindow(rect);
    }

    public static void m6534i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setContainerTitle(charSequence);
    }

    public static void m6535j(AccessibilityNodeInfo accessibilityNodeInfo, long j10) {
        accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j10));
    }

    public static void m6536k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z7) {
        accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z7);
    }

    public static void m6537l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z7) {
        accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z7);
    }
}

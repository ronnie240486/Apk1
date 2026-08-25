package androidx.core.widget;

import android.widget.PopupWindow;

public abstract class AbstractC0380m {
    public static boolean m1140a(PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    public static int m1141b(PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }

    public static void m1142c(PopupWindow popupWindow, boolean z7) {
        popupWindow.setOverlapAnchor(z7);
    }

    public static void m1143d(PopupWindow popupWindow, int i6) {
        popupWindow.setWindowLayoutType(i6);
    }
}

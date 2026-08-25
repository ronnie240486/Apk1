package androidx.appcompat.widget;

import android.graphics.Rect;
import android.widget.PopupWindow;

public abstract class AbstractC0297y1 {
    public static void m832a(PopupWindow popupWindow, Rect rect) {
        popupWindow.setEpicenterBounds(rect);
    }

    public static void m833b(PopupWindow popupWindow, boolean z7) {
        popupWindow.setIsClippedToScreen(z7);
    }
}

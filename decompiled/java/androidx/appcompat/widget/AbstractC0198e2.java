package androidx.appcompat.widget;

import android.transition.Transition;
import android.widget.PopupWindow;

public abstract class AbstractC0198e2 {
    public static void m658a(PopupWindow popupWindow, Transition transition) {
        popupWindow.setEnterTransition(transition);
    }

    public static void m659b(PopupWindow popupWindow, Transition transition) {
        popupWindow.setExitTransition(transition);
    }
}

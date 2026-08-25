package androidx.appcompat.widget;

import android.view.ViewTreeObserver;

public abstract class AbstractC0201f0 {
    public static void m660a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }
}

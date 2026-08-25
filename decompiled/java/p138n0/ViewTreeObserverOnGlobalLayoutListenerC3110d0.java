package p138n0;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Map;
import java.util.WeakHashMap;

public final class ViewTreeObserverOnGlobalLayoutListenerC3110d0 implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

    public final WeakHashMap f10580a = new WeakHashMap();

    @Override
    public final void onGlobalLayout() {
        if (Build.VERSION.SDK_INT < 28) {
            for (Map.Entry entry : this.f10580a.entrySet()) {
                View view = (View) entry.getKey();
                boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
                boolean z7 = view.isShown() && view.getWindowVisibility() == 0;
                if (zBooleanValue != z7) {
                    AbstractC3155s0.m6338h(z7 ? 16 : 32, view);
                    entry.setValue(Boolean.valueOf(z7));
                }
            }
        }
    }

    @Override
    public final void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override
    public final void onViewDetachedFromWindow(View view) {
    }
}

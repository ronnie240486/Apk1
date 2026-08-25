package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

public final class C0231l0 implements PopupWindow.OnDismissListener {

    public final ViewTreeObserverOnGlobalLayoutListenerC0255q f987a;

    public final C0236m0 f988b;

    public C0231l0(C0236m0 c0236m0, ViewTreeObserverOnGlobalLayoutListenerC0255q viewTreeObserverOnGlobalLayoutListenerC0255q) {
        this.f988b = c0236m0;
        this.f987a = viewTreeObserverOnGlobalLayoutListenerC0255q;
    }

    @Override
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f988b.f1007G.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f987a);
        }
    }
}

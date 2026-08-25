package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import la.ViewOnClickListenerC3017d;

public final class ViewOnTouchListenerC0187c2 implements View.OnTouchListener {

    public final int f877a;

    public final Object f878b;

    public ViewOnTouchListenerC0187c2(int i6, Object obj) {
        this.f877a = i6;
        this.f878b = obj;
    }

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        switch (this.f877a) {
            case 0:
                int action = motionEvent.getAction();
                int x10 = (int) motionEvent.getX();
                int y7 = (int) motionEvent.getY();
                ListPopupWindow listPopupWindow = (ListPopupWindow) this.f878b;
                if (action == 0 && (popupWindow = listPopupWindow.f715y) != null && popupWindow.isShowing() && x10 >= 0 && x10 < listPopupWindow.f715y.getWidth() && y7 >= 0 && y7 < listPopupWindow.f715y.getHeight()) {
                    listPopupWindow.f711u.postDelayed(listPopupWindow.f707q, 250L);
                } else if (action == 1) {
                    listPopupWindow.f711u.removeCallbacks(listPopupWindow.f707q);
                }
                break;
            default:
                ViewOnClickListenerC3017d viewOnClickListenerC3017d = (ViewOnClickListenerC3017d) this.f878b;
                viewOnClickListenerC3017d.f10314X.setVisibility(0);
                viewOnClickListenerC3017d.m6092S();
                break;
        }
        return false;
    }
}

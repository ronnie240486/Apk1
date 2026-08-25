package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public final class RunnableC0277u1 implements Runnable {

    public final int f1075a;

    public final AbstractViewOnTouchListenerC0282v1 f1076b;

    public RunnableC0277u1(AbstractViewOnTouchListenerC0282v1 abstractViewOnTouchListenerC0282v1, int i6) {
        this.f1075a = i6;
        this.f1076b = abstractViewOnTouchListenerC0282v1;
    }

    @Override
    public final void run() {
        switch (this.f1075a) {
            case 0:
                ViewParent parent = this.f1076b.f1091d.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                AbstractViewOnTouchListenerC0282v1 abstractViewOnTouchListenerC0282v1 = this.f1076b;
                abstractViewOnTouchListenerC0282v1.m796a();
                View view = abstractViewOnTouchListenerC0282v1.f1091d;
                if (view.isEnabled() && !view.isLongClickable() && abstractViewOnTouchListenerC0282v1.mo656c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    abstractViewOnTouchListenerC0282v1.f1094g = true;
                    break;
                }
                break;
        }
    }
}

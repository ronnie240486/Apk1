package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import p173q1.C3406f0;
import p232v6.AbstractC4012a;
import ua.C3947h;

public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    public final C3406f0 f6676g;

    public BaseTransientBottomBar$Behavior() {
        C3406f0 c3406f0 = new C3406f0(7);
        this.f5907d = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.f5908e = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.f5906c = 0;
        this.f6676g = c3406f0;
    }

    @Override
    public final boolean mo925g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.f6676g.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (C3947h.f13272b == null) {
                    C3947h.f13272b = new C3947h();
                }
                synchronized (C3947h.f13272b.f13273a) {
                }
            }
        } else if (coordinatorLayout.m912t(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (C3947h.f13272b == null) {
                C3947h.f13272b = new C3947h();
            }
            C3947h.f13272b.m7876a();
        }
        return super.mo925g(coordinatorLayout, view, motionEvent);
    }

    @Override
    public final boolean mo4102s(View view) {
        this.f6676g.getClass();
        return view instanceof AbstractC4012a;
    }
}

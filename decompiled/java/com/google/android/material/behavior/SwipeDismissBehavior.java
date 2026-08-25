package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import java.util.WeakHashMap;
import p001a0.C0019b;
import p006a6.C0063b;
import p138n0.AbstractC3155s0;
import p148o0.C3228c;
import p226v0.C3968d;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    public C3968d f5904a;

    public boolean f5905b;

    public int f5906c = 2;

    public float f5907d = 0.0f;

    public float f5908e = 0.5f;

    public final C0063b f5909f = new C0063b(this);

    @Override
    public boolean mo925g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zM912t = this.f5905b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zM912t = coordinatorLayout.m912t(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f5905b = zM912t;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f5905b = false;
        }
        if (!zM912t) {
            return false;
        }
        if (this.f5904a == null) {
            this.f5904a = new C3968d(coordinatorLayout.getContext(), coordinatorLayout, this.f5909f);
        }
        return this.f5904a.m7963r(motionEvent);
    }

    @Override
    public final boolean mo926h(CoordinatorLayout coordinatorLayout, View view, int i6) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            AbstractC3155s0.m6344n(ProgressiveMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES, view);
            AbstractC3155s0.m6338h(0, view);
            if (mo4102s(view)) {
                AbstractC3155s0.m6345o(view, C3228c.f10848l, new C0019b(2, this));
            }
        }
        return false;
    }

    @Override
    public final boolean mo936r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        C3968d c3968d = this.f5904a;
        if (c3968d == null) {
            return false;
        }
        c3968d.m7956k(motionEvent);
        return true;
    }

    public boolean mo4102s(View view) {
        return true;
    }
}

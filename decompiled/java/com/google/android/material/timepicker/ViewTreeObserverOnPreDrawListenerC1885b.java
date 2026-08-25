package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

public final class ViewTreeObserverOnPreDrawListenerC1885b implements ViewTreeObserver.OnPreDrawListener {

    public final ClockFaceView f6944a;

    public ViewTreeObserverOnPreDrawListenerC1885b(ClockFaceView clockFaceView) {
        this.f6944a = clockFaceView;
    }

    @Override
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f6944a;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.f6917t.f6925b) - clockFaceView.f6910A;
        if (height != clockFaceView.f6935r) {
            clockFaceView.f6935r = height;
            clockFaceView.m4410o();
            int i6 = clockFaceView.f6935r;
            ClockHandView clockHandView = clockFaceView.f6917t;
            clockHandView.f6933j = i6;
            clockHandView.invalidate();
        }
        return true;
    }
}

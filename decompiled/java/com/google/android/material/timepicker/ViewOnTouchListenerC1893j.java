package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

public final class ViewOnTouchListenerC1893j implements View.OnTouchListener {

    public final GestureDetector f6950a;

    public ViewOnTouchListenerC1893j(GestureDetector gestureDetector) {
        this.f6950a = gestureDetector;
    }

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.f6950a.onTouchEvent(motionEvent);
        }
        return false;
    }
}

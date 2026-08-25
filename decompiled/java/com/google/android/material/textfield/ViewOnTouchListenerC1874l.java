package com.google.android.material.textfield;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import ma.C3091a;
import na.C3222a;
import org.bitspark.android.keyboard.custom.MyKeyBoardView;
import p209t3.C3807d;

public final class ViewOnTouchListenerC1874l implements View.OnTouchListener {

    public final int f6849a;

    public final Object f6850b;

    public final Object f6851c;

    public ViewOnTouchListenerC1874l(Object obj, int i6, Object obj2) {
        this.f6849a = i6;
        this.f6851c = obj;
        this.f6850b = obj2;
    }

    @Override
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C3222a c3222a;
        switch (this.f6849a) {
            case 0:
                if (motionEvent.getAction() == 1) {
                    C1875m c1875m = (C1875m) this.f6851c;
                    c1875m.getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis() - c1875m.f6861n;
                    if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
                        c1875m.f6859l = false;
                    }
                    C1875m.m4386d(c1875m, (AutoCompleteTextView) this.f6850b);
                    c1875m.f6859l = true;
                    c1875m.f6861n = System.currentTimeMillis();
                }
                return false;
            default:
                if (motionEvent.getAction() == 1 && (c3222a = ((C3091a) this.f6851c).f10554e) != null) {
                    MyKeyBoardView.m6734a(c3222a.f10824a, view, ((C3807d) this.f6850b).getLayoutPosition());
                }
                return true;
        }
    }
}

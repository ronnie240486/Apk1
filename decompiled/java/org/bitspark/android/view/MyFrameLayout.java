package org.bitspark.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.nmmedit.protect.NativeUtil;
import sa.InterfaceC3735f;

public class MyFrameLayout extends FrameLayout {

    public InterfaceC3735f f11284a;

    static {
        NativeUtil.classesInit0(23);
    }

    public MyFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11284a = null;
    }

    @Override
    public final native boolean onInterceptTouchEvent(MotionEvent motionEvent);

    public native void setOnInterceptTouchEvent(InterfaceC3735f interfaceC3735f);

    public MyFrameLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f11284a = null;
    }
}

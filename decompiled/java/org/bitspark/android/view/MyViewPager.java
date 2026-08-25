package org.bitspark.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.nmmedit.protect.NativeUtil;
import sa.InterfaceC3730a;

public class MyViewPager extends ViewPager {

    public InterfaceC3730a f11299d0;

    static {
        NativeUtil.classesInit0(52);
    }

    public MyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public final native boolean dispatchKeyEvent(KeyEvent keyEvent);

    @Override
    public final native boolean onInterceptTouchEvent(MotionEvent motionEvent);

    @Override
    public final native boolean onTouchEvent(MotionEvent motionEvent);

    public native void setDispatchKeyEvent(InterfaceC3730a interfaceC3730a);
}

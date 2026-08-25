package org.bitspark.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.nmmedit.protect.NativeUtil;

public class MyRadioButton extends RadioButton {

    public Drawable f11297a;

    public int f11298b;

    static {
        NativeUtil.classesInit0(25);
    }

    public MyRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public final native void onDraw(Canvas canvas);

    @Override
    public native void setButtonDrawable(int i6);

    @Override
    public native void setButtonDrawable(Drawable drawable);
}

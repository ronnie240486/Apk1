package org.bitspark.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.nmmedit.protect.NativeUtil;

public class MyCircularProgressBar extends View {

    public final RectF f11278a;

    public int f11279b;

    public int f11280c;

    public float f11281d;

    public Paint f11282e;

    public Paint f11283f;

    static {
        NativeUtil.classesInit0(35);
    }

    public MyCircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11278a = new RectF();
        this.f11279b = 0;
        this.f11280c = 100;
        this.f11281d = 4.0f;
        m6779a(context);
    }

    public final native void m6779a(Context context);

    @Override
    public final native void onDraw(Canvas canvas);

    @Override
    public native void setBackgroundColor(int i6);

    public native void setMax(int i6);

    public native void setProgress(int i6);

    public native void setProgressColor(int i6);

    public native void setStrokeWidth(float f);

    public MyCircularProgressBar(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f11278a = new RectF();
        this.f11279b = 0;
        this.f11280c = 100;
        this.f11281d = 4.0f;
        m6779a(context);
    }
}

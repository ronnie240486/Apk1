package org.bitspark.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.nmmedit.protect.NativeUtil;

public class GradientBorderView extends View {

    public Paint f11273a;

    public int f11274b;

    public int[] f11275c;

    public float f11276d;

    static {
        NativeUtil.classesInit0(65);
    }

    public GradientBorderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11274b = 6;
        this.f11275c = new int[]{0, 0};
        this.f11276d = 16.0f;
        m6778a();
    }

    public final native void m6778a();

    @Override
    public final native void onDraw(Canvas canvas);

    public native void setColor(int i6);

    public native void setColor(int[] iArr);

    public GradientBorderView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f11274b = 6;
        this.f11275c = new int[]{0, 0};
        this.f11276d = 16.0f;
        m6778a();
    }
}

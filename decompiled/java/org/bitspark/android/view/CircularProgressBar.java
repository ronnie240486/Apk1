package org.bitspark.android.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.nmmedit.protect.NativeUtil;

public class CircularProgressBar extends View {

    public final RectF f11265a;

    public int f11266b;

    public int f11267c;

    public float f11268d;

    public Paint f11269e;

    public Paint f11270f;

    public ValueAnimator f11271g;

    public float f11272h;

    static {
        NativeUtil.classesInit0(30);
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11265a = new RectF();
        this.f11266b = 0;
        this.f11267c = 100;
        this.f11268d = 10.0f;
        this.f11272h = 0.0f;
        m6777a(context);
    }

    public final native void m6777a(Context context);

    @Override
    public final native void onDraw(Canvas canvas);

    @Override
    public native void setBackgroundColor(int i6);

    public native void setMax(int i6);

    public native void setProgress(int i6);

    public native void setProgressColor(int i6);

    public native void setStrokeWidth(float f);

    @Override
    public native void setVisibility(int i6);

    public CircularProgressBar(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f11265a = new RectF();
        this.f11266b = 0;
        this.f11267c = 100;
        this.f11268d = 10.0f;
        this.f11272h = 0.0f;
        m6777a(context);
    }
}

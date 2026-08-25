package org.bitspark.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.nmmedit.protect.NativeUtil;
import p143n5.AbstractC3198d;

public class MyProcessRelativeLayout extends RelativeLayout {

    public final int f11285a;

    public int f11286b;

    public int f11287c;

    public int f11288d;

    public boolean f11289e;

    public int f11290f;

    public final int f11291g;

    public Paint f11292h;

    public Paint f11293i;

    public float f11294j;

    public float f11295k;

    public Path f11296l;

    static {
        NativeUtil.classesInit0(57);
    }

    public MyProcessRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11285a = -10086;
        this.f11286b = -10086;
        this.f11287c = -10086;
        this.f11288d = -10086;
        this.f11289e = false;
        this.f11290f = 0;
        this.f11291g = 100;
        this.f11294j = AbstractC3198d.m6469q(getContext(), 4);
        this.f11295k = AbstractC3198d.m6469q(getContext(), 4);
        m6780a(attributeSet);
    }

    public final native void m6780a(AttributeSet attributeSet);

    public final native void m6781b();

    public native int getFocusColor();

    public native int getUnFocusColor();

    @Override
    public final native void onDraw(Canvas canvas);

    @Override
    public final native void onFocusChanged(boolean z7, int i6, Rect rect);

    public native void setBackgroundPaintColor(int i6);

    public native void setCornerRadius(float f);

    public native void setFocusColor(int i6);

    public native void setProgress(int i6);

    public native void setProgressHeight(float f);

    public native void setUnFocusColor(int i6);

    public MyProcessRelativeLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f11285a = -10086;
        this.f11286b = -10086;
        this.f11287c = -10086;
        this.f11288d = -10086;
        this.f11289e = false;
        this.f11290f = 0;
        this.f11291g = 100;
        this.f11294j = AbstractC3198d.m6469q(getContext(), 4);
        this.f11295k = AbstractC3198d.m6469q(getContext(), 4);
        m6780a(attributeSet);
    }
}

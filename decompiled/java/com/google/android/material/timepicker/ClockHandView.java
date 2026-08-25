package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p250x5.AbstractC4121a;

class ClockHandView extends View {

    public final ArrayList f6924a;

    public final int f6925b;

    public final float f6926c;

    public final Paint f6927d;

    public final RectF f6928e;

    public final int f6929f;

    public float f6930g;

    public boolean f6931h;

    public double f6932i;

    public int f6933j;

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public final void m4409a(float f) {
        float f3 = f % 360.0f;
        this.f6930g = f3;
        this.f6932i = Math.toRadians(f3 - 90.0f);
        int height = getHeight() / 2;
        float fCos = (this.f6933j * ((float) Math.cos(this.f6932i))) + (getWidth() / 2);
        float fSin = (this.f6933j * ((float) Math.sin(this.f6932i))) + height;
        float f4 = this.f6925b;
        this.f6928e.set(fCos - f4, fSin - f4, fCos + f4, fSin + f4);
        Iterator it = this.f6924a.iterator();
        while (it.hasNext()) {
            ClockFaceView clockFaceView = (ClockFaceView) ((InterfaceC1887d) it.next());
            if (Math.abs(clockFaceView.f6915F - f3) > 0.001f) {
                clockFaceView.f6915F = f3;
                clockFaceView.m4408p();
            }
        }
        invalidate();
    }

    @Override
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f = width;
        float fCos = (this.f6933j * ((float) Math.cos(this.f6932i))) + f;
        float f3 = height;
        float fSin = (this.f6933j * ((float) Math.sin(this.f6932i))) + f3;
        Paint paint = this.f6927d;
        paint.setStrokeWidth(0.0f);
        int i6 = this.f6925b;
        canvas.drawCircle(fCos, fSin, i6, paint);
        double dSin = Math.sin(this.f6932i);
        double dCos = Math.cos(this.f6932i);
        double d = this.f6933j - i6;
        paint.setStrokeWidth(this.f6929f);
        canvas.drawLine(f, f3, width + ((int) (dCos * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f, f3, this.f6926c, paint);
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        m4409a(this.f6930g);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        boolean z10;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y7 = motionEvent.getY();
        boolean z11 = false;
        if (actionMasked != 0) {
            z7 = (actionMasked == 1 || actionMasked == 2) ? this.f6931h : false;
            z10 = false;
        } else {
            this.f6931h = false;
            z7 = false;
            z10 = true;
        }
        boolean z12 = this.f6931h;
        int degrees = (int) Math.toDegrees(Math.atan2(y7 - (getHeight() / 2), x10 - (getWidth() / 2)));
        int i6 = degrees + 90;
        if (i6 < 0) {
            i6 = degrees + 450;
        }
        float f = i6;
        boolean z13 = this.f6930g != f;
        if (z10 && z13) {
            z11 = true;
        } else if (z13 || z7) {
            m4409a(f);
            z11 = true;
        }
        this.f6931h = z12 | z11;
        return true;
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f6924a = new ArrayList();
        Paint paint = new Paint();
        this.f6927d = paint;
        this.f6928e = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4121a.f13999m, i6, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.f6933j = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f6925b = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        Resources resources = getResources();
        this.f6929f = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f6926c = resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        m4409a(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
    }
}

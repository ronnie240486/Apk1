package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import p221u6.C3908h;
import p221u6.C3913m;

public final class C1869g extends C3908h {

    public final RectF f6842x;

    public C1869g(C3913m c3913m) {
        super(c3913m == null ? new C3913m() : c3913m);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f6842x = new RectF();
    }

    @Override
    public final void mo4382f(Canvas canvas) {
        RectF rectF = this.f6842x;
        if (rectF.isEmpty()) {
            super.mo4382f(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(rectF);
        } else {
            canvas.clipRect(rectF, Region.Op.DIFFERENCE);
        }
        super.mo4382f(canvas);
        canvas.restore();
    }

    public final void m4383w(float f, float f3, float f4, float f5) {
        RectF rectF = this.f6842x;
        if (f == rectF.left && f3 == rectF.top && f4 == rectF.right && f5 == rectF.bottom) {
            return;
        }
        rectF.set(f, f3, f4, f5);
        invalidateSelf();
    }
}

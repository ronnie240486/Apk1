package com.dinuscxj.progressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import java.lang.reflect.Field;
import p229v3.AbstractC3986a;

public class CircleProgressBar extends ProgressBar {

    public final RectF f4513a;

    public final Rect f4514b;

    public final Paint f4515c;

    public final Paint f4516d;

    public final Paint f4517e;

    public final Paint f4518f;

    public float f4519g;

    public float f4520h;

    public float f4521i;

    public int f4522j;

    public int f4523k;

    public float f4524l;

    public float f4525m;

    public float f4526n;

    public int f4527o;

    public int f4528p;

    public int f4529q;

    public int f4530r;

    public final boolean f4531s;

    public String f4532t;

    public int f4533u;

    public int f4534v;

    public Paint.Cap f4535w;

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4513a = new RectF();
        this.f4514b = new Rect();
        this.f4515c = new Paint(1);
        this.f4516d = new Paint(1);
        this.f4517e = new Paint(1);
        this.f4518f = new Paint(1);
        try {
            Field declaredField = ProgressBar.class.getDeclaredField("mOnlyIndeterminate");
            declaredField.setAccessible(true);
            Boolean bool = Boolean.FALSE;
            declaredField.set(this, bool);
            Field declaredField2 = ProgressBar.class.getDeclaredField("mIndeterminate");
            declaredField2.setAccessible(true);
            declaredField2.set(this, bool);
            Field declaredField3 = ProgressBar.class.getDeclaredField("mCurrentDrawable");
            declaredField3.setAccessible(true);
            declaredField3.set(this, null);
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        } catch (NoSuchFieldException e10) {
            e10.printStackTrace();
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3986a.f13518a);
        this.f4522j = typedArrayObtainStyledAttributes.getColor(0, 0);
        this.f4531s = typedArrayObtainStyledAttributes.getBoolean(1, true);
        this.f4523k = typedArrayObtainStyledAttributes.getInt(2, 45);
        this.f4532t = typedArrayObtainStyledAttributes.hasValue(11) ? typedArrayObtainStyledAttributes.getString(11) : "%d%%";
        this.f4533u = typedArrayObtainStyledAttributes.getInt(13, 0);
        this.f4534v = typedArrayObtainStyledAttributes.getInt(6, 0);
        this.f4535w = typedArrayObtainStyledAttributes.hasValue(8) ? Paint.Cap.values()[typedArrayObtainStyledAttributes.getInt(8, 0)] : Paint.Cap.BUTT;
        this.f4524l = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, (int) ((4.0f * getContext().getResources().getDisplayMetrics().density) + 0.5f));
        this.f4526n = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, (int) ((11.0f * getContext().getResources().getDisplayMetrics().density) + 0.5f));
        this.f4525m = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, (int) ((1.0f * getContext().getResources().getDisplayMetrics().density) + 0.5f));
        this.f4527o = typedArrayObtainStyledAttributes.getColor(7, Color.parseColor("#fff2a670"));
        this.f4528p = typedArrayObtainStyledAttributes.getColor(5, Color.parseColor("#fff2a670"));
        this.f4529q = typedArrayObtainStyledAttributes.getColor(10, Color.parseColor("#fff2a670"));
        this.f4530r = typedArrayObtainStyledAttributes.getColor(4, Color.parseColor("#ffe3e3e5"));
        typedArrayObtainStyledAttributes.recycle();
        Paint.Align align = Paint.Align.CENTER;
        Paint paint = this.f4518f;
        paint.setTextAlign(align);
        paint.setTextSize(this.f4526n);
        Paint.Style style = this.f4533u == 1 ? Paint.Style.FILL : Paint.Style.STROKE;
        Paint paint2 = this.f4515c;
        paint2.setStyle(style);
        paint2.setStrokeWidth(this.f4525m);
        paint2.setColor(this.f4527o);
        paint2.setStrokeCap(this.f4535w);
        Paint.Style style2 = this.f4533u == 1 ? Paint.Style.FILL : Paint.Style.STROKE;
        Paint paint3 = this.f4516d;
        paint3.setStyle(style2);
        paint3.setStrokeWidth(this.f4525m);
        paint3.setColor(this.f4530r);
        paint3.setStrokeCap(this.f4535w);
        Paint.Style style3 = Paint.Style.FILL;
        Paint paint4 = this.f4517e;
        paint4.setStyle(style3);
        paint4.setColor(this.f4522j);
    }

    public final void m3578a(Canvas canvas) {
        int i6 = this.f4533u;
        RectF rectF = this.f4513a;
        Paint paint = this.f4516d;
        Paint paint2 = this.f4515c;
        if (i6 == 1) {
            canvas.drawArc(rectF, -90.0f, 360.0f, false, paint);
            canvas.drawArc(rectF, -90.0f, (getProgress() * 360.0f) / getMax(), true, paint2);
            return;
        }
        if (i6 == 2) {
            canvas.drawArc(rectF, -90.0f, 360.0f, false, paint);
            canvas.drawArc(rectF, -90.0f, (getProgress() * 360.0f) / getMax(), false, paint2);
            return;
        }
        float f = (float) (6.283185307179586d / ((double) this.f4523k));
        float f3 = this.f4519g;
        float f4 = f3 - this.f4524l;
        int progress = (int) ((getProgress() / getMax()) * this.f4523k);
        for (int i10 = 0; i10 < this.f4523k; i10++) {
            double d = i10 * f;
            float fSin = (((float) Math.sin(d)) * f4) + this.f4520h;
            float fCos = this.f4520h - (((float) Math.cos(d)) * f4);
            float fSin2 = (((float) Math.sin(d)) * f3) + this.f4520h;
            float fCos2 = this.f4520h - (((float) Math.cos(d)) * f3);
            if (i10 < progress) {
                canvas.drawLine(fSin, fCos, fSin2, fCos2, paint2);
            } else {
                canvas.drawLine(fSin, fCos, fSin2, fCos2, paint);
            }
        }
    }

    public final void m3579b(Canvas canvas) {
        if (this.f4531s) {
            String str = String.format(this.f4532t, Integer.valueOf(getProgress()));
            Paint paint = this.f4518f;
            paint.setTextSize(this.f4526n);
            paint.setColor(this.f4529q);
            int length = str.length();
            Rect rect = this.f4514b;
            paint.getTextBounds(str, 0, length, rect);
            canvas.drawText(str, this.f4520h, this.f4521i + (rect.height() / 2), paint);
        }
    }

    public final void m3580c() {
        int i6 = this.f4527o;
        int i10 = this.f4528p;
        Shader linearGradient = null;
        Paint paint = this.f4515c;
        if (i6 == i10) {
            paint.setShader(null);
            paint.setColor(this.f4527o);
            return;
        }
        int i11 = this.f4534v;
        if (i11 == 0) {
            RectF rectF = this.f4513a;
            float f = rectF.left;
            linearGradient = new LinearGradient(f, rectF.top, f, rectF.bottom, this.f4527o, this.f4528p, Shader.TileMode.CLAMP);
        } else if (i11 == 1) {
            linearGradient = new RadialGradient(this.f4520h, this.f4521i, this.f4519g, this.f4527o, this.f4528p, Shader.TileMode.CLAMP);
        } else if (i11 == 2) {
            float degrees = (float) ((-90.0d) - ((this.f4535w == Paint.Cap.BUTT && this.f4533u == 2) ? 0.0d : Math.toDegrees((float) (((((double) this.f4525m) / 3.141592653589793d) * 2.0d) / ((double) this.f4519g)))));
            linearGradient = new SweepGradient(this.f4520h, this.f4521i, new int[]{this.f4527o, this.f4528p}, new float[]{0.0f, 1.0f});
            Matrix matrix = new Matrix();
            matrix.postRotate(degrees, this.f4520h, this.f4521i);
            linearGradient.setLocalMatrix(matrix);
        }
        paint.setShader(linearGradient);
    }

    public int getBackgroundColor() {
        return this.f4522j;
    }

    public Paint.Cap getCap() {
        return this.f4535w;
    }

    public int getLineCount() {
        return this.f4523k;
    }

    public float getLineWidth() {
        return this.f4524l;
    }

    public int getProgressBackgroundColor() {
        return this.f4530r;
    }

    public int getProgressEndColor() {
        return this.f4528p;
    }

    public int getProgressStartColor() {
        return this.f4527o;
    }

    public float getProgressStrokeWidth() {
        return this.f4525m;
    }

    public int getProgressTextColor() {
        return this.f4529q;
    }

    public String getProgressTextFormatPattern() {
        return this.f4532t;
    }

    public float getProgressTextSize() {
        return this.f4526n;
    }

    public int getShader() {
        return this.f4534v;
    }

    public int getStyle() {
        return this.f4533u;
    }

    @Override
    public final synchronized void onDraw(Canvas canvas) {
        if (this.f4522j != 0) {
            float f = this.f4520h;
            canvas.drawCircle(f, f, this.f4519g, this.f4517e);
        }
        m3578a(canvas);
        m3579b(canvas);
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        super.onSizeChanged(i6, i10, i11, i12);
        float f = i6 / 2;
        this.f4520h = f;
        float f3 = i10 / 2;
        this.f4521i = f3;
        float fMin = Math.min(f, f3);
        this.f4519g = fMin;
        RectF rectF = this.f4513a;
        float f4 = this.f4521i;
        rectF.top = f4 - fMin;
        rectF.bottom = f4 + fMin;
        float f5 = this.f4520h;
        rectF.left = f5 - fMin;
        rectF.right = f5 + fMin;
        m3580c();
        float f10 = this.f4525m;
        rectF.inset(f10 / 2.0f, f10 / 2.0f);
    }

    @Override
    public void setBackgroundColor(int i6) {
        this.f4522j = i6;
        this.f4517e.setColor(i6);
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.f4535w = cap;
        this.f4515c.setStrokeCap(cap);
        this.f4516d.setStrokeCap(cap);
        invalidate();
    }

    public void setLineCount(int i6) {
        this.f4523k = i6;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.f4524l = f;
        invalidate();
    }

    public void setProgressBackgroundColor(int i6) {
        this.f4530r = i6;
        this.f4516d.setColor(i6);
        invalidate();
    }

    public void setProgressEndColor(int i6) {
        this.f4528p = i6;
        m3580c();
        invalidate();
    }

    public void setProgressStartColor(int i6) {
        this.f4527o = i6;
        m3580c();
        invalidate();
    }

    public void setProgressStrokeWidth(float f) {
        this.f4525m = f;
        this.f4513a.inset(f / 2.0f, f / 2.0f);
        invalidate();
    }

    public void setProgressTextColor(int i6) {
        this.f4529q = i6;
        invalidate();
    }

    public void setProgressTextFormatPattern(String str) {
        this.f4532t = str;
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.f4526n = f;
        invalidate();
    }

    public void setShader(int i6) {
        this.f4534v = i6;
        m3580c();
        invalidate();
    }

    public void setStyle(int i6) {
        this.f4533u = i6;
        this.f4515c.setStyle(i6 == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f4516d.setStyle(this.f4533u == 1 ? Paint.Style.FILL : Paint.Style.STROKE);
        invalidate();
    }
}

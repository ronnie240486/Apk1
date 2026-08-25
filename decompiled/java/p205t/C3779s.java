package p205t;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;

public final class C3779s {

    public float[] f12701a;

    public final int[] f12702b;

    public final float[] f12703c;

    public Path f12704d;

    public final Paint f12705e;

    public final Paint f12706f;

    public final Paint f12707g;

    public final Paint f12708h;

    public final Paint f12709i;

    public final float[] f12710j;

    public int f12711k;

    public final Rect f12712l = new Rect();

    public final int f12713m = 1;

    public final MotionLayout f12714n;

    public C3779s(MotionLayout motionLayout) {
        this.f12714n = motionLayout;
        Paint paint = new Paint();
        this.f12705e = paint;
        paint.setAntiAlias(true);
        paint.setColor(-21965);
        paint.setStrokeWidth(2.0f);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint paint2 = new Paint();
        this.f12706f = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(-2067046);
        paint2.setStrokeWidth(2.0f);
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f12707g = paint3;
        paint3.setAntiAlias(true);
        paint3.setColor(-13391360);
        paint3.setStrokeWidth(2.0f);
        paint3.setStyle(style);
        Paint paint4 = new Paint();
        this.f12708h = paint4;
        paint4.setAntiAlias(true);
        paint4.setColor(-13391360);
        paint4.setTextSize(motionLayout.getContext().getResources().getDisplayMetrics().density * 12.0f);
        this.f12710j = new float[8];
        Paint paint5 = new Paint();
        this.f12709i = paint5;
        paint5.setAntiAlias(true);
        paint3.setPathEffect(new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f));
        this.f12703c = new float[100];
        this.f12702b = new int[50];
    }

    public final void m7524a(Canvas canvas, int i6, int i10, C3774o c3774o) {
        int width;
        int height;
        int[] iArr = this.f12702b;
        int i11 = 4;
        if (i6 == 4) {
            boolean z7 = false;
            boolean z10 = false;
            for (int i12 = 0; i12 < this.f12711k; i12++) {
                int i13 = iArr[i12];
                if (i13 == 1) {
                    z7 = true;
                }
                if (i13 == 2) {
                    z10 = true;
                }
            }
            if (z7) {
                float[] fArr = this.f12701a;
                canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f12707g);
            }
            if (z10) {
                m7525b(canvas);
            }
        }
        if (i6 == 2) {
            float[] fArr2 = this.f12701a;
            canvas.drawLine(fArr2[0], fArr2[1], fArr2[fArr2.length - 2], fArr2[fArr2.length - 1], this.f12707g);
        }
        if (i6 == 3) {
            m7525b(canvas);
        }
        canvas.drawLines(this.f12701a, this.f12705e);
        View view = c3774o.f12648a;
        if (view != null) {
            width = view.getWidth();
            height = c3774o.f12648a.getHeight();
        } else {
            width = 0;
            height = 0;
        }
        int i14 = 1;
        while (i14 < i10 - 1) {
            if (i6 == i11 && iArr[i14 - 1] == 0) {
                i14 = i14;
            } else {
                int i15 = i14 * 2;
                float[] fArr3 = this.f12703c;
                float f = fArr3[i15];
                float f3 = fArr3[i15 + 1];
                this.f12704d.reset();
                this.f12704d.moveTo(f, f3 + 10.0f);
                this.f12704d.lineTo(f + 10.0f, f3);
                this.f12704d.lineTo(f, f3 - 10.0f);
                this.f12704d.lineTo(f - 10.0f, f3);
                this.f12704d.close();
                int i16 = i14 - 1;
                Paint paint = this.f12709i;
                if (i6 == i11) {
                    int i17 = iArr[i16];
                    if (i17 == 1) {
                        m7527d(canvas, f - 0.0f, f3 - 0.0f);
                    } else if (i17 == 2) {
                        m7526c(canvas, f - 0.0f, f3 - 0.0f);
                    } else {
                        if (i17 == 3) {
                            m7528e(canvas, f - 0.0f, f3 - 0.0f, width, height);
                        }
                        canvas.drawPath(this.f12704d, paint);
                    }
                    canvas.drawPath(this.f12704d, paint);
                } else {
                    paint = paint;
                    f3 = f3;
                    f = f;
                    i14 = i14;
                }
                if (i6 == 2) {
                    m7527d(canvas, f - 0.0f, f3 - 0.0f);
                }
                if (i6 == 3) {
                    m7526c(canvas, f - 0.0f, f3 - 0.0f);
                }
                if (i6 == 6) {
                    m7528e(canvas, f - 0.0f, f3 - 0.0f, width, height);
                }
                canvas.drawPath(this.f12704d, paint);
            }
            i14++;
            i11 = 4;
        }
        float[] fArr4 = this.f12701a;
        if (fArr4.length > 1) {
            float f4 = fArr4[0];
            float f5 = fArr4[1];
            Paint paint2 = this.f12706f;
            canvas.drawCircle(f4, f5, 8.0f, paint2);
            float[] fArr5 = this.f12701a;
            canvas.drawCircle(fArr5[fArr5.length - 2], fArr5[fArr5.length - 1], 8.0f, paint2);
        }
    }

    public final void m7525b(Canvas canvas) {
        float[] fArr = this.f12701a;
        float f = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[fArr.length - 2];
        float f5 = fArr[fArr.length - 1];
        float fMin = Math.min(f, f4);
        float fMax = Math.max(f3, f5);
        float fMax2 = Math.max(f, f4);
        float fMax3 = Math.max(f3, f5);
        Paint paint = this.f12707g;
        canvas.drawLine(fMin, fMax, fMax2, fMax3, paint);
        canvas.drawLine(Math.min(f, f4), Math.min(f3, f5), Math.min(f, f4), Math.max(f3, f5), paint);
    }

    public final void m7526c(Canvas canvas, float f, float f3) {
        float[] fArr = this.f12701a;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f10 = fArr[fArr.length - 2];
        float f11 = fArr[fArr.length - 1];
        float fMin = Math.min(f4, f10);
        float fMax = Math.max(f5, f11);
        float fMin2 = f - Math.min(f4, f10);
        float fMax2 = Math.max(f5, f11) - f3;
        String str = "" + (((int) (((double) ((fMin2 * 100.0f) / Math.abs(f10 - f4))) + 0.5d)) / 100.0f);
        Paint paint = this.f12708h;
        paint.getTextBounds(str, 0, str.length(), this.f12712l);
        Rect rect = this.f12712l;
        canvas.drawText(str, ((fMin2 / 2.0f) - (rect.width() / 2)) + fMin, f3 - 20.0f, paint);
        float fMin3 = Math.min(f4, f10);
        Paint paint2 = this.f12707g;
        canvas.drawLine(f, f3, fMin3, f3, paint2);
        String str2 = "" + (((int) (((double) ((fMax2 * 100.0f) / Math.abs(f11 - f5))) + 0.5d)) / 100.0f);
        paint.getTextBounds(str2, 0, str2.length(), this.f12712l);
        canvas.drawText(str2, f + 5.0f, fMax - ((fMax2 / 2.0f) - (rect.height() / 2)), paint);
        canvas.drawLine(f, f3, f, Math.max(f5, f11), paint2);
    }

    public final void m7527d(Canvas canvas, float f, float f3) {
        float[] fArr = this.f12701a;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f10 = fArr[fArr.length - 2];
        float f11 = fArr[fArr.length - 1];
        float fHypot = (float) Math.hypot(f4 - f10, f5 - f11);
        float f12 = f10 - f4;
        float f13 = f11 - f5;
        float f14 = (((f3 - f5) * f13) + ((f - f4) * f12)) / (fHypot * fHypot);
        float f15 = f4 + (f12 * f14);
        float f16 = f5 + (f14 * f13);
        Path path = new Path();
        path.moveTo(f, f3);
        path.lineTo(f15, f16);
        float fHypot2 = (float) Math.hypot(f15 - f, f16 - f3);
        String str = "" + (((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
        Paint paint = this.f12708h;
        paint.getTextBounds(str, 0, str.length(), this.f12712l);
        canvas.drawTextOnPath(str, path, (fHypot2 / 2.0f) - (this.f12712l.width() / 2), -20.0f, paint);
        canvas.drawLine(f, f3, f15, f16, this.f12707g);
    }

    public final void m7528e(Canvas canvas, float f, float f3, int i6, int i10) {
        StringBuilder sb = new StringBuilder("");
        MotionLayout motionLayout = this.f12714n;
        sb.append(((int) (((double) (((f - (i6 / 2)) * 100.0f) / (motionLayout.getWidth() - i6))) + 0.5d)) / 100.0f);
        String string = sb.toString();
        Paint paint = this.f12708h;
        paint.getTextBounds(string, 0, string.length(), this.f12712l);
        Rect rect = this.f12712l;
        canvas.drawText(string, ((f / 2.0f) - (rect.width() / 2)) + 0.0f, f3 - 20.0f, paint);
        float fMin = Math.min(0.0f, 1.0f);
        Paint paint2 = this.f12707g;
        canvas.drawLine(f, f3, fMin, f3, paint2);
        String str = "" + (((int) (((double) (((f3 - (i10 / 2)) * 100.0f) / (motionLayout.getHeight() - i10))) + 0.5d)) / 100.0f);
        paint.getTextBounds(str, 0, str.length(), this.f12712l);
        canvas.drawText(str, f + 5.0f, 0.0f - ((f3 / 2.0f) - (rect.height() / 2)), paint);
        canvas.drawLine(f, f3, f, Math.max(0.0f, 1.0f), paint2);
    }
}

package p178q6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import p156o9.AbstractC3281e;

public final class C3509f extends AbstractC3516m {

    public int f11815c;

    public float f11816d;

    public float f11817e;

    public float f11818f;

    public C3509f(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.f11815c = 1;
    }

    @Override
    public final void mo7149a(Canvas canvas, float f) {
        AbstractC3508e abstractC3508e = this.f11853a;
        float f3 = (((CircularProgressIndicatorSpec) abstractC3508e).f6596g / 2.0f) + ((CircularProgressIndicatorSpec) abstractC3508e).f6597h;
        canvas.translate(f3, f3);
        canvas.rotate(-90.0f);
        float f4 = -f3;
        canvas.clipRect(f4, f4, f3, f3);
        this.f11815c = ((CircularProgressIndicatorSpec) abstractC3508e).f6598i == 0 ? 1 : -1;
        this.f11816d = ((CircularProgressIndicatorSpec) abstractC3508e).f11809a * f;
        this.f11817e = ((CircularProgressIndicatorSpec) abstractC3508e).f11810b * f;
        this.f11818f = (((CircularProgressIndicatorSpec) abstractC3508e).f6596g - ((CircularProgressIndicatorSpec) abstractC3508e).f11809a) / 2.0f;
        if ((this.f11854b.m7165d() && ((CircularProgressIndicatorSpec) abstractC3508e).f11813e == 2) || (this.f11854b.m7164c() && ((CircularProgressIndicatorSpec) abstractC3508e).f11814f == 1)) {
            this.f11818f = (((1.0f - f) * ((CircularProgressIndicatorSpec) abstractC3508e).f11809a) / 2.0f) + this.f11818f;
        } else if ((this.f11854b.m7165d() && ((CircularProgressIndicatorSpec) abstractC3508e).f11813e == 1) || (this.f11854b.m7164c() && ((CircularProgressIndicatorSpec) abstractC3508e).f11814f == 2)) {
            this.f11818f -= ((1.0f - f) * ((CircularProgressIndicatorSpec) abstractC3508e).f11809a) / 2.0f;
        }
    }

    @Override
    public final void mo7150b(Canvas canvas, Paint paint, float f, float f3, int i6) {
        if (f == f3) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i6);
        paint.setStrokeWidth(this.f11816d);
        float f4 = this.f11815c;
        float f5 = f * 360.0f * f4;
        float f10 = (f3 >= f ? f3 - f : (1.0f + f3) - f) * 360.0f * f4;
        float f11 = this.f11818f;
        float f12 = -f11;
        canvas.drawArc(new RectF(f12, f12, f11, f11), f5, f10, false, paint);
        if (this.f11817e <= 0.0f || Math.abs(f10) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        m7154f(canvas, paint, this.f11816d, this.f11817e, f5);
        m7154f(canvas, paint, this.f11816d, this.f11817e, f5 + f10);
    }

    @Override
    public final void mo7151c(Canvas canvas, Paint paint) {
        int iM6620j = AbstractC3281e.m6620j(((CircularProgressIndicatorSpec) this.f11853a).f11812d, this.f11854b.f11852j);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(iM6620j);
        paint.setStrokeWidth(this.f11816d);
        float f = this.f11818f;
        canvas.drawArc(new RectF(-f, -f, f, f), 0.0f, 360.0f, false, paint);
    }

    @Override
    public final int mo7152d() {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.f11853a;
        return (circularProgressIndicatorSpec.f6597h * 2) + circularProgressIndicatorSpec.f6596g;
    }

    @Override
    public final int mo7153e() {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.f11853a;
        return (circularProgressIndicatorSpec.f6597h * 2) + circularProgressIndicatorSpec.f6596g;
    }

    public final void m7154f(Canvas canvas, Paint paint, float f, float f3, float f4) {
        canvas.save();
        canvas.rotate(f4);
        float f5 = this.f11818f;
        float f10 = f / 2.0f;
        canvas.drawRoundRect(new RectF(f5 - f10, f3, f5 + f10, -f3), f3, f3, paint);
        canvas.restore();
    }
}

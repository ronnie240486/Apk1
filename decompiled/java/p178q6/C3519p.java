package p178q6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import p156o9.AbstractC3281e;

public final class C3519p extends AbstractC3516m {

    public float f11860c;

    public float f11861d;

    public float f11862e;

    public C3519p(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.f11860c = 300.0f;
    }

    @Override
    public final void mo7149a(Canvas canvas, float f) {
        Rect clipBounds = canvas.getClipBounds();
        this.f11860c = clipBounds.width();
        AbstractC3508e abstractC3508e = this.f11853a;
        float f3 = ((LinearProgressIndicatorSpec) abstractC3508e).f11809a;
        canvas.translate((clipBounds.width() / 2.0f) + clipBounds.left, Math.max(0.0f, (clipBounds.height() - ((LinearProgressIndicatorSpec) abstractC3508e).f11809a) / 2.0f) + (clipBounds.height() / 2.0f) + clipBounds.top);
        if (((LinearProgressIndicatorSpec) abstractC3508e).f6602i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f11854b.m7165d() && ((LinearProgressIndicatorSpec) abstractC3508e).f11813e == 1) || (this.f11854b.m7164c() && ((LinearProgressIndicatorSpec) abstractC3508e).f11814f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f11854b.m7165d() || this.f11854b.m7164c()) {
            canvas.translate(0.0f, ((f - 1.0f) * ((LinearProgressIndicatorSpec) abstractC3508e).f11809a) / 2.0f);
        }
        float f4 = this.f11860c;
        canvas.clipRect((-f4) / 2.0f, (-f3) / 2.0f, f4 / 2.0f, f3 / 2.0f);
        this.f11861d = ((LinearProgressIndicatorSpec) abstractC3508e).f11809a * f;
        this.f11862e = ((LinearProgressIndicatorSpec) abstractC3508e).f11810b * f;
    }

    @Override
    public final void mo7150b(Canvas canvas, Paint paint, float f, float f3, int i6) {
        if (f == f3) {
            return;
        }
        float f4 = this.f11860c;
        float f5 = (-f4) / 2.0f;
        float f10 = this.f11862e * 2.0f;
        float f11 = f4 - f10;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i6);
        float f12 = this.f11861d;
        RectF rectF = new RectF((f * f11) + f5, (-f12) / 2.0f, (f11 * f3) + f5 + f10, f12 / 2.0f);
        float f13 = this.f11862e;
        canvas.drawRoundRect(rectF, f13, f13, paint);
    }

    @Override
    public final void mo7151c(Canvas canvas, Paint paint) {
        int iM6620j = AbstractC3281e.m6620j(((LinearProgressIndicatorSpec) this.f11853a).f11812d, this.f11854b.f11852j);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(iM6620j);
        float f = this.f11860c;
        float f3 = this.f11861d;
        RectF rectF = new RectF((-f) / 2.0f, (-f3) / 2.0f, f / 2.0f, f3 / 2.0f);
        float f4 = this.f11862e;
        canvas.drawRoundRect(rectF, f4, f4, paint);
    }

    @Override
    public final int mo7152d() {
        return ((LinearProgressIndicatorSpec) this.f11853a).f11809a;
    }

    @Override
    public final int mo7153e() {
        return -1;
    }
}

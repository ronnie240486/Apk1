package p221u6;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import p211t6.C3811a;

public final class C3918r extends AbstractC3922v {

    public final C3920t f13192b;

    public final float f13193c;

    public final float f13194d;

    public C3918r(C3920t c3920t, float f, float f3) {
        this.f13192b = c3920t;
        this.f13193c = f;
        this.f13194d = f3;
    }

    @Override
    public final void mo7829a(Matrix matrix, C3811a c3811a, int i6, Canvas canvas) {
        C3920t c3920t = this.f13192b;
        float f = c3920t.f13203c;
        float f3 = this.f13194d;
        float f4 = c3920t.f13202b;
        float f5 = this.f13193c;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f - f3, f4 - f5), 0.0f);
        Matrix matrix2 = new Matrix(matrix);
        matrix2.preTranslate(f5, f3);
        matrix2.preRotate(m7830b());
        c3811a.getClass();
        rectF.bottom += i6;
        rectF.offset(0.0f, -i6);
        int[] iArr = C3811a.f12860i;
        iArr[0] = c3811a.f12869f;
        iArr[1] = c3811a.f12868e;
        iArr[2] = c3811a.f12867d;
        Paint paint = c3811a.f12866c;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, C3811a.f12861j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float m7830b() {
        C3920t c3920t = this.f13192b;
        return (float) Math.toDegrees(Math.atan((c3920t.f13203c - this.f13194d) / (c3920t.f13202b - this.f13193c)));
    }
}

package p221u6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import p211t6.C3811a;

public final class C3917q extends AbstractC3922v {

    public final C3919s f13191b;

    public C3917q(C3919s c3919s) {
        this.f13191b = c3919s;
    }

    @Override
    public final void mo7829a(Matrix matrix, C3811a c3811a, int i6, Canvas canvas) {
        C3919s c3919s = this.f13191b;
        float f = c3919s.f13200f;
        float f3 = c3919s.f13201g;
        RectF rectF = new RectF(c3919s.f13196b, c3919s.f13197c, c3919s.f13198d, c3919s.f13199e);
        c3811a.getClass();
        boolean z7 = f3 < 0.0f;
        Path path = c3811a.f12870g;
        int[] iArr = C3811a.f12862k;
        if (z7) {
            iArr[0] = 0;
            iArr[1] = c3811a.f12869f;
            iArr[2] = c3811a.f12868e;
            iArr[3] = c3811a.f12867d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f, f3);
            path.close();
            float f4 = -i6;
            rectF.inset(f4, f4);
            iArr[0] = 0;
            iArr[1] = c3811a.f12867d;
            iArr[2] = c3811a.f12868e;
            iArr[3] = c3811a.f12869f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f5 = 1.0f - (i6 / fWidth);
        float[] fArr = C3811a.f12863l;
        fArr[1] = f5;
        fArr[2] = ((1.0f - f5) / 2.0f) + f5;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP);
        Paint paint = c3811a.f12865b;
        paint.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z7) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, c3811a.f12871h);
        }
        canvas.drawArc(rectF, f, f3, true, paint);
        canvas.restore();
    }
}

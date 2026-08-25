package p178q6;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;

public final class C3518o extends AbstractC3515l {

    public final AbstractC3516m f11858l;

    public AbstractC3517n f11859m;

    public C3518o(Context context, AbstractC3508e abstractC3508e, AbstractC3516m abstractC3516m, AbstractC3517n abstractC3517n) {
        super(context, abstractC3508e);
        this.f11858l = abstractC3516m;
        abstractC3516m.f11854b = this;
        this.f11859m = abstractC3517n;
        abstractC3517n.f11855a = this;
    }

    @Override
    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        AbstractC3516m abstractC3516m = this.f11858l;
        float fM7163b = m7163b();
        abstractC3516m.f11853a.mo4303a();
        abstractC3516m.mo7149a(canvas, fM7163b);
        AbstractC3516m abstractC3516m2 = this.f11858l;
        Paint paint = this.f11851i;
        abstractC3516m2.mo7151c(canvas, paint);
        int i6 = 0;
        while (true) {
            AbstractC3517n abstractC3517n = this.f11859m;
            int[] iArr = abstractC3517n.f11857c;
            if (i6 >= iArr.length) {
                canvas.restore();
                return;
            }
            AbstractC3516m abstractC3516m3 = this.f11858l;
            float[] fArr = abstractC3517n.f11856b;
            int i10 = i6 * 2;
            abstractC3516m3.mo7150b(canvas, paint, fArr[i10], fArr[i10 + 1], iArr[i6]);
            i6++;
        }
    }

    @Override
    public final boolean mo7161f(boolean z7, boolean z10, boolean z11) {
        boolean zMo7161f = super.mo7161f(z7, z10, z11);
        if (!isRunning()) {
            this.f11859m.mo7155a();
        }
        C3504a c3504a = this.f11845c;
        ContentResolver contentResolver = this.f11843a.getContentResolver();
        c3504a.getClass();
        float f = Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        if (z7 && (z11 || (Build.VERSION.SDK_INT <= 21 && f > 0.0f))) {
            this.f11859m.mo7159e();
        }
        return zMo7161f;
    }

    @Override
    public final int getIntrinsicHeight() {
        return this.f11858l.mo7152d();
    }

    @Override
    public final int getIntrinsicWidth() {
        return this.f11858l.mo7153e();
    }
}

package p066g1;

import android.view.animation.Interpolator;
import p055ea.AbstractC2460q;

public abstract class AbstractInterpolatorC2593b implements Interpolator {

    public final float[] f9043a;

    public final float f9044b;

    public AbstractInterpolatorC2593b(float[] fArr) {
        this.f9043a = fArr;
        this.f9044b = 1.0f / (fArr.length - 1);
    }

    @Override
    public final float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f9043a;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f3 = this.f9044b;
        float f4 = (f - (iMin * f3)) / f3;
        float f5 = fArr[iMin];
        return AbstractC2460q.m5490d(fArr[iMin + 1], f5, f4, f5);
    }
}

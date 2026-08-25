package androidx.recyclerview.widget;

import android.view.animation.Interpolator;

public final class InterpolatorC1149h0 implements Interpolator {
    @Override
    public final float getInterpolation(float f) {
        float f3 = f - 1.0f;
        return (f3 * f3 * f3 * f3 * f3) + 1.0f;
    }
}

package p015b2;

import android.view.animation.Interpolator;

public final class InterpolatorC1253e implements Interpolator {

    public final int f3977a;

    @Override
    public final float getInterpolation(float f) {
        switch (this.f3977a) {
            case 0:
                float f3 = f - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            default:
                float f4 = f - 1.0f;
                return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    }
}

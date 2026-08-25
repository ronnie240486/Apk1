package p205t;

import android.view.animation.Interpolator;
import p194s.C3681e;

public final class InterpolatorC3786z implements Interpolator {

    public final C3681e f12748a;

    public InterpolatorC3786z(C3681e c3681e) {
        this.f12748a = c3681e;
    }

    @Override
    public final float getInterpolation(float f) {
        return (float) this.f12748a.mo7428a(f);
    }
}

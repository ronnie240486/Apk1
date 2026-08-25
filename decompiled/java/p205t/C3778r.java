package p205t;

import androidx.constraintlayout.motion.widget.MotionLayout;

public final class C3778r extends AbstractInterpolatorC3776p {

    public float f12697a = 0.0f;

    public float f12698b = 0.0f;

    public float f12699c;

    public final MotionLayout f12700d;

    public C3778r(MotionLayout motionLayout) {
        this.f12700d = motionLayout;
    }

    @Override
    public final float mo7435a() {
        return this.f12700d.f1235s;
    }

    @Override
    public final float getInterpolation(float f) {
        float f3 = this.f12697a;
        MotionLayout motionLayout = this.f12700d;
        if (f3 > 0.0f) {
            float f4 = this.f12699c;
            if (f3 / f4 < f) {
                f = f3 / f4;
            }
            motionLayout.f1235s = f3 - (f4 * f);
            return ((f3 * f) - (((f4 * f) * f) / 2.0f)) + this.f12698b;
        }
        float f5 = this.f12699c;
        if ((-f3) / f5 < f) {
            f = (-f3) / f5;
        }
        motionLayout.f1235s = (f5 * f) + f3;
        return (((f5 * f) * f) / 2.0f) + (f3 * f) + this.f12698b;
    }
}

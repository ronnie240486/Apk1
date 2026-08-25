package p161p0;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

public abstract class AbstractC3349a {
    public static Interpolator m6821a(float f, float f3) {
        return new PathInterpolator(f, f3);
    }

    public static Interpolator m6822b(float f, float f3, float f4, float f5) {
        return new PathInterpolator(f, f3, f4, f5);
    }

    public static Interpolator m6823c(Path path) {
        return new PathInterpolator(path);
    }
}

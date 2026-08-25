package p147o;

import android.graphics.drawable.Drawable;

public abstract class AbstractC3225b extends Drawable {

    public static final double f10836a = Math.cos(Math.toRadians(45.0d));

    public static float m6510a(float f, float f3, boolean z7) {
        if (!z7) {
            return f;
        }
        return (float) (((1.0d - f10836a) * ((double) f3)) + ((double) f));
    }

    public static float m6511b(float f, float f3, boolean z7) {
        if (!z7) {
            return f * 1.5f;
        }
        return (float) (((1.0d - f10836a) * ((double) f3)) + ((double) (f * 1.5f)));
    }
}

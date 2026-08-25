package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

public abstract class AbstractC0373f {
    public static EdgeEffect m1123a(Context context, AttributeSet attributeSet) {
        try {
            return new EdgeEffect(context, attributeSet);
        } catch (Throwable unused) {
            return new EdgeEffect(context);
        }
    }

    public static float m1124b(EdgeEffect edgeEffect) {
        try {
            return edgeEffect.getDistance();
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static float m1125c(EdgeEffect edgeEffect, float f, float f3) {
        try {
            return edgeEffect.onPullDistance(f, f3);
        } catch (Throwable unused) {
            edgeEffect.onPull(f, f3);
            return 0.0f;
        }
    }
}

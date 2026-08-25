package p138n0;

import android.view.VelocityTracker;

public abstract class AbstractC3170y {
    public static float m6365a(VelocityTracker velocityTracker, int i6) {
        return velocityTracker.getAxisVelocity(i6);
    }

    public static float m6366b(VelocityTracker velocityTracker, int i6, int i10) {
        return velocityTracker.getAxisVelocity(i6, i10);
    }

    public static boolean m6367c(VelocityTracker velocityTracker, int i6) {
        return velocityTracker.isAxisSupported(i6);
    }
}

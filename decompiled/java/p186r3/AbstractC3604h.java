package p186r3;

import android.os.SystemClock;

public abstract class AbstractC3604h {

    public static final double f12100a = 1.0d / Math.pow(10.0d, 6.0d);

    public static final int f12101b = 0;

    public static double m7226a(long j10) {
        return (SystemClock.elapsedRealtimeNanos() - j10) * f12100a;
    }
}

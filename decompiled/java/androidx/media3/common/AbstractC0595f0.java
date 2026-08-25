package androidx.media3.common;

import android.os.SystemClock;

public abstract class AbstractC0595f0 {
    static {
        SimpleBasePlayer.PositionSupplier positionSupplier = SimpleBasePlayer.PositionSupplier.ZERO;
    }

    public static SimpleBasePlayer.PositionSupplier m1647a(long j10) {
        return new C0593e0(j10);
    }

    public static SimpleBasePlayer.PositionSupplier m1648b(final long j10, final float f) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        return new SimpleBasePlayer.PositionSupplier() {
            @Override
            public final long get() {
                return AbstractC0595f0.m1650d(j10, jElapsedRealtime, f);
            }
        };
    }

    public static long m1650d(long j10, long j11, float f) {
        return j10 + ((long) ((SystemClock.elapsedRealtime() - j11) * f));
    }

    public static long m1649c(long j10) {
        return j10;
    }
}

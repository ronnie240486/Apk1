package com.google.common.util.concurrent;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p020b7.AbstractC1332b;
import p020b7.C1337d0;

@ElementTypesAreNonnullByDefault
public abstract class RateLimiter {
    private volatile Object mutexDoNotUseDirectly;
    private final SleepingStopwatch stopwatch;

    public static abstract class SleepingStopwatch {
        public static SleepingStopwatch createFromSystemTimer() {
            return new SleepingStopwatch() {
                final C1337d0 stopwatch;

                {
                    C1337d0 c1337d0 = new C1337d0();
                    AbstractC1332b.m3223n("This stopwatch is already running.", !c1337d0.f4151a);
                    c1337d0.f4151a = true;
                    c1337d0.f4153c = System.nanoTime();
                    this.stopwatch = c1337d0;
                }

                @Override
                public long readMicros() {
                    C1337d0 c1337d0 = this.stopwatch;
                    return TimeUnit.MICROSECONDS.convert(c1337d0.f4151a ? (System.nanoTime() - c1337d0.f4153c) + c1337d0.f4152b : c1337d0.f4152b, TimeUnit.NANOSECONDS);
                }

                @Override
                public void sleepMicrosUninterruptibly(long j10) {
                    if (j10 > 0) {
                        Uninterruptibles.sleepUninterruptibly(j10, TimeUnit.MICROSECONDS);
                    }
                }
            };
        }

        public abstract long readMicros();

        public abstract void sleepMicrosUninterruptibly(long j10);
    }

    public RateLimiter(SleepingStopwatch sleepingStopwatch) {
        sleepingStopwatch.getClass();
        this.stopwatch = sleepingStopwatch;
    }

    private boolean canAcquire(long j10, long j11) {
        return queryEarliestAvailable(j10) - j11 <= j10;
    }

    private static void checkPermits(int i6) {
        if (!(i6 > 0)) {
            throw new IllegalArgumentException(AbstractC1332b.m3228s("Requested permits (%s) must be positive", Integer.valueOf(i6)));
        }
    }

    public static RateLimiter create(double d) {
        return create(d, SleepingStopwatch.createFromSystemTimer());
    }

    private Object mutex() {
        Object obj = this.mutexDoNotUseDirectly;
        if (obj == null) {
            synchronized (this) {
                try {
                    obj = this.mutexDoNotUseDirectly;
                    if (obj == null) {
                        obj = new Object();
                        this.mutexDoNotUseDirectly = obj;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return obj;
    }

    public double acquire() {
        return acquire(1);
    }

    public abstract double doGetRate();

    public abstract void doSetRate(double d, long j10);

    public final double getRate() {
        double dDoGetRate;
        synchronized (mutex()) {
            dDoGetRate = doGetRate();
        }
        return dDoGetRate;
    }

    public abstract long queryEarliestAvailable(long j10);

    public final long reserve(int i6) {
        long jReserveAndGetWaitLength;
        checkPermits(i6);
        synchronized (mutex()) {
            jReserveAndGetWaitLength = reserveAndGetWaitLength(i6, this.stopwatch.readMicros());
        }
        return jReserveAndGetWaitLength;
    }

    public final long reserveAndGetWaitLength(int i6, long j10) {
        return Math.max(reserveEarliestAvailable(i6, j10) - j10, 0L);
    }

    public abstract long reserveEarliestAvailable(int i6, long j10);

    public final void setRate(double d) {
        AbstractC1332b.m3214e("rate must be positive", d > 0.0d);
        synchronized (mutex()) {
            doSetRate(d, this.stopwatch.readMicros());
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(getRate()));
    }

    public boolean tryAcquire(long j10, TimeUnit timeUnit) {
        return tryAcquire(1, j10, timeUnit);
    }

    public static RateLimiter create(double d, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothBursty smoothBursty = new SmoothRateLimiter.SmoothBursty(sleepingStopwatch, 1.0d);
        smoothBursty.setRate(d);
        return smoothBursty;
    }

    public double acquire(int i6) {
        long jReserve = reserve(i6);
        this.stopwatch.sleepMicrosUninterruptibly(jReserve);
        return (jReserve * 1.0d) / TimeUnit.SECONDS.toMicros(1L);
    }

    public boolean tryAcquire(int i6) {
        return tryAcquire(i6, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
    }

    public static RateLimiter create(double d, long j10, TimeUnit timeUnit) {
        AbstractC1332b.m3216g(j10 >= 0, "warmupPeriod must not be negative: %s", j10);
        return create(d, j10, timeUnit, 3.0d, SleepingStopwatch.createFromSystemTimer());
    }

    public boolean tryAcquire(int i6, long j10, TimeUnit timeUnit) {
        long jMax = Math.max(timeUnit.toMicros(j10), 0L);
        checkPermits(i6);
        synchronized (mutex()) {
            try {
                long micros = this.stopwatch.readMicros();
                if (!canAcquire(micros, jMax)) {
                    return false;
                }
                this.stopwatch.sleepMicrosUninterruptibly(reserveAndGetWaitLength(i6, micros));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static RateLimiter create(double d, long j10, TimeUnit timeUnit, double d10, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new SmoothRateLimiter.SmoothWarmingUp(sleepingStopwatch, j10, timeUnit, d10);
        smoothWarmingUp.setRate(d);
        return smoothWarmingUp;
    }
}

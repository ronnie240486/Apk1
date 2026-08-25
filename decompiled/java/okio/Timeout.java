package okio;

import androidx.media3.common.PlaybackException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import p000a.AbstractC0004e;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p204s9.AbstractC3727a;
import p204s9.EnumC3729c;

public class Timeout {
    public static final Companion Companion = new Companion(null);
    public static final Timeout NONE = new Timeout() {
        @Override
        public Timeout timeout(long j10, TimeUnit timeUnit) {
            AbstractC2796i.m5785f(timeUnit, "unit");
            return this;
        }

        @Override
        public void throwIfReached() {
        }

        @Override
        public Timeout deadlineNanoTime(long j10) {
            return this;
        }
    };
    private volatile Object cancelMark;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final long minTimeout(long j10, long j11) {
            return (j10 != 0 && (j11 == 0 || j10 < j11)) ? j10 : j11;
        }

        public final Timeout timeout(Timeout timeout, long j10, EnumC3729c enumC3729c) {
            AbstractC2796i.m5785f(timeout, "<this>");
            AbstractC2796i.m5785f(enumC3729c, "unit");
            return timeout.timeout(j10, enumC3729c.f12496a);
        }

        public final Timeout m8581timeoutHG0u8IE(Timeout timeout, long j10) {
            AbstractC2796i.m5785f(timeout, "$this$timeout");
            long j11 = j10 >> 1;
            int i6 = AbstractC3727a.f12493a;
            if ((((int) j10) & 1) != 0) {
                if (j11 > 9223372036854L) {
                    j11 = Long.MAX_VALUE;
                } else {
                    j11 = j11 < -9223372036854L ? Long.MIN_VALUE : j11 * ((long) PlaybackException.CUSTOM_ERROR_CODE_BASE);
                }
            }
            return timeout.timeout(j11, TimeUnit.NANOSECONDS);
        }

        private Companion() {
        }
    }

    public void awaitSignal(Condition condition) throws InterruptedIOException {
        AbstractC2796i.m5785f(condition, "condition");
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            if (!zHasDeadline && jTimeoutNanos == 0) {
                condition.await();
                return;
            }
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - System.nanoTime());
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - System.nanoTime();
            }
            if (jTimeoutNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object obj = this.cancelMark;
            if (condition.awaitNanos(jTimeoutNanos) <= 0 && this.cancelMark == obj) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public void cancel() {
        this.cancelMark = new Object();
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final Timeout deadline(long j10, TimeUnit timeUnit) {
        AbstractC2796i.m5785f(timeUnit, "unit");
        if (j10 <= 0) {
            throw new IllegalArgumentException(AbstractC0004e.m21o(j10, "duration <= 0: ").toString());
        }
        return deadlineNanoTime(timeUnit.toNanos(j10) + System.nanoTime());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(Timeout timeout, InterfaceC2713a interfaceC2713a) {
        AbstractC2796i.m5785f(timeout, "other");
        AbstractC2796i.m5785f(interfaceC2713a, "block");
        long jTimeoutNanos = timeoutNanos();
        timeout(Companion.minTimeout(timeout.timeoutNanos(), timeoutNanos()), TimeUnit.NANOSECONDS);
        if (!hasDeadline()) {
            if (timeout.hasDeadline()) {
                deadlineNanoTime(timeout.deadlineNanoTime());
            }
            try {
                return (T) interfaceC2713a.invoke();
            } finally {
                timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout.hasDeadline()) {
                    clearDeadline();
                }
            }
        }
        long jDeadlineNanoTime = deadlineNanoTime();
        if (timeout.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), timeout.deadlineNanoTime()));
        }
        try {
            return (T) interfaceC2713a.invoke();
        } finally {
            timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout timeout(long j10, TimeUnit timeUnit) {
        AbstractC2796i.m5785f(timeUnit, "unit");
        if (j10 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m21o(j10, "timeout < 0: ").toString());
        }
        this.timeoutNanos = timeUnit.toNanos(j10);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public void waitUntilNotified(Object obj) throws InterruptedIOException {
        AbstractC2796i.m5785f(obj, "monitor");
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            if (!zHasDeadline && jTimeoutNanos == 0) {
                obj.wait();
                return;
            }
            long jNanoTime = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime;
            }
            if (jTimeoutNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object obj2 = this.cancelMark;
            long j10 = jTimeoutNanos / 1000000;
            Long.signum(j10);
            obj.wait(j10, (int) (jTimeoutNanos - (1000000 * j10)));
            if (System.nanoTime() - jNanoTime >= jTimeoutNanos && this.cancelMark == obj2) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public Timeout deadlineNanoTime(long j10) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j10;
        return this;
    }
}

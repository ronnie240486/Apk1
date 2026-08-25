package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public class AsyncTimeout extends Timeout {
    private static final Companion Companion = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int STATE_CANCELED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_QUEUE = 1;
    private static final int STATE_TIMED_OUT = 2;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static final Condition condition;
    private static AsyncTimeout head;
    private static final ReentrantLock lock;
    private AsyncTimeout next;
    private int state;
    private long timeoutAt;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final void insertIntoQueue(AsyncTimeout asyncTimeout, long j10, boolean z7) {
            if (AsyncTimeout.head == null) {
                AsyncTimeout.head = new AsyncTimeout();
                new Watchdog().start();
            }
            long jNanoTime = System.nanoTime();
            if (j10 != 0 && z7) {
                asyncTimeout.timeoutAt = Math.min(j10, asyncTimeout.deadlineNanoTime() - jNanoTime) + jNanoTime;
            } else if (j10 != 0) {
                asyncTimeout.timeoutAt = j10 + jNanoTime;
            } else {
                if (!z7) {
                    throw new AssertionError();
                }
                asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
            }
            long jRemainingNanos = asyncTimeout.remainingNanos(jNanoTime);
            AsyncTimeout asyncTimeout2 = AsyncTimeout.head;
            AbstractC2796i.m5782c(asyncTimeout2);
            while (asyncTimeout2.next != null) {
                AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                AbstractC2796i.m5782c(asyncTimeout3);
                if (jRemainingNanos < asyncTimeout3.remainingNanos(jNanoTime)) {
                    break;
                }
                asyncTimeout2 = asyncTimeout2.next;
                AbstractC2796i.m5782c(asyncTimeout2);
            }
            asyncTimeout.next = asyncTimeout2.next;
            asyncTimeout2.next = asyncTimeout;
            if (asyncTimeout2 == AsyncTimeout.head) {
                getCondition().signal();
            }
        }

        public final void removeFromQueue(AsyncTimeout asyncTimeout) {
            for (AsyncTimeout asyncTimeout2 = AsyncTimeout.head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                if (asyncTimeout2.next == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    return;
                }
            }
            throw new IllegalStateException("node was not found in the queue");
        }

        public final AsyncTimeout awaitTimeout() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            AbstractC2796i.m5782c(asyncTimeout);
            AsyncTimeout asyncTimeout2 = asyncTimeout.next;
            if (asyncTimeout2 == null) {
                long jNanoTime = System.nanoTime();
                getCondition().await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
                AbstractC2796i.m5782c(asyncTimeout3);
                if (asyncTimeout3.next != null || System.nanoTime() - jNanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long jRemainingNanos = asyncTimeout2.remainingNanos(System.nanoTime());
            if (jRemainingNanos > 0) {
                getCondition().await(jRemainingNanos, TimeUnit.NANOSECONDS);
                return null;
            }
            AsyncTimeout asyncTimeout4 = AsyncTimeout.head;
            AbstractC2796i.m5782c(asyncTimeout4);
            asyncTimeout4.next = asyncTimeout2.next;
            asyncTimeout2.next = null;
            asyncTimeout2.state = 2;
            return asyncTimeout2;
        }

        public final Condition getCondition() {
            return AsyncTimeout.condition;
        }

        public final ReentrantLock getLock() {
            return AsyncTimeout.lock;
        }

        private Companion() {
        }
    }

    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    ReentrantLock lock = AsyncTimeout.Companion.getLock();
                    lock.lock();
                    try {
                        AsyncTimeout asyncTimeoutAwaitTimeout = AsyncTimeout.Companion.awaitTimeout();
                        if (asyncTimeoutAwaitTimeout == AsyncTimeout.head) {
                            Companion unused = AsyncTimeout.Companion;
                            AsyncTimeout.head = null;
                            lock.unlock();
                            return;
                        } else {
                            lock.unlock();
                            if (asyncTimeoutAwaitTimeout != null) {
                                asyncTimeoutAwaitTimeout.timedOut();
                            }
                        }
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } catch (InterruptedException unused2) {
                    continue;
                }
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        AbstractC2796i.m5784e(conditionNewCondition, "newCondition(...)");
        condition = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final long remainingNanos(long j10) {
        return this.timeoutAt - j10;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    @Override
    public void cancel() {
        super.cancel();
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (this.state == 1) {
                Companion.removeFromQueue(this);
                this.state = 3;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void enter() {
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            ReentrantLock reentrantLock = lock;
            reentrantLock.lock();
            try {
                if (this.state != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.state = 1;
                Companion.insertIntoQueue(this, jTimeoutNanos, zHasDeadline);
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean exit() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            int i6 = this.state;
            this.state = 0;
            if (i6 != 1) {
                return i6 == 2;
            }
            Companion.removeFromQueue(this);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        AbstractC2796i.m5785f(sink, "sink");
        return new Sink() {
            @Override
            public void close() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Sink sink2 = sink;
                asyncTimeout.enter();
                try {
                    try {
                        sink2.close();
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(null);
                        }
                    } catch (IOException e5) {
                        if (!asyncTimeout.exit()) {
                            throw e5;
                        }
                        throw asyncTimeout.access$newTimeoutException(e5);
                    }
                } catch (Throwable th) {
                    asyncTimeout.exit();
                    throw th;
                }
            }

            @Override
            public void flush() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Sink sink2 = sink;
                asyncTimeout.enter();
                try {
                    try {
                        sink2.flush();
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(null);
                        }
                    } catch (IOException e5) {
                        if (!asyncTimeout.exit()) {
                            throw e5;
                        }
                        throw asyncTimeout.access$newTimeoutException(e5);
                    }
                } catch (Throwable th) {
                    asyncTimeout.exit();
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }

            @Override
            public void write(Buffer buffer, long j10) throws IOException {
                AbstractC2796i.m5785f(buffer, "source");
                SegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, j10);
                while (true) {
                    long j11 = 0;
                    if (j10 <= 0) {
                        return;
                    }
                    Segment segment = buffer.head;
                    AbstractC2796i.m5782c(segment);
                    while (j11 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                        j11 += (long) (segment.limit - segment.pos);
                        if (j11 >= j10) {
                            j11 = j10;
                            break;
                        } else {
                            segment = segment.next;
                            AbstractC2796i.m5782c(segment);
                        }
                    }
                    AsyncTimeout asyncTimeout = AsyncTimeout.this;
                    Sink sink2 = sink;
                    asyncTimeout.enter();
                    try {
                        try {
                            sink2.write(buffer, j11);
                            if (asyncTimeout.exit()) {
                                throw asyncTimeout.access$newTimeoutException(null);
                            }
                            j10 -= j11;
                        } catch (IOException e5) {
                            if (!asyncTimeout.exit()) {
                                throw e5;
                            }
                            throw asyncTimeout.access$newTimeoutException(e5);
                        }
                    } catch (Throwable th) {
                        asyncTimeout.exit();
                        throw th;
                    }
                }
            }

            @Override
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }
        };
    }

    public final Source source(final Source source) {
        AbstractC2796i.m5785f(source, "source");
        return new Source() {
            @Override
            public void close() throws IOException {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Source source2 = source;
                asyncTimeout.enter();
                try {
                    try {
                        source2.close();
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(null);
                        }
                    } catch (IOException e5) {
                        if (!asyncTimeout.exit()) {
                            throw e5;
                        }
                        throw asyncTimeout.access$newTimeoutException(e5);
                    }
                } catch (Throwable th) {
                    asyncTimeout.exit();
                    throw th;
                }
            }

            @Override
            public long read(Buffer buffer, long j10) throws IOException {
                AbstractC2796i.m5785f(buffer, "sink");
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Source source2 = source;
                asyncTimeout.enter();
                try {
                    try {
                        long j11 = source2.read(buffer, j10);
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(null);
                        }
                        return j11;
                    } catch (IOException e5) {
                        if (asyncTimeout.exit()) {
                            throw asyncTimeout.access$newTimeoutException(e5);
                        }
                        throw e5;
                    }
                } catch (Throwable th) {
                    asyncTimeout.exit();
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }

            @Override
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }
        };
    }

    public final <T> T withTimeout(InterfaceC2713a interfaceC2713a) throws IOException {
        AbstractC2796i.m5785f(interfaceC2713a, "block");
        enter();
        try {
            try {
                T t5 = (T) interfaceC2713a.invoke();
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                return t5;
            } catch (IOException e5) {
                if (exit()) {
                    throw access$newTimeoutException(e5);
                }
                throw e5;
            }
        } catch (Throwable th) {
            exit();
            throw th;
        }
    }

    public void timedOut() {
    }
}

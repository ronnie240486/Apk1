package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import p000a.AbstractC0004e;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;

public final class Pipe {
    private final Buffer buffer = new Buffer();
    private boolean canceled;
    private final Condition condition;
    private Sink foldedSink;
    private final ReentrantLock lock;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j10) {
        this.maxBufferSize = j10;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        AbstractC2796i.m5784e(conditionNewCondition, "newCondition(...)");
        this.condition = conditionNewCondition;
        if (j10 < 1) {
            throw new IllegalArgumentException(AbstractC0004e.m21o(j10, "maxBufferSize < 1: ").toString());
        }
        this.sink = new Sink() {
            private final Timeout timeout = new Timeout();

            @Override
            public void close() {
                boolean zHasDeadline;
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed$okio()) {
                        lock.unlock();
                        return;
                    }
                    Sink foldedSink$okio = pipe.getFoldedSink$okio();
                    if (foldedSink$okio == null) {
                        if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        pipe.setSinkClosed$okio(true);
                        pipe.getCondition().signalAll();
                        foldedSink$okio = null;
                    }
                    lock.unlock();
                    if (foldedSink$okio != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe2.sink().timeout();
                        long jTimeoutNanos = timeout.timeoutNanos();
                        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.close();
                                if (zHasDeadline) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            }
                        }
                        long jDeadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.close();
                        } finally {
                            timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(jDeadlineNanoTime);
                            }
                        }
                    }
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }

            @Override
            public void flush() {
                boolean zHasDeadline;
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed$okio()) {
                        throw new IllegalStateException("closed");
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    Sink foldedSink$okio = pipe.getFoldedSink$okio();
                    if (foldedSink$okio == null) {
                        if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        foldedSink$okio = null;
                    }
                    lock.unlock();
                    if (foldedSink$okio != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe2.sink().timeout();
                        long jTimeoutNanos = timeout.timeoutNanos();
                        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.flush();
                                if (zHasDeadline) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            }
                        }
                        long jDeadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.flush();
                        } finally {
                            timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(jDeadlineNanoTime);
                            }
                        }
                    }
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }

            @Override
            public Timeout timeout() {
                return this.timeout;
            }

            @Override
            public void write(Buffer buffer, long j11) {
                Sink foldedSink$okio;
                boolean zHasDeadline;
                AbstractC2796i.m5785f(buffer, "source");
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed$okio()) {
                        throw new IllegalStateException("closed");
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    while (true) {
                        if (j11 <= 0) {
                            foldedSink$okio = null;
                            break;
                        }
                        foldedSink$okio = pipe.getFoldedSink$okio();
                        if (foldedSink$okio != null) {
                            break;
                        }
                        if (pipe.getSourceClosed$okio()) {
                            throw new IOException("source is closed");
                        }
                        long maxBufferSize$okio = pipe.getMaxBufferSize$okio() - pipe.getBuffer$okio().size();
                        if (maxBufferSize$okio == 0) {
                            this.timeout.awaitSignal(pipe.getCondition());
                            if (pipe.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                        } else {
                            long jMin = Math.min(maxBufferSize$okio, j11);
                            pipe.getBuffer$okio().write(buffer, jMin);
                            j11 -= jMin;
                            pipe.getCondition().signalAll();
                        }
                    }
                    lock.unlock();
                    if (foldedSink$okio != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe2.sink().timeout();
                        long jTimeoutNanos = timeout.timeoutNanos();
                        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.write(buffer, j11);
                                if (zHasDeadline) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            }
                        }
                        long jDeadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.write(buffer, j11);
                        } finally {
                            timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(jDeadlineNanoTime);
                            }
                        }
                    }
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }
        };
        this.source = new Source() {
            private final Timeout timeout = new Timeout();

            @Override
            public void close() {
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    pipe.setSourceClosed$okio(true);
                    pipe.getCondition().signalAll();
                } finally {
                    lock.unlock();
                }
            }

            @Override
            public long read(Buffer buffer, long j11) {
                AbstractC2796i.m5785f(buffer, "sink");
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSourceClosed$okio()) {
                        throw new IllegalStateException("closed");
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    while (pipe.getBuffer$okio().size() == 0) {
                        if (pipe.getSinkClosed$okio()) {
                            lock.unlock();
                            return -1L;
                        }
                        this.timeout.awaitSignal(pipe.getCondition());
                        if (pipe.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                    }
                    long j12 = pipe.getBuffer$okio().read(buffer, j11);
                    pipe.getCondition().signalAll();
                    lock.unlock();
                    return j12;
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }

            @Override
            public Timeout timeout() {
                return this.timeout;
            }
        };
    }

    private final void forward(Sink sink, InterfaceC2724l interfaceC2724l) {
        boolean zHasDeadline;
        Timeout timeout = sink.timeout();
        Timeout timeout2 = sink().timeout();
        long jTimeoutNanos = timeout.timeoutNanos();
        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (!timeout.hasDeadline()) {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                interfaceC2724l.invoke(sink);
                if (zHasDeadline) {
                    return;
                } else {
                    return;
                }
            } finally {
                timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
            }
        }
        long jDeadlineNanoTime = timeout.deadlineNanoTime();
        if (timeout2.hasDeadline()) {
            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
        }
        try {
            interfaceC2724l.invoke(sink);
        } finally {
            timeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(jDeadlineNanoTime);
            }
        }
    }

    public final Sink m8579deprecated_sink() {
        return this.sink;
    }

    public final Source m8580deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.canceled = true;
            this.buffer.clear();
            this.condition.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void fold(Sink sink) throws IOException {
        Buffer buffer;
        boolean z7;
        AbstractC2796i.m5785f(sink, "sink");
        while (true) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.foldedSink != null) {
                    throw new IllegalStateException("sink already folded");
                }
                if (this.canceled) {
                    this.foldedSink = sink;
                    throw new IOException("canceled");
                }
                boolean z10 = this.sinkClosed;
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    buffer = null;
                    z7 = true;
                } else {
                    buffer = new Buffer();
                    Buffer buffer2 = this.buffer;
                    buffer.write(buffer2, buffer2.size());
                    this.condition.signalAll();
                    z7 = false;
                }
                reentrantLock.unlock();
                if (z7) {
                    if (z10) {
                        sink.close();
                        return;
                    }
                    return;
                }
                if (buffer == null) {
                    AbstractC2796i.m5791l("sinkBuffer");
                    throw null;
                }
                try {
                    sink.write(buffer, buffer.size());
                    sink.flush();
                } catch (Throwable th) {
                    ReentrantLock reentrantLock2 = this.lock;
                    reentrantLock2.lock();
                    this.sourceClosed = true;
                    this.condition.signalAll();
                    throw th;
                }
                ReentrantLock reentrantLock3 = this.lock;
                reentrantLock3.lock();
                try {
                    this.sourceClosed = true;
                    this.condition.signalAll();
                    throw th;
                } finally {
                    reentrantLock3.unlock();
                }
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z7) {
        this.canceled = z7;
    }

    public final void setFoldedSink$okio(Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z7) {
        this.sinkClosed = z7;
    }

    public final void setSourceClosed$okio(boolean z7) {
        this.sourceClosed = z7;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}

package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import p103j9.AbstractC2796i;

public class ForwardingTimeout extends Timeout {
    private Timeout delegate;

    public ForwardingTimeout(Timeout timeout) {
        AbstractC2796i.m5785f(timeout, "delegate");
        this.delegate = timeout;
    }

    @Override
    public void awaitSignal(Condition condition) throws InterruptedIOException {
        AbstractC2796i.m5785f(condition, "condition");
        this.delegate.awaitSignal(condition);
    }

    @Override
    public void cancel() {
        this.delegate.cancel();
    }

    @Override
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    public final Timeout delegate() {
        return this.delegate;
    }

    @Override
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    public final void m8575setDelegate(Timeout timeout) {
        AbstractC2796i.m5785f(timeout, "<set-?>");
        this.delegate = timeout;
    }

    @Override
    public void throwIfReached() throws IOException {
        this.delegate.throwIfReached();
    }

    @Override
    public Timeout timeout(long j10, TimeUnit timeUnit) {
        AbstractC2796i.m5785f(timeUnit, "unit");
        return this.delegate.timeout(j10, timeUnit);
    }

    @Override
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override
    public void waitUntilNotified(Object obj) throws InterruptedIOException {
        AbstractC2796i.m5785f(obj, "monitor");
        this.delegate.waitUntilNotified(obj);
    }

    @Override
    public Timeout deadlineNanoTime(long j10) {
        return this.delegate.deadlineNanoTime(j10);
    }

    public final ForwardingTimeout setDelegate(Timeout timeout) {
        AbstractC2796i.m5785f(timeout, "delegate");
        this.delegate = timeout;
        return this;
    }
}

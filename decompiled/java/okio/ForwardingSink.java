package okio;

import java.io.IOException;
import p103j9.AbstractC2796i;

public abstract class ForwardingSink implements Sink {
    private final Sink delegate;

    public ForwardingSink(Sink sink) {
        AbstractC2796i.m5785f(sink, "delegate");
        this.delegate = sink;
    }

    public final Sink m8573deprecated_delegate() {
        return this.delegate;
    }

    @Override
    public void close() throws IOException {
        this.delegate.close();
    }

    public final Sink delegate() {
        return this.delegate;
    }

    @Override
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override
    public void write(Buffer buffer, long j10) throws IOException {
        AbstractC2796i.m5785f(buffer, "source");
        this.delegate.write(buffer, j10);
    }
}

package okio;

import java.io.IOException;
import p103j9.AbstractC2796i;

public abstract class ForwardingSource implements Source {
    private final Source delegate;

    public ForwardingSource(Source source) {
        AbstractC2796i.m5785f(source, "delegate");
        this.delegate = source;
    }

    public final Source m8574deprecated_delegate() {
        return this.delegate;
    }

    @Override
    public void close() throws IOException {
        this.delegate.close();
    }

    public final Source delegate() {
        return this.delegate;
    }

    @Override
    public long read(Buffer buffer, long j10) throws IOException {
        AbstractC2796i.m5785f(buffer, "sink");
        return this.delegate.read(buffer, j10);
    }

    @Override
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}

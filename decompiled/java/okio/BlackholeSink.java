package okio;

import java.io.EOFException;
import p103j9.AbstractC2796i;

final class BlackholeSink implements Sink {
    @Override
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override
    public void write(Buffer buffer, long j10) throws EOFException {
        AbstractC2796i.m5785f(buffer, "source");
        buffer.skip(j10);
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }
}

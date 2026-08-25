package okio;

import java.io.IOException;
import java.io.OutputStream;
import p103j9.AbstractC2796i;

final class OutputStreamSink implements Sink {
    private final OutputStream out;
    private final Timeout timeout;

    public OutputStreamSink(OutputStream outputStream, Timeout timeout) {
        AbstractC2796i.m5785f(outputStream, "out");
        AbstractC2796i.m5785f(timeout, "timeout");
        this.out = outputStream;
        this.timeout = timeout;
    }

    @Override
    public void close() throws IOException {
        this.out.close();
    }

    @Override
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override
    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }

    @Override
    public void write(Buffer buffer, long j10) throws IOException {
        AbstractC2796i.m5785f(buffer, "source");
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, j10);
        while (j10 > 0) {
            this.timeout.throwIfReached();
            Segment segment = buffer.head;
            AbstractC2796i.m5782c(segment);
            int iMin = (int) Math.min(j10, segment.limit - segment.pos);
            this.out.write(segment.data, segment.pos, iMin);
            segment.pos += iMin;
            long j11 = iMin;
            j10 -= j11;
            buffer.setSize$okio(buffer.size() - j11);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }
}

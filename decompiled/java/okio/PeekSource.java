package okio;

import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;

public final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource bufferedSource) {
        AbstractC2796i.m5785f(bufferedSource, "upstream");
        this.upstream = bufferedSource;
        Buffer buffer = bufferedSource.getBuffer();
        this.buffer = buffer;
        Segment segment = buffer.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    @Override
    public void close() {
        this.closed = true;
    }

    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long read(Buffer buffer, long j10) {
        Segment segment;
        AbstractC2796i.m5785f(buffer, "sink");
        if (j10 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m21o(j10, "byteCount < 0: ").toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Segment segment2 = this.expectedSegment;
        if (segment2 != null) {
            Segment segment3 = this.buffer.head;
            if (segment2 == segment3) {
                int i6 = this.expectedPos;
                AbstractC2796i.m5782c(segment3);
            }
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        if (j10 == 0) {
            return 0L;
        }
        if (!this.upstream.request(this.pos + 1)) {
            return -1L;
        }
        if (this.expectedSegment == null && (segment = this.buffer.head) != null) {
            this.expectedSegment = segment;
            AbstractC2796i.m5782c(segment);
            this.expectedPos = segment.pos;
        }
        long jMin = Math.min(j10, this.buffer.size() - this.pos);
        this.buffer.copyTo(buffer, this.pos, jMin);
        this.pos += jMin;
        return jMin;
    }

    @Override
    public Timeout timeout() {
        return this.upstream.timeout();
    }
}

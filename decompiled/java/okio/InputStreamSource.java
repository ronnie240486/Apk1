package okio;

import java.io.IOException;
import java.io.InputStream;
import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;

class InputStreamSource implements Source {
    private final InputStream input;
    private final Timeout timeout;

    public InputStreamSource(InputStream inputStream, Timeout timeout) {
        AbstractC2796i.m5785f(inputStream, "input");
        AbstractC2796i.m5785f(timeout, "timeout");
        this.input = inputStream;
        this.timeout = timeout;
    }

    @Override
    public void close() throws IOException {
        this.input.close();
    }

    @Override
    public long read(Buffer buffer, long j10) throws IOException {
        AbstractC2796i.m5785f(buffer, "sink");
        if (j10 == 0) {
            return 0L;
        }
        if (j10 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m21o(j10, "byteCount < 0: ").toString());
        }
        try {
            this.timeout.throwIfReached();
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            int i6 = this.input.read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j10, 8192 - segmentWritableSegment$okio.limit));
            if (i6 != -1) {
                segmentWritableSegment$okio.limit += i6;
                long j11 = i6;
                buffer.setSize$okio(buffer.size() + j11);
                return j11;
            }
            if (segmentWritableSegment$okio.pos != segmentWritableSegment$okio.limit) {
                return -1L;
            }
            buffer.head = segmentWritableSegment$okio.pop();
            SegmentPool.recycle(segmentWritableSegment$okio);
            return -1L;
        } catch (AssertionError e5) {
            if (Okio.isAndroidGetsocknameError(e5)) {
                throw new IOException(e5);
            }
            throw e5;
        }
    }

    @Override
    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "source(" + this.input + ')';
    }
}

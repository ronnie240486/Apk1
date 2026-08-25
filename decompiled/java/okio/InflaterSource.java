package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;

public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        AbstractC2796i.m5785f(bufferedSource, "source");
        AbstractC2796i.m5785f(inflater, "inflater");
        this.source = bufferedSource;
        this.inflater = inflater;
    }

    private final void releaseBytesAfterInflate() throws IOException {
        int i6 = this.bufferBytesHeldByInflater;
        if (i6 == 0) {
            return;
        }
        int remaining = i6 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override
    public long read(Buffer buffer, long j10) throws IOException {
        AbstractC2796i.m5785f(buffer, "sink");
        do {
            long orInflate = readOrInflate(buffer, j10);
            if (orInflate > 0) {
                return orInflate;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.source.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(Buffer buffer, long j10) throws IOException {
        AbstractC2796i.m5785f(buffer, "sink");
        if (j10 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m21o(j10, "byteCount < 0: ").toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j10 == 0) {
            return 0L;
        }
        try {
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            int iMin = (int) Math.min(j10, 8192 - segmentWritableSegment$okio.limit);
            refill();
            int iInflate = this.inflater.inflate(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
            releaseBytesAfterInflate();
            if (iInflate > 0) {
                segmentWritableSegment$okio.limit += iInflate;
                long j11 = iInflate;
                buffer.setSize$okio(buffer.size() + j11);
                return j11;
            }
            if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                buffer.head = segmentWritableSegment$okio.pop();
                SegmentPool.recycle(segmentWritableSegment$okio);
            }
            return 0L;
        } catch (DataFormatException e5) {
            throw new IOException(e5);
        }
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment segment = this.source.getBuffer().head;
        AbstractC2796i.m5782c(segment);
        int i6 = segment.limit;
        int i10 = segment.pos;
        int i11 = i6 - i10;
        this.bufferBytesHeldByInflater = i11;
        this.inflater.setInput(segment.data, i10, i11);
        return false;
    }

    @Override
    public Timeout timeout() {
        return this.source.timeout();
    }

    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.buffer(source), inflater);
        AbstractC2796i.m5785f(source, "source");
        AbstractC2796i.m5785f(inflater, "inflater");
    }
}

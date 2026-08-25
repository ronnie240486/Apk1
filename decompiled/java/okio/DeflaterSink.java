package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import p103j9.AbstractC2796i;

public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        AbstractC2796i.m5785f(bufferedSink, "sink");
        AbstractC2796i.m5785f(deflater, "deflater");
        this.sink = bufferedSink;
        this.deflater = deflater;
    }

    private final void deflate(boolean z7) throws IOException {
        Segment segmentWritableSegment$okio;
        int iDeflate;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            if (z7) {
                try {
                    Deflater deflater = this.deflater;
                    byte[] bArr = segmentWritableSegment$okio.data;
                    int i6 = segmentWritableSegment$okio.limit;
                    iDeflate = deflater.deflate(bArr, i6, 8192 - i6, 2);
                } catch (NullPointerException e5) {
                    throw new IOException("Deflater already closed", e5);
                }
            } else {
                Deflater deflater2 = this.deflater;
                byte[] bArr2 = segmentWritableSegment$okio.data;
                int i10 = segmentWritableSegment$okio.limit;
                iDeflate = deflater2.deflate(bArr2, i10, 8192 - i10);
            }
            if (iDeflate > 0) {
                segmentWritableSegment$okio.limit += iDeflate;
                buffer.setSize$okio(buffer.size() + ((long) iDeflate));
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
            buffer.head = segmentWritableSegment$okio.pop();
            SegmentPool.recycle(segmentWritableSegment$okio);
        }
    }

    @Override
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        finishDeflate$okio();
        th = null;
        try {
            this.deflater.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public final void finishDeflate$okio() throws IOException {
        this.deflater.finish();
        deflate(false);
    }

    @Override
    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    @Override
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    @Override
    public void write(Buffer buffer, long j10) throws IOException {
        AbstractC2796i.m5785f(buffer, "source");
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, j10);
        while (j10 > 0) {
            Segment segment = buffer.head;
            AbstractC2796i.m5782c(segment);
            int iMin = (int) Math.min(j10, segment.limit - segment.pos);
            this.deflater.setInput(segment.data, segment.pos, iMin);
            deflate(false);
            long j11 = iMin;
            buffer.setSize$okio(buffer.size() - j11);
            int i6 = segment.pos + iMin;
            segment.pos = i6;
            if (i6 == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j10 -= j11;
        }
    }

    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.buffer(sink), deflater);
        AbstractC2796i.m5785f(sink, "sink");
        AbstractC2796i.m5785f(deflater, "deflater");
    }
}

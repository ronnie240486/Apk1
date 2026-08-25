package okio;

import java.io.IOException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;

public final class CipherSource implements Source {
    private final int blockSize;
    private final Buffer buffer;
    private final Cipher cipher;
    private boolean closed;

    private boolean f14844final;
    private final BufferedSource source;

    public CipherSource(BufferedSource bufferedSource, Cipher cipher) {
        AbstractC2796i.m5785f(bufferedSource, "source");
        AbstractC2796i.m5785f(cipher, "cipher");
        this.source = bufferedSource;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.blockSize = blockSize;
        this.buffer = new Buffer();
        if (blockSize > 0) {
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
    }

    private final void doFinal() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize == 0) {
            return;
        }
        Segment segmentWritableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int iDoFinal = this.cipher.doFinal(segmentWritableSegment$okio.data, segmentWritableSegment$okio.pos);
        segmentWritableSegment$okio.limit += iDoFinal;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + ((long) iDoFinal));
        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
            this.buffer.head = segmentWritableSegment$okio.pop();
            SegmentPool.recycle(segmentWritableSegment$okio);
        }
    }

    private final void refill() throws BadPaddingException, IllegalBlockSizeException, IOException, ShortBufferException {
        while (this.buffer.size() == 0 && !this.f14844final) {
            if (this.source.exhausted()) {
                this.f14844final = true;
                doFinal();
                return;
            }
            update();
        }
    }

    private final void update() throws BadPaddingException, IllegalBlockSizeException, IOException, ShortBufferException {
        Segment segment = this.source.getBuffer().head;
        AbstractC2796i.m5782c(segment);
        int i6 = segment.limit - segment.pos;
        int outputSize = this.cipher.getOutputSize(i6);
        while (outputSize > 8192) {
            int i10 = this.blockSize;
            if (i6 <= i10) {
                this.f14844final = true;
                Buffer buffer = this.buffer;
                byte[] bArrDoFinal = this.cipher.doFinal(this.source.readByteArray());
                AbstractC2796i.m5784e(bArrDoFinal, "doFinal(...)");
                buffer.write(bArrDoFinal);
                return;
            }
            i6 -= i10;
            outputSize = this.cipher.getOutputSize(i6);
        }
        Segment segmentWritableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int iUpdate = this.cipher.update(segment.data, segment.pos, i6, segmentWritableSegment$okio.data, segmentWritableSegment$okio.pos);
        this.source.skip(i6);
        segmentWritableSegment$okio.limit += iUpdate;
        Buffer buffer2 = this.buffer;
        buffer2.setSize$okio(buffer2.size() + ((long) iUpdate));
        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
            this.buffer.head = segmentWritableSegment$okio.pop();
            SegmentPool.recycle(segmentWritableSegment$okio);
        }
    }

    @Override
    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override
    public long read(Buffer buffer, long j10) throws BadPaddingException, IllegalBlockSizeException, IOException, ShortBufferException {
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
        refill();
        return this.buffer.read(buffer, j10);
    }

    @Override
    public Timeout timeout() {
        return this.source.timeout();
    }
}

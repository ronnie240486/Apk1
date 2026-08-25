package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;

public final class GzipSource implements Source {
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(Source source) {
        AbstractC2796i.m5785f(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.source = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new InflaterSource((BufferedSource) realBufferedSource, inflater);
        this.crc = new CRC32();
    }

    private final void checkEqual(String str, int i6, int i10) throws IOException {
        if (i10 != i6) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i10), Integer.valueOf(i6)}, 3)));
        }
    }

    private final void consumeHeader() throws IOException {
        this.source.require(10L);
        byte b8 = this.source.bufferField.getByte(3L);
        boolean z7 = ((b8 >> 1) & 1) == 1;
        if (z7) {
            updateCrc(this.source.bufferField, 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((b8 >> 2) & 1) == 1) {
            this.source.require(2L);
            if (z7) {
                updateCrc(this.source.bufferField, 0L, 2L);
            }
            long shortLe = this.source.bufferField.readShortLe() & 65535;
            this.source.require(shortLe);
            if (z7) {
                updateCrc(this.source.bufferField, 0L, shortLe);
            }
            this.source.skip(shortLe);
        }
        if (((b8 >> 3) & 1) == 1) {
            long jIndexOf = this.source.indexOf((byte) 0);
            if (jIndexOf == -1) {
                throw new EOFException();
            }
            if (z7) {
                updateCrc(this.source.bufferField, 0L, jIndexOf + 1);
            }
            this.source.skip(jIndexOf + 1);
        }
        if (((b8 >> 4) & 1) == 1) {
            long jIndexOf2 = this.source.indexOf((byte) 0);
            if (jIndexOf2 == -1) {
                throw new EOFException();
            }
            if (z7) {
                updateCrc(this.source.bufferField, 0L, jIndexOf2 + 1);
            }
            this.source.skip(jIndexOf2 + 1);
        }
        if (z7) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private final void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private final void updateCrc(Buffer buffer, long j10, long j11) {
        Segment segment = buffer.head;
        AbstractC2796i.m5782c(segment);
        while (true) {
            int i6 = segment.limit;
            int i10 = segment.pos;
            if (j10 < i6 - i10) {
                break;
            }
            j10 -= (long) (i6 - i10);
            segment = segment.next;
            AbstractC2796i.m5782c(segment);
        }
        while (j11 > 0) {
            int i11 = (int) (((long) segment.pos) + j10);
            int iMin = (int) Math.min(segment.limit - i11, j11);
            this.crc.update(segment.data, i11, iMin);
            j11 -= (long) iMin;
            segment = segment.next;
            AbstractC2796i.m5782c(segment);
            j10 = 0;
        }
    }

    @Override
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    @Override
    public long read(Buffer buffer, long j10) throws IOException {
        AbstractC2796i.m5785f(buffer, "sink");
        if (j10 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m21o(j10, "byteCount < 0: ").toString());
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.section == 0) {
            consumeHeader();
            this.section = (byte) 1;
        }
        if (this.section == 1) {
            long size = buffer.size();
            long j11 = this.inflaterSource.read(buffer, j10);
            if (j11 != -1) {
                updateCrc(buffer, size, j11);
                return j11;
            }
            this.section = (byte) 2;
        }
        if (this.section == 2) {
            consumeTrailer();
            this.section = (byte) 3;
            if (!this.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override
    public Timeout timeout() {
        return this.source.timeout();
    }
}

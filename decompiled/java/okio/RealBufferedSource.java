package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import p000a.AbstractC0004e;
import p103j9.AbstractC2796i;
import p156o9.AbstractC3280d;

public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField;
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source source) {
        AbstractC2796i.m5785f(source, "source");
        this.source = source;
        this.bufferField = new Buffer();
    }

    @Override
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    @Override
    public boolean exhausted() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.bufferField.exhausted() && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override
    public long indexOf(byte b8) {
        return indexOf(b8, 0L, Long.MAX_VALUE);
    }

    @Override
    public long indexOfElement(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "targetBytes");
        return indexOfElement(byteString, 0L);
    }

    @Override
    public InputStream inputStream() {
        return new InputStream() {
            @Override
            public int available() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(realBufferedSource.bufferField.size(), Integer.MAX_VALUE);
            }

            @Override
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            @Override
            public int read() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                if (realBufferedSource.bufferField.size() == 0) {
                    RealBufferedSource realBufferedSource2 = RealBufferedSource.this;
                    if (realBufferedSource2.source.read(realBufferedSource2.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        return -1;
                    }
                }
                return RealBufferedSource.this.bufferField.readByte() & 255;
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override
            public int read(byte[] bArr, int i6, int i10) throws IOException {
                AbstractC2796i.m5785f(bArr, "data");
                if (!RealBufferedSource.this.closed) {
                    SegmentedByteString.checkOffsetAndCount(bArr.length, i6, i10);
                    if (RealBufferedSource.this.bufferField.size() == 0) {
                        RealBufferedSource realBufferedSource = RealBufferedSource.this;
                        if (realBufferedSource.source.read(realBufferedSource.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                            return -1;
                        }
                    }
                    return RealBufferedSource.this.bufferField.read(bArr, i6, i10);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override
    public boolean isOpen() {
        return !this.closed;
    }

    @Override
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override
    public boolean rangeEquals(long j10, ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "bytes");
        return rangeEquals(j10, byteString, 0, byteString.size());
    }

    @Override
    public int read(byte[] bArr) {
        AbstractC2796i.m5785f(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    @Override
    public long readAll(Sink sink) throws IOException {
        AbstractC2796i.m5785f(sink, "sink");
        long j10 = 0;
        while (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            long jCompleteSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j10 += jCompleteSegmentByteCount;
                sink.write(this.bufferField, jCompleteSegmentByteCount);
            }
        }
        if (this.bufferField.size() <= 0) {
            return j10;
        }
        long size = j10 + this.bufferField.size();
        Buffer buffer = this.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    @Override
    public byte readByte() throws EOFException {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override
    public byte[] readByteArray() throws IOException {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override
    public ByteString readByteString() throws IOException {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    @Override
    public long readDecimalLong() throws EOFException {
        require(1L);
        long j10 = 0;
        while (true) {
            long j11 = j10 + 1;
            if (!request(j11)) {
                break;
            }
            byte b8 = this.bufferField.getByte(j10);
            if ((b8 < 48 || b8 > 57) && !(j10 == 0 && b8 == 45)) {
                if (j10 != 0) {
                    break;
                }
                AbstractC3280d.m6586d(16);
                String string = Integer.toString(b8, 16);
                AbstractC2796i.m5784e(string, "toString(...)");
                throw new NumberFormatException("Expected a digit or '-' but was 0x".concat(string));
            }
            j10 = j11;
        }
        return this.bufferField.readDecimalLong();
    }

    @Override
    public void readFully(byte[] bArr) throws EOFException {
        AbstractC2796i.m5785f(bArr, "sink");
        try {
            require(bArr.length);
            this.bufferField.readFully(bArr);
        } catch (EOFException e5) {
            int i6 = 0;
            while (this.bufferField.size() > 0) {
                Buffer buffer = this.bufferField;
                int i10 = buffer.read(bArr, i6, (int) buffer.size());
                if (i10 == -1) {
                    throw new AssertionError();
                }
                i6 += i10;
            }
            throw e5;
        }
    }

    @Override
    public long readHexadecimalUnsignedLong() throws EOFException {
        require(1L);
        int i6 = 0;
        while (true) {
            int i10 = i6 + 1;
            if (!request(i10)) {
                break;
            }
            byte b8 = this.bufferField.getByte(i6);
            if ((b8 < 48 || b8 > 57) && ((b8 < 97 || b8 > 102) && (b8 < 65 || b8 > 70))) {
                if (i6 != 0) {
                    break;
                }
                AbstractC3280d.m6586d(16);
                String string = Integer.toString(b8, 16);
                AbstractC2796i.m5784e(string, "toString(...)");
                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
            }
            i6 = i10;
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override
    public int readInt() throws EOFException {
        require(4L);
        return this.bufferField.readInt();
    }

    @Override
    public int readIntLe() throws EOFException {
        require(4L);
        return this.bufferField.readIntLe();
    }

    @Override
    public long readLong() throws EOFException {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override
    public long readLongLe() throws EOFException {
        require(8L);
        return this.bufferField.readLongLe();
    }

    @Override
    public short readShort() throws EOFException {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override
    public short readShortLe() throws EOFException {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @Override
    public String readString(long j10, Charset charset) throws EOFException {
        AbstractC2796i.m5785f(charset, "charset");
        require(j10);
        return this.bufferField.readString(j10, charset);
    }

    @Override
    public String readUtf8() throws IOException {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override
    public int readUtf8CodePoint() throws EOFException {
        require(1L);
        byte b8 = this.bufferField.getByte(0L);
        if ((b8 & 224) == 192) {
            require(2L);
        } else if ((b8 & 240) == 224) {
            require(3L);
        } else if ((b8 & 248) == 240) {
            require(4L);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    @Override
    public String readUtf8Line() {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this.bufferField, jIndexOf);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    @Override
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override
    public boolean request(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m21o(j10, "byteCount < 0: ").toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (this.bufferField.size() < j10) {
            if (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void require(long j10) throws EOFException {
        if (!request(j10)) {
            throw new EOFException();
        }
    }

    @Override
    public int select(Options options) throws EOFException {
        AbstractC2796i.m5785f(options, "options");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int iSelectPrefix = okio.internal.Buffer.selectPrefix(this.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    break;
                }
                this.bufferField.skip(options.getByteStrings$okio()[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    @Override
    public void skip(long j10) throws EOFException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j10 > 0) {
            if (this.bufferField.size() == 0 && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, this.bufferField.size());
            this.bufferField.skip(jMin);
            j10 -= jMin;
        }
    }

    @Override
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override
    public long indexOf(byte b8, long j10) {
        return indexOf(b8, j10, Long.MAX_VALUE);
    }

    @Override
    public long indexOfElement(ByteString byteString, long j10) {
        AbstractC2796i.m5785f(byteString, "targetBytes");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jIndexOfElement = this.bufferField.indexOfElement(byteString, j10);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, size);
        }
    }

    @Override
    public long read(Buffer buffer, long j10) {
        AbstractC2796i.m5785f(buffer, "sink");
        if (j10 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m21o(j10, "byteCount < 0: ").toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.bufferField.read(buffer, Math.min(j10, this.bufferField.size()));
    }

    @Override
    public String readUtf8LineStrict(long j10) throws EOFException {
        if (j10 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m21o(j10, "limit < 0: ").toString());
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        long jIndexOf = indexOf((byte) 10, 0L, j11);
        if (jIndexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this.bufferField, jIndexOf);
        }
        if (j11 < Long.MAX_VALUE && request(j11) && this.bufferField.getByte(j11 - 1) == 13 && request(1 + j11) && this.bufferField.getByte(j11) == 10) {
            return okio.internal.Buffer.readUtf8Line(this.bufferField, j11);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), j10) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override
    public long indexOf(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "bytes");
        return indexOf(byteString, 0L);
    }

    @Override
    public boolean rangeEquals(long j10, ByteString byteString, int i6, int i10) {
        AbstractC2796i.m5785f(byteString, "bytes");
        if (!this.closed) {
            if (j10 < 0 || i6 < 0 || i10 < 0 || byteString.size() - i6 < i10) {
                return false;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                long j11 = ((long) i11) + j10;
                if (!request(1 + j11) || this.bufferField.getByte(j11) != byteString.getByte(i6 + i11)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public long indexOf(byte b8, long j10, long j11) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (0 > j10 || j10 > j11) {
            throw new IllegalArgumentException(("fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        while (j10 < j11) {
            long jIndexOf = this.bufferField.indexOf(b8, j10, j11);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = this.bufferField.size();
            if (size >= j11 || this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, size);
        }
        return -1L;
    }

    @Override
    public String readString(Charset charset) throws IOException {
        AbstractC2796i.m5785f(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @Override
    public byte[] readByteArray(long j10) throws EOFException {
        require(j10);
        return this.bufferField.readByteArray(j10);
    }

    @Override
    public ByteString readByteString(long j10) throws EOFException {
        require(j10);
        return this.bufferField.readByteString(j10);
    }

    @Override
    public String readUtf8(long j10) throws EOFException {
        require(j10);
        return this.bufferField.readUtf8(j10);
    }

    @Override
    public void readFully(Buffer buffer, long j10) throws IOException {
        AbstractC2796i.m5785f(buffer, "sink");
        try {
            require(j10);
            this.bufferField.readFully(buffer, j10);
        } catch (EOFException e5) {
            buffer.writeAll(this.bufferField);
            throw e5;
        }
    }

    @Override
    public <T> T select(TypedOptions<T> typedOptions) throws IOException {
        AbstractC2796i.m5785f(typedOptions, "options");
        int iSelect = select(typedOptions.getOptions$okio());
        if (iSelect == -1) {
            return null;
        }
        return typedOptions.get(iSelect);
    }

    @Override
    public long indexOf(ByteString byteString, long j10) throws IOException {
        AbstractC2796i.m5785f(byteString, "bytes");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jIndexOf = this.bufferField.indexOf(byteString, j10);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, (size - ((long) byteString.size())) + 1);
        }
    }

    @Override
    public int read(byte[] bArr, int i6, int i10) {
        AbstractC2796i.m5785f(bArr, "sink");
        long j10 = i10;
        SegmentedByteString.checkOffsetAndCount(bArr.length, i6, j10);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.bufferField.read(bArr, i6, (int) Math.min(j10, this.bufferField.size()));
    }

    public static void getBuffer$annotations() {
    }

    @Override
    public int read(ByteBuffer byteBuffer) {
        AbstractC2796i.m5785f(byteBuffer, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.bufferField.read(byteBuffer);
    }
}

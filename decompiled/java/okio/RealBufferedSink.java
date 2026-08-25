package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import p103j9.AbstractC2796i;

public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField;
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        AbstractC2796i.m5785f(sink, "sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    @Override
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        if (this.bufferField.size() > 0) {
            Sink sink = this.sink;
            Buffer buffer = this.bufferField;
            sink.write(buffer, buffer.size());
        }
        th = null;
        try {
            this.sink.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override
    public BufferedSink emit() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long size = this.bufferField.size();
        if (size > 0) {
            this.sink.write(this.bufferField, size);
        }
        return this;
    }

    @Override
    public BufferedSink emitCompleteSegments() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long jCompleteSegmentByteCount = this.bufferField.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.sink.write(this.bufferField, jCompleteSegmentByteCount);
        }
        return this;
    }

    @Override
    public void flush() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.bufferField.size() > 0) {
            Sink sink = this.sink;
            Buffer buffer = this.bufferField;
            sink.write(buffer, buffer.size());
        }
        this.sink.flush();
    }

    @Override
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override
    public boolean isOpen() {
        return !this.closed;
    }

    @Override
    public OutputStream outputStream() {
        return new OutputStream() {
            @Override
            public void close() throws Throwable {
                RealBufferedSink.this.close();
            }

            @Override
            public void flush() throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    return;
                }
                realBufferedSink.flush();
            }

            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override
            public void write(int i6) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    throw new IOException("closed");
                }
                realBufferedSink.bufferField.writeByte((int) ((byte) i6));
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override
            public void write(byte[] bArr, int i6, int i10) throws IOException {
                AbstractC2796i.m5785f(bArr, "data");
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (!realBufferedSink.closed) {
                    realBufferedSink.bufferField.write(bArr, i6, i10);
                    RealBufferedSink.this.emitCompleteSegments();
                    return;
                }
                throw new IOException("closed");
            }
        };
    }

    @Override
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override
    public int write(ByteBuffer byteBuffer) throws IOException {
        AbstractC2796i.m5785f(byteBuffer, "source");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.bufferField.write(byteBuffer);
        emitCompleteSegments();
        return iWrite;
    }

    @Override
    public long writeAll(Source source) throws IOException {
        AbstractC2796i.m5785f(source, "source");
        long j10 = 0;
        while (true) {
            long j11 = source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
            emitCompleteSegments();
        }
    }

    @Override
    public BufferedSink writeByte(int i6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeByte(i6);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeDecimalLong(long j10) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeDecimalLong(j10);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeHexadecimalUnsignedLong(long j10) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeHexadecimalUnsignedLong(j10);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeInt(int i6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeInt(i6);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeIntLe(int i6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeIntLe(i6);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeLong(long j10) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeLong(j10);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeLongLe(long j10) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeLongLe(j10);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeShort(int i6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeShort(i6);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeShortLe(int i6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeShortLe(i6);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeString(String str, Charset charset) {
        AbstractC2796i.m5785f(str, "string");
        AbstractC2796i.m5785f(charset, "charset");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeString(str, charset);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeUtf8(String str) {
        AbstractC2796i.m5785f(str, "string");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override
    public BufferedSink writeUtf8CodePoint(int i6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeUtf8CodePoint(i6);
        return emitCompleteSegments();
    }

    @Override
    public void write(Buffer buffer, long j10) throws IOException {
        AbstractC2796i.m5785f(buffer, "source");
        if (!this.closed) {
            this.bufferField.write(buffer, j10);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public BufferedSink writeString(String str, int i6, int i10, Charset charset) {
        AbstractC2796i.m5785f(str, "string");
        AbstractC2796i.m5785f(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(str, i6, i10, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public BufferedSink writeUtf8(String str, int i6, int i10) {
        AbstractC2796i.m5785f(str, "string");
        if (!this.closed) {
            this.bufferField.writeUtf8(str, i6, i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public BufferedSink write(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public BufferedSink write(ByteString byteString, int i6, int i10) {
        AbstractC2796i.m5785f(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString, i6, i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public BufferedSink write(byte[] bArr) {
        AbstractC2796i.m5785f(bArr, "source");
        if (!this.closed) {
            this.bufferField.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public static void getBuffer$annotations() {
    }

    @Override
    public BufferedSink write(byte[] bArr, int i6, int i10) {
        AbstractC2796i.m5785f(bArr, "source");
        if (!this.closed) {
            this.bufferField.write(bArr, i6, i10);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public BufferedSink write(Source source, long j10) throws IOException {
        AbstractC2796i.m5785f(source, "source");
        while (j10 > 0) {
            long j11 = source.read(this.bufferField, j10);
            if (j11 != -1) {
                j10 -= j11;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}

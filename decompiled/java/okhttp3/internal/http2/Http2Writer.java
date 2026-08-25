package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import p000a.AbstractC0004e;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;

public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        private Companion() {
        }
    }

    public Http2Writer(BufferedSink bufferedSink, boolean z7) {
        AbstractC2796i.m5785f(bufferedSink, "sink");
        this.sink = bufferedSink;
        this.client = z7;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, null);
    }

    private final void writeContinuationFrames(int i6, long j10) throws IOException {
        while (j10 > 0) {
            long jMin = Math.min(this.maxFrameSize, j10);
            j10 -= jMin;
            frameHeader(i6, (int) jMin, 9, j10 == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, jMin);
        }
    }

    public final synchronized void applyAndAckSettings(Settings settings) throws IOException {
        try {
            AbstractC2796i.m5785f(settings, "peerSettings");
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                this.sink.write(Http2.CONNECTION_PREFACE);
                this.sink.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void data(boolean z7, int i6, Buffer buffer, int i10) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        dataFrame(i6, z7 ? 1 : 0, buffer, i10);
    }

    public final void dataFrame(int i6, int i10, Buffer buffer, int i11) throws IOException {
        frameHeader(i6, i11, 0, i10);
        if (i11 > 0) {
            BufferedSink bufferedSink = this.sink;
            AbstractC2796i.m5782c(buffer);
            bufferedSink.write(buffer, i11);
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final void frameHeader(int i6, int i10, int i11, int i12) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, i6, i10, i11, i12));
        }
        if (i10 > this.maxFrameSize) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i10).toString());
        }
        if ((Integer.MIN_VALUE & i6) != 0) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "reserved bit set: ").toString());
        }
        Util.writeMedium(this.sink, i10);
        this.sink.writeByte(i11 & 255);
        this.sink.writeByte(i12 & 255);
        this.sink.writeInt(i6 & Integer.MAX_VALUE);
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i6, ErrorCode errorCode, byte[] bArr) throws IOException {
        try {
            AbstractC2796i.m5785f(errorCode, "errorCode");
            AbstractC2796i.m5785f(bArr, "debugData");
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            frameHeader(0, bArr.length + 8, 7, 0);
            this.sink.writeInt(i6);
            this.sink.writeInt(errorCode.getHttpCode());
            if (!(bArr.length == 0)) {
                this.sink.write(bArr);
            }
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void headers(boolean z7, int i6, List<Header> list) throws IOException {
        AbstractC2796i.m5785f(list, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long size = this.hpackBuffer.size();
        long jMin = Math.min(this.maxFrameSize, size);
        int i10 = size == jMin ? 4 : 0;
        if (z7) {
            i10 |= 1;
        }
        frameHeader(i6, (int) jMin, 1, i10);
        this.sink.write(this.hpackBuffer, jMin);
        if (size > jMin) {
            writeContinuationFrames(i6, size - jMin);
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z7, int i6, int i10) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, 6, z7 ? 1 : 0);
        this.sink.writeInt(i6);
        this.sink.writeInt(i10);
        this.sink.flush();
    }

    public final synchronized void pushPromise(int i6, int i10, List<Header> list) throws IOException {
        AbstractC2796i.m5785f(list, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long size = this.hpackBuffer.size();
        int iMin = (int) Math.min(((long) this.maxFrameSize) - 4, size);
        long j10 = iMin;
        frameHeader(i6, iMin + 4, 5, size == j10 ? 4 : 0);
        this.sink.writeInt(i10 & Integer.MAX_VALUE);
        this.sink.write(this.hpackBuffer, j10);
        if (size > j10) {
            writeContinuationFrames(i6, size - j10);
        }
    }

    public final synchronized void rstStream(int i6, ErrorCode errorCode) throws IOException {
        AbstractC2796i.m5785f(errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.getHttpCode() == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        frameHeader(i6, 4, 3, 0);
        this.sink.writeInt(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final synchronized void settings(Settings settings) throws IOException {
        int i6;
        try {
            AbstractC2796i.m5785f(settings, "settings");
            if (this.closed) {
                throw new IOException("closed");
            }
            int i10 = 0;
            frameHeader(0, settings.size() * 6, 4, 0);
            while (i10 < 10) {
                if (settings.isSet(i10)) {
                    if (i10 != 4) {
                        i6 = i10 != 7 ? i10 : 4;
                    } else {
                        i6 = 3;
                    }
                    this.sink.writeShort(i6);
                    this.sink.writeInt(settings.get(i10));
                }
                i10++;
            }
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void windowUpdate(int i6, long j10) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j10 == 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j10).toString());
        }
        frameHeader(i6, 4, 8, 0);
        this.sink.writeInt((int) j10);
        this.sink.flush();
    }
}

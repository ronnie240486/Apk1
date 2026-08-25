package p036d2;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class C2140i extends InputStream {

    public final int f7770a = 0;

    public int f7771b = 1073741824;

    public final Object f7772c;

    public C2140i(InputStream inputStream) {
        this.f7772c = inputStream;
    }

    private final synchronized void m5082a(int i6) {
        this.f7771b = ((ByteBuffer) this.f7772c).position();
    }

    private final synchronized void m5083b() {
        int i6 = this.f7771b;
        if (i6 == -1) {
            throw new IOException("Cannot reset to unset mark position");
        }
        ((ByteBuffer) this.f7772c).position(i6);
    }

    @Override
    public final int available() {
        switch (this.f7770a) {
            case 0:
                return this.f7771b;
            default:
                return ((ByteBuffer) this.f7772c).remaining();
        }
    }

    @Override
    public void close() throws IOException {
        switch (this.f7770a) {
            case 0:
                ((InputStream) this.f7772c).close();
                break;
            default:
                super.close();
                break;
        }
    }

    @Override
    public synchronized void mark(int i6) {
        switch (this.f7770a) {
            case 1:
                m5082a(i6);
                break;
            default:
                super.mark(i6);
                break;
        }
    }

    @Override
    public boolean markSupported() {
        switch (this.f7770a) {
            case 1:
                return true;
            default:
                return super.markSupported();
        }
    }

    @Override
    public int read(byte[] bArr) throws IOException {
        switch (this.f7770a) {
            case 0:
                int i6 = ((InputStream) this.f7772c).read(bArr);
                if (i6 == -1) {
                    this.f7771b = 0;
                }
                return i6;
            default:
                return super.read(bArr);
        }
    }

    @Override
    public synchronized void reset() throws IOException {
        switch (this.f7770a) {
            case 1:
                m5083b();
                break;
            default:
                super.reset();
                break;
        }
    }

    @Override
    public final long skip(long j10) {
        switch (this.f7770a) {
            case 0:
                return ((InputStream) this.f7772c).skip(j10);
            default:
                ByteBuffer byteBuffer = (ByteBuffer) this.f7772c;
                if (!byteBuffer.hasRemaining()) {
                    return -1L;
                }
                long jMin = Math.min(j10, byteBuffer.remaining());
                byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
                return jMin;
        }
    }

    public C2140i(ByteBuffer byteBuffer) {
        this.f7772c = byteBuffer;
    }

    @Override
    public final int read() throws IOException {
        switch (this.f7770a) {
            case 0:
                int i6 = ((InputStream) this.f7772c).read();
                if (i6 == -1) {
                    this.f7771b = 0;
                }
                return i6;
            default:
                ByteBuffer byteBuffer = (ByteBuffer) this.f7772c;
                if (byteBuffer.hasRemaining()) {
                    return byteBuffer.get() & 255;
                }
                return -1;
        }
    }

    @Override
    public final int read(byte[] bArr, int i6, int i10) throws IOException {
        switch (this.f7770a) {
            case 0:
                int i11 = ((InputStream) this.f7772c).read(bArr, i6, i10);
                if (i11 == -1) {
                    this.f7771b = 0;
                }
                return i11;
            default:
                ByteBuffer byteBuffer = (ByteBuffer) this.f7772c;
                if (!byteBuffer.hasRemaining()) {
                    return -1;
                }
                int iMin = Math.min(i10, byteBuffer.remaining());
                byteBuffer.get(bArr, i6, iMin);
                return iMin;
        }
    }
}

package p186r3;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class C3599c extends FilterInputStream {

    public final long f12092a;

    public int f12093b;

    public C3599c(InputStream inputStream, long j10) {
        super(inputStream);
        this.f12092a = j10;
    }

    public final void m7221a(int i6) throws IOException {
        if (i6 >= 0) {
            this.f12093b += i6;
            return;
        }
        long j10 = this.f12093b;
        long j11 = this.f12092a;
        if (j11 - j10 <= 0) {
            return;
        }
        throw new IOException("Failed to read all expected data, expected: " + j11 + ", but read: " + this.f12093b);
    }

    @Override
    public final synchronized int available() {
        return (int) Math.max(this.f12092a - ((long) this.f12093b), ((FilterInputStream) this).in.available());
    }

    @Override
    public final synchronized int read() {
        int i6;
        i6 = super.read();
        m7221a(i6 >= 0 ? 1 : -1);
        return i6;
    }

    @Override
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override
    public final synchronized int read(byte[] bArr, int i6, int i10) {
        int i11;
        i11 = super.read(bArr, i6, i10);
        m7221a(i11);
        return i11;
    }
}

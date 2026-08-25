package p186r3;

import java.io.FilterInputStream;
import java.io.IOException;

public final class C3607k extends FilterInputStream {

    public int f12107a;

    public C3607k(C3600d c3600d) {
        super(c3600d);
        this.f12107a = Integer.MIN_VALUE;
    }

    public final long m7231a(long j10) {
        int i6 = this.f12107a;
        if (i6 == 0) {
            return -1L;
        }
        return (i6 == Integer.MIN_VALUE || j10 <= ((long) i6)) ? j10 : i6;
    }

    @Override
    public final int available() {
        int i6 = this.f12107a;
        return i6 == Integer.MIN_VALUE ? super.available() : Math.min(i6, super.available());
    }

    public final void m7232b(long j10) {
        int i6 = this.f12107a;
        if (i6 == Integer.MIN_VALUE || j10 == -1) {
            return;
        }
        this.f12107a = (int) (((long) i6) - j10);
    }

    @Override
    public final synchronized void mark(int i6) {
        super.mark(i6);
        this.f12107a = i6;
    }

    @Override
    public final int read() throws IOException {
        if (m7231a(1L) == -1) {
            return -1;
        }
        int i6 = super.read();
        m7232b(1L);
        return i6;
    }

    @Override
    public final synchronized void reset() {
        super.reset();
        this.f12107a = Integer.MIN_VALUE;
    }

    @Override
    public final long skip(long j10) throws IOException {
        long jM7231a = m7231a(j10);
        if (jM7231a == -1) {
            return 0L;
        }
        long jSkip = super.skip(jM7231a);
        m7232b(jSkip);
        return jSkip;
    }

    @Override
    public final int read(byte[] bArr, int i6, int i10) throws IOException {
        int iM7231a = (int) m7231a(i10);
        if (iM7231a == -1) {
            return -1;
        }
        int i11 = super.read(bArr, i6, iM7231a);
        m7232b(i11);
        return i11;
    }
}

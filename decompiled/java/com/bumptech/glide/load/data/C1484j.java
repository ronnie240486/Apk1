package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import p000a.AbstractC0004e;

public final class C1484j extends FilterInputStream {

    public static final byte[] f4485c = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    public static final int f4486d = 31;

    public final byte f4487a;

    public int f4488b;

    public C1484j(InputStream inputStream, int i6) {
        super(inputStream);
        if (i6 < -1 || i6 > 8) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Cannot add invalid orientation: "));
        }
        this.f4487a = (byte) i6;
    }

    @Override
    public final void mark(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean markSupported() {
        return false;
    }

    @Override
    public final int read() throws IOException {
        int i6;
        int i10;
        int i11 = this.f4488b;
        if (i11 < 2 || i11 > (i10 = f4486d)) {
            i6 = super.read();
        } else {
            i6 = i11 == i10 ? this.f4487a : f4485c[i11 - 2] & 255;
        }
        if (i6 != -1) {
            this.f4488b++;
        }
        return i6;
    }

    @Override
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final long skip(long j10) throws IOException {
        long jSkip = super.skip(j10);
        if (jSkip > 0) {
            this.f4488b = (int) (((long) this.f4488b) + jSkip);
        }
        return jSkip;
    }

    @Override
    public final int read(byte[] bArr, int i6, int i10) throws IOException {
        int i11;
        int i12 = this.f4488b;
        int i13 = f4486d;
        if (i12 > i13) {
            i11 = super.read(bArr, i6, i10);
        } else if (i12 == i13) {
            bArr[i6] = this.f4487a;
            i11 = 1;
        } else if (i12 < 2) {
            i11 = super.read(bArr, i6, 2 - i12);
        } else {
            int iMin = Math.min(i13 - i12, i10);
            System.arraycopy(f4485c, this.f4488b - 2, bArr, i6, iMin);
            i11 = iMin;
        }
        if (i11 > 0) {
            this.f4488b += i11;
        }
        return i11;
    }
}

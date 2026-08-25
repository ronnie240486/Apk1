package p049e3;

import androidx.media3.common.C0565C;
import com.google.android.gms.internal.cast.C1549e7;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import p259y2.C4243f;

public final class C2405w extends FilterInputStream {

    public volatile byte[] f8389a;

    public int f8390b;

    public int f8391c;

    public int f8392d;

    public int f8393e;

    public final C4243f f8394f;

    public C2405w(InputStream inputStream, C4243f c4243f) {
        super(inputStream);
        this.f8392d = -1;
        this.f8394f = c4243f;
        this.f8389a = (byte[]) c4243f.m8287d(C0565C.DEFAULT_BUFFER_SEGMENT_SIZE, byte[].class);
    }

    public static void m5439c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int m5440a(InputStream inputStream, byte[] bArr) throws IOException {
        int i6 = this.f8392d;
        if (i6 != -1) {
            int i10 = this.f8393e - i6;
            int i11 = this.f8391c;
            if (i10 < i11) {
                if (i6 == 0 && i11 > bArr.length && this.f8390b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i11) {
                        i11 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f8394f.m8287d(i11, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f8389a = bArr2;
                    this.f8394f.m8291h(bArr);
                    bArr = bArr2;
                } else if (i6 > 0) {
                    System.arraycopy(bArr, i6, bArr, 0, bArr.length - i6);
                }
                int i12 = this.f8393e - this.f8392d;
                this.f8393e = i12;
                this.f8392d = 0;
                this.f8390b = 0;
                int i13 = inputStream.read(bArr, i12, bArr.length - i12);
                int i14 = this.f8393e;
                if (i13 > 0) {
                    i14 += i13;
                }
                this.f8390b = i14;
                return i13;
            }
        }
        int i15 = inputStream.read(bArr);
        if (i15 > 0) {
            this.f8392d = -1;
            this.f8393e = 0;
            this.f8390b = i15;
        }
        return i15;
    }

    @Override
    public final synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f8389a == null || inputStream == null) {
            m5439c();
            throw null;
        }
        return (this.f8390b - this.f8393e) + inputStream.available();
    }

    public final synchronized void m5441b() {
        if (this.f8389a != null) {
            this.f8394f.m8291h(this.f8389a);
            this.f8389a = null;
        }
    }

    @Override
    public final void close() throws IOException {
        if (this.f8389a != null) {
            this.f8394f.m8291h(this.f8389a);
            this.f8389a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override
    public final synchronized void mark(int i6) {
        this.f8391c = Math.max(this.f8391c, i6);
        this.f8392d = this.f8393e;
    }

    @Override
    public final boolean markSupported() {
        return true;
    }

    @Override
    public final synchronized int read() {
        byte[] bArr = this.f8389a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            m5439c();
            throw null;
        }
        if (this.f8393e >= this.f8390b && m5440a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f8389a && (bArr = this.f8389a) == null) {
            m5439c();
            throw null;
        }
        int i6 = this.f8390b;
        int i10 = this.f8393e;
        if (i6 - i10 <= 0) {
            return -1;
        }
        this.f8393e = i10 + 1;
        return bArr[i10] & 255;
    }

    @Override
    public final synchronized void reset() {
        if (this.f8389a == null) {
            throw new IOException("Stream is closed");
        }
        int i6 = this.f8392d;
        if (-1 == i6) {
            throw new C1549e7("Mark has been invalidated, pos: " + this.f8393e + " markLimit: " + this.f8391c);
        }
        this.f8393e = i6;
    }

    @Override
    public final synchronized long skip(long j10) {
        if (j10 < 1) {
            return 0L;
        }
        byte[] bArr = this.f8389a;
        if (bArr == null) {
            m5439c();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            m5439c();
            throw null;
        }
        int i6 = this.f8390b;
        int i10 = this.f8393e;
        if (i6 - i10 >= j10) {
            this.f8393e = (int) (((long) i10) + j10);
            return j10;
        }
        long j11 = ((long) i6) - ((long) i10);
        this.f8393e = i6;
        if (this.f8392d == -1 || j10 > this.f8391c) {
            long jSkip = inputStream.skip(j10 - j11);
            if (jSkip > 0) {
                this.f8392d = -1;
            }
            return j11 + jSkip;
        }
        if (m5440a(inputStream, bArr) == -1) {
            return j11;
        }
        int i11 = this.f8390b;
        int i12 = this.f8393e;
        if (i11 - i12 >= j10 - j11) {
            this.f8393e = (int) ((((long) i12) + j10) - j11);
            return j10;
        }
        long j12 = (j11 + ((long) i11)) - ((long) i12);
        this.f8393e = i11;
        return j12;
    }

    @Override
    public final synchronized int read(byte[] bArr, int i6, int i10) {
        int i11;
        int i12;
        byte[] bArr2 = this.f8389a;
        if (bArr2 == null) {
            m5439c();
            throw null;
        }
        if (i10 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i13 = this.f8393e;
            int i14 = this.f8390b;
            if (i13 < i14) {
                int i15 = i14 - i13;
                if (i15 >= i10) {
                    i15 = i10;
                }
                System.arraycopy(bArr2, i13, bArr, i6, i15);
                this.f8393e += i15;
                if (i15 == i10 || inputStream.available() == 0) {
                    return i15;
                }
                i6 += i15;
                i11 = i10 - i15;
            } else {
                i11 = i10;
            }
            while (true) {
                if (this.f8392d == -1 && i11 >= bArr2.length) {
                    i12 = inputStream.read(bArr, i6, i11);
                    if (i12 == -1) {
                        return i11 != i10 ? i10 - i11 : -1;
                    }
                } else {
                    if (m5440a(inputStream, bArr2) == -1) {
                        return i11 != i10 ? i10 - i11 : -1;
                    }
                    if (bArr2 != this.f8389a && (bArr2 = this.f8389a) == null) {
                        m5439c();
                        throw null;
                    }
                    int i16 = this.f8390b;
                    int i17 = this.f8393e;
                    i12 = i16 - i17;
                    if (i12 >= i11) {
                        i12 = i11;
                    }
                    System.arraycopy(bArr2, i17, bArr, i6, i12);
                    this.f8393e += i12;
                }
                i11 -= i12;
                if (i11 == 0) {
                    return i10;
                }
                if (inputStream.available() == 0) {
                    return i10 - i11;
                }
                i6 += i12;
            }
        } else {
            m5439c();
            throw null;
        }
    }
}

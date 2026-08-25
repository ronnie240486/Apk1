package p197s2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public final class C3701e implements Closeable {

    public final FileInputStream f12405a;

    public final Charset f12406b;

    public byte[] f12407c;

    public int f12408d;

    public int f12409e;

    public C3701e(FileInputStream fileInputStream, Charset charset) {
        if (charset == null) {
            throw null;
        }
        if (!charset.equals(AbstractC3702f.f12410a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f12405a = fileInputStream;
        this.f12406b = charset;
        this.f12407c = new byte[8192];
    }

    public final String m7464a() {
        int i6;
        synchronized (this.f12405a) {
            try {
                byte[] bArr = this.f12407c;
                if (bArr == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f12408d >= this.f12409e) {
                    int i10 = this.f12405a.read(bArr, 0, bArr.length);
                    if (i10 == -1) {
                        throw new EOFException();
                    }
                    this.f12408d = 0;
                    this.f12409e = i10;
                }
                for (int i11 = this.f12408d; i11 != this.f12409e; i11++) {
                    byte[] bArr2 = this.f12407c;
                    if (bArr2[i11] == 10) {
                        int i12 = this.f12408d;
                        if (i11 != i12) {
                            i6 = i11 - 1;
                            if (bArr2[i6] != 13) {
                                i6 = i11;
                            }
                        } else {
                            i6 = i11;
                        }
                        String str = new String(bArr2, i12, i6 - i12, this.f12406b.name());
                        this.f12408d = i11 + 1;
                        return str;
                    }
                }
                C3700d c3700d = new C3700d(this, (this.f12409e - this.f12408d) + 80);
                while (true) {
                    byte[] bArr3 = this.f12407c;
                    int i13 = this.f12408d;
                    c3700d.write(bArr3, i13, this.f12409e - i13);
                    this.f12409e = -1;
                    byte[] bArr4 = this.f12407c;
                    int i14 = this.f12405a.read(bArr4, 0, bArr4.length);
                    if (i14 == -1) {
                        throw new EOFException();
                    }
                    this.f12408d = 0;
                    this.f12409e = i14;
                    for (int i15 = 0; i15 != this.f12409e; i15++) {
                        byte[] bArr5 = this.f12407c;
                        if (bArr5[i15] == 10) {
                            int i16 = this.f12408d;
                            if (i15 != i16) {
                                c3700d.write(bArr5, i16, i15 - i16);
                            }
                            this.f12408d = i15 + 1;
                            return c3700d.toString();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void close() {
        synchronized (this.f12405a) {
            try {
                if (this.f12407c != null) {
                    this.f12407c = null;
                    this.f12405a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

package p047e1;

import java.io.IOException;
import java.io.InputStream;

public final class C2362f extends C2358b {
    public C2362f(byte[] bArr) {
        super(bArr);
        this.f8225a.mark(Integer.MAX_VALUE);
    }

    public final void m5348b(long j10) throws IOException {
        int i6 = this.f8226b;
        if (i6 > j10) {
            this.f8226b = 0;
            this.f8225a.reset();
        } else {
            j10 -= (long) i6;
        }
        m5340a((int) j10);
    }

    public C2362f(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.f8225a.mark(Integer.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }
}

package p047e1;

import android.media.MediaDataSource;
import java.io.IOException;

public final class C2357a extends MediaDataSource {

    public long f8223a;

    public final C2362f f8224b;

    public C2357a(C2362f c2362f) {
        this.f8224b = c2362f;
    }

    @Override
    public final long getSize() {
        return -1L;
    }

    @Override
    public final int readAt(long j10, byte[] bArr, int i6, int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (j10 < 0) {
            return -1;
        }
        try {
            long j11 = this.f8223a;
            if (j11 != j10) {
                if (j11 >= 0 && j10 >= j11 + ((long) this.f8224b.f8225a.available())) {
                    return -1;
                }
                this.f8224b.m5348b(j10);
                this.f8223a = j10;
            }
            if (i10 > this.f8224b.f8225a.available()) {
                i10 = this.f8224b.f8225a.available();
            }
            int i11 = this.f8224b.read(bArr, i6, i10);
            if (i11 >= 0) {
                this.f8223a += (long) i11;
                return i11;
            }
        } catch (IOException unused) {
        }
        this.f8223a = -1L;
        return -1;
    }

    @Override
    public final void close() {
    }
}

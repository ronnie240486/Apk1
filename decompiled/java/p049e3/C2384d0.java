package p049e3;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

public final class C2384d0 extends MediaDataSource {

    public final ByteBuffer f8339a;

    public C2384d0(ByteBuffer byteBuffer) {
        this.f8339a = byteBuffer;
    }

    @Override
    public final long getSize() {
        return this.f8339a.limit();
    }

    @Override
    public final int readAt(long j10, byte[] bArr, int i6, int i10) {
        if (j10 >= this.f8339a.limit()) {
            return -1;
        }
        this.f8339a.position((int) j10);
        int iMin = Math.min(i10, this.f8339a.remaining());
        this.f8339a.get(bArr, i6, iMin);
        return iMin;
    }

    @Override
    public final void close() {
    }
}

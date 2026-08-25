package p036d2;

import okio.Buffer;
import okio.ForwardingSource;

public final class C2133b extends ForwardingSource {

    public Exception f7748a;

    @Override
    public final long read(Buffer buffer, long j10) throws Exception {
        try {
            return super.read(buffer, j10);
        } catch (Exception e5) {
            this.f7748a = e5;
            throw e5;
        }
    }
}

package p197s2;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public final class C3700d extends ByteArrayOutputStream {

    public final C3701e f12404a;

    public C3700d(C3701e c3701e, int i6) {
        super(i6);
        this.f12404a = c3701e;
    }

    @Override
    public final String toString() {
        int i6 = ((ByteArrayOutputStream) this).count;
        if (i6 > 0 && ((ByteArrayOutputStream) this).buf[i6 - 1] == 13) {
            i6--;
        }
        try {
            return new String(((ByteArrayOutputStream) this).buf, 0, i6, this.f12404a.f12406b.name());
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }
}

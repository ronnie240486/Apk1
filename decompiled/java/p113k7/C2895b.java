package p113k7;

import java.io.OutputStream;

public final class C2895b extends OutputStream {

    public long f9837a;

    @Override
    public final void write(int i6) {
        this.f9837a++;
    }

    @Override
    public final void write(byte[] bArr) {
        this.f9837a += (long) bArr.length;
    }

    @Override
    public final void write(byte[] bArr, int i6, int i10) {
        int i11;
        if (i6 >= 0 && i6 <= bArr.length && i10 >= 0 && (i11 = i6 + i10) <= bArr.length && i11 >= 0) {
            this.f9837a += (long) i10;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}

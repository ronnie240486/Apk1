package p186r3;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import p049e3.C2405w;

public final class C3600d extends InputStream {

    public static final ArrayDeque f12094c;

    public C2405w f12095a;

    public IOException f12096b;

    static {
        char[] cArr = AbstractC3610n.f12112a;
        f12094c = new ArrayDeque(0);
    }

    public final void m7222a() {
        this.f12096b = null;
        this.f12095a = null;
        ArrayDeque arrayDeque = f12094c;
        synchronized (arrayDeque) {
            arrayDeque.offer(this);
        }
    }

    @Override
    public final int available() {
        return this.f12095a.available();
    }

    @Override
    public final void close() throws IOException {
        this.f12095a.close();
    }

    @Override
    public final void mark(int i6) {
        this.f12095a.mark(i6);
    }

    @Override
    public final boolean markSupported() {
        this.f12095a.getClass();
        return true;
    }

    @Override
    public final int read() throws IOException {
        try {
            return this.f12095a.read();
        } catch (IOException e5) {
            this.f12096b = e5;
            throw e5;
        }
    }

    @Override
    public final synchronized void reset() {
        this.f12095a.reset();
    }

    @Override
    public final long skip(long j10) throws IOException {
        try {
            return this.f12095a.skip(j10);
        } catch (IOException e5) {
            this.f12096b = e5;
            throw e5;
        }
    }

    @Override
    public final int read(byte[] bArr) throws IOException {
        try {
            return this.f12095a.read(bArr);
        } catch (IOException e5) {
            this.f12096b = e5;
            throw e5;
        }
    }

    @Override
    public final int read(byte[] bArr, int i6, int i10) throws IOException {
        try {
            return this.f12095a.read(bArr, i6, i10);
        } catch (IOException e5) {
            this.f12096b = e5;
            throw e5;
        }
    }
}

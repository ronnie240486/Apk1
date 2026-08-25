package p048e2;

import java.io.Closeable;
import p192r9.C3647e;

public final class C2370e implements Closeable {

    public final C2369d f8299a;

    public boolean f8300b;

    public final C2373h f8301c;

    public C2370e(C2373h c2373h, C2369d c2369d) {
        this.f8301c = c2373h;
        this.f8299a = c2369d;
    }

    @Override
    public final void close() {
        if (this.f8300b) {
            return;
        }
        this.f8300b = true;
        C2373h c2373h = this.f8301c;
        synchronized (c2373h) {
            C2369d c2369d = this.f8299a;
            int i6 = c2369d.f8297h - 1;
            c2369d.f8297h = i6;
            if (i6 == 0 && c2369d.f8295f) {
                C3647e c3647e = C2373h.f8303q;
                c2373h.m5395i(c2369d);
            }
        }
    }
}

package p127m;

import java.util.Iterator;

public final class C3022d extends AbstractC3023e implements Iterator {

    public C3021c f10347a;

    public boolean f10348b = true;

    public final C3024f f10349c;

    public C3022d(C3024f c3024f) {
        this.f10349c = c3024f;
    }

    @Override
    public final void mo6097a(C3021c c3021c) {
        C3021c c3021c2 = this.f10347a;
        if (c3021c == c3021c2) {
            C3021c c3021c3 = c3021c2.f10346d;
            this.f10347a = c3021c3;
            this.f10348b = c3021c3 == null;
        }
    }

    @Override
    public final boolean hasNext() {
        if (this.f10348b) {
            return this.f10349c.f10350a != null;
        }
        C3021c c3021c = this.f10347a;
        return (c3021c == null || c3021c.f10345c == null) ? false : true;
    }

    @Override
    public final Object next() {
        if (this.f10348b) {
            this.f10348b = false;
            this.f10347a = this.f10349c.f10350a;
        } else {
            C3021c c3021c = this.f10347a;
            this.f10347a = c3021c != null ? c3021c.f10345c : null;
        }
        return this.f10347a;
    }
}

package p127m;

import java.util.Iterator;

public final class C3020b extends AbstractC3023e implements Iterator {

    public C3021c f10340a;

    public C3021c f10341b;

    public final int f10342c;

    public C3020b(C3021c c3021c, C3021c c3021c2, int i6) {
        this.f10342c = i6;
        this.f10340a = c3021c2;
        this.f10341b = c3021c;
    }

    @Override
    public final void mo6097a(C3021c c3021c) {
        C3021c c3021c2;
        C3021c c3021cM6098b = null;
        if (this.f10340a == c3021c && c3021c == this.f10341b) {
            this.f10341b = null;
            this.f10340a = null;
        }
        C3021c c3021c3 = this.f10340a;
        if (c3021c3 == c3021c) {
            switch (this.f10342c) {
                case 0:
                    c3021c2 = c3021c3.f10346d;
                    break;
                default:
                    c3021c2 = c3021c3.f10345c;
                    break;
            }
            this.f10340a = c3021c2;
        }
        C3021c c3021c4 = this.f10341b;
        if (c3021c4 == c3021c) {
            C3021c c3021c5 = this.f10340a;
            if (c3021c4 != c3021c5 && c3021c5 != null) {
                c3021cM6098b = m6098b(c3021c4);
            }
            this.f10341b = c3021cM6098b;
        }
    }

    public final C3021c m6098b(C3021c c3021c) {
        switch (this.f10342c) {
            case 0:
                return c3021c.f10345c;
            default:
                return c3021c.f10346d;
        }
    }

    @Override
    public final boolean hasNext() {
        return this.f10341b != null;
    }

    @Override
    public final Object next() {
        C3021c c3021c = this.f10341b;
        C3021c c3021c2 = this.f10340a;
        this.f10341b = (c3021c == c3021c2 || c3021c2 == null) ? null : m6098b(c3021c);
        return c3021c;
    }
}

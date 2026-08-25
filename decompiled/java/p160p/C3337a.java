package p160p;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p115k9.InterfaceC2905a;

public final class C3337a implements Iterator, InterfaceC2905a {

    public int f11301a;

    public int f11302b;

    public boolean f11303c;

    public final int f11304d;

    public final Object f11305e;

    public C3337a(int i6) {
        this.f11301a = i6;
    }

    @Override
    public final boolean hasNext() {
        return this.f11302b < this.f11301a;
    }

    @Override
    public final Object next() {
        Object objM6812f;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i6 = this.f11302b;
        switch (this.f11304d) {
            case 0:
                objM6812f = ((C3341e) this.f11305e).m6812f(i6);
                break;
            case 1:
                objM6812f = ((C3341e) this.f11305e).m6816j(i6);
                break;
            default:
                objM6812f = ((C3342f) this.f11305e).f11316b[i6];
                break;
        }
        this.f11302b++;
        this.f11303c = true;
        return objM6812f;
    }

    @Override
    public final void remove() {
        if (!this.f11303c) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i6 = this.f11302b - 1;
        this.f11302b = i6;
        switch (this.f11304d) {
            case 0:
                ((C3341e) this.f11305e).mo6814h(i6);
                break;
            case 1:
                ((C3341e) this.f11305e).mo6814h(i6);
                break;
            default:
                ((C3342f) this.f11305e).m6784c(i6);
                break;
        }
        this.f11301a--;
        this.f11303c = false;
    }

    public C3337a(C3342f c3342f) {
        this(c3342f.f11317c);
        this.f11304d = 2;
        this.f11305e = c3342f;
    }

    public C3337a(C3341e c3341e, int i6) {
        this(c3341e.f11334c);
        this.f11304d = i6;
        switch (i6) {
            case 1:
                this.f11305e = c3341e;
                this(c3341e.f11334c);
                break;
            default:
                this.f11305e = c3341e;
                break;
        }
    }
}

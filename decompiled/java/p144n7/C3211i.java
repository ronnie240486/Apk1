package p144n7;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class C3211i implements Iterator {

    public C3213k f10792a;

    public C3213k f10793b = null;

    public int f10794c;

    public final C3214l f10795d;

    public final int f10796e;

    public C3211i(C3214l c3214l, int i6) {
        this.f10796e = i6;
        this.f10795d = c3214l;
        this.f10792a = c3214l.f10812e.f10802d;
        this.f10794c = c3214l.f10811d;
    }

    public final Object m6499a() {
        return m6500b();
    }

    public final C3213k m6500b() {
        C3213k c3213k = this.f10792a;
        C3214l c3214l = this.f10795d;
        if (c3213k == c3214l.f10812e) {
            throw new NoSuchElementException();
        }
        if (c3214l.f10811d != this.f10794c) {
            throw new ConcurrentModificationException();
        }
        this.f10792a = c3213k.f10802d;
        this.f10793b = c3213k;
        return c3213k;
    }

    @Override
    public final boolean hasNext() {
        return this.f10792a != this.f10795d.f10812e;
    }

    @Override
    public Object next() {
        switch (this.f10796e) {
            case 1:
                return m6500b().f10804f;
            default:
                return m6499a();
        }
    }

    @Override
    public final void remove() {
        C3213k c3213k = this.f10793b;
        if (c3213k == null) {
            throw new IllegalStateException();
        }
        C3214l c3214l = this.f10795d;
        c3214l.m6503c(c3213k, true);
        this.f10793b = null;
        this.f10794c = c3214l.f10811d;
    }
}

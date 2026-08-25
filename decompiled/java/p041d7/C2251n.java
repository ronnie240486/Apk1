package p041d7;

import java.util.List;
import java.util.ListIterator;

public final class C2251n extends C2188e implements ListIterator {

    public final C2258o f8003e;

    public C2251n(C2258o c2258o) {
        super(c2258o);
        this.f8003e = c2258o;
    }

    @Override
    public final void add(Object obj) {
        C2258o c2258o = this.f8003e;
        boolean zIsEmpty = c2258o.isEmpty();
        m5250b().add(obj);
        c2258o.f8010f.f8046g++;
        if (zIsEmpty) {
            c2258o.m5240c();
        }
    }

    public final ListIterator m5250b() {
        m5165a();
        return (ListIterator) this.f7873b;
    }

    @Override
    public final boolean hasPrevious() {
        return m5250b().hasPrevious();
    }

    @Override
    public final int nextIndex() {
        return m5250b().nextIndex();
    }

    @Override
    public final Object previous() {
        return m5250b().previous();
    }

    @Override
    public final int previousIndex() {
        return m5250b().previousIndex();
    }

    @Override
    public final void set(Object obj) {
        m5250b().set(obj);
    }

    public C2251n(C2258o c2258o, int i6) {
        super(c2258o, ((List) c2258o.f7992b).listIterator(i6));
        this.f8003e = c2258o;
    }
}

package p041d7;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import p020b7.AbstractC1332b;

public abstract class AbstractC2160a extends AbstractC2292s5 implements ListIterator {

    public final int f7822a;

    public int f7823b;

    public AbstractC2160a(int i6, int i10) {
        AbstractC1332b.m3220k(i10, i6);
        this.f7822a = i6;
        this.f7823b = i10;
    }

    public abstract Object mo5098a(int i6);

    @Override
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean hasNext() {
        return this.f7823b < this.f7822a;
    }

    @Override
    public final boolean hasPrevious() {
        return this.f7823b > 0;
    }

    @Override
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i6 = this.f7823b;
        this.f7823b = i6 + 1;
        return mo5098a(i6);
    }

    @Override
    public final int nextIndex() {
        return this.f7823b;
    }

    @Override
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i6 = this.f7823b - 1;
        this.f7823b = i6;
        return mo5098a(i6);
    }

    @Override
    public final int previousIndex() {
        return this.f7823b - 1;
    }

    @Override
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}

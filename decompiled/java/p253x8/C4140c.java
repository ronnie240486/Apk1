package p253x8;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import p103j9.C2788a;

public final class C4140c extends C2788a implements ListIterator {

    public final AbstractC4142e f14063d;

    public C4140c(AbstractC4142e abstractC4142e, int i6) {
        super(3, abstractC4142e);
        this.f14063d = abstractC4142e;
        C4139b c4139b = AbstractC4142e.Companion;
        int size = abstractC4142e.size();
        c4139b.getClass();
        C4139b.m8158b(i6, size);
        this.f9521b = i6;
    }

    @Override
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean hasPrevious() {
        return this.f9521b > 0;
    }

    @Override
    public final int nextIndex() {
        return this.f9521b;
    }

    @Override
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i6 = this.f9521b - 1;
        this.f9521b = i6;
        return this.f14063d.get(i6);
    }

    @Override
    public final int previousIndex() {
        return this.f9521b - 1;
    }

    @Override
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

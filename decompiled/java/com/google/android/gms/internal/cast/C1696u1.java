package com.google.android.gms.internal.cast;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class C1696u1 extends AbstractC1584i2 implements ListIterator {

    public final int f5686a;

    public int f5687b;

    public final AbstractC1714w1 f5688c;

    public C1696u1(AbstractC1714w1 abstractC1714w1, int i6) {
        int size = abstractC1714w1.size();
        AbstractC1503a1.m3700l(i6, size);
        this.f5686a = size;
        this.f5687b = i6;
        this.f5688c = abstractC1714w1;
    }

    public final Object m4024a(int i6) {
        return this.f5688c.get(i6);
    }

    @Override
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean hasNext() {
        return this.f5687b < this.f5686a;
    }

    @Override
    public final boolean hasPrevious() {
        return this.f5687b > 0;
    }

    @Override
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i6 = this.f5687b;
        this.f5687b = i6 + 1;
        return m4024a(i6);
    }

    @Override
    public final int nextIndex() {
        return this.f5687b;
    }

    @Override
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i6 = this.f5687b - 1;
        this.f5687b = i6;
        return m4024a(i6);
    }

    @Override
    public final int previousIndex() {
        return this.f5687b - 1;
    }

    @Override
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}

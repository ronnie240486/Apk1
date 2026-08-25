package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class C1509a7 implements Iterator {

    public int f5206a = 0;

    public final int f5207b;

    public final C1529c7 f5208c;

    public C1509a7(C1529c7 c1529c7) {
        this.f5208c = c1529c7;
        this.f5207b = c1529c7.mo3734e();
    }

    @Override
    public final boolean hasNext() {
        return this.f5206a < this.f5207b;
    }

    @Override
    public final Object next() {
        int i6 = this.f5206a;
        if (i6 >= this.f5207b) {
            throw new NoSuchElementException();
        }
        this.f5206a = i6 + 1;
        return Byte.valueOf(this.f5208c.mo3733d(i6));
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

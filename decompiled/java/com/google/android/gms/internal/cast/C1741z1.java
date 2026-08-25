package com.google.android.gms.internal.cast;

import java.util.NoSuchElementException;

public final class C1741z1 extends AbstractC1584i2 {

    public final Object f5743a;

    public boolean f5744b;

    public C1741z1(Object obj) {
        this.f5743a = obj;
    }

    @Override
    public final boolean hasNext() {
        return !this.f5744b;
    }

    @Override
    public final Object next() {
        if (this.f5744b) {
            throw new NoSuchElementException();
        }
        this.f5744b = true;
        return this.f5743a;
    }
}

package com.google.android.gms.internal.cast;

import java.util.Iterator;

public final class C1534d2 extends AbstractC1732y1 {

    public final transient C1554f2 f5244d;

    public final transient C1544e2 f5245e;

    public C1534d2(C1554f2 c1554f2, C1544e2 c1544e2) {
        this.f5244d = c1554f2;
        this.f5245e = c1544e2;
    }

    @Override
    public final int mo3710c(Object[] objArr) {
        return this.f5245e.mo3710c(objArr);
    }

    @Override
    public final boolean contains(Object obj) {
        return this.f5244d.get(obj) != null;
    }

    @Override
    public final Iterator iterator() {
        return this.f5245e.listIterator(0);
    }

    @Override
    public final int size() {
        return this.f5244d.f5300f;
    }
}

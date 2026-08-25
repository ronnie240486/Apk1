package com.google.android.gms.internal.cast;

import java.util.Objects;

public final class C1544e2 extends AbstractC1714w1 {

    public final transient Object[] f5279c;

    public final transient int f5280d;

    public final transient int f5281e;

    public C1544e2(Object[] objArr, int i6, int i10) {
        this.f5279c = objArr;
        this.f5280d = i6;
        this.f5281e = i10;
    }

    @Override
    public final Object get(int i6) {
        AbstractC1503a1.m3698i(i6, this.f5281e);
        Object obj = this.f5279c[i6 + i6 + this.f5280d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override
    public final int size() {
        return this.f5281e;
    }
}

package com.google.android.gms.internal.cast;

import java.util.AbstractMap;
import java.util.Objects;

public final class C1514b2 extends AbstractC1714w1 {

    public final C1524c2 f5218c;

    public C1514b2(C1524c2 c1524c2) {
        this.f5218c = c1524c2;
    }

    @Override
    public final Object get(int i6) {
        C1524c2 c1524c2 = this.f5218c;
        AbstractC1503a1.m3698i(i6, c1524c2.f5231f);
        int i10 = i6 + i6;
        Object[] objArr = c1524c2.f5230e;
        Object obj = objArr[i10];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i10 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override
    public final int size() {
        return this.f5218c.f5231f;
    }
}

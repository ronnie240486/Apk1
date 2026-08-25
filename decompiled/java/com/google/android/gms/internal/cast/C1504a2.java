package com.google.android.gms.internal.cast;

import java.util.Objects;

public final class C1504a2 extends AbstractC1714w1 {

    public static final C1504a2 f5202e = new C1504a2(new Object[0], 0);

    public final transient Object[] f5203c;

    public final transient int f5204d;

    public C1504a2(Object[] objArr, int i6) {
        this.f5203c = objArr;
        this.f5204d = i6;
    }

    @Override
    public final int mo3710c(Object[] objArr) {
        Object[] objArr2 = this.f5203c;
        int i6 = this.f5204d;
        System.arraycopy(objArr2, 0, objArr, 0, i6);
        return i6;
    }

    @Override
    public final int mo3711d() {
        return this.f5204d;
    }

    @Override
    public final int mo3712e() {
        return 0;
    }

    @Override
    public final Object[] mo3713f() {
        return this.f5203c;
    }

    @Override
    public final Object get(int i6) {
        AbstractC1503a1.m3698i(i6, this.f5204d);
        Object obj = this.f5203c[i6];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override
    public final int size() {
        return this.f5204d;
    }
}

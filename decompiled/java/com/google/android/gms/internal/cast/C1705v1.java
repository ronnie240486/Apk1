package com.google.android.gms.internal.cast;

public final class C1705v1 extends AbstractC1714w1 {

    public final transient int f5699c;

    public final transient int f5700d;

    public final AbstractC1714w1 f5701e;

    public C1705v1(AbstractC1714w1 abstractC1714w1, int i6, int i10) {
        this.f5701e = abstractC1714w1;
        this.f5699c = i6;
        this.f5700d = i10;
    }

    @Override
    public final int mo3711d() {
        return this.f5701e.mo3712e() + this.f5699c + this.f5700d;
    }

    @Override
    public final int mo3712e() {
        return this.f5701e.mo3712e() + this.f5699c;
    }

    @Override
    public final Object[] mo3713f() {
        return this.f5701e.mo3713f();
    }

    @Override
    public final AbstractC1714w1 subList(int i6, int i10) {
        AbstractC1503a1.m3701n(i6, i10, this.f5700d);
        int i11 = this.f5699c;
        return this.f5701e.subList(i6 + i11, i10 + i11);
    }

    @Override
    public final Object get(int i6) {
        AbstractC1503a1.m3698i(i6, this.f5700d);
        return this.f5701e.get(i6 + this.f5699c);
    }

    @Override
    public final int size() {
        return this.f5700d;
    }
}

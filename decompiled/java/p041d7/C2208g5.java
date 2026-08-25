package p041d7;

import java.util.Objects;
import p020b7.AbstractC1332b;

public final class C2208g5 extends AbstractC2301u1 {

    public final transient Object[] f7909c;

    public final transient int f7910d;

    public final transient int f7911e;

    public C2208g5(Object[] objArr, int i6, int i10) {
        this.f7909c = objArr;
        this.f7910d = i6;
        this.f7911e = i10;
    }

    @Override
    public final Object get(int i6) {
        AbstractC1332b.m3217h(i6, this.f7911e);
        Object obj = this.f7909c[(i6 * 2) + this.f7910d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override
    public final boolean mo5127h() {
        return true;
    }

    @Override
    public final int size() {
        return this.f7911e;
    }
}

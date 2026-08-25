package p041d7;

import java.util.AbstractMap;
import java.util.Objects;
import p020b7.AbstractC1332b;

public final class C2187d5 extends AbstractC2301u1 {

    public final C2194e5 f7871c;

    public C2187d5(C2194e5 c2194e5) {
        this.f7871c = c2194e5;
    }

    @Override
    public final Object get(int i6) {
        C2194e5 c2194e5 = this.f7871c;
        AbstractC1332b.m3217h(i6, c2194e5.f7886f);
        int i10 = i6 * 2;
        Object[] objArr = c2194e5.f7885e;
        Object obj = objArr[i10];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i10 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override
    public final boolean mo5127h() {
        return true;
    }

    @Override
    public final int size() {
        return this.f7871c.f7886f;
    }
}

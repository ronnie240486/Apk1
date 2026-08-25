package p041d7;

import java.util.Iterator;
import java.util.ListIterator;
import p020b7.AbstractC1332b;

public final class C2295t1 extends AbstractC2301u1 {

    public final transient int f8057c;

    public final transient int f8058d;

    public final AbstractC2301u1 f8059e;

    public C2295t1(AbstractC2301u1 abstractC2301u1, int i6, int i10) {
        this.f8059e = abstractC2301u1;
        this.f8057c = i6;
        this.f8058d = i10;
    }

    @Override
    public final Object[] mo5124e() {
        return this.f8059e.mo5124e();
    }

    @Override
    public final int mo5125f() {
        return this.f8059e.mo5126g() + this.f8057c + this.f8058d;
    }

    @Override
    public final int mo5126g() {
        return this.f8059e.mo5126g() + this.f8057c;
    }

    @Override
    public final Object get(int i6) {
        AbstractC1332b.m3217h(i6, this.f8058d);
        return this.f8059e.get(i6 + this.f8057c);
    }

    @Override
    public final boolean mo5127h() {
        return true;
    }

    @Override
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override
    public final int size() {
        return this.f8058d;
    }

    @Override
    public final AbstractC2301u1 subList(int i6, int i10) {
        AbstractC1332b.m3221l(i6, i10, this.f8058d);
        int i11 = this.f8057c;
        return this.f8059e.subList(i6 + i11, i10 + i11);
    }

    @Override
    public final ListIterator listIterator(int i6) {
        return listIterator(i6);
    }
}

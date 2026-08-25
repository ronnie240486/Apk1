package p041d7;

import java.util.Objects;
import p020b7.AbstractC1332b;

public final class C2180c5 extends AbstractC2301u1 {

    public static final C2180c5 f7862e = new C2180c5(new Object[0], 0);

    public final transient Object[] f7863c;

    public final transient int f7864d;

    public C2180c5(Object[] objArr, int i6) {
        this.f7863c = objArr;
        this.f7864d = i6;
    }

    @Override
    public final int mo5123d(Object[] objArr, int i6) {
        Object[] objArr2 = this.f7863c;
        int i10 = this.f7864d;
        System.arraycopy(objArr2, 0, objArr, i6, i10);
        return i6 + i10;
    }

    @Override
    public final Object[] mo5124e() {
        return this.f7863c;
    }

    @Override
    public final int mo5125f() {
        return this.f7864d;
    }

    @Override
    public final int mo5126g() {
        return 0;
    }

    @Override
    public final Object get(int i6) {
        AbstractC1332b.m3217h(i6, this.f7864d);
        Object obj = this.f7863c[i6];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override
    public final boolean mo5127h() {
        return false;
    }

    @Override
    public final int size() {
        return this.f7864d;
    }
}

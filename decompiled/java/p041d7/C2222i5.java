package p041d7;

public final class C2222i5 extends AbstractC2233k2 {

    public static final Object[] f7946i;

    public static final C2222i5 f7947j;

    public final transient Object[] f7948d;

    public final transient int f7949e;

    public final transient Object[] f7950f;

    public final transient int f7951g;

    public final transient int f7952h;

    static {
        Object[] objArr = new Object[0];
        f7946i = objArr;
        f7947j = new C2222i5(0, 0, 0, objArr, objArr);
    }

    public C2222i5(int i6, int i10, int i11, Object[] objArr, Object[] objArr2) {
        this.f7948d = objArr;
        this.f7949e = i6;
        this.f7950f = objArr2;
        this.f7951g = i10;
        this.f7952h = i11;
    }

    @Override
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f7950f;
            if (objArr.length != 0) {
                int iM5130B = AbstractC2182d0.m5130B(obj);
                while (true) {
                    int i6 = iM5130B & this.f7951g;
                    Object obj2 = objArr[i6];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iM5130B = i6 + 1;
                }
            }
        }
        return false;
    }

    @Override
    public final int mo5123d(Object[] objArr, int i6) {
        Object[] objArr2 = this.f7948d;
        int i10 = this.f7952h;
        System.arraycopy(objArr2, 0, objArr, i6, i10);
        return i6 + i10;
    }

    @Override
    public final Object[] mo5124e() {
        return this.f7948d;
    }

    @Override
    public final int mo5125f() {
        return this.f7952h;
    }

    @Override
    public final int mo5126g() {
        return 0;
    }

    @Override
    public final boolean mo5127h() {
        return false;
    }

    @Override
    public final int hashCode() {
        return this.f7949e;
    }

    @Override
    public final AbstractC2292s5 mo5164i() {
        return mo5167c().listIterator(0);
    }

    @Override
    public final AbstractC2301u1 mo5169m() {
        return AbstractC2301u1.m5268j(this.f7948d, this.f7952h);
    }

    @Override
    public final int size() {
        return this.f7952h;
    }
}

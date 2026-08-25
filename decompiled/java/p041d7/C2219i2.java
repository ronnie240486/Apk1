package p041d7;

public final class C2219i2 extends AbstractC2233k2 {

    public final C2191e2 f7942d;

    public C2219i2(C2191e2 c2191e2) {
        this.f7942d = c2191e2;
    }

    @Override
    public final boolean contains(Object obj) {
        if (!(obj instanceof AbstractC2316w4)) {
            return false;
        }
        AbstractC2316w4 abstractC2316w4 = (AbstractC2316w4) obj;
        if (abstractC2316w4.mo5264a() <= 0) {
            return false;
        }
        return this.f7942d.count(abstractC2316w4.mo5265b()) == abstractC2316w4.mo5264a();
    }

    @Override
    public final int mo5123d(Object[] objArr, int i6) {
        return mo5167c().mo5123d(objArr, i6);
    }

    @Override
    public final boolean mo5127h() {
        this.f7942d.getClass();
        return true;
    }

    @Override
    public final int hashCode() {
        return this.f7942d.hashCode();
    }

    @Override
    public final AbstractC2292s5 iterator() {
        return mo5167c().listIterator(0);
    }

    @Override
    public final AbstractC2301u1 mo5169m() {
        return new C2261o2(this);
    }

    @Override
    public final int size() {
        return this.f7942d.f7880d.f7907f.keySet().size();
    }
}

package p041d7;

public final class C2201f5 extends AbstractC2233k2 {

    public final transient AbstractC2331z1 f7899d;

    public final transient C2208g5 f7900e;

    public C2201f5(AbstractC2331z1 abstractC2331z1, C2208g5 c2208g5) {
        this.f7899d = abstractC2331z1;
        this.f7900e = c2208g5;
    }

    @Override
    public final AbstractC2301u1 mo5167c() {
        return this.f7900e;
    }

    @Override
    public final boolean contains(Object obj) {
        return this.f7899d.get(obj) != null;
    }

    @Override
    public final int mo5123d(Object[] objArr, int i6) {
        return this.f7900e.mo5123d(objArr, i6);
    }

    @Override
    public final boolean mo5127h() {
        return true;
    }

    @Override
    public final AbstractC2292s5 iterator() {
        return this.f7900e.listIterator(0);
    }

    @Override
    public final int size() {
        return ((C2215h5) this.f7899d).f7930f;
    }
}

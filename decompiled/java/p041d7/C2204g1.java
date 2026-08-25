package p041d7;

public final class C2204g1 extends AbstractC2160a {

    public final int f7905c = 0;

    public final Iterable f7906d;

    public C2204g1(C2197f1 c2197f1, int i6) {
        super(i6, 0);
        this.f7906d = c2197f1;
    }

    @Override
    public final Object mo5098a(int i6) {
        switch (this.f7905c) {
            case 0:
                return ((Iterable[]) ((C2197f1) this.f7906d).f7896c)[i6].iterator();
            default:
                return ((AbstractC2301u1) this.f7906d).get(i6);
        }
    }

    public C2204g1(AbstractC2301u1 abstractC2301u1, int i6) {
        super(abstractC2301u1.size(), i6);
        this.f7906d = abstractC2301u1;
    }
}

package p041d7;

public final class C2198f2 extends AbstractC2274q1 {

    public final transient AbstractC2205g2 f7897b;

    public C2198f2(AbstractC2205g2 abstractC2205g2) {
        this.f7897b = abstractC2205g2;
    }

    @Override
    public final boolean contains(Object obj) {
        return this.f7897b.mo5175h(obj);
    }

    @Override
    public final int mo5123d(Object[] objArr, int i6) {
        C2204g1 c2204g1ListIterator = ((AbstractC2301u1) this.f7897b.f7907f.values()).listIterator(0);
        while (c2204g1ListIterator.hasNext()) {
            i6 = ((AbstractC2274q1) c2204g1ListIterator.next()).mo5123d(objArr, i6);
        }
        return i6;
    }

    @Override
    public final AbstractC2292s5 iterator() {
        AbstractC2205g2 abstractC2205g2 = this.f7897b;
        abstractC2205g2.getClass();
        return new C2170b2(abstractC2205g2);
    }

    @Override
    public final int size() {
        return this.f7897b.f7908g;
    }
}

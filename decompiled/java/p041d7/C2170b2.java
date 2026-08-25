package p041d7;

public final class C2170b2 extends AbstractC2292s5 {

    public final AbstractC2292s5 f7833a;

    public AbstractC2292s5 f7834b = C2289s2.f8052d;

    public C2170b2(AbstractC2205g2 abstractC2205g2) {
        this.f7833a = ((AbstractC2301u1) abstractC2205g2.f7907f.values()).listIterator(0);
    }

    @Override
    public final boolean hasNext() {
        return this.f7834b.hasNext() || this.f7833a.hasNext();
    }

    @Override
    public final Object next() {
        if (!this.f7834b.hasNext()) {
            this.f7834b = ((AbstractC2274q1) this.f7833a.next()).iterator();
        }
        return this.f7834b.next();
    }
}

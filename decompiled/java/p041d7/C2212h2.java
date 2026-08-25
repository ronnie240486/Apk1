package p041d7;

import java.util.Objects;

public final class C2212h2 extends AbstractC2292s5 {

    public int f7917a;

    public Object f7918b;

    public final AbstractC2292s5 f7919c;

    public C2212h2(AbstractC2292s5 abstractC2292s5) {
        this.f7919c = abstractC2292s5;
    }

    @Override
    public final boolean hasNext() {
        return this.f7917a > 0 || this.f7919c.hasNext();
    }

    @Override
    public final Object next() {
        if (this.f7917a <= 0) {
            AbstractC2316w4 abstractC2316w4 = (AbstractC2316w4) this.f7919c.next();
            this.f7918b = abstractC2316w4.mo5265b();
            this.f7917a = abstractC2316w4.mo5264a();
        }
        this.f7917a--;
        Object obj = this.f7918b;
        Objects.requireNonNull(obj);
        return obj;
    }
}

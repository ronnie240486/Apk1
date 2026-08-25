package p041d7;

import java.util.Map;
import java.util.Objects;

public final class C2163a2 extends AbstractC2292s5 {

    public final AbstractC2292s5 f7827a;

    public Object f7828b = null;

    public AbstractC2292s5 f7829c = C2289s2.f8052d;

    public C2163a2(AbstractC2205g2 abstractC2205g2) {
        this.f7827a = abstractC2205g2.f7907f.entrySet().iterator();
    }

    @Override
    public final boolean hasNext() {
        return this.f7829c.hasNext() || this.f7827a.hasNext();
    }

    @Override
    public final Object next() {
        if (!this.f7829c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f7827a.next();
            this.f7828b = entry.getKey();
            this.f7829c = ((AbstractC2274q1) entry.getValue()).iterator();
        }
        Object obj = this.f7828b;
        Objects.requireNonNull(obj);
        return new C2281r1(obj, this.f7829c.next());
    }
}

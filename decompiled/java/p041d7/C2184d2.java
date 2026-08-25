package p041d7;

import java.util.Map;

public final class C2184d2 extends AbstractC2274q1 {

    public final AbstractC2205g2 f7867b;

    public C2184d2(AbstractC2205g2 abstractC2205g2) {
        this.f7867b = abstractC2205g2;
    }

    @Override
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.f7867b.m5285g(entry.getKey(), entry.getValue());
    }

    @Override
    public final AbstractC2292s5 iterator() {
        AbstractC2205g2 abstractC2205g2 = this.f7867b;
        abstractC2205g2.getClass();
        return new C2163a2(abstractC2205g2);
    }

    @Override
    public final int size() {
        return this.f7867b.f7908g;
    }
}

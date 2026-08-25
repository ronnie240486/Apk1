package p041d7;

import java.util.Map;
import p020b7.AbstractC1332b;

public final class C2235k4 extends AbstractC2239l1 implements Map.Entry {

    public final Map.Entry f7977a;

    public final C2282r2 f7978b;

    public C2235k4(C2282r2 c2282r2, Map.Entry entry) {
        this.f7977a = entry;
        this.f7978b = c2282r2;
    }

    @Override
    public final Object delegate() {
        return this.f7977a;
    }

    @Override
    public final boolean equals(Object obj) {
        return this.f7977a.equals(obj);
    }

    @Override
    public final Object getKey() {
        return this.f7977a.getKey();
    }

    @Override
    public final Object getValue() {
        return this.f7977a.getValue();
    }

    @Override
    public final int hashCode() {
        return this.f7977a.hashCode();
    }

    @Override
    public final Object setValue(Object obj) {
        C2242l4 c2242l4 = (C2242l4) ((C2162a1) this.f7978b.f8041c).f7826b;
        Map.Entry entry = this.f7977a;
        AbstractC1332b.m3215f(c2242l4.m5238d(entry.getKey(), obj));
        return entry.setValue(obj);
    }
}

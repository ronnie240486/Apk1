package p041d7;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class C2169b1 extends AbstractC2218i1 implements Set {

    public final C2176c1 f7832a;

    public C2169b1(C2176c1 c2176c1) {
        this.f7832a = c2176c1;
    }

    @Override
    public final Collection delegate() {
        C2176c1 c2176c1 = this.f7832a;
        return AbstractC2182d0.m5148k(c2176c1.f7848f.mo5108a(), c2176c1.mo5110c());
    }

    @Override
    public final boolean equals(Object obj) {
        return AbstractC2182d0.m5147j(this, obj);
    }

    @Override
    public final int hashCode() {
        return AbstractC2182d0.m5153p(this);
    }

    @Override
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        C2176c1 c2176c1 = this.f7832a;
        if (!c2176c1.f7848f.containsKey(entry.getKey()) || !c2176c1.f7849g.apply(entry.getKey())) {
            return false;
        }
        return c2176c1.f7848f.remove(entry.getKey(), entry.getValue());
    }
}

package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import p020b7.C1356p;
import p020b7.C1357q;
import p020b7.C1360t;
import p029c7.C1427w;

public final class C2294t0 extends C1427w {

    public final C2300u0 f8056c;

    public C2294t0(C2300u0 c2300u0) {
        super(c2300u0);
        this.f8056c = c2300u0;
    }

    @Override
    public final boolean remove(Object obj) {
        if (!(obj instanceof Collection)) {
            return false;
        }
        Collection collection = (Collection) obj;
        C2300u0 c2300u0 = this.f8056c;
        Iterator it = c2300u0.f8068d.f8100f.mo5173d().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            C2189e0 c2189e0M5289o = C2324y0.m5289o((Collection) entry.getValue(), new C2318x0(c2300u0.f8068d, entry.getKey()));
            if (!c2189e0M5289o.isEmpty() && collection.equals(c2189e0M5289o)) {
                if (c2189e0M5289o.size() == ((Collection) entry.getValue()).size()) {
                    it.remove();
                    return true;
                }
                c2189e0M5289o.clear();
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean removeAll(Collection collection) {
        return this.f8056c.f8068d.m5290p(new C1356p(new C1357q(collection), EnumC2221i4.f7944b));
    }

    @Override
    public final boolean retainAll(Collection collection) {
        return this.f8056c.f8068d.m5290p(new C1356p(new C1360t(new C1357q(collection)), EnumC2221i4.f7944b));
    }
}

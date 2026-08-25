package p041d7;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p020b7.AbstractC1332b;
import p020b7.C1355o;
import p020b7.C1356p;
import p020b7.InterfaceC1354n;

public final class C2242l4 extends AbstractC2263o4 {

    public final Map f7987d;

    public final Object f7988e;

    public final int f7989f;

    public final Object f7990g;

    public C2242l4(Map map, InterfaceC1354n interfaceC1354n, C1356p c1356p) {
        this(map, c1356p);
        this.f7989f = 1;
        this.f7990g = interfaceC1354n;
    }

    @Override
    public final Set mo5170a() {
        switch (this.f7989f) {
            case 0:
                return new C2162a1(1, this);
            default:
                return AbstractC2182d0.m5149l(this.f7987d.entrySet(), this.f7988e);
        }
    }

    @Override
    public final Set mo5185b() {
        switch (this.f7989f) {
            case 0:
                return new C2202g(this, 2);
            default:
                return AbstractC2182d0.m5149l(this.f7987d.keySet(), this.f7990g);
        }
    }

    @Override
    public final Collection mo5237c() {
        return new C2249m4(this, this.f7987d, this.f7988e);
    }

    @Override
    public boolean containsKey(Object obj) {
        switch (this.f7989f) {
            case 1:
                return this.f7987d.containsKey(obj) && this.f7990g.apply(obj);
            default:
                return m5239e(obj);
        }
    }

    public final boolean m5238d(Object obj, Object obj2) {
        return this.f7988e.apply(new C2281r1(obj, obj2));
    }

    public final boolean m5239e(Object obj) {
        Map map = this.f7987d;
        return map.containsKey(obj) && m5238d(obj, map.get(obj));
    }

    @Override
    public final Object get(Object obj) {
        Object obj2 = this.f7987d.get(obj);
        if (obj2 == null || !m5238d(obj, obj2)) {
            return null;
        }
        return obj2;
    }

    @Override
    public final boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override
    public final Object put(Object obj, Object obj2) {
        AbstractC1332b.m3215f(m5238d(obj, obj2));
        return this.f7987d.put(obj, obj2);
    }

    @Override
    public final void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            AbstractC1332b.m3215f(m5238d(entry.getKey(), entry.getValue()));
        }
        this.f7987d.putAll(map);
    }

    @Override
    public final Object remove(Object obj) {
        if (containsKey(obj)) {
            return this.f7987d.remove(obj);
        }
        return null;
    }

    public C2242l4(Map map, C1355o c1355o) {
        this(map, (InterfaceC1354n) c1355o);
        this.f7989f = 0;
        this.f7990g = AbstractC2182d0.m5149l(map.entrySet(), this.f7988e);
    }

    public C2242l4(Map map, InterfaceC1354n interfaceC1354n) {
        this.f7987d = map;
        this.f7988e = interfaceC1354n;
    }
}

package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p020b7.C1355o;
import p020b7.InterfaceC1354n;
import p029c7.C1427w;

public final class C2324y0 extends AbstractC2311w implements InterfaceC2190e1, InterfaceC2183d1 {

    public final InterfaceC2243l5 f8100f;

    public final C1355o f8101g;

    public C2324y0(InterfaceC2243l5 interfaceC2243l5, C1355o c1355o) {
        interfaceC2243l5.getClass();
        this.f8100f = interfaceC2243l5;
        this.f8101g = c1355o;
    }

    public static C2189e0 m5289o(Collection collection, C2318x0 c2318x0) {
        return collection instanceof Set ? AbstractC2182d0.m5149l((Set) collection, c2318x0) : AbstractC2182d0.m5148k(collection, c2318x0);
    }

    @Override
    public final Collection mo5108a() {
        return (Set) super.mo5108a();
    }

    @Override
    public final InterfaceC2243l5 mo5109b() {
        return this.f8100f;
    }

    @Override
    public final InterfaceC1354n mo5110c() {
        return this.f8101g;
    }

    @Override
    public final void clear() {
        ((Set) super.mo5108a()).clear();
    }

    @Override
    public final boolean containsKey(Object obj) {
        return mo5173d().get(obj) != null;
    }

    @Override
    public final InterfaceC2243l5 mo5111e() {
        return this.f8100f;
    }

    @Override
    public final Map mo5112i() {
        return new C2300u0(this);
    }

    @Override
    public final Collection mo5113j() {
        return AbstractC2182d0.m5149l(this.f8100f.mo5108a(), this.f8101g);
    }

    @Override
    public final Set mo5114k() {
        return mo5173d().keySet();
    }

    @Override
    public final InterfaceC2310v4 mo5115l() {
        return new C2312w0(this);
    }

    @Override
    public final Collection mo5116m() {
        return new C1427w(this);
    }

    public final boolean m5290p(InterfaceC1354n interfaceC1354n) {
        Iterator it = this.f8100f.mo5173d().entrySet().iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            C2189e0 c2189e0M5289o = m5289o((Collection) entry.getValue(), new C2318x0(this, key));
            if (!c2189e0M5289o.isEmpty() && interfaceC1354n.apply(new C2281r1(key, c2189e0M5289o))) {
                if (c2189e0M5289o.size() == ((Collection) entry.getValue()).size()) {
                    it.remove();
                } else {
                    c2189e0M5289o.clear();
                }
                z7 = true;
            }
        }
        return z7;
    }

    @Override
    public final int size() {
        return ((Set) super.mo5108a()).size();
    }

    @Override
    public final Set mo5108a() {
        return (Set) super.mo5108a();
    }

    @Override
    public final Set get(Object obj) {
        return (Set) m5289o(this.f8100f.get(obj), new C2318x0(this, obj));
    }
}

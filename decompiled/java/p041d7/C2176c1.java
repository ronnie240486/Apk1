package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p020b7.AbstractC1332b;
import p020b7.C1356p;
import p020b7.InterfaceC1354n;
import p029c7.C1427w;

public final class C2176c1 extends AbstractC2311w implements InterfaceC2190e1, InterfaceC2183d1 {

    public final InterfaceC2243l5 f7848f;

    public final Object f7849g;

    public C2176c1(InterfaceC2243l5 interfaceC2243l5, InterfaceC1354n interfaceC1354n) {
        interfaceC2243l5.getClass();
        this.f7848f = interfaceC2243l5;
        this.f7849g = interfaceC1354n;
    }

    @Override
    public final Collection mo5108a() {
        return (Set) super.mo5108a();
    }

    @Override
    public final InterfaceC2243l5 mo5109b() {
        return this.f7848f;
    }

    @Override
    public final InterfaceC1354n mo5110c() {
        return new C1356p(this.f7849g, EnumC2221i4.f7943a);
    }

    @Override
    public final void clear() {
        keySet().clear();
    }

    @Override
    public final boolean containsKey(Object obj) {
        if (this.f7848f.containsKey(obj)) {
            return this.f7849g.apply(obj);
        }
        return false;
    }

    @Override
    public final InterfaceC2243l5 mo5111e() {
        return this.f7848f;
    }

    @Override
    public final Map mo5112i() {
        Map mapMo5173d = this.f7848f.mo5173d();
        ?? r10 = this.f7849g;
        r10.getClass();
        C1356p c1356p = new C1356p(r10, EnumC2221i4.f7943a);
        if (mapMo5173d instanceof C2242l4) {
            C2242l4 c2242l4 = (C2242l4) mapMo5173d;
            return new C2242l4(c2242l4.f7987d, AbstractC1332b.m3210a(c2242l4.f7988e, c1356p));
        }
        mapMo5173d.getClass();
        return new C2242l4(mapMo5173d, r10, c1356p);
    }

    @Override
    public final Collection mo5113j() {
        return new C2169b1(this);
    }

    @Override
    public final Set mo5114k() {
        return AbstractC2182d0.m5149l(this.f7848f.keySet(), this.f7849g);
    }

    @Override
    public final InterfaceC2310v4 mo5115l() {
        InterfaceC2310v4 interfaceC2310v4Mo5174f = this.f7848f.mo5174f();
        boolean z7 = interfaceC2310v4Mo5174f instanceof C2328y4;
        ?? r10 = this.f7849g;
        if (!z7) {
            return new C2328y4(interfaceC2310v4Mo5174f, r10);
        }
        C2328y4 c2328y4 = (C2328y4) interfaceC2310v4Mo5174f;
        return new C2328y4(c2328y4.f8107c, AbstractC1332b.m3210a(c2328y4.f8108d, r10));
    }

    @Override
    public final Collection mo5116m() {
        return new C1427w(this);
    }

    @Override
    public final int size() {
        Iterator it = mo5173d().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Collection) it.next()).size();
        }
        return size;
    }

    @Override
    public final Set mo5108a() {
        return (Set) super.mo5108a();
    }

    @Override
    public final Set get(Object obj) {
        Collection c2162a1;
        boolean zApply = this.f7849g.apply(obj);
        InterfaceC2243l5 interfaceC2243l5 = this.f7848f;
        if (zApply) {
            c2162a1 = interfaceC2243l5.get(obj);
        } else {
            c2162a1 = interfaceC2243l5 instanceof InterfaceC2243l5 ? new C2162a1(0, obj) : new C2330z0(obj);
        }
        return (Set) c2162a1;
    }
}

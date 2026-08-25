package p041d7;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1354n;
import p187r4.AbstractC3612b;

public final class C2328y4 extends AbstractC2329z {

    public final InterfaceC2310v4 f8107c;

    public final Object f8108d;

    public C2328y4(InterfaceC2310v4 interfaceC2310v4, InterfaceC1354n interfaceC1354n) {
        interfaceC2310v4.getClass();
        this.f8107c = interfaceC2310v4;
        interfaceC1354n.getClass();
        this.f8108d = interfaceC1354n;
    }

    @Override
    public final int add(int i6, Object obj) {
        ?? r10 = this.f8108d;
        boolean zApply = r10.apply(obj);
        Serializable serializable = (Serializable) r10;
        if (zApply) {
            return this.f8107c.add(i6, obj);
        }
        throw new IllegalArgumentException(AbstractC1332b.m3228s("Element %s does not match predicate %s", obj, serializable));
    }

    @Override
    public final int mo5166b(int i6, Object obj) {
        AbstractC2182d0.m5141d(i6, "occurrences");
        if (i6 == 0) {
            return count(obj);
        }
        if (contains(obj)) {
            return this.f8107c.mo5166b(i6, obj);
        }
        return 0;
    }

    @Override
    public final Set mo5293c() {
        return AbstractC2182d0.m5149l(this.f8107c.elementSet(), this.f8108d);
    }

    @Override
    public final void clear() {
        elementSet().clear();
    }

    @Override
    public final int count(Object obj) {
        int iCount = this.f8107c.count(obj);
        if (iCount <= 0 || !this.f8108d.apply(obj)) {
            return 0;
        }
        return iCount;
    }

    @Override
    public final Set mo5294d() {
        return AbstractC2182d0.m5149l(this.f8107c.entrySet(), new C2322x4(this));
    }

    @Override
    public final int mo5281e() {
        return elementSet().size();
    }

    @Override
    public final Iterator mo5282f() {
        throw new AssertionError("should never be called");
    }

    @Override
    public final Iterator mo5283g() {
        throw new AssertionError("should never be called");
    }

    @Override
    public final Iterator iterator() {
        Iterator it = this.f8107c.iterator();
        ?? r10 = this.f8108d;
        it.getClass();
        r10.getClass();
        return new C2287s0(it, r10);
    }

    @Override
    public final int size() {
        Iterator it = entrySet().iterator();
        long jMo5264a = 0;
        while (it.hasNext()) {
            jMo5264a += (long) ((AbstractC2316w4) it.next()).mo5264a();
        }
        return AbstractC3612b.m7255K(jMo5264a);
    }
}

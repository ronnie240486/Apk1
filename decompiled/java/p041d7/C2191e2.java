package p041d7;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public final class C2191e2 extends AbstractC2274q1 implements InterfaceC2310v4 {

    public transient C2180c5 f7878b;

    public transient AbstractC2233k2 f7879c;

    public final AbstractC2205g2 f7880d;

    public C2191e2(AbstractC2205g2 abstractC2205g2) {
        this.f7880d = abstractC2205g2;
    }

    @Override
    public final int add(int i6, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int mo5166b(int i6, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final AbstractC2301u1 mo5167c() {
        C2180c5 c2180c5 = this.f7878b;
        if (c2180c5 != null) {
            return c2180c5;
        }
        AbstractC2301u1 abstractC2301u1Mo5167c = super.mo5167c();
        this.f7878b = (C2180c5) abstractC2301u1Mo5167c;
        return abstractC2301u1Mo5167c;
    }

    @Override
    public final boolean contains(Object obj) {
        return this.f7880d.f7907f.containsKey(obj);
    }

    @Override
    public final int count(Object obj) {
        Collection collection = (Collection) this.f7880d.f7907f.get(obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    @Override
    public final int mo5123d(Object[] objArr, int i6) {
        AbstractC2292s5 it = entrySet().iterator();
        while (it.hasNext()) {
            AbstractC2316w4 abstractC2316w4 = (AbstractC2316w4) it.next();
            Arrays.fill(objArr, i6, abstractC2316w4.mo5264a() + i6, abstractC2316w4.mo5265b());
            i6 += abstractC2316w4.mo5264a();
        }
        return i6;
    }

    @Override
    public final Set elementSet() {
        return this.f7880d.f7907f.keySet();
    }

    @Override
    public final boolean equals(Object obj) {
        return AbstractC2182d0.m5145h(this, obj);
    }

    @Override
    public final boolean mo5127h() {
        throw null;
    }

    @Override
    public final int hashCode() {
        return AbstractC2182d0.m5153p(entrySet());
    }

    @Override
    public final AbstractC2292s5 iterator() {
        return new C2212h2(entrySet().iterator());
    }

    @Override
    public final AbstractC2233k2 entrySet() {
        AbstractC2233k2 c2219i2 = this.f7879c;
        if (c2219i2 == null) {
            c2219i2 = isEmpty() ? C2222i5.f7947j : new C2219i2(this);
            this.f7879c = c2219i2;
        }
        return c2219i2;
    }

    @Override
    public final int size() {
        return this.f7880d.f7908g;
    }

    @Override
    public final String toString() {
        return entrySet().toString();
    }
}

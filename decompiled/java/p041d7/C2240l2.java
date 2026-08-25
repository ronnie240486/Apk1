package p041d7;

import java.util.Set;

public final class C2240l2 extends AbstractC2177c2 {
    @Override
    public final int mo5117a(Iterable iterable) {
        if (iterable instanceof Set) {
            return Math.max(4, ((Set) iterable).size());
        }
        return 4;
    }

    @Override
    public final AbstractC2267p1 mo5118b(int i6) {
        int i10 = AbstractC2233k2.f7972c;
        AbstractC2182d0.m5141d(i6, "expectedSize");
        C2226j2 c2226j2 = new C2226j2(i6);
        c2226j2.f7957d = new Object[AbstractC2233k2.m5234j(i6)];
        return c2226j2;
    }

    @Override
    public final AbstractC2177c2 mo5120d(Object obj, Object obj2) {
        super.mo5120d(obj, obj2);
        return this;
    }
}

package p253x8;

import java.util.RandomAccess;
import p103j9.AbstractC2796i;

public final class C4141d extends AbstractC4142e implements RandomAccess {

    public final AbstractC4142e f14064a;

    public final int f14065b;

    public final int f14066c;

    public C4141d(AbstractC4142e abstractC4142e, int i6, int i10) {
        AbstractC2796i.m5785f(abstractC4142e, "list");
        this.f14064a = abstractC4142e;
        this.f14065b = i6;
        C4139b c4139b = AbstractC4142e.Companion;
        int size = abstractC4142e.size();
        c4139b.getClass();
        C4139b.m8159c(i6, i10, size);
        this.f14066c = i10 - i6;
    }

    @Override
    public final Object get(int i6) {
        C4139b c4139b = AbstractC4142e.Companion;
        int i10 = this.f14066c;
        c4139b.getClass();
        C4139b.m8157a(i6, i10);
        return this.f14064a.get(this.f14065b + i6);
    }

    @Override
    public final int getSize() {
        return this.f14066c;
    }
}

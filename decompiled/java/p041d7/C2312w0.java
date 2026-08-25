package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class C2312w0 extends C2304u4 {

    public final C2324y0 f8083d;

    public C2312w0(C2324y0 c2324y0) {
        super(c2324y0);
        this.f8083d = c2324y0;
    }

    @Override
    public final int mo5166b(int i6, Object obj) {
        AbstractC2182d0.m5141d(i6, "occurrences");
        if (i6 == 0) {
            return count(obj);
        }
        C2324y0 c2324y0 = this.f8083d;
        Collection collection = (Collection) c2324y0.f8100f.mo5173d().get(obj);
        int i10 = 0;
        if (collection == null) {
            return 0;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (c2324y0.f8101g.apply(new C2281r1(obj, it.next())) && (i10 = i10 + 1) <= i6) {
                it.remove();
            }
        }
        return i10;
    }

    @Override
    public final Set entrySet() {
        return new C2323y(this, 1);
    }
}

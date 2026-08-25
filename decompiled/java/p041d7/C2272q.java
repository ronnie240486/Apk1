package p041d7;

import java.util.Collection;
import java.util.Set;

public final class C2272q extends AbstractC2244m implements Set {

    public final C2291s4 f8026f;

    public C2272q(C2291s4 c2291s4, Object obj, Set set) {
        super(c2291s4, obj, set, null);
        this.f8026f = c2291s4;
    }

    @Override
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zM5161x = AbstractC2182d0.m5161x((Set) this.f7992b, collection);
        if (zM5161x) {
            int size2 = this.f7992b.size();
            this.f8026f.f8046g += size2 - size;
            m5242e();
        }
        return zM5161x;
    }
}

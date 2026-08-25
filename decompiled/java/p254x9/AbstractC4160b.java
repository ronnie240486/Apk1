package p254x9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p222u7.C3926b;

public abstract class AbstractC4160b extends AbstractC4173o {

    public static final AtomicReferenceFieldUpdater f14083a = AtomicReferenceFieldUpdater.newUpdater(AbstractC4160b.class, Object.class, "_consensus");
    private volatile Object _consensus = AbstractC4159a.f14077a;

    @Override
    public final Object mo8210a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14083a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        C3926b c3926b = AbstractC4159a.f14077a;
        if (obj2 == c3926b) {
            C3926b c3926bMo7711c = mo7711c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == c3926b) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, c3926b, c3926bMo7711c)) {
                    if (atomicReferenceFieldUpdater.get(this) != c3926b) {
                        obj2 = atomicReferenceFieldUpdater.get(this);
                    }
                }
                obj2 = c3926bMo7711c;
            }
        }
        mo7710b(obj, obj2);
        return obj2;
    }

    public abstract void mo7710b(Object obj, Object obj2);

    public abstract C3926b mo7711c(Object obj);
}

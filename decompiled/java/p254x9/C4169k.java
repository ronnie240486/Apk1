package p254x9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class C4169k {

    public static final AtomicReferenceFieldUpdater f14103a = AtomicReferenceFieldUpdater.newUpdater(C4169k.class, Object.class, "_cur");
    private volatile Object _cur = new C4171m(8, false);

    public final boolean m8219a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14103a;
            C4171m c4171m = (C4171m) atomicReferenceFieldUpdater.get(this);
            int iM8223a = c4171m.m8223a(runnable);
            if (iM8223a == 0) {
                return true;
            }
            if (iM8223a == 1) {
                C4171m c4171mM8225c = c4171m.m8225c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, c4171m, c4171mM8225c) && atomicReferenceFieldUpdater.get(this) == c4171m) {
                }
            } else if (iM8223a == 2) {
                return false;
            }
        }
    }

    public final void m8220b() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14103a;
            C4171m c4171m = (C4171m) atomicReferenceFieldUpdater.get(this);
            if (c4171m.m8224b()) {
                return;
            }
            C4171m c4171mM8225c = c4171m.m8225c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, c4171m, c4171mM8225c) && atomicReferenceFieldUpdater.get(this) == c4171m) {
            }
        }
    }

    public final int m8221c() {
        C4171m c4171m = (C4171m) f14103a.get(this);
        c4171m.getClass();
        long j10 = C4171m.f14106f.get(c4171m);
        return 1073741823 & (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j10)));
    }

    public final Object m8222d() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14103a;
            C4171m c4171m = (C4171m) atomicReferenceFieldUpdater.get(this);
            Object objM8226d = c4171m.m8226d();
            if (objM8226d != C4171m.f14107g) {
                return objM8226d;
            }
            C4171m c4171mM8225c = c4171m.m8225c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, c4171m, c4171mM8225c) && atomicReferenceFieldUpdater.get(this) == c4171m) {
            }
        }
    }
}

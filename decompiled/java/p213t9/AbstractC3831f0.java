package p213t9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import p008a9.InterfaceC0079i;
import p222u7.C3926b;
import p253x8.C4145h;
import p254x9.C4171m;

public abstract class AbstractC3831f0 extends AbstractC3834g0 implements InterfaceC3873y {

    public static final AtomicReferenceFieldUpdater f12911f = AtomicReferenceFieldUpdater.newUpdater(AbstractC3831f0.class, Object.class, "_queue");

    public static final AtomicReferenceFieldUpdater f12912g = AtomicReferenceFieldUpdater.newUpdater(AbstractC3831f0.class, Object.class, "_delayed");

    public static final AtomicIntegerFieldUpdater f12913h = AtomicIntegerFieldUpdater.newUpdater(AbstractC3831f0.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    @Override
    public final void mo7665d(InterfaceC0079i interfaceC0079i, Runnable runnable) {
        mo7666l(runnable);
    }

    public void mo7666l(Runnable runnable) {
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12911f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (f12913h.get(this) == 0) {
                if (obj == null) {
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == null);
                } else if (obj instanceof C4171m) {
                    C4171m c4171m = (C4171m) obj;
                    int iM8223a = c4171m.m8223a(runnable);
                    if (iM8223a == 0) {
                        break;
                    }
                    if (iM8223a == 1) {
                        C4171m c4171mM8225c = c4171m.m8225c();
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c4171mM8225c) && atomicReferenceFieldUpdater.get(this) == obj) {
                        }
                    } else if (iM8223a != 2) {
                    }
                } else if (obj != AbstractC3865u.f12956b) {
                    C4171m c4171m2 = new C4171m(8, true);
                    c4171m2.m8223a((Runnable) obj);
                    c4171m2.m8223a(runnable);
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj, c4171m2)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj);
                }
            }
            RunnableC3867v.f12965i.mo7666l(runnable);
            return;
        }
        Thread threadMo7646i = mo7646i();
        if (Thread.currentThread() != threadMo7646i) {
            LockSupport.unpark(threadMo7646i);
        }
    }

    public final long m7667m() {
        C4145h c4145h = this.f12918e;
        if (((c4145h == null || c4145h.isEmpty()) ? Long.MAX_VALUE : 0L) == 0) {
            return 0L;
        }
        Object obj = f12911f.get(this);
        if (obj != null) {
            if (!(obj instanceof C4171m)) {
                return obj == AbstractC3865u.f12956b ? Long.MAX_VALUE : 0L;
            }
            long j10 = C4171m.f14106f.get((C4171m) obj);
            if (((int) (1073741823 & j10)) != ((int) ((j10 & 1152921503533105152L) >> 30))) {
                return 0L;
            }
        }
        return Long.MAX_VALUE;
    }

    public final boolean m7668n() {
        C4145h c4145h = this.f12918e;
        if (!(c4145h != null ? c4145h.isEmpty() : true)) {
            return false;
        }
        Object obj = f12911f.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof C4171m) {
            long j10 = C4171m.f14106f.get((C4171m) obj);
            if (((int) (1073741823 & j10)) == ((int) ((j10 & 1152921503533105152L) >> 30))) {
                return true;
            }
        } else if (obj == AbstractC3865u.f12956b) {
            return true;
        }
        return false;
    }

    public final long m7669o() {
        Runnable runnable;
        if (m7674k()) {
            return 0L;
        }
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12911f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            runnable = null;
            if (obj == null) {
                break;
            }
            if (obj instanceof C4171m) {
                C4171m c4171m = (C4171m) obj;
                Object objM8226d = c4171m.m8226d();
                if (objM8226d != C4171m.f14107g) {
                    runnable = (Runnable) objM8226d;
                    break;
                }
                C4171m c4171mM8225c = c4171m.m8225c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c4171mM8225c) && atomicReferenceFieldUpdater.get(this) == obj) {
                }
            } else {
                if (obj == AbstractC3865u.f12956b) {
                    break;
                }
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        runnable = (Runnable) obj;
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj);
            }
        }
        if (runnable == null) {
            return m7667m();
        }
        runnable.run();
        return 0L;
    }

    @Override
    public void shutdown() {
        AbstractC3832f1.f12914a.set(null);
        f12913h.set(this, 1);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12911f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            C3926b c3926b = AbstractC3865u.f12956b;
            if (obj == null) {
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, c3926b)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == null);
            } else if (obj instanceof C4171m) {
                ((C4171m) obj).m8224b();
                break;
            } else {
                if (obj == c3926b) {
                    break;
                }
                C4171m c4171m = new C4171m(8, true);
                c4171m.m8223a((Runnable) obj);
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, c4171m)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj);
            }
        }
        while (m7669o() <= 0) {
        }
        System.nanoTime();
    }
}

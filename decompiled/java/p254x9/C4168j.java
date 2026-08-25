package p254x9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p103j9.AbstractC2796i;
import p213t9.AbstractC3865u;

public class C4168j {

    public static final AtomicReferenceFieldUpdater f14100a = AtomicReferenceFieldUpdater.newUpdater(C4168j.class, Object.class, "_next");

    public static final AtomicReferenceFieldUpdater f14101b = AtomicReferenceFieldUpdater.newUpdater(C4168j.class, Object.class, "_prev");

    public static final AtomicReferenceFieldUpdater f14102c = AtomicReferenceFieldUpdater.newUpdater(C4168j.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    public final C4168j m8215d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f14101b;
            C4168j c4168j = (C4168j) atomicReferenceFieldUpdater2.get(this);
            C4168j c4168j2 = c4168j;
            while (true) {
                C4168j c4168j3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = f14100a;
                    obj = atomicReferenceFieldUpdater.get(c4168j2);
                    if (obj == this) {
                        if (c4168j == c4168j2) {
                            return c4168j2;
                        }
                        while (!atomicReferenceFieldUpdater2.compareAndSet(this, c4168j, c4168j2)) {
                            if (atomicReferenceFieldUpdater2.get(this) != c4168j) {
                                break;
                            }
                        }
                        return c4168j2;
                    }
                    if (mo7732h()) {
                        return null;
                    }
                    if (obj == null) {
                        return c4168j2;
                    }
                    if (obj instanceof AbstractC4173o) {
                        ((AbstractC4173o) obj).mo8210a(c4168j2);
                        break;
                    }
                    if (!(obj instanceof C4174p)) {
                        AbstractC2796i.m5783d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                        c4168j3 = c4168j2;
                        c4168j2 = (C4168j) obj;
                    } else {
                        if (c4168j3 != null) {
                            break;
                        }
                        c4168j2 = (C4168j) atomicReferenceFieldUpdater2.get(c4168j2);
                    }
                }
                C4168j c4168j4 = ((C4174p) obj).f14113a;
                while (!atomicReferenceFieldUpdater.compareAndSet(c4168j3, c4168j2, c4168j4)) {
                    if (atomicReferenceFieldUpdater.get(c4168j3) != c4168j2) {
                        break;
                    }
                }
                c4168j2 = c4168j3;
            }
        }
    }

    public final void m8216e(C4168j c4168j) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14101b;
            C4168j c4168j2 = (C4168j) atomicReferenceFieldUpdater.get(c4168j);
            if (m8217f() != c4168j) {
                return;
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(c4168j, c4168j2, this)) {
                    if (mo7732h()) {
                        c4168j.m8215d();
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(c4168j) == c4168j2);
        }
    }

    public final Object m8217f() {
        while (true) {
            Object obj = f14100a.get(this);
            if (!(obj instanceof AbstractC4173o)) {
                return obj;
            }
            ((AbstractC4173o) obj).mo8210a(this);
        }
    }

    public final C4168j m8218g() {
        C4168j c4168j;
        Object objM8217f = m8217f();
        C4174p c4174p = objM8217f instanceof C4174p ? (C4174p) objM8217f : null;
        if (c4174p != null && (c4168j = c4174p.f14113a) != null) {
            return c4168j;
        }
        AbstractC2796i.m5783d(objM8217f, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (C4168j) objM8217f;
    }

    public boolean mo7732h() {
        return m8217f() instanceof C4174p;
    }

    public String toString() {
        return new C4167i(this) + '@' + AbstractC3865u.m7691f(this);
    }
}

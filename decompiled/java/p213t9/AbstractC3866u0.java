package p213t9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p091i9.InterfaceC2724l;
import p103j9.AbstractC2796i;
import p254x9.C4168j;
import p254x9.C4174p;

public abstract class AbstractC3866u0 extends C4168j implements InterfaceC3822c0, InterfaceC3846k0, InterfaceC2724l {

    public C3874y0 f12964d;

    @Override
    public final void mo7644a() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2;
        C3874y0 c3874y0M7702i = m7702i();
        while (true) {
            Object objM7728u = c3874y0M7702i.m7728u();
            if (objM7728u instanceof AbstractC3866u0) {
                if (objM7728u != this) {
                    return;
                }
                C3825d0 c3825d0 = AbstractC3865u.f12963i;
                do {
                    atomicReferenceFieldUpdater2 = C3874y0.f12981a;
                    if (atomicReferenceFieldUpdater2.compareAndSet(c3874y0M7702i, objM7728u, c3825d0)) {
                        return;
                    }
                } while (atomicReferenceFieldUpdater2.get(c3874y0M7702i) == objM7728u);
            } else {
                if (!(objM7728u instanceof InterfaceC3846k0) || ((InterfaceC3846k0) objM7728u).mo7647c() == null) {
                    return;
                }
                while (true) {
                    Object objM8217f = m8217f();
                    if (objM8217f instanceof C4174p) {
                        C4168j c4168j = ((C4174p) objM8217f).f14113a;
                        return;
                    }
                    if (objM8217f == this) {
                        return;
                    }
                    AbstractC2796i.m5783d(objM8217f, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                    C4168j c4168j2 = (C4168j) objM8217f;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = C4168j.f14102c;
                    C4174p c4174p = (C4174p) atomicReferenceFieldUpdater3.get(c4168j2);
                    if (c4174p == null) {
                        c4174p = new C4174p(c4168j2);
                        atomicReferenceFieldUpdater3.lazySet(c4168j2, c4174p);
                    }
                    do {
                        atomicReferenceFieldUpdater = C4168j.f14100a;
                        if (atomicReferenceFieldUpdater.compareAndSet(this, objM8217f, c4174p)) {
                            c4168j2.m8215d();
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == objM8217f);
                }
            }
        }
    }

    @Override
    public final C3876z0 mo7647c() {
        return null;
    }

    public final C3874y0 m7702i() {
        C3874y0 c3874y0 = this.f12964d;
        if (c3874y0 != null) {
            return c3874y0;
        }
        AbstractC2796i.m5791l("job");
        throw null;
    }

    @Override
    public final boolean isActive() {
        return true;
    }

    public abstract void mo7671j(Throwable th);

    @Override
    public final String toString() {
        return getClass().getSimpleName() + '@' + AbstractC3865u.m7691f(this) + "[job@" + AbstractC3865u.m7691f(m7702i()) + ']';
    }
}

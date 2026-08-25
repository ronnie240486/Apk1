package p213t9;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p008a9.InterfaceC0074d;
import p103j9.AbstractC2796i;
import p222u7.C3926b;
import p243w8.C4070l;
import p254x9.AbstractC4159a;
import p254x9.C4165g;

public final class C3833g extends AbstractC3862s0 {

    public final C3827e f12915e;

    public C3833g(C3827e c3827e) {
        this.f12915e = c3827e;
    }

    @Override
    public final Object invoke(Object obj) {
        mo7671j((Throwable) obj);
        return C4070l.f13734a;
    }

    @Override
    public final void mo7671j(Throwable th) {
        C3874y0 c3874y0M7702i = m7702i();
        C3827e c3827e = this.f12915e;
        c3827e.getClass();
        CancellationException cancellationExceptionM7726q = c3874y0M7702i.m7726q();
        if (c3827e.m7662r()) {
            InterfaceC0074d interfaceC0074d = c3827e.f12908d;
            AbstractC2796i.m5783d(interfaceC0074d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            C4165g c4165g = (C4165g) interfaceC0074d;
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C4165g.f14089h;
                Object obj = atomicReferenceFieldUpdater.get(c4165g);
                C3926b c3926b = AbstractC4159a.f14080d;
                if (AbstractC2796i.m5780a(obj, c3926b)) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(c4165g, c3926b, cancellationExceptionM7726q)) {
                        if (atomicReferenceFieldUpdater.get(c4165g) != c3926b) {
                        }
                    }
                    return;
                } else {
                    if (obj instanceof Throwable) {
                        return;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(c4165g, obj, null)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(c4165g) == obj);
                }
            }
        }
        c3827e.m7654j(cancellationExceptionM7726q);
        if (c3827e.m7662r()) {
            return;
        }
        c3827e.m7655k();
    }
}

package p213t9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p103j9.AbstractC2796i;
import p222u7.C3926b;
import p254x9.AbstractC4159a;
import p254x9.AbstractC4160b;
import p254x9.C4168j;

public final class C3872x0 extends AbstractC4160b {

    public final AbstractC3866u0 f12977b;

    public C3876z0 f12978c;

    public final C3874y0 f12979d;

    public final InterfaceC3846k0 f12980e;

    public C3872x0(AbstractC3866u0 abstractC3866u0, C3874y0 c3874y0, InterfaceC3846k0 interfaceC3846k0) {
        this.f12979d = c3874y0;
        this.f12980e = interfaceC3846k0;
        this.f12977b = abstractC3866u0;
    }

    @Override
    public final void mo7710b(Object obj, Object obj2) {
        C4168j c4168j = (C4168j) obj;
        boolean z7 = obj2 == null;
        AbstractC3866u0 abstractC3866u0 = this.f12977b;
        InterfaceC3846k0 interfaceC3846k0 = z7 ? abstractC3866u0 : this.f12978c;
        if (interfaceC3846k0 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C4168j.f14100a;
            while (!atomicReferenceFieldUpdater.compareAndSet(c4168j, this, interfaceC3846k0)) {
                if (atomicReferenceFieldUpdater.get(c4168j) != this) {
                    return;
                }
            }
            if (z7) {
                C3876z0 c3876z0 = this.f12978c;
                AbstractC2796i.m5782c(c3876z0);
                abstractC3866u0.m8216e(c3876z0);
            }
        }
    }

    @Override
    public final C3926b mo7711c(Object obj) {
        if (this.f12979d.m7728u() == this.f12980e) {
            return null;
        }
        return AbstractC4159a.f14081e;
    }
}

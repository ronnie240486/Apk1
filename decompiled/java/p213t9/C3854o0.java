package p213t9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p091i9.InterfaceC2724l;
import p243w8.C4070l;

public final class C3854o0 extends AbstractC3862s0 {

    public static final AtomicIntegerFieldUpdater f12947f = AtomicIntegerFieldUpdater.newUpdater(C3854o0.class, "_invoked");
    private volatile int _invoked;

    public final InterfaceC2724l f12948e;

    public C3854o0(InterfaceC2724l interfaceC2724l) {
        this.f12948e = interfaceC2724l;
    }

    @Override
    public final Object invoke(Object obj) {
        mo7671j((Throwable) obj);
        return C4070l.f13734a;
    }

    @Override
    public final void mo7671j(Throwable th) {
        if (f12947f.compareAndSet(this, 0, 1)) {
            this.f12948e.invoke(th);
        }
    }
}

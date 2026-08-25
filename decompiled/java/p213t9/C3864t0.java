package p213t9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class C3864t0 extends C3874y0 {

    public final boolean f12954c;

    public C3864t0(InterfaceC3858q0 interfaceC3858q0) {
        super(true);
        boolean z7 = true;
        m7729x(interfaceC3858q0);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C3874y0.f12982b;
        InterfaceC3836h interfaceC3836h = (InterfaceC3836h) atomicReferenceFieldUpdater.get(this);
        C3839i c3839i = interfaceC3836h instanceof C3839i ? (C3839i) interfaceC3836h : null;
        if (c3839i == null) {
            z7 = false;
            break;
        }
        C3874y0 c3874y0M7702i = c3839i.m7702i();
        while (!c3874y0M7702i.mo7684r()) {
            InterfaceC3836h interfaceC3836h2 = (InterfaceC3836h) atomicReferenceFieldUpdater.get(c3874y0M7702i);
            C3839i c3839i2 = interfaceC3836h2 instanceof C3839i ? (C3839i) interfaceC3836h2 : null;
            if (c3839i2 == null) {
                z7 = false;
                break;
            }
            c3874y0M7702i = c3839i2.m7702i();
        }
        this.f12954c = z7;
    }

    @Override
    public final boolean mo7684r() {
        return this.f12954c;
    }

    @Override
    public final boolean mo7685s() {
        return true;
    }
}

package p169p8;

import java.util.concurrent.TimeUnit;
import p004a3.RunnableC0038c;
import p090i8.InterfaceC2709c;
import p135m8.EnumC3085a;
import p156o9.AbstractC3280d;
import p180q8.C3533h;

public final class C3382g extends AbstractC3376a {

    public final C3533h f11421k;

    public C3382g(AbstractC3280d abstractC3280d, C3533h c3533h) {
        super(abstractC3280d);
        this.f11421k = c3533h;
    }

    @Override
    public final void mo6609G(InterfaceC2709c interfaceC2709c) {
        C3381f c3381f = new C3381f(interfaceC2709c);
        interfaceC2709c.mo5703c(c3381f);
        RunnableC0038c runnableC0038c = new RunnableC0038c(this, 26, c3381f);
        C3533h c3533h = this.f11421k;
        c3533h.getClass();
        EnumC3085a.m6114c(c3381f, c3533h.mo5678b(runnableC0038c, TimeUnit.NANOSECONDS));
    }
}

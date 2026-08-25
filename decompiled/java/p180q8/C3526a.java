package p180q8;

import java.util.concurrent.TimeUnit;
import p090i8.AbstractC2711e;
import p102j8.C2786a;
import p102j8.InterfaceC2787b;
import p135m8.EnumC3086b;
import p169p8.RunnableC3379d;

public final class C3526a extends AbstractC2711e {

    public final C2786a f11887a;

    public final C2786a f11888b;

    public final C2786a f11889c;

    public final C3528c f11890d;

    public volatile boolean f11891e;

    public C3526a(C3528c c3528c) {
        this.f11890d = c3528c;
        C2786a c2786a = new C2786a(1);
        this.f11887a = c2786a;
        C2786a c2786a2 = new C2786a(0);
        this.f11888b = c2786a2;
        C2786a c2786a3 = new C2786a(1);
        this.f11889c = c2786a3;
        c2786a3.m5773b(c2786a);
        c2786a3.m5773b(c2786a2);
    }

    @Override
    public final void mo5675a() {
        if (this.f11891e) {
            return;
        }
        this.f11891e = true;
        this.f11889c.mo5675a();
    }

    @Override
    public final InterfaceC2787b mo5676b(Runnable runnable, TimeUnit timeUnit) {
        return this.f11891e ? EnumC3086b.f10549a : this.f11890d.m7169d(runnable, timeUnit, this.f11888b);
    }

    @Override
    public final void mo5706c(RunnableC3379d runnableC3379d) {
        if (this.f11891e) {
            return;
        }
        this.f11890d.m7169d(runnableC3379d, TimeUnit.MILLISECONDS, this.f11887a);
    }
}

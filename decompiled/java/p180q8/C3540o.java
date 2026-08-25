package p180q8;

import com.bumptech.glide.AbstractC1466d;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p090i8.AbstractC2711e;
import p102j8.C2786a;
import p102j8.InterfaceC2787b;
import p135m8.EnumC3086b;

public final class C3540o extends AbstractC2711e {

    public final ScheduledExecutorService f11937a;

    public final C2786a f11938b = new C2786a(0);

    public volatile boolean f11939c;

    public C3540o(ScheduledExecutorService scheduledExecutorService) {
        this.f11937a = scheduledExecutorService;
    }

    @Override
    public final void mo5675a() {
        if (this.f11939c) {
            return;
        }
        this.f11939c = true;
        this.f11938b.mo5675a();
    }

    @Override
    public final InterfaceC2787b mo5676b(Runnable runnable, TimeUnit timeUnit) {
        boolean z7 = this.f11939c;
        EnumC3086b enumC3086b = EnumC3086b.f10549a;
        if (z7) {
            return enumC3086b;
        }
        RunnableC3538m runnableC3538m = new RunnableC3538m(runnable, this.f11938b);
        this.f11938b.m5773b(runnableC3538m);
        try {
            runnableC3538m.m7170b(this.f11937a.submit((Callable) runnableC3538m));
            return runnableC3538m;
        } catch (RejectedExecutionException e5) {
            mo5675a();
            AbstractC1466d.m3505y(e5);
            return enumC3086b;
        }
    }
}

package p180q8;

import com.bumptech.glide.AbstractC1466d;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p090i8.AbstractC2711e;
import p102j8.C2786a;
import p102j8.InterfaceC2787b;
import p135m8.EnumC3086b;
import p169p8.RunnableC3379d;

public class C3535j extends AbstractC2711e {

    public final ScheduledThreadPoolExecutor f11921a;

    public volatile boolean f11922b;

    public C3535j(ThreadFactoryC3536k threadFactoryC3536k) {
        boolean z7 = AbstractC3539n.f11936a;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, threadFactoryC3536k);
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(AbstractC3539n.f11936a);
        this.f11921a = scheduledThreadPoolExecutor;
    }

    @Override
    public final void mo5675a() {
        if (this.f11922b) {
            return;
        }
        this.f11922b = true;
        this.f11921a.shutdownNow();
    }

    @Override
    public final InterfaceC2787b mo5676b(Runnable runnable, TimeUnit timeUnit) {
        return this.f11922b ? EnumC3086b.f10549a : m7169d(runnable, timeUnit, null);
    }

    @Override
    public final void mo5706c(RunnableC3379d runnableC3379d) {
        mo5676b(runnableC3379d, null);
    }

    public final RunnableC3538m m7169d(Runnable runnable, TimeUnit timeUnit, C2786a c2786a) {
        RunnableC3538m runnableC3538m = new RunnableC3538m(runnable, c2786a);
        if (c2786a != null && !c2786a.m5773b(runnableC3538m)) {
            return runnableC3538m;
        }
        try {
            runnableC3538m.m7170b(this.f11921a.submit((Callable) runnableC3538m));
        } catch (RejectedExecutionException e5) {
            if (c2786a != null) {
                c2786a.m5775h(runnableC3538m);
            }
            AbstractC1466d.m3505y(e5);
        }
        return runnableC3538m;
    }
}

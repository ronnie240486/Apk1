package p180q8;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p090i8.AbstractC2711e;
import p090i8.AbstractC2712f;

public final class C3533h extends AbstractC2712f {

    public static final ThreadFactoryC3536k f11911b;

    public static final ThreadFactoryC3536k f11912c;

    public static final C3532g f11915f;

    public static final boolean f11916g;

    public static final RunnableC3530e f11917h;

    public final AtomicReference f11918a;

    public static final TimeUnit f11914e = TimeUnit.SECONDS;

    public static final long f11913d = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    static {
        C3532g c3532g = new C3532g(new ThreadFactoryC3536k("RxCachedThreadSchedulerShutdown"));
        f11915f = c3532g;
        c3532g.mo5675a();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        ThreadFactoryC3536k threadFactoryC3536k = new ThreadFactoryC3536k("RxCachedThreadScheduler", false, iMax);
        f11911b = threadFactoryC3536k;
        f11912c = new ThreadFactoryC3536k("RxCachedWorkerPoolEvictor", false, iMax);
        f11916g = Boolean.getBoolean("rx3.io-scheduled-release");
        RunnableC3530e runnableC3530e = new RunnableC3530e(0L, null, threadFactoryC3536k);
        f11917h = runnableC3530e;
        runnableC3530e.f11902c.mo5675a();
        ScheduledFuture scheduledFuture = runnableC3530e.f11904e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = runnableC3530e.f11903d;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public C3533h() {
        AtomicReference atomicReference;
        ThreadFactoryC3536k threadFactoryC3536k = f11911b;
        RunnableC3530e runnableC3530e = f11917h;
        this.f11918a = new AtomicReference(runnableC3530e);
        RunnableC3530e runnableC3530e2 = new RunnableC3530e(f11913d, f11914e, threadFactoryC3536k);
        do {
            atomicReference = this.f11918a;
            if (atomicReference.compareAndSet(runnableC3530e, runnableC3530e2)) {
                return;
            }
        } while (atomicReference.get() == runnableC3530e);
        runnableC3530e2.f11902c.mo5675a();
        ScheduledFuture scheduledFuture = runnableC3530e2.f11904e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = runnableC3530e2.f11903d;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    @Override
    public final AbstractC2711e mo5677a() {
        return new RunnableC3531f((RunnableC3530e) this.f11918a.get());
    }
}

package p180q8;

import com.bumptech.glide.AbstractC1466d;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p004a3.RunnableC0038c;
import p090i8.AbstractC2711e;
import p090i8.AbstractC2712f;
import p102j8.InterfaceC2787b;
import p135m8.EnumC3086b;

public final class C3541p extends AbstractC2712f {

    public static final ThreadFactoryC3536k f11940b;

    public static final ScheduledExecutorService f11941c;

    public final AtomicReference f11942a;

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f11941c = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f11940b = new ThreadFactoryC3536k("RxSingleScheduler", true, Math.max(1, Math.min(10, Integer.getInteger("rx3.single-priority", 5).intValue())));
    }

    public C3541p() {
        AtomicReference atomicReference = new AtomicReference();
        this.f11942a = atomicReference;
        boolean z7 = AbstractC3539n.f11936a;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, f11940b);
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(AbstractC3539n.f11936a);
        atomicReference.lazySet(scheduledThreadPoolExecutor);
    }

    @Override
    public final AbstractC2711e mo5677a() {
        return new C3540o((ScheduledExecutorService) this.f11942a.get());
    }

    @Override
    public final InterfaceC2787b mo5678b(RunnableC0038c runnableC0038c, TimeUnit timeUnit) {
        Future future;
        CallableC3537l callableC3537l = new CallableC3537l(runnableC0038c);
        try {
            Future futureSubmit = ((ScheduledExecutorService) this.f11942a.get()).submit(callableC3537l);
            do {
                future = (Future) callableC3537l.get();
                if (future == CallableC3537l.f11926d) {
                    break;
                }
                if (future == CallableC3537l.f11927e) {
                    if (callableC3537l.f11930c != Thread.currentThread()) {
                        futureSubmit.cancel(callableC3537l.f11929b);
                        break;
                    }
                    futureSubmit.cancel(false);
                    break;
                }
            } while (!callableC3537l.compareAndSet(future, futureSubmit));
            return callableC3537l;
        } catch (RejectedExecutionException e5) {
            AbstractC1466d.m3505y(e5);
            return EnumC3086b.f10549a;
        }
    }
}

package p180q8;

import com.bumptech.glide.AbstractC1466d;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p004a3.RunnableC0038c;
import p090i8.AbstractC2711e;
import p090i8.AbstractC2712f;
import p102j8.InterfaceC2787b;
import p135m8.EnumC3086b;

public final class C3529d extends AbstractC2712f {

    public static final C3527b f11895b;

    public static final ThreadFactoryC3536k f11896c;

    public static final int f11897d;

    public static final C3528c f11898e;

    public final AtomicReference f11899a;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        int iIntValue = Integer.getInteger("rx3.computation-threads", 0).intValue();
        if (iIntValue > 0 && iIntValue <= iAvailableProcessors) {
            iAvailableProcessors = iIntValue;
        }
        f11897d = iAvailableProcessors;
        C3528c c3528c = new C3528c(new ThreadFactoryC3536k("RxComputationShutdown"));
        f11898e = c3528c;
        c3528c.mo5675a();
        ThreadFactoryC3536k threadFactoryC3536k = new ThreadFactoryC3536k("RxComputationThreadPool", true, Math.max(1, Math.min(10, Integer.getInteger("rx3.computation-priority", 5).intValue())));
        f11896c = threadFactoryC3536k;
        C3527b c3527b = new C3527b(0, threadFactoryC3536k);
        f11895b = c3527b;
        for (C3528c c3528c2 : c3527b.f11893b) {
            c3528c2.mo5675a();
        }
    }

    public C3529d() {
        AtomicReference atomicReference;
        ThreadFactoryC3536k threadFactoryC3536k = f11896c;
        C3527b c3527b = f11895b;
        this.f11899a = new AtomicReference(c3527b);
        C3527b c3527b2 = new C3527b(f11897d, threadFactoryC3536k);
        do {
            atomicReference = this.f11899a;
            if (atomicReference.compareAndSet(c3527b, c3527b2)) {
                return;
            }
        } while (atomicReference.get() == c3527b);
        for (C3528c c3528c : c3527b2.f11893b) {
            c3528c.mo5675a();
        }
    }

    @Override
    public final AbstractC2711e mo5677a() {
        C3528c c3528c;
        C3527b c3527b = (C3527b) this.f11899a.get();
        int i6 = c3527b.f11892a;
        if (i6 == 0) {
            c3528c = f11898e;
        } else {
            long j10 = c3527b.f11894c;
            c3527b.f11894c = 1 + j10;
            c3528c = c3527b.f11893b[(int) (j10 % ((long) i6))];
        }
        return new C3526a(c3528c);
    }

    @Override
    public final InterfaceC2787b mo5678b(RunnableC0038c runnableC0038c, TimeUnit timeUnit) {
        C3528c c3528c;
        Future future;
        C3527b c3527b = (C3527b) this.f11899a.get();
        int i6 = c3527b.f11892a;
        if (i6 == 0) {
            c3528c = f11898e;
        } else {
            long j10 = c3527b.f11894c;
            c3527b.f11894c = 1 + j10;
            c3528c = c3527b.f11893b[(int) (j10 % ((long) i6))];
        }
        c3528c.getClass();
        CallableC3537l callableC3537l = new CallableC3537l(runnableC0038c);
        try {
            Future futureSubmit = c3528c.f11921a.submit(callableC3537l);
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

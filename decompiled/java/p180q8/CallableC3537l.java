package p180q8;

import com.bumptech.glide.AbstractC1466d;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import p004a3.RunnableC0038c;
import p014b1.RunnableC1238l;
import p102j8.InterfaceC2787b;
import p145n8.AbstractC3220a;

public final class CallableC3537l extends AtomicReference implements Callable, InterfaceC2787b {

    public static final FutureTask f11926d;

    public static final FutureTask f11927e;

    public final RunnableC0038c f11928a;

    public final boolean f11929b = true;

    public Thread f11930c;

    static {
        RunnableC1238l runnableC1238l = AbstractC3220a.f10820a;
        f11926d = new FutureTask(runnableC1238l, null);
        f11927e = new FutureTask(runnableC1238l, null);
    }

    public CallableC3537l(RunnableC0038c runnableC0038c) {
        this.f11928a = runnableC0038c;
    }

    @Override
    public final void mo5675a() {
        FutureTask futureTask;
        Future future = (Future) get();
        if (future == f11926d || future == (futureTask = f11927e) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        if (this.f11930c == Thread.currentThread()) {
            future.cancel(false);
        } else {
            future.cancel(this.f11929b);
        }
    }

    @Override
    public final Object call() {
        FutureTask futureTask = f11926d;
        this.f11930c = Thread.currentThread();
        try {
            try {
                this.f11928a.run();
                return null;
            } finally {
                lazySet(futureTask);
                this.f11930c = null;
            }
        } catch (Throwable th) {
            AbstractC1466d.m3505y(th);
            throw th;
        }
    }

    @Override
    public final String toString() {
        String str;
        Future future = (Future) get();
        if (future == f11926d) {
            str = "Finished";
        } else if (future == f11927e) {
            str = "Disposed";
        } else if (this.f11930c != null) {
            str = "Running on " + this.f11930c;
        } else {
            str = "Waiting";
        }
        return CallableC3537l.class.getSimpleName() + "[" + str + "]";
    }
}

package p254x9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p008a9.InterfaceC0079i;
import p213t9.AbstractC3855p;
import p213t9.AbstractC3869w;
import p213t9.InterfaceC3873y;
import ua.RunnableC3940a;

public final class C4166h extends AbstractC3855p implements InterfaceC3873y {

    public static final AtomicIntegerFieldUpdater f14094g = AtomicIntegerFieldUpdater.newUpdater(C4166h.class, "runningWorkers");

    public final AbstractC3855p f14095c;

    public final int f14096d;

    public final C4169k f14097e;

    public final Object f14098f;
    private volatile int runningWorkers;

    public C4166h(AbstractC3855p abstractC3855p, int i6) {
        this.f14095c = abstractC3855p;
        this.f14096d = i6;
        if ((abstractC3855p instanceof InterfaceC3873y ? (InterfaceC3873y) abstractC3855p : null) == null) {
            int i10 = AbstractC3869w.f12971a;
        }
        this.f14097e = new C4169k();
        this.f14098f = new Object();
    }

    @Override
    public final void mo7665d(InterfaceC0079i interfaceC0079i, Runnable runnable) {
        this.f14097e.m8219a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14094g;
        if (atomicIntegerFieldUpdater.get(this) < this.f14096d) {
            synchronized (this.f14098f) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f14096d) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable runnableM8213h = m8213h();
                if (runnableM8213h == null) {
                    return;
                }
                this.f14095c.mo7665d(this, new RunnableC3940a(7, this, runnableM8213h, false));
            }
        }
    }

    public final Runnable m8213h() {
        while (true) {
            Runnable runnable = (Runnable) this.f14097e.m8222d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f14098f) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14094g;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f14097e.m8221c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }
}

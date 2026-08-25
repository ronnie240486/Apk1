package p275z9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class C4370l {

    public static final AtomicReferenceFieldUpdater f14839b = AtomicReferenceFieldUpdater.newUpdater(C4370l.class, Object.class, "lastScheduledTask");

    public static final AtomicIntegerFieldUpdater f14840c = AtomicIntegerFieldUpdater.newUpdater(C4370l.class, "producerIndex");

    public static final AtomicIntegerFieldUpdater f14841d = AtomicIntegerFieldUpdater.newUpdater(C4370l.class, "consumerIndex");

    public static final AtomicIntegerFieldUpdater f14842e = AtomicIntegerFieldUpdater.newUpdater(C4370l.class, "blockingTasksInBuffer");

    public final AtomicReferenceArray f14843a = new AtomicReferenceArray(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    public final AbstractRunnableC4366h m8416a(AbstractRunnableC4366h abstractRunnableC4366h) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14840c;
        if (atomicIntegerFieldUpdater.get(this) - f14841d.get(this) == 127) {
            return abstractRunnableC4366h;
        }
        if (abstractRunnableC4366h.f14828b.f2374a == 1) {
            f14842e.incrementAndGet(this);
        }
        int i6 = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f14843a;
            if (atomicReferenceArray.get(i6) == null) {
                atomicReferenceArray.lazySet(i6, abstractRunnableC4366h);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final AbstractRunnableC4366h m8417b() {
        AbstractRunnableC4366h abstractRunnableC4366h;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14841d;
            int i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 - f14840c.get(this) == 0) {
                return null;
            }
            int i10 = i6 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i6, i6 + 1) && (abstractRunnableC4366h = (AbstractRunnableC4366h) this.f14843a.getAndSet(i10, null)) != null) {
                if (abstractRunnableC4366h.f14828b.f2374a == 1) {
                    f14842e.decrementAndGet(this);
                }
                return abstractRunnableC4366h;
            }
        }
    }

    public final AbstractRunnableC4366h m8418c(int i6, boolean z7) {
        int i10 = i6 & 127;
        AtomicReferenceArray atomicReferenceArray = this.f14843a;
        AbstractRunnableC4366h abstractRunnableC4366h = (AbstractRunnableC4366h) atomicReferenceArray.get(i10);
        if (abstractRunnableC4366h != null) {
            if ((abstractRunnableC4366h.f14828b.f2374a == 1) == z7) {
                while (!atomicReferenceArray.compareAndSet(i10, abstractRunnableC4366h, null)) {
                    if (atomicReferenceArray.get(i10) != abstractRunnableC4366h) {
                    }
                }
                if (z7) {
                    f14842e.decrementAndGet(this);
                }
                return abstractRunnableC4366h;
            }
        }
        return null;
    }
}

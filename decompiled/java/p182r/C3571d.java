package p182r;

import com.bumptech.glide.AbstractC1466d;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class C3571d extends AbstractC1466d {

    public final AtomicReferenceFieldUpdater f12031a;

    public final AtomicReferenceFieldUpdater f12032b;

    public final AtomicReferenceFieldUpdater f12033c;

    public final AtomicReferenceFieldUpdater f12034d;

    public final AtomicReferenceFieldUpdater f12035e;

    public C3571d(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f12031a = atomicReferenceFieldUpdater;
        this.f12032b = atomicReferenceFieldUpdater2;
        this.f12033c = atomicReferenceFieldUpdater3;
        this.f12034d = atomicReferenceFieldUpdater4;
        this.f12035e = atomicReferenceFieldUpdater5;
    }

    @Override
    public final void mo3507B(C3573f c3573f, C3573f c3573f2) {
        this.f12032b.lazySet(c3573f, c3573f2);
    }

    @Override
    public final void mo3508C(C3573f c3573f, Thread thread) {
        this.f12031a.lazySet(c3573f, thread);
    }

    @Override
    public final boolean mo3512b(AbstractC3574g abstractC3574g, C3570c c3570c, C3570c c3570c2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f12034d;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractC3574g, c3570c, c3570c2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractC3574g) == c3570c);
        return false;
    }

    @Override
    public final boolean mo3513c(AbstractC3574g abstractC3574g, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f12035e;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractC3574g, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractC3574g) == obj);
        return false;
    }

    @Override
    public final boolean mo3514d(AbstractC3574g abstractC3574g, C3573f c3573f, C3573f c3573f2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f12033c;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractC3574g, c3573f, c3573f2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractC3574g) == c3573f);
        return false;
    }
}

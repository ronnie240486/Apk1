package p009aa;

import java.util.concurrent.atomic.AtomicReferenceArray;
import p254x9.AbstractC4177s;

public final class C0087g extends AbstractC4177s {

    public final AtomicReferenceArray f224e;

    public C0087g(long j10, C0087g c0087g, int i6) {
        super(j10, c0087g, i6);
        this.f224e = new AtomicReferenceArray(AbstractC0086f.f223f);
    }

    @Override
    public final int mo256d() {
        return AbstractC0086f.f223f;
    }

    @Override
    public final void mo257e(int i6) {
        this.f224e.set(i6, AbstractC0086f.f222e);
        if (AbstractC4177s.f14115d.incrementAndGet(this) == AbstractC0086f.f223f) {
            m8212b();
        }
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f14116c + ", hashCode=" + hashCode() + ']';
    }
}

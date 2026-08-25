package p041d7;

import java.lang.ref.ReferenceQueue;

public final class C2283r3 extends AbstractC2213h3 {

    public final ReferenceQueue f8042h;

    public C2283r3(ConcurrentMapC2179c4 concurrentMapC2179c4, int i6) {
        super(concurrentMapC2179c4, i6);
        this.f8042h = new ReferenceQueue();
    }

    @Override
    public final void mo5196e() {
        while (this.f8042h.poll() != null) {
        }
    }

    @Override
    public final void mo5197f() {
        m5193b(this.f8042h);
    }

    @Override
    public final AbstractC2213h3 mo5202k() {
        return this;
    }
}

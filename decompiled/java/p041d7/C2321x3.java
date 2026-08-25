package p041d7;

import java.lang.ref.ReferenceQueue;

public final class C2321x3 extends AbstractC2213h3 {

    public final ReferenceQueue f8095h;

    public final ReferenceQueue f8096i;

    public C2321x3(ConcurrentMapC2179c4 concurrentMapC2179c4, int i6) {
        super(concurrentMapC2179c4, i6);
        this.f8095h = new ReferenceQueue();
        this.f8096i = new ReferenceQueue();
    }

    @Override
    public final void mo5196e() {
        while (this.f8095h.poll() != null) {
        }
    }

    @Override
    public final void mo5197f() {
        m5192a(this.f8095h);
        m5193b(this.f8096i);
    }

    @Override
    public final AbstractC2213h3 mo5202k() {
        return this;
    }
}

package p213t9;

import p253x8.C4145h;

public abstract class AbstractC3834g0 extends AbstractC3855p {

    public long f12916c;

    public boolean f12917d;

    public C4145h f12918e;

    public final void m7672h() {
        long j10 = this.f12916c - 4294967296L;
        this.f12916c = j10;
        if (j10 <= 0 && this.f12917d) {
            shutdown();
        }
    }

    public abstract Thread mo7646i();

    public final void m7673j(boolean z7) {
        this.f12916c = (z7 ? 4294967296L : 1L) + this.f12916c;
        if (z7) {
            return;
        }
        this.f12917d = true;
    }

    public final boolean m7674k() {
        C4145h c4145h = this.f12918e;
        if (c4145h == null) {
            return false;
        }
        AbstractC3816a0 abstractC3816a0 = (AbstractC3816a0) (c4145h.isEmpty() ? null : c4145h.removeFirst());
        if (abstractC3816a0 == null) {
            return false;
        }
        abstractC3816a0.run();
        return true;
    }

    public abstract void shutdown();
}

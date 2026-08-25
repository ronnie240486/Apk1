package p173q1;

import p046e0.AbstractC2343b;

public final class RunnableC3396c implements Runnable {

    public final int f11436a;

    public final Object f11437b;

    public final int f11438c;

    public RunnableC3396c(int i6, int i10, Object obj) {
        this.f11436a = i10;
        this.f11437b = obj;
        this.f11438c = i6;
    }

    @Override
    public final void run() {
        switch (this.f11436a) {
            case 0:
                C3445s0 c3445s0 = ((C3399d) this.f11437b).f11442g.f11449c.f11491d;
                if (c3445s0 != null) {
                    c3445s0.m7027j(this.f11438c);
                }
                break;
            case 1:
                C3445s0 c3445s1 = ((C3399d) this.f11437b).f11442g.f11449c.f11491d;
                if (c3445s1 != null) {
                    c3445s1.m7028k(this.f11438c);
                }
                break;
            default:
                ((AbstractC2343b) this.f11437b).mo757i(this.f11438c);
                break;
        }
    }
}

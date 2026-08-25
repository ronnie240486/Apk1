package p213t9;

import com.bumptech.glide.AbstractC1466d;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p254x9.AbstractC4159a;
import p254x9.C4176r;

public final class C3875z extends C4176r {

    public static final AtomicIntegerFieldUpdater f12983e = AtomicIntegerFieldUpdater.newUpdater(C3875z.class, "_decision");
    private volatile int _decision;

    @Override
    public final void mo7720h(Object obj) {
        mo7679i(obj);
    }

    @Override
    public final void mo7679i(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = f12983e;
            int i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 != 0) {
                if (i6 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                AbstractC4159a.m8205f(AbstractC1466d.m3499r(this.f14114d), AbstractC3865u.m7697l(obj), null);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}

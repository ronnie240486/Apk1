package p213t9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class C3845k {

    public static final AtomicIntegerFieldUpdater f12933b = AtomicIntegerFieldUpdater.newUpdater(C3845k.class, "_handled");
    private volatile int _handled;

    public final Throwable f12934a;

    public C3845k(Throwable th, boolean z7) {
        this.f12934a = th;
        this._handled = z7 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f12934a + ']';
    }
}

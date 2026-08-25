package p213t9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class C3830f extends C3845k {

    public static final AtomicIntegerFieldUpdater f12910c = AtomicIntegerFieldUpdater.newUpdater(C3830f.class, "_resumed");
    private volatile int _resumed;

    public C3830f(C3827e c3827e, Throwable th, boolean z7) {
        super(th, z7);
        this._resumed = 0;
    }
}

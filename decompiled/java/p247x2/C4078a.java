package p247x2;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import p186r3.AbstractC3602f;

public final class C4078a extends WeakReference {

    public final C4095q f13751a;

    public final boolean f13752b;

    public InterfaceC4102x f13753c;

    public C4078a(C4095q c4095q, C4096r c4096r, ReferenceQueue referenceQueue) {
        super(c4096r, referenceQueue);
        AbstractC3602f.m7225c(c4095q, "Argument must not be null");
        this.f13751a = c4095q;
        boolean z7 = c4096r.f13879a;
        this.f13753c = null;
        this.f13752b = z7;
    }
}

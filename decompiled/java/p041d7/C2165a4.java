package p041d7;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class C2165a4 extends WeakReference implements InterfaceC2333z3 {

    public final InterfaceC2199f3 f7830a;

    public C2165a4(ReferenceQueue referenceQueue, Object obj, InterfaceC2199f3 interfaceC2199f3) {
        super(obj, referenceQueue);
        this.f7830a = interfaceC2199f3;
    }

    @Override
    public final InterfaceC2199f3 mo5101a() {
        return this.f7830a;
    }

    @Override
    public final InterfaceC2333z3 mo5102b(ReferenceQueue referenceQueue, InterfaceC2327y3 interfaceC2327y3) {
        return new C2165a4(referenceQueue, get(), interfaceC2327y3);
    }
}

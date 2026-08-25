package p041d7;

import java.lang.ref.ReferenceQueue;

public class C2315w3 extends AbstractC2178c3 implements InterfaceC2327y3 {

    public volatile InterfaceC2333z3 f8084b;

    public C2315w3(Object obj, int i6, ReferenceQueue referenceQueue) {
        super(obj, i6, referenceQueue);
        this.f8084b = ConcurrentMapC2179c4.f7852j;
    }

    @Override
    public final InterfaceC2333z3 mo5259a() {
        return this.f8084b;
    }

    @Override
    public final Object getValue() {
        return this.f8084b.get();
    }
}

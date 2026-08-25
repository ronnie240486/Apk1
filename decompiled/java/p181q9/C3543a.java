package p181q9;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public final class C3543a implements InterfaceC3545c {

    public final AtomicReference f11944a;

    public C3543a(C3549g c3549g) {
        this.f11944a = new AtomicReference(c3549g);
    }

    @Override
    public final Iterator iterator() {
        InterfaceC3545c interfaceC3545c = (InterfaceC3545c) this.f11944a.getAndSet(null);
        if (interfaceC3545c != null) {
            return interfaceC3545c.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}

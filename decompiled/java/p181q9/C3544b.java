package p181q9;

import java.util.Iterator;
import p103j9.C2788a;

public final class C3544b implements InterfaceC3545c {

    public final InterfaceC3545c f11945a;

    public final int f11946b;

    public C3544b(InterfaceC3545c interfaceC3545c, int i6) {
        this.f11945a = interfaceC3545c;
        this.f11946b = i6;
        if (i6 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i6 + '.').toString());
    }

    @Override
    public final Iterator iterator() {
        return new C2788a(this);
    }
}

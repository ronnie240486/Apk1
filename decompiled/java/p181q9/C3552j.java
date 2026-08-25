package p181q9;

import java.util.Iterator;
import p091i9.InterfaceC2724l;
import p138n0.C3168x;

public final class C3552j implements InterfaceC3545c {

    public final InterfaceC3545c f11954a;

    public final InterfaceC2724l f11955b;

    public C3552j(InterfaceC3545c interfaceC3545c, InterfaceC2724l interfaceC2724l) {
        this.f11954a = interfaceC3545c;
        this.f11955b = interfaceC2724l;
    }

    @Override
    public final Iterator iterator() {
        return new C3168x(this);
    }
}

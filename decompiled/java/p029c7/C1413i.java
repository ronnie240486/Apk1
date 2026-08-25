package p029c7;

import java.util.AbstractQueue;
import java.util.NoSuchElementException;
import p041d7.AbstractC2292s5;

public final class C1413i extends AbstractC2292s5 {

    public Object f4301a;

    public final int f4302b;

    public final AbstractQueue f4303c;

    public C1413i(AbstractQueue abstractQueue, InterfaceC1406c0 interfaceC1406c0, int i6) {
        this.f4302b = i6;
        this.f4303c = abstractQueue;
        this.f4301a = interfaceC1406c0;
    }

    @Override
    public final boolean hasNext() {
        return this.f4301a != null;
    }

    @Override
    public final Object next() {
        InterfaceC1406c0 interfaceC1406c0Mo3290i;
        Object obj = this.f4301a;
        if (obj == null) {
            throw new NoSuchElementException();
        }
        switch (this.f4302b) {
            case 0:
                interfaceC1406c0Mo3290i = ((InterfaceC1406c0) obj).mo3290i();
                if (interfaceC1406c0Mo3290i == ((C1412h) ((C1414j) this.f4303c).f4305b)) {
                    interfaceC1406c0Mo3290i = null;
                }
                break;
            default:
                interfaceC1406c0Mo3290i = ((InterfaceC1406c0) obj).mo3296o();
                if (interfaceC1406c0Mo3290i == ((C1412h) ((C1414j) this.f4303c).f4305b)) {
                    interfaceC1406c0Mo3290i = null;
                }
                break;
        }
        this.f4301a = interfaceC1406c0Mo3290i;
        return obj;
    }
}

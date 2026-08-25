package p029c7;

import java.util.AbstractQueue;
import java.util.Iterator;

public final class C1414j extends AbstractQueue {

    public final int f4304a;

    public final AbstractC1411g f4305b;

    public C1414j(int i6) {
        this.f4304a = i6;
        switch (i6) {
            case 1:
                C1412h c1412h = new C1412h(1);
                c1412h.f4299b = c1412h;
                c1412h.f4300c = c1412h;
                this.f4305b = c1412h;
                break;
            default:
                C1412h c1412h2 = new C1412h(0);
                c1412h2.f4299b = c1412h2;
                c1412h2.f4300c = c1412h2;
                this.f4305b = c1412h2;
                break;
        }
    }

    @Override
    public final void clear() {
        EnumC1420p enumC1420p = EnumC1420p.f4321a;
        AbstractC1411g abstractC1411g = this.f4305b;
        switch (this.f4304a) {
            case 0:
                C1412h c1412h = (C1412h) abstractC1411g;
                InterfaceC1406c0 interfaceC1406c0 = c1412h.f4299b;
                while (interfaceC1406c0 != c1412h) {
                    InterfaceC1406c0 interfaceC1406c0Mo3290i = interfaceC1406c0.mo3290i();
                    C1409e c1409e = ConcurrentMapC1404b0.f4272s;
                    interfaceC1406c0.mo3289h(enumC1420p);
                    interfaceC1406c0.mo3295n(enumC1420p);
                    interfaceC1406c0 = interfaceC1406c0Mo3290i;
                }
                c1412h.f4299b = c1412h;
                c1412h.f4300c = c1412h;
                break;
            default:
                C1412h c1412h2 = (C1412h) abstractC1411g;
                InterfaceC1406c0 interfaceC1406c1 = c1412h2.f4299b;
                while (interfaceC1406c1 != c1412h2) {
                    InterfaceC1406c0 interfaceC1406c0Mo3296o = interfaceC1406c1.mo3296o();
                    C1409e c1409e2 = ConcurrentMapC1404b0.f4272s;
                    interfaceC1406c1.mo3287f(enumC1420p);
                    interfaceC1406c1.mo3288g(enumC1420p);
                    interfaceC1406c1 = interfaceC1406c0Mo3296o;
                }
                c1412h2.f4299b = c1412h2;
                c1412h2.f4300c = c1412h2;
                break;
        }
    }

    @Override
    public final boolean contains(Object obj) {
        switch (this.f4304a) {
            case 0:
                return ((InterfaceC1406c0) obj).mo3290i() != EnumC1420p.f4321a;
            default:
                return ((InterfaceC1406c0) obj).mo3296o() != EnumC1420p.f4321a;
        }
    }

    @Override
    public final boolean isEmpty() {
        switch (this.f4304a) {
            case 0:
                C1412h c1412h = (C1412h) this.f4305b;
                return c1412h.f4299b == c1412h;
            default:
                C1412h c1412h2 = (C1412h) this.f4305b;
                return c1412h2.f4299b == c1412h2;
        }
    }

    @Override
    public final Iterator iterator() {
        switch (this.f4304a) {
            case 0:
                C1412h c1412h = (C1412h) this.f4305b;
                InterfaceC1406c0 interfaceC1406c0 = c1412h.f4299b;
                if (interfaceC1406c0 == c1412h) {
                    interfaceC1406c0 = null;
                }
                return new C1413i(this, interfaceC1406c0, 0);
            default:
                C1412h c1412h2 = (C1412h) this.f4305b;
                InterfaceC1406c0 interfaceC1406c1 = c1412h2.f4299b;
                if (interfaceC1406c1 == c1412h2) {
                    interfaceC1406c1 = null;
                }
                return new C1413i(this, interfaceC1406c1, 1);
        }
    }

    @Override
    public final boolean offer(Object obj) {
        AbstractC1411g abstractC1411g = this.f4305b;
        switch (this.f4304a) {
            case 0:
                InterfaceC1406c0 interfaceC1406c0 = (InterfaceC1406c0) obj;
                InterfaceC1406c0 interfaceC1406c0Mo3286e = interfaceC1406c0.mo3286e();
                InterfaceC1406c0 interfaceC1406c0Mo3290i = interfaceC1406c0.mo3290i();
                C1409e c1409e = ConcurrentMapC1404b0.f4272s;
                interfaceC1406c0Mo3286e.mo3289h(interfaceC1406c0Mo3290i);
                interfaceC1406c0Mo3290i.mo3295n(interfaceC1406c0Mo3286e);
                C1412h c1412h = (C1412h) abstractC1411g;
                InterfaceC1406c0 interfaceC1406c1 = c1412h.f4300c;
                interfaceC1406c1.mo3289h(interfaceC1406c0);
                interfaceC1406c0.mo3295n(interfaceC1406c1);
                interfaceC1406c0.mo3289h(c1412h);
                c1412h.f4300c = interfaceC1406c0;
                break;
            default:
                InterfaceC1406c0 interfaceC1406c2 = (InterfaceC1406c0) obj;
                InterfaceC1406c0 interfaceC1406c0Mo3294m = interfaceC1406c2.mo3294m();
                InterfaceC1406c0 interfaceC1406c0Mo3296o = interfaceC1406c2.mo3296o();
                C1409e c1409e2 = ConcurrentMapC1404b0.f4272s;
                interfaceC1406c0Mo3294m.mo3287f(interfaceC1406c0Mo3296o);
                interfaceC1406c0Mo3296o.mo3288g(interfaceC1406c0Mo3294m);
                C1412h c1412h2 = (C1412h) abstractC1411g;
                InterfaceC1406c0 interfaceC1406c3 = c1412h2.f4300c;
                interfaceC1406c3.mo3287f(interfaceC1406c2);
                interfaceC1406c2.mo3288g(interfaceC1406c3);
                interfaceC1406c2.mo3287f(c1412h2);
                c1412h2.f4300c = interfaceC1406c2;
                break;
        }
        return true;
    }

    @Override
    public final Object peek() {
        switch (this.f4304a) {
            case 0:
                C1412h c1412h = (C1412h) this.f4305b;
                InterfaceC1406c0 interfaceC1406c0 = c1412h.f4299b;
                if (interfaceC1406c0 == c1412h) {
                    return null;
                }
                return interfaceC1406c0;
            default:
                C1412h c1412h2 = (C1412h) this.f4305b;
                InterfaceC1406c0 interfaceC1406c1 = c1412h2.f4299b;
                if (interfaceC1406c1 == c1412h2) {
                    return null;
                }
                return interfaceC1406c1;
        }
    }

    @Override
    public final Object poll() {
        switch (this.f4304a) {
            case 0:
                C1412h c1412h = (C1412h) this.f4305b;
                InterfaceC1406c0 interfaceC1406c0 = c1412h.f4299b;
                if (interfaceC1406c0 == c1412h) {
                    return null;
                }
                remove(interfaceC1406c0);
                return interfaceC1406c0;
            default:
                C1412h c1412h2 = (C1412h) this.f4305b;
                InterfaceC1406c0 interfaceC1406c1 = c1412h2.f4299b;
                if (interfaceC1406c1 == c1412h2) {
                    return null;
                }
                remove(interfaceC1406c1);
                return interfaceC1406c1;
        }
    }

    @Override
    public final boolean remove(Object obj) {
        EnumC1420p enumC1420p = EnumC1420p.f4321a;
        switch (this.f4304a) {
            case 0:
                InterfaceC1406c0 interfaceC1406c0 = (InterfaceC1406c0) obj;
                InterfaceC1406c0 interfaceC1406c0Mo3286e = interfaceC1406c0.mo3286e();
                InterfaceC1406c0 interfaceC1406c0Mo3290i = interfaceC1406c0.mo3290i();
                C1409e c1409e = ConcurrentMapC1404b0.f4272s;
                interfaceC1406c0Mo3286e.mo3289h(interfaceC1406c0Mo3290i);
                interfaceC1406c0Mo3290i.mo3295n(interfaceC1406c0Mo3286e);
                interfaceC1406c0.mo3289h(enumC1420p);
                interfaceC1406c0.mo3295n(enumC1420p);
                return interfaceC1406c0Mo3290i != enumC1420p;
            default:
                InterfaceC1406c0 interfaceC1406c1 = (InterfaceC1406c0) obj;
                InterfaceC1406c0 interfaceC1406c0Mo3294m = interfaceC1406c1.mo3294m();
                InterfaceC1406c0 interfaceC1406c0Mo3296o = interfaceC1406c1.mo3296o();
                C1409e c1409e2 = ConcurrentMapC1404b0.f4272s;
                interfaceC1406c0Mo3294m.mo3287f(interfaceC1406c0Mo3296o);
                interfaceC1406c0Mo3296o.mo3288g(interfaceC1406c0Mo3294m);
                interfaceC1406c1.mo3287f(enumC1420p);
                interfaceC1406c1.mo3288g(enumC1420p);
                return interfaceC1406c0Mo3296o != enumC1420p;
        }
    }

    @Override
    public final int size() {
        switch (this.f4304a) {
            case 0:
                C1412h c1412h = (C1412h) this.f4305b;
                int i6 = 0;
                for (InterfaceC1406c0 interfaceC1406c0Mo3290i = c1412h.f4299b; interfaceC1406c0Mo3290i != c1412h; interfaceC1406c0Mo3290i = interfaceC1406c0Mo3290i.mo3290i()) {
                    i6++;
                }
                return i6;
            default:
                C1412h c1412h2 = (C1412h) this.f4305b;
                int i10 = 0;
                for (InterfaceC1406c0 interfaceC1406c0Mo3296o = c1412h2.f4299b; interfaceC1406c0Mo3296o != c1412h2; interfaceC1406c0Mo3296o = interfaceC1406c0Mo3296o.mo3296o()) {
                    i10++;
                }
                return i10;
        }
    }
}

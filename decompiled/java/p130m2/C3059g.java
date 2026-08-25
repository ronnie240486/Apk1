package p130m2;

import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.EnumC0539o;
import androidx.lifecycle.InterfaceC0519e;
import androidx.lifecycle.InterfaceC0553v;

public final class C3059g extends AbstractC0541p {

    public static final C3059g f10441b = new C3059g();

    public static final C3058f f10442c = new C3058f();

    @Override
    public final void mo1508a(InterfaceC0553v interfaceC0553v) {
        if (!(interfaceC0553v instanceof InterfaceC0519e)) {
            throw new IllegalArgumentException((interfaceC0553v + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
        }
        InterfaceC0519e interfaceC0519e = (InterfaceC0519e) interfaceC0553v;
        C3058f c3058f = f10442c;
        interfaceC0519e.mo1492c(c3058f);
        interfaceC0519e.onStart(c3058f);
        interfaceC0519e.mo1491b(c3058f);
    }

    @Override
    public final EnumC0539o mo1509b() {
        return EnumC0539o.f2511e;
    }

    public final String toString() {
        return "coil.request.GlobalLifecycle";
    }

    @Override
    public final void mo1510c(InterfaceC0553v interfaceC0553v) {
    }
}

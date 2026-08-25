package androidx.lifecycle;

import androidx.appcompat.widget.C0280v;
import java.util.HashMap;
import java.util.List;
import p103j9.AbstractC2796i;

public final class C0523g implements InterfaceC0551u {

    public final int f2483a = 1;

    public final Object f2484b;

    public final Object f2485c;

    public C0523g(InterfaceC0519e interfaceC0519e, InterfaceC0551u interfaceC0551u) {
        AbstractC2796i.m5785f(interfaceC0519e, "defaultLifecycleObserver");
        this.f2484b = interfaceC0519e;
        this.f2485c = interfaceC0551u;
    }

    @Override
    public final void onStateChanged(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
        switch (this.f2483a) {
            case 0:
                int i6 = AbstractC0521f.f2482a[enumC0537n.ordinal()];
                InterfaceC0519e interfaceC0519e = (InterfaceC0519e) this.f2484b;
                switch (i6) {
                    case 1:
                        interfaceC0519e.mo1492c(interfaceC0555w);
                        break;
                    case 2:
                        interfaceC0519e.onStart(interfaceC0555w);
                        break;
                    case 3:
                        interfaceC0519e.mo1491b(interfaceC0555w);
                        break;
                    case 4:
                        interfaceC0519e.mo1493e(interfaceC0555w);
                        break;
                    case 5:
                        interfaceC0519e.onStop(interfaceC0555w);
                        break;
                    case 6:
                        interfaceC0519e.onDestroy(interfaceC0555w);
                        break;
                    case 7:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                }
                InterfaceC0551u interfaceC0551u = (InterfaceC0551u) this.f2485c;
                if (interfaceC0551u != null) {
                    interfaceC0551u.onStateChanged(interfaceC0555w, enumC0537n);
                    return;
                }
                return;
            case 1:
                if (enumC0537n == EnumC0537n.ON_START) {
                    ((AbstractC0541p) this.f2484b).mo1510c(this);
                    ((C0280v) this.f2485c).m791g();
                    return;
                }
                return;
            default:
                HashMap map = ((C0513b) this.f2485c).f2458a;
                List list = (List) map.get(enumC0537n);
                InterfaceC0553v interfaceC0553v = (InterfaceC0553v) this.f2484b;
                C0513b.m1475a(list, interfaceC0555w, enumC0537n, interfaceC0553v);
                C0513b.m1475a((List) map.get(EnumC0537n.ON_ANY), interfaceC0555w, enumC0537n, interfaceC0553v);
                return;
        }
    }

    public C0523g(InterfaceC0553v interfaceC0553v) {
        this.f2484b = interfaceC0553v;
        C0517d c0517d = C0517d.f2468c;
        Class<?> cls = interfaceC0553v.getClass();
        C0513b c0513b = (C0513b) c0517d.f2469a.get(cls);
        this.f2485c = c0513b == null ? c0517d.m1480a(cls, null) : c0513b;
    }

    public C0523g(C0280v c0280v, AbstractC0541p abstractC0541p) {
        this.f2484b = abstractC0541p;
        this.f2485c = c0280v;
    }
}

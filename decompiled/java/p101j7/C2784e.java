package p101j7;

import java.util.Date;
import java.util.HashMap;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2668f;
import p080h7.InterfaceC2669g;
import p089i7.InterfaceC2706a;

public final class C2784e implements InterfaceC2706a {

    public static final C2781b f9504f;

    public static final C2781b f9505g;

    public final HashMap f9507a;

    public final HashMap f9508b;

    public final C2780a f9509c;

    public boolean f9510d;

    public static final C2780a f9503e = new C2780a(0);

    public static final C2783d f9506h = new C2783d();

    static {
        final int i6 = 0;
        f9504f = new InterfaceC2668f() {
            @Override
            public final void mo192a(Object obj, Object obj2) {
                switch (i6) {
                    case 0:
                        ((InterfaceC2669g) obj2).mo5673b((String) obj);
                        break;
                    default:
                        ((InterfaceC2669g) obj2).mo5674c(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
        final int i10 = 1;
        f9505g = new InterfaceC2668f() {
            @Override
            public final void mo192a(Object obj, Object obj2) {
                switch (i10) {
                    case 0:
                        ((InterfaceC2669g) obj2).mo5673b((String) obj);
                        break;
                    default:
                        ((InterfaceC2669g) obj2).mo5674c(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
    }

    public C2784e() {
        HashMap map = new HashMap();
        this.f9507a = map;
        HashMap map2 = new HashMap();
        this.f9508b = map2;
        this.f9509c = f9503e;
        this.f9510d = false;
        map2.put(String.class, f9504f);
        map.remove(String.class);
        map2.put(Boolean.class, f9505g);
        map.remove(Boolean.class);
        map2.put(Date.class, f9506h);
        map.remove(Date.class);
    }

    public final InterfaceC2706a m5766a(Class cls, InterfaceC2666d interfaceC2666d) {
        this.f9507a.put(cls, interfaceC2666d);
        this.f9508b.remove(cls);
        return this;
    }
}

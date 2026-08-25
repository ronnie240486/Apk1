package p005a4;

import java.util.Collections;
import java.util.HashMap;
import p050e4.C2412d;
import p080h7.C2665c;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2667e;
import p113k7.C2894a;
import p113k7.InterfaceC2897d;

public final class C0044c implements InterfaceC2666d {

    public static final C0044c f126a = new C0044c();

    public static final C2665c f127b;

    public static final C2665c f128c;

    static {
        C2894a c2894a = new C2894a(1);
        HashMap map = new HashMap();
        map.put(InterfaceC2897d.class, c2894a);
        f127b = new C2665c("eventsDroppedCount", Collections.unmodifiableMap(new HashMap(map)));
        C2894a c2894a2 = new C2894a(3);
        HashMap map2 = new HashMap();
        map2.put(InterfaceC2897d.class, c2894a2);
        f128c = new C2665c("reason", Collections.unmodifiableMap(new HashMap(map2)));
    }

    @Override
    public final void mo192a(Object obj, Object obj2) {
        C2412d c2412d = (C2412d) obj;
        InterfaceC2667e interfaceC2667e = (InterfaceC2667e) obj2;
        interfaceC2667e.mo5671a(f127b, c2412d.f8414a);
        interfaceC2667e.mo5672d(f128c, c2412d.f8415b);
    }
}

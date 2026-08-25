package p005a4;

import java.util.Collections;
import java.util.HashMap;
import p050e4.C2413e;
import p080h7.C2665c;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2667e;
import p113k7.C2894a;
import p113k7.InterfaceC2897d;

public final class C0045d implements InterfaceC2666d {

    public static final C0045d f129a = new C0045d();

    public static final C2665c f130b;

    public static final C2665c f131c;

    static {
        C2894a c2894a = new C2894a(1);
        HashMap map = new HashMap();
        map.put(InterfaceC2897d.class, c2894a);
        f130b = new C2665c("logSource", Collections.unmodifiableMap(new HashMap(map)));
        C2894a c2894a2 = new C2894a(2);
        HashMap map2 = new HashMap();
        map2.put(InterfaceC2897d.class, c2894a2);
        f131c = new C2665c("logEventDropped", Collections.unmodifiableMap(new HashMap(map2)));
    }

    @Override
    public final void mo192a(Object obj, Object obj2) {
        C2413e c2413e = (C2413e) obj;
        InterfaceC2667e interfaceC2667e = (InterfaceC2667e) obj2;
        interfaceC2667e.mo5672d(f130b, c2413e.f8417a);
        interfaceC2667e.mo5672d(f131c, c2413e.f8418b);
    }
}

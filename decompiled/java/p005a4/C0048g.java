package p005a4;

import java.util.Collections;
import java.util.HashMap;
import p050e4.C2415g;
import p080h7.C2665c;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2667e;
import p113k7.C2894a;
import p113k7.InterfaceC2897d;

public final class C0048g implements InterfaceC2666d {

    public static final C0048g f136a = new C0048g();

    public static final C2665c f137b;

    public static final C2665c f138c;

    static {
        C2894a c2894a = new C2894a(1);
        HashMap map = new HashMap();
        map.put(InterfaceC2897d.class, c2894a);
        f137b = new C2665c("startMs", Collections.unmodifiableMap(new HashMap(map)));
        C2894a c2894a2 = new C2894a(2);
        HashMap map2 = new HashMap();
        map2.put(InterfaceC2897d.class, c2894a2);
        f138c = new C2665c("endMs", Collections.unmodifiableMap(new HashMap(map2)));
    }

    @Override
    public final void mo192a(Object obj, Object obj2) {
        C2415g c2415g = (C2415g) obj;
        InterfaceC2667e interfaceC2667e = (InterfaceC2667e) obj2;
        interfaceC2667e.mo5671a(f137b, c2415g.f8421a);
        interfaceC2667e.mo5671a(f138c, c2415g.f8422b);
    }
}

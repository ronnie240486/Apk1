package p005a4;

import java.util.Collections;
import java.util.HashMap;
import p050e4.C2414f;
import p080h7.C2665c;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2667e;
import p113k7.C2894a;
import p113k7.InterfaceC2897d;

public final class C0047f implements InterfaceC2666d {

    public static final C0047f f133a = new C0047f();

    public static final C2665c f134b;

    public static final C2665c f135c;

    static {
        C2894a c2894a = new C2894a(1);
        HashMap map = new HashMap();
        map.put(InterfaceC2897d.class, c2894a);
        f134b = new C2665c("currentCacheSizeBytes", Collections.unmodifiableMap(new HashMap(map)));
        C2894a c2894a2 = new C2894a(2);
        HashMap map2 = new HashMap();
        map2.put(InterfaceC2897d.class, c2894a2);
        f135c = new C2665c("maxCacheSizeBytes", Collections.unmodifiableMap(new HashMap(map2)));
    }

    @Override
    public final void mo192a(Object obj, Object obj2) {
        C2414f c2414f = (C2414f) obj;
        InterfaceC2667e interfaceC2667e = (InterfaceC2667e) obj2;
        interfaceC2667e.mo5671a(f134b, c2414f.f8419a);
        interfaceC2667e.mo5671a(f135c, c2414f.f8420b);
    }
}

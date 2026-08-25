package p005a4;

import java.util.Collections;
import java.util.HashMap;
import p050e4.C2409a;
import p080h7.C2665c;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2667e;
import p113k7.C2894a;
import p113k7.InterfaceC2897d;

public final class C0042a implements InterfaceC2666d {

    public static final C0042a f119a = new C0042a();

    public static final C2665c f120b;

    public static final C2665c f121c;

    public static final C2665c f122d;

    public static final C2665c f123e;

    static {
        C2894a c2894a = new C2894a(1);
        HashMap map = new HashMap();
        map.put(InterfaceC2897d.class, c2894a);
        f120b = new C2665c("window", Collections.unmodifiableMap(new HashMap(map)));
        C2894a c2894a2 = new C2894a(2);
        HashMap map2 = new HashMap();
        map2.put(InterfaceC2897d.class, c2894a2);
        f121c = new C2665c("logSourceMetrics", Collections.unmodifiableMap(new HashMap(map2)));
        C2894a c2894a3 = new C2894a(3);
        HashMap map3 = new HashMap();
        map3.put(InterfaceC2897d.class, c2894a3);
        f122d = new C2665c("globalMetrics", Collections.unmodifiableMap(new HashMap(map3)));
        C2894a c2894a4 = new C2894a(4);
        HashMap map4 = new HashMap();
        map4.put(InterfaceC2897d.class, c2894a4);
        f123e = new C2665c("appNamespace", Collections.unmodifiableMap(new HashMap(map4)));
    }

    @Override
    public final void mo192a(Object obj, Object obj2) {
        C2409a c2409a = (C2409a) obj;
        InterfaceC2667e interfaceC2667e = (InterfaceC2667e) obj2;
        interfaceC2667e.mo5672d(f120b, c2409a.f8400a);
        interfaceC2667e.mo5672d(f121c, c2409a.f8401b);
        interfaceC2667e.mo5672d(f122d, c2409a.f8402c);
        interfaceC2667e.mo5672d(f123e, c2409a.f8403d);
    }
}

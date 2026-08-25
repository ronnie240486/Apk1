package p270z3;

import p080h7.C2665c;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2667e;

public final class C4312f implements InterfaceC2666d {

    public static final C4312f f14636a = new C4312f();

    public static final C2665c f14637b = C2665c.m5670a("requestTimeMs");

    public static final C2665c f14638c = C2665c.m5670a("requestUptimeMs");

    public static final C2665c f14639d = C2665c.m5670a("clientInfo");

    public static final C2665c f14640e = C2665c.m5670a("logSource");

    public static final C2665c f14641f = C2665c.m5670a("logSourceName");

    public static final C2665c f14642g = C2665c.m5670a("logEvent");

    public static final C2665c f14643h = C2665c.m5670a("qosTier");

    @Override
    public final void mo192a(Object obj, Object obj2) {
        InterfaceC2667e interfaceC2667e = (InterfaceC2667e) obj2;
        C4318l c4318l = (C4318l) ((AbstractC4325s) obj);
        interfaceC2667e.mo5671a(f14637b, c4318l.f14668a);
        interfaceC2667e.mo5671a(f14638c, c4318l.f14669b);
        interfaceC2667e.mo5672d(f14639d, c4318l.f14670c);
        interfaceC2667e.mo5672d(f14640e, c4318l.f14671d);
        interfaceC2667e.mo5672d(f14641f, c4318l.f14672e);
        interfaceC2667e.mo5672d(f14642g, c4318l.f14673f);
        interfaceC2667e.mo5672d(f14643h, EnumC4329w.f14683a);
    }
}

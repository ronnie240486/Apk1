package p270z3;

import p080h7.C2665c;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2667e;

public final class C4311e implements InterfaceC2666d {

    public static final C4311e f14628a = new C4311e();

    public static final C2665c f14629b = C2665c.m5670a("eventTimeMs");

    public static final C2665c f14630c = C2665c.m5670a("eventCode");

    public static final C2665c f14631d = C2665c.m5670a("eventUptimeMs");

    public static final C2665c f14632e = C2665c.m5670a("sourceExtension");

    public static final C2665c f14633f = C2665c.m5670a("sourceExtensionJsonProto3");

    public static final C2665c f14634g = C2665c.m5670a("timezoneOffsetSeconds");

    public static final C2665c f14635h = C2665c.m5670a("networkConnectionInfo");

    @Override
    public final void mo192a(Object obj, Object obj2) {
        InterfaceC2667e interfaceC2667e = (InterfaceC2667e) obj2;
        C4317k c4317k = (C4317k) ((AbstractC4324r) obj);
        interfaceC2667e.mo5671a(f14629b, c4317k.f14661a);
        interfaceC2667e.mo5672d(f14630c, c4317k.f14662b);
        interfaceC2667e.mo5671a(f14631d, c4317k.f14663c);
        interfaceC2667e.mo5672d(f14632e, c4317k.f14664d);
        interfaceC2667e.mo5672d(f14633f, c4317k.f14665e);
        interfaceC2667e.mo5671a(f14634g, c4317k.f14666f);
        interfaceC2667e.mo5672d(f14635h, c4317k.f14667g);
    }
}

package p270z3;

import p080h7.C2665c;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2667e;

public final class C4313g implements InterfaceC2666d {

    public static final C4313g f14644a = new C4313g();

    public static final C2665c f14645b = C2665c.m5670a("networkType");

    public static final C2665c f14646c = C2665c.m5670a("mobileSubtype");

    @Override
    public final void mo192a(Object obj, Object obj2) {
        InterfaceC2667e interfaceC2667e = (InterfaceC2667e) obj2;
        C4320n c4320n = (C4320n) ((AbstractC4328v) obj);
        interfaceC2667e.mo5672d(f14645b, c4320n.f14675a);
        interfaceC2667e.mo5672d(f14646c, c4320n.f14676b);
    }
}

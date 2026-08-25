package p005a4;

import java.util.Collections;
import java.util.HashMap;
import p050e4.C2410b;
import p080h7.C2665c;
import p080h7.InterfaceC2666d;
import p080h7.InterfaceC2667e;
import p113k7.C2894a;
import p113k7.InterfaceC2897d;

public final class C0043b implements InterfaceC2666d {

    public static final C0043b f124a = new C0043b();

    public static final C2665c f125b;

    static {
        C2894a c2894a = new C2894a(1);
        HashMap map = new HashMap();
        map.put(InterfaceC2897d.class, c2894a);
        f125b = new C2665c("storageMetrics", Collections.unmodifiableMap(new HashMap(map)));
    }

    @Override
    public final void mo192a(Object obj, Object obj2) {
        ((InterfaceC2667e) obj2).mo5672d(f125b, ((C2410b) obj).f8404a);
    }
}

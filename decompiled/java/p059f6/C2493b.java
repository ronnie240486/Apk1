package p059f6;

import android.util.Property;

public final class C2493b extends Property {

    public static final C2493b f8722a = new C2493b(C2495d.class, "circularReveal");

    @Override
    public final Object get(Object obj) {
        return ((InterfaceC2496e) obj).getRevealInfo();
    }

    @Override
    public final void set(Object obj, Object obj2) {
        ((InterfaceC2496e) obj).setRevealInfo((C2495d) obj2);
    }
}

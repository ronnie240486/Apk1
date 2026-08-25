package p059f6;

import android.util.Property;

public final class C2494c extends Property {

    public static final C2494c f8723a = new C2494c(Integer.class, "circularRevealScrimColor");

    @Override
    public final Object get(Object obj) {
        return Integer.valueOf(((InterfaceC2496e) obj).getCircularRevealScrimColor());
    }

    @Override
    public final void set(Object obj, Object obj2) {
        ((InterfaceC2496e) obj).setCircularRevealScrimColor(((Integer) obj2).intValue());
    }
}

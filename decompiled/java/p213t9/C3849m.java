package p213t9;

import p008a9.InterfaceC0077g;
import p008a9.InterfaceC0079i;
import p091i9.InterfaceC2728p;
import p103j9.AbstractC2797j;

public final class C3849m extends AbstractC2797j implements InterfaceC2728p {

    public static final C3849m f12938b = new C3849m(2, 0);

    public static final C3849m f12939c = new C3849m(2, 1);

    public final int f12940a;

    public C3849m(int i6, int i10) {
        super(i6);
        this.f12940a = i10;
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f12940a) {
            case 0:
                return ((InterfaceC0079i) obj).mo253f((InterfaceC0077g) obj2);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.getClass();
                return bool;
            default:
                return ((InterfaceC0079i) obj).mo253f((InterfaceC0077g) obj2);
        }
    }
}

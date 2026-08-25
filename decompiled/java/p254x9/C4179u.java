package p254x9;

import p055ea.AbstractC2460q;
import p091i9.InterfaceC2728p;
import p103j9.AbstractC2797j;

public final class C4179u extends AbstractC2797j implements InterfaceC2728p {

    public static final C4179u f14118b = new C4179u(2, 0);

    public static final C4179u f14119c = new C4179u(2, 1);

    public static final C4179u f14120d = new C4179u(2, 2);

    public final int f14121a;

    public C4179u(int i6, int i10) {
        super(i6);
        this.f14121a = i10;
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f14121a) {
            case 0:
                return obj;
            case 1:
                AbstractC2460q.m5499m(obj);
                return null;
            default:
                return (C4181w) obj;
        }
    }
}

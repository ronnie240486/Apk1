package p125l7;

import java.io.IOException;
import p212t7.C3812a;
import p212t7.C3813b;

public final class C3001h extends AbstractC3011r {

    public final int f10291a;

    @Override
    public final Object mo6077a(C3812a c3812a) throws IOException {
        switch (this.f10291a) {
            case 0:
                if (c3812a.m7612u() != 9) {
                    return Double.valueOf(c3812a.m7603l());
                }
                c3812a.m7608q();
                return null;
            default:
                if (c3812a.m7612u() != 9) {
                    return Float.valueOf((float) c3812a.m7603l());
                }
                c3812a.m7608q();
                return null;
        }
    }

    @Override
    public final void mo6078b(C3813b c3813b, Object obj) throws IOException {
        switch (this.f10291a) {
            case 0:
                Number number = (Number) obj;
                if (number != null) {
                    C3004k.m6079a(number.doubleValue());
                    c3813b.m7630m(number);
                } else {
                    c3813b.m7626i();
                }
                break;
            default:
                Number number2 = (Number) obj;
                if (number2 != null) {
                    C3004k.m6079a(number2.floatValue());
                    c3813b.m7630m(number2);
                } else {
                    c3813b.m7626i();
                }
                break;
        }
    }
}

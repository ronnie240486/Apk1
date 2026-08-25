package p154o7;

import java.util.Calendar;
import java.util.GregorianCalendar;
import p125l7.AbstractC3011r;
import p125l7.C3004k;
import p125l7.InterfaceC3012s;
import p202s7.C3723a;

public final class C3265f implements InterfaceC3012s {

    public final int f10906a;

    public final AbstractC3011r f10907b;

    public C3265f(AbstractC3011r abstractC3011r, int i6) {
        this.f10906a = i6;
        this.f10907b = abstractC3011r;
    }

    @Override
    public final AbstractC3011r mo6089a(C3004k c3004k, C3723a c3723a) {
        switch (this.f10906a) {
            case 0:
                if (c3723a.f12480a == Number.class) {
                    return (C3266g) this.f10907b;
                }
                return null;
            default:
                Class cls = c3723a.f12480a;
                if (cls == Calendar.class || cls == GregorianCalendar.class) {
                    return (C3266g) this.f10907b;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f10906a) {
            case 1:
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((C3266g) this.f10907b) + "]";
            default:
                return super.toString();
        }
    }
}

package p160p;

import java.util.ConcurrentModificationException;
import p103j9.AbstractC2796i;
import p171q.AbstractC3387a;

public abstract class AbstractC3346j {

    public static final Object f11330a = new Object();

    public static final Object f11331b = new Object();

    public static final void m6805a(C3342f c3342f, int i6) {
        AbstractC2796i.m5785f(c3342f, "<this>");
        c3342f.f11315a = new int[i6];
        c3342f.f11316b = new Object[i6];
    }

    public static final int m6806b(C3342f c3342f, Object obj, int i6) {
        AbstractC2796i.m5785f(c3342f, "<this>");
        int i10 = c3342f.f11317c;
        if (i10 == 0) {
            return -1;
        }
        try {
            int iM6876a = AbstractC3387a.m6876a(c3342f.f11317c, i6, c3342f.f11315a);
            if (iM6876a < 0 || AbstractC2796i.m5780a(obj, c3342f.f11316b[iM6876a])) {
                return iM6876a;
            }
            int i11 = iM6876a + 1;
            while (i11 < i10 && c3342f.f11315a[i11] == i6) {
                if (AbstractC2796i.m5780a(obj, c3342f.f11316b[i11])) {
                    return i11;
                }
                i11++;
            }
            for (int i12 = iM6876a - 1; i12 >= 0 && c3342f.f11315a[i12] == i6; i12--) {
                if (AbstractC2796i.m5780a(obj, c3342f.f11316b[i12])) {
                    return i12;
                }
            }
            return ~i11;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}

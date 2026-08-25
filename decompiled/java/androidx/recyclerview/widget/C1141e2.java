package androidx.recyclerview.widget;

import p160p.AbstractC3346j;
import p160p.C3345i;
import p160p.C3347k;

public final class C1141e2 {

    public final C3347k f3557a = new C3347k(0);

    public final C3345i f3558b = new C3345i();

    public final void m2938a(AbstractC1174p1 abstractC1174p1, C1179r0 c1179r0) {
        C3347k c3347k = this.f3557a;
        C1133c2 c1133c2M2908a = (C1133c2) c3347k.get(abstractC1174p1);
        if (c1133c2M2908a == null) {
            c1133c2M2908a = C1133c2.m2908a();
            c3347k.put(abstractC1174p1, c1133c2M2908a);
        }
        c1133c2M2908a.f3532c = c1179r0;
        c1133c2M2908a.f3530a |= 8;
    }

    public final C1179r0 m2939b(AbstractC1174p1 abstractC1174p1, int i6) {
        C1133c2 c1133c2;
        C1179r0 c1179r0;
        C3347k c3347k = this.f3557a;
        int iM6810d = c3347k.m6810d(abstractC1174p1);
        if (iM6810d >= 0 && (c1133c2 = (C1133c2) c3347k.m6816j(iM6810d)) != null) {
            int i10 = c1133c2.f3530a;
            if ((i10 & i6) != 0) {
                int i11 = i10 & (~i6);
                c1133c2.f3530a = i11;
                if (i6 == 4) {
                    c1179r0 = c1133c2.f3531b;
                } else {
                    if (i6 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    c1179r0 = c1133c2.f3532c;
                }
                if ((i11 & 12) == 0) {
                    c3347k.mo6814h(iM6810d);
                    c1133c2.f3530a = 0;
                    c1133c2.f3531b = null;
                    c1133c2.f3532c = null;
                    C1133c2.f3529d.mo6101c(c1133c2);
                }
                return c1179r0;
            }
        }
        return null;
    }

    public final void m2940c(AbstractC1174p1 abstractC1174p1) {
        C1133c2 c1133c2 = (C1133c2) this.f3557a.get(abstractC1174p1);
        if (c1133c2 == null) {
            return;
        }
        c1133c2.f3530a &= -2;
    }

    public final void m2941d(AbstractC1174p1 abstractC1174p1) {
        C3345i c3345i = this.f3558b;
        for (int iM6803j = c3345i.m6803j() - 1; iM6803j >= 0; iM6803j--) {
            if (abstractC1174p1 == c3345i.m6804k(iM6803j)) {
                Object[] objArr = c3345i.f11328c;
                Object obj = objArr[iM6803j];
                Object obj2 = AbstractC3346j.f11330a;
                if (obj == obj2) {
                    break;
                }
                objArr[iM6803j] = obj2;
                c3345i.f11326a = true;
                break;
            }
        }
        C1133c2 c1133c2 = (C1133c2) this.f3557a.remove(abstractC1174p1);
        if (c1133c2 != null) {
            c1133c2.f3530a = 0;
            c1133c2.f3531b = null;
            c1133c2.f3532c = null;
            C1133c2.f3529d.mo6101c(c1133c2);
        }
    }
}

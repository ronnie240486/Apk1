package p173q1;

import java.util.ArrayList;

public final class C3390a implements InterfaceC3391a0 {

    public final C3411h f11426a;

    public C3390a(C3411h c3411h) {
        this.f11426a = c3411h;
    }

    @Override
    public void mo1737c(AbstractC3394b0 abstractC3394b0, C3454w c3454w, ArrayList arrayList) {
        C3411h c3411h = this.f11426a;
        if (abstractC3394b0 != c3411h.f11512y || c3454w == null) {
            if (abstractC3394b0 == c3411h.f11492e) {
                if (c3454w != null) {
                    c3411h.m6948o(c3411h.f11491d, c3454w);
                }
                C3436p0 c3436p0M7019a = c3411h.f11491d.m7019a();
                if (c3436p0M7019a != null) {
                    c3436p0M7019a.m7015p(arrayList);
                    return;
                }
                return;
            }
            return;
        }
        C3442r0 c3442r0 = c3411h.f11511x.f11652a;
        String strM7089f = c3454w.m7089f();
        C3436p0 c3436p0 = new C3436p0(c3442r0, strM7089f, c3411h.m6935b(c3442r0, strM7089f));
        c3436p0.m7026i(c3454w);
        if (c3411h.f11491d == c3436p0) {
            return;
        }
        AbstractC3394b0 abstractC3394b1 = c3411h.f11512y;
        C3445s0 c3445s0 = c3411h.f11511x;
        C3439q0 c3439q0 = c3411h.f11493f;
        if (c3439q0 != null) {
            if (!c3439q0.f11637i && !c3439q0.f11638j) {
                c3439q0.f11638j = true;
                AbstractC3397c0 abstractC3397c0 = c3439q0.f11629a;
                if (abstractC3397c0 != null) {
                    abstractC3397c0.mo6900i(0);
                    abstractC3397c0.mo6897e();
                }
            }
            c3411h.f11493f = null;
        }
        C3439q0 c3439q1 = new C3439q0(c3411h, c3436p0, abstractC3394b1, 3, true, c3445s0, arrayList);
        c3411h.f11493f = c3439q1;
        c3439q1.m7017a();
        c3411h.f11511x = null;
        c3411h.f11512y = null;
    }
}

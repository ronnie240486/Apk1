package p213t9;

import p243w8.C4070l;

public final class C3868v0 extends AbstractC3866u0 {

    public final C3874y0 f12967e;

    public final C3870w0 f12968f;

    public final C3839i f12969g;

    public final Object f12970h;

    public C3868v0(C3874y0 c3874y0, C3870w0 c3870w0, C3839i c3839i, Object obj) {
        this.f12967e = c3874y0;
        this.f12968f = c3870w0;
        this.f12969g = c3839i;
        this.f12970h = obj;
    }

    @Override
    public final Object invoke(Object obj) {
        mo7671j((Throwable) obj);
        return C4070l.f13734a;
    }

    @Override
    public final void mo7671j(Throwable th) {
        C3839i c3839i = this.f12969g;
        C3874y0 c3874y0 = this.f12967e;
        c3874y0.getClass();
        C3839i c3839iM7712B = C3874y0.m7712B(c3839i);
        C3870w0 c3870w0 = this.f12968f;
        Object obj = this.f12970h;
        if (c3839iM7712B != null) {
            while (AbstractC3865u.m7694i(c3839iM7712B.f12923e, false, new C3868v0(c3874y0, c3870w0, c3839iM7712B, obj), 1) == C3817a1.f12899a) {
                c3839iM7712B = C3874y0.m7712B(c3839iM7712B);
                if (c3839iM7712B == null) {
                }
            }
            return;
        }
        c3874y0.mo7720h(c3874y0.m7725p(c3870w0, obj));
    }
}

package p174q2;

import p130m2.AbstractC3062j;
import p130m2.C3057e;
import p130m2.C3069q;
import p150o2.C3246a;

public final class C3464c implements InterfaceC3466e {

    public final C3246a f11728a;

    public final AbstractC3062j f11729b;

    public C3464c(C3246a c3246a, AbstractC3062j abstractC3062j) {
        this.f11728a = c3246a;
        this.f11729b = abstractC3062j;
    }

    @Override
    public final void mo3274a() {
        AbstractC3062j abstractC3062j = this.f11729b;
        boolean z7 = abstractC3062j instanceof C3069q;
        C3246a c3246a = this.f11728a;
        if (z7) {
            c3246a.m6555g(((C3069q) abstractC3062j).f10514a);
        } else if (abstractC3062j instanceof C3057e) {
            c3246a.m6555g(((C3057e) abstractC3062j).f10438a);
        }
    }
}

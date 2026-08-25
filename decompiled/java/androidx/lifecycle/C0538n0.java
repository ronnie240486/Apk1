package androidx.lifecycle;

import androidx.appcompat.widget.C0280v;
import p103j9.AbstractC2796i;

public final class C0538n0 implements InterfaceC0551u {

    public final String f2504a;

    public final C0536m0 f2505b;

    public boolean f2506c;

    public C0538n0(String str, C0536m0 c0536m0) {
        this.f2504a = str;
        this.f2505b = c0536m0;
    }

    public final void m1502d(C0280v c0280v, AbstractC0541p abstractC0541p) {
        AbstractC2796i.m5785f(c0280v, "registry");
        AbstractC2796i.m5785f(abstractC0541p, "lifecycle");
        if (this.f2506c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f2506c = true;
        abstractC0541p.mo1508a(this);
        c0280v.m790f(this.f2504a, this.f2505b.f2503e);
    }

    @Override
    public final void onStateChanged(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
        if (enumC0537n == EnumC0537n.ON_DESTROY) {
            this.f2506c = false;
            interfaceC0555w.mo360f().mo1510c(this);
        }
    }
}

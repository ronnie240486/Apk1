package androidx.lifecycle;

import androidx.fragment.app.FragmentActivity;

public final class C0514b0 extends AbstractC0516c0 implements InterfaceC0551u {

    public final FragmentActivity f2460e;

    public final C0518d0 f2461f;

    public C0514b0(C0518d0 c0518d0, FragmentActivity fragmentActivity, InterfaceC0520e0 interfaceC0520e0) {
        super(c0518d0, interfaceC0520e0);
        this.f2461f = c0518d0;
        this.f2460e = fragmentActivity;
    }

    @Override
    public final void mo1476g() {
        this.f2460e.f228d.mo1510c(this);
    }

    @Override
    public final boolean mo1477h(FragmentActivity fragmentActivity) {
        return this.f2460e == fragmentActivity;
    }

    @Override
    public final boolean mo1474i() {
        return this.f2460e.f228d.f2553d.compareTo(EnumC0539o.f2510d) >= 0;
    }

    @Override
    public final void onStateChanged(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
        FragmentActivity fragmentActivity = this.f2460e;
        EnumC0539o enumC0539o = fragmentActivity.f228d.f2553d;
        if (enumC0539o == EnumC0539o.f2507a) {
            this.f2461f.mo1489i(this.f2464a);
            return;
        }
        EnumC0539o enumC0539o2 = null;
        while (enumC0539o2 != enumC0539o) {
            m1478d(mo1474i());
            enumC0539o2 = enumC0539o;
            enumC0539o = fragmentActivity.f228d.f2553d;
        }
    }
}

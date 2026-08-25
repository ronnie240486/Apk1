package p130m2;

import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.InterfaceC0555w;
import p103j9.AbstractC2796i;
import p213t9.AbstractC3865u;
import p213t9.InterfaceC3858q0;

public final class C3053a implements InterfaceC3068p {

    public final AbstractC0541p f10412a;

    public final InterfaceC3858q0 f10413b;

    public C3053a(AbstractC0541p abstractC0541p, InterfaceC3858q0 interfaceC3858q0) {
        this.f10412a = abstractC0541p;
        this.f10413b = interfaceC3858q0;
    }

    @Override
    public final void mo6105a() {
        this.f10412a.mo1510c(this);
    }

    @Override
    public final void mo1491b(InterfaceC0555w interfaceC0555w) {
        AbstractC2796i.m5785f(interfaceC0555w, "owner");
    }

    @Override
    public final void mo1492c(InterfaceC0555w interfaceC0555w) {
        AbstractC2796i.m5785f(interfaceC0555w, "owner");
    }

    @Override
    public final void onDestroy(InterfaceC0555w interfaceC0555w) {
        AbstractC3865u.m7688c(this.f10413b);
    }

    @Override
    public final void onStart(InterfaceC0555w interfaceC0555w) {
        AbstractC2796i.m5785f(interfaceC0555w, "owner");
    }

    @Override
    public final void start() {
        this.f10412a.mo1508a(this);
    }

    @Override
    public final void mo6106f() {
    }

    @Override
    public final void mo1493e(InterfaceC0555w interfaceC0555w) {
    }

    @Override
    public final void onStop(InterfaceC0555w interfaceC0555w) {
    }
}

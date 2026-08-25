package p185r2;

import androidx.lifecycle.InterfaceC0519e;
import androidx.lifecycle.InterfaceC0555w;
import p103j9.AbstractC2796i;
import p213t9.C3827e;
import p243w8.C4070l;

public final class C3584c implements InterfaceC0519e {

    public final C3827e f12062a;

    public C3584c(C3827e c3827e) {
        this.f12062a = c3827e;
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
    public final void onStart(InterfaceC0555w interfaceC0555w) {
        this.f12062a.resumeWith(C4070l.f13734a);
    }

    @Override
    public final void mo1493e(InterfaceC0555w interfaceC0555w) {
    }

    @Override
    public final void onDestroy(InterfaceC0555w interfaceC0555w) {
    }

    @Override
    public final void onStop(InterfaceC0555w interfaceC0555w) {
    }
}

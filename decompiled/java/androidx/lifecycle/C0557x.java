package androidx.lifecycle;

import p103j9.AbstractC2796i;

public final class C0557x {

    public EnumC0539o f2547a;

    public InterfaceC0551u f2548b;

    public final void m1517a(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
        EnumC0539o enumC0539oM1501a = enumC0537n.m1501a();
        EnumC0539o enumC0539o = this.f2547a;
        AbstractC2796i.m5785f(enumC0539o, "state1");
        if (enumC0539oM1501a.compareTo(enumC0539o) < 0) {
            enumC0539o = enumC0539oM1501a;
        }
        this.f2547a = enumC0539o;
        this.f2548b.onStateChanged(interfaceC0555w, enumC0537n);
        this.f2547a = enumC0539oM1501a;
    }
}

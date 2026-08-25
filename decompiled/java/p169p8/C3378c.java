package p169p8;

import com.bumptech.glide.AbstractC1466d;
import p090i8.InterfaceC2708b;
import p090i8.InterfaceC2709c;
import p135m8.EnumC3085a;
import p156o9.AbstractC3280d;

public final class C3378c extends AbstractC3280d {

    public final InterfaceC2708b f11406j;

    public C3378c(InterfaceC2708b interfaceC2708b) {
        this.f11406j = interfaceC2708b;
    }

    @Override
    public final void mo6609G(InterfaceC2709c interfaceC2709c) {
        C3377b c3377b = new C3377b(interfaceC2709c);
        interfaceC2709c.mo5703c(c3377b);
        try {
            this.f11406j.mo1735a(c3377b);
        } catch (Throwable th) {
            AbstractC1466d.m3484G(th);
            if (c3377b.m6872b()) {
                AbstractC1466d.m3505y(th);
                return;
            }
            try {
                c3377b.f11405a.mo5704d(th);
            } finally {
                EnumC3085a.m6113b(c3377b);
            }
        }
    }
}

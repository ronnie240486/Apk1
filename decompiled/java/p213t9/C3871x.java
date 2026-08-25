package p213t9;

import p008a9.InterfaceC0079i;

public class C3871x extends AbstractC3815a {

    public final int f12976d;

    public C3871x(InterfaceC0079i interfaceC0079i, boolean z7, int i6) {
        super(interfaceC0079i, z7);
        this.f12976d = i6;
    }

    @Override
    public boolean mo7709v(Throwable th) {
        switch (this.f12976d) {
            case 1:
                AbstractC3865u.m7693h(this.f12897c, th);
                return true;
            default:
                return super.mo7709v(th);
        }
    }
}

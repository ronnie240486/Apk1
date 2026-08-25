package p269z2;

import p186r3.C3606j;
import p247x2.C4090l;
import p247x2.InterfaceC4102x;

public final class C4304e extends C3606j {

    public C4090l f14602d;

    @Override
    public final int mo7228b(Object obj) {
        InterfaceC4102x interfaceC4102x = (InterfaceC4102x) obj;
        if (interfaceC4102x == null) {
            return 1;
        }
        return interfaceC4102x.mo5403a();
    }

    @Override
    public final void mo3169c(Object obj, Object obj2) {
        InterfaceC4102x interfaceC4102x = (InterfaceC4102x) obj2;
        C4090l c4090l = this.f14602d;
        if (c4090l == null || interfaceC4102x == null) {
            return;
        }
        c4090l.f13838e.m442e(interfaceC4102x, true);
    }

    public final void m8354f(int i6) {
        long j10;
        if (i6 >= 40) {
            m7230e(0L);
        } else if (i6 >= 20 || i6 == 15) {
            synchronized (this) {
                j10 = this.f12105b;
            }
            m7230e(j10 / 2);
        }
    }
}

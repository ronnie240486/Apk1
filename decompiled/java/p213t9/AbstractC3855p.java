package p213t9;

import com.lzy.okgo.cache.CacheEntity;
import p008a9.AbstractC0071a;
import p008a9.C0075e;
import p008a9.C0080j;
import p008a9.InterfaceC0076f;
import p008a9.InterfaceC0077g;
import p008a9.InterfaceC0078h;
import p008a9.InterfaceC0079i;
import p103j9.AbstractC2796i;

public abstract class AbstractC3855p extends AbstractC0071a implements InterfaceC0076f {

    public static final C3853o f12949b = new C3853o(C0075e.f205a, C3851n.f12943a);

    public AbstractC3855p() {
        super(C0075e.f205a);
    }

    @Override
    public final InterfaceC0079i mo251c(InterfaceC0078h interfaceC0078h) {
        AbstractC2796i.m5785f(interfaceC0078h, CacheEntity.KEY);
        boolean z7 = interfaceC0078h instanceof C3853o;
        C0080j c0080j = C0080j.f206a;
        if (z7) {
            C3853o c3853o = (C3853o) interfaceC0078h;
            InterfaceC0078h interfaceC0078h2 = this.f201a;
            if ((interfaceC0078h2 == c3853o || c3853o.f12946b == interfaceC0078h2) && c3853o.m7682a(this) != null) {
                return c0080j;
            }
        } else if (C0075e.f205a == interfaceC0078h) {
            return c0080j;
        }
        return this;
    }

    public abstract void mo7665d(InterfaceC0079i interfaceC0079i, Runnable runnable);

    @Override
    public final InterfaceC0077g mo252e(InterfaceC0078h interfaceC0078h) {
        AbstractC2796i.m5785f(interfaceC0078h, CacheEntity.KEY);
        if (!(interfaceC0078h instanceof C3853o)) {
            if (C0075e.f205a == interfaceC0078h) {
                return this;
            }
            return null;
        }
        C3853o c3853o = (C3853o) interfaceC0078h;
        InterfaceC0078h interfaceC0078h2 = this.f201a;
        if (interfaceC0078h2 != c3853o && c3853o.f12946b != interfaceC0078h2) {
            return null;
        }
        InterfaceC0077g interfaceC0077gM7682a = c3853o.m7682a(this);
        if (interfaceC0077gM7682a instanceof InterfaceC0077g) {
            return interfaceC0077gM7682a;
        }
        return null;
    }

    public boolean mo7683g() {
        return !(this instanceof AbstractC3838h1);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + AbstractC3865u.m7691f(this);
    }
}

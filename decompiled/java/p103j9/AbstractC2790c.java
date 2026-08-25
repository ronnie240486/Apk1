package p103j9;

import java.io.Serializable;
import p170p9.InterfaceC3383a;

public abstract class AbstractC2790c implements InterfaceC3383a, Serializable {

    public transient InterfaceC3383a f9524a;

    public final Object f9525b;

    public final Class f9526c;

    public final String f9527d;

    public final String f9528e;

    public final boolean f9529f;

    public AbstractC2790c(Object obj, Class cls, String str, String str2, boolean z7) {
        this.f9525b = obj;
        this.f9526c = cls;
        this.f9527d = str;
        this.f9528e = str2;
        this.f9529f = z7;
    }

    public final InterfaceC2791d m5776a() {
        Class cls = this.f9526c;
        if (!this.f9529f) {
            return AbstractC2802o.m5794a(cls);
        }
        AbstractC2802o.f9541a.getClass();
        return new C2798k(cls);
    }
}

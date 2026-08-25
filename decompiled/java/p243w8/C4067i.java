package p243w8;

import java.io.Serializable;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2796i;

public final class C4067i implements InterfaceC4061c, Serializable {

    public InterfaceC2713a f13730a;

    public volatile Object f13731b = C4069k.f13733a;

    public final Object f13732c = this;

    public C4067i(InterfaceC2713a interfaceC2713a) {
        this.f13730a = interfaceC2713a;
    }

    @Override
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.f13731b;
        C4069k c4069k = C4069k.f13733a;
        if (obj != c4069k) {
            return obj;
        }
        synchronized (this.f13732c) {
            objInvoke = this.f13731b;
            if (objInvoke == c4069k) {
                InterfaceC2713a interfaceC2713a = this.f13730a;
                AbstractC2796i.m5782c(interfaceC2713a);
                objInvoke = interfaceC2713a.invoke();
                this.f13731b = objInvoke;
                this.f13730a = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return this.f13731b != C4069k.f13733a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}

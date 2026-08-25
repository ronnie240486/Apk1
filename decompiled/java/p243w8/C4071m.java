package p243w8;

import java.io.Serializable;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2797j;

public final class C4071m implements InterfaceC4061c, Serializable {

    public AbstractC2797j f13735a;

    public Object f13736b;

    @Override
    public final Object getValue() {
        if (this.f13736b == C4069k.f13733a) {
            ?? r10 = this.f13735a;
            AbstractC2796i.m5782c(r10);
            this.f13736b = r10.invoke();
            this.f13735a = null;
        }
        return this.f13736b;
    }

    public final String toString() {
        return this.f13736b != C4069k.f13733a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}

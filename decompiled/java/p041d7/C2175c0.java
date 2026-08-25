package p041d7;

import java.io.Serializable;
import java.util.Arrays;
import p020b7.InterfaceC1346i;

public final class C2175c0 extends AbstractC2173b5 implements Serializable {

    public final InterfaceC1346i f7846a;

    public final AbstractC2173b5 f7847b;

    public C2175c0(InterfaceC1346i interfaceC1346i, AbstractC2173b5 abstractC2173b5) {
        this.f7846a = interfaceC1346i;
        abstractC2173b5.getClass();
        this.f7847b = abstractC2173b5;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        InterfaceC1346i interfaceC1346i = this.f7846a;
        return this.f7847b.compare(interfaceC1346i.apply(obj), interfaceC1346i.apply(obj2));
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2175c0)) {
            return false;
        }
        C2175c0 c2175c0 = (C2175c0) obj;
        return this.f7846a.equals(c2175c0.f7846a) && this.f7847b.equals(c2175c0.f7847b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7846a, this.f7847b});
    }

    public final String toString() {
        return this.f7847b + ".onResultOf(" + this.f7846a + ")";
    }
}

package p041d7;

import java.io.Serializable;

public final class C2236k5 extends AbstractC2173b5 implements Serializable {

    public final AbstractC2173b5 f7979a;

    public C2236k5(AbstractC2173b5 abstractC2173b5) {
        this.f7979a = abstractC2173b5;
    }

    @Override
    public final AbstractC2173b5 mo5103a() {
        return this.f7979a;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        return this.f7979a.compare(obj2, obj);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2236k5) {
            return this.f7979a.equals(((C2236k5) obj).f7979a);
        }
        return false;
    }

    public final int hashCode() {
        return -this.f7979a.hashCode();
    }

    public final String toString() {
        return this.f7979a + ".reverse()";
    }
}

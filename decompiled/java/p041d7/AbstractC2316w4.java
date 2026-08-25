package p041d7;

import p020b7.AbstractC1332b;

public abstract class AbstractC2316w4 {
    public abstract int mo5264a();

    public abstract Object mo5265b();

    public final boolean equals(Object obj) {
        if (!(obj instanceof AbstractC2316w4)) {
            return false;
        }
        AbstractC2316w4 abstractC2316w4 = (AbstractC2316w4) obj;
        return mo5264a() == abstractC2316w4.mo5264a() && AbstractC1332b.m3225p(mo5265b(), abstractC2316w4.mo5265b());
    }

    public final int hashCode() {
        Object objMo5265b = mo5265b();
        return (objMo5265b == null ? 0 : objMo5265b.hashCode()) ^ mo5264a();
    }

    public final String toString() {
        String strValueOf = String.valueOf(mo5265b());
        int iMo5264a = mo5264a();
        if (iMo5264a == 1) {
            return strValueOf;
        }
        return strValueOf + " x " + iMo5264a;
    }
}

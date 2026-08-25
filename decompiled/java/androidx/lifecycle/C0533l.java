package androidx.lifecycle;

import p103j9.AbstractC2796i;

public final class C0533l {
    public static EnumC0537n m1498a(EnumC0539o enumC0539o) {
        AbstractC2796i.m5785f(enumC0539o, "state");
        int iOrdinal = enumC0539o.ordinal();
        if (iOrdinal == 1) {
            return EnumC0537n.ON_CREATE;
        }
        if (iOrdinal == 2) {
            return EnumC0537n.ON_START;
        }
        if (iOrdinal != 3) {
            return null;
        }
        return EnumC0537n.ON_RESUME;
    }
}

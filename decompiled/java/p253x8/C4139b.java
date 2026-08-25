package p253x8;

import p000a.AbstractC0004e;

public final class C4139b {
    public static void m8157a(int i6, int i10) {
        if (i6 < 0 || i6 >= i10) {
            throw new IndexOutOfBoundsException(AbstractC0004e.m19m(i6, i10, "index: ", ", size: "));
        }
    }

    public static void m8158b(int i6, int i10) {
        if (i6 < 0 || i6 > i10) {
            throw new IndexOutOfBoundsException(AbstractC0004e.m19m(i6, i10, "index: ", ", size: "));
        }
    }

    public static void m8159c(int i6, int i10, int i11) {
        if (i6 < 0 || i10 > i11) {
            StringBuilder sbM28v = AbstractC0004e.m28v("fromIndex: ", i6, ", toIndex: ", i10, ", size: ");
            sbM28v.append(i11);
            throw new IndexOutOfBoundsException(sbM28v.toString());
        }
        if (i6 > i10) {
            throw new IllegalArgumentException(AbstractC0004e.m19m(i6, i10, "fromIndex: ", " > toIndex: "));
        }
    }
}

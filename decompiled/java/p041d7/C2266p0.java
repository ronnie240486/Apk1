package p041d7;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import p000a.AbstractC0004e;

public final class C2266p0 extends AbstractC2173b5 implements Serializable {

    public final Comparator[] f8019a;

    public C2266p0(C2175c0 c2175c0, C2175c0 c2175c1) {
        this.f8019a = new Comparator[]{c2175c0, c2175c1};
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        int i6 = 0;
        while (true) {
            Comparator[] comparatorArr = this.f8019a;
            if (i6 >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i6].compare(obj, obj2);
            if (iCompare != 0) {
                return iCompare;
            }
            i6++;
        }
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2266p0) {
            return Arrays.equals(this.f8019a, ((C2266p0) obj).f8019a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8019a);
    }

    public final String toString() {
        return AbstractC0004e.m26t(new StringBuilder("Ordering.compound("), Arrays.toString(this.f8019a), ")");
    }
}

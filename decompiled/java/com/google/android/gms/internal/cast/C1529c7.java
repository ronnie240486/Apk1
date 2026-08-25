package com.google.android.gms.internal.cast;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;
import p000a.AbstractC0004e;

public class C1529c7 implements Iterable, Serializable {

    public static final C1529c7 f5233c = new C1529c7(AbstractC1639n7.f5473b);

    public int f5234a = 0;

    public final byte[] f5235b;

    static {
        int i6 = AbstractC1746z6.f5745a;
    }

    public C1529c7(byte[] bArr) {
        bArr.getClass();
        this.f5235b = bArr;
    }

    public static void m3757f(int i6) {
        if (((i6 - 47) | 47) < 0) {
            throw new IndexOutOfBoundsException(AbstractC0004e.m20n(i6, "End index: 47 >= "));
        }
    }

    public byte mo3732c(int i6) {
        return this.f5235b[i6];
    }

    public byte mo3733d(int i6) {
        return this.f5235b[i6];
    }

    public int mo3734e() {
        return this.f5235b.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1529c7) || mo3734e() != ((C1529c7) obj).mo3734e()) {
            return false;
        }
        if (mo3734e() == 0) {
            return true;
        }
        if (!(obj instanceof C1529c7)) {
            return obj.equals(this);
        }
        C1529c7 c1529c7 = (C1529c7) obj;
        int i6 = this.f5234a;
        int i10 = c1529c7.f5234a;
        if (i6 != 0 && i10 != 0 && i6 != i10) {
            return false;
        }
        int iMo3734e = mo3734e();
        if (iMo3734e > c1529c7.mo3734e()) {
            throw new IllegalArgumentException("Length too large: " + iMo3734e + mo3734e());
        }
        if (iMo3734e > c1529c7.mo3734e()) {
            throw new IllegalArgumentException(AbstractC0004e.m19m(iMo3734e, c1529c7.mo3734e(), "Ran off end of other: 0, ", ", "));
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < iMo3734e) {
            if (this.f5235b[i11] != c1529c7.f5235b[i12]) {
                return false;
            }
            i11++;
            i12++;
        }
        return true;
    }

    public final int hashCode() {
        int i6 = this.f5234a;
        if (i6 != 0) {
            return i6;
        }
        int iMo3734e = mo3734e();
        Charset charset = AbstractC1639n7.f5472a;
        int i10 = iMo3734e;
        for (int i11 = 0; i11 < iMo3734e; i11++) {
            i10 = (i10 * 31) + this.f5235b[i11];
        }
        int i12 = i10 != 0 ? i10 : 1;
        this.f5234a = i12;
        return i12;
    }

    @Override
    public final Iterator iterator() {
        return new C1509a7(this);
    }

    public final String toString() {
        String strConcat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iMo3734e = mo3734e();
        if (mo3734e() <= 50) {
            strConcat = AbstractC1503a1.m3694e(this);
        } else {
            m3757f(mo3734e());
            strConcat = AbstractC1503a1.m3694e(new C1519b7(this.f5235b)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iMo3734e);
        sb.append(" contents=\"");
        return AbstractC0004e.m26t(sb, strConcat, "\">");
    }
}

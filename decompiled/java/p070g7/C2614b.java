package p070g7;

import java.io.Serializable;
import okhttp3.HttpUrl;
import p020b7.AbstractC1332b;
import p222u7.AbstractC3928d;

public final class C2614b implements Serializable {

    public static final C2614b f9093c = new C2614b(new long[0], 0);

    public final long[] f9094a;

    public final int f9095b;

    public C2614b(long[] jArr, int i6) {
        this.f9094a = jArr;
        this.f9095b = i6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2614b)) {
            return false;
        }
        C2614b c2614b = (C2614b) obj;
        int i6 = c2614b.f9095b;
        int i10 = this.f9095b;
        if (i10 != i6) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            AbstractC1332b.m3217h(i11, i10);
            long j10 = this.f9094a[i11];
            AbstractC1332b.m3217h(i11, c2614b.f9095b);
            if (j10 != c2614b.f9094a[i11]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iM7854r = 1;
        for (int i6 = 0; i6 < this.f9095b; i6++) {
            iM7854r = (iM7854r * 31) + AbstractC3928d.m7854r(this.f9094a[i6]);
        }
        return iM7854r;
    }

    public final String toString() {
        int i6 = this.f9095b;
        if (i6 == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(i6 * 5);
        sb.append('[');
        long[] jArr = this.f9094a;
        sb.append(jArr[0]);
        for (int i10 = 1; i10 < i6; i10++) {
            sb.append(", ");
            sb.append(jArr[i10]);
        }
        sb.append(']');
        return sb.toString();
    }
}

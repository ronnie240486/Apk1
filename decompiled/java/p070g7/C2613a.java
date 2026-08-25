package p070g7;

import java.io.Serializable;
import okhttp3.HttpUrl;
import p020b7.AbstractC1332b;

public final class C2613a implements Serializable {

    public static final C2613a f9090c = new C2613a(new int[0]);

    public final int[] f9091a;

    public final int f9092b;

    public C2613a(int[] iArr) {
        int length = iArr.length;
        this.f9091a = iArr;
        this.f9092b = length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2613a)) {
            return false;
        }
        C2613a c2613a = (C2613a) obj;
        int i6 = c2613a.f9092b;
        int i10 = this.f9092b;
        if (i10 != i6) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            AbstractC1332b.m3217h(i11, i10);
            int i12 = this.f9091a[i11];
            AbstractC1332b.m3217h(i11, c2613a.f9092b);
            if (i12 != c2613a.f9091a[i11]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i6 = 1;
        for (int i10 = 0; i10 < this.f9092b; i10++) {
            i6 = (i6 * 31) + this.f9091a[i10];
        }
        return i6;
    }

    public final String toString() {
        int i6 = this.f9092b;
        if (i6 == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(i6 * 5);
        sb.append('[');
        int[] iArr = this.f9091a;
        sb.append(iArr[0]);
        for (int i10 = 1; i10 < i6; i10++) {
            sb.append(", ");
            sb.append(iArr[i10]);
        }
        sb.append(']');
        return sb.toString();
    }
}

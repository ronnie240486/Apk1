package p160p;

import java.util.Arrays;
import p103j9.AbstractC2796i;
import p171q.AbstractC3387a;
import p253x8.AbstractC4146i;

public final class C3348l implements Cloneable {

    public int[] f11335a;

    public Object[] f11336b;

    public int f11337c;

    public C3348l() {
        int i6;
        int i10 = 4;
        while (true) {
            i6 = 40;
            if (i10 >= 32) {
                break;
            }
            int i11 = (1 << i10) - 12;
            if (40 <= i11) {
                i6 = i11;
                break;
            }
            i10++;
        }
        int i12 = i6 / 4;
        this.f11335a = new int[i12];
        this.f11336b = new Object[i12];
    }

    public final void m6817a(int i6, Object obj) {
        int i10 = this.f11337c;
        if (i10 != 0 && i6 <= this.f11335a[i10 - 1]) {
            m6820d(i6, obj);
            return;
        }
        if (i10 >= this.f11335a.length) {
            int i11 = (i10 + 1) * 4;
            for (int i12 = 4; i12 < 32; i12++) {
                int i13 = (1 << i12) - 12;
                if (i11 <= i13) {
                    i11 = i13;
                    break;
                }
            }
            int i14 = i11 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f11335a, i14);
            AbstractC2796i.m5784e(iArrCopyOf, "copyOf(this, newSize)");
            this.f11335a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11336b, i14);
            AbstractC2796i.m5784e(objArrCopyOf, "copyOf(this, newSize)");
            this.f11336b = objArrCopyOf;
        }
        this.f11335a[i10] = i6;
        this.f11336b[i10] = obj;
        this.f11337c = i10 + 1;
    }

    public final C3348l clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        AbstractC2796i.m5783d(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        C3348l c3348l = (C3348l) objClone;
        c3348l.f11335a = (int[]) this.f11335a.clone();
        c3348l.f11336b = (Object[]) this.f11336b.clone();
        return c3348l;
    }

    public final Object m6819c(int i6) {
        Object obj;
        int iM6876a = AbstractC3387a.m6876a(this.f11337c, i6, this.f11335a);
        if (iM6876a < 0 || (obj = this.f11336b[iM6876a]) == AbstractC3346j.f11331b) {
            return null;
        }
        return obj;
    }

    public final void m6820d(int i6, Object obj) {
        int iM6876a = AbstractC3387a.m6876a(this.f11337c, i6, this.f11335a);
        if (iM6876a >= 0) {
            this.f11336b[iM6876a] = obj;
            return;
        }
        int i10 = ~iM6876a;
        int i11 = this.f11337c;
        if (i10 < i11) {
            Object[] objArr = this.f11336b;
            if (objArr[i10] == AbstractC3346j.f11331b) {
                this.f11335a[i10] = i6;
                objArr[i10] = obj;
                return;
            }
        }
        if (i11 >= this.f11335a.length) {
            int i12 = (i11 + 1) * 4;
            for (int i13 = 4; i13 < 32; i13++) {
                int i14 = (1 << i13) - 12;
                if (i12 <= i14) {
                    i12 = i14;
                    break;
                }
            }
            int i15 = i12 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f11335a, i15);
            AbstractC2796i.m5784e(iArrCopyOf, "copyOf(this, newSize)");
            this.f11335a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11336b, i15);
            AbstractC2796i.m5784e(objArrCopyOf, "copyOf(this, newSize)");
            this.f11336b = objArrCopyOf;
        }
        int i16 = this.f11337c;
        if (i16 - i10 != 0) {
            int[] iArr = this.f11335a;
            int i17 = i10 + 1;
            AbstractC4146i.m8170C(i17, i10, i16, iArr, iArr);
            Object[] objArr2 = this.f11336b;
            AbstractC4146i.m8171D(i17, i10, this.f11337c, objArr2, objArr2);
        }
        this.f11335a[i10] = i6;
        this.f11336b[i10] = obj;
        this.f11337c++;
    }

    public final String toString() {
        int i6 = this.f11337c;
        if (i6 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i6 * 28);
        sb.append('{');
        int i10 = this.f11337c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            sb.append(this.f11335a[i11]);
            sb.append('=');
            Object obj = this.f11336b[i11];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC2796i.m5784e(string, "buffer.toString()");
        return string;
    }
}

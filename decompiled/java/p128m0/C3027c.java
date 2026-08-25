package p128m0;

import p103j9.AbstractC2796i;
import p215u.C3880c;

public class C3027c {

    public final int f10356a;

    public final Object[] f10357b;

    public int f10358c;

    public C3027c(int i6) {
        this.f10356a = 0;
        if (i6 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f10357b = new Object[i6];
    }

    public Object mo6099a() {
        switch (this.f10356a) {
            case 0:
                int i6 = this.f10358c;
                if (i6 <= 0) {
                    return null;
                }
                int i10 = i6 - 1;
                Object[] objArr = this.f10357b;
                Object obj = objArr[i10];
                AbstractC2796i.m5783d(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
                objArr[i10] = null;
                this.f10358c--;
                return obj;
            default:
                int i11 = this.f10358c;
                if (i11 <= 0) {
                    return null;
                }
                int i12 = i11 - 1;
                Object[] objArr2 = this.f10357b;
                Object obj2 = objArr2[i12];
                objArr2[i12] = null;
                this.f10358c = i11 - 1;
                return obj2;
        }
    }

    public void m6100b(C3880c c3880c) {
        int i6 = this.f10358c;
        Object[] objArr = this.f10357b;
        if (i6 < objArr.length) {
            objArr[i6] = c3880c;
            this.f10358c = i6 + 1;
        }
    }

    public boolean mo6101c(Object obj) {
        Object[] objArr;
        boolean z7;
        AbstractC2796i.m5785f(obj, "instance");
        int i6 = this.f10358c;
        int i10 = 0;
        while (true) {
            objArr = this.f10357b;
            if (i10 >= i6) {
                z7 = false;
                break;
            }
            if (objArr[i10] == obj) {
                z7 = true;
                break;
            }
            i10++;
        }
        if (z7) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i11 = this.f10358c;
        if (i11 >= objArr.length) {
            return false;
        }
        objArr[i11] = obj;
        this.f10358c = i11 + 1;
        return true;
    }

    public C3027c() {
        this.f10356a = 1;
        this.f10357b = new Object[256];
    }
}

package p041d7;

import java.util.Arrays;

public final class C2325y1 {

    public Object[] f8102a;

    public int f8103b = 0;

    public C2319x1 f8104c;

    public C2325y1(int i6) {
        this.f8102a = new Object[i6 * 2];
    }

    public final C2215h5 m5291a() {
        C2319x1 c2319x1 = this.f8104c;
        if (c2319x1 != null) {
            throw c2319x1.m5288a();
        }
        C2215h5 c2215h5M5205g = C2215h5.m5205g(this.f8103b, this.f8102a, this);
        C2319x1 c2319x2 = this.f8104c;
        if (c2319x2 == null) {
            return c2215h5M5205g;
        }
        throw c2319x2.m5288a();
    }

    public final void m5292b(Object obj, Object obj2) {
        int i6 = (this.f8103b + 1) * 2;
        Object[] objArr = this.f8102a;
        if (i6 > objArr.length) {
            this.f8102a = Arrays.copyOf(objArr, AbstractC2267p1.m5254f(objArr.length, i6));
        }
        AbstractC2182d0.m5140c(obj, obj2);
        Object[] objArr2 = this.f8102a;
        int i10 = this.f8103b;
        int i11 = i10 * 2;
        objArr2[i11] = obj;
        objArr2[i11 + 1] = obj2;
        this.f8103b = i10 + 1;
    }
}

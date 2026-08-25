package p014b1;

import android.util.SparseArray;

public final class C1243q {

    public final SparseArray f3959a;

    public C1239m f3960b;

    public C1243q(int i6) {
        this.f3959a = new SparseArray(i6);
    }

    public final void m3123a(C1239m c1239m, int i6, int i10) {
        int iM3113a = c1239m.m3113a(i6);
        SparseArray sparseArray = this.f3959a;
        C1243q c1243q = sparseArray == null ? null : (C1243q) sparseArray.get(iM3113a);
        if (c1243q == null) {
            c1243q = new C1243q(1);
            sparseArray.put(c1239m.m3113a(i6), c1243q);
        }
        if (i10 > i6) {
            c1243q.m3123a(c1239m, i6 + 1, i10);
        } else {
            c1243q.f3960b = c1239m;
        }
    }
}

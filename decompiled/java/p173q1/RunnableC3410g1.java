package p173q1;

import android.util.SparseArray;

public final class RunnableC3410g1 implements Runnable {

    public final int f11480a;

    public final C3413h1 f11481b;

    public RunnableC3410g1(C3413h1 c3413h1, int i6) {
        this.f11480a = i6;
        this.f11481b = c3413h1;
    }

    @Override
    public final void run() {
        switch (this.f11480a) {
            case 0:
                SparseArray sparseArray = this.f11481b.f11523h;
                int size = sparseArray.size();
                for (int i6 = 0; i6 < size; i6++) {
                    ((AbstractC3433o0) sparseArray.valueAt(i6)).mo6959a(null, null);
                }
                sparseArray.clear();
                break;
            default:
                C3413h1 c3413h1 = this.f11481b;
                ServiceConnectionC3428m1 serviceConnectionC3428m1 = c3413h1.f11524i;
                if (serviceConnectionC3428m1.f11587n == c3413h1) {
                    serviceConnectionC3428m1.m7005j();
                }
                break;
        }
    }
}

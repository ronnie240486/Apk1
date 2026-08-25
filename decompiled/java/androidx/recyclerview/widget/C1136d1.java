package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.util.Set;

public final class C1136d1 {

    public SparseArray f3541a;

    public int f3542b;

    public Set f3543c;

    public final C1132c1 m2923a(int i6) {
        SparseArray sparseArray = this.f3541a;
        C1132c1 c1132c1 = (C1132c1) sparseArray.get(i6);
        if (c1132c1 != null) {
            return c1132c1;
        }
        C1132c1 c1132c2 = new C1132c1();
        sparseArray.put(i6, c1132c2);
        return c1132c2;
    }
}

package p196s1;

import android.util.SparseBooleanArray;
import java.util.ArrayList;
import p160p.C3341e;

public final class C3695e {

    public static final C3693c f12369e = new C3693c();

    public final ArrayList f12370a;

    public final C3694d f12373d;

    public final SparseBooleanArray f12372c = new SparseBooleanArray();

    public final C3341e f12371b = new C3341e(0);

    public C3695e(ArrayList arrayList, ArrayList arrayList2) {
        this.f12370a = arrayList;
        int size = arrayList.size();
        int i6 = Integer.MIN_VALUE;
        C3694d c3694d = null;
        for (int i10 = 0; i10 < size; i10++) {
            C3694d c3694d2 = (C3694d) arrayList.get(i10);
            int i11 = c3694d2.f12364e;
            if (i11 > i6) {
                c3694d = c3694d2;
                i6 = i11;
            }
        }
        this.f12373d = c3694d;
    }
}

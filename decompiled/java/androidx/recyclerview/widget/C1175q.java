package androidx.recyclerview.widget;

import java.util.Comparator;

public final class C1175q implements Comparator {
    @Override
    public final int compare(Object obj, Object obj2) {
        C1181s c1181s = (C1181s) obj;
        C1181s c1181s2 = (C1181s) obj2;
        RecyclerView recyclerView = c1181s.f3685d;
        if ((recyclerView == null) != (c1181s2.f3685d == null)) {
            if (recyclerView == null) {
                return 1;
            }
            return -1;
        }
        boolean z7 = c1181s.f3682a;
        if (z7 != c1181s2.f3682a) {
            if (z7) {
                return -1;
            }
            return 1;
        }
        int i6 = c1181s2.f3683b - c1181s.f3683b;
        if (i6 != 0) {
            return i6;
        }
        int i10 = c1181s.f3684c - c1181s2.f3684c;
        if (i10 != 0) {
            return i10;
        }
        return 0;
    }
}

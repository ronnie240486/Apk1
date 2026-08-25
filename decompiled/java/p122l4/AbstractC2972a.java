package p122l4;

import android.util.SparseArray;
import java.util.HashMap;
import p000a.AbstractC0004e;
import p248x3.EnumC4107c;

public abstract class AbstractC2972a {

    public static final SparseArray f10171a = new SparseArray();

    public static final HashMap f10172b;

    static {
        HashMap map = new HashMap();
        f10172b = map;
        map.put(EnumC4107c.f13925a, 0);
        map.put(EnumC4107c.f13926b, 1);
        map.put(EnumC4107c.f13927c, 2);
        for (EnumC4107c enumC4107c : map.keySet()) {
            f10171a.append(((Integer) f10172b.get(enumC4107c)).intValue(), enumC4107c);
        }
    }

    public static int m6008a(EnumC4107c enumC4107c) {
        Integer num = (Integer) f10172b.get(enumC4107c);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + enumC4107c);
    }

    public static EnumC4107c m6009b(int i6) {
        EnumC4107c enumC4107c = (EnumC4107c) f10171a.get(i6);
        if (enumC4107c != null) {
            return enumC4107c;
        }
        throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Unknown Priority for value "));
    }
}

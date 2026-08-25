package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class C0513b {

    public final HashMap f2458a = new HashMap();

    public final HashMap f2459b;

    public C0513b(HashMap map) {
        this.f2459b = map;
        for (Map.Entry entry : map.entrySet()) {
            EnumC0537n enumC0537n = (EnumC0537n) entry.getValue();
            List arrayList = (List) this.f2458a.get(enumC0537n);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f2458a.put(enumC0537n, arrayList);
            }
            arrayList.add((C0515c) entry.getKey());
        }
    }

    public static void m1475a(List list, InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n, InterfaceC0553v interfaceC0553v) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                C0515c c0515c = (C0515c) list.get(size);
                c0515c.getClass();
                try {
                    int i6 = c0515c.f2462a;
                    Method method = c0515c.f2463b;
                    if (i6 == 0) {
                        method.invoke(interfaceC0553v, null);
                    } else if (i6 == 1) {
                        method.invoke(interfaceC0553v, interfaceC0555w);
                    } else if (i6 == 2) {
                        method.invoke(interfaceC0553v, interfaceC0555w, enumC0537n);
                    }
                } catch (IllegalAccessException e5) {
                    throw new RuntimeException(e5);
                } catch (InvocationTargetException e10) {
                    throw new RuntimeException("Failed to call observer method", e10.getCause());
                }
            }
        }
    }
}

package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public final class C0562z0 {

    public final LinkedHashMap f2562a = new LinkedHashMap();

    public final void m1527a() {
        for (AbstractC0554v0 abstractC0554v0 : this.f2562a.values()) {
            abstractC0554v0.f2542c = true;
            HashMap map = abstractC0554v0.f2540a;
            if (map != null) {
                synchronized (map) {
                    try {
                        Iterator it = abstractC0554v0.f2540a.values().iterator();
                        while (it.hasNext()) {
                            AbstractC0554v0.m1516a(it.next());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            LinkedHashSet linkedHashSet = abstractC0554v0.f2541b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        Iterator it2 = abstractC0554v0.f2541b.iterator();
                        while (it2.hasNext()) {
                            AbstractC0554v0.m1516a((Closeable) it2.next());
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                abstractC0554v0.f2541b.clear();
            }
            abstractC0554v0.mo1267b();
        }
        this.f2562a.clear();
    }
}

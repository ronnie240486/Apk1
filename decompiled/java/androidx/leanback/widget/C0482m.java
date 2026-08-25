package androidx.leanback.widget;

import java.util.ArrayList;
import java.util.HashMap;
import qa.C3565m;

public final class C0482m extends AbstractC0481l0 {

    public final ArrayList f2366a = new ArrayList();

    public final HashMap f2367b = new HashMap();

    @Override
    public final C3565m mo1405a(Object obj) {
        Object obj2;
        C3565m c3565mMo1405a;
        if (obj == null) {
            return null;
        }
        Class<?> superclass = obj.getClass();
        do {
            obj2 = this.f2367b.get(superclass);
            if ((obj2 instanceof AbstractC0481l0) && (c3565mMo1405a = ((AbstractC0481l0) obj2).mo1405a(obj)) != null) {
                return c3565mMo1405a;
            }
            superclass = superclass.getSuperclass();
            if (obj2 != null) {
                break;
            }
        } while (superclass != null);
        return (C3565m) obj2;
    }

    public final void m1445b(Class cls, C3565m c3565m) {
        this.f2367b.put(cls, c3565m);
        ArrayList arrayList = this.f2366a;
        if (arrayList.contains(c3565m)) {
            return;
        }
        arrayList.add(c3565m);
    }
}

package p041d7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class C2300u0 extends AbstractC2263o4 {

    public final C2324y0 f8068d;

    public C2300u0(C2324y0 c2324y0) {
        this.f8068d = c2324y0;
    }

    @Override
    public final Set mo5170a() {
        return new C2181d(this, 1);
    }

    @Override
    public final Set mo5185b() {
        return new C2202g(this, 1);
    }

    @Override
    public final Collection mo5237c() {
        return new C2294t0(this);
    }

    @Override
    public final void clear() {
        this.f8068d.clear();
    }

    @Override
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override
    public final Collection get(Object obj) {
        C2324y0 c2324y0 = this.f8068d;
        Collection collection = (Collection) c2324y0.f8100f.mo5173d().get(obj);
        if (collection == null) {
            return null;
        }
        C2189e0 c2189e0M5289o = C2324y0.m5289o(collection, new C2318x0(c2324y0, obj));
        if (c2189e0M5289o.isEmpty()) {
            return null;
        }
        return c2189e0M5289o;
    }

    @Override
    public final Collection remove(Object obj) {
        C2324y0 c2324y0 = this.f8068d;
        Collection collection = (Collection) c2324y0.f8100f.mo5173d().get(obj);
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (c2324y0.f8101g.apply(new C2281r1(obj, next))) {
                it.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return c2324y0.f8100f instanceof InterfaceC2243l5 ? Collections.unmodifiableSet(new LinkedHashSet(arrayList)) : Collections.unmodifiableList(arrayList);
    }
}

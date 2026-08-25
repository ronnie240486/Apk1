package p041d7;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public final class C2265p extends C2279r implements NavigableSet {

    public final C2291s4 f8018g;

    public C2265p(C2291s4 c2291s4, Object obj, NavigableSet navigableSet, AbstractC2244m abstractC2244m) {
        super(c2291s4, obj, navigableSet, abstractC2244m);
        this.f8018g = c2291s4;
    }

    @Override
    public final Object ceiling(Object obj) {
        return mo5251f().ceiling(obj);
    }

    @Override
    public final Iterator descendingIterator() {
        return new C2188e(this, mo5251f().descendingIterator());
    }

    @Override
    public final NavigableSet descendingSet() {
        return m5253h(mo5251f().descendingSet());
    }

    @Override
    public final Object floor(Object obj) {
        return mo5251f().floor(obj);
    }

    @Override
    public final NavigableSet mo5251f() {
        return (NavigableSet) ((SortedSet) this.f7992b);
    }

    public final C2265p m5253h(NavigableSet navigableSet) {
        AbstractC2244m abstractC2244m = this.f7993c;
        if (abstractC2244m == null) {
            abstractC2244m = this;
        }
        return new C2265p(this.f8018g, this.f7991a, navigableSet, abstractC2244m);
    }

    @Override
    public final NavigableSet headSet(Object obj, boolean z7) {
        return m5253h(mo5251f().headSet(obj, z7));
    }

    @Override
    public final Object higher(Object obj) {
        return mo5251f().higher(obj);
    }

    @Override
    public final Object lower(Object obj) {
        return mo5251f().lower(obj);
    }

    @Override
    public final Object pollFirst() {
        return AbstractC2182d0.m5159v(iterator());
    }

    @Override
    public final Object pollLast() {
        return AbstractC2182d0.m5159v(descendingIterator());
    }

    @Override
    public final NavigableSet subSet(Object obj, boolean z7, Object obj2, boolean z10) {
        return m5253h(mo5251f().subSet(obj, z7, obj2, z10));
    }

    @Override
    public final NavigableSet tailSet(Object obj, boolean z7) {
        return m5253h(mo5251f().tailSet(obj, z7));
    }
}

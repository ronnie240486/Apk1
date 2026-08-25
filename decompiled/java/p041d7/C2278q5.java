package p041d7;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

public final class C2278q5 extends AbstractC2260o1 implements NavigableSet, Serializable {

    public final NavigableSet f8033a;

    public final SortedSet f8034b;

    public transient C2278q5 f8035c;

    public C2278q5(NavigableSet navigableSet) {
        navigableSet.getClass();
        this.f8033a = navigableSet;
        this.f8034b = Collections.unmodifiableSortedSet(navigableSet);
    }

    @Override
    public final Set mo5100c() {
        return this.f8034b;
    }

    @Override
    public final Object ceiling(Object obj) {
        return this.f8033a.ceiling(obj);
    }

    @Override
    public final Object delegate() {
        return this.f8034b;
    }

    @Override
    public final Iterator descendingIterator() {
        Iterator itDescendingIterator = this.f8033a.descendingIterator();
        itDescendingIterator.getClass();
        return itDescendingIterator instanceof AbstractC2292s5 ? (AbstractC2292s5) itDescendingIterator : new C2275q2(itDescendingIterator);
    }

    @Override
    public final NavigableSet descendingSet() {
        C2278q5 c2278q5 = this.f8035c;
        if (c2278q5 != null) {
            return c2278q5;
        }
        C2278q5 c2278q6 = new C2278q5(this.f8033a.descendingSet());
        this.f8035c = c2278q6;
        c2278q6.f8035c = this;
        return c2278q6;
    }

    @Override
    public final Object floor(Object obj) {
        return this.f8033a.floor(obj);
    }

    @Override
    public final NavigableSet headSet(Object obj, boolean z7) {
        return AbstractC2182d0.m5137I(this.f8033a.headSet(obj, z7));
    }

    @Override
    public final Object higher(Object obj) {
        return this.f8033a.higher(obj);
    }

    @Override
    public final Object lower(Object obj) {
        return this.f8033a.lower(obj);
    }

    @Override
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final NavigableSet subSet(Object obj, boolean z7, Object obj2, boolean z10) {
        return AbstractC2182d0.m5137I(this.f8033a.subSet(obj, z7, obj2, z10));
    }

    @Override
    public final NavigableSet tailSet(Object obj, boolean z7) {
        return AbstractC2182d0.m5137I(this.f8033a.tailSet(obj, z7));
    }

    @Override
    public final Collection delegate() {
        return this.f8034b;
    }
}

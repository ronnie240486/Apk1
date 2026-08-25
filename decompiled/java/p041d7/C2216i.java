package p041d7;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

public final class C2216i extends C2237l implements NavigableSet {

    public final AbstractC2286s f7931f;

    public C2216i(AbstractC2286s abstractC2286s, NavigableMap navigableMap) {
        super(abstractC2286s, navigableMap);
        this.f7931f = abstractC2286s;
    }

    @Override
    public final Object ceiling(Object obj) {
        return mo5206c().ceilingKey(obj);
    }

    @Override
    public final NavigableMap mo5206c() {
        return (NavigableMap) ((SortedMap) ((Map) this.f8086b));
    }

    @Override
    public final Iterator descendingIterator() {
        return ((C2202g) descendingSet()).iterator();
    }

    @Override
    public final NavigableSet descendingSet() {
        return new C2216i(this.f7931f, mo5206c().descendingMap());
    }

    @Override
    public final Object floor(Object obj) {
        return mo5206c().floorKey(obj);
    }

    @Override
    public final SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override
    public final Object higher(Object obj) {
        return mo5206c().higherKey(obj);
    }

    @Override
    public final Object lower(Object obj) {
        return mo5206c().lowerKey(obj);
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
    public final SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override
    public final SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    @Override
    public final NavigableSet headSet(Object obj, boolean z7) {
        return new C2216i(this.f7931f, mo5206c().headMap(obj, z7));
    }

    @Override
    public final NavigableSet subSet(Object obj, boolean z7, Object obj2, boolean z10) {
        return new C2216i(this.f7931f, mo5206c().subMap(obj, z7, obj2, z10));
    }

    @Override
    public final NavigableSet tailSet(Object obj, boolean z7) {
        return new C2216i(this.f7931f, mo5206c().tailMap(obj, z7));
    }
}

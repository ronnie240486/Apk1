package p041d7;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

public class C2237l extends C2202g implements SortedSet {

    public final AbstractC2286s f7980e;

    public C2237l(AbstractC2286s abstractC2286s, SortedMap sortedMap) {
        super(abstractC2286s, sortedMap);
        this.f7980e = abstractC2286s;
    }

    public SortedMap mo5206c() {
        return (SortedMap) ((Map) this.f8086b);
    }

    @Override
    public final Comparator comparator() {
        return mo5206c().comparator();
    }

    @Override
    public final Object first() {
        return mo5206c().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new C2237l(this.f7980e, mo5206c().headMap(obj));
    }

    @Override
    public final Object last() {
        return mo5206c().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new C2237l(this.f7980e, mo5206c().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new C2237l(this.f7980e, mo5206c().tailMap(obj));
    }
}

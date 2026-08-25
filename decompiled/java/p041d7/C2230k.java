package p041d7;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

public class C2230k extends C2195f implements SortedMap {

    public SortedSet f7961f;

    public final AbstractC2286s f7962g;

    public C2230k(AbstractC2286s abstractC2286s, SortedMap sortedMap) {
        super(abstractC2286s, sortedMap);
        this.f7962g = abstractC2286s;
    }

    @Override
    public final Comparator comparator() {
        return mo5188g().comparator();
    }

    @Override
    public SortedSet mo5185b() {
        return new C2237l(this.f7962g, mo5188g());
    }

    @Override
    public SortedSet keySet() {
        SortedSet sortedSet = this.f7961f;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet sortedSetMo5185b = mo5185b();
        this.f7961f = sortedSetMo5185b;
        return sortedSetMo5185b;
    }

    @Override
    public final Object firstKey() {
        return mo5188g().firstKey();
    }

    public SortedMap mo5188g() {
        return (SortedMap) this.f7887d;
    }

    public SortedMap headMap(Object obj) {
        return new C2230k(this.f7962g, mo5188g().headMap(obj));
    }

    @Override
    public final Object lastKey() {
        return mo5188g().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new C2230k(this.f7962g, mo5188g().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new C2230k(this.f7962g, mo5188g().tailMap(obj));
    }
}

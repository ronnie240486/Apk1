package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class C2209h extends C2230k implements NavigableMap {

    public final AbstractC2286s f7912h;

    public C2209h(AbstractC2286s abstractC2286s, NavigableMap navigableMap) {
        super(abstractC2286s, navigableMap);
        this.f7912h = abstractC2286s;
    }

    @Override
    public final Set mo5185b() {
        return new C2216i(this.f7912h, mo5188g());
    }

    @Override
    public final Map.Entry ceilingEntry(Object obj) {
        Map.Entry entryCeilingEntry = mo5188g().ceilingEntry(obj);
        if (entryCeilingEntry == null) {
            return null;
        }
        return m5171d(entryCeilingEntry);
    }

    @Override
    public final Object ceilingKey(Object obj) {
        return mo5188g().ceilingKey(obj);
    }

    @Override
    public final NavigableSet descendingKeySet() {
        return (NavigableSet) super.keySet();
    }

    @Override
    public final NavigableMap descendingMap() {
        return new C2209h(this.f7912h, mo5188g().descendingMap());
    }

    @Override
    public final SortedSet mo5185b() {
        return new C2216i(this.f7912h, mo5188g());
    }

    @Override
    public final SortedSet keySet() {
        return (NavigableSet) super.keySet();
    }

    @Override
    public final Map.Entry firstEntry() {
        Map.Entry entryFirstEntry = mo5188g().firstEntry();
        if (entryFirstEntry == null) {
            return null;
        }
        return m5171d(entryFirstEntry);
    }

    @Override
    public final Map.Entry floorEntry(Object obj) {
        Map.Entry entryFloorEntry = mo5188g().floorEntry(obj);
        if (entryFloorEntry == null) {
            return null;
        }
        return m5171d(entryFloorEntry);
    }

    @Override
    public final Object floorKey(Object obj) {
        return mo5188g().floorKey(obj);
    }

    public final C2281r1 m5189h(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Map.Entry entry = (Map.Entry) it.next();
        AbstractC2286s abstractC2286s = this.f7912h;
        Collection collectionMo5099o = abstractC2286s.mo5099o();
        collectionMo5099o.addAll((Collection) entry.getValue());
        it.remove();
        return new C2281r1(entry.getKey(), abstractC2286s.mo5104r(collectionMo5099o));
    }

    @Override
    public final SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override
    public final Map.Entry higherEntry(Object obj) {
        Map.Entry entryHigherEntry = mo5188g().higherEntry(obj);
        if (entryHigherEntry == null) {
            return null;
        }
        return m5171d(entryHigherEntry);
    }

    @Override
    public final Object higherKey(Object obj) {
        return mo5188g().higherKey(obj);
    }

    @Override
    public final NavigableMap mo5188g() {
        return (NavigableMap) ((SortedMap) this.f7887d);
    }

    @Override
    public final Set keySet() {
        return (NavigableSet) super.keySet();
    }

    @Override
    public final Map.Entry lastEntry() {
        Map.Entry entryLastEntry = mo5188g().lastEntry();
        if (entryLastEntry == null) {
            return null;
        }
        return m5171d(entryLastEntry);
    }

    @Override
    public final Map.Entry lowerEntry(Object obj) {
        Map.Entry entryLowerEntry = mo5188g().lowerEntry(obj);
        if (entryLowerEntry == null) {
            return null;
        }
        return m5171d(entryLowerEntry);
    }

    @Override
    public final Object lowerKey(Object obj) {
        return mo5188g().lowerKey(obj);
    }

    @Override
    public final NavigableSet navigableKeySet() {
        return (NavigableSet) super.keySet();
    }

    @Override
    public final Map.Entry pollFirstEntry() {
        return m5189h(entrySet().iterator());
    }

    @Override
    public final Map.Entry pollLastEntry() {
        return m5189h(((AbstractC2263o4) descendingMap()).entrySet().iterator());
    }

    @Override
    public final SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override
    public final SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override
    public final NavigableMap headMap(Object obj, boolean z7) {
        return new C2209h(this.f7912h, mo5188g().headMap(obj, z7));
    }

    @Override
    public final NavigableMap subMap(Object obj, boolean z7, Object obj2, boolean z10) {
        return new C2209h(this.f7912h, mo5188g().subMap(obj, z7, obj2, z10));
    }

    @Override
    public final NavigableMap tailMap(Object obj, boolean z7) {
        return new C2209h(this.f7912h, mo5188g().tailMap(obj, z7));
    }
}

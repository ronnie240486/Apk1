package p041d7;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p001a0.C0019b;
import p020b7.InterfaceC1346i;
import p029c7.C1427w;

public final class C2256n4 extends AbstractMap {

    public final Map f8008a;

    public final C0019b f8009b;

    public C2256n4(Map map, C0019b c0019b) {
        map.getClass();
        this.f8008a = map;
        this.f8009b = c0019b;
    }

    @Override
    public final void clear() {
        this.f8008a.clear();
    }

    @Override
    public final boolean containsKey(Object obj) {
        return this.f8008a.containsKey(obj);
    }

    @Override
    public final Set entrySet() {
        return new C2181d(this, 2);
    }

    @Override
    public final Object get(Object obj) {
        Map map = this.f8008a;
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return ((InterfaceC1346i) this.f8009b.f38b).apply(obj2);
        }
        return null;
    }

    @Override
    public final Set keySet() {
        return this.f8008a.keySet();
    }

    @Override
    public final Object remove(Object obj) {
        Map map = this.f8008a;
        if (!map.containsKey(obj)) {
            return null;
        }
        return ((InterfaceC1346i) this.f8009b.f38b).apply(map.remove(obj));
    }

    @Override
    public final int size() {
        return this.f8008a.size();
    }

    @Override
    public final Collection values() {
        return new C1427w(this);
    }
}

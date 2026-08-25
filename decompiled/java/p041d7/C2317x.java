package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class C2317x extends AbstractC2271p5 {

    public final int f8085a = 0;

    public final Object f8086b;

    public C2317x(Map map) {
        map.getClass();
        this.f8086b = map;
    }

    @Override
    public void clear() {
        switch (this.f8085a) {
            case 0:
                ((AbstractC2329z) this.f8086b).clear();
                break;
            default:
                ((Map) this.f8086b).clear();
                break;
        }
    }

    @Override
    public final boolean contains(Object obj) {
        switch (this.f8085a) {
            case 0:
                return ((AbstractC2329z) this.f8086b).contains(obj);
            default:
                return ((Map) this.f8086b).containsKey(obj);
        }
    }

    @Override
    public boolean containsAll(Collection collection) {
        switch (this.f8085a) {
            case 0:
                return ((AbstractC2329z) this.f8086b).containsAll(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override
    public final boolean isEmpty() {
        switch (this.f8085a) {
            case 0:
                return ((AbstractC2329z) this.f8086b).isEmpty();
            default:
                return ((Map) this.f8086b).isEmpty();
        }
    }

    @Override
    public Iterator iterator() {
        switch (this.f8085a) {
            case 0:
                ((AbstractC2329z) this.f8086b).mo5282f();
                throw null;
            default:
                return new C2200f4(((Map) this.f8086b).entrySet().iterator(), 0);
        }
    }

    @Override
    public boolean remove(Object obj) {
        switch (this.f8085a) {
            case 0:
                return ((AbstractC2329z) this.f8086b).mo5166b(Integer.MAX_VALUE, obj) > 0;
            default:
                Map map = (Map) this.f8086b;
                if (!map.containsKey(obj)) {
                    return false;
                }
                map.remove(obj);
                return true;
        }
    }

    @Override
    public final int size() {
        switch (this.f8085a) {
            case 0:
                return ((AbstractC2329z) this.f8086b).entrySet().size();
            default:
                return ((Map) this.f8086b).size();
        }
    }

    public C2317x(AbstractC2329z abstractC2329z) {
        this.f8086b = abstractC2329z;
    }
}

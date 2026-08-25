package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import p020b7.C1356p;
import p020b7.C1357q;
import p020b7.C1360t;

public class C2202g extends C2317x {

    public final int f7901c;

    public final Object f7902d;

    public C2202g(AbstractC2263o4 abstractC2263o4, int i6) {
        super(abstractC2263o4);
        this.f7901c = i6;
        this.f7902d = abstractC2263o4;
    }

    @Override
    public void clear() {
        switch (this.f7901c) {
            case 0:
                AbstractC2182d0.m5142e(iterator());
                break;
            default:
                super.clear();
                break;
        }
    }

    @Override
    public boolean containsAll(Collection collection) {
        switch (this.f7901c) {
            case 0:
                return ((Map) this.f8086b).keySet().containsAll(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override
    public boolean equals(Object obj) {
        switch (this.f7901c) {
            case 0:
                return this == obj || ((Map) this.f8086b).keySet().equals(obj);
            default:
                return super.equals(obj);
        }
    }

    @Override
    public int hashCode() {
        switch (this.f7901c) {
            case 0:
                return ((Map) this.f8086b).keySet().hashCode();
            default:
                return super.hashCode();
        }
    }

    @Override
    public Iterator iterator() {
        switch (this.f7901c) {
            case 0:
                return new C2188e(this, ((Map) this.f8086b).entrySet().iterator());
            default:
                return super.iterator();
        }
    }

    @Override
    public final boolean remove(Object obj) {
        int size;
        switch (this.f7901c) {
            case 0:
                Collection collection = (Collection) ((Map) this.f8086b).remove(obj);
                if (collection != null) {
                    size = collection.size();
                    collection.clear();
                    ((AbstractC2286s) this.f7902d).f8046g -= size;
                } else {
                    size = 0;
                }
                return size > 0;
            case 1:
                return ((C2300u0) this.f7902d).remove(obj) != null;
            default:
                C2242l4 c2242l4 = (C2242l4) this.f7902d;
                if (!c2242l4.containsKey(obj)) {
                    return false;
                }
                c2242l4.f7987d.remove(obj);
                return true;
        }
    }

    @Override
    public boolean removeAll(Collection collection) {
        switch (this.f7901c) {
            case 1:
                return ((C2300u0) this.f7902d).f8068d.m5290p(new C1356p(new C1357q(collection), EnumC2221i4.f7943a));
            case 2:
                C2242l4 c2242l4 = (C2242l4) this.f7902d;
                Map map = c2242l4.f7987d;
                ?? r10 = c2242l4.f7988e;
                Iterator it = map.entrySet().iterator();
                boolean z7 = false;
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (r10.apply(entry) && collection.contains(entry.getKey())) {
                        it.remove();
                        z7 = true;
                    }
                }
                return z7;
            default:
                return super.removeAll(collection);
        }
    }

    @Override
    public boolean retainAll(Collection collection) {
        switch (this.f7901c) {
            case 1:
                return ((C2300u0) this.f7902d).f8068d.m5290p(new C1356p(new C1360t(new C1357q(collection)), EnumC2221i4.f7943a));
            case 2:
                C2242l4 c2242l4 = (C2242l4) this.f7902d;
                Map map = c2242l4.f7987d;
                ?? r10 = c2242l4.f7988e;
                Iterator it = map.entrySet().iterator();
                boolean z7 = false;
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (r10.apply(entry) && !collection.contains(entry.getKey())) {
                        it.remove();
                        z7 = true;
                    }
                }
                return z7;
            default:
                return super.retainAll(collection);
        }
    }

    @Override
    public Object[] toArray() {
        switch (this.f7901c) {
            case 2:
                return AbstractC2182d0.m5156s(iterator()).toArray();
            default:
                return super.toArray();
        }
    }

    public C2202g(AbstractC2286s abstractC2286s, Map map) {
        super(map);
        this.f7901c = 0;
        this.f7902d = abstractC2286s;
    }

    @Override
    public Object[] toArray(Object[] objArr) {
        switch (this.f7901c) {
            case 2:
                return AbstractC2182d0.m5156s(iterator()).toArray(objArr);
            default:
                return super.toArray(objArr);
        }
    }
}

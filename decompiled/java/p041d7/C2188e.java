package p041d7;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p020b7.AbstractC1332b;

public class C2188e implements Iterator {

    public final int f7872a = 0;

    public final Iterator f7873b;

    public Object f7874c;

    public final Object f7875d;

    public C2188e(AbstractC2244m abstractC2244m) {
        this.f7875d = abstractC2244m;
        Collection collection = abstractC2244m.f7992b;
        this.f7874c = collection;
        this.f7873b = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public void m5165a() {
        AbstractC2244m abstractC2244m = (AbstractC2244m) this.f7875d;
        abstractC2244m.m5241d();
        if (abstractC2244m.f7992b != ((Collection) this.f7874c)) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public final boolean hasNext() {
        switch (this.f7872a) {
            case 0:
                break;
            case 1:
                break;
            default:
                m5165a();
                break;
        }
        return this.f7873b.hasNext();
    }

    @Override
    public final Object next() {
        switch (this.f7872a) {
            case 0:
                Map.Entry entry = (Map.Entry) this.f7873b.next();
                this.f7874c = (Collection) entry.getValue();
                return ((C2195f) this.f7875d).m5171d(entry);
            case 1:
                Map.Entry entry2 = (Map.Entry) this.f7873b.next();
                this.f7874c = entry2;
                return entry2.getKey();
            default:
                m5165a();
                return this.f7873b.next();
        }
    }

    @Override
    public final void remove() {
        switch (this.f7872a) {
            case 0:
                AbstractC1332b.m3223n("no calls to next() since the last call to remove()", ((Collection) this.f7874c) != null);
                this.f7873b.remove();
                ((C2195f) this.f7875d).f7888e.f8046g -= ((Collection) this.f7874c).size();
                ((Collection) this.f7874c).clear();
                this.f7874c = null;
                break;
            case 1:
                AbstractC1332b.m3223n("no calls to next() since the last call to remove()", ((Map.Entry) this.f7874c) != null);
                Collection collection = (Collection) ((Map.Entry) this.f7874c).getValue();
                this.f7873b.remove();
                ((AbstractC2286s) ((C2202g) this.f7875d).f7902d).f8046g -= collection.size();
                collection.clear();
                this.f7874c = null;
                break;
            default:
                this.f7873b.remove();
                AbstractC2244m abstractC2244m = (AbstractC2244m) this.f7875d;
                abstractC2244m.f7995e.f8046g--;
                abstractC2244m.m5242e();
                break;
        }
    }

    public C2188e(AbstractC2244m abstractC2244m, Iterator it) {
        this.f7875d = abstractC2244m;
        this.f7874c = abstractC2244m.f7992b;
        this.f7873b = it;
    }

    public C2188e(C2202g c2202g, Iterator it) {
        this.f7873b = it;
        this.f7875d = c2202g;
    }

    public C2188e(C2195f c2195f) {
        this.f7875d = c2195f;
        this.f7873b = c2195f.f7887d.entrySet().iterator();
    }
}

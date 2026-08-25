package p041d7;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p001a0.C0019b;
import p020b7.C1357q;
import p020b7.C1360t;
import p187r4.AbstractC3612b;

public final class C2181d extends AbstractC2228j4 {

    public final int f7865b;

    public final AbstractMap f7866c;

    public C2181d(AbstractMap abstractMap, int i6) {
        super(0);
        this.f7865b = i6;
        this.f7866c = abstractMap;
    }

    @Override
    public final Map mo5128c() {
        switch (this.f7865b) {
            case 0:
                return (C2195f) this.f7866c;
            case 1:
                return (C2300u0) this.f7866c;
            default:
                return (C2256n4) this.f7866c;
        }
    }

    @Override
    public boolean contains(Object obj) {
        switch (this.f7865b) {
            case 0:
                Set setEntrySet = ((C2195f) this.f7866c).f7887d.entrySet();
                setEntrySet.getClass();
                try {
                    return setEntrySet.contains(obj);
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            default:
                return super.contains(obj);
        }
    }

    @Override
    public final Iterator iterator() {
        switch (this.f7865b) {
            case 0:
                return new C2188e((C2195f) this.f7866c);
            case 1:
                return new C2287s0(this);
            default:
                C2256n4 c2256n4 = (C2256n4) this.f7866c;
                Iterator it = c2256n4.f8008a.entrySet().iterator();
                C0019b c0019b = c2256n4.f8009b;
                c0019b.getClass();
                return new C2282r2(it, new C2193e4(c0019b));
        }
    }

    @Override
    public boolean remove(Object obj) {
        Object objRemove;
        switch (this.f7865b) {
            case 0:
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractC2286s abstractC2286s = ((C2195f) this.f7866c).f7888e;
                Object key = entry.getKey();
                Map map = abstractC2286s.f8045f;
                map.getClass();
                try {
                    objRemove = map.remove(key);
                    break;
                } catch (ClassCastException | NullPointerException unused) {
                    objRemove = null;
                }
                Collection collection = (Collection) objRemove;
                if (collection != null) {
                    int size = collection.size();
                    collection.clear();
                    abstractC2286s.f8046g -= size;
                }
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override
    public boolean removeAll(Collection collection) {
        switch (this.f7865b) {
            case 1:
                return ((C2300u0) this.f7866c).f8068d.m5290p(new C1357q(collection));
            default:
                return super.removeAll(collection);
        }
    }

    @Override
    public boolean retainAll(Collection collection) {
        switch (this.f7865b) {
            case 1:
                return ((C2300u0) this.f7866c).f8068d.m5290p(new C1360t(new C1357q(collection)));
            default:
                return super.retainAll(collection);
        }
    }

    @Override
    public int size() {
        switch (this.f7865b) {
            case 1:
                C2287s0 c2287s0 = new C2287s0(this);
                long j10 = 0;
                while (c2287s0.hasNext()) {
                    c2287s0.next();
                    j10++;
                }
                return AbstractC3612b.m7255K(j10);
            default:
                return super.size();
        }
    }
}

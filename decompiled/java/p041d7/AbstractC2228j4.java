package p041d7;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import p020b7.AbstractC1332b;

public abstract class AbstractC2228j4 extends AbstractC2271p5 {

    public final int f7959a;

    public AbstractC2228j4(int i6) {
        this.f7959a = i6;
    }

    public abstract Map mo5128c();

    @Override
    public final void clear() {
        switch (this.f7959a) {
            case 0:
                mo5128c().clear();
                break;
            default:
                mo5225d().clear();
                break;
        }
    }

    @Override
    public boolean contains(Object obj) {
        Object obj2;
        switch (this.f7959a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Map mapMo5128c = mo5128c();
                mapMo5128c.getClass();
                try {
                    obj2 = mapMo5128c.get(key);
                    break;
                } catch (ClassCastException | NullPointerException unused) {
                    obj2 = null;
                }
                if (AbstractC1332b.m3225p(obj2, entry.getValue())) {
                    return obj2 != null || mo5128c().containsKey(key);
                }
                return false;
            default:
                if (!(obj instanceof AbstractC2316w4)) {
                    return false;
                }
                AbstractC2316w4 abstractC2316w4 = (AbstractC2316w4) obj;
                return abstractC2316w4.mo5264a() > 0 && mo5225d().count(abstractC2316w4.mo5265b()) == abstractC2316w4.mo5264a();
        }
    }

    public abstract InterfaceC2310v4 mo5225d();

    @Override
    public boolean isEmpty() {
        switch (this.f7959a) {
            case 0:
                return mo5128c().isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override
    public boolean remove(Object obj) {
        switch (this.f7959a) {
            case 0:
                if (contains(obj) && (obj instanceof Map.Entry)) {
                    return mo5128c().keySet().remove(((Map.Entry) obj).getKey());
                }
                return false;
            default:
                if (!(obj instanceof AbstractC2316w4)) {
                    return false;
                }
                AbstractC2316w4 abstractC2316w4 = (AbstractC2316w4) obj;
                Object objMo5265b = abstractC2316w4.mo5265b();
                int iMo5264a = abstractC2316w4.mo5264a();
                if (iMo5264a == 0) {
                    return false;
                }
                AbstractC2329z abstractC2329z = (AbstractC2329z) mo5225d();
                abstractC2329z.getClass();
                AbstractC2182d0.m5141d(iMo5264a, "oldCount");
                AbstractC2182d0.m5141d(0, "newCount");
                if (abstractC2329z.count(objMo5265b) != iMo5264a) {
                    return false;
                }
                AbstractC2182d0.m5141d(0, "count");
                int iCount = 0 - abstractC2329z.count(objMo5265b);
                if (iCount > 0) {
                    abstractC2329z.add(iCount, objMo5265b);
                } else if (iCount < 0) {
                    abstractC2329z.mo5166b(-iCount, objMo5265b);
                }
                return true;
        }
    }

    @Override
    public boolean removeAll(Collection collection) {
        switch (this.f7959a) {
            case 0:
                try {
                    collection.getClass();
                    return AbstractC2182d0.m5161x(this, collection);
                } catch (UnsupportedOperationException unused) {
                    Iterator it = collection.iterator();
                    boolean zRemove = false;
                    while (it.hasNext()) {
                        zRemove |= remove(it.next());
                    }
                    return zRemove;
                }
            default:
                return super.removeAll(collection);
        }
    }

    @Override
    public boolean retainAll(Collection collection) {
        int iCeil;
        switch (this.f7959a) {
            case 0:
                try {
                    collection.getClass();
                    return super.retainAll(collection);
                } catch (UnsupportedOperationException unused) {
                    int size = collection.size();
                    if (size < 3) {
                        AbstractC2182d0.m5141d(size, "expectedSize");
                        iCeil = size + 1;
                    } else {
                        iCeil = size < 1073741824 ? (int) Math.ceil(((double) size) / 0.75d) : Integer.MAX_VALUE;
                    }
                    HashSet hashSet = new HashSet(iCeil);
                    for (Object obj : collection) {
                        if (contains(obj) && (obj instanceof Map.Entry)) {
                            hashSet.add(((Map.Entry) obj).getKey());
                        }
                    }
                    return mo5128c().keySet().retainAll(hashSet);
                }
            default:
                return super.retainAll(collection);
        }
    }

    @Override
    public int size() {
        return mo5128c().size();
    }
}

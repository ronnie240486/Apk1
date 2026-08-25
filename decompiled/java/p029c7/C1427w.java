package p029c7;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import p020b7.AbstractC1332b;
import p020b7.C1356p;
import p020b7.C1357q;
import p020b7.C1360t;
import p020b7.InterfaceC1354n;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2311w;
import p041d7.C2185d3;
import p041d7.C2196f0;
import p041d7.C2200f4;
import p041d7.C2217i0;
import p041d7.ConcurrentMapC2179c4;
import p041d7.EnumC2221i4;
import p041d7.InterfaceC2183d1;

public class C1427w extends AbstractCollection {

    public final int f4352a;

    public final Object f4353b;

    public C1427w(AbstractMap abstractMap, int i6) {
        this.f4352a = i6;
        this.f4353b = abstractMap;
    }

    @Override
    public final void clear() {
        switch (this.f4352a) {
            case 0:
                ((ConcurrentMapC1404b0) this.f4353b).clear();
                break;
            case 1:
                ((C2217i0) this.f4353b).clear();
                break;
            case 2:
                ((AbstractC2311w) this.f4353b).clear();
                break;
            case 3:
                ((ConcurrentMapC2179c4) this.f4353b).clear();
                break;
            default:
                ((AbstractMap) this.f4353b).clear();
                break;
        }
    }

    @Override
    public boolean contains(Object obj) {
        switch (this.f4352a) {
            case 0:
                return ((ConcurrentMapC1404b0) this.f4353b).containsValue(obj);
            case 1:
            default:
                return super.contains(obj);
            case 2:
                return ((AbstractC2311w) this.f4353b).mo5175h(obj);
            case 3:
                return ((ConcurrentMapC2179c4) this.f4353b).containsValue(obj);
            case 4:
                return ((AbstractMap) this.f4353b).containsValue(obj);
        }
    }

    @Override
    public boolean isEmpty() {
        switch (this.f4352a) {
            case 0:
                return ((ConcurrentMapC1404b0) this.f4353b).isEmpty();
            case 1:
            case 2:
            default:
                return super.isEmpty();
            case 3:
                return ((ConcurrentMapC2179c4) this.f4353b).isEmpty();
            case 4:
                return ((AbstractMap) this.f4353b).isEmpty();
        }
    }

    @Override
    public final Iterator iterator() {
        switch (this.f4352a) {
            case 0:
                return new C1416l((ConcurrentMapC1404b0) this.f4353b, 2);
            case 1:
                C2217i0 c2217i0 = (C2217i0) this.f4353b;
                Map mapM5210c = c2217i0.m5210c();
                return mapM5210c != null ? mapM5210c.values().iterator() : new C2196f0(c2217i0, 2);
            case 2:
                return new C2200f4(((AbstractC2311w) this.f4353b).mo5108a().iterator(), 1);
            case 3:
                return new C2185d3((ConcurrentMapC2179c4) this.f4353b, 2);
            default:
                return new C2200f4(((AbstractMap) this.f4353b).entrySet().iterator(), 1);
        }
    }

    @Override
    public boolean remove(Object obj) {
        switch (this.f4352a) {
            case 2:
                ?? r10 = (AbstractC2311w) this.f4353b;
                InterfaceC1354n interfaceC1354nMo5110c = r10.mo5110c();
                Iterator it = r10.mo5111e().mo5108a().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (interfaceC1354nMo5110c.apply(entry) && AbstractC1332b.m3225p(entry.getValue(), obj)) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            case 3:
            default:
                return super.remove(obj);
            case 4:
                try {
                    return super.remove(obj);
                } catch (UnsupportedOperationException unused) {
                    AbstractMap abstractMap = (AbstractMap) this.f4353b;
                    for (Map.Entry entry2 : abstractMap.entrySet()) {
                        if (AbstractC1332b.m3225p(obj, entry2.getValue())) {
                            abstractMap.remove(entry2.getKey());
                            return true;
                        }
                    }
                    return false;
                }
        }
    }

    @Override
    public boolean removeAll(Collection collection) {
        switch (this.f4352a) {
            case 2:
                ?? r10 = (AbstractC2311w) this.f4353b;
                return AbstractC2182d0.m5162y(r10.mo5111e().mo5108a(), AbstractC1332b.m3210a(r10.mo5110c(), new C1356p(new C1357q(collection), EnumC2221i4.f7944b)));
            case 3:
            default:
                return super.removeAll(collection);
            case 4:
                try {
                    collection.getClass();
                    return super.removeAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    AbstractMap abstractMap = (AbstractMap) this.f4353b;
                    for (Map.Entry entry : abstractMap.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return abstractMap.keySet().removeAll(hashSet);
                }
        }
    }

    @Override
    public boolean retainAll(Collection collection) {
        switch (this.f4352a) {
            case 2:
                ?? r10 = (AbstractC2311w) this.f4353b;
                return AbstractC2182d0.m5162y(r10.mo5111e().mo5108a(), AbstractC1332b.m3210a(r10.mo5110c(), new C1356p(new C1360t(new C1357q(collection)), EnumC2221i4.f7944b)));
            case 3:
            default:
                return super.retainAll(collection);
            case 4:
                try {
                    collection.getClass();
                    return super.retainAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    AbstractMap abstractMap = (AbstractMap) this.f4353b;
                    for (Map.Entry entry : abstractMap.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return abstractMap.keySet().retainAll(hashSet);
                }
        }
    }

    @Override
    public final int size() {
        switch (this.f4352a) {
            case 0:
                return ((ConcurrentMapC1404b0) this.f4353b).size();
            case 1:
                return ((C2217i0) this.f4353b).size();
            case 2:
                return ((AbstractC2311w) this.f4353b).size();
            case 3:
                return ((ConcurrentMapC2179c4) this.f4353b).size();
            default:
                return ((AbstractMap) this.f4353b).size();
        }
    }

    public C1427w(InterfaceC2183d1 interfaceC2183d1) {
        this.f4352a = 2;
        this.f4353b = (AbstractC2311w) interfaceC2183d1;
    }

    public C1427w(AbstractMap abstractMap) {
        this.f4352a = 4;
        abstractMap.getClass();
        this.f4353b = abstractMap;
    }
}

package p041d7;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import p020b7.AbstractC1332b;
import p160p.C3339c;
import p160p.C3341e;

public final class C2203g0 extends AbstractSet {

    public final int f7903a;

    public final Map f7904b;

    public C2203g0(Map map, int i6) {
        this.f7903a = i6;
        this.f7904b = map;
    }

    @Override
    public void clear() {
        switch (this.f7903a) {
            case 0:
                ((C2217i0) this.f7904b).clear();
                break;
            case 1:
                ((C2217i0) this.f7904b).clear();
                break;
            default:
                super.clear();
                break;
        }
    }

    @Override
    public boolean contains(Object obj) {
        switch (this.f7903a) {
            case 0:
                C2217i0 c2217i0 = (C2217i0) this.f7904b;
                Map mapM5210c = c2217i0.m5210c();
                if (mapM5210c != null) {
                    return mapM5210c.entrySet().contains(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int iM5212e = c2217i0.m5212e(entry.getKey());
                    if (iM5212e != -1 && AbstractC1332b.m3225p(c2217i0.m5218k()[iM5212e], entry.getValue())) {
                        return true;
                    }
                }
                return false;
            case 1:
                return ((C2217i0) this.f7904b).containsKey(obj);
            default:
                return super.contains(obj);
        }
    }

    @Override
    public final Iterator iterator() {
        switch (this.f7903a) {
            case 0:
                C2217i0 c2217i0 = (C2217i0) this.f7904b;
                Map mapM5210c = c2217i0.m5210c();
                return mapM5210c != null ? mapM5210c.entrySet().iterator() : new C2196f0(c2217i0, 1);
            case 1:
                C2217i0 c2217i1 = (C2217i0) this.f7904b;
                Map mapM5210c2 = c2217i1.m5210c();
                return mapM5210c2 != null ? mapM5210c2.keySet().iterator() : new C2196f0(c2217i1, 0);
            default:
                return new C3339c((C3341e) this.f7904b);
        }
    }

    @Override
    public boolean remove(Object obj) {
        switch (this.f7903a) {
            case 0:
                C2217i0 c2217i0 = (C2217i0) this.f7904b;
                Map mapM5210c = c2217i0.m5210c();
                if (mapM5210c != null) {
                    return mapM5210c.entrySet().remove(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (!c2217i0.m5214g()) {
                        int iM5211d = c2217i0.m5211d();
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        Object obj2 = c2217i0.f7933a;
                        Objects.requireNonNull(obj2);
                        int iM5160w = AbstractC2182d0.m5160w(key, value, iM5211d, obj2, c2217i0.m5216i(), c2217i0.m5217j(), c2217i0.m5218k());
                        if (iM5160w != -1) {
                            c2217i0.m5213f(iM5160w, iM5211d);
                            c2217i0.f7938f--;
                            c2217i0.f7937e += 32;
                            return true;
                        }
                    }
                }
                return false;
            case 1:
                C2217i0 c2217i1 = (C2217i0) this.f7904b;
                Map mapM5210c2 = c2217i1.m5210c();
                if (mapM5210c2 != null) {
                    return mapM5210c2.keySet().remove(obj);
                }
                return c2217i1.m5215h(obj) != C2217i0.f7932j;
            default:
                return super.remove(obj);
        }
    }

    @Override
    public final int size() {
        switch (this.f7903a) {
            case 0:
                return ((C2217i0) this.f7904b).size();
            case 1:
                return ((C2217i0) this.f7904b).size();
            default:
                return ((C3341e) this.f7904b).f11334c;
        }
    }
}

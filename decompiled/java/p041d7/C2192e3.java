package p041d7;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public final class C2192e3 extends AbstractSet {

    public final int f7881a;

    public final ConcurrentMapC2179c4 f7882b;

    public C2192e3(ConcurrentMapC2179c4 concurrentMapC2179c4, int i6) {
        this.f7881a = i6;
        this.f7882b = concurrentMapC2179c4;
    }

    @Override
    public final void clear() {
        switch (this.f7881a) {
            case 0:
                this.f7882b.clear();
                break;
            default:
                this.f7882b.clear();
                break;
        }
    }

    @Override
    public final boolean contains(Object obj) {
        Map.Entry entry;
        Object key;
        ConcurrentMapC2179c4 concurrentMapC2179c4;
        Object obj2;
        switch (this.f7881a) {
            case 0:
                return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = (concurrentMapC2179c4 = this.f7882b).get(key)) != null && concurrentMapC2179c4.f7858f.mo5183d().mo5220a().m3238c(entry.getValue(), obj2);
            default:
                return this.f7882b.containsKey(obj);
        }
    }

    @Override
    public final boolean isEmpty() {
        switch (this.f7881a) {
            case 0:
                break;
        }
        return this.f7882b.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        switch (this.f7881a) {
            case 0:
                return new C2185d3(this.f7882b, 0);
            default:
                return new C2185d3(this.f7882b, 1);
        }
    }

    @Override
    public final boolean remove(Object obj) {
        Map.Entry entry;
        Object key;
        switch (this.f7881a) {
            case 0:
                return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && this.f7882b.remove(key, entry.getValue());
            default:
                return this.f7882b.remove(obj) != null;
        }
    }

    @Override
    public final int size() {
        switch (this.f7881a) {
            case 0:
                break;
        }
        return this.f7882b.size();
    }
}

package p029c7;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public final class C1417m extends AbstractSet {

    public final ConcurrentMapC1404b0 f4308a;

    public final int f4309b;

    public final ConcurrentMapC1404b0 f4310c;

    public C1417m(ConcurrentMapC1404b0 concurrentMapC1404b0, int i6) {
        this.f4309b = i6;
        this.f4310c = concurrentMapC1404b0;
        this.f4308a = concurrentMapC1404b0;
    }

    @Override
    public final void clear() {
        this.f4308a.clear();
    }

    @Override
    public final boolean contains(Object obj) {
        Map.Entry entry;
        Object key;
        ConcurrentMapC1404b0 concurrentMapC1404b0;
        Object obj2;
        switch (this.f4309b) {
            case 0:
                return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = (concurrentMapC1404b0 = this.f4310c).get(key)) != null && concurrentMapC1404b0.f4279f.m3238c(entry.getValue(), obj2);
            default:
                return this.f4310c.containsKey(obj);
        }
    }

    @Override
    public final boolean isEmpty() {
        return this.f4308a.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        switch (this.f4309b) {
            case 0:
                return new C1416l(this.f4310c, 0);
            default:
                return new C1416l(this.f4310c, 1);
        }
    }

    @Override
    public final boolean remove(Object obj) {
        Map.Entry entry;
        Object key;
        switch (this.f4309b) {
            case 0:
                return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && this.f4310c.remove(key, entry.getValue());
            default:
                return this.f4310c.remove(obj) != null;
        }
    }

    @Override
    public final int size() {
        return this.f4308a.size();
    }
}

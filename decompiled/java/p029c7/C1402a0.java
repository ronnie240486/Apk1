package p029c7;

import java.util.Map;

public final class C1402a0 implements Map.Entry {

    public final Object f4267a;

    public Object f4268b;

    public final ConcurrentMapC1404b0 f4269c;

    public C1402a0(ConcurrentMapC1404b0 concurrentMapC1404b0, Object obj, Object obj2) {
        this.f4269c = concurrentMapC1404b0;
        this.f4267a = obj;
        this.f4268b = obj2;
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.f4267a.equals(entry.getKey()) && this.f4268b.equals(entry.getValue());
    }

    @Override
    public final Object getKey() {
        return this.f4267a;
    }

    @Override
    public final Object getValue() {
        return this.f4268b;
    }

    @Override
    public final int hashCode() {
        return this.f4267a.hashCode() ^ this.f4268b.hashCode();
    }

    @Override
    public final Object setValue(Object obj) {
        Object objPut = this.f4269c.put(this.f4267a, obj);
        this.f4268b = obj;
        return objPut;
    }

    public final String toString() {
        return this.f4267a + "=" + this.f4268b;
    }
}

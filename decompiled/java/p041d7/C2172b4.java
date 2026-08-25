package p041d7;

import java.util.Map;

public final class C2172b4 extends AbstractC2293t {

    public final Object f7837a;

    public Object f7838b;

    public final ConcurrentMapC2179c4 f7839c;

    public C2172b4(ConcurrentMapC2179c4 concurrentMapC2179c4, Object obj, Object obj2) {
        this.f7839c = concurrentMapC2179c4;
        this.f7837a = obj;
        this.f7838b = obj2;
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.f7837a.equals(entry.getKey()) && this.f7838b.equals(entry.getValue());
    }

    @Override
    public final Object getKey() {
        return this.f7837a;
    }

    @Override
    public final Object getValue() {
        return this.f7838b;
    }

    @Override
    public final int hashCode() {
        return this.f7837a.hashCode() ^ this.f7838b.hashCode();
    }

    @Override
    public final Object setValue(Object obj) {
        Object objPut = this.f7839c.put(this.f7837a, obj);
        this.f7838b = obj;
        return objPut;
    }
}

package p041d7;

import java.util.Map;

public final class C2194e5 extends AbstractC2233k2 {

    public final transient AbstractC2331z1 f7884d;

    public final transient Object[] f7885e;

    public final transient int f7886f;

    public C2194e5(AbstractC2331z1 abstractC2331z1, Object[] objArr, int i6) {
        this.f7884d = abstractC2331z1;
        this.f7885e = objArr;
        this.f7886f = i6;
    }

    @Override
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        return value != null && value.equals(this.f7884d.get(key));
    }

    @Override
    public final int mo5123d(Object[] objArr, int i6) {
        return mo5167c().mo5123d(objArr, i6);
    }

    @Override
    public final boolean mo5127h() {
        return true;
    }

    @Override
    public final AbstractC2292s5 iterator() {
        return mo5167c().listIterator(0);
    }

    @Override
    public final AbstractC2301u1 mo5169m() {
        return new C2187d5(this);
    }

    @Override
    public final int size() {
        return this.f7886f;
    }
}

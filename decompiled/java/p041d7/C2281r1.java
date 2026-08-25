package p041d7;

import java.io.Serializable;

public final class C2281r1 extends AbstractC2293t implements Serializable {

    public final Object f8038a;

    public final Object f8039b;

    public C2281r1(Object obj, Object obj2) {
        this.f8038a = obj;
        this.f8039b = obj2;
    }

    @Override
    public final Object getKey() {
        return this.f8038a;
    }

    @Override
    public final Object getValue() {
        return this.f8039b;
    }

    @Override
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}

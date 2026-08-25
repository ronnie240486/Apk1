package p041d7;

import java.util.Map;
import p020b7.AbstractC1332b;

public final class C2210h0 extends AbstractC2293t {

    public final Object f7913a;

    public int f7914b;

    public final C2217i0 f7915c;

    public C2210h0(C2217i0 c2217i0, int i6) {
        this.f7915c = c2217i0;
        Object obj = C2217i0.f7932j;
        this.f7913a = c2217i0.m5217j()[i6];
        this.f7914b = i6;
    }

    public final void m5191a() {
        int i6 = this.f7914b;
        Object obj = this.f7913a;
        C2217i0 c2217i0 = this.f7915c;
        if (i6 != -1 && i6 < c2217i0.size()) {
            if (AbstractC1332b.m3225p(obj, c2217i0.m5217j()[this.f7914b])) {
                return;
            }
        }
        Object obj2 = C2217i0.f7932j;
        this.f7914b = c2217i0.m5212e(obj);
    }

    @Override
    public final Object getKey() {
        return this.f7913a;
    }

    @Override
    public final Object getValue() {
        C2217i0 c2217i0 = this.f7915c;
        Map mapM5210c = c2217i0.m5210c();
        if (mapM5210c != null) {
            return mapM5210c.get(this.f7913a);
        }
        m5191a();
        int i6 = this.f7914b;
        if (i6 == -1) {
            return null;
        }
        return c2217i0.m5218k()[i6];
    }

    @Override
    public final Object setValue(Object obj) {
        C2217i0 c2217i0 = this.f7915c;
        Map mapM5210c = c2217i0.m5210c();
        Object obj2 = this.f7913a;
        if (mapM5210c != null) {
            return mapM5210c.put(obj2, obj);
        }
        m5191a();
        int i6 = this.f7914b;
        if (i6 == -1) {
            c2217i0.put(obj2, obj);
            return null;
        }
        Object obj3 = c2217i0.m5218k()[i6];
        c2217i0.m5218k()[this.f7914b] = obj;
        return obj3;
    }
}

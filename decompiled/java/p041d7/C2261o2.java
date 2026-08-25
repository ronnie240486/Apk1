package p041d7;

import java.util.Collection;
import java.util.Map;

public final class C2261o2 extends AbstractC2301u1 {

    public final C2219i2 f8014c;

    public C2261o2(C2219i2 c2219i2) {
        this.f8014c = c2219i2;
    }

    @Override
    public final Object get(int i6) {
        Map.Entry entry = (Map.Entry) this.f8014c.f7942d.f7880d.f7907f.entrySet().mo5167c().get(i6);
        return new C2334z4(((Collection) entry.getValue()).size(), entry.getKey());
    }

    @Override
    public final boolean mo5127h() {
        return this.f8014c.mo5127h();
    }

    @Override
    public final int size() {
        return this.f8014c.size();
    }
}

package p041d7;

import java.util.Collection;
import java.util.Map;

public final class C2298t4 extends AbstractC2316w4 {

    public final Map.Entry f8065a;

    public C2298t4(Map.Entry entry) {
        this.f8065a = entry;
    }

    @Override
    public final int mo5264a() {
        return ((Collection) this.f8065a.getValue()).size();
    }

    @Override
    public final Object mo5265b() {
        return this.f8065a.getKey();
    }
}

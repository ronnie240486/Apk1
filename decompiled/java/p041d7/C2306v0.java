package p041d7;

import java.util.Collection;
import java.util.Map;
import p020b7.InterfaceC1354n;

public final class C2306v0 implements InterfaceC1354n {

    public final Object f8074a;

    @Override
    public final boolean apply(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        return this.f8074a.apply(new C2334z4(((Collection) entry.getValue()).size(), entry.getKey()));
    }
}

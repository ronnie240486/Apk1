package p041d7;

import java.util.Iterator;
import java.util.Map;
import p020b7.InterfaceC1346i;

public final class C2282r2 extends AbstractC2285r5 {

    public final int f8040b = 1;

    public final Object f8041c;

    public C2282r2(Iterator it, InterfaceC1346i interfaceC1346i) {
        super(it);
        this.f8041c = interfaceC1346i;
    }

    @Override
    public final Object mo5172a(Object obj) {
        switch (this.f8040b) {
            case 0:
                return ((InterfaceC1346i) this.f8041c).apply(obj);
            default:
                return new C2235k4(this, (Map.Entry) obj);
        }
    }

    public C2282r2(C2162a1 c2162a1, Iterator it) {
        super(it);
        this.f8041c = c2162a1;
    }
}

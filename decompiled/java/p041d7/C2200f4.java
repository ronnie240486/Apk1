package p041d7;

import java.util.Iterator;
import java.util.Map;

public final class C2200f4 extends AbstractC2285r5 {

    public final int f7898b;

    public C2200f4(Iterator it, int i6) {
        super(it);
        this.f7898b = i6;
    }

    @Override
    public final Object mo5172a(Object obj) {
        switch (this.f7898b) {
            case 0:
                return ((Map.Entry) obj).getKey();
            case 1:
                return ((Map.Entry) obj).getValue();
            default:
                return new C2298t4((Map.Entry) obj);
        }
    }
}

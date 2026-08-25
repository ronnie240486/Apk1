package p016b3;

import java.util.ArrayDeque;
import p186r3.C3606j;

public final class C1285r extends C3606j {
    @Override
    public final void mo3169c(Object obj, Object obj2) {
        C1286s c1286s = (C1286s) obj;
        c1286s.getClass();
        ArrayDeque arrayDeque = C1286s.f4050b;
        synchronized (arrayDeque) {
            arrayDeque.offer(c1286s);
        }
    }
}

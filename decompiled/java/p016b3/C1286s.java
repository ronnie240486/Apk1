package p016b3;

import java.util.ArrayDeque;
import p186r3.AbstractC3610n;

public final class C1286s {

    public static final ArrayDeque f4050b;

    public Object f4051a;

    static {
        char[] cArr = AbstractC3610n.f12112a;
        f4050b = new ArrayDeque(0);
    }

    public static C1286s m3170a(Object obj) {
        C1286s c1286s;
        ArrayDeque arrayDeque = f4050b;
        synchronized (arrayDeque) {
            c1286s = (C1286s) arrayDeque.poll();
        }
        if (c1286s == null) {
            c1286s = new C1286s();
        }
        c1286s.f4051a = obj;
        return c1286s;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1286s)) {
            return false;
        }
        C1286s c1286s = (C1286s) obj;
        c1286s.getClass();
        return this.f4051a.equals(c1286s.f4051a);
    }

    public final int hashCode() {
        return this.f4051a.hashCode();
    }
}

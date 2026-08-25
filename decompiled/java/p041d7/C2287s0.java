package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1354n;
import p215u.AbstractC3885h;

public final class C2287s0 extends AbstractC2292s5 {

    public int f8047a;

    public Object f8048b;

    public final int f8049c;

    public final Iterator f8050d;

    public final Object f8051e;

    public C2287s0() {
        this.f8047a = 2;
    }

    @Override
    public final boolean hasNext() {
        Object c2281r1;
        AbstractC1332b.m3224o(this.f8047a != 4);
        int iM7785a = AbstractC3885h.m7785a(this.f8047a);
        if (iM7785a == 0) {
            return true;
        }
        if (iM7785a == 2) {
            return false;
        }
        this.f8047a = 4;
        switch (this.f8049c) {
            case 0:
                while (true) {
                    Iterator it = this.f8050d;
                    if (!it.hasNext()) {
                        this.f8047a = 3;
                        c2281r1 = null;
                        break;
                    } else {
                        Map.Entry entry = (Map.Entry) it.next();
                        Object key = entry.getKey();
                        C2189e0 c2189e0M5289o = C2324y0.m5289o((Collection) entry.getValue(), new C2318x0(((C2300u0) ((C2181d) this.f8051e).f7866c).f8068d, key));
                        if (!c2189e0M5289o.isEmpty()) {
                            c2281r1 = new C2281r1(key, c2189e0M5289o);
                            break;
                        }
                    }
                }
                break;
            case 1:
                do {
                    Iterator it2 = this.f8050d;
                    if (!it2.hasNext()) {
                        this.f8047a = 3;
                        c2281r1 = null;
                    } else {
                        c2281r1 = it2.next();
                    }
                    break;
                } while (!((InterfaceC1354n) this.f8051e).apply(c2281r1));
                break;
            default:
                do {
                    Iterator it3 = this.f8050d;
                    if (!it3.hasNext()) {
                        this.f8047a = 3;
                        c2281r1 = null;
                    } else {
                        c2281r1 = it3.next();
                    }
                    break;
                } while (!((C2250m5) this.f8051e).f8002b.contains(c2281r1));
                break;
        }
        this.f8048b = c2281r1;
        if (this.f8047a == 3) {
            return false;
        }
        this.f8047a = 1;
        return true;
    }

    @Override
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f8047a = 2;
        Object obj = this.f8048b;
        this.f8048b = null;
        return obj;
    }

    public C2287s0(C2181d c2181d) {
        this();
        this.f8049c = 0;
        this.f8051e = c2181d;
        this.f8050d = ((C2300u0) c2181d.f7866c).f8068d.f8100f.mo5173d().entrySet().iterator();
    }

    public C2287s0(Iterator it, InterfaceC1354n interfaceC1354n) {
        this();
        this.f8049c = 1;
        this.f8050d = it;
        this.f8051e = interfaceC1354n;
    }

    public C2287s0(C2250m5 c2250m5) {
        this();
        this.f8049c = 2;
        this.f8051e = c2250m5;
        this.f8050d = c2250m5.f8001a.iterator();
    }
}

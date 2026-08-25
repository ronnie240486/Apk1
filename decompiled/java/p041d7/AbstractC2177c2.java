package p041d7;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.LinkedHashMap;
import p186r3.AbstractC3610n;
import p259y2.InterfaceC4245h;

public abstract class AbstractC2177c2 {

    public Serializable f7850a;

    public AbstractC2177c2(int i6) {
        switch (i6) {
            case 2:
                char[] cArr = AbstractC3610n.f12112a;
                this.f7850a = new ArrayDeque(20);
                break;
            default:
                this.f7850a = new LinkedHashMap();
                break;
        }
    }

    public int mo5117a(Iterable iterable) {
        if (iterable instanceof Collection) {
            return Math.max(4, ((Collection) iterable).size());
        }
        return 4;
    }

    public AbstractC2267p1 mo5118b(int i6) {
        return AbstractC2301u1.m5270l(i6);
    }

    public void m5119c(InterfaceC4245h interfaceC4245h) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f7850a;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(interfaceC4245h);
        }
    }

    public AbstractC2177c2 mo5120d(Object obj, Object obj2) {
        AbstractC2182d0.m5140c(obj, obj2);
        C2217i0 c2217i0M5208a = (C2217i0) this.f7850a;
        if (c2217i0M5208a == null) {
            c2217i0M5208a = C2217i0.m5208a();
            this.f7850a = c2217i0M5208a;
        }
        AbstractC2267p1 abstractC2267p1Mo5118b = (AbstractC2267p1) c2217i0M5208a.get(obj);
        if (abstractC2267p1Mo5118b == null) {
            abstractC2267p1Mo5118b = mo5118b(4);
            C2217i0 c2217i0M5208a2 = (C2217i0) this.f7850a;
            if (c2217i0M5208a2 == null) {
                c2217i0M5208a2 = C2217i0.m5208a();
                this.f7850a = c2217i0M5208a2;
            }
            c2217i0M5208a2.put(obj, abstractC2267p1Mo5118b);
        }
        abstractC2267p1Mo5118b.mo5221b(obj2);
        return this;
    }
}

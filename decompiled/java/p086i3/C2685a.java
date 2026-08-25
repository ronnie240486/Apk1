package p086i3;

import java.util.ArrayDeque;
import p186r3.AbstractC3610n;
import p208t2.C3802c;
import p269z2.C4301b;

public final class C2685a {

    public final ArrayDeque f9327a;

    public C2685a(int i6) {
        switch (i6) {
            case 1:
                this.f9327a = new ArrayDeque();
                break;
            default:
                char[] cArr = AbstractC3610n.f12112a;
                this.f9327a = new ArrayDeque(0);
                break;
        }
    }

    public C4301b m5685a() {
        C4301b c4301b;
        synchronized (this.f9327a) {
            c4301b = (C4301b) this.f9327a.poll();
        }
        return c4301b == null ? new C4301b() : c4301b;
    }

    public void m5686b(C4301b c4301b) {
        synchronized (this.f9327a) {
            try {
                if (this.f9327a.size() < 10) {
                    this.f9327a.offer(c4301b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void m5687c(C3802c c3802c) {
        c3802c.f12818b = null;
        c3802c.f12819c = null;
        this.f9327a.offer(c3802c);
    }
}

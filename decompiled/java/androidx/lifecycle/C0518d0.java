package androidx.lifecycle;

import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import java.util.Map;
import p000a.AbstractC0004e;
import p000a.RunnableC0005f;
import p117l.C2946a;
import p127m.C3021c;
import p127m.C3022d;
import p127m.C3024f;

public class C0518d0 {

    public static final Object f2471k = new Object();

    public final Object f2472a = new Object();

    public final C3024f f2473b = new C3024f();

    public int f2474c = 0;

    public boolean f2475d;

    public volatile Object f2476e;

    public volatile Object f2477f;

    public int f2478g;

    public boolean f2479h;

    public boolean f2480i;

    public final RunnableC0005f f2481j;

    public C0518d0() {
        Object obj = f2471k;
        this.f2477f = obj;
        this.f2481j = new RunnableC0005f(5, this);
        this.f2476e = obj;
        this.f2478g = -1;
    }

    public static void m1481a(String str) {
        C2946a.m5967V().f10115r.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(AbstractC0004e.m24r("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void m1482b(AbstractC0516c0 abstractC0516c0) {
        if (abstractC0516c0.f2465b) {
            if (!abstractC0516c0.mo1474i()) {
                abstractC0516c0.m1478d(false);
                return;
            }
            int i6 = abstractC0516c0.f2466c;
            int i10 = this.f2478g;
            if (i6 >= i10) {
                return;
            }
            abstractC0516c0.f2466c = i10;
            abstractC0516c0.f2464a.mo1200c(this.f2476e);
        }
    }

    public final void m1483c(AbstractC0516c0 abstractC0516c0) {
        if (this.f2479h) {
            this.f2480i = true;
            return;
        }
        this.f2479h = true;
        do {
            this.f2480i = false;
            if (abstractC0516c0 != null) {
                m1482b(abstractC0516c0);
                abstractC0516c0 = null;
            } else {
                C3024f c3024f = this.f2473b;
                c3024f.getClass();
                C3022d c3022d = new C3022d(c3024f);
                c3024f.f10352c.put(c3022d, Boolean.FALSE);
                while (c3022d.hasNext()) {
                    m1482b((AbstractC0516c0) ((Map.Entry) c3022d.next()).getValue());
                    if (this.f2480i) {
                        break;
                    }
                }
            }
        } while (this.f2480i);
        this.f2479h = false;
    }

    public final Object m1484d() {
        Object obj = this.f2476e;
        if (obj != f2471k) {
            return obj;
        }
        return null;
    }

    public final void m1485e(FragmentActivity fragmentActivity, InterfaceC0520e0 interfaceC0520e0) {
        Object obj;
        m1481a("observe");
        if (fragmentActivity.f228d.f2553d == EnumC0539o.f2507a) {
            return;
        }
        C0514b0 c0514b0 = new C0514b0(this, fragmentActivity, interfaceC0520e0);
        C3024f c3024f = this.f2473b;
        C3021c c3021cMo6095c = c3024f.mo6095c(interfaceC0520e0);
        if (c3021cMo6095c != null) {
            obj = c3021cMo6095c.f10344b;
        } else {
            C3021c c3021c = new C3021c(interfaceC0520e0, c0514b0);
            c3024f.f10353d++;
            C3021c c3021c2 = c3024f.f10351b;
            if (c3021c2 == null) {
                c3024f.f10350a = c3021c;
                c3024f.f10351b = c3021c;
            } else {
                c3021c2.f10345c = c3021c;
                c3021c.f10346d = c3021c2;
                c3024f.f10351b = c3021c;
            }
            obj = null;
        }
        AbstractC0516c0 abstractC0516c0 = (AbstractC0516c0) obj;
        if (abstractC0516c0 != null && !abstractC0516c0.mo1477h(fragmentActivity)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC0516c0 != null) {
            return;
        }
        fragmentActivity.f228d.mo1508a(c0514b0);
    }

    public final void m1488h(Object obj) {
        boolean z7;
        synchronized (this.f2472a) {
            z7 = this.f2477f == f2471k;
            this.f2477f = obj;
        }
        if (z7) {
            C2946a.m5967V().m5968W(this.f2481j);
        }
    }

    public void mo1489i(InterfaceC0520e0 interfaceC0520e0) {
        m1481a("removeObserver");
        AbstractC0516c0 abstractC0516c0 = (AbstractC0516c0) this.f2473b.mo6096d(interfaceC0520e0);
        if (abstractC0516c0 == null) {
            return;
        }
        abstractC0516c0.mo1476g();
        abstractC0516c0.m1478d(false);
    }

    public void m1490j(Object obj) {
        m1481a("setValue");
        this.f2478g++;
        this.f2476e = obj;
        m1483c(null);
    }

    public void m1486f() {
    }

    public void m1487g() {
    }
}

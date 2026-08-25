package p225v;

import java.util.HashSet;
import java.util.Iterator;
import p055ea.AbstractC2460q;
import p215u.AbstractC3885h;
import p215u.C3886i;

public final class C3956c {

    public final C3958e f13313b;

    public final int f13314c;

    public C3956c f13315d;

    public C3886i f13318g;

    public HashSet f13312a = null;

    public int f13316e = 0;

    public int f13317f = -1;

    public C3956c(C3958e c3958e, int i6) {
        this.f13313b = c3958e;
        this.f13314c = i6;
    }

    public final void m7885a(C3956c c3956c, int i6) {
        m7886b(c3956c, i6, -1, false);
    }

    public final boolean m7886b(C3956c c3956c, int i6, int i10, boolean z7) {
        if (c3956c == null) {
            m7892h();
            return true;
        }
        if (!z7 && !m7891g(c3956c)) {
            return false;
        }
        this.f13315d = c3956c;
        if (c3956c.f13312a == null) {
            c3956c.f13312a = new HashSet();
        }
        this.f13315d.f13312a.add(this);
        if (i6 > 0) {
            this.f13316e = i6;
        } else {
            this.f13316e = 0;
        }
        this.f13317f = i10;
        return true;
    }

    public final int m7887c() {
        C3956c c3956c;
        if (this.f13313b.f13347X == 8) {
            return 0;
        }
        int i6 = this.f13317f;
        return (i6 <= -1 || (c3956c = this.f13315d) == null || c3956c.f13313b.f13347X != 8) ? this.f13316e : i6;
    }

    public final C3956c m7888d() {
        int i6 = this.f13314c;
        int iM7785a = AbstractC3885h.m7785a(i6);
        C3958e c3958e = this.f13313b;
        switch (iM7785a) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return c3958e.f13324A;
            case 2:
                return c3958e.f13325B;
            case 3:
                return c3958e.f13380y;
            case 4:
                return c3958e.f13381z;
            default:
                throw new AssertionError(AbstractC2460q.m5502p(i6));
        }
    }

    public final boolean m7889e() {
        HashSet hashSet = this.f13312a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((C3956c) it.next()).m7888d().m7890f()) {
                return true;
            }
        }
        return false;
    }

    public final boolean m7890f() {
        return this.f13315d != null;
    }

    public final boolean m7891g(C3956c c3956c) {
        if (c3956c == null) {
            return false;
        }
        int i6 = this.f13314c;
        C3958e c3958e = c3956c.f13313b;
        int i10 = c3956c.f13314c;
        if (i10 == i6) {
            return i6 != 6 || (c3958e.f13378w && this.f13313b.f13378w);
        }
        switch (AbstractC3885h.m7785a(i6)) {
            case 0:
            case 5:
            case 7:
            case 8:
                return false;
            case 1:
            case 3:
                boolean z7 = i10 == 2 || i10 == 4;
                if (c3958e instanceof C3962i) {
                    return z7 || i10 == 8;
                }
                return z7;
            case 2:
            case 4:
                boolean z10 = i10 == 3 || i10 == 5;
                if (c3958e instanceof C3962i) {
                    return z10 || i10 == 9;
                }
                return z10;
            case 6:
                return (i10 == 6 || i10 == 8 || i10 == 9) ? false : true;
            default:
                throw new AssertionError(AbstractC2460q.m5502p(i6));
        }
    }

    public final void m7892h() {
        HashSet hashSet;
        C3956c c3956c = this.f13315d;
        if (c3956c != null && (hashSet = c3956c.f13312a) != null) {
            hashSet.remove(this);
        }
        this.f13315d = null;
        this.f13316e = 0;
        this.f13317f = -1;
    }

    public final void m7893i() {
        C3886i c3886i = this.f13318g;
        if (c3886i == null) {
            this.f13318g = new C3886i(1);
        } else {
            c3886i.m7788c();
        }
    }

    public final String toString() {
        return this.f13313b.f13348Y + ":" + AbstractC2460q.m5502p(this.f13314c);
    }
}

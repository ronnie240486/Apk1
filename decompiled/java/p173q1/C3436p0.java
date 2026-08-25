package p173q1;

import java.util.ArrayList;
import java.util.Iterator;
import p000a.AbstractC0004e;
import p160p.C3341e;

public final class C3436p0 extends C3445s0 {

    public final ArrayList f11620w;

    public final C3341e f11621x;

    public C3436p0(C3442r0 c3442r0, String str, String str2) {
        super(c3442r0, str, str2, false);
        this.f11620w = new ArrayList();
        this.f11621x = new C3341e(0);
    }

    public final boolean m7013n() {
        C3451u0.m7067b();
        C3411h c3411hM7068c = C3451u0.m7068c();
        c3411hM7068c.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = c3411hM7068c.f11497j.values().iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
        return arrayList.contains(this);
    }

    public final boolean m7014o(C3445s0 c3445s0) {
        C3460z c3460z = (C3460z) this.f11621x.get(c3445s0.f11654c);
        return c3460z != null && c3460z.f11722d;
    }

    public final void m7015p(ArrayList arrayList) {
        C3445s0 c3445s0;
        this.f11673v.clear();
        ArrayList arrayList2 = this.f11620w;
        arrayList2.clear();
        C3341e c3341e = this.f11621x;
        c3341e.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C3460z c3460z = (C3460z) it.next();
            String strM7089f = c3460z.f11719a.m7089f();
            Iterator it2 = this.f11652a.f11644b.iterator();
            do {
                if (!it2.hasNext()) {
                    c3445s0 = null;
                    break;
                }
                c3445s0 = (C3445s0) it2.next();
            } while (!c3445s0.f11653b.equals(strM7089f));
            if (c3445s0 != null) {
                arrayList2.add(c3445s0);
                c3341e.put(c3445s0.f11654c, c3460z);
                int i6 = c3460z.f11720b;
                if (i6 == 2 || i6 == 3) {
                    this.f11673v.add(c3445s0);
                }
            }
        }
        C3451u0.m7068c().f11488a.m6886b(259, this);
    }
}

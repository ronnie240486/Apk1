package p186r3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class C3606j {

    public final LinkedHashMap f12104a = new LinkedHashMap(100, 0.75f, true);

    public final long f12105b;

    public long f12106c;

    public C3606j(long j10) {
        this.f12105b = j10;
    }

    public final synchronized Object m7227a(Object obj) {
        C3605i c3605i;
        c3605i = (C3605i) this.f12104a.get(obj);
        return c3605i != null ? c3605i.f12102a : null;
    }

    public int mo7228b(Object obj) {
        return 1;
    }

    public final synchronized Object m7229d(Object obj, Object obj2) {
        int iMo7228b = mo7228b(obj2);
        long j10 = iMo7228b;
        if (j10 >= this.f12105b) {
            mo3169c(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.f12106c += j10;
        }
        C3605i c3605i = (C3605i) this.f12104a.put(obj, obj2 == null ? null : new C3605i(iMo7228b, obj2));
        if (c3605i != null) {
            this.f12106c -= (long) c3605i.f12103b;
            if (!c3605i.f12102a.equals(obj2)) {
                mo3169c(obj, c3605i.f12102a);
            }
        }
        m7230e(this.f12105b);
        return c3605i != null ? c3605i.f12102a : null;
    }

    public final synchronized void m7230e(long j10) {
        while (this.f12106c > j10) {
            Iterator it = this.f12104a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            C3605i c3605i = (C3605i) entry.getValue();
            this.f12106c -= (long) c3605i.f12103b;
            Object key = entry.getKey();
            it.remove();
            mo3169c(key, c3605i.f12102a);
        }
    }

    public void mo3169c(Object obj, Object obj2) {
    }
}

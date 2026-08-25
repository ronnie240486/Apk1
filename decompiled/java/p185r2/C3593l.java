package p185r2;

import android.os.SystemClock;
import p048e2.C2376k;
import p140n2.C3176a;
import p140n2.C3183h;
import p187r4.AbstractC3612b;

public final class C3593l implements InterfaceC3590i {

    public static final C3593l f12081a = new C3593l();

    public static C2376k f12082b;

    @Override
    public boolean mo7213a(C3183h c3183h) {
        AbstractC3612b abstractC3612b = c3183h.f10678a;
        if ((abstractC3612b instanceof C3176a ? ((C3176a) abstractC3612b).f10667c : Integer.MAX_VALUE) > 100) {
            AbstractC3612b abstractC3612b2 = c3183h.f10679b;
            if ((abstractC3612b2 instanceof C3176a ? ((C3176a) abstractC3612b2).f10667c : Integer.MAX_VALUE) > 100) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean mo7214b() {
        boolean z7;
        synchronized (C3589h.f12070a) {
            try {
                int i6 = C3589h.f12072c;
                C3589h.f12072c = i6 + 1;
                if (i6 >= 30 || SystemClock.uptimeMillis() > C3589h.f12073d + ((long) 30000)) {
                    C3589h.f12072c = 0;
                    C3589h.f12073d = SystemClock.uptimeMillis();
                    String[] list = C3589h.f12071b.list();
                    if (list == null) {
                        list = new String[0];
                    }
                    C3589h.f12074e = list.length < 800;
                }
                z7 = C3589h.f12074e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z7;
    }
}

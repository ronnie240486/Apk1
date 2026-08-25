package com.tencent.bugly.proguard;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class RunnableC2095p0 implements Runnable {

    public final int f7660a;

    public final int f7661b;

    public final C2101u f7662c;

    public RunnableC2095p0(C2101u c2101u, int i6, int i10) {
        this.f7660a = i10;
        this.f7662c = c2101u;
        this.f7661b = i6;
    }

    @Override
    public final void run() {
        C2100t c2100t;
        switch (this.f7660a) {
            case 0:
                C2101u c2101u = this.f7662c;
                try {
                    if (!TextUtils.isEmpty(c2101u.f7696d)) {
                        List<C2100t> listM5003d = c2101u.m5003d(1004);
                        if (listM5003d == null) {
                            listM5003d = new ArrayList();
                        }
                        if (c2101u.f7697e.get(1004) == null) {
                            c2101u.f7697e.put(1004, new HashMap());
                        }
                        Object obj = ((Map) c2101u.f7697e.get(1004)).get(c2101u.f7696d);
                        int i6 = this.f7661b;
                        if (obj == null) {
                            c2100t = new C2100t();
                            c2100t.f7686a = 1004;
                            c2100t.f7692g = C2101u.f7693a;
                            c2100t.f7687b = c2101u.f7696d;
                            c2100t.f7691f = C2018aa.m4509b().f7239o;
                            c2100t.f7690e = C2018aa.m4509b().f7232h;
                            c2100t.f7688c = System.currentTimeMillis();
                            c2100t.f7689d = i6;
                            ((Map) c2101u.f7697e.get(1004)).put(c2101u.f7696d, c2100t);
                        } else {
                            c2100t = (C2100t) ((Map) c2101u.f7697e.get(1004)).get(c2101u.f7696d);
                            c2100t.f7689d = i6;
                        }
                        ArrayList arrayList = new ArrayList();
                        boolean z7 = false;
                        for (C2100t c2100t2 : listM5003d) {
                            if (C2101u.m4997a(c2100t2, c2100t)) {
                                c2100t2.f7689d = c2100t.f7689d;
                                z7 = true;
                            }
                            if (C2101u.m4999b(c2100t2, c2100t)) {
                                arrayList.add(c2100t2);
                            }
                        }
                        listM5003d.removeAll(arrayList);
                        if (!z7) {
                            listM5003d.add(c2100t);
                        }
                        c2101u.m4995a(1004, listM5003d);
                    }
                } catch (Exception unused) {
                    C2029al.m4646e("saveCrashRecord failed", new Object[0]);
                    return;
                }
                break;
            default:
                C2101u c2101u2 = this.f7662c;
                int i10 = this.f7661b;
                boolean zM5002c = c2101u2.m5002c(i10);
                c2101u2.f7698f.edit().putBoolean(i10 + "_" + c2101u2.f7696d, !zM5002c).commit();
                break;
        }
    }
}

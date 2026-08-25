package com.tencent.bugly.proguard;

import com.alibaba.fastjson.JSON;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.mars.xlog.Log;
import ga.C2621d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.AbstractC3331m;
import p003a2.AbstractC0032a;

public final class C2081i0 extends Thread {

    public final int f7627a;

    public final Object f7628b;

    public C2081i0(int i6, Object obj) {
        this.f7627a = i6;
        this.f7628b = obj;
    }

    @Override
    public final void run() {
        List<CrashDetailBean> list;
        switch (this.f7627a) {
            case 0:
                C2037at c2037at = (C2037at) this.f7628b;
                if (!C2033ap.m4689a(c2037at.f7385c, "local_crash_lock")) {
                    C2029al.m4644c("Failed to lock file for uploading local crash.", new Object[0]);
                    return;
                }
                C2024ag c2024ag = C2024ag.a.f7269a;
                List<C2024ag.b> listM4596a = C2024ag.m4596a();
                if (listM4596a == null || listM4596a.isEmpty()) {
                    C2029al.m4644c("sla local data is null", new Object[0]);
                } else {
                    C2029al.m4644c("sla load local data list size:%s", Integer.valueOf(listM4596a.size()));
                    Iterator<C2024ag.b> it = listM4596a.iterator();
                    ArrayList arrayList = new ArrayList();
                    while (it.hasNext()) {
                        C2024ag.b next = it.next();
                        if (next.f7271b < C2033ap.m4695b() - 604800000) {
                            C2029al.m4644c("sla local data is expired:%s", next.f7272c);
                            arrayList.add(next);
                            it.remove();
                        }
                    }
                    C2024ag.m4599d(arrayList);
                    c2024ag.m4603b(listM4596a);
                }
                List<CrashDetailBean> listM4725a = C2036as.m4725a();
                if (listM4725a == null || listM4725a.size() <= 0) {
                    C2029al.m4644c("no crash need to be uploaded at this start", new Object[0]);
                } else {
                    C2029al.m4644c("Size of crash list: %s", Integer.valueOf(listM4725a.size()));
                    int size = listM4725a.size();
                    if (size > 20) {
                        ArrayList arrayList2 = new ArrayList();
                        Collections.sort(listM4725a);
                        for (int i6 = 0; i6 < 20; i6++) {
                            arrayList2.add(listM4725a.get((size - 1) - i6));
                        }
                        list = arrayList2;
                    } else {
                        list = listM4725a;
                    }
                    c2037at.f7386s.m4758a(list, 0L, false, false, false);
                }
                C2033ap.m4701b(c2037at.f7385c, "local_crash_lock");
                return;
            default:
                try {
                    try {
                        C2621d.f9108b = JSON.parseArray((String) this.f7628b, ChannelBean.class);
                        C2621d.m5627a();
                        break;
                    } catch (Exception e5) {
                        String strM165s = AbstractC0032a.m165s("VvZi5q/oc3V4\n", "FKUhjs6GHRA=\n");
                        String str = AbstractC0032a.m165s("VjYUT0Dg7T5HOQhZSeDqN1I2RllXsuEkBw==\n", "JldmPCXAjlY=\n") + e5.toString();
                        boolean z7 = AbstractC3331m.f11244b;
                        Log.m5049i(strM165s, str);
                    }
                    return;
                } finally {
                    Spark.f11002X1.sendEmptyMessage(20);
                }
        }
    }
}

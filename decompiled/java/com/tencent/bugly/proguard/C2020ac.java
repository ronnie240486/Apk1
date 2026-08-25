package com.tencent.bugly.proguard;

import android.content.Context;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.List;
import java.util.Map;

public final class C2020ac {

    public static int f7254a = 1000;

    public static long f7255b = 259200000;

    private static C2020ac f7256d;

    private static String f7257i;

    public final C2028ak f7258c;

    private final List<AbstractC2092o> f7259e;

    private final StrategyBean f7260f;

    private StrategyBean f7261g = null;

    private Context f7262h;

    private C2020ac(Context context, List<AbstractC2092o> list) {
        this.f7262h = context;
        if (C2018aa.m4507a(context) != null) {
            String str = C2018aa.m4507a(context).f7183H;
            if ("oversea".equals(str)) {
                StrategyBean.f7069a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.f7070b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.f7069a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.f7070b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
        this.f7260f = new StrategyBean();
        this.f7259e = list;
        this.f7258c = C2028ak.m4631a();
    }

    public static StrategyBean m4574d() {
        byte[] bArr;
        List<C2105y> listM5028a = C2103w.m5011a().m5028a(2);
        if (listM5028a == null || listM5028a.size() <= 0 || (bArr = listM5028a.get(0).f7712g) == null) {
            return null;
        }
        return (StrategyBean) C2033ap.m4674a(bArr, StrategyBean.CREATOR);
    }

    public final StrategyBean m4579c() {
        StrategyBean strategyBean = this.f7261g;
        if (strategyBean != null) {
            if (!C2033ap.m4711d(strategyBean.f7085q)) {
                this.f7261g.f7085q = StrategyBean.f7069a;
            }
            if (!C2033ap.m4711d(this.f7261g.f7086r)) {
                this.f7261g.f7086r = StrategyBean.f7070b;
            }
            return this.f7261g;
        }
        if (!C2033ap.m4703b(f7257i) && C2033ap.m4711d(f7257i)) {
            StrategyBean strategyBean2 = this.f7260f;
            String str = f7257i;
            strategyBean2.f7085q = str;
            strategyBean2.f7086r = str;
        }
        return this.f7260f;
    }

    public final synchronized boolean m4578b() {
        return this.f7261g != null;
    }

    public static synchronized C2020ac m4571a(Context context, List<AbstractC2092o> list) {
        try {
            if (f7256d == null) {
                f7256d = new C2020ac(context, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7256d;
    }

    public static synchronized C2020ac m4570a() {
        return f7256d;
    }

    public final void m4576a(StrategyBean strategyBean, boolean z7) {
        C2029al.m4644c("[Strategy] Notify %s", C2099s.class.getName());
        C2099s.m4975a(strategyBean, z7);
        for (AbstractC2092o abstractC2092o : this.f7259e) {
            try {
                C2029al.m4644c("[Strategy] Notify %s", abstractC2092o.getClass().getName());
                abstractC2092o.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void m4572a(String str) {
        if (!C2033ap.m4703b(str) && C2033ap.m4711d(str)) {
            f7257i = str;
        } else {
            C2029al.m4645d("URL user set is invalid.", new Object[0]);
        }
    }

    public final void m4577a(C2065bt c2065bt) {
        int i6;
        if (c2065bt == null) {
            return;
        }
        StrategyBean strategyBean = this.f7261g;
        if (strategyBean == null || c2065bt.f7570h != strategyBean.f7083o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f7074f = c2065bt.f7563a;
            strategyBean2.f7076h = c2065bt.f7565c;
            strategyBean2.f7075g = c2065bt.f7564b;
            if (C2033ap.m4703b(f7257i) || !C2033ap.m4711d(f7257i)) {
                if (C2033ap.m4711d(c2065bt.f7566d)) {
                    C2029al.m4644c("[Strategy] Upload url changes to %s", c2065bt.f7566d);
                    strategyBean2.f7085q = c2065bt.f7566d;
                }
                if (C2033ap.m4711d(c2065bt.f7567e)) {
                    C2029al.m4644c("[Strategy] Exception upload url changes to %s", c2065bt.f7567e);
                    strategyBean2.f7086r = c2065bt.f7567e;
                }
            }
            C2064bs c2064bs = c2065bt.f7568f;
            if (c2064bs != null && !C2033ap.m4703b(c2064bs.f7558a)) {
                strategyBean2.f7087s = c2065bt.f7568f.f7558a;
            }
            long j10 = c2065bt.f7570h;
            if (j10 != 0) {
                strategyBean2.f7083o = j10;
            }
            Map<String, String> map = c2065bt.f7569g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = c2065bt.f7569g;
                strategyBean2.f7088t = map2;
                String str = map2.get("B11");
                strategyBean2.f7077i = str != null && str.equals(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
                String str2 = c2065bt.f7569g.get("B3");
                if (str2 != null) {
                    strategyBean2.f7091w = Long.parseLong(str2);
                }
                int i10 = c2065bt.f7574l;
                strategyBean2.f7084p = i10;
                strategyBean2.f7090v = i10;
                String str3 = c2065bt.f7569g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int i11 = Integer.parseInt(str3);
                        if (i11 > 0) {
                            strategyBean2.f7089u = i11;
                        }
                    } catch (Exception e5) {
                        if (!C2029al.m4641a(e5)) {
                            e5.printStackTrace();
                        }
                    }
                }
                String str4 = c2065bt.f7569g.get("B25");
                strategyBean2.f7079k = str4 != null && str4.equals(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
            }
            C2029al.m4640a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f7074f), Boolean.valueOf(strategyBean2.f7076h), Boolean.valueOf(strategyBean2.f7075g), Boolean.valueOf(strategyBean2.f7077i), Boolean.valueOf(strategyBean2.f7078j), Boolean.valueOf(strategyBean2.f7081m), Boolean.valueOf(strategyBean2.f7082n), Long.valueOf(strategyBean2.f7084p), Boolean.valueOf(strategyBean2.f7079k), Long.valueOf(strategyBean2.f7083o));
            this.f7261g = strategyBean2;
            if (C2033ap.m4711d(c2065bt.f7566d)) {
                i6 = 0;
            } else {
                i6 = 0;
                C2029al.m4644c("[Strategy] download url is null", new Object[0]);
                this.f7261g.f7085q = "";
            }
            if (!C2033ap.m4711d(c2065bt.f7567e)) {
                C2029al.m4644c("[Strategy] download crashurl is null", new Object[i6]);
                this.f7261g.f7086r = "";
            }
            C2103w.m5011a().m5033b(2);
            C2105y c2105y = new C2105y();
            c2105y.f7707b = 2;
            c2105y.f7706a = strategyBean2.f7072d;
            c2105y.f7710e = strategyBean2.f7073e;
            c2105y.f7712g = C2033ap.m4692a(strategyBean2);
            C2103w.m5011a().m5032a(c2105y);
            m4576a(strategyBean2, true);
        }
    }
}

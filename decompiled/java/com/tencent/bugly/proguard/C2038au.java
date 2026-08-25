package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.LinkedHashMap;
import java.util.Map;
import p000a.RunnableC0005f;

public final class C2038au {

    private static C2038au f7402a;

    private C2020ac f7403b;

    private C2018aa f7404c;

    private C2036as f7405d;

    private Context f7406e;

    private C2038au(Context context) {
        C2037at c2037atM4762a = C2037at.m4762a();
        if (c2037atM4762a == null) {
            return;
        }
        this.f7403b = C2020ac.m4570a();
        this.f7404c = C2018aa.m4507a(context);
        this.f7405d = c2037atM4762a.f7386s;
        this.f7406e = context;
        C2028ak.m4631a().m4633a(new RunnableC0005f(12, this));
    }

    public static C2038au m4780a(Context context) {
        if (f7402a == null) {
            f7402a = new C2038au(context);
        }
        return f7402a;
    }

    public static void m4783a(Thread thread, int i6, String str, String str2, String str3, Map<String, String> map) {
        C2028ak.m4631a().m4633a(new RunnableC2083j0(thread, i6, str, str2, str3, map));
    }

    public static void m4781a(C2038au c2038au) {
        C2029al.m4644c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            c2038au.f7404c.getClass();
            C2033ap.m4688a(cls, "sdkPackageName", "com.tencent.bugly");
            C2029al.m4644c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            C2029al.m4640a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    public static void m4782a(C2038au c2038au, Thread thread, int i6, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        Thread threadCurrentThread = thread == null ? Thread.currentThread() : thread;
        if (i6 == 4) {
            str4 = "Unity";
        } else if (i6 == 5 || i6 == 6) {
            str4 = "Cocos";
        } else {
            if (i6 != 8) {
                C2029al.m4645d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i6));
                return;
            }
            str4 = "H5";
        }
        C2029al.m4646e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!c2038au.f7403b.m4578b()) {
                C2029al.m4645d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean strategyBeanM4579c = c2038au.f7403b.m4579c();
            if (!strategyBeanM4579c.f7074f && c2038au.f7403b.m4578b()) {
                C2029al.m4646e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                C2036as.m4730a(str4, C2033ap.m4675a(), c2038au.f7404c.f7228d, threadCurrentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                C2029al.m4646e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i6 != 5 && i6 != 6) {
                if (i6 == 8 && !strategyBeanM4579c.f7080l) {
                    C2029al.m4646e("[ExtraCrashManager] %s report is disabled.", str4);
                    C2029al.m4646e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (!strategyBeanM4579c.f7079k) {
                C2029al.m4646e("[ExtraCrashManager] %s report is disabled.", str4);
                C2029al.m4646e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i10 = i6 != 8 ? i6 : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.f7094C = C2019ab.m4558j();
            crashDetailBean.f7095D = C2019ab.m4554f();
            crashDetailBean.f7096E = C2019ab.m4560l();
            crashDetailBean.f7097F = c2038au.f7404c.m4531k();
            crashDetailBean.f7098G = c2038au.f7404c.m4530j();
            crashDetailBean.f7099H = c2038au.f7404c.m4532l();
            crashDetailBean.f7100I = C2019ab.m4548b(c2038au.f7406e);
            crashDetailBean.f7101J = C2019ab.m4555g();
            crashDetailBean.f7102K = C2019ab.m4556h();
            crashDetailBean.f7120b = i10;
            crashDetailBean.f7123e = c2038au.f7404c.m4526g();
            C2018aa c2018aa = c2038au.f7404c;
            crashDetailBean.f7124f = c2018aa.f7239o;
            crashDetailBean.f7125g = c2018aa.m4536q();
            crashDetailBean.f7131m = c2038au.f7404c.m4524f();
            crashDetailBean.f7132n = String.valueOf(str);
            crashDetailBean.f7133o = String.valueOf(str2);
            String str6 = "";
            if (str3 == null) {
                str5 = "";
            } else {
                String[] strArrSplit = str3.split("\n");
                if (strArrSplit.length > 0) {
                    str6 = strArrSplit[0];
                }
                str5 = str3;
            }
            crashDetailBean.f7134p = str6;
            crashDetailBean.f7135q = str5;
            crashDetailBean.f7136r = System.currentTimeMillis();
            crashDetailBean.f7139u = C2033ap.m4705c(crashDetailBean.f7135q.getBytes());
            crashDetailBean.f7144z = C2033ap.m4686a(c2038au.f7404c.f7192Q, C2037at.f7371h);
            crashDetailBean.f7092A = c2038au.f7404c.f7228d;
            crashDetailBean.f7093B = threadCurrentThread.getName() + "(" + threadCurrentThread.getId() + ")";
            crashDetailBean.f7103L = c2038au.f7404c.m4538s();
            crashDetailBean.f7126h = c2038au.f7404c.m4535p();
            C2018aa c2018aa2 = c2038au.f7404c;
            crashDetailBean.f7108Q = c2018aa2.f7201a;
            crashDetailBean.f7109R = c2018aa2.m4515a();
            crashDetailBean.f7112U = c2038au.f7404c.m4545z();
            C2018aa c2018aa3 = c2038au.f7404c;
            crashDetailBean.f7113V = c2018aa3.f7248x;
            crashDetailBean.f7114W = c2018aa3.m4539t();
            crashDetailBean.f7115X = c2038au.f7404c.m4544y();
            crashDetailBean.f7143y = C2032ao.m4659a();
            if (crashDetailBean.f7110S == null) {
                crashDetailBean.f7110S = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.f7110S.putAll(map);
            }
            C2036as.m4730a(str4, C2033ap.m4675a(), c2038au.f7404c.f7228d, threadCurrentThread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!c2038au.f7405d.m4759a(crashDetailBean, !C2037at.m4762a().f7384C)) {
                c2038au.f7405d.m4761b(crashDetailBean, false);
            }
            C2029al.m4646e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
                C2029al.m4646e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                C2029al.m4646e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }
}

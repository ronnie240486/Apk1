package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import p014b1.RunnableC1238l;

public final class C2037at {

    private static C2037at f7364D = null;

    public static int f7365a = 0;

    public static boolean f7366b = false;

    public static int f7367d = 2;

    public static boolean f7368e = false;

    public static int f7369f = 20480;

    public static int f7370g = 3000;

    public static int f7371h = 20480;

    public static long f7372i = 209715200;

    public static long f7373j = 604800000;

    public static String f7374k = null;

    public static boolean f7375l = false;

    public static String f7376m = null;

    public static int f7377n = 5000;

    public static boolean f7378o = true;

    public static boolean f7379p;

    public static String f7380q;

    public static String f7381r;

    public Boolean f7382A;

    public int f7383B = 31;

    public boolean f7384C = false;

    public final Context f7385c;

    public final C2036as f7386s;

    public final C2039av f7387t;

    public final NativeCrashHandler f7388u;

    public final C2020ac f7389v;

    public final C2028ak f7390w;

    public final C2042ay f7391x;

    public BuglyStrategy.C2006a f7392y;

    public InterfaceC2040aw f7393z;

    private C2037at(Context context, C2028ak c2028ak, boolean z7, BuglyStrategy.C2006a c2006a) {
        f7365a = 1004;
        Context contextM4670a = C2033ap.m4670a(context);
        this.f7385c = contextM4670a;
        C2020ac c2020acM4570a = C2020ac.m4570a();
        this.f7389v = c2020acM4570a;
        this.f7390w = c2028ak;
        this.f7392y = c2006a;
        this.f7393z = null;
        C2036as c2036as = new C2036as(contextM4670a, C2026ai.m4605a(), C2103w.m5011a(), c2020acM4570a, c2006a);
        this.f7386s = c2036as;
        C2018aa c2018aaM4507a = C2018aa.m4507a(contextM4670a);
        this.f7387t = new C2039av(contextM4670a, c2036as, c2020acM4570a, c2018aaM4507a);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(contextM4670a, c2018aaM4507a, c2036as, c2020acM4570a, c2028ak, z7, null);
        this.f7388u = nativeCrashHandler;
        c2018aaM4507a.f7189N = nativeCrashHandler;
        if (C2042ay.f7424f == null) {
            C2042ay.f7424f = new C2042ay(contextM4670a, c2020acM4570a, c2018aaM4507a, c2028ak, c2036as);
        }
        this.f7391x = C2042ay.f7424f;
    }

    public final synchronized void m4770c() {
        this.f7387t.m4794b();
        m4771d();
        m4774g();
    }

    public final void m4771d() {
        this.f7388u.setUserOpened(false);
    }

    public final void m4772e() {
        this.f7388u.setUserOpened(true);
    }

    public final void m4773f() {
        new Handler(Looper.getMainLooper()).post(new RunnableC1238l(1));
        this.f7391x.m4816b(true);
    }

    public final void m4774g() {
        new Handler(Looper.getMainLooper()).post(new RunnableC1238l(2));
        this.f7391x.m4816b(false);
    }

    public final synchronized void m4775h() {
        int i6 = 0;
        while (true) {
            int i10 = i6 + 1;
            if (i6 < 30) {
                try {
                    C2029al.m4640a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i10));
                    C2033ap.m4699b(5000L);
                    i6 = i10;
                } catch (Throwable th) {
                    if (C2029al.m4641a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    public final boolean m4776i() {
        return this.f7391x.f7425a.get();
    }

    public final boolean m4777j() {
        return (this.f7383B & 16) > 0;
    }

    public final boolean m4778k() {
        return (this.f7383B & 8) > 0;
    }

    public static synchronized C2037at m4763a(Context context, boolean z7, BuglyStrategy.C2006a c2006a) {
        try {
            if (f7364D == null) {
                f7364D = new C2037at(context, C2028ak.m4631a(), z7, c2006a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7364D;
    }

    public final synchronized void m4769b() {
        this.f7387t.m4791a();
        m4772e();
        m4773f();
    }

    public static synchronized C2037at m4762a() {
        return f7364D;
    }

    public final synchronized void m4768a(boolean z7, boolean z10, boolean z11) {
        this.f7388u.testNativeCrash(z7, z10, z11);
    }

    public final void m4767a(CrashDetailBean crashDetailBean) {
        this.f7386s.m4760b(crashDetailBean);
    }

    public final void m4766a(long j10) {
        C2028ak.m4631a().m4634a(new C2081i0(0, this), j10);
    }
}

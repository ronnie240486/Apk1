package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.text.TextUtils;
import androidx.media3.exoplayer.Renderer;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class C2042ay {

    public static C2042ay f7424f;

    public final ActivityManager f7426b;

    final C2018aa f7427c;

    final C2028ak f7428d;

    String f7429e;

    private final Context f7430g;

    private final C2020ac f7431h;

    private final C2036as f7432i;

    private FileObserver f7434k;

    private C2052bg f7436m;

    private int f7437n;

    public final AtomicBoolean f7425a = new AtomicBoolean(false);

    private final Object f7433j = new Object();

    private boolean f7435l = true;

    private long f7438o = 0;

    public C2042ay(Context context, C2020ac c2020ac, C2018aa c2018aa, C2028ak c2028ak, C2036as c2036as) {
        Context contextM4670a = C2033ap.m4670a(context);
        this.f7430g = contextM4670a;
        this.f7426b = (ActivityManager) contextM4670a.getSystemService("activity");
        if (C2033ap.m4703b(NativeCrashHandler.getDumpFilePath())) {
            this.f7429e = context.getDir("bugly", 0).getAbsolutePath();
        } else {
            this.f7429e = NativeCrashHandler.getDumpFilePath();
        }
        this.f7427c = c2018aa;
        this.f7428d = c2028ak;
        this.f7431h = c2020ac;
        this.f7432i = c2036as;
    }

    private synchronized void m4804c() {
        if (m4808e()) {
            C2029al.m4645d("start when started!", new Object[0]);
            return;
        }
        FileObserverC2085k0 fileObserverC2085k0 = new FileObserverC2085k0(this);
        this.f7434k = fileObserverC2085k0;
        try {
            fileObserverC2085k0.startWatching();
            C2029al.m4640a("start anr monitor!", new Object[0]);
            this.f7428d.m4633a(new RunnableC2087l0(this, 0));
        } catch (Throwable th) {
            this.f7434k = null;
            C2029al.m4645d("start anr monitor failed!", new Object[0]);
            if (C2029al.m4641a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized void m4806d() {
        if (!m4808e()) {
            C2029al.m4645d("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f7434k.stopWatching();
            this.f7434k = null;
            C2029al.m4645d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            C2029al.m4645d("stop anr monitor failed!", new Object[0]);
            if (C2029al.m4641a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized boolean m4808e() {
        return this.f7434k != null;
    }

    private synchronized boolean m4809f() {
        return this.f7435l;
    }

    private synchronized void m4810g() {
        int i6 = 1;
        synchronized (this) {
            if (m4808e()) {
                C2029al.m4645d("start when started!", new Object[0]);
                return;
            }
            if (TextUtils.isEmpty(this.f7429e)) {
                return;
            }
            synchronized (this.f7433j) {
                try {
                    C2052bg c2052bg = this.f7436m;
                    if (c2052bg == null || !c2052bg.isAlive()) {
                        C2052bg c2052bg2 = new C2052bg();
                        this.f7436m = c2052bg2;
                        boolean z7 = this.f7427c.f7194S;
                        c2052bg2.f7471b = z7;
                        C2029al.m4644c("set record stack trace enable:".concat(String.valueOf(z7)), new Object[0]);
                        C2052bg c2052bg3 = this.f7436m;
                        StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
                        int i10 = this.f7437n;
                        this.f7437n = i10 + 1;
                        sb.append(i10);
                        c2052bg3.setName(sb.toString());
                        this.f7436m.m4845b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            FileObserverC2085k0 fileObserverC2085k0 = new FileObserverC2085k0(this, this.f7429e);
            this.f7434k = fileObserverC2085k0;
            try {
                fileObserverC2085k0.startWatching();
                C2029al.m4640a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f7429e);
                this.f7428d.m4633a(new RunnableC2087l0(this, i6));
            } catch (Throwable th2) {
                this.f7434k = null;
                C2029al.m4645d("startWatchingPrivateAnrDir failed!", new Object[0]);
                if (C2029al.m4641a(th2)) {
                    return;
                }
                th2.printStackTrace();
            }
        }
    }

    private synchronized void m4811h() {
        if (!m4808e()) {
            C2029al.m4645d("close when closed!", new Object[0]);
            return;
        }
        synchronized (this.f7433j) {
            try {
                C2052bg c2052bg = this.f7436m;
                if (c2052bg != null) {
                    c2052bg.m4844a();
                    this.f7436m = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C2029al.m4640a("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.f7434k.stopWatching();
            this.f7434k = null;
            C2029al.m4645d("close anr monitor!", new Object[0]);
        } catch (Throwable th2) {
            C2029al.m4645d("stop anr monitor failed!", new Object[0]);
            if (C2029al.m4641a(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    public final void m4816b(boolean z7) {
        m4807d(z7);
        boolean zM4809f = m4809f();
        C2020ac c2020acM4570a = C2020ac.m4570a();
        if (c2020acM4570a != null) {
            zM4809f = zM4809f && c2020acM4570a.m4579c().f7074f;
        }
        if (zM4809f != m4808e()) {
            C2029al.m4640a("anr changed to %b", Boolean.valueOf(zM4809f));
            m4805c(zM4809f);
        }
    }

    public static synchronized C2042ay m4799a() {
        return f7424f;
    }

    private CrashDetailBean m4798a(C2041ax c2041ax) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.f7094C = C2019ab.m4558j();
            crashDetailBean.f7095D = C2019ab.m4554f();
            crashDetailBean.f7096E = C2019ab.m4560l();
            crashDetailBean.f7097F = this.f7427c.m4531k();
            crashDetailBean.f7098G = this.f7427c.m4530j();
            crashDetailBean.f7099H = this.f7427c.m4532l();
            crashDetailBean.f7100I = C2019ab.m4548b(this.f7430g);
            crashDetailBean.f7101J = C2019ab.m4555g();
            crashDetailBean.f7102K = C2019ab.m4556h();
            crashDetailBean.f7120b = 3;
            crashDetailBean.f7123e = this.f7427c.m4526g();
            C2018aa c2018aa = this.f7427c;
            crashDetailBean.f7124f = c2018aa.f7239o;
            crashDetailBean.f7125g = c2018aa.m4536q();
            crashDetailBean.f7131m = this.f7427c.m4524f();
            crashDetailBean.f7132n = "ANR_EXCEPTION";
            crashDetailBean.f7133o = c2041ax.f7422f;
            crashDetailBean.f7135q = c2041ax.f7423g;
            HashMap map = new HashMap();
            crashDetailBean.f7111T = map;
            map.put("BUGLY_CR_01", c2041ax.f7421e);
            String str = crashDetailBean.f7135q;
            int iIndexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.f7134p = iIndexOf > 0 ? crashDetailBean.f7135q.substring(0, iIndexOf) : "GET_FAIL";
            crashDetailBean.f7136r = c2041ax.f7419c;
            String str2 = crashDetailBean.f7135q;
            if (str2 != null) {
                crashDetailBean.f7139u = C2033ap.m4705c(str2.getBytes());
            }
            crashDetailBean.f7144z = c2041ax.f7418b;
            crashDetailBean.f7092A = c2041ax.f7417a;
            crashDetailBean.f7093B = "main(1)";
            crashDetailBean.f7103L = this.f7427c.m4538s();
            crashDetailBean.f7126h = this.f7427c.m4535p();
            crashDetailBean.f7127i = this.f7427c.m4511A();
            crashDetailBean.f7140v = c2041ax.f7420d;
            C2018aa c2018aa2 = this.f7427c;
            crashDetailBean.f7107P = c2018aa2.f7245u;
            crashDetailBean.f7108Q = c2018aa2.f7201a;
            crashDetailBean.f7109R = c2018aa2.m4515a();
            crashDetailBean.f7112U = this.f7427c.m4545z();
            C2018aa c2018aa3 = this.f7427c;
            crashDetailBean.f7113V = c2018aa3.f7248x;
            crashDetailBean.f7114W = c2018aa3.m4539t();
            crashDetailBean.f7115X = this.f7427c.m4544y();
            crashDetailBean.f7143y = C2032ao.m4659a();
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    public final synchronized void m4815b() {
        C2029al.m4645d("customer decides whether to open or close.", new Object[0]);
    }

    private synchronized void m4807d(boolean z7) {
        if (this.f7435l != z7) {
            C2029al.m4640a("user change anr %b", Boolean.valueOf(z7));
            this.f7435l = z7;
        }
    }

    private synchronized void m4805c(boolean z7) {
        try {
            if (z7) {
                m4810g();
            } else {
                m4811h();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static boolean m4803a(String str, String str2, String str3) {
        Map<String, String[]> map;
        TraceFileHelper.C2010a targetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (targetDumpInfo != null && (map = targetDumpInfo.f7148d) != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder(1024);
            String[] strArr = targetDumpInfo.f7148d.get("main");
            if (strArr != null && strArr.length >= 3) {
                sb.append("\"main\" tid=");
                sb.append(strArr[2]);
                sb.append(" :\n");
                sb.append(strArr[0]);
                sb.append("\n");
                sb.append(strArr[1]);
                sb.append("\n\n");
            }
            for (Map.Entry<String, String[]> entry : targetDumpInfo.f7148d.entrySet()) {
                if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                    sb.append("\"");
                    sb.append(entry.getKey());
                    sb.append("\" tid=");
                    sb.append(entry.getValue()[2]);
                    sb.append(" :\n");
                    sb.append(entry.getValue()[0]);
                    sb.append("\n");
                    sb.append(entry.getValue()[1]);
                    sb.append("\n\n");
                }
            }
            return C2030am.m4652a(str2, sb.toString(), sb.length() * 2);
        }
        C2029al.m4646e("not found trace dump for %s", str3);
        return false;
    }

    private static String m4800a(List<C2046ba> list, long j10) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder(4096);
            sb.append("\n>>>>> 以下为anr过程中主线程堆栈记录，可根据堆栈出现次数推测在该堆栈阻塞的时间，出现次数越多对anr贡献越大，越可能是造成anr的原因 >>>>>\n\n>>>>> Thread Stack Traces Records Start >>>>>\n");
            for (int i6 = 0; i6 < list.size(); i6++) {
                C2046ba c2046ba = list.get(i6);
                sb.append("Thread name:");
                sb.append(c2046ba.f7440a);
                sb.append("\n");
                long j11 = c2046ba.f7441b - j10;
                String str = j11 <= 0 ? "before " : "after ";
                sb.append("Got ");
                sb.append(str);
                sb.append("anr:");
                sb.append(Math.abs(j11));
                sb.append("ms\n");
                sb.append(c2046ba.f7442c);
                sb.append("\n");
                if (sb.length() * 2 >= 101376) {
                    break;
                }
            }
            sb.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
            return sb.toString();
        }
        return "main thread stack not enable";
    }

    public final boolean m4814a(boolean z7) {
        boolean zCompareAndSet = this.f7425a.compareAndSet(!z7, z7);
        C2029al.m4644c("tryChangeAnrState to %s, success:%s", Boolean.valueOf(z7), Boolean.valueOf(zCompareAndSet));
        return zCompareAndSet;
    }

    public final void m4812a(long j10, String str) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoM4817a;
        List<C2046ba> listM4841c;
        try {
            C2029al.m4644c("anr time:%s", Long.valueOf(j10));
            synchronized (this.f7433j) {
                try {
                    if (this.f7436m != null) {
                        C2029al.m4644c("Disable record main stack trace.", new Object[0]);
                        this.f7436m.m4846c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            String strM4680a = C2033ap.m4680a(Looper.getMainLooper().getThread());
            Map<String, String> mapM4686a = C2033ap.m4686a(this.f7427c.f7193R, C2037at.f7371h);
            if (this.f7427c.m4515a()) {
                boolean z7 = C2019ab.m4563o() || C2019ab.m4564p();
                C2029al.m4644c("isAnrCrashDevice:%s", Boolean.valueOf(z7));
                if (!z7) {
                    processErrorStateInfoM4817a = C2043az.m4817a(this.f7426b, 21000L);
                } else {
                    processErrorStateInfoM4817a = C2043az.m4817a(this.f7426b, 0L);
                }
            } else {
                processErrorStateInfoM4817a = C2043az.m4817a(this.f7426b, 0L);
            }
            if (processErrorStateInfoM4817a == null) {
                C2029al.m4644c("proc state is invisible or not my proc!", new Object[0]);
                m4814a(false);
                return;
            }
            C2041ax c2041ax = new C2041ax();
            c2041ax.f7419c = j10;
            c2041ax.f7417a = processErrorStateInfoM4817a.processName;
            c2041ax.f7422f = processErrorStateInfoM4817a.shortMsg;
            c2041ax.f7421e = processErrorStateInfoM4817a.longMsg;
            c2041ax.f7418b = mapM4686a;
            c2041ax.f7423g = strM4680a;
            if (TextUtils.isEmpty(strM4680a)) {
                c2041ax.f7423g = "main stack is null , some error may be encountered.";
            }
            Long lValueOf = Long.valueOf(c2041ax.f7419c);
            String str2 = c2041ax.f7420d;
            String str3 = c2041ax.f7417a;
            String str4 = c2041ax.f7423g;
            String str5 = c2041ax.f7422f;
            String str6 = c2041ax.f7421e;
            Map<String, String> map = c2041ax.f7418b;
            C2029al.m4644c("anr time:%d\ntrace file:%s\nproc:%s\nmain stack:%s\nshort msg:%s\nlong msg:%s\n threads:%d", lValueOf, str2, str3, str4, str5, str6, Integer.valueOf(map == null ? 0 : map.size()));
            C2029al.m4640a("found visible anr , start to upload!", new Object[0]);
            C2029al.m4644c("trace file:%s", str);
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                File file = new File(this.f7429e, "bugly_trace_" + j10 + ".txt");
                C2029al.m4644c("trace file exists", new Object[0]);
                if (str.startsWith("/data/anr/")) {
                    C2029al.m4640a("backup trace isOK:%s", Boolean.valueOf(m4803a(str, file.getAbsolutePath(), c2041ax.f7417a)));
                } else {
                    C2029al.m4640a("trace file rename :%s", Boolean.valueOf(new File(str).renameTo(file)));
                }
                synchronized (this.f7433j) {
                    try {
                        C2052bg c2052bg = this.f7436m;
                        listM4841c = c2052bg != null ? c2052bg.f7470a.m4841c() : null;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (listM4841c != null) {
                    String strM4800a = m4800a(listM4841c, j10);
                    C2029al.m4644c("save main stack trace", new Object[0]);
                    C2030am.m4650a(file, strM4800a, 2147483647L, true);
                }
                c2041ax.f7420d = file.getAbsolutePath();
            } else {
                C2029al.m4644c("trace file is null or not exists, just ignore", new Object[0]);
            }
            CrashDetailBean crashDetailBeanM4798a = m4798a(c2041ax);
            C2037at.m4762a().m4767a(crashDetailBeanM4798a);
            if (crashDetailBeanM4798a.f7118a >= 0) {
                C2029al.m4640a("backup anr record success!", new Object[0]);
            } else {
                C2029al.m4645d("backup anr record fail!", new Object[0]);
            }
            C2036as.m4730a("ANR", C2033ap.m4677a(j10), c2041ax.f7417a, "main", c2041ax.f7423g, crashDetailBeanM4798a);
            if (!this.f7432i.m4759a(crashDetailBeanM4798a, !C2019ab.m4566r())) {
                this.f7432i.m4761b(crashDetailBeanM4798a, true);
            }
            this.f7432i.m4757a(crashDetailBeanM4798a);
            synchronized (this.f7433j) {
                try {
                    if (this.f7436m != null) {
                        C2029al.m4644c("Finish anr process.", new Object[0]);
                        this.f7436m.m4847d();
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            m4814a(false);
        } catch (Throwable th4) {
            try {
                C2029al.m4643b(th4);
            } finally {
                m4814a(false);
            }
        }
    }

    public final boolean m4813a(long j10) {
        if (Math.abs(j10 - this.f7438o) < Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
            C2029al.m4645d("should not process ANR too Fre in %dms", 10000);
            return true;
        }
        this.f7438o = j10;
        return false;
    }

    public static void m4801a(C2042ay c2042ay) {
        long jCurrentTimeMillis = (System.currentTimeMillis() + C2037at.f7373j) - C2033ap.m4695b();
        C2030am.m4649a(c2042ay.f7429e, "bugly_trace_", ".txt", jCurrentTimeMillis);
        C2030am.m4649a(c2042ay.f7429e, "manual_bugly_trace_", ".txt", jCurrentTimeMillis);
        C2030am.m4649a(c2042ay.f7429e, "main_stack_record_", ".txt", jCurrentTimeMillis);
        C2030am.m4649a(c2042ay.f7429e, "main_stack_record_", ".txt.merged", jCurrentTimeMillis);
    }
}

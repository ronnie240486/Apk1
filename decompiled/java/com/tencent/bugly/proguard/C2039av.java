package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.HashMap;
import p055ea.AbstractC2460q;

public final class C2039av implements Thread.UncaughtExceptionHandler {

    private static String f7407h;

    private static final Object f7408i = new Object();

    protected final Context f7409a;

    protected final C2036as f7410b;

    protected final C2020ac f7411c;

    protected final C2018aa f7412d;

    protected Thread.UncaughtExceptionHandler f7413e;

    protected Thread.UncaughtExceptionHandler f7414f;

    protected boolean f7415g = false;

    private int f7416j;

    public C2039av(Context context, C2036as c2036as, C2020ac c2020ac, C2018aa c2018aa) {
        this.f7409a = context;
        this.f7410b = c2036as;
        this.f7411c = c2020ac;
        this.f7412d = c2018aa;
    }

    private static void m4790c() {
        C2029al.m4646e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public final synchronized void m4791a() {
        if (this.f7416j >= 10) {
            C2029al.m4640a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f7415g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (C2039av.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                C2029al.m4640a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f7414f = defaultUncaughtExceptionHandler;
                this.f7413e = defaultUncaughtExceptionHandler;
            } else {
                C2029al.m4640a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f7413e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f7416j++;
        C2029al.m4640a("registered java monitor: %s", toString());
    }

    public final synchronized void m4794b() {
        this.f7415g = false;
        C2029al.m4640a("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            C2029al.m4640a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f7413e);
            this.f7416j--;
        }
    }

    @Override
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f7408i) {
            m4793a(thread, th, true, null, null, this.f7412d.f7192Q);
        }
    }

    private CrashDetailBean m4789b(Thread thread, Throwable th, boolean z7, String str, byte[] bArr, boolean z10) {
        boolean z11;
        boolean z12;
        if (th == null) {
            C2029al.m4645d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f7136r = System.currentTimeMillis();
        crashDetailBean.f7094C = C2019ab.m4558j();
        crashDetailBean.f7095D = C2019ab.m4554f();
        crashDetailBean.f7096E = C2019ab.m4560l();
        crashDetailBean.f7097F = this.f7412d.m4531k();
        crashDetailBean.f7098G = this.f7412d.m4530j();
        crashDetailBean.f7099H = this.f7412d.m4532l();
        if (!z7 && C2018aa.m4501B() >= 31) {
            crashDetailBean.f7100I = 0L;
        } else {
            crashDetailBean.f7100I = C2019ab.m4548b(this.f7409a);
        }
        crashDetailBean.f7101J = C2019ab.m4555g();
        crashDetailBean.f7102K = C2019ab.m4556h();
        byte[] bArrM4659a = C2032ao.m4659a();
        crashDetailBean.f7143y = bArrM4659a;
        C2029al.m4640a("user log size:%d", Integer.valueOf(bArrM4659a == null ? 0 : bArrM4659a.length));
        crashDetailBean.f7120b = z7 ? 0 : 2;
        crashDetailBean.f7123e = this.f7412d.m4526g();
        C2018aa c2018aa = this.f7412d;
        crashDetailBean.f7124f = c2018aa.f7239o;
        crashDetailBean.f7125g = c2018aa.m4536q();
        crashDetailBean.f7131m = this.f7412d.m4524f();
        crashDetailBean.f7144z = C2033ap.m4686a(z10, C2037at.f7371h);
        crashDetailBean.f7092A = this.f7412d.f7228d;
        crashDetailBean.f7093B = thread.getName() + "(" + thread.getId() + ")";
        crashDetailBean.f7103L = this.f7412d.m4538s();
        crashDetailBean.f7126h = this.f7412d.m4535p();
        crashDetailBean.f7127i = this.f7412d.m4511A();
        C2018aa c2018aa2 = this.f7412d;
        crashDetailBean.f7108Q = c2018aa2.f7201a;
        crashDetailBean.f7109R = c2018aa2.m4515a();
        m4786a(crashDetailBean, th, z7);
        if (!z7) {
            if (str != null) {
                try {
                    if (str.length() > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (bArr != null || bArr.length <= 0) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (z11) {
                        HashMap map = new HashMap(1);
                        crashDetailBean.f7110S = map;
                        map.put("UserData", str);
                    }
                    if (z12) {
                        crashDetailBean.f7116Y = bArr;
                    }
                } catch (Throwable th2) {
                    C2029al.m4646e("handle crash error %s", th2.toString());
                }
            } else {
                z11 = false;
                if (bArr != null) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                if (z11) {
                    HashMap map2 = new HashMap(1);
                    crashDetailBean.f7110S = map2;
                    map2.put("UserData", str);
                }
                if (z12) {
                    crashDetailBean.f7116Y = bArr;
                }
            }
            return crashDetailBean;
        }
        crashDetailBean.f7112U = this.f7412d.m4545z();
        C2018aa c2018aa3 = this.f7412d;
        crashDetailBean.f7113V = c2018aa3.f7248x;
        crashDetailBean.f7114W = c2018aa3.m4539t();
        crashDetailBean.f7115X = this.f7412d.m4544y();
        return crashDetailBean;
    }

    private static void m4786a(CrashDetailBean crashDetailBean, Throwable th, boolean z7) {
        String strM4785a;
        String name = th.getClass().getName();
        String strM4784a = m4784a(th);
        C2029al.m4646e("stack frame :%d, has cause %b", Integer.valueOf(th.getStackTrace().length), Boolean.valueOf(th.getCause() != null));
        String str = "";
        String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable cause = th;
        while (cause != null && cause.getCause() != null) {
            cause = cause.getCause();
        }
        if (cause != null && cause != th) {
            crashDetailBean.f7132n = cause.getClass().getName();
            crashDetailBean.f7133o = m4784a(cause);
            if (cause.getStackTrace().length > 0) {
                crashDetailBean.f7134p = cause.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(strM4784a);
            sb.append("\n");
            sb.append(string);
            sb.append("\n......\nCaused by:\n");
            sb.append(crashDetailBean.f7132n);
            sb.append(":");
            sb.append(crashDetailBean.f7133o);
            sb.append("\n");
            strM4785a = m4785a(cause, C2037at.f7371h);
            sb.append(strM4785a);
            crashDetailBean.f7135q = sb.toString();
        } else {
            crashDetailBean.f7132n = name;
            if (C2037at.m4762a().m4776i() && z7) {
                C2029al.m4646e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
                str = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
            }
            crashDetailBean.f7133o = AbstractC2460q.m5494h(strM4784a, str);
            crashDetailBean.f7134p = string;
            strM4785a = m4785a(th, C2037at.f7371h);
            crashDetailBean.f7135q = strM4785a;
        }
        crashDetailBean.f7139u = C2033ap.m4705c(crashDetailBean.f7135q.getBytes());
        crashDetailBean.f7144z.put(crashDetailBean.f7093B, strM4785a);
    }

    private static boolean m4788a(Thread thread) {
        synchronized (f7408i) {
            try {
                if (f7407h != null && thread.getName().equals(f7407h)) {
                    return true;
                }
                f7407h = thread.getName();
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m4793a(Thread thread, Throwable th, boolean z7, String str, byte[] bArr, boolean z10) {
        if (z7) {
            C2029al.m4646e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (m4788a(thread)) {
                C2029al.m4640a("this class has handled this exception", new Object[0]);
                if (this.f7414f != null) {
                    C2029al.m4640a("call system handler", new Object[0]);
                    this.f7414f.uncaughtException(thread, th);
                } else {
                    m4790c();
                }
            }
        } else {
            C2029al.m4646e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f7415g) {
                C2029al.m4644c("Java crash handler is disable. Just return.", new Object[0]);
                if (z7) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7413e;
                    if (uncaughtExceptionHandler != null && m4787a(uncaughtExceptionHandler)) {
                        C2029al.m4646e("sys default last handle start!", new Object[0]);
                        this.f7413e.uncaughtException(thread, th);
                        C2029al.m4646e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f7414f != null) {
                        C2029al.m4646e("system handle start!", new Object[0]);
                        this.f7414f.uncaughtException(thread, th);
                        C2029al.m4646e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C2029al.m4646e("crashreport last handle start!", new Object[0]);
                        m4790c();
                        C2029al.m4646e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f7411c.m4578b()) {
                C2029al.m4645d("no remote but still store!", new Object[0]);
            }
            if (!this.f7411c.m4579c().f7074f && this.f7411c.m4578b()) {
                C2029al.m4646e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                C2036as.m4730a(z7 ? "JAVA_CRASH" : "JAVA_CATCH", C2033ap.m4675a(), this.f7412d.f7228d, thread.getName(), C2033ap.m4681a(th), null);
                if (z7) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f7413e;
                    if (uncaughtExceptionHandler2 != null && m4787a(uncaughtExceptionHandler2)) {
                        C2029al.m4646e("sys default last handle start!", new Object[0]);
                        this.f7413e.uncaughtException(thread, th);
                        C2029al.m4646e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f7414f != null) {
                        C2029al.m4646e("system handle start!", new Object[0]);
                        this.f7414f.uncaughtException(thread, th);
                        C2029al.m4646e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C2029al.m4646e("crashreport last handle start!", new Object[0]);
                        m4790c();
                        C2029al.m4646e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean crashDetailBeanM4789b = m4789b(thread, th, z7, str, bArr, z10);
            if (crashDetailBeanM4789b == null) {
                C2029al.m4646e("pkg crash datas fail!", new Object[0]);
                if (z7) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f7413e;
                    if (uncaughtExceptionHandler3 != null && m4787a(uncaughtExceptionHandler3)) {
                        C2029al.m4646e("sys default last handle start!", new Object[0]);
                        this.f7413e.uncaughtException(thread, th);
                        C2029al.m4646e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f7414f != null) {
                        C2029al.m4646e("system handle start!", new Object[0]);
                        this.f7414f.uncaughtException(thread, th);
                        C2029al.m4646e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C2029al.m4646e("crashreport last handle start!", new Object[0]);
                        m4790c();
                        C2029al.m4646e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            C2036as.m4730a(z7 ? "JAVA_CRASH" : "JAVA_CATCH", C2033ap.m4675a(), this.f7412d.f7228d, thread.getName(), C2033ap.m4681a(th), crashDetailBeanM4789b);
            if (!this.f7410b.m4759a(crashDetailBeanM4789b, z7)) {
                this.f7410b.m4761b(crashDetailBeanM4789b, z7);
            }
            if (z7) {
                this.f7410b.m4757a(crashDetailBeanM4789b);
            }
            if (z7) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f7413e;
                if (uncaughtExceptionHandler4 != null && m4787a(uncaughtExceptionHandler4)) {
                    C2029al.m4646e("sys default last handle start!", new Object[0]);
                    this.f7413e.uncaughtException(thread, th);
                    C2029al.m4646e("sys default last handle end!", new Object[0]);
                } else if (this.f7414f != null) {
                    C2029al.m4646e("system handle start!", new Object[0]);
                    this.f7414f.uncaughtException(thread, th);
                    C2029al.m4646e("system handle end!", new Object[0]);
                } else {
                    C2029al.m4646e("crashreport last handle start!", new Object[0]);
                    m4790c();
                    C2029al.m4646e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!C2029al.m4641a(th2)) {
                    th2.printStackTrace();
                }
                if (z7) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f7413e;
                    if (uncaughtExceptionHandler5 != null && m4787a(uncaughtExceptionHandler5)) {
                        C2029al.m4646e("sys default last handle start!", new Object[0]);
                        this.f7413e.uncaughtException(thread, th);
                        C2029al.m4646e("sys default last handle end!", new Object[0]);
                    } else if (this.f7414f != null) {
                        C2029al.m4646e("system handle start!", new Object[0]);
                        this.f7414f.uncaughtException(thread, th);
                        C2029al.m4646e("system handle end!", new Object[0]);
                    } else {
                        C2029al.m4646e("crashreport last handle start!", new Object[0]);
                        m4790c();
                        C2029al.m4646e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z7) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f7413e;
                    if (uncaughtExceptionHandler6 != null && m4787a(uncaughtExceptionHandler6)) {
                        C2029al.m4646e("sys default last handle start!", new Object[0]);
                        this.f7413e.uncaughtException(thread, th);
                        C2029al.m4646e("sys default last handle end!", new Object[0]);
                    } else if (this.f7414f != null) {
                        C2029al.m4646e("system handle start!", new Object[0]);
                        this.f7414f.uncaughtException(thread, th);
                        C2029al.m4646e("system handle end!", new Object[0]);
                    } else {
                        C2029al.m4646e("crashreport last handle start!", new Object[0]);
                        m4790c();
                        C2029al.m4646e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    private static boolean m4787a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void m4792a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z7 = strategyBean.f7074f;
            if (z7 != this.f7415g) {
                C2029al.m4640a("java changed to %b", Boolean.valueOf(z7));
                if (strategyBean.f7074f) {
                    m4791a();
                    return;
                }
                m4794b();
            }
        }
    }

    private static String m4785a(Throwable th, int i6) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i6 > 0 && sb.length() >= i6) {
                        sb.append("\n[Stack over limit size :" + i6 + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            C2029al.m4646e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    private static String m4784a(Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}

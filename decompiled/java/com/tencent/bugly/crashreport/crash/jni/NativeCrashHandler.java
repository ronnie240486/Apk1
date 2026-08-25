package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C2018aa;
import com.tencent.bugly.proguard.C2019ab;
import com.tencent.bugly.proguard.C2020ac;
import com.tencent.bugly.proguard.C2028ak;
import com.tencent.bugly.proguard.C2029al;
import com.tencent.bugly.proguard.C2033ap;
import com.tencent.bugly.proguard.C2036as;
import com.tencent.bugly.proguard.C2037at;
import com.tencent.bugly.proguard.C2049bd;
import com.tencent.bugly.proguard.C2050be;
import com.tencent.bugly.proguard.InterfaceC2096q;
import p000a.AbstractC0004e;

public class NativeCrashHandler implements InterfaceC2096q {

    static String f7159a = null;

    private static NativeCrashHandler f7160b = null;

    private static int f7161c = 1;

    private static boolean f7162n = true;

    private final Context f7163d;

    private final C2018aa f7164e;

    private final C2028ak f7165f;

    private NativeExceptionHandler f7166g;

    private final boolean f7167h;

    private boolean f7168i = false;

    private boolean f7169j = false;

    private boolean f7170k = false;

    private boolean f7171l = false;

    private C2036as f7172m;

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, C2018aa c2018aa, C2036as c2036as, C2028ak c2028ak, boolean z7, String str) {
        this.f7163d = C2033ap.m4670a(context);
        if (C2033ap.m4703b(f7159a)) {
            try {
                if (C2033ap.m4703b(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = AbstractC0004e.m24r("/data/data/", C2018aa.m4507a(context).f7227c, "/app_bugly");
            }
            f7159a = str;
        }
        this.f7172m = c2036as;
        this.f7164e = c2018aa;
        this.f7165f = c2028ak;
        this.f7167h = z7;
        this.f7166g = new C2049bd(context, c2018aa, c2036as, C2020ac.m4570a());
    }

    public static synchronized String getDumpFilePath() {
        return f7159a;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, C2018aa c2018aa, C2036as c2036as, C2020ac c2020ac, C2028ak c2028ak, boolean z7, String str) {
        try {
            if (f7160b == null) {
                f7160b = new NativeCrashHandler(context, c2018aa, c2036as, c2028ak, z7, str);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7160b;
    }

    private native String getProperties(String str);

    private native String getSoCpuAbi();

    public static boolean isShouldHandleInJava() {
        return f7162n;
    }

    public static synchronized void setDumpFilePath(String str) {
        f7159a = str;
    }

    public static void setShouldHandleInJava(boolean z7) {
        f7162n = z7;
        NativeCrashHandler nativeCrashHandler = f7160b;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.m4491a(999, String.valueOf(z7));
        }
    }

    @Override
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f7168i || this.f7169j) && str != null && str2 != null && str3 != null) {
            try {
                if (this.f7169j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) C2033ap.m4673a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f7165f.m4633a(new RunnableC2014a(this));
    }

    public void disableCatchAnrTrace() {
        f7161c = 1;
    }

    public void dumpAnrNativeStack() {
        m4491a(19, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
    }

    public void enableCatchAnrTrace() {
        f7161c |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return m4491a(998, "true");
    }

    @Override
    public String getLogFromNative() {
        if (!this.f7168i && !this.f7169j) {
            return null;
        }
        try {
            return this.f7169j ? getNativeLog() : (String) C2033ap.m4673a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f7166g;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            C2029al.m4645d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public String getSystemProperty(String str) {
        return (this.f7169j || this.f7168i) ? getProperties(str) : "fail";
    }

    public boolean isEnableCatchAnrTrace() {
        return (f7161c & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.f7171l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            try {
                boolean z7 = strategyBean.f7074f;
                if (z7 != this.f7170k) {
                    C2029al.m4645d("server native changed to %b", Boolean.valueOf(z7));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean z10 = C2020ac.m4570a().m4579c().f7074f && this.f7171l;
        if (z10 != this.f7170k) {
            C2029al.m4640a("native changed to %b", Boolean.valueOf(z10));
            m4496b(z10);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f7168i || this.f7169j) && str != null && str2 != null) {
            try {
                if (this.f7169j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) C2033ap.m4673a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z7, int i6);

    public void removeEmptyNativeRecordFiles() {
        C2050be.m4836c(f7159a);
    }

    public native String removeNativeKeyValue(String str);

    public void resendSigquit() {
        m4491a(20, "");
    }

    public boolean setNativeAppChannel(String str) {
        return m4491a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return m4491a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return m4491a(10, str);
    }

    public native void setNativeInfo(int i6, String str);

    @Override
    public boolean setNativeIsAppForeground(boolean z7) {
        return m4491a(14, z7 ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j10) {
        try {
            return m4491a(15, String.valueOf(j10));
        } catch (NumberFormatException e5) {
            if (C2029al.m4641a(e5)) {
                return false;
            }
            e5.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return m4491a(11, str);
    }

    public synchronized void setUserOpened(boolean z7) {
        try {
            m4499c(z7);
            boolean zIsUserOpened = isUserOpened();
            C2020ac c2020acM4570a = C2020ac.m4570a();
            if (c2020acM4570a != null) {
                zIsUserOpened = zIsUserOpened && c2020acM4570a.m4579c().f7074f;
            }
            if (zIsUserOpened != this.f7170k) {
                C2029al.m4640a("native changed to %b", Boolean.valueOf(zIsUserOpened));
                m4496b(zIsUserOpened);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void startNativeMonitor() {
        try {
            if (!this.f7169j && !this.f7168i) {
                boolean zM4703b = C2033ap.m4703b(this.f7164e.f7244t);
                boolean z7 = !zM4703b;
                if (C2037at.f7366b) {
                    boolean zM4493a = m4493a(zM4703b ? "Bugly_Native" : this.f7164e.f7244t, z7);
                    this.f7169j = zM4493a;
                    if (!zM4493a && zM4703b) {
                        this.f7168i = m4493a("NativeRQD", false);
                    }
                } else {
                    String str = "Bugly_Native";
                    C2018aa c2018aa = this.f7164e;
                    String str2 = c2018aa.f7244t;
                    if (zM4703b) {
                        c2018aa.getClass();
                    } else {
                        str = str2;
                    }
                    this.f7169j = m4493a(str, z7);
                }
                if (this.f7169j || this.f7168i) {
                    m4489a(this.f7167h);
                    setNativeAppVersion(this.f7164e.f7239o);
                    setNativeAppChannel(this.f7164e.f7243s);
                    setNativeAppPackage(this.f7164e.f7227c);
                    setNativeUserId(this.f7164e.m4524f());
                    setNativeIsAppForeground(this.f7164e.m4515a());
                    setNativeLaunchTime(this.f7164e.f7201a);
                    return;
                }
                return;
            }
            m4489a(this.f7167h);
        } catch (Throwable th) {
            throw th;
        }
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (this.f7169j) {
            testCrash();
        } else {
            C2029al.m4645d("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    public void unBlockSigquit(boolean z7) {
        if (z7) {
            m4491a(21, "true");
        } else {
            m4491a(21, "false");
        }
    }

    public native String unregist();

    private synchronized void m4498c() {
        if (!this.f7170k) {
            C2029al.m4645d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                C2029al.m4640a("[Native] Successfully closed native crash report.", new Object[0]);
                this.f7170k = false;
                return;
            }
            try {
                C2033ap.m4673a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
                this.f7170k = false;
                C2029al.m4640a("[Native] Successfully closed native crash report.", new Object[0]);
                return;
            } catch (Throwable unused) {
                C2029al.m4644c("[Native] Failed to close native crash report.", new Object[0]);
                this.f7169j = false;
                this.f7168i = false;
                return;
            }
        } catch (Throwable unused2) {
            C2029al.m4644c("[Native] Failed to close native crash report.", new Object[0]);
        }
        throw th;
    }

    private synchronized void m4496b(boolean z7) {
        try {
            if (z7) {
                startNativeMonitor();
            } else {
                m4498c();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void m4489a(boolean z7) {
        if (this.f7170k) {
            C2029al.m4645d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f7169j) {
            try {
                String strRegist = regist(f7159a, z7, f7161c);
                if (strRegist != null) {
                    C2029al.m4640a("[Native] Native Crash Report enable.", new Object[0]);
                    this.f7164e.f7245u = strRegist;
                    String strConcat = "-".concat(strRegist);
                    if (!C2037at.f7366b && !this.f7164e.f7232h.contains(strConcat)) {
                        C2018aa c2018aa = this.f7164e;
                        c2018aa.f7232h = c2018aa.f7232h.concat("-").concat(this.f7164e.f7245u);
                    }
                    C2029al.m4640a("comInfo.sdkVersion %s", this.f7164e.f7232h);
                    this.f7170k = true;
                    String runningCpuAbi = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi)) {
                        this.f7164e.m4523e(runningCpuAbi);
                    }
                    return;
                }
            } catch (Throwable unused) {
                C2029al.m4644c("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.f7168i) {
            try {
                Class cls = Integer.TYPE;
                String str = (String) C2033ap.m4673a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", new Class[]{String.class, String.class, cls, cls}, new Object[]{f7159a, C2019ab.m4552d(), Integer.valueOf(z7 ? 1 : 5), 1});
                if (str == null) {
                    String strM4552d = C2019ab.m4552d();
                    C2018aa.m4509b();
                    str = (String) C2033ap.m4673a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", new Class[]{String.class, String.class, cls}, new Object[]{f7159a, strM4552d, Integer.valueOf(C2018aa.m4501B())});
                }
                if (str != null) {
                    this.f7170k = true;
                    this.f7164e.f7245u = str;
                    C2033ap.m4673a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    C2033ap.m4673a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{cls}, new Object[]{Integer.valueOf(z7 ? 1 : 5)});
                    String runningCpuAbi2 = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi2)) {
                        this.f7164e.m4523e(runningCpuAbi2);
                    }
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.f7169j = false;
        this.f7168i = false;
    }

    public static synchronized NativeCrashHandler getInstance() {
        return f7160b;
    }

    public void testNativeCrash(boolean z7, boolean z10, boolean z11) {
        m4491a(16, String.valueOf(z7));
        m4491a(17, String.valueOf(z10));
        m4491a(18, String.valueOf(z11));
        testNativeCrash();
    }

    private synchronized void m4499c(boolean z7) {
        if (this.f7171l != z7) {
            C2029al.m4640a("user change native %b", Boolean.valueOf(z7));
            this.f7171l = z7;
        }
    }

    private static boolean m4493a(String str, boolean z7) {
        boolean z10;
        try {
            C2029al.m4640a("[Native] Trying to load so: %s", str);
            if (z7) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                C2029al.m4640a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z10 = true;
                C2029al.m4645d(th.getMessage(), new Object[0]);
                C2029al.m4645d("[Native] Failed to load so: %s", str);
                return z10;
            }
        } catch (Throwable th2) {
            th = th2;
            z10 = false;
        }
    }

    public boolean m4491a(int i6, String str) {
        if (!this.f7169j) {
            return false;
        }
        try {
            setNativeInfo(i6, str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }
}

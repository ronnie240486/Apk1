package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.p033h5.H5JavaScriptInterface;
import com.tencent.bugly.proguard.C2018aa;
import com.tencent.bugly.proguard.C2020ac;
import com.tencent.bugly.proguard.C2028ak;
import com.tencent.bugly.proguard.C2029al;
import com.tencent.bugly.proguard.C2031an;
import com.tencent.bugly.proguard.C2033ap;
import com.tencent.bugly.proguard.C2034aq;
import com.tencent.bugly.proguard.C2037at;
import com.tencent.bugly.proguard.C2038au;
import com.tencent.bugly.proguard.C2048bc;
import com.tencent.bugly.proguard.C2094p;
import com.tencent.bugly.proguard.C2098r;
import com.tencent.bugly.proguard.C2099s;
import com.tencent.bugly.proguard.C2103w;
import com.tencent.bugly.proguard.C2104x;
import com.tencent.bugly.proguard.C2105y;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000a.AbstractC0004e;

public class CrashReport {

    private static Context f7044a;

    public static class CrashHandleCallback extends BuglyStrategy.C2006a {
    }

    public static class UserStrategy extends BuglyStrategy {

        CrashHandleCallback f7045c;

        public UserStrategy(Context context) {
        }

        @Override
        public synchronized int getCallBackType() {
            return this.f7017a;
        }

        @Override
        public synchronized boolean getCloseErrorCallback() {
            return this.f7018b;
        }

        @Override
        public synchronized void setCallBackType(int i6) {
            this.f7017a = i6;
        }

        @Override
        public synchronized void setCloseErrorCallback(boolean z7) {
            this.f7018b = z7;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f7045c = crashHandleCallback;
        }

        @Override
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f7045c;
        }
    }

    public interface InterfaceC2008a {
        String mo4476a();

        void mo4477a(H5JavaScriptInterface h5JavaScriptInterface, String str);

        void mo4478a(String str);

        void mo4479b();

        CharSequence mo4480c();
    }

    public static void closeBugly() {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not close bugly because bugly is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        if (f7044a == null) {
            return;
        }
        C2034aq c2034aqM4713a = C2034aq.m4713a();
        if (c2034aqM4713a != null) {
            c2034aqM4713a.m4719b(f7044a);
        }
        closeCrashReport();
        C2099s.m4973a(f7044a);
        C2028ak c2028akM4631a = C2028ak.m4631a();
        if (c2028akM4631a != null) {
            c2028akM4631a.m4635b();
        }
    }

    public static void closeCrashReport() {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not close crash report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            C2037at.m4762a().m4770c();
        } else {
            Log.w(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void closeNativeReport() {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not close native report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            C2037at.m4762a().m4771d();
        } else {
            Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void enableBugly(boolean z7) {
        C2094p.f7655a = z7;
    }

    public static void enableObtainId(Context context, boolean z7) {
        setCollectPrivacyInfo(context, z7);
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        }
        if (context != null) {
            return C2018aa.m4507a(context).m4542w();
        }
        Log.e(C2029al.f7315b, "getAllUserDataKeys args context should not be null");
        return new HashSet();
    }

    public static String getAppChannel() {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not get App channel because bugly is disable.");
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return C2018aa.m4507a(f7044a).f7243s;
        }
        Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return "unknown";
    }

    public static String getAppID() {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not get App ID because bugly is disable.");
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return C2018aa.m4507a(f7044a).m4522e();
        }
        Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return "unknown";
    }

    public static String getAppVer() {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not get app version because bugly is disable.");
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return C2018aa.m4507a(f7044a).f7239o;
        }
        Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return "unknown";
    }

    public static String getBuglyVersion(Context context) {
        if (context != null) {
            return C2018aa.m4507a(context).f7232h;
        }
        C2029al.m4645d("Please call with context.", new Object[0]);
        return "unknown";
    }

    public static Context getContext() {
        return f7044a;
    }

    public static String getDeviceID(Context context) {
        return C2018aa.m4507a(context).m4526g();
    }

    public static Proxy getHttpProxy() {
        return C2031an.f7317a;
    }

    public static Map<String, String> getSdkExtraData() {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return C2018aa.m4507a(f7044a).f7186K;
        }
        Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return null;
    }

    public static String getUserData(Context context, String str) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not get user data because bugly is disable.");
            return "unknown";
        }
        if (context == null) {
            Log.e(C2029al.f7315b, "getUserDataValue args context should not be null");
            return "unknown";
        }
        if (C2033ap.m4703b(str)) {
            return null;
        }
        return C2018aa.m4507a(context).m4527g(str);
    }

    public static int getUserDatasSize(Context context) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not get size of user data because bugly is disable.");
            return -1;
        }
        if (context != null) {
            return C2018aa.m4507a(context).m4541v();
        }
        Log.e(C2029al.f7315b, "getUserDatasSize args context should not be null");
        return -1;
    }

    public static String getUserId() {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not get user ID because bugly is disable.");
            return "unknown";
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return C2018aa.m4507a(f7044a).m4524f();
        }
        Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        return "unknown";
    }

    public static int getUserSceneTagId(Context context) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not get user scene tag because bugly is disable.");
            return -1;
        }
        if (context != null) {
            return C2018aa.m4507a(context).m4545z();
        }
        Log.e(C2029al.f7315b, "getUserSceneTagId args context should not be null");
        return -1;
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        f7044a = context;
        C2094p.m4948a(CrashModule.getInstance());
        C2094p.m4945a(context);
    }

    public static boolean isLastSessionCrash() {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return false;
        }
        C2037at c2037atM4762a = C2037at.m4762a();
        Boolean bool = c2037atM4762a.f7382A;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = C2018aa.m4509b().f7228d;
        List<C2105y> listM5028a = C2103w.m5011a().m5028a(1);
        ArrayList arrayList = new ArrayList();
        if (listM5028a == null || listM5028a.size() <= 0) {
            c2037atM4762a.f7382A = Boolean.FALSE;
            return false;
        }
        for (C2105y c2105y : listM5028a) {
            if (str.equals(c2105y.f7708c)) {
                c2037atM4762a.f7382A = Boolean.TRUE;
                arrayList.add(c2105y);
            }
        }
        if (arrayList.size() > 0) {
            C2103w.m5011a().m5030a(arrayList);
        }
        return true;
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postException(Thread thread, int i6, String str, String str2, String str3, Map<String, String> map) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not post crash caught because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            C2038au.m4783a(thread, i6, str, str2, str3, map);
        } else {
            Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || C2033ap.m4703b(str) || C2033ap.m4703b(str2)) {
            return;
        }
        String strReplace = str.replace("[a-zA-Z[0-9]]+", "");
        if (strReplace.length() > 100) {
            Log.w(C2029al.f7315b, String.format("putSdkData key length over limit %d, will be cutted.", 50));
            strReplace = strReplace.substring(0, 50);
        }
        if (str2.length() > 500) {
            Log.w(C2029al.f7315b, String.format("putSdkData value length over limit %d, will be cutted!", 200));
            str2 = str2.substring(0, 200);
        }
        C2018aa.m4507a(context).m4517b(strReplace, str2);
        StringBuilder sb = new StringBuilder("[param] putSdkData data: ");
        sb.append(strReplace);
        C2029al.m4642b(AbstractC0004e.m26t(sb, " - ", str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not put user data because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(C2029al.f7315b, "putUserData args context should not be null");
            return;
        }
        if (str == null) {
            C2029al.m4645d("putUserData args key should not be null or empty", new Object[0]);
            return;
        }
        if (str2 == null) {
            C2029al.m4645d("putUserData args value should not be null", new Object[0]);
            return;
        }
        if (str2.length() > 200) {
            C2029al.m4645d("user data value length over limit %d, it will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        C2018aa c2018aaM4507a = C2018aa.m4507a(context);
        if (c2018aaM4507a.m4542w().contains(str)) {
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.putKeyValueToNative(str, str2);
            }
            C2018aa.m4507a(context).m4514a(str, str2);
            C2029al.m4644c("replace KV %s %s", str, str2);
            return;
        }
        if (c2018aaM4507a.m4541v() >= 50) {
            C2029al.m4645d("user data size is over limit %d, it will be cutted!", 50);
            return;
        }
        if (str.length() > 50) {
            C2029al.m4645d("user data key length over limit %d , will drop this new key %s", 50, str);
            str = str.substring(0, 50);
        }
        NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
        if (nativeCrashHandler2 != null) {
            nativeCrashHandler2.putKeyValueToNative(str, str2);
        }
        C2018aa.m4507a(context).m4514a(str, str2);
        C2029al.m4642b("[param] set user data: %s - %s", str, str2);
    }

    public static String removeUserData(Context context, String str) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not remove user data because bugly is disable.");
            return "unknown";
        }
        if (context == null) {
            Log.e(C2029al.f7315b, "removeUserData args context should not be null");
            return "unknown";
        }
        if (C2033ap.m4703b(str)) {
            return null;
        }
        C2029al.m4642b("[param] remove user data: %s", str);
        return C2018aa.m4507a(context).m4525f(str);
    }

    public static void setAllThreadStackEnable(Context context, boolean z7, boolean z10) {
        C2018aa c2018aaM4507a = C2018aa.m4507a(context);
        c2018aaM4507a.f7192Q = z7;
        c2018aaM4507a.f7193R = z10;
    }

    public static void setAppChannel(Context context, String str) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set App channel because Bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(C2029al.f7315b, "setAppChannel args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(C2029al.f7315b, "App channel is null, will not set");
            return;
        }
        C2018aa.m4507a(context).f7243s = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set App package because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(C2029al.f7315b, "setAppPackage args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(C2029al.f7315b, "App package is null, will not set");
            return;
        }
        C2018aa.m4507a(context).f7227c = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppPackage(str);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set App version because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(C2029al.f7315b, "setAppVersion args context should not be null");
            return;
        }
        if (str == null) {
            Log.w(C2029al.f7315b, "App version is null, will not set");
            return;
        }
        C2018aa.m4507a(context).f7239o = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppVersion(str);
        }
    }

    public static void setBuglyDbName(String str) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set DB name because bugly is disable.");
        } else {
            Log.i(C2029al.f7315b, "Set Bugly DB name: ".concat(String.valueOf(str)));
            C2104x.f7702a = str;
        }
    }

    public static void setCollectPrivacyInfo(Context context, boolean z7) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set collect privacy info enable because bugly is disable.");
        } else if (context == null) {
            Log.w(C2029al.f7315b, "setCollectPrivacyInfo args context should not be null");
        } else {
            Log.i(C2029al.f7315b, "setCollectPrivacyInfo: ".concat(String.valueOf(z7)));
            C2018aa.m4507a(context).f7238n = z7;
        }
    }

    public static void setContext(Context context) {
        f7044a = context;
    }

    public static void setCrashFilter(String str) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set App package because bugly is disable.");
        } else {
            Log.i(C2029al.f7315b, "Set crash stack filter: ".concat(String.valueOf(str)));
            C2037at.f7380q = str;
        }
    }

    public static void setCrashRegularFilter(String str) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set App package because bugly is disable.");
        } else {
            Log.i(C2029al.f7315b, "Set crash stack filter: ".concat(String.valueOf(str)));
            C2037at.f7381r = str;
        }
    }

    public static void setDeviceId(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        C2018aa.m4507a(context).m4513a(str);
    }

    public static void setDeviceModel(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        C2018aa.m4507a(context).m4516b(str);
    }

    public static void setDumpFilePath(Context context, String str) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set App version because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(C2029al.f7315b, "setTombPath args context should not be null");
        } else if (str == null) {
            Log.w(C2029al.f7315b, "tombstone path is null, will not set");
        } else {
            Log.i(C2029al.f7315b, "user set tombstone path: ".concat(str));
            NativeCrashHandler.setDumpFilePath(str);
        }
    }

    public static void setHandleNativeCrashInJava(boolean z7) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set App package because bugly is disable.");
        } else {
            Log.i(C2029al.f7315b, "Should handle native crash in Java profile after handled in native profile: ".concat(String.valueOf(z7)));
            NativeCrashHandler.setShouldHandleInJava(z7);
        }
    }

    public static void setHttpProxy(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            C2031an.f7317a = null;
        } else {
            C2031an.f7317a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i6));
        }
    }

    @Deprecated
    public static void setIsAppForeground(Context context, boolean z7) {
        C2029al.m4640a("App fore and back status are no longer supported", new Object[0]);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z7) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set 'isDevelopmentDevice' because bugly is disable.");
            return;
        }
        if (context == null) {
            C2029al.m4645d("Context should not be null.", new Object[0]);
            return;
        }
        if (z7) {
            C2029al.m4644c("This is a development device.", new Object[0]);
        } else {
            C2029al.m4644c("This is not a development device.", new Object[0]);
        }
        C2018aa.m4507a(context).f7184I = z7;
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z7) {
        return setJavascriptMonitor(webView, z7, false);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not put SDK extra data because bugly is disable.");
            return;
        }
        if (context == null || C2033ap.m4703b(str) || C2033ap.m4703b(str2)) {
            return;
        }
        C2018aa c2018aaM4507a = C2018aa.m4507a(context);
        if (str == null || str2 == null) {
            return;
        }
        synchronized (c2018aaM4507a.f7195T) {
            c2018aaM4507a.f7186K.put(str, str2);
        }
    }

    public static void setServerUrl(String str) {
        if (C2033ap.m4703b(str) || !C2033ap.m4711d(str)) {
            Log.i(C2029al.f7315b, "URL is invalid.");
            return;
        }
        C2020ac.m4572a(str);
        StrategyBean.f7069a = str;
        StrategyBean.f7070b = str;
    }

    public static void setSessionIntervalMills(long j10) {
        if (C2094p.f7655a) {
            C2099s.m4972a(j10);
        } else {
            Log.w(C2029al.f7315b, "Can not set 'SessionIntervalMills' because bugly is disable.");
        }
    }

    public static void setUserId(String str) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set user ID because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            setUserId(f7044a, str);
        } else {
            Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void setUserSceneTag(Context context, int i6) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set tag caught because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.e(C2029al.f7315b, "setTag args context should not be null");
            return;
        }
        if (i6 <= 0) {
            C2029al.m4645d("setTag args tagId should > 0", new Object[0]);
        }
        C2018aa c2018aaM4507a = C2018aa.m4507a(context);
        synchronized (c2018aaM4507a.f7196U) {
            try {
                int i10 = c2018aaM4507a.f7247w;
                if (i10 != i6) {
                    c2018aaM4507a.f7247w = i6;
                    C2029al.m4640a("user scene tag %d changed to tag %d", Integer.valueOf(i10), Integer.valueOf(c2018aaM4507a.f7247w));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C2029al.m4642b("[param] set user scene tag: %d", Integer.valueOf(i6));
    }

    public static void startCrashReport() {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not start crash report because bugly is disable.");
        } else if (CrashModule.getInstance().hasInitialized()) {
            C2037at.m4762a().m4769b();
        } else {
            Log.w(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void testANRCrash() {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C2029al.m4640a("start to create a anr crash for test!", new Object[0]);
            C2037at.m4762a().m4775h();
        }
    }

    public static void testJavaCrash() {
        int i6;
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not test Java crash because bugly is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        C2018aa c2018aaM4509b = C2018aa.m4509b();
        if (c2018aaM4509b != null && (i6 = c2018aaM4509b.f7248x) != 24096) {
            c2018aaM4509b.f7248x = 24096;
            C2029al.m4640a("server scene tag %d changed to tag %d", Integer.valueOf(i6), Integer.valueOf(c2018aaM4509b.f7248x));
        }
        throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
    }

    public static void testNativeCrash() {
        testNativeCrash(true, true, false);
    }

    public static void uploadUserInfo() {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not upload user info because bugly is disable.");
            return;
        }
        C2098r c2098r = C2099s.f7674b;
        if (c2098r == null) {
            Log.w(C2029al.f7315b, "Can not upload user info because bugly is not init.");
        } else {
            c2098r.m4969b();
        }
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebView webView, boolean z7, boolean z10) {
        if (webView == null) {
            Log.w(C2029al.f7315b, "WebView is null.");
            return false;
        }
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setAllowFileAccess(false);
        return setJavascriptMonitor(new C2009a(webView), z7, z10);
    }

    public static void testNativeCrash(boolean z7, boolean z10, boolean z11) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C2029al.m4640a("start to create a native crash for test!", new Object[0]);
            C2037at.m4762a().m4768a(z7, z10, z11);
        }
    }

    public static void postCatchedException(final Throwable th, final Thread thread, final boolean z7) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not post crash caught because bugly is disable.");
            return;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2029al.f7315b, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return;
        }
        if (th == null) {
            C2029al.m4645d("throwable is null, just return", new Object[0]);
            return;
        }
        if (thread == null) {
            thread = Thread.currentThread();
        }
        final C2037at c2037atM4762a = C2037at.m4762a();
        c2037atM4762a.f7390w.m4633a(new Runnable() {

            final boolean f7394a = false;

            final String f7397d = null;

            final byte[] f7398e = null;

            final boolean f7399f = true;

            @Override
            public final void run() {
                try {
                    C2029al.m4644c("post a throwable %b", Boolean.valueOf(this.f7394a));
                    C2037at.this.f7387t.m4793a(thread, th, false, this.f7397d, this.f7398e, this.f7399f);
                    if (z7) {
                        C2029al.m4640a("clear user datas", new Object[0]);
                        C2018aa.m4507a(C2037at.this.f7385c).m4540u();
                    }
                } catch (Throwable th2) {
                    if (!C2029al.m4643b(th2)) {
                        th2.printStackTrace();
                    }
                    C2029al.m4646e("java catch error: %s", th.toString());
                }
            }
        });
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f7044a = context;
        C2094p.m4948a(CrashModule.getInstance());
        C2094p.m4946a(context, userStrategy);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i6) {
        if (inetAddress == null) {
            C2031an.f7317a = null;
        } else {
            C2031an.f7317a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i6));
        }
    }

    public static void postException(int i6, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i6, str, str2, str3, map);
    }

    public static void setUserId(Context context, String str) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set user ID because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.e(C2029al.f7315b, "Context should not be null when bugly has not been initialed!");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C2029al.m4645d("userId should not be null", new Object[0]);
            return;
        }
        if (str.length() > 100) {
            String strSubstring = str.substring(0, 100);
            C2029al.m4645d("userId %s length is over limit %d substring to %s", str, 100, strSubstring);
            str = strSubstring;
        }
        if (str.equals(C2018aa.m4507a(context).m4524f())) {
            return;
        }
        C2018aa c2018aaM4507a = C2018aa.m4507a(context);
        synchronized (c2018aaM4507a.f7197V) {
            c2018aaM4507a.f7236l = str;
        }
        C2029al.m4642b("[user] set userId : %s", str);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeUserId(str);
        }
        if (CrashModule.getInstance().hasInitialized()) {
            C2099s.m4971a();
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        }
        if (context == null) {
            C2029al.m4645d("Context should not be null.", new Object[0]);
            return null;
        }
        return C2018aa.m4507a(context).f7186K;
    }

    public static void initCrashReport(Context context, String str, boolean z7) {
        initCrashReport(context, str, z7, null);
    }

    public static boolean setJavascriptMonitor(InterfaceC2008a interfaceC2008a, boolean z7) {
        return setJavascriptMonitor(interfaceC2008a, z7, false);
    }

    public static void initCrashReport(Context context, String str, boolean z7, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f7044a = context;
        C2094p.m4948a(CrashModule.getInstance());
        C2094p.m4947a(context, str, z7, userStrategy);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(InterfaceC2008a interfaceC2008a, boolean z7, boolean z10) {
        if (interfaceC2008a == null) {
            Log.w(C2029al.f7315b, "WebViewInterface is null.");
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            C2029al.m4646e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
        C2029al.m4640a("Set Javascript exception monitor of webview.", new Object[0]);
        if (!C2094p.f7655a) {
            Log.w(C2029al.f7315b, "Can not set JavaScript monitor because bugly is disable.");
            return false;
        }
        C2029al.m4644c("URL of webview is %s", interfaceC2008a.mo4476a());
        C2029al.m4640a("Enable the javascript needed by webview monitor.", new Object[0]);
        interfaceC2008a.mo4479b();
        H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(interfaceC2008a);
        if (h5JavaScriptInterface != null) {
            C2029al.m4640a("Add a secure javascript interface to the webview.", new Object[0]);
            interfaceC2008a.mo4477a(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z7) {
            C2029al.m4640a("Inject bugly.js(v%s) to the webview.", C2048bc.m4821b());
            String strM4820a = C2048bc.m4820a();
            if (strM4820a == null) {
                C2029al.m4646e("Failed to inject Bugly.js.", C2048bc.m4821b());
                return false;
            }
            interfaceC2008a.mo4478a("javascript:".concat(strM4820a));
        }
        return true;
    }
}

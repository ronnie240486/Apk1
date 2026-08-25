package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class C2094p {

    public static boolean f7655a = true;

    public static List<AbstractC2092o> f7656b = new ArrayList();

    public static boolean f7657c;

    private static C2103w f7658d;

    private static boolean f7659e;

    private static boolean m4949a(C2018aa c2018aa) {
        List<String> list = c2018aa.f7246v;
        return list != null && list.contains("bugly");
    }

    public static synchronized void m4945a(Context context) {
        m4946a(context, null);
    }

    public static synchronized void m4946a(Context context, BuglyStrategy buglyStrategy) {
        if (f7659e) {
            C2029al.m4645d("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == null) {
            Log.w(C2029al.f7315b, "[init] context of init() is null, check it.");
            return;
        }
        C2018aa c2018aaM4507a = C2018aa.m4507a(context);
        if (m4949a(c2018aaM4507a)) {
            f7655a = false;
            return;
        }
        String strM4522e = c2018aaM4507a.m4522e();
        if (strM4522e == null) {
            Log.e(C2029al.f7315b, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
        } else {
            m4947a(context, strM4522e, c2018aaM4507a.f7179D, buglyStrategy);
        }
    }

    public static synchronized void m4947a(Context context, String str, boolean z7, BuglyStrategy buglyStrategy) {
        int i6;
        long appReportDelay;
        byte[] bArr;
        if (f7659e) {
            C2029al.m4645d("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == null) {
            Log.w(C2029al.f7315b, "[init] context is null, check it.");
            return;
        }
        if (str == null) {
            Log.e(C2029al.f7315b, "init arg 'crashReportAppID' should not be null!");
            return;
        }
        f7659e = true;
        if (z7) {
            f7657c = true;
            C2029al.f7316c = true;
            C2029al.m4645d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
            C2029al.m4646e("--------------------------------------------------------------------------------------------", new Object[0]);
            C2029al.m4645d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
            C2029al.m4645d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
            C2029al.m4645d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
            C2029al.m4645d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
            C2029al.m4646e("--------------------------------------------------------------------------------------------", new Object[0]);
            C2029al.m4642b("[init] Open debug mode of Bugly.", new Object[0]);
        }
        C2029al.m4640a(" crash report start initializing...", new Object[0]);
        C2029al.m4642b("[init] Bugly start initializing...", new Object[0]);
        C2029al.m4640a("[init] Bugly complete version: v%s", "4.1.9.3");
        Context contextM4670a = C2033ap.m4670a(context);
        C2018aa c2018aaM4507a = C2018aa.m4507a(contextM4670a);
        c2018aaM4507a.m4534o();
        C2032ao.m4656a(contextM4670a);
        f7658d = C2103w.m5012a(contextM4670a, f7656b);
        C2026ai.m4606a(contextM4670a);
        C2020ac.m4571a(contextM4670a, f7656b);
        C2101u c2101uM4992a = C2101u.m4992a(contextM4670a);
        if (m4949a(c2018aaM4507a)) {
            f7655a = false;
            return;
        }
        c2018aaM4507a.f7242r = str;
        c2018aaM4507a.m4517b("APP_ID", str);
        C2029al.m4640a("[param] Set APP ID:%s", str);
        if (buglyStrategy != null) {
            String appVersion = buglyStrategy.getAppVersion();
            if (!TextUtils.isEmpty(appVersion)) {
                if (appVersion.length() > 100) {
                    String strSubstring = appVersion.substring(0, 100);
                    C2029al.m4645d("appVersion %s length is over limit %d substring to %s", appVersion, 100, strSubstring);
                    appVersion = strSubstring;
                }
                c2018aaM4507a.f7239o = appVersion;
                C2029al.m4640a("[param] Set App version: %s", buglyStrategy.getAppVersion());
            }
            try {
                if (buglyStrategy.isReplaceOldChannel()) {
                    String appChannel = buglyStrategy.getAppChannel();
                    if (!TextUtils.isEmpty(appChannel)) {
                        if (appChannel.length() > 100) {
                            String strSubstring2 = appChannel.substring(0, 100);
                            C2029al.m4645d("appChannel %s length is over limit %d substring to %s", appChannel, 100, strSubstring2);
                            appChannel = strSubstring2;
                        }
                        f7658d.m5031a(556, "app_channel", appChannel.getBytes(), false);
                        c2018aaM4507a.f7243s = appChannel;
                    }
                } else {
                    Map<String, byte[]> mapM5029a = f7658d.m5029a(556, (InterfaceC2102v) null);
                    if (mapM5029a != null && (bArr = mapM5029a.get("app_channel")) != null) {
                        c2018aaM4507a.f7243s = new String(bArr);
                    }
                }
                C2029al.m4640a("[param] Set App channel: %s", c2018aaM4507a.f7243s);
            } catch (Exception e5) {
                if (f7657c) {
                    e5.printStackTrace();
                }
            }
            String appPackageName = buglyStrategy.getAppPackageName();
            if (!TextUtils.isEmpty(appPackageName)) {
                if (appPackageName.length() > 100) {
                    String strSubstring3 = appPackageName.substring(0, 100);
                    C2029al.m4645d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, strSubstring3);
                    appPackageName = strSubstring3;
                }
                c2018aaM4507a.f7227c = appPackageName;
                C2029al.m4640a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
            }
            String deviceID = buglyStrategy.getDeviceID();
            if (deviceID != null) {
                if (deviceID.length() > 100) {
                    String strSubstring4 = deviceID.substring(0, 100);
                    C2029al.m4645d("deviceId %s length is over limit %d substring to %s", deviceID, 100, strSubstring4);
                    deviceID = strSubstring4;
                }
                c2018aaM4507a.m4513a(deviceID);
                C2029al.m4640a("[param] Set device ID: %s", deviceID);
            }
            String deviceModel = buglyStrategy.getDeviceModel();
            if (deviceModel != null) {
                c2018aaM4507a.m4516b(deviceModel);
                C2029al.m4640a("[param] Set device model: %s", deviceModel);
            }
            c2018aaM4507a.f7230f = buglyStrategy.isUploadProcess();
            C2032ao.f7319b = buglyStrategy.isBuglyLogUpload();
            for (i6 = 0; i6 < f7656b.size(); i6++) {
                try {
                    if (c2101uM4992a.m5005b(f7656b.get(i6).f7654id)) {
                        f7656b.get(i6).init(contextM4670a, z7, buglyStrategy);
                    }
                } catch (Throwable th) {
                    if (!C2029al.m4641a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            C2099s.m4974a(contextM4670a, buglyStrategy);
            if (buglyStrategy != null) {
                appReportDelay = buglyStrategy.getAppReportDelay();
            } else {
                appReportDelay = 0;
            }
            final C2020ac c2020acM4570a = C2020ac.m4570a();
            c2020acM4570a.f7258c.m4634a(new Thread() {
                @Override
                public final void run() {
                    try {
                        Map<String, byte[]> mapM5029a2 = C2103w.m5011a().m5029a(C2020ac.f7254a, (InterfaceC2102v) null);
                        if (mapM5029a2 != null) {
                            byte[] bArr2 = mapM5029a2.get("device");
                            byte[] bArr3 = mapM5029a2.get("gateway");
                            if (bArr2 != null) {
                                C2018aa.m4507a(C2020ac.this.f7262h).m4521d(new String(bArr2));
                            }
                            if (bArr3 != null) {
                                C2018aa.m4507a(C2020ac.this.f7262h).m4519c(new String(bArr3));
                            }
                        }
                        C2020ac.this.f7261g = C2020ac.m4574d();
                        if (C2020ac.this.f7261g != null) {
                            if (C2033ap.m4703b(C2020ac.f7257i) || !C2033ap.m4711d(C2020ac.f7257i)) {
                                C2020ac.this.f7261g.f7085q = StrategyBean.f7069a;
                                C2020ac.this.f7261g.f7086r = StrategyBean.f7070b;
                            } else {
                                C2020ac.this.f7261g.f7085q = C2020ac.f7257i;
                                C2020ac.this.f7261g.f7086r = C2020ac.f7257i;
                            }
                        }
                    } catch (Throwable th2) {
                        if (!C2029al.m4641a(th2)) {
                            th2.printStackTrace();
                        }
                    }
                    C2020ac c2020ac = C2020ac.this;
                    c2020ac.m4576a(c2020ac.f7261g, false);
                }
            }, appReportDelay);
            C2029al.m4642b("[init] Bugly initialization finished.", new Object[0]);
            return;
        }
        while (i6 < f7656b.size()) {
            if (c2101uM4992a.m5005b(f7656b.get(i6).f7654id)) {
                f7656b.get(i6).init(contextM4670a, z7, buglyStrategy);
            }
        }
        C2099s.m4974a(contextM4670a, buglyStrategy);
        if (buglyStrategy != null) {
            appReportDelay = buglyStrategy.getAppReportDelay();
        } else {
            appReportDelay = 0;
        }
        final C2020ac c2020acM4570a2 = C2020ac.m4570a();
        c2020acM4570a2.f7258c.m4634a(new Thread() {
            @Override
            public final void run() {
                try {
                    Map<String, byte[]> mapM5029a2 = C2103w.m5011a().m5029a(C2020ac.f7254a, (InterfaceC2102v) null);
                    if (mapM5029a2 != null) {
                        byte[] bArr2 = mapM5029a2.get("device");
                        byte[] bArr3 = mapM5029a2.get("gateway");
                        if (bArr2 != null) {
                            C2018aa.m4507a(C2020ac.this.f7262h).m4521d(new String(bArr2));
                        }
                        if (bArr3 != null) {
                            C2018aa.m4507a(C2020ac.this.f7262h).m4519c(new String(bArr3));
                        }
                    }
                    C2020ac.this.f7261g = C2020ac.m4574d();
                    if (C2020ac.this.f7261g != null) {
                        if (C2033ap.m4703b(C2020ac.f7257i) || !C2033ap.m4711d(C2020ac.f7257i)) {
                            C2020ac.this.f7261g.f7085q = StrategyBean.f7069a;
                            C2020ac.this.f7261g.f7086r = StrategyBean.f7070b;
                        } else {
                            C2020ac.this.f7261g.f7085q = C2020ac.f7257i;
                            C2020ac.this.f7261g.f7086r = C2020ac.f7257i;
                        }
                    }
                } catch (Throwable th2) {
                    if (!C2029al.m4641a(th2)) {
                        th2.printStackTrace();
                    }
                }
                C2020ac c2020ac = C2020ac.this;
                c2020ac.m4576a(c2020ac.f7261g, false);
            }
        }, appReportDelay);
        C2029al.m4642b("[init] Bugly initialization finished.", new Object[0]);
        return;
        throw th;
    }

    public static synchronized void m4948a(AbstractC2092o abstractC2092o) {
        if (!f7656b.contains(abstractC2092o)) {
            f7656b.add(abstractC2092o);
        }
    }
}

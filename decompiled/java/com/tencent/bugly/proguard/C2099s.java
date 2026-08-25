package com.tencent.bugly.proguard;

import android.app.Application;
import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.List;
import p004a3.RunnableC0038c;

public class C2099s {

    public static boolean f7673a = false;

    public static C2098r f7674b = null;

    private static int f7675c = 10;

    private static long f7676d = 300000;

    private static long f7677e = 30000;

    private static long f7678f = 0;

    private static int f7679g = 0;

    private static long f7680h = 0;

    private static long f7681i = 0;

    private static long f7682j = 0;

    private static Application.ActivityLifecycleCallbacks f7683k = null;

    private static Class<?> f7684l = null;

    private static boolean f7685m = true;

    public static void m4974a(Context context, BuglyStrategy buglyStrategy) {
        long appReportDelay;
        if (f7673a) {
            return;
        }
        boolean z7 = C2018aa.m4507a(context).f7230f;
        f7685m = z7;
        f7674b = new C2098r(context, z7);
        f7673a = true;
        if (buglyStrategy != null) {
            f7684l = buglyStrategy.getUserInfoActivity();
            appReportDelay = buglyStrategy.getAppReportDelay();
        } else {
            appReportDelay = 0;
        }
        if (appReportDelay <= 0) {
            m4981c(context, buglyStrategy);
        } else {
            C2028ak.m4631a().m4634a(new RunnableC0038c(12, context, buglyStrategy, false), appReportDelay);
        }
    }

    public static int m4985g() {
        int i6 = f7679g;
        f7679g = i6 + 1;
        return i6;
    }

    public static void m4981c(Context context, BuglyStrategy buglyStrategy) {
        boolean zIsEnableUserInfo;
        boolean zRecordUserInfoOnceADay;
        if (buglyStrategy != null) {
            zRecordUserInfoOnceADay = buglyStrategy.recordUserInfoOnceADay();
            zIsEnableUserInfo = buglyStrategy.isEnableUserInfo();
        } else {
            zIsEnableUserInfo = true;
            zRecordUserInfoOnceADay = false;
        }
        if (zRecordUserInfoOnceADay) {
            C2018aa c2018aaM4507a = C2018aa.m4507a(context);
            List<UserInfoBean> listM4952a = C2098r.m4952a(c2018aaM4507a.f7228d);
            if (listM4952a != null) {
                for (int i6 = 0; i6 < listM4952a.size(); i6++) {
                    UserInfoBean userInfoBean = listM4952a.get(i6);
                    if (userInfoBean.f7060n.equals(c2018aaM4507a.f7239o) && userInfoBean.f7048b == 1) {
                        long jM4695b = C2033ap.m4695b();
                        if (jM4695b <= 0) {
                            break;
                        }
                        if (userInfoBean.f7051e >= jM4695b) {
                            if (userInfoBean.f7052f <= 0) {
                                f7674b.m4969b();
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            zIsEnableUserInfo = false;
        }
        C2018aa c2018aaM4509b = C2018aa.m4509b();
        if (c2018aaM4509b != null && C2106z.m5038a()) {
            c2018aaM4509b.m4512a(0, true);
        }
        if (zIsEnableUserInfo) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (f7683k == null) {
                        f7683k = new C2093o0();
                    }
                    application.registerActivityLifecycleCallbacks(f7683k);
                } catch (Exception e5) {
                    if (!C2029al.m4641a(e5)) {
                        e5.printStackTrace();
                    }
                }
            }
        }
        if (f7685m) {
            f7681i = System.currentTimeMillis();
            f7674b.m4967a(1, false);
            C2029al.m4640a("[session] launch app, new start", new Object[0]);
            f7674b.m4966a();
            f7674b.m4968a(21600000L);
        }
    }

    public static void m4972a(long j10) {
        if (j10 < 0) {
            j10 = C2020ac.m4570a().m4579c().f7084p;
        }
        f7678f = j10;
    }

    public static void m4975a(StrategyBean strategyBean, boolean z7) {
        C2098r c2098r = f7674b;
        if (c2098r != null && !z7) {
            c2098r.m4969b();
        }
        if (strategyBean == null) {
            return;
        }
        long j10 = strategyBean.f7084p;
        if (j10 > 0) {
            f7677e = j10;
        }
        int i6 = strategyBean.f7089u;
        if (i6 > 0) {
            f7675c = i6;
        }
        long j11 = strategyBean.f7090v;
        if (j11 > 0) {
            f7676d = j11;
        }
    }

    public static void m4971a() {
        C2098r c2098r = f7674b;
        if (c2098r != null) {
            c2098r.m4967a(2, false);
        }
    }

    public static void m4973a(Context context) {
        if (!f7673a || context == null) {
            return;
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application != null) {
            try {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f7683k;
                if (activityLifecycleCallbacks != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
            } catch (Exception e5) {
                if (!C2029al.m4641a(e5)) {
                    e5.printStackTrace();
                }
            }
        }
        f7673a = false;
    }

    public static String m4970a(String str, String str2) {
        return C2033ap.m4675a() + "  " + str + "  " + str2 + "\n";
    }
}

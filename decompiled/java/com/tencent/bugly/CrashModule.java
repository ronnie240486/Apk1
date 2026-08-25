package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.AbstractC2092o;
import com.tencent.bugly.proguard.C2018aa;
import com.tencent.bugly.proguard.C2029al;
import com.tencent.bugly.proguard.C2034aq;
import com.tencent.bugly.proguard.C2037at;
import com.tencent.bugly.proguard.C2038au;
import com.tencent.bugly.proguard.C2101u;
import com.tencent.bugly.proguard.C2106z;

public class CrashModule extends AbstractC2092o {
    public static final int MODULE_ID = 1004;

    private static int f7039c;

    private static CrashModule f7040e = new CrashModule();

    private long f7041a;

    private BuglyStrategy.C2006a f7042b;

    private boolean f7043d = false;

    private synchronized void m4469a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        try {
            String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
            if (!TextUtils.isEmpty(libBuglySOFilePath)) {
                C2018aa.m4507a(context).f7244t = libBuglySOFilePath;
                C2029al.m4640a("setted libBugly.so file path :%s", libBuglySOFilePath);
            }
            if (buglyStrategy.getCrashHandleCallback() != null) {
                this.f7042b = buglyStrategy.getCrashHandleCallback();
                C2029al.m4640a("setted CrashHanldeCallback", new Object[0]);
            }
            if (buglyStrategy.getAppReportDelay() > 0) {
                long appReportDelay = buglyStrategy.getAppReportDelay();
                this.f7041a = appReportDelay;
                C2029al.m4640a("setted delay: %d", Long.valueOf(appReportDelay));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f7040e;
        crashModule.f7654id = 1004;
        return crashModule;
    }

    @Override
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f7043d;
    }

    @Override
    public synchronized void init(Context context, boolean z7, BuglyStrategy buglyStrategy) {
        if (context != null) {
            try {
                if (!this.f7043d) {
                    C2029al.m4640a("Initializing crash module.", new Object[0]);
                    C2101u c2101uM4991a = C2101u.m4991a();
                    int i6 = f7039c + 1;
                    f7039c = i6;
                    c2101uM4991a.m5004a(i6);
                    this.f7043d = true;
                    CrashReport.setContext(context);
                    m4469a(context, buglyStrategy);
                    C2037at c2037atM4763a = C2037at.m4763a(context, z7, this.f7042b);
                    c2037atM4763a.f7387t.m4791a();
                    if (buglyStrategy != null) {
                        c2037atM4763a.f7383B = buglyStrategy.getCallBackType();
                        c2037atM4763a.f7384C = buglyStrategy.getCloseErrorCallback();
                        C2037at.f7378o = buglyStrategy.isUploadSpotCrash();
                        C2018aa.m4507a(context).f7194S = buglyStrategy.isEnableRecordAnrMainStack();
                        if (buglyStrategy.isEnableCatchAnrTrace()) {
                            c2037atM4763a.f7388u.enableCatchAnrTrace();
                        } else {
                            c2037atM4763a.f7388u.disableCatchAnrTrace();
                        }
                    } else {
                        c2037atM4763a.f7388u.enableCatchAnrTrace();
                    }
                    if (C2018aa.m4509b().f7228d.equals(C2106z.m5036a(c2037atM4763a.f7385c))) {
                        c2037atM4763a.f7388u.removeEmptyNativeRecordFiles();
                    }
                    if (buglyStrategy == null || buglyStrategy.isEnableNativeCrashMonitor()) {
                        c2037atM4763a.m4772e();
                    } else {
                        C2029al.m4640a("[crash] Closed native crash monitor!", new Object[0]);
                        c2037atM4763a.m4771d();
                    }
                    if (buglyStrategy == null || buglyStrategy.isEnableANRCrashMonitor()) {
                        c2037atM4763a.m4773f();
                    } else {
                        C2029al.m4640a("[crash] Closed ANR monitor!", new Object[0]);
                        c2037atM4763a.m4774g();
                    }
                    if (buglyStrategy != null) {
                        C2037at.f7368e = buglyStrategy.isMerged();
                    }
                    c2037atM4763a.m4766a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
                    c2037atM4763a.f7388u.checkUploadRecordCrash();
                    C2038au.m4780a(context);
                    C2034aq c2034aqM4713a = C2034aq.m4713a();
                    c2034aqM4713a.m4718a("android.net.conn.CONNECTIVITY_CHANGE");
                    c2034aqM4713a.m4717a(context);
                    C2101u c2101uM4991a2 = C2101u.m4991a();
                    int i10 = f7039c - 1;
                    f7039c = i10;
                    c2101uM4991a2.m5004a(i10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        C2037at c2037atM4762a;
        if (strategyBean == null || (c2037atM4762a = C2037at.m4762a()) == null) {
            return;
        }
        c2037atM4762a.f7387t.m4792a(strategyBean);
        c2037atM4762a.f7388u.onStrategyChanged(strategyBean);
        c2037atM4762a.f7391x.m4815b();
    }
}

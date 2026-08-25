package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

public final class C2043az {
    public static ActivityManager.ProcessErrorStateInfo m4817a(ActivityManager activityManager, long j10) {
        if (activityManager == null) {
            C2029al.m4644c("get anr state, ActivityManager is null", new Object[0]);
            return null;
        }
        C2029al.m4644c("get anr state, timeout:%d", Long.valueOf(j10));
        long j11 = j10 / 500;
        int i6 = 0;
        while (true) {
            ActivityManager.ProcessErrorStateInfo processErrorStateInfoM4819a = m4819a(activityManager.getProcessesInErrorState());
            if (processErrorStateInfoM4819a == null) {
                C2029al.m4644c("found proc state is null", new Object[0]);
            } else {
                int i10 = processErrorStateInfoM4819a.condition;
                if (i10 == 2) {
                    C2029al.m4644c("found proc state is anr! proc:%s", processErrorStateInfoM4819a.processName);
                    return processErrorStateInfoM4819a;
                }
                if (i10 == 1) {
                    C2029al.m4644c("found proc state is crashed!", new Object[0]);
                    return null;
                }
            }
            int i11 = i6 + 1;
            if (i6 >= j11) {
                return m4818a("Find process anr, but unable to get anr message.");
            }
            C2029al.m4644c("try the %s times:", Integer.valueOf(i11));
            C2033ap.m4699b(500L);
            i6 = i11;
        }
    }

    private static ActivityManager.ProcessErrorStateInfo m4819a(List<ActivityManager.ProcessErrorStateInfo> list) {
        if (list != null && !list.isEmpty()) {
            int iMyPid = Process.myPid();
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : list) {
                if (processErrorStateInfo.pid == iMyPid) {
                    if (TextUtils.isEmpty(processErrorStateInfo.longMsg)) {
                        return null;
                    }
                    C2029al.m4644c("found current proc in the error state", new Object[0]);
                    return processErrorStateInfo;
                }
            }
            C2029al.m4644c("current proc not in the error state", new Object[0]);
            return null;
        }
        C2029al.m4644c("error state info list is null", new Object[0]);
        return null;
    }

    private static ActivityManager.ProcessErrorStateInfo m4818a(String str) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = new ActivityManager.ProcessErrorStateInfo();
        processErrorStateInfo.pid = Process.myPid();
        processErrorStateInfo.processName = C2106z.m5035a(Process.myPid());
        processErrorStateInfo.shortMsg = str;
        return processErrorStateInfo;
    }
}

package com.tencent.bugly.crashreport.crash.jni;

import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C2029al;
import com.tencent.bugly.proguard.C2033ap;
import com.tencent.bugly.proguard.C2037at;
import com.tencent.bugly.proguard.C2050be;
import java.io.File;
import java.util.Arrays;
import p001a0.C0022e;

public final class RunnableC2014a implements Runnable {

    public final NativeCrashHandler f7173a;

    public RunnableC2014a(NativeCrashHandler nativeCrashHandler) {
        this.f7173a = nativeCrashHandler;
    }

    @Override
    public final void run() throws Throwable {
        NativeCrashHandler nativeCrashHandler = this.f7173a;
        if (!C2033ap.m4689a(nativeCrashHandler.f7163d, "native_record_lock")) {
            C2029al.m4640a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
            return;
        }
        if (!NativeCrashHandler.f7162n) {
            nativeCrashHandler.m4491a(999, "false");
        }
        CrashDetailBean crashDetailBeanM4823a = C2050be.m4823a(nativeCrashHandler.f7163d, NativeCrashHandler.f7159a, nativeCrashHandler.f7166g);
        if (crashDetailBeanM4823a != null) {
            C2029al.m4640a("[Native] Get crash from native record.", new Object[0]);
            if (!nativeCrashHandler.f7172m.m4759a(crashDetailBeanM4823a, true)) {
                nativeCrashHandler.f7172m.m4761b(crashDetailBeanM4823a, false);
            }
            C2050be.m4831a(false, NativeCrashHandler.f7159a);
        }
        long jM4695b = C2033ap.m4695b() - C2037at.f7373j;
        long jM4695b2 = C2033ap.m4695b() + 86400000;
        File file = new File(NativeCrashHandler.f7159a);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    Arrays.sort(fileArrListFiles, new C0022e(3));
                    long length = 0;
                    int i6 = 0;
                    int i10 = 0;
                    for (File file2 : fileArrListFiles) {
                        long jLastModified = file2.lastModified();
                        length += file2.length();
                        if (jLastModified < jM4695b || jLastModified >= jM4695b2 || length >= C2037at.f7372i) {
                            C2029al.m4640a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i6++;
                            if (file2.delete()) {
                                i10++;
                            }
                        }
                    }
                    C2029al.m4644c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i6), Integer.valueOf(i10));
                }
            } catch (Throwable th) {
                C2029al.m4641a(th);
            }
        }
        C2033ap.m4701b(nativeCrashHandler.f7163d, "native_record_lock");
    }
}

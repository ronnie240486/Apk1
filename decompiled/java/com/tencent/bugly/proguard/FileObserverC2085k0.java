package com.tencent.bugly.proguard;

import android.os.FileObserver;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import p004a3.RunnableC0038c;

public final class FileObserverC2085k0 extends FileObserver {

    public final int f7639a = 0;

    public final C2042ay f7640b;

    public FileObserverC2085k0(C2042ay c2042ay) {
        super("/data/anr/", 8);
        this.f7640b = c2042ay;
    }

    @Override
    public final void onEvent(int i6, String str) {
        C2042ay c2042ay = this.f7640b;
        switch (this.f7639a) {
            case 0:
                if (str != null) {
                    String strConcat = "/data/anr/".concat(str);
                    C2029al.m4645d("watching file %s", strConcat);
                    if (!strConcat.contains("trace")) {
                        C2029al.m4645d("not anr file %s", strConcat);
                    } else {
                        c2042ay.f7428d.m4633a(new RunnableC0038c(this, 11, strConcat));
                    }
                    break;
                }
                break;
            default:
                if (str != null) {
                    C2029al.m4645d("observe file, dir:%s fileName:%s", c2042ay.f7429e, str);
                    if (!str.startsWith("manual_bugly_trace_") || !str.endsWith(".txt")) {
                        C2029al.m4644c("not manual trace file, ignore.", new Object[0]);
                    } else if (!c2042ay.f7425a.get()) {
                        C2029al.m4644c("proc is not in anr, just ignore", new Object[0]);
                    } else if (!c2042ay.f7427c.m4515a()) {
                        C2029al.m4644c("Found background anr, resend sigquit later.", new Object[0]);
                        c2042ay.m4812a(C2030am.m4647a(str, "manual_bugly_trace_", ".txt"), c2042ay.f7429e + "/" + str);
                        C2029al.m4644c("Finish handling one anr, now resend sigquit.", new Object[0]);
                        NativeCrashHandler.getInstance().resendSigquit();
                    } else {
                        C2029al.m4644c("Found foreground anr, resend sigquit immediately.", new Object[0]);
                        NativeCrashHandler.getInstance().resendSigquit();
                        c2042ay.m4812a(C2030am.m4647a(str, "manual_bugly_trace_", ".txt"), c2042ay.f7429e + "/" + str);
                        C2029al.m4644c("Finish handling one anr.", new Object[0]);
                    }
                    break;
                }
                break;
        }
    }

    public FileObserverC2085k0(C2042ay c2042ay, String str) {
        super(str, 8);
        this.f7640b = c2042ay;
    }
}

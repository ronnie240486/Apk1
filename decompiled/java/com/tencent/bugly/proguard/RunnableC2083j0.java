package com.tencent.bugly.proguard;

import java.util.Map;

public final class RunnableC2083j0 implements Runnable {

    public final Thread f7629a;

    public final int f7630b;

    public final String f7631c;

    public final String f7632d;

    public final String f7633e;

    public final Map f7634f;

    public RunnableC2083j0(Thread thread, int i6, String str, String str2, String str3, Map map) {
        this.f7629a = thread;
        this.f7630b = i6;
        this.f7631c = str;
        this.f7632d = str2;
        this.f7633e = str3;
        this.f7634f = map;
    }

    @Override
    public final void run() {
        try {
            if (C2038au.f7402a == null) {
                C2029al.m4646e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
            } else {
                C2038au.m4782a(C2038au.f7402a, this.f7629a, this.f7630b, this.f7631c, this.f7632d, this.f7633e, this.f7634f);
            }
        } catch (Throwable th) {
            if (!C2029al.m4643b(th)) {
                th.printStackTrace();
            }
            C2029al.m4646e("[ExtraCrashManager] Crash error %s %s %s", this.f7631c, this.f7632d, this.f7633e);
        }
    }
}

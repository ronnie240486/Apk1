package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class RunnableC2051bf implements Runnable {

    final Handler f7463a;

    long f7466d;

    private final String f7467e;

    private final List<C2046ba> f7468f = new LinkedList();

    long f7464b = 5000;

    private final long f7469g = 5000;

    boolean f7465c = true;

    public RunnableC2051bf(Handler handler, String str) {
        this.f7463a = handler;
        this.f7467e = str;
    }

    private Thread m4838e() {
        return this.f7463a.getLooper().getThread();
    }

    public final boolean m4839a() {
        return !this.f7465c && SystemClock.uptimeMillis() >= this.f7466d + this.f7464b;
    }

    public final long m4840b() {
        return SystemClock.uptimeMillis() - this.f7466d;
    }

    public final List<C2046ba> m4841c() {
        ArrayList arrayList;
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f7468f) {
            try {
                arrayList = new ArrayList(this.f7468f.size());
                for (int i6 = 0; i6 < this.f7468f.size(); i6++) {
                    C2046ba c2046ba = this.f7468f.get(i6);
                    if (!c2046ba.f7444e && jCurrentTimeMillis - c2046ba.f7441b < 200000) {
                        arrayList.add(c2046ba);
                        c2046ba.f7444e = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final void m4842d() {
        StringBuilder sb = new StringBuilder(1024);
        long jNanoTime = System.nanoTime();
        try {
            StackTraceElement[] stackTrace = m4838e().getStackTrace();
            if (stackTrace.length == 0) {
                sb.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement);
                    sb.append("\n");
                }
            }
        } catch (SecurityException e5) {
            sb.append("getStackTrace() encountered:\n");
            sb.append(e5.getMessage());
            sb.append("\n");
            C2029al.m4641a(e5);
        }
        long jNanoTime2 = System.nanoTime();
        C2046ba c2046ba = new C2046ba(sb.toString(), System.currentTimeMillis());
        c2046ba.f7443d = jNanoTime2 - jNanoTime;
        String name = m4838e().getName();
        if (name == null) {
            name = "";
        }
        c2046ba.f7440a = name;
        synchronized (this.f7468f) {
            while (this.f7468f.size() >= 32) {
                try {
                    this.f7468f.remove(0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f7468f.add(c2046ba);
        }
    }

    @Override
    public final void run() {
        this.f7465c = true;
        this.f7464b = this.f7469g;
    }
}

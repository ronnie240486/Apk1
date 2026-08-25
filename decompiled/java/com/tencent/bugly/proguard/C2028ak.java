package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class C2028ak {

    private static final AtomicInteger f7311a = new AtomicInteger(1);

    private static C2028ak f7312b;

    private ScheduledExecutorService f7313c;

    public C2028ak() {
        this.f7313c = null;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactoryC2069c0(0));
        this.f7313c = scheduledExecutorServiceNewScheduledThreadPool;
        if (scheduledExecutorServiceNewScheduledThreadPool == null || scheduledExecutorServiceNewScheduledThreadPool.isShutdown()) {
            C2029al.m4645d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized C2028ak m4631a() {
        try {
            if (f7312b == null) {
                f7312b = new C2028ak();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7312b;
    }

    public final synchronized void m4635b() {
        ScheduledExecutorService scheduledExecutorService = this.f7313c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            C2029al.m4644c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f7313c.shutdownNow();
        }
    }

    public final synchronized boolean m4636c() {
        ScheduledExecutorService scheduledExecutorService = this.f7313c;
        return (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) ? false : true;
    }

    public final synchronized boolean m4634a(Runnable runnable, long j10) {
        if (!m4636c()) {
            C2029al.m4645d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (j10 <= 0) {
            j10 = 0;
        }
        C2029al.m4644c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j10), runnable.getClass().getName());
        try {
            this.f7313c.schedule(runnable, j10, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (C2094p.f7657c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized boolean m4633a(Runnable runnable) {
        if (!m4636c()) {
            C2029al.m4645d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            C2029al.m4645d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        C2029al.m4644c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f7313c.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (C2094p.f7657c) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
